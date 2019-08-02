<%--
  Created by IntelliJ IDEA.
  User: Shiraz
  Date: 7/25/2019
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">

    <h1>List of Users</h1>
    <br>
    <div class="float-right">
        <p>
            <a href="signup" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus-sign"></span>
                Add
            </a>
            <a href="logout" class="btn btn-success"><span class="glyphicon glyphicon-send"></span>
                Sign Out</a>
        </p>
    </div>


    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Username</th>
            <th scope="col">Password</th>
            <th scope="col">Action</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><a href="edit?id=${user.id}" class="btn btn-warning"><span
                        class="glyphicon glyphicon-pencil"></span>
                    Edit
                </a>
                    <a href="delete?id=${user.id}" class="btn btn-danger"><span
                            class="glyphicon glyphicon-trash"></span>
                        Delete
                    </a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
