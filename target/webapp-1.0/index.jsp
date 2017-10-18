<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fmt:requestEncoding value="utf-8"/>
<fmt:setBundle basename="language.Messages" var="locale"/>
<fmt:setLocale value="${lang}" scope="session"/>


<html>
<head>
    <title>HOTEL</title>
    <style type="text/css">
        #rus{
            width: 5%;
            top: 0;
            right: 0;
        }
        #eng{
            width: 5%;
            top: 0;
            right: 5%;
        }
        #toLogin{
            width: 100%;
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body>
    <h2 align="center"><fmt:message key="index.welcomeHead" bundle="${locale}" /></h2>
    <hr/>
    <br/>
    <p><fmt:message key="index.welcome" bundle="${locale}"/></p>
    <p><fmt:message key="index.welcomeBody" bundle="${locale}"/></p>
    <hr/>
    <br/>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="request"/>
        <button type="submit">
            <fmt:message key="index.torequest" bundle="${locale}"/>
        </button>
    </form>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="language"/>
        <input type="hidden" name="lang" value="ru_RU"/>
        <button type="submit" id="rus">
            <fmt:message key="index.russian" bundle="${locale}" />
        </button>
    </form>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="language"/>
        <input type="hidden" name="lang" value="en_EN"/>
        <button type="submit" id="eng">
            <fmt:message key="index.english" bundle="${locale}"/>
        </button>
    </form>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="toLogin"/>
        <button type="submit" id="toLogin">
            <fmt:message key="index.toadmin" bundle="${locale}"/>
        </button>
    </form>
</body>
</html>
