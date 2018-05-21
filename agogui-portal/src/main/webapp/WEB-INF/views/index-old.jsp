<%-- 
Document   : index
Created on : 10/12/2016, 1:27:44 PM
Author     : nalvarez
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Agogui</title>
        <meta name="description" content="description">
        <meta name="keywords" content="keywords">
        
        <script type="text/javascript"  src="/js/libs/jquery-3.1.0.min.js"></script>
        <script type="text/javascript" src="/js/util/Util.js"></script>

        <script type="text/javascript" src="/js/libs/jquery.validate.js"></script>
        <script type="text/javascript" src="/js/libs/additional-methods.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Agogui</h1>
        <br><input type="button" value="Entrar" onclick="location.href='<%=request.getContextPath()%>/account/login';"/>
    </body>
</html>
