<%-- 
    Document   : addUser
    Created on : 6-May-2018, 1:18:55 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Employee</title>
    </head>
    <body>
        <!-- Message -->
        <div class="container">
            <h1>Add New Employee</h1>
            <!-- Message -->
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
            <form action="addUser" method="post">
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

                <div class="form-group">
                    <label for="department">Department</label><br>
                    <select name="department">
                        <c:forEach var="department" items="${departments}">
                            <option value=${department.departmentID}>${department.departmentName}</option>
                        </c:forEach>
                    </select>
                </div>

                <input type="hidden" name="action" value="add">
                <button type="submit" class="btn btn-primary btn-block">Add</button>
        </div>

    </body>
</html>
