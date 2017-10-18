<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="language.Messages" var="locale"/>
<fmt:setLocale value="${sessionScope.lang}" scope="session"/>

<html>
<head>
    <title>Authentication</title>
    <style type="text/css">
        #toStart{
            /*position: fixed;*/
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body >
    <%--Please input you login and password for successful authentication!--%>
    <fmt:message key="authentication.mess" bundle="${locale}"/>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="login" />
        <p>
            <%--<label>Login:&emsp;&ensp;</label>--%>
            <label><fmt:message key="authentication.login" bundle="${locale}"/></label>
            <input type="text" name="login" id="login"/>
        </p>
        <p>
            <%--<label>Password:</label>--%>
            <label><fmt:message key="authentication.pass" bundle="${locale}"/></label>
            <input type="password" name="password" id="password"/>
        </p>
        <p>
            <%--<button type="submit">LogIn</button>--%>
            <button type="submit"><fmt:message key="authentication.dologin" bundle="${locale}"/></button>
        </p>
    </form>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="start">
        <%--<button id="toStart" type="submit">To start page</button>--%>
        <button id="toStart" type="submit"><fmt:message key="authentication.tostart" bundle="${locale}"/></button>
    </form>
</body>
</html>
