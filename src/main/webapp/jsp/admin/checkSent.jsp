<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check successfully sent</title>
</head>
<body bgcolor="#90ee90">
    <h4>Check was successfully sent.</h4>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="adminMenu">
        <input id="toMenu" type="submit" value="To admin start page"/>
    </form>
</body>
</html>
