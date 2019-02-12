<%-- 
    Document   : account
    Created on : 18-Apr-2018, 8:54:32 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>account page</title>
    </head>
    <body>
        <div class="container">
            <h1>Account Settings</h1>
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

            <form action="account?action=update" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" value="${currentUser.username}" name="username" readonly="">
                </div>
                <div class="form-group">
                    <label for="pwd">Password</label>
                    <input type="password" class="form-control" id="password" value="${currentUser.password}" name="password">
                </div>

                <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" class="form-control" id="firstname" value="${currentUser.firstname}" name="firstname">
                </div>

                <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" class="form-control" id="lastname" value="${currentUser.lastname}" name="lastname">
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" value="${currentUser.email}" name="email">
                </div>

                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" value="${currentUser.phone}" name="phone" maxlength="10">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Update</button>
            </form>
        </div>
    </body>
</html>
