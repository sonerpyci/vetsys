<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Vet-Sys</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">VET-SYS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Customer</a></li>
            <li><a href="#">Pet</a></li>
            <li><a href="#">Search</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <c:choose>
        <c:when test="${mode == 'CUSTOMER_VIEW'}">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>District</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Operations</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.district}</td>
                            <td>${customer.addres}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
    </c:choose>


</div>

</body>
</html>
