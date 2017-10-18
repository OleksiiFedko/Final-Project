<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tdl/hotel" prefix="hl"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ordered rooms</title>
</head>
<body>
<table>
    <div><thead>
    <tr>
        <td>ID.</td>
        <td>|    Room number </td>
        <td>|    Room class   </td>
        <td>|    Date of arriving  </td>
        <td>|    Date of leaving   </td>
        <td>|    First name        </td>
        <td>|    Second name       </td>
        <td>|    Passport          </td>
    </tr>
    </thead>
    </div>
    <tbody>
        <hl:ShowOrderedRoomsTag/>
    </tbody>
</table>
</body>
</html>
