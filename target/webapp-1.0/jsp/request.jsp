<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tdl/hotel" prefix="hl"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>
<fmt:setBundle basename="language.Messages" var="locale"/>
<fmt:setLocale value="${sessionScope.lang}" scope="session"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Room Request</title>
    <style type="text/css">
        #toStart{
            /*position: fixed;*/
            bottom: 0;
            left: 0;
        }
    </style>
</head>
<body>
<%--<h4>Request form for room</h4>--%>
<h4><fmt:message key="request.mess" bundle="${locale}"/></h4>
<form action="/controller" method="get">
    <input type="hidden" name="command" value="start"/>
    <%--<button type="submit">To start page</button>--%>
    <button id="toStart" type="submit"><fmt:message key="request.tostart" bundle="${locale}"/>...</button>
</form>
<form action="/controller" method="get">
    <input type="hidden" name="command" value="sendRequest"/>
    <%--<button type="submit">Send request</button>--%>
    <button type="submit"><fmt:message key="request.send" bundle="${locale}"/></button>
    <table style="width: 50%">
        <tr>
            <%--<td>Date of arriving</td>--%>
            <td><fmt:message key="request.datearr" bundle="${locale}"/></td>
            <td><input type="date"  name="arrivingDate"/></td>
        </tr>
        <tr>
            <%--<td>Date of leaving</td>--%>
            <td><fmt:message key="request.dareleave" bundle="${locale}"/></td>
            <td><input type="date" name="leavingDate"/></td>
        </tr>
        <tr>
            <%--<td>First name</td>--%>
            <td><fmt:message key="request.name" bundle="${locale}"/></td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <%--<td>Second name</td>--%>
            <td><fmt:message key="request.sname" bundle="${locale}"/></td>
            <td><input type="text" name="secondName"/></td>
        </tr>
        <tr>
            <%--<td>Passport</td>--%>
            <td><fmt:message key="request.passport" bundle="${locale}"/></td>
            <td><input type="text" name="passport"/></td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><input type="email" name="email"/></td>
        </tr>
        <tr>
            <%--<td>Room class</td>--%>
            <td><fmt:message key="request.class" bundle="${locale}"/></td>
                <td><hl:ShowRoomClass/></td>
        </tr>
    </table>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="start"/>
        <%--<button type="submit">To start page</button>--%>
        <button id="toStart" type="submit"><fmt:message key="request.tostart" bundle="${locale}"/></button>
    </form>
</form>
</body>
</html>
