<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2023
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: blue; text-align: center" >============ Form Create Customer ================</h1>
<a href="/customer">Back Menu</a>
<form action="" method="post">
    <c:if test='${requestScope["validate"]!=null}'>
        <span style="color: green">${requestScope["validate"]}</span>
    </c:if>

    <table style="text-align: center">
        <tr>
            <td>Name: </td>
            <td><input type="text" name="ten"><br></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="text" name="email"><br></td>
        </tr>
        <tr>
            <td>Address: </td>
            <td><input type="text" name="address"><br></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
