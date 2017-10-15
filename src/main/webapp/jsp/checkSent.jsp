<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 15.10.2017
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check successfully sent</title>
</head>
<body>
    <h4>Check was successfully sent.</h4>
    <form action="/controller">
        <input type="hidden" name="command" value="adminMenu">
        <input id="toMenu" type="submit" value="To admin start page"/>
    </form>
</body>
</html>
