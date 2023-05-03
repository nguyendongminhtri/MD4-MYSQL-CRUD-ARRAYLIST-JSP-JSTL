<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/3/2023
  Time: 4:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 style="color: blue">===========LIST CUSTOMERS ==================</h1>
<a href="/customer?action=create">Create Customer</a>

<table style="width: 100%;" border="1">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>ADDRESS</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items= '${requestScope["listCustomers"]}' var="ctm" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td><a href="/customer?action=detail&id=${ctm.getId()}">${ctm.getName()}</a></td>
            <td>${ctm.getEmail()}</td>
            <td>${ctm.getAddress()}</td>
            <td><a href="/customer?action=edit&id=${ctm.getId()}"><button style="background-color: blue; color: aliceblue; border-radius: 8%">Edit</button></a></td>
            <td><a href="/customer?action=delete&id=${ctm.getId()}"><button style="background-color: red; color: aliceblue; border-radius: 8%">Delete</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
