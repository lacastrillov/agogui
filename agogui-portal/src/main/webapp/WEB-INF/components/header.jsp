<%-- 
    Document   : header
    Created on : 13/03/2017, 09:31:40 PM
    Author     : lacastrillov
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="<%=request.getContextPath()%>/account/UserAuthentication"></script>
<script src="/js/web/Searcher.js"></script>
<script>
    var userAuthentication = new UserAuthentication();
    var searcher= new Searcher();
</script>


    <div data-collapse="medium" data-animation="default" data-duration="400" class="navigation-bar w-nav">
        <div class="w-container">
            <a href="/" class="w-nav-brand">
                <div class="site-name" style="color: #0f8790">AGOGUI - Expediente Acad&eacute;mico</div>
            </a>
            <nav role="navigation" class="navigation-menu w-nav-menu">
                <a href="/" class="navigation-link w-nav-link" style="max-width: 940px;">Inicio</a>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="userSession" property="principal" />
                    <a href="/expediente/estudiante" class="navigation-link w-nav-link w--current" style="max-width: 940px;">Expediente ${userSession.nombre} ${userSession.apellidos}</a>
                    <a onclick="userAuthentication.logout()" href="javascript:void(0);">Cerrar sesi&oacute;n</a>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <a href="/expediente/estudiante" class="navigation-link w-nav-link w--current" style="max-width: 940px;">Expediente</a>
                </sec:authorize>
                <a href="/contactenos" class="navigation-link w-nav-link" style="max-width: 940px;">Cont&aacute;ctenos</a>
            </nav>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
        <div class="w-nav-overlay" data-wf-ignore=""></div>
    </div>