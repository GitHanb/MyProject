<%-- 
    Document   : register
    Created on : 23-Apr-2018, 8:38:48 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>register</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <h1>Register</h1>
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
            <!--register form-->
            <form action="register" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" id="password1" placeholder="Enter password" name="password1">
                </div>
                <div class="form-group">
                    <label for="pwd">Confirm Password</label>
                    <input type="password" class="form-control" id="password2" placeholder="Repeat password" name="password2">
                </div>
                <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" class="form-control" id="firstname" placeholder="Enter first name" name="firstname">
                </div>
                <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" class="form-control" id="lastname" placeholder="Enter last name" name="lastname">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label> (Optional)
                    <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone" maxlength="10">
                    <span class="help-block">Maximum 10 digits without any other characters or symbols.</span>
                </div>
                <p class="center">By creating an account you agree to our <a data-target="#myModal" data-toggle="modal" class="MainNavText" id="MainNavHelp" href="#myModal">Terms & Privacy</a>.</p>

                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Terms & Privacy</h4>
                            </div>
                            <div class="modal-body">
                                <p>Some text in the modal.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
                <input type="hidden" name="action" value="register">
                <button type="submit" class="btn btn-primary btn-block">Register</button>
                <br>
                <p class="center">Already have an account? <a href="login">Sign in</a></p>
            </form>
        </div>
    </body>
</html>
