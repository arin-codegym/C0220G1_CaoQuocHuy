<%--
  Created by IntelliJ IDEA.
  User: G731
  Date: 5/25/2020
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form:form method="post" action="/save">
    <table>
        <tr>
            <td><form:label path = "condiments">Sandwich condiment:</form:label></td>
            <td><form:checkboxes items = "${CondimentList}" path = "condiments" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>