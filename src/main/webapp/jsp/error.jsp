<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Error</title>
    <style type="text/css">
        #toLogin{
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body bgcolor="#cd5c5c">
    <h1>ERROR HAPPENED</h1>
    <p>
        <h2>
        <jsp:expression>(request.getAttribute("errorMessage") != null) ? (String) request
        .getAttribute("errorMessage") : "unknown error"
        </jsp:expression>
        </h2>
    </p>
    <form action="/controller">
        <input type="hidden" name="command" value="toLogin">
        <input id="toLogin" type="submit" value="Return to login form"/>
    </form>
</body>
</html>
