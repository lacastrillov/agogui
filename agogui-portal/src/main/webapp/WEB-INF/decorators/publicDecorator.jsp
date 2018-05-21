<%-- 
    Document   : publicDecorator
    Created on : 13/03/2017, 09:32:30 PM
    Author     : lacastrillov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html data-wf-domain="expediente-agogui.webflow.io" data-wf-page="5b018faf59e4c847ae76ba05" data-wf-site="5b018fae59e4c8dd6376b9fd" data-wf-status="1" class="w-mod-js wf-lato-n1-active wf-lato-i1-active wf-lato-n3-active wf-lato-i3-active wf-lato-n4-active wf-lato-i4-active wf-lato-n7-active wf-lato-i7-active wf-lato-n9-active wf-lato-i9-active wf-active">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title><sitemesh:write property='title'>Agogui</sitemesh:write> - Agogui</title>
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta content="Webflow" name="generator">
        <link href="/static/expediente-agogui.css" rel="stylesheet" type="text/css">
        <script src="/static/webfont.js" type="text/javascript"></script>
        <link rel="stylesheet" href="/static/css.css">
        <script type="text/javascript">WebFont.load({google: {families: ["Lato:100,100italic,300,300italic,400,400italic,700,700italic,900,900italic"]}});</script><!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]--><script type="text/javascript">!function (o, c) {
              var n = c.documentElement, t = " w-mod-";
              n.className += t + "js", ("ontouchstart"in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
          }(window, document);</script>
        <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
        <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
        
        <!-- Placed at the end of the document so the pages load faster ============================================= -->
        <script src="${pageContext.request.scheme}://${pageContext.request.serverName}:8080/ext-4.2.1/examples/shared/include-ext.js"></script>
        <script src="/js/libs/jquery/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="/libjs/util/Util.js"></script>
        <script src="/js/util/Validation.js"></script>
        <script>
            Ext.context= "";
        </script>
        
        <sitemesh:write property='head'/>
    </head>
    <body>
        
        <jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
        
        <sitemesh:write property='body'/>
        
        <jsp:include page="/WEB-INF/components/footer.jsp"></jsp:include>
        
    </body>
</html>