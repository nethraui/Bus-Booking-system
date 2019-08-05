<%@page contentType="text/html; ISO-8859-1" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>--%>

<html>
<head>
    <title>
        Search results
    </title>
    <style>
        .wrapper {
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: center;
            width: 100%;
            min-height: 100%;
            padding: 20px;
        }

        #formContent {
            -webkit-border-radius: 10px 10px 10px 10px;
            border-radius: 10px 10px 10px 10px;
            background: #fff;
            padding: 30px;
            width: 90%;
            max-width: 700px;
            position: relative;
            padding: 0px;
            -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
            box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
            text-align: center;
        }
        input[type=button], input[type=submit], input[type=reset]  {
            background-color: #56baed;
            border: none;
            color: white;
            padding: 15px 80px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            text-transform: uppercase;
            font-size: 13px;
            -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
            box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
            -webkit-border-radius: 5px 5px 5px 5px;
            border-radius: 5px 5px 5px 5px;
            margin: 5px 20px 40px 20px;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -ms-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
            background-color: #39ace7;
        }

        input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
            -moz-transform: scale(0.95);
            -webkit-transform: scale(0.95);
            -o-transform: scale(0.95);
            -ms-transform: scale(0.95);
            transform: scale(0.95);
        }

        input[type=text],input[type=password] {
            background-color: #f6f6f6;
            border: none;
            color: #0d0d0d;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 5px;
            width: 85%;
            border: 2px solid #f6f6f6;
            -webkit-transition: all 0.5s ease-in-out;
            -moz-transition: all 0.5s ease-in-out;
            -ms-transition: all 0.5s ease-in-out;
            -o-transition: all 0.5s ease-in-out;
            transition: all 0.5s ease-in-out;
            -webkit-border-radius: 5px 5px 5px 5px;
            border-radius: 5px 5px 5px 5px;
        }

        input[type=text],input[type=password]:focus {
            background-color: #fff;
            border-bottom: 2px solid #5fbae9;
        }

        input[type=text],input[type=password]:placeholder {
            color: #cccccc;
        }


    </style>

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
    </style>

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-large">
    <a href="/about" class="w3-bar-item w3-button w3-mobile">About</a>
    <a href="/contact" class="w3-bar-item w3-button w3-mobile">Contact</a>

    <a href="/adminaccount" class="w3-bar-item w3-button w3-mobile" style="float: right">Account</a>

    <a href="/logout" class="w3-bar-item w3-button w3-mobile" style="float: right">LogOut</a>
</div>
</head>
<body>

<div align="center" class="wrapper">

<%--    <form method="get" action="search">--%>
<%--        <input name="keyword" type="text"/>--%>
<%--        <input type="submit" value="Searchhhh">--%>
<%--    </form>--%>

    <h2>Buses List</h2>
    <div id="formContent">
<%--        <form:form action="loginnext" modelAttribute="logintry" >--%>

<%--            Name: ${loginneww.fullName}--%>
<%--            <br>--%>
<%--            Email:--%>
<%--            <br>--%>
<%--            Gender:--%>
<%--            <br>--%>
<%--            Uername:--%>

<%--        </form:form>--%>

    <table border="1" cellpadding="5">
        <tr>
            <th>Id</th>
            <th>Bus Name</th>
            <th>Information</th>
            <th>Time</th>
            <th>Arrival</th>
            <th>Destination</th>
            <th>Date</th>
        </tr>
                <c:forEach items="${buslist}" var="businfo">
                    <tr>
                        <td>${businfo.id}</td>
                        <td>${businfo.busName}</td>
                        <td>${businfo.busInfo}</td>
                        <td>${businfo.busTime}</td>
                        <td>${businfo.arrival}</td>
                        <td>${businfo.destination}</td>
                        <td>${businfo.busDate}</td>
                        <td>
                            <a href="/edit?id=${businfo.id}" style="color: #2196F3" >Edit</a>

                            <a href="/delete/${businfo.id}" style="color: red">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
    </table>
    </div>

    <a href="/add" style="color: #2196F3">Add Bus</a>
</div>
</body>
</html>