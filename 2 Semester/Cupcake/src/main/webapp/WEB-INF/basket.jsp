<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Basket
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <h2>Shopping Basket</h2>
            <c:if test="${sessionScope.user != null}">
                <h3 class="float-right">Balance: $${sessionScope.user.balance}0</h3>
            </c:if>

            <c:set var="basketTotal" value="0" scope="page"/>

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
                    <c:forEach var="basketItem" items="${sessionScope.basketItems}">
                        <tr>
                            <td>${basketItem.cupcakeBottomName}</td>
                            <td>${basketItem.cupcakeTopName}</td>
                            <td>${basketItem.amount}</td>
                            <td>$${basketItem.total}0</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/fc/basketRemoveCommand" method="get">
                                    <button type="submit" class="btn btn-danger btn-sm"
                                        name="removeBasketElement" value="${sessionScope.basketItems.indexOf(basketItem)}">Remove</button>
                                </form>
                            </td>
                        </tr>
                        <c:set var="basketTotal" value="${basketTotal + basketItem.total}" scope="page"/>
                    </c:forEach>
                    </tbody>
                </table>

                <c:if test="${sessionScope.role == null }">
                    <div class="form-group row mb-5">
                        <div class="form-group">
                            <label class="float-left">Basket total: <strong>$${basketTotal}0</strong></label>
                            <label class="float-end">You need to be logged in to place an order</label>
                            <form action="${pageContext.request.contextPath}/fc/loginpage" method="get">
                                <button type="submit" class="btn btn-lg btn-primary float-end">Login</button>
                            </form>
                        </div>
                    </div>
                </c:if>

                <c:if test="${sessionScope.role == 'employee' || sessionScope.role == 'customer'}">
                    <div class="form-group row mb-5">
                        <div class="form-group">
                            <form action="${pageContext.request.contextPath}/fc/basketBuyCommand" method="get">
                                <label class="float-left">Basket total: <strong>$${basketTotal}0</strong></label>
                                <c:if test="${sessionScope.user.balance < basketTotal}">
                                    <button type="submit" class="btn btn-lg btn-primary float-end" disabled>Buy</button>
                                </c:if>
                                <c:if test="${sessionScope.user.balance >= basketTotal}">
                                    <button type="submit" class="btn btn-lg btn-primary float-end">Buy</button>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </c:if>

            </div>
        </div>

    </jsp:body>
</t:genericpage>