<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Users
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
<%--            <h2>User Overview</h2>--%>

            <c:if test="${sessionScope.allUsers != null}">
                <div class="p-2 bg-light">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>User Id</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th>Balance</th>
                            <th>Orders Made</th>
                            <th> </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${sessionScope.allUsers}">
                            <tr>
                                <td>${user.getId()}</td>
                                <td>${user.getEmail()}</td>
                                <td>${user.getRole()}</td>
                                <td>$${user.getBalance()}0</td>
                                <td>${user.getAmountOfOrdersMade()}</td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/fc/userViewCommandEmployee" method="get">
                                        <button type="submit" class="btn btn-info btn-sm"
                                                name="viewUserId" value="${user.getId()}">View User</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>