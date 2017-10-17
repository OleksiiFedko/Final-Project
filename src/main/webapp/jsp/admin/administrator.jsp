<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>HOTEL ADMINISTRATOR MENU</title>
    <style type="text/css">
        #toStart{
            width: 10%;
            position: fixed;
            bottom: 0;
            right: 0;
        }
    </style>
</head>
<body bgcolor="#90ee90">
    <h2 align="center">Administrator menu.</h2>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="getOpenRequests"/>
        <p>
        1. <button type="submit">Check open requests</button>
        </p>
    </form>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="logout"/>
        <button id="toStart" type="submit">LogOut</button>
    </form>
</body>
</html>
