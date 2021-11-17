<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Customer Orders
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
<%--            <h2>Customer Orders</h2>--%>

            <h3>User: ${sessionScope.user.email}</h3>


            <c:if test="${sessionScope.orderEntriesCombined != null}">
                <div class="p-2 bg-light">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Order Id</th>
                            <c:if test="${sessionScope.user.role == 'employee'}">
                                <th>Username</th>
                            </c:if>
                            <th>Cupcake Amount</th>
                            <th>Order Total</th>
                            <th> </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="orderEntriesCombined" items="${sessionScope.orderEntriesCombined}">
                            <tr>
                                <td>${orderEntriesCombined.getOrderId()}</td>
                                <c:if test="${sessionScope.user.role == 'employee'}">
                                    <td>${orderEntriesCombined.getUsername()}</td>
                                </c:if>
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
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>