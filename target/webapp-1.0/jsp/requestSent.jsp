<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        #toStart{
            position: fixed;
            left: 50%;
        }
    </style>
</head>
<body bgcolor="#696969">
<h1>Request successfully sent.</h1><br/>
<h3>Press "To main page" button to return at main page</h3>
<form>
    <input type="hidden" name="command" value="start">
    <input id="toStart" type="submit" value="To start page"/>
</form>
</body>
</html>
