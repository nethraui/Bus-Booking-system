<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
</style>
<div class="w3-bar w3-white w3-large">
    <a href="/list" class="w3-bar-item w3-button w3-mobile">Home</a>
    <a href="/about" class="w3-bar-item w3-button w3-mobile">About</a>
    <a href="/contact" class="w3-bar-item w3-button w3-mobile">Contact</a>
    <a href="/adminaccount" class="w3-bar-item w3-button w3-mobile activeTableTab" style="float: right">Account</a>
    <a href="/logout" class="w3-bar-item w3-button w3-mobile" style="float: right">LogOut</a>
</div>
<!------------- MAIN PAGE CONTENT AREA --------->
<div class="site-panel"style="margin-top:110px">
    <div class="container">
        <div class="row">
            <form:form action="loginnext"  modelAttribute="logintry">
                <div class="col-md-9 ">
                    <div class= "content-box well">
                        <legend>My Profile </legend>
                        <div class="row">
                            <div class="table-responsive">
                                Name: ${name}
                                <br>
                                Email:
                                <br>
                                Gender:
                                <br>
                                Uername:
                            </div>
                        </div>

                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>