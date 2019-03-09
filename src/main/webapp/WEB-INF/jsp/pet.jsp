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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
            <ul id="petResult" class="list-group">
            </ul>
        </div>
    </div>
</div>
<div class="col-md-9 container">
    <c:choose>
        <c:when test="${mode == 'PET_VIEW' || mode == 'CUSTOMER_PET_VIEW'}">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Born</th>
                        <th>Class</th>
                        <th>Kind</th>
                        <th>Age</th>
                        <th>Statement</th>
                        <th>Owner</th>
                        <th>Operations</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="pet" items="${pets}">
                        <tr>
                            <td>${pet.id}</td>
                            <td>${pet.name}</td>
                            <td>${pet.born}</td>
                            <td>${pet.petClass}</td>
                            <td>${pet.kind}</td>
                            <td>${pet.age}</td>
                            <td>${pet.statement}</td>
                            <td>${pet.owner}</td>
                            <td>
                                <a href="updatePet?id=${pet.id}"><div class="glyphicon glyphicon-pencil"></div></a>
                                <span style="padding-left: 20px;"></span>
                                <a href="deletePet?id=${pet.id}"><div class="glyphicon glyphicon-trash"></div></a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <a href="createPet"><div class="glyphicon glyphicon-plus"></div>Add Pet</a>
                    </tr>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:when test="${mode == 'PET_EDIT' || mode == 'PET_CREATE' || mode == 'CUSTOMER_PET_CREATE'}">
            <form class="form-horizontal" action="savePet?id=${pet.id}" method="POST">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" value="${pet.name}" name="name" id="name" required="true">
                </div>
                <div class="form-group">
                    <label for="born">Born</label>
                    <input type="text" class="form-control" value="${pet.born}" name="born" id="born" >
                </div>
                <div class="form-group">
                    <label for="class">Class</label>
                    <input type="text" class="form-control" value="${pet.petClass}" name="petClass" id="class" required="true">
                </div>
                <div class="form-group">
                    <label for="kind">Kind</label>
                    <input type="text" class="form-control" value="${pet.kind}" name="kind" id="kind" required="true">
                </div>
                <div class="form-group">
                    <label for="statement">Statement</label>
                    <input type="text" class="form-control" value="${pet.statement}" name="statement" id="statement">
                </div>
                <div class="form-group">
                    <label for="age">Age</label>
                    <input type="number" class="form-control" value="${pet.age}" name="age" id="age" required="true">
                </div>

                <div class="form-group">
                    <label for="owner">Owner</label>
                    <c:choose>
                        <c:when test="${mode == 'CUSTOMER_PET_CREATE'}">
                            <input type="number" class="form-control" value="${customerId}" name="owner" id="owner" readonly>
                        </c:when>
                        <c:otherwise>
                            <input type="number" class="form-control" value="${pet.owner}" name="owner" id="owner">
                        </c:otherwise>
                    </c:choose>
                </div>
                <input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>
    </c:choose>
</div>
<script src="petSearch.js"></script>
</body>
</html>
