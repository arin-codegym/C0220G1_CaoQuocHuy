<%--
  Created by IntelliJ IDEA.
  User: G731
  Date: 5/19/2020
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/cal">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand: </td>
                <td><label>
                    <input name="first-operand" type="text"/>
                </label></td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td>
                    <label>
                        <select name="operator">
                            <option value="+">+</option>
                            <option value="-">-</option>
                            <option value="*">X</option>
                            <option value="/">/</option>
                        </select>
                    </label>
                </td>
            </tr>
            <tr>
                <td>Second operand: </td>
                <td><label>
                    <input name="second-operand" type="text"/>
                </label></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
    </fieldset>
</form>
<h1>Result: ${res}</h1>
<h1 type="text" ${messge}></h1>



</body>
</html>