<%@ page import="FunctionLayer.Toppings" %>
<%@ page import="Util.Initializer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.inc"%>

<%!
    @Override
    public void jspInit() {
        // Fyr kode af til initialisering. F.eks. befolke datastrukturer, lister etc..
//        Toppings.initTopping();
    }
%>

<%
//    request.setAttribute("toppings", Toppings.getToppings());
    if (request.getServletContext().getAttribute("sportList") == null) {
        request.getServletContext().setAttribute("sportList", Initializer.getSportList());
    }
    if (request.getServletContext().getAttribute("infoList") == null) {
        request.getServletContext().setAttribute("infoList", Initializer.getInfoList());
    }
%>

    <div class="row">

        <div class="col-md-4"></div>

        <div class="col-md-4">

            <h1 class="text-center">BMI Beregner</h1>

            <form action="FrontController" method="post">
                <input type="hidden" name="target" value="result"/>
                <div class="form-group">
                    <label for="height">Indtast din højde i cm:</label>
                    <input type="text" class="form-control" id="height" name="height" aria-describedby="heightHelp">
                    <small id="emailHelp" class="form-text text-muted">Du skal være ærlig!</small>
                </div>
                <div class="form-group">
                    <label for="weight">Indtast din vægt i kg:</label>
                    <input type="text" class="form-control" id="weight" name="weight">
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Beregn BMI</button>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="kvinde" checked>
                    <label class="form-check-label" for="exampleRadios1">
                        Kvinde
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="exampleRadios2" value="mand" checked>
                    <label class="form-check-label" for="exampleRadios2">
                        Mand
                    </label>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlSelect1">Angiv din primære idræt:</label>
                    <select class="form-control" name="sport" id="exampleFormControlSelect1">
                        <c:forEach var="sportsItem" items="${applicationScope.sportList}">
                            <option value="${sportsItem.sports_id}">${sportsItem.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <c:forEach var="infoItem" items="${applicationScope.infoList}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="info" value="${infoItem.info_id}" id="defaultCheck${infoItem.info_id}">
                        <label class="form-check-label" for="defaultCheck${infoItem.info_id}">
                            ${infoItem.name}
                        </label>
                    </div>
                </c:forEach>

            </form>

            <h3>${requestScope.message}</h3>

<%--            <ul>--%>
<%--                <c:forEach var="topping" items="${toppings}">--%>
<%--                    <li>${topping.name} ${topping.price}</li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>

        </div>
        <div class="col-md-4"></div>
    </div> <!--  row-->

<%@include file="includes/footer.inc"%>