<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com -->
<!-- Last Published: Sun May 20 2018 19:10:39 GMT+0000 (UTC) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:useBean id="webFunctions" class="com.lacv.jmagrexs.util.WebFunctions"/>
<html>
    <head>
        <title>Agogui</title>
        <meta content="Inicio" property="og:title">
    </head>
    <body>
        
        <div class="content-wrapper">
            <div class="w-container">
                <div class="w-row">
                    <div class="w-hidden-small w-hidden-tiny w-col w-col-3">
                        <div>
                            <div class="w-form">
                                <div class="body-copy w-richtext">
                                    <h1>Iniciar Sesi&oacute;n</h1>
                                    <p>
                                        Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta 
                                        ac consectetur ac, vestibulum at eros. Nulla vitae elit libero.
                                    </p>
                                </div>
                                <form id="formLogin" action="<c:url value='/account/authenticate'/>" method="post">
                                    <label for="Name">Usuario</label>
                                    <input placeholder="usuario" id="j_username" type="text" class="w-input" name="j_username" value="" maxlength="50" minlength="3" />
                                    <label for="Email">Contrase&ntilde;a</label>
                                    <input placeholder="* * * * * *" id="j_password" type="password" class="w-input" name="j_password" value="" maxlength="50" minlength="3" />
                                    <input value="Ingresar" type="button" onclick="userAuthentication.authenticate('formLogin')" class="button w-button" />
                                </form>
                                <div class="w-form-done">
                                    <div>Thank you! Your submission has been received!</div>
                                </div>
                                <div class="w-form-fail">
                                    <div>Oops! Something went wrong while submitting the form.</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="content-column w-col w-col-9">
                        <div class="post-wrapper">
                            <div class="post-content">
                                <div class="body-copy w-richtext">
                                    <h1>About me</h1>
                                    <p>The
                                        rich text element allows you to create and format headings, paragraphs,
                                        blockquotes, images, and video all in one place instead of having to 
                                        add and format them individually. Just double-click and easily create 
                                        content.
                                    </p>
                                    <h2>Something else here</h2>
                                    <p>Maecenas faucibus mollis 
                                        interdum. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor
                                        auctor. Curabitur blandit tempus porttitor. Lorem ipsum dolor sit amet,
                                        consectetur adipiscing elit. Vestibulum id ligula porta felis euismod 
                                        semper.
                                    </p>
                                    <p>Vestibulum id ligula porta felis euismod semper. Cum 
                                        sociis natoque penatibus et magnis dis parturient montes, nascetur 
                                        ridiculus mus. Donec id elit non mi porta gravida at eget metus. Donec 
                                        ullamcorper nulla non metus auctor fringilla.
                                    </p>
                                </div>
                                <a href="/" class="button w-button">Get in touch</a>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>