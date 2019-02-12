<%-- 
    Document   : user
    Created on : 19-Apr-2018, 12:00:23 PM
    Author     : 636334
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>user</title>
    </head>
    <body>

        <!-- Message -->
        <div class="container">
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

            <!-- Edit User form -->
            <c:if test="${selectedUser!=null}">
                <h1>Update ${selectedUser.firstname} ${selectedUser.lastname}'s Information</h1>
                <form action="user" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" value="${selectedUser.username}" readonly>
                    </div>

                    <div class="form-group">
                        <label for="department">Department</label><br>
                        <select name="department">
                            <c:forEach var="department" items="${departments}">
                                <option value=${department.departmentID} <c:if test="${department.departmentID==selectedUser.department.departmentID}">selected</c:if>>${department.departmentName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="department">Activate Account</label>
                        <input type="checkbox" name="active" <c:if test="${selectedUser.active==true}">checked</c:if>>
                        </div>

                        <input type="hidden" name="action" value="save">
                        <button type="submit" class="btn btn-default">Save Changes</button>
                    </form>
                    <hr>
            </c:if>

            <h1>Employee List</h1> 
            <input class="form-control" id="myInput" type="text" placeholder="Search..">
            <br>
            <!-- User List table -->
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Role</th>
                        <th>Department</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                            <c:if test="${currentUser.role.roleID==1}">
                            <th>Status</th>
                            <th>Edit</th>
                            <th>Delete</th>
                            </c:if>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>
                                <c:if test="${user.role.roleID==1}">
                                    <i class="material-icons">domain</i>
                                </c:if>
                                <c:if test="${user.role.roleID!=1}">
                                    <i class="material-icons">group</i>
                                </c:if>
                            </td>
                            <td>${user.department.departmentName}</td>
                            <td>${user.firstname}</td>
                            <td>${user.lastname}</td>
                            <td>${user.email}</td>
                            <td>
                                (${fn:substring(user.phone, 0, 3)})${fn:substring(user.phone, 3, 6)}-${fn:substring(user.phone, 6, 10)}
                            </td>
                            <c:if test="${currentUser.role.roleID==1}">
                                <td>
                                    <c:if test="${user.active==true}">
                                        <i class="material-icons">lock_open</i>
                                    </c:if>
                                    <c:if test="${user.active==false}">
                                        <i class="material-icons">lock_outline</i>
                                    </c:if>
                                </td>
                                <td>
                                    <form action="user" method="post">                  
                                        <input type="hidden" name="action" value="edit">
                                        <input type="hidden" name="selectedUser" value="${user.username}">
                                        <button type="submit" class="btn btn-link"><span class="glyphicon glyphicon-pencil"></span></button>
                                    </form>
                                </td>
                                <td>
                                    <c:if test="${currentUser!=user}">
                                        <form action="user" method="post">                  
                                            <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="selectedUser" value="${user.username}">
                                            <button type="submit" class="btn btn-link"><span class="glyphicon glyphicon-trash"></span></button>
                                        </form>
                                    </c:if>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                    });
                });
            });
        </script>
    </body>
</html>
