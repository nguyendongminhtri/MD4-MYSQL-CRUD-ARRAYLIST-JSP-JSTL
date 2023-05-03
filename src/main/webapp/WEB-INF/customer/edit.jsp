<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2023
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: blue; text-align: center" >============ Form Edit Customer ================</h1>
<a href="/customer">Back Menu</a>
<form action="" method="post">
  <c:if test='${requestScope["validate"]!=null}'>
    <span style="color: red">${requestScope["validate"]}</span>
  </c:if>
  <c:if test='${requestScope["validate"]!=null}'>
    <span style="color: green">${requestScope["success"]}</span>
  </c:if>
  <table style="text-align: center">
    <tr>
      <td>Name: </td>
      <td><input type="text" name="ten" value="${requestScope["customer"].getName()}"><br></td>
    </tr>
    <tr>
      <td>Email: </td>
      <td><input type="text" name="email"  value="${requestScope["customer"].getEmail()}"><br></td>
    </tr>
    <tr>
      <td>Address: </td>
      <td><input type="text" name="address"  value="${requestScope["customer"].getAddress()}"><br></td>
    </tr>
    <tr>
      <td></td>
      <td><button type="submit">Update</button></td>
    </tr>
  </table>
</form>
</body>
</html>
