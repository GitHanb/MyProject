<%-- 
    Document   : Comment
    Created on : 19-Apr-2018, 11:35:39 PM
    Author     : hanzh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "navigationbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>comment</title>
        <link rel="stylesheet" type="text/css" href="css/general.css">
    </head>
    <body>
        <div class="container">
            <h1>Posted Comments</h1>

            <!-- Left-aligned media object -->
            <div class="media">
                <div class="media-left">
                    <img src="image/img_avatar1.png" class="media-object" style="width:60px">
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Anna Galban</h4><small><i>Posted on April 1, 2018</i></small>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
            </div>
            <hr>

            <!-- Right-aligned media object -->
            <div class="media">
                <div class="media-body">
                    <h4 class="media-heading">John Sanidad</h4><small><i>Posted on April 20, 2018</i></small>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
                <div class="media-right">
                    <img src="image/img_avatar1.png" class="media-object" style="width:60px">
                </div>
            </div>

            <h1>Leave a comment</h1>
            <form action="comment" method="post">
                <div class="form-group">
                    <label for="comment">Comment</label>
                    <textarea class="form-control" rows="3" id="comment"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Post</button>
            </form>
        </div>

    </body>
</html>
