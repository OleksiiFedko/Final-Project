<%@ page import="com.hotel.model.entities.RoomsEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Room available</title>
    <style type="text/css">
        #toStart{
            width: 10%;
            /*position: fixed;*/
            bottom: 0;
            right: 0;
        }
    </style>
</head>
<body>
    <h3>Free rooms</h3>
    <table>
        <thead>
        <tr>
            <td>Room №</td>
            <td>|  Room class    </td>
            <td>|  Price for day </td>
        </tr>
        </thead>
        <tbody>
            <%List<RoomsEntity> freeRooms = (List<RoomsEntity>) request.getAttribute("freeRooms");%>
            <%for(RoomsEntity room : freeRooms) {%>
            <tr>
                <form action="/controller" method="post">
                    <td>  <%= room.getRoomNumber()%></td>
                    <td>  <%= room.getRoomClass().getRoomClass()%></td>
                    <td>  <%= room.getRoomClass().getPriceForDay()%></td>
                    <input type="hidden" name="roomNum" value="<%= room.getRoomNumber()%>"/>
                    <input type="hidden" name="requestId" value="<%= request.getParameter("requestId")%>"/>
                    <input type="hidden" name="command" value="sendCheck"/>
                    <input type="hidden" name="isSuccess" value="true"/>
                    <td><button type="submit">Reserve number and send check</button></td>
                </form>
            </tr>
            <%}%>
        </tbody>
    </table>
    <form action="/controller" method="get">
        <input type="hidden" name="command" value="logout"/>
        <button id="toStart" type="submit">LogOut</button>
    </form>
</body>
</html>
