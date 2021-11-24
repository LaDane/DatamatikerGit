<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Order Confirmation
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Order Confirmation</h2>

            <c:if test="${sessionScope.lastOrderId != null}">
                <h3>Order id: ${sessionScope.lastOrderId}</h3>
            </c:if>

            <div class="p-2 bg-light">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Cupcake Bottom</th>
                        <th>Cupcake Topping</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="order" items="${sessionScope.lastOrder}">
                        <tr>
                            <td>${order.getOrderEntryCupcakeBotName()}</td>
                            <td>${order.getOrderEntryCupcakeTopName()}</td>
                            <td>${order.getOrderEntryCupcakeAmount()}</td>
                            <td>${order.getOrderEntryTotal()}</td>
                        </tr>
                        <c:set var="orderTotal" value="${orderTotal + order.getOrderEntryTotal()}" scope="page"/>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="form-group row mb-5">
                    <div class="form-group">
                        <label class="float-left">Order total: <strong>$${orderTotal}0</strong></label>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:genericpage>