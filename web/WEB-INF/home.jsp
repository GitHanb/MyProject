<%-- 
    Document   : homepage
    Created on : 18-Apr-2018, 12:03:13 AM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>home</title>
        <link rel="stylesheet" type="text/css" href="css/general.css">
    </head>
    <body>
        <div class="container">
            <h1>${currentTime}</h1>
            <h1>Welcome back, ${currentUser.firstname}.</h1>
            <h2>Task</h2>
            <div class="progress">
                <div class="progress-bar progress-bar-striped active" role="progressbar"
                     aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">40%
                </div>
            </div> 
        </div>
    </body>
</html>
