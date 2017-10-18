<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tdl/hotel" prefix="hl"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="utf-8"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Opened Requests</title>
    <style type="text/css">
        #toMenu{
            width: 20%;
            bottom: 0;
            left: 0;
        }
        #toStart{
            width: 10%;
            /*position: fixed;*/
            bottom: 0;
            right: 0;
        }
    </style>
</head>
    <body>
        <form action="/controller" method="post">
            <input type="hidden" name="command" value="logout"/>
            <button id="toStart" type="submit">LogOut</button>
        </form>
        <table>
            <thead>
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
            </thead>
            <tbody>
            <hl:ShowOpenRequestsTag/>
                <%--<c:forEach items="${openRequest.openedRequests}" var="request">--%>
                <%--<tr>--%>
                    <%--<form action="/controller" method="post">--%>
                        <%--<td>  ${request.requestId}.</td>--%>
                        <%--<td>  ${request.dateOfArriving}</td>--%>
                        <%--<td>  ${request.dateOfLeaving}</td>--%>
                        <%--<td>  ${request.firstName}</td>--%>
                        <%--<td>  ${request.secondName}</td>--%>
                        <%--<td>  ${request.roomClass}</td>--%>
                        <%--<td>  ${request.passport}</td>--%>
                        <%--<td>  ${request.email}</td>--%>
                        <%--<input type="hidden" name="requestId" value="${request.requestId}"/>--%>
                        <%--<input type="hidden" name="command" value="checkRoomExistence">--%>
                        <%--<td>  <button type="submit">Check for existing</button></td>--%>
                    <%--</form>--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
            </tbody>
        </table> <br/>
        <form action="/controller" method="post">
                <input type="hidden" name="command" value="adminMenu">
                <input id="toMenu" type="submit" value="To admin start page"/>
        </form>
    </body>
</html>
