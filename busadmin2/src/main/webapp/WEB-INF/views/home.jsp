<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<body class="w3-light-grey">

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
    <a href="/about" class="w3-bar-item w3-button w3-mobile">About</a>
    <a href="/contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
    <a href="/userlogin" class="w3-bar-item w3-button w3-mobile">User</a>
    <a href="/login" class="w3-bar-item w3-button w3-mobile">Admin</a>

</div>
<!-- Header -->
<header class="w3-display-container w3-content" style="max-width:1500px;">
    <img class="w3-image" src=https://www.atlantacharterbuscompany.com/images/bus_main.png alt="The Bus" style="min-width:1000px" width="1500" height="800">

    <div class="w3-display-left w3-padding w3-col l6 m8">
        <div class="w3-container w3-red">
            <h2>Bus Reservation</h2>
        </div>
        <div class="w3-container w3-white w3-padding-16">
            <form:form action="/searchlist" modelAttribute="search">

                <div class="w3-row-padding" style="margin:0 -16px;">


                    <div class="w3-half w3-margin-bottom">
                        <label><i class=" "></i> FROM</label>
                        <select name="arrival">
                            <option value="hyderabad">hyderabad</option>
                            <option value="kolkata">kolkata</option>
                            <option value="chennai">chennai</option>
                            <option value="dehli">dehli</option>
                            <option value="chennai">chennai</option>
                            <option value="bengaluru">bengaluru</option>
                            <option value="pune">pune</option>
                        </select>
                        <br><br>
                    </div>


                    <div class="w3-half">
                        <label><i class=" "></i> TO </label>
                        <select name="destination">
                            <option value="hyderabad">hyderabad</option>
                            <option value="Kolkata">Kolkata</option>
                            <option value="chennai">chennai</option>
                            <option value="dehli">dehli</option>
                            <option value="chennai">chennai</option>
                            <option value="bengaluru">bengaluru</option>
                            <option value="pune">pune</option>
                        </select>
                        <br><br>
                    </div>

                    <div class="w3-row-padding" style="margin:0 -16px;">
<%--                        <div class="w3-half w3-margin-bottom">--%>
<%--                            <label><i class="fa fa-calendar-o"></i> ONWARD DATE</label>--%>
<%--                            <input class="w3-input w3-border" type="date" placeholder="DD MM YYYY" name="ONWARD DATE" required>--%>
<%--                        </div>--%>
                        <div class="w3-half">
                            <label><i class="fa fa-calendar-o"></i>DATE</label>
                            <input class="w3-input w3-border" type="date" placeholder="DD MM YYYY" name="busDate" required>
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:8px -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label><i class="fa fa-male"></i> Adults</label>
                            <input class="w3-input w3-border" type="number" value="1" name="Adults" min="1" max="6">
                        </div>
                        <div class="w3-half">
                            <label><i class="fa fa-child"></i> Kids</label>
                            <input class="w3-input w3-border" type="number" value="0" name="Kids" min="0" max="6">
                        </div>
                    </div>
                    <button class="w3-button w3-dark-grey" type="submit"><i class="fa fa-search w3-margin-right"></i> Search availability</button>
                </div>
            </form:form>

        </div>
    </div>
</header>

<!-- End page content -->
</div>

<!-- Footer -->
<footer class="w3-padding-32 w3-black w3-center w3-margin-top">
    <h5>Find Us On</h5>
    <div class="w3-xlarge w3-padding-16">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
</footer>



</body>
</html>