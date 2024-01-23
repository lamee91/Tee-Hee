<%-- 
    Document   : boarding
    Created on : Jan 19, 2024, 10:11:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css/boarding-rate.css" />
        <link rel="stylesheet" href="css/header.css" />
        <link rel="stylesheet" href="css/footer.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,500;1,200&family=Quicksand:wght@500&display=swap"
            rel="stylesheet"
            />
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="header.jsp"/>
        <!-- BODY -->
        <div class="body">
            <center>
                <div class="room-category">
                    <div>
                        <h1>Classic Cabin</h1>
                        <div class="detail">
                            <img src="picture/CatGuest06.jpg" alt="Classic Cabin" />
                            <ul class="description">
                                <li>1.2m long undisturbed, private cabin</li>
                                <li>Lodges 1 cat only</li>
                                <li>24/7 air-conditioned lodging</li>
                                <li>Separate play, rest, bathroom & dining areas</li>
                                <li>Twice daily housekeeping & disinfection</li>
                                <li>Built-in perch/hideout</;>
                                <li>
                                    Free access to hotel lounge for daily playtime/interaction
                                    with caretakers
                                </li>
                                <li>Complimentary use of cat litter & bin</li>
                                <li>Food and water bowls provided</li>
                                <h2>From 49$</h2>
                            </ul>
                        </div>
                    </div>
                    <!--  -->
                    <div>
                        <h1>Classic Cabin</h1>
                        <div class="detail">
                            <img src="picture/CatGuest06.jpg" alt="Classic Cabin" />
                            <ul class="description">
                                <li>1.2m long undisturbed, private cabin</li>
                                <li>Lodges 1 cat only</li>
                                <li>24/7 air-conditioned lodging</li>
                                <li>Separate play, rest, bathroom & dining areas</li>
                                <li>Twice daily housekeeping & disinfection</li>
                                <li>Built-in perch/hideout</;>
                                <li>
                                    Free access to hotel lounge for daily playtime/interaction
                                    with caretakers
                                </li>
                                <li>Complimentary use of cat litter & bin</li>
                                <li>Food and water bowls provided</li>
                                <h2>From 49$</h2>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- end room category -->
                <!-- Add ons -->
                <div class="add-ons">
                    <div>
                        <h3>ADD - ONS</h3>
                        <h4>Customise your NekoHee Experience</h4>
                    </div>
                    <div class="detail">
                        <img src="picture/z5079006647600_6799daa354879a3665e325c5e41f8676.jpg" alt="pe hy">
                        <div>
                            <!-- chen JSP vao day -->
                            <div class="sub-detail">
                                <div class="title">
                                    <p>Extend Playtime</p>
                                    <p>15$/hr</p>
                                </div>
                                <!-- <h5>Extended Playtime.............15$</h5> -->
                                <p>Full hour of uninterrupted, free roam of our indoor play lounge and hotel. 
                                    If more than one of your cats is lodging with us, we'll let them out all at once for the same flat fee!</p>
                            </div>
                            <!--  -->
                            <div class="sub-detail">
                                <div class="title">
                                    <p>Media Updates</p>
                                    <p>5$/day</p>
                                </div>
                                <!-- <h5>Extended Playtime.............15$</h5> -->
                                <p>Receive a minimum of three photos or videos of your cat(s) to your mobile device of choice.</p>
                            </div>
                        </div>                       
                    </div>
                </div>
            </center>
        </div>
        <!-- FOOTER -->
        <jsp:include page="footer.html"/>
    </body>
</html>
