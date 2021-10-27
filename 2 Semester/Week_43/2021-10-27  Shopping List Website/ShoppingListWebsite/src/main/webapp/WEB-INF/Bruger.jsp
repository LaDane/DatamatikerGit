<%--
  Created by IntelliJ IDEA.
  User: usaw
  Date: 27/10/2021
  Time: 09.08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var"contextPath" value="${pageContext.request.contextPath}"/>--%>

<link href="Resources/bootstrap.min.css" rel="stylesheet">

<html>
<head>
    <title>Brugerside</title>
</head>
<body>
<div class="container">
    <h1>Shopping list for the trip</h1>
    Logged in as user: ${sessionScope.fname}
    <div class="card">
        <div class="card-body">
            <form action="TilføjEmneServlet", method="post">

                <div class="form-group row">
                    <label for="item" class="col-sm-2 col-form-label">Item</label>
                    <div class="col-sm-7">
                        <input type="text" id="item" class="form-control" name="item" placeholder="Enter an item">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-7">
                        <input type="text" id="quantity" class="form-control" name="quantity" placeholder="Amount of given item">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<br><br>
<div class="container">
    <h2>Your current shopping list</h2>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>First name</th>
                        <th>Last name</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="itemList" items="${sessionScope.itemList}">
                        <tr>
                            <td>${itemList.item}</td>
                            <td>${itemList.quantity}</td>
                            <td>${itemList.fname}</td>
                            <td>${itemList.lname}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

Du er nu logget ind som ${sessionScope.fname}
<%--med session-id ${sessionScope.sessionId} <br><br>--%>
<h2>Her kan du tilføje emner til din huskeliste</h2> <br><br>

<form action="TilføjEmneServlet", method="post">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" value="Saft"><br>

<%--    <label for="Quantity">Quantity:</label><br>--%>
<%--    <input type="text" id="Quantity" name="Quantity"><br><br>--%>
<%--    --%>
    <input type="submit" value="Tilføj emne">
</form>

<c:forEach items="${sessionScope.itemList}" var="item">
    ${item}<br>
</c:forEach>

<h1>Alle emner der er tilføjet af brugere</h1><br>
<c:forEach items="${applicationScope.alleBrugeresEmner}" var="emne">
    ${emne}<br>
</c:forEach>

<form action="OversigtServlet" method="get">
    <input type="submit" value="Gå til oversigt">
</form>

</body>
</html>
