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
    <h1 class="float-left">Shopping list for the trip</h1>
<%--        <label class="float-right">Logged in as user:</label>--%>
<%--        <label class="float-right">${sessionScope.fname} ${sessionScope.lname}</label>--%>
    <div class="card float-right">
        <div class="card-body">
            <table class="table">
                <tbody>
                    <tr><td>Logged in as:</td></tr>
                    <tr><td>${sessionScope.fname} ${sessionScope.lname}</td></tr>
                    <tr><td>
                        <form action="HelloServlet" method="get">
                            <button type="submit" class="btn btn-warning">Logout</button>
                        </form>
                    </td></tr>
                </tbody>
            </table>
        </div>
    </div>
<%--    Logged in as user: ${sessionScope.fname} ${sessionScope.lname}--%>
    <br><br><br>
    <div class="card float-none">
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

                <button type="submit" class="btn btn-secondary float-left">Submit</button>
            </form>
<%--            <form action="OversigtServlet" method="get">--%>
<%--                <button type="submit" class="btn btn-success float-right">Overview of all items</button>--%>
<%--            </form>--%>
        </div>
    </div>
</div>
<br>
<div class="container">
    <div class="card">
        <div class="card-body">
            <div>
                <h2 class="float-left">Your current shopping list</h2>
                <form action="OversigtServlet" method="get">
                    <button type="submit" class="btn btn-secondary float-right">Overview</button>
                </form>
            </div>
            <br><br>
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
    </div>
</div>

<%--Du er nu logget ind som ${sessionScope.fname}--%>
<%--&lt;%&ndash;med session-id ${sessionScope.sessionId} <br><br>&ndash;%&gt;--%>
<%--<h2>Her kan du tilføje emner til din huskeliste</h2> <br><br>--%>

<%--<form action="TilføjEmneServlet", method="post">--%>
<%--    <label for="emne">Emne:</label><br>--%>
<%--    <input type="text" id="emne" name="emne" value="Saft"><br>--%>

<%--&lt;%&ndash;    <label for="Quantity">Quantity:</label><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="text" id="Quantity" name="Quantity"><br><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    &ndash;%&gt;--%>
<%--    <input type="submit" value="Tilføj emne">--%>
<%--</form>--%>

<%--<c:forEach items="${sessionScope.itemList}" var="item">--%>
<%--    ${item}<br>--%>
<%--</c:forEach>--%>

<%--<h1>Alle emner der er tilføjet af brugere</h1><br>--%>
<%--<c:forEach items="${applicationScope.alleBrugeresEmner}" var="emne">--%>
<%--    ${emne}<br>--%>
<%--</c:forEach>--%>

<%--<form action="OversigtServlet" method="get">--%>
<%--    <input type="submit" value="Gå til oversigt">--%>
<%--</form>--%>

</body>
</html>
