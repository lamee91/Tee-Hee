<%-- 
    Document   : cabin
    Created on : Jan 21, 2024, 11:05:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/cabin.css" />
        <link rel="stylesheet" href="css/calendar.css" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,500;1,200&family=Quicksand:wght@500&display=swap"
            rel="stylesheet"
            />

        <!-- Include FullCalendar CSS and JS -->
        <!-- Include FullCalendar CSS and JS -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.css"
            />
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.10.2/fullcalendar.min.js"></script>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"/>
        <div class="body-container">
            <div>
                <div>
                    <img
                        src="picture/CC_C3-scaled-e1695366218592.jpg"
                        alt="classic cabin"
                        />
                </div>

                <div>
                    <div class="title">
                        <h1>Classic cabin</h1>
                        <p class="price">From 49$</p>
                    </div>

                    <p class="description">1.2m long undisturbed, private cabin</p>
                </div>
            </div>

            <div>
                <div class="note">
                    <div class="box1"></div>
                    <p>Available</p>
                    <div class="box2"></div>
                    <p>Booked</p>
                    <div class="box3"></div>
                    <p>Selecting</p>
                </div>
                <div id="calendar"></div>
                <!-- Pet information -->
                <div class="pet-information">
                    <h2>About your pet</h2>
                    <!-- <i>You haven't add any pet yet!</i> <br /> -->
                    <div class="pet-list">
                        <div class="pet">
                            <img src="picture/hythui.jpg" alt="" />
                            <div>
                                <h3>Hy Thui</h3>
                                <p>18/03/2021</p>
                                <p>Female</p>
                                <p>4.5kg</p>
                            </div>
                            <input type="checkbox" name="choosePet" />
                        </div>
                    </div>
                    <button><a href="add-pet.jsp">Add more</a></button>
                </div>
                <!-- end pet information -->
                <!-- Add ons -->
                <div class="add-ons">
                    <h2>Add-ons</h2>
                    <ul>
                        <li><input type="checkbox" name="addOns" />Bath</li>
                        <li><input type="checkbox" name="addOns" />Grooming</li>
                        <li><input type="checkbox" name="addOns" />Nail</li>
                    </ul>
                </div>
                <!-- end add ons -->
                <!-- start voucher -->
                <div class="voucher">
                    <h2>Voucher</h2>
                    <p>Voucher code:</p>
                    <form action="">
                        <input type="text" name="voucher" />
                        <input type="submit" value="Apply" />
                    </form>
                    <i style="color: red">Invalid voucher code!</i>
                </div>
                <!-- end voucher -->
                <!-- review booking -->
                <div class="review-booking">
                    <h2>Review your booking</h2>
                    <table>
                        <tr>
                            <th>Service</th>
                            <th>Total</th>
                        </tr>
                        <tr>
                            <td>Classic cabin x 1</td>
                            <td>$49</td>
                        </tr>
                        <tr>
                            <td>Grooming (4.5kg)</td>
                            <td>$10</td>
                        </tr>
                    </table>
                </div>
                <!-- end review booking -->
                <!-- check out -->
                <div class="check-out">
                    <button><a href="">Proceed to Checkout</a></button>
                </div>
            </div>
        </div>
        <!-- FOOTER -->
        <jsp:include page="footer.html"/>

        <script>
            $(document).ready(function () {
                $("#calendar").fullCalendar({
                    header: {
                        left: "prev,next today",
                        center: "title",
                        right: "month,agendaWeek,agendaDay",
                    },
                    // googleCalendarApiKey: "YOUR_GOOGLE_API_KEY",
                    // events: {
                    //   googleCalendarId: "YOUR_GOOGLE_CALENDAR_ID",
                    // },
                });
            });
            var checkin;
            var checkout;
            document.addEventListener("DOMContentLoaded", function () {
                var isCheckin = true;
                var calendar = $("#calendar").fullCalendar({
                    header: {
                        left: "prev,next today",
                        center: "title",
                        right: "month,agendaWeek,agendaDay",
                    },

                    dayClick: function (date, jsEvent, view) {
                        if (isCheckin) {
                            checkin = date;
                            var checkinElement = jsEvent.target;
                            checkinElement.style.backgroundColor = "rgb(246, 236, 94)";
                        } else {
                            checkout = date;
                            selectDaysInRange(checkin, checkout);
                        }
                        isCheckin = !isCheckin;
                    },
                });
                function selectDaysInRange(startDate, endDate) {
                    var current = moment(startDate);

                    while (!current.isAfter(endDate)) {
                        var dayElement = calendar.find(
                                '.fc-day[data-date="' + current.format() + '"]'
                                );

                        if (dayElement.length > 0) {
                            var dayDOMElement = dayElement[0];
                            dayDOMElement.style.backgroundColor = "rgb(246, 236, 94)";
                        }

                        current.add(1, "days");
                    }
                }
            });
        </script>
    </body>
</html>
