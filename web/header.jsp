<%-- 
    Document   : header
    Created on : Jan 20, 2024, 4:49:39 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/header.css" />
    </head>
    <body>
        <header class="container">
            <div class="logo"></div>
            <div class="menu">
                <ul>
                    <li><a href="home.html">Home</a></li>
                    <li><a href="about.html">About</a></li>
                    <li class="dropdown">
                        <a href="">Cat Boarding</a>
                        <ul>
                            <li><a href="requirement.jsp">Boarding Requirements</a></li>
                            <li><a href="Guide.jsp">Boarding Guide</a></li>
                            <li><a href="boarding.jsp">Boarding Rates</a></li>
                        </ul>
                    </li>
                    <li><a href="news.html">Service</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </div>
            <div class="booking">
                <input class="bookingbtn" type="button" value="Book Now" />
            </div>
            <div class="user">
                <a href="login.jsp" class="login">Hello, ${sessionScope.username != null ? sessionScope.username : "Sign in"}</a>
                <a href="order.jsp" class="order">Order</a>
                <a href="cart.jsp" class="cart"
                   ><i class="fa-regular fa-cart-shopping"></i> Cart</a
                >
            </div>
        </header>
    </body>
</html>
