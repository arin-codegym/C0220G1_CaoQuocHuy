<%--
  Created by IntelliJ IDEA.
  User: G731
  Date: 5/18/2020
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save">
    <label>
        <input type="checkbox" name="condiment" value="lettuce">
    </label> Lettuce
        <input type="checkbox" name="condiment" value="tomato">
    </label> Tomato
    <label>
        <input type="checkbox" name="condiment" value="mustard" checked>
    </label> Mustard
    <label>
        <input type="checkbox" name="condiment" value="sprouts">
    </label> Sprouts
    <br><br>
    <input type="submit" value="Save">
</form>
<p>Danh sách đã chọn ${condiment}</p>
</body>
</html>
