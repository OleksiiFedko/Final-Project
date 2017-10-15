<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
    <style type="text/css">
        #toStart{
            width: 100%;
            position: fixed;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body bgcolor="#696969">
    Please input you login and password for successful authentication!
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="login" />
        <p>
            <label>Login:&emsp;&ensp;</label>
            <input type="text" name="login" id="login"/>
        </p>
        <p>
            <label>Password:</label>
            <input type="password" name="password" id="password"/>
        </p>
        <p>
            <button type="submit">LogIn</button>
        </p>
    </form>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="start">
        <%--<input id="toStart" type="submit" value="To start page"/>--%>
        <button id="toStart" type="submit">To start page</button>
    </form>
</body>
</html>
