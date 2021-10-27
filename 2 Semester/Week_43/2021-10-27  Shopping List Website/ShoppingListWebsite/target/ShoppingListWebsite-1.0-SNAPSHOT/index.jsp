<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online huskesedel</title>
</head>
<body>

<br/>

<h1>Velkommen til online huskesedler!</h1>
Her kan du oprette dig som bruger.
<br/><br/>

${requestScope.msg}

<br/><br/>
<form action="hello-servlet", method="get">

    <label for="name">Navn:</label><br>
    <input type="text" id="name" name="name" value="John"><br>

    <label for="pass1">password:</label><br>
    <input type="text" id="pass1" name="pass1"><br>

    <label for="pass2">gentag password:</label><br>
    <input type="text" id="pass2" name="pass2"><br><br>

    <input type="submit" value="opret">

</form>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>