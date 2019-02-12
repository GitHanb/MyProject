<%-- 
    Document   : gallery
    Created on : 19-Apr-2018, 11:16:07 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>gallery</title>
        <link rel="stylesheet" type="text/css" href="css/general.css">
    </head>
    <body>

        <div class="container">
            <h1>Gallery</h1>
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="image/lights.jpg" alt="Lights" style="width:100%;">
                    </div>

                    <div class="item">
                        <img src="image/nature.jpg" alt="Nature" style="width:100%;">
                    </div>

                    <div class="item">
                        <img src="image/fjords.jpg" alt="Fjords" style="width:100%;">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

    </body>
</html>

