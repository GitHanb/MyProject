<%-- 
    Document   : question
    Created on : 6-May-2018, 2:04:49 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>question</title>
    </head>
    <body>
        <div class="container">
            <h1>Common Questions</h1>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">What is Han Project?</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body">
                            "Han Project" is a redesign of the Capstone Project. The whole project will be completed by Henry Han.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Why am I building it?</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <div class="panel-body">
                            The purpose of this project is to practice and learn Web elements.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">How to contact me</a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="panel-body">
                            <p><span class="glyphicon glyphicon-home"></span> Address: 2220 Victoria Crescent NW, Calgary, AB, Canada</p>
                            <p><span class="glyphicon glyphicon-earphone"></span> Tel: (587) 436-0922</p>
                            <p><span class="glyphicon glyphicon-envelope"></span> Email: <a href="mailto:zhongliu.han@edu.sait.ca?Subject=Hello%20Henry" target="_top">Zhongliu.Han@edu.sait.ca</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
