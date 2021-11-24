<%@ page import="business.entities.CupcakeBottoms" %>
<%@ page import="business.entities.CupcakeTops" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.getServletContext().setAttribute("CupcakeBottoms", CupcakeBottoms.getCupcakeBottoms());
    request.getServletContext().setAttribute("CupcakeTops", CupcakeTops.getCupcakeTops());
%>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
<%--            <h2>Our Cool Site</h2>--%>

<%--            <div style="margin-top: 3em;margin-bottom: 3em;">--%>
<%--                Main page for this 2. semester start project used at cphbusiness.dk--%>
<%--            </div>--%>

<%--            <c:if test="${sessionScope.role == 'employee' }">--%>
<%--            <p style="font-size: larger">This is what you can do,--%>
<%--                since your are logged in as an employee</p>--%>
<%--            <p><a href="fc/employeepage">Employee Page</a>--%>
<%--                </c:if>--%>

<%--                <c:if test="${sessionScope.role == 'customer' }">--%>
<%--            <p style="font-size: larger">This is what you can do, since your--%>
<%--                are logged in as a customer</p>--%>
<%--            <p><a href="fc/customerpage">Customer Page</a>--%>
<%--                </c:if>--%>

            <form class="p-2 bg-light" action="${pageContext.request.contextPath}"  method="get">

            <h2>Welcome on board!</h2>
            <div style="margin-top: 3em;margin-bottom: 3em;">
                The best cupcakes on the island! Choose and order here:
            </div>

                <div class="form-group row mb-5">
                    <div class="col">
                        <label for="selectCupcakeBottom">Choose cupcake bottom</label>
                        <select class="form-control" name="cupcakeBottom" id="selectCupcakeBottom">
                            <c:forEach var="ccBot" items="${applicationScope.CupcakeBottoms}">
                                <option value="${ccBot.cupcakeBottomId}">${ccBot.cupcakeBottomName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col">
                        <label for="selectCupcakeTop">Choose cupcake topping</label>
                        <select class="form-control" name="cupcakeTop" id="selectCupcakeTop">
                            <c:forEach var="ccTop" items="${applicationScope.CupcakeTops}">
                                <option value="${ccTop.cupcakeTopId}">${ccTop.cupcakeTopName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col mb-3">
                        <label>Choose amount of cupcakes</label>
                        <input type="number" class="form-control" name="cupcakeAmount" id="selectCupcakeAmount" placeholder="1" value="1">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-lg btn-primary float-end">Add to basket</button>
                    </div>
                </div>

            <c:if test="${sessionScope.basketItems != null && not empty param.cupcakeBottom}">
                <c:set var="lastBasketItem" value="${sessionScope.basketItems.get(sessionScope.basketItems.size()-1)}" scope="page" />
                <p>
                    Added <strong>${lastBasketItem.amount}</strong> cupcakes to the basket,
                    with bottom type <strong>${lastBasketItem.getCupcakeBottomName()}</strong>
                    and topping type <strong>${lastBasketItem.getCupcakeTopName()}</strong>.
                    Order total: <strong>${lastBasketItem.total}</strong>
                </p>
                <div class="text-center">
                    <a class="text-dark" href="${pageContext.request.contextPath}/fc/basket">To shopping basket</a>
                </div>
            </c:if>

            </form>
        </div>

    </jsp:body>
</t:genericpage>