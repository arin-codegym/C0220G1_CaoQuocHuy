<%--
  Created by IntelliJ IDEA.
  User: G731
  Date: 5/25/2020
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Sandwich is Condiment: </td>
        <td> <% String[] condiments = (String[])request.getAttribute("condiments");
            for(String condiment: condiments) {
                out.println(condiment);
            }
        %></td>
    </tr>
</table>
</body>
</html>