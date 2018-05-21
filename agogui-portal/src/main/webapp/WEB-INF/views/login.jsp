<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com -->
<!-- Last Published: Sun May 20 2018 19:10:39 GMT+0000 (UTC) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>Iniciar Sesi&oacute;n</title>
        <meta content="Contact" property="og:title">
    </head>
    <body>
        
        <div class="content-wrapper">
            <div class="w-container">
                <div class="w-row">
                    <div class="w-hidden-small w-hidden-tiny w-col w-col-1"></div>
                    <div class="content-column w-col w-col-11">
                        <div class="post-wrapper">
                            <div class="loginDiv post-content">
                                <div class="body-copy w-richtext">
                                    <h1>Iniciar Sesi&oacute;n</h1>
                                    <p>
                                        Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta 
                                        ac consectetur ac, vestibulum at eros. Nulla vitae elit libero.
                                    </p>
                                </div>
                                <div class="form-wrapper w-form">
                                    <form id="formLogin" action="<c:url value='/account/authenticate'/>" method="post">
                                        <label for="Name">Usuario</label>
                                        <input placeholder="usuario" id="j_username" type="text" class="text-field w-input" name="j_username" value="" maxlength="50" minlength="3" />
                                        <label for="Email">Contrase&ntilde;a</label>
                                        <input placeholder="* * * * * *" id="j_password" type="password" class="text-field w-input" name="j_password" value="" maxlength="50" minlength="3" />
                                        <input value="Ingresar" type="button" onclick="userAuthentication.authenticate('formLogin')" class="button w-button" />
                                        <input value="&iquest;Olvidaste tu clave?" type="button" onclick="userAuthentication.changeForm('changePasswordDiv')" class="button w-button" />
                                    </form>
                                    <div class="success-message w-form-done">
                                        <p class="success-text">Thank you! Your submission has been received!</p>
                                    </div>
                                    <div class="w-form-fail">
                                        <p>Oops! Something went wrong while submitting the form</p>
                                    </div>
                                </div>
                            </div>
                            <div class="changePasswordDiv post-content" style="display: none">
                                <div class="body-copy w-richtext">
                                    <h1>Recuperar Contrase&ntilde;a</h1>
                                    <p>
                                        Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta 
                                        ac consectetur ac, vestibulum at eros. Nulla vitae elit libero.
                                    </p>
                                </div>
                                <div class="form-wrapper w-form">
                                    <form id="changePasswordForm" action="<%=request.getContextPath()%>/web/usuario/ajax/recuperarContrasena" method="post">
                                        <label for="Email">Email Address</label>
                                        <input id="correoElectronico" name="correoElectronico" type="text" class="text-field w-input" placeholder="Correo electr&oacute;nico" />
                                        <input value="Ingresar" type="button" onclick="userAuthentication.resetPassword();" class="button w-button" />
                                        <input value="Volver" type="button" onclick="userAuthentication.changeForm('loginDiv')" class="button w-button" />
                                    </form>
                                    <div class="success-message w-form-done">
                                        <p class="success-text">Thank you! Your submission has been received!</p>
                                    </div>
                                    <div class="w-form-fail">
                                        <p>Oops! Something went wrong while submitting the form</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>