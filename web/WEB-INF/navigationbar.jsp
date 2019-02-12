<%-- 
    Document   : navigationbar
    Created on : 20-Apr-2018, 8:06:52 AM
    Author     : 636334
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <style>
            h1{
                text-align: center;
                color: #f4511e;
            }
            p.center
            {
                text-align:center;
                background-color: #f1f1f1;
                padding:16px;
            }
        </style>
    </head>
    <body>
        <!-- start navigation bar -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">Han Project</a>
                </div>
                <ul class="nav navbar-nav">
                    <c:if test="${currentUser!=null}">
                        <li id="dashboard"><a href="home"><span class="glyphicon glyphicon-stats"></span> Dashboard</a></li>
                            <c:if test="${currentUser.role.roleID==1}">
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Employees
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="user">Employee List</a></li>
                                    <li><a href="addUser">Add New Employee</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li id="gallery"><a href="gallery"><span class="glyphicon glyphicon-picture"></span> Gallery</a></li>
                        <li id="comment"><a href="comment"><span class="glyphicon glyphicon-comment"></span> Comment</a></li>
                            <c:if test="${currentUser.role.roleID!=1}">
                            <li id="employee"><a href="user"><span class="glyphicon glyphicon-earphone"></span> Contact</a></li>
                            </c:if>
                        </c:if>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${currentUser!=null}">
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${currentUser.username} <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Personal</li>
                                <li><a href="account"><span class="glyphicon glyphicon-cog"></span> Account Settings</a></li>
                                <li class="dropdown-header">General</li>
                                <li><a href="question"><span class="glyphicon glyphicon-question-sign"></span> Question</a></li>
                                <li class="divider"></li>
                                <li><a href="login?action=logout"><span class="glyphicon glyphicon-log-in"></span> Log Out</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${currentUser==null}">
                        <li><a href="register"><span class="glyphicon glyphicon-cog"></span> REGISTER</a></li>
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> LOGIN</a></li>

                    </c:if>
                </ul>
            </div>
        </nav>
        <!-- end navigation bar -->
    </body>
</html>
