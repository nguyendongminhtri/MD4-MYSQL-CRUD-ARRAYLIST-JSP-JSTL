<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center; color: blue">==== Profile Customer ====</h1>
<table border="1" style="width: 100%">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>ADDRESS</th>
    </tr>
    <tr>
        <td>${requestScope["customer"].getId()}</td>
        <td>${requestScope["customer"].getName()}</td>
        <td>${requestScope["customer"].getEmail()}</td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
