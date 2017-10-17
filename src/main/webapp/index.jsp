<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOTEL</title>
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
    <h2 align="center">Welcome to hotel "Java"</h2>
    <hr/>
    <br/>
    <p>Welcome to hotel rooms request system.</p>
    <p>You can create request for rooms that you want and send it.<br/>
        To creating request press button "To request page".<br/>
        Our administrator will will consider your request.<br/>
        If such room will be available we, will send you check to you email.
    </p>

    <hr/>
    <br/>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="request">
        <input id="request" type="submit" value="To request page"/>
    </form>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="toLogin">
        <input id="toLogin" type="submit" value="To administrator login page"/>
    </form>
</body>
</html>
