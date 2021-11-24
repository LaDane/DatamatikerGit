<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         User Page
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
<%--            <h2>User Page</h2>--%>

            <div class="p-2 bg-light">
                <table class="table table-sm mb-5 col-3">
                    <tbody>
                    <tr>
                        <td>User Id</td>
                        <td><strong>${sessionScope.viewUser.getId()}</strong></td>
                        <td> </td>
                    </tr>
                    <tr>
                        <td>User Email</td>
                        <td><strong>${sessionScope.viewUser.getEmail()}</strong></td>
                        <td> </td>
                    </tr>
                    <tr>
                        <td>User Role</td>
                        <td><strong>${sessionScope.viewUser.getRole()}</strong></td>
                        <td> </td>
                    </tr>
                    <tr>
                        <td>User Orders Made</td>
                        <td><strong>${sessionScope.viewUser.getAmountOfOrdersMade()}</strong></td>
                        <td> </td>
                    </tr>
                    <tr>
                        <td>User Balance</td>
                        <c:if test="${sessionScope.user.role == 'customer'}">
                            <td><strong>$${sessionScope.viewUser.getBalance()}0</strong></td>
                            <td> </td>
                        </c:if>

                        <c:if test="${sessionScope.user.role == 'employee'}">
                            <form action="${pageContext.request.contextPath}/fc/userEditBalanceCommand" method="get">
                                <td>
                                    <input type="number" class="form-control" name="newUserBalance" id="newUserBalance" placeholder="${sessionScope.viewUser.getBalance()}" value="${sessionScope.viewUser.getBalance()}">
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-success btn-sm"
                                                name="userId" value="${sessionScope.viewUser.getId()}">Edit Balance</button>
                                </td>
                            </form>
                        </c:if>
                    </tr>
                    </tbody>
                </table>

                <h3>User Orders</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Order Id</th>
                        <th>Cupcake Amount</th>
                        <th>Order Total</th>
                        <th> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="orderEntriesCombined" items="${sessionScope.orderEntriesCombined}">
                        <tr>
                            <td>${orderEntriesCombined.getOrderId()}</td>
                            <td>${orderEntriesCombined.getOrderCupcakeAmount()}</td>
                            <td>$${orderEntriesCombined.getOrderPrice()}0</td>
                            <td>
                                <c:if test="${sessionScope.user.role == 'employee'}">
                                    <form action="${pageContext.request.contextPath}/fc/employeeViewOrderCommand" method="get">
                                        <button type="submit" class="btn btn-info btn-sm"
                                                name="viewOrderId" value="${orderEntriesCombined.getOrderId()}">View Order</button>
                                    </form>
                                </c:if>

                                <c:if test="${sessionScope.user.role == 'customer'}">
                                    <form action="${pageContext.request.contextPath}/fc/customerViewOrderCommand" method="get">
                                        <button type="submit" class="btn btn-info btn-sm"
                                                name="viewOrderId" value="${orderEntriesCombined.getOrderId()}">View Order</button>
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </jsp:body>
</t:genericpage>