<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No rooms available</title>
</head>
<body bgcolor="#90ee90">
    <h2>No rooms found with this condition!</h2>
    <form action="/controller" method="post">
        <input type="hidden" name="requestId" value="<%= request.getParameter("requestId")%>"/>
        <input type="hidden" name="isSuccess" value="false"/>
        <input type="hidden" name="<command>" value="noFreeRoom">
        <input type="submit" value="Send negative response"/>
    </form>
</body>
</html>
