<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2023
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: blue; text-align: center">============ Are you sure Delete? ================</h1>
<a href="/customer">Back Menu</a>
<c:if test='${requestScope["delete"]!=null}'>
    <span style="color: red">${requestScope["delete"]}</span>
</c:if>
<form action="" method="post">
    <table style="text-align: center">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="ten" value="${requestScope["customer"].getName()}"><br></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="${requestScope["customer"].getEmail()}"><br></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="${requestScope["customer"].getAddress()}"><br></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" style="background-color: red; color: aliceblue">Yes</button>
            </td>
        </tr>
    </table>
</form>
<a href="/customer">
    <button style="background-color: blue; color: aliceblue">No</button>
</a>
</body>
</html>
