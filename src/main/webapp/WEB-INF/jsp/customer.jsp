<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Vet-Sys</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="app.css" >
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>

<%@include file='header.jsp'%>
<div class="col-md-3">
    <div class="panel panel-primary">
    <div class="panel-heading">
        <div class="input-group col-md-12">
            <span class="input-group-btn">
                <button class="btn searchButton" type="button">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </span>
            <input type="text" id="search" class="search-query form-control" placeholder="Search" />
        </div>
    </div>
    <div class="panel-body">
        <ul id="customerResult" class="list-group">
        </ul>
    </div>
    </div>
</div>

<div class="col-md-9 container">
        <c:choose>
            <c:when test="${mode == 'CUSTOMER_VIEW'}">
                <div class="table-responsive">
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
                                    <td>${customer.address}</td>
                                    <td>${customer.phone}</td>
                                    <td>${customer.email}</td>
                                    <td>
                                        <div class="pull-right action-buttons">
                                        <a href="updateCustomer?id=${customer.id}" ><span class="glyphicon glyphicon-pencil"></span></a>

                                        <a href="deleteCustomer?id=${customer.id}" class="trash"><span class="glyphicon glyphicon-trash"></span></a>

                                        <a href="createPet?id=${customer.id}" class="plus"><span class="glyphicon glyphicon-plus"></span></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <a href="createCustomer"><div class="glyphicon glyphicon-plus"></div>Add Customer</a>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:when test="${mode == 'CUSTOMER_EDIT' || mode == 'CUSTOMER_CREATE'}">
                <form class="form-horizontal" action="saveCustomer?id=${customer.id}" method="POST">
                    <div class="form-group">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" value="${customer.firstName}" name="firstName" id="firstName" required="true">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" value="${customer.lastName}" name="lastName" id="lastName" required="true">
                    </div>
                    <div class="form-group">
                        <label for="district">District</label>
                        <input type="text" class="form-control" value="${customer.district}" name="district" id="district" required="true">
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" value="${customer.address}" name="address" id="address">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" value="${customer.phone}" name="phone" id="phone" required="true">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" value="${customer.email}" name="email" id="email" required="true">
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </c:when>
        </c:choose>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="customerSearch.js"></script>
</body>
</html>
