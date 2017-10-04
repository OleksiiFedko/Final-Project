<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EPAM HOTEL</title>
    <style type="text/css">
        #toLogin{
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body bgcolor="#696969">
    <h3 align="center">Welcome to EPAM hotel</h3>
    <form action="/controller">
        <input type="hidden" name="command" value="request">
        <input id="request" type="submit" value="To request page"/>
    </form>
    <form action="/controller">
        <input type="hidden" name="command" value="toLogin">
        <input id="toLogin" type="submit" value="To administrator login page"/>
    </form>
</body>
</html>
