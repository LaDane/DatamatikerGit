<%--
  Created by IntelliJ IDEA.
  User: usaw
  Date: 27/10/2021
  Time: 09.08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brugerside</title>
</head>
<body>

Du er nu logget ind som ${sessionScope.navn} med session-id ${sessionScope.sessionId} <br><br>
<h2>Her kan du tilføje emner til din huskeliste</h2> <br><br>

<form action="TilføjEmneServlet", method="post">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" value="Saft"><br>

    <input type="submit" value="Tilføj emne">
</form>

<c:forEach items="${sessionScope.emneListe}" var="emne">
    ${emne}<br>
</c:forEach>

<h1>Alle emner der er tilføjet af brugere</h1><br>
<c:forEach items="${applicationScope.alleBrugeresEmner}" var="emne">
    ${emne}<br>
</c:forEach>

<form action="OversigtServlet", method="get">
    <input type="submit" value="Gå til oversigt">
</form>

</body>
</html>
