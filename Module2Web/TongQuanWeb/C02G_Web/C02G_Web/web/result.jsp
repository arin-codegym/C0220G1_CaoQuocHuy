<%--
  Created by IntelliJ IDEA.
  User: pato2
  Date: 05/08/20
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>

</head>
<body>
    <h1>Tên học viên: </h1>
    <h2><c:out value="${param.tenHocVien}"></c:out></h2>

    <c:choose>
        <c:when test="${param.tenHocVien == 'Toan'}">
            <h3>Xin chào</h3>
        </c:when>
        <c:otherwise>
            <h3>Chào mừng bạn đến với CodeGym</h3>
        </c:otherwise>
    </c:choose>

<%--    for (HocVienCodeGym hocVien : danhSachHocVien)--%>
    <table>
    <c:forEach var="hocVien" items="${danhSachHocVien}">
        <tr>
            <td><c:out value="${hocVien.getHoTen()}"></c:out></td>
            <td><c:out value="${hocVien.getNgaySinh()}"></c:out></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>