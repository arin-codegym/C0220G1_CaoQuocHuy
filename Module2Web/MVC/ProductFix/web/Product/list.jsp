<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11-12-19
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="${pageContext.request.contextPath}/?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Producer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["productList"]}' var="product">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}?action=view&id=${product.getId()}">${product.getName()}</a>
            </td>
            <td>${product.getProducer()}</td>
            <td><a href="${pageContext.request.contextPath}?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>