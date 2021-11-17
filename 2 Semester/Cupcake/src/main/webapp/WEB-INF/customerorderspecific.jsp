<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Customer Order
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Customer Order</h2>

            <h3>User: ${sessionScope.orderEntryUsername}</h3>

            <c:if test="${sessionScope.customerOrders != null}">
                <c:set var="orderTotal" value="0" scope="page"/>

                <div class="p-2 bg-light">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Order Id</th>
                            <th>Cupcake Bottom</th>
                            <th>Cupcake Topping</th>
                            <th>Cupcake Amount</th>
                            <th>Cupcake Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="order" items="${sessionScope.customerOrders}">
                            <tr>
                                <td>${order.getOrderEntryId()}</td>
                                <td>${order.getOrderEntryCupcakeBotName()}</td>
                                <td>${order.getOrderEntryCupcakeTopName()}</td>
                                <td>${order.getOrderEntryCupcakeAmount()}</td>
                                <td>$${order.getOrderEntryTotal()}0</td>
                            </tr>
                            <c:set var="orderTotal" value="${orderTotal + order.getOrderEntryTotal()}" scope="page"/>

                        </c:forEach>
                        </tbody>
                    </table>
                    <label class="float-left">Order total: <strong>$${orderTotal}0</strong></label>

                </div>
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>