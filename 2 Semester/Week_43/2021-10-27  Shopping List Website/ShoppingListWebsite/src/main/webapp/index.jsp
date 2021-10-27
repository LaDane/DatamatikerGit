<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="Resources/bootstrap.min.css" rel="stylesheet">
<html>
<head>
    <title>Online Shoppinglists</title>
</head>
<body>

<br/>
<br/><br/>

${requestScope.msg}
<div class="container">
    <h1>Welcome to Online Shoppinglists</h1>
    <br>
    <div class="card">
        <div class="card-body">
            <form action="hello-servlet", method="get">

                <div class="form-group row">
                    <label for="fname" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-7">
                        <input type="text" id="fname" class="form-control" name="fname" placeholder="John">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lname" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-7">
                        <input type="text" id = "lname" class="form-control" name="lname" placeholder="Johnson">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="pass1" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input type="text" id = "pass1" class="form-control" name="pass1" placeholder="*******">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="pass2" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input type="text" id = "pass2" class="form-control" name="pass2" placeholder="*******">
                    </div>
                </div>
                <br>
                <input type="submit" class="btn btn-info" value="Submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>

