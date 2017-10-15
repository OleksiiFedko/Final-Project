<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOTEL ADMINISTRATOR MENU</title>
    <style type="text/css">
        #toStart{
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body bgcolor="#228b22">
    <h2 align="center">Administrator menu.</h2>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="getOpenRequests"/>
        <p>
        1. <button type="submit">Check open requests</button>
        </p>
    </form>
    <%--<form action="/controller" method="post">--%>
        <%--<input type="hidden" name="command" value="">--%>
        <%--2. <input type="submit" value="not supported"/>--%>
    <%--</form>--%>
    <%--<form action="/controller" method="post">--%>
        <%--<input type="hidden" name="command" value="">--%>
        <%--3. <input type="submit" value="not supported"/>--%>
    <%--</form>--%>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="start"/>
        <%--<input id="toStart" type="submit" value="LogOut"/>--%>
        <button id="toStart" type="submit">LogOut</button>
    </form>
</body>
</html>
