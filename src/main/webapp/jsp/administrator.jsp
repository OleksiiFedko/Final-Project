<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EPAM HOTEL ADMINISTRATOR MENU</title>
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
    <form action="/controller">
        <input type="hidden" name="command" value="getOpenRequests"/>
        1. <input type="submit" value="Check open requests"/>
    </form>
    <form action="/controller">
        <input type="hidden" name="command" value="">
        2. <input type="submit" value="not supported"/>
    </form>
    <form action="/controller">
        <input type="hidden" name="command" value="">
        3. <input type="submit" value="not supported"/>
    </form>
    <form action="/controller">
        <input type="hidden" name="command" value="start"/>
        <input id="toStart" type="submit" value="LogOut"/>
    </form>
</body>
</html>
