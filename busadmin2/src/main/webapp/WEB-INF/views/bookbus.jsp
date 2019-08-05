<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: Arial;
            font-size: 17px;
            padding: 8px;
        }

        * {
            box-sizing: border-box;
        }

        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
        }

        .col-25 {
            -ms-flex: 25%; /* IE10 */
            flex: 25%;
        }

        .col-50 {
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
        }

        .col-75 {
            -ms-flex: 75%; /* IE10 */
            flex: 75%;
        }

        .col-25,
        .col-50,
        .col-75 {
            padding: 0 16px;
        }

        .container {
            background-color: sandybrown;
            padding: 5px 20px 15px 20px;
            border: 1px solid lightgrey;
            border-radius: 3px;
        }

        input[type=text] {
            width: 45%;
            margin-bottom: 20px;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type=number] {
            width: 45%;
            margin-bottom: 20px;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }


        label {
            margin-bottom: 10px;
            display: block;
        }

        .icon-container {
            margin-bottom: 20px;
            padding: 7px 0;
            font-size: 24px;
        }

        .btn {
            background-color: burlywood;
            color: black;
            padding: 12px;
            margin: 10px 0;
            border: none;
            width: 45%;
            border-radius: 3px;
            cursor: pointer;
            font-size: 17px;
        }

        .btn:hover {
            background-color: #45a049;
        }

        a {
            color: #2196F3;
        }

        hr {
            border: 1px solid lightgrey;
        }

        span.price {
            float: right;
            color: grey;
        }


        @media (max-width: 800px) {
            .row {
                flex-direction: column-reverse;
            }
            .col-25 {
                margin-bottom: 20px;
            }
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
    <a href="/useraccount" class="w3-bar-item w3-button w3-mobile" style="float: right">Account</a>
    <a href="/logout" class="w3-bar-item w3-button w3-mobile" style="float: right">LogOut</a>

</div>
</head>
<body>


<div class="row">
    <div class="col-75">
        <div class="container">
            <form action="/paymentsave" method="post">


                <div class="col-50">
                    <h3>Payment</h3>

                    <label for="cardholdername">Name on Card</label>
                    <input type="text" id="cardholdername" name="cardholdername" required>
                    <label for="cardnumber">Credit card number</label>
                    <input type="number" id="cardnumber" name="cardnumber" required >
                    <label for="month">Exp Month</label>
                    <input type="text" id="month" name="month"required >
                    <div class="row">
                        <div class="col-50">
                            <label for="year">Exp Year</label>
                            <input type="number" id="year" name="year" required>
                        </div>
                        <div class="col-50">
                            <label for="cvv">CVV</label>
                            <input type="number" id="cvv" name="cvv" required >
                        </div>
                    </div>
                </div>

                <input type="submit" value="Continue to checkout" class="btn">
            </form>
        </div>
    </div>

</div>
</div>
</div>

</body>
</html>