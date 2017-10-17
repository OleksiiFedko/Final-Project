<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tdl/RoomClassBoxTag" prefix="rcb"%>

<%--<jsp:useBean id="roomClass" class="com.hotel.domain.beans.RoomClassBean" scope="session"/>--%>

<html>
<head>
    <title>Room Request</title>
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
    <h4>Request form for room</h4>
    <form action="/controller" method="post">
        <input type="hidden" name="command" value="sendRequest"/>
        <table style="width: 50%">
            <tr>
                <td>Date of arriving</td>
                <td><input type="date"  name="arrivingDate"/></td>
            </tr>
            <tr>
                <td>Date of leaving</td>
                <td><input type="date" name="leavingDate"/></td>
            </tr>
            <tr>
                <td>First name</td>
                <td><input type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td>Second name</td>
                <td><input type="text" name="secondName"/></td>
            </tr>
            <tr>
                <td>Passport</td>
                <td><input type="text" name="passport"/></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="email" name="email"/></td>
            </tr>
            <tr>
                <td>Room class</td>
                <rcb:ShowRoomClass/>
            <%--<td>--%>
            <%--<select name="roomClass">--%>
            <%--<option disabled>Choose room class</option>--%>
            <%--<c:forEach items="${roomClass.roomClassList}" var="roomClassList">--%>
            <%--<option>${roomClassList.roomClass}</option>--%>
            <%--</c:forEach>--%>
            <%--</select>--%>
            <%--</td>--%>
            </tr>

        </table>
        </br>
        <button type="submit">Send request</button>
    </form>
    <form action="/controller">
        <input type="hidden" name="command" value="start">
        <button id="toStart" type="submit">To start page</button>
    </form>
</body>
</html>
