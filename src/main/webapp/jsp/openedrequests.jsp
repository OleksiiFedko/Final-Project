<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Opened Requests</title>
    <style type="text/css">
        #toMenu{
            width: 50%;
            left: 0;
        }
    </style>
</head>
<body bgcolor="#228b22">
        <jsp:useBean id="openRequest" class="com.epamhotel.domain.beans.OpenRequestBean"/>
        <table>
            <tr>
                <td>ID.</td>
                <td>|    Date of arriving  </td>
                <td>|    Date of leaving   </td>
                <td>|    First name        </td>
                <td>|    Second name       </td>
                <td>|    Room class        </td>
                <td>|    Passport          </td>
                <td>|    Email             </td>
            </tr>
            <c:forEach items="${openRequest.openedRequests}" var="request">
            <tr>
                <form action="/controller" method="post">
                    <td>  ${request.requestId}.</td>
                    <td>  ${request.dateOfArriving}</td>
                    <td>  ${request.dateOfLeaving}</td>
                    <td>  ${request.firstName}</td>
                    <td>  ${request.secondName}</td>
                    <td>  ${request.roomClass}</td>
                    <td>  ${request.passport}</td>
                    <td>  ${request.email}</td>
                    <input type="hidden" name="command" value="checkRoomExistence">
                    <td>  <input type="submit" value="check for existing"></td>
                    <input type="hidden" name="currentRequest" value="${request}">
                </form>
            </tr>
            </c:forEach>
            <form action="/controller" method="post">
                <tr>
                     <input type="hidden" name="command" value="adminMenu">
                     <input id="toMenu" type="submit" value="To start page"/>
                </tr>
            </form>
        </table>
</body>
</html>
