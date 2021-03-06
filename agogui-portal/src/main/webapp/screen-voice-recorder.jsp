<%-- 
    Document   : screen-voice-recorder
    Created on : 5/05/2020, 09:51:59 AM
    Author     : e11001a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Screen Voice Recorder</title>
        <style>
            body { font-family: "Benton Sans", "Helvetica Neue", helvetica, arial, sans-serif; margin: 2em; }
            h1 { font-style: italic; color: #373fff; }
            video { width: 640px; height: 480px; }
            button { margin: 1em; padding: 1em; }
        </style>
        <script>

            window.onload = () => {
                const warningEl = document.getElementById('warning');
                const videoElement = document.getElementById('videoElement');
                const captureBtn = document.getElementById('captureBtn');
                const startBtn = document.getElementById('startBtn');
                const stopBtn = document.getElementById('stopBtn');
                const download = document.getElementById('download');
                const audioToggle = document.getElementById('audioToggle');
                const micAudioToggle = document.getElementById('micAudioToggle');

                if ('getDisplayMedia' in navigator.mediaDevices)
                    warningEl.style.display = 'none';

                let blobs;
                let blob;
                let rec;
                let stream;
                let voiceStream;
                let desktopStream;

                const mergeAudioStreams = (desktopStream, voiceStream) => {
                    const context = new AudioContext();
                    const destination = context.createMediaStreamDestination();
                    let hasDesktop = false;
                    let hasVoice = false;
                    if (desktopStream && desktopStream.getAudioTracks().length > 0) {
                        // If you don't want to share Audio from the desktop it should still work with just the voice.
                        const source1 = context.createMediaStreamSource(desktopStream);
                        const desktopGain = context.createGain();
                        desktopGain.gain.value = 0.7;
                        source1.connect(desktopGain).connect(destination);
                        hasDesktop = true;
                    }

                    if (voiceStream && voiceStream.getAudioTracks().length > 0) {
                        const source2 = context.createMediaStreamSource(voiceStream);
                        const voiceGain = context.createGain();
                        voiceGain.gain.value = 0.7;
                        source2.connect(voiceGain).connect(destination);
                        hasVoice = true;
                    }

                    return (hasDesktop || hasVoice) ? destination.stream.getAudioTracks() : [];
                };

                captureBtn.onclick = async () => {
                    download.style.display = 'none';
                    const audio = audioToggle.checked || false;
                    const mic = micAudioToggle.checked || false;

                    desktopStream = await navigator.mediaDevices.getDisplayMedia({video: true, audio: audio});

                    if (mic === true) {
                        voiceStream = await navigator.mediaDevices.getUserMedia({video: false, audio: mic});
                    }

                    const tracks = [
                        ...desktopStream.getVideoTracks(),
                        ...mergeAudioStreams(desktopStream, voiceStream)
                    ];

                    console.log('Tracks to add to stream', tracks);
                    stream = new MediaStream(tracks);
                    console.log('Stream', stream)
                    videoElement.srcObject = stream;
                    videoElement.muted = true;

                    blobs = [];

                    rec = new MediaRecorder(stream, {mimeType: 'video/webm; codecs=vp8,opus'});
                    rec.ondataavailable = (e) => blobs.push(e.data);
                    rec.onstop = async () => {

                        //blobs.push(MediaRecorder.requestData());
                        blob = new Blob(blobs, {type: 'video/webm'});
                        let url = window.URL.createObjectURL(blob);
                        download.href = url;
                        download.download = 'test.webm';
                        download.style.display = 'block';
                    };
                    startBtn.disabled = false;
                    captureBtn.disabled = true;
                    audioToggle.disabled = true;
                    micAudioToggle.disabled = true;
                };

                startBtn.onclick = () => {
                    startBtn.disabled = true;
                    stopBtn.disabled = false;
                    rec.start();
                };

                stopBtn.onclick = () => {
                    captureBtn.disabled = false;
                    audioToggle.disabled = false;
                    micAudioToggle.disabled = false;
                    startBtn.disabled = true;
                    stopBtn.disabled = true;

                    rec.stop();

                    stream.getTracks().forEach(s => s.stop());
                    videoElement.srcObject = null;
                    stream = null;
                };
            };
        </script>
    </head>
    <body>
        <h1>Screen Voice Recorder</h1>
        <p id="warning">
            Enable chrome://flags/#enable-experimental-web-platform-features
        </p>
        <video id="videoElement" autoplay muted></video>
        <br />
        <button id="captureBtn">Capture</button>
        <button id="startBtn" disabled>Start Recording</button>
        <button id="stopBtn" disabled>Stop Capture</button>
        <br>
        <input type="checkbox" id="audioToggle" />
        <label for="audioToggle">Capture Audio from Desktop</label>
        <input type="checkbox" id="micAudioToggle" />
        <label for="micAudioToggle">Capture Audio from Microphone</label>
        <a id="download" href="#" style="display: none;">Download</a>
    </body>
</html>
