<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form action="/controller">
        <input type="hidden" name="command" value="toLogin">
        <input id="toLogin" type="submit" value="Return to login form"/>
    </form>
</body>
</html>
