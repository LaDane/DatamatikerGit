<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><jsp:invoke fragment="header"/></title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" rel="stylesheet">
    <meta name="theme-color" content="#7952b3">
</head>
<body>
    <!--
        This header is inspired by this bootstrap
        example: https://getbootstrap.com/docs/5.0/examples/pricing/
    -->
<div>
    <img src="${pageContext.request.contextPath}/img/banner.png" class="img-fluid px-3 my-2 rounded"/>
</div>

<header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 bg-white border-bottom shadow-sm">
    <div class="h5 my-0 me-md-auto fw-normal">
<%--        <p>Demo Project for DAT 2. semester</p>--%>
        <p style="font-size: larger">
            <jsp:invoke fragment="header"/>
        </p>
    </div>
    <nav class="my-2 my-md-0 me-md-3">
        <c:if test="${addHomeLink == null }">
            <a class="p-2 text-dark" href="<%=request.getContextPath()%>">Home</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'customer'}">
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/customerOrdersCommand">Orders</a>
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/userViewCommandCustomer">Profile</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'employee'}">
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/employeeOrdersCommand">Orders</a>
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/usersCommand">Users</a>
            <a class="p-2 text-dark" href="${pageContext.request.contextPath}/fc/userViewCommandEmployee">Profile</a>
        </c:if>

    </nav>

    <div>

        <c:if test="${sessionScope.user != null }">
            ${sessionScope.user.email}
            $${sessionScope.user.balance}0
        </c:if>

<%--        <form action="${pageContext.request.contextPath}/fc/basket" method="get">--%>
<%--            <button type="submit" class="btn btn-sm btn-outline-secondary">--%>
<%--                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-basket" viewBox="0 0 16 16">--%>
<%--                    <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1v4.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 13.5V9a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h1.217L5.07 1.243a.5.5 0 0 1 .686-.172zM2 9v4.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9H2zM1 7v1h14V7H1zm3 3a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 4 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 6 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 8 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5z"></path>--%>
<%--                </svg>--%>
<%--            </button>--%>
<%--        </form>--%>

        <a type="button" class="btn btn-sm  btn-outline-secondary"
           href="${pageContext.request.contextPath}/fc/basket">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-basket" viewBox="0 0 16 16">
                <path d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1v4.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 13.5V9a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h1.217L5.07 1.243a.5.5 0 0 1 .686-.172zM2 9v4.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9H2zM1 7v1h14V7H1zm3 3a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 4 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 6 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 8 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5z"></path>
            </svg>
        </a>

        <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
        <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
        <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>

        <c:if test="${isNotLoginPage && isNotRegisterPage}">
            <c:if test="${sessionScope.user != null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
            </c:if>
            <c:if test="${sessionScope.user == null }">
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                <a type="button" class="btn btn-sm  btn-outline-secondary"
                   href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
            </c:if>
    </div>
    </c:if>
</header>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>