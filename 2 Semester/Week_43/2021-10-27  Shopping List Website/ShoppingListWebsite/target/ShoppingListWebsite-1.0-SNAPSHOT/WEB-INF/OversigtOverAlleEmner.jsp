<%--
  Created by IntelliJ IDEA.
  User: usaw
  Date: 27/10/2021
  Time: 10.37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OversigtOverAlleEmner</title>
</head>
<body>

Her kan du få oversigten over alle emner.<br><br>
<c:forEach items="${applicationScope.alleBrugeresEmner}" var="emne">
    ${emne}<br>
</c:forEach>

</body>
</html>
