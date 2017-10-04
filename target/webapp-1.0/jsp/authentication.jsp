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
        <table>
            <input type="hidden" name="command" value="login" />
            <tr>
                <td>Login: </td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password"/></td>
            </tr>
        </table>
            <input type="submit" value="Sign in"/>
    </form>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="adminmenu">
        <input id="toStart" type="submit" value="To start page"/>
    </form>
</body>
</html>
