<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/general.css">
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <!--Message-->
            <c:if test="${successMessage!=null}">
                <div class="alert alert-success alert-dismissible fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Success!</strong> ${successMessage}
                </div>
            </c:if>
            <c:if test="${warningMessage!=null}">
                <div class="alert alert-warning alert-dismissible fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Warning!</strong> ${warningMessage}
                </div>
            </c:if>
            <c:if test="${dangerMessage!=null}">
                <div class="alert alert-danger alert-dismissible fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Danger!</strong> ${dangerMessage}
                </div>
            </c:if>
            <!--login form-->
            <form action="login" method="post">
                <div class="form-group">
                    <i class="glyphicon glyphicon-user"></i> <label for="username">Username</label>                  
                    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
                </div>
                <div class="form-group">
                    <i class="glyphicon glyphicon-lock"></i> <label for="pwd">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                </div>
                <!--                <div class="checkbox">
                                    <label><input type="checkbox" onclick="myFunction()">Show Password</label>
                                </div>-->
                <button type="submit" class="btn btn-primary btn-block">Login</button>
                <br>
                <p class="center">Need an account? <a href="register">Sign up</a></p>
            </form>
        </div>
        <script>
            function myFunction()
            {
                var x = document.getElementById("password");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
    </body>
</html>

