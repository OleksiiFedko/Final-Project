<%@ page import="com.hotel.model.entities.RoomsEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Room available</title>
</head>
<body bgcolor="#228b22">
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
                <form action="/controller">
                    <td>  <%= room.getRoomNumber()%></td>
                    <td>  <%= room.getRoomClass().getRoomClass()%></td>
                    <td>  <%= room.getRoomClass().getPriceForDay()%></td>
                    <input type="hidden" name="" value=""/>
                    <input type="hidden" name="" value=""/>
                    <td><button type="submit">Reserve number and send check</button></td>
                </form>
            </tr>
            <%}%>
        </tbody>
    </table>
</body>
</html>