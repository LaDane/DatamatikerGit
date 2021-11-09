<%@ page import="FunctionLayer.Toppings" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.inc"%>

<%!
    @Override
    public void jspInit() {
        // Fyr kode af til initialisering. F.eks. befolke datastrukturer, lister etc..
        Toppings.initTopping();
    }
%>

<%
    request.setAttribute("toppings", Toppings.getToppings());
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
                        <option value="1">Jogging</option>
                        <option value="2">Fodbold</option>
                        <option value="3">Håndbold</option>
                        <option value="4">Gymnastik</option>
                        <option value="5">Yoga</option>
                        <option value="6">Andet</option>
                    </select>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="info" value="1" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        Jeg går op i sund kost
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="info" value="2" id="defaultCheck2">
                    <label class="form-check-label" for="defaultCheck2">
                        Jeg har et sommerhus
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="info" value="3" id="defaultCheck3">
                    <label class="form-check-label" for="defaultCheck3">
                        Jeg har et kæledyr
                    </label>
                </div>

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