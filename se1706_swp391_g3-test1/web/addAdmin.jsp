<%-- 
    Document   : Register
    Created on : 14 May, 2023, 9:29:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginRegister.css">
        <link rel="stylesheet" href="css/bootstrap.min_loginRegister.css">
        <link rel="stylesheet" href="css/stylereg.css">
        <link rel="stylesheet" href="css/nunito-font.css">
        <link rel="stylesheet" href="css/register.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <script>
            function showPassword() {
                var x = document.getElementById("password");
                if (x.type === "password") {
                x.type = "text";
                } else {
                x.type = "password";
                }
          }
        </script>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/register.js"></script>
        </head>
    
    <body class="form-v9">
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
            <a href="adminhome.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            
        </nav>
            <!--<form action="" >
                <div class="ms-5 ">
                <br>
                <table class="col-8">                   
                <tr><td>Full Name : </td><td><input class="form-control " type="text" required placeholder="Fullname"></td></tr>
                <tr><td>Date Of Birth : </td><td><input class="form-control " type="date"></td></tr>
                <tr><td>E-mail : </td><td><input class="form-control " type="email" required placeholder="E-mail"></td></tr>
                <tr><td>Account : </td><td><input class="form-control " type="text" required placeholder="Account"></td></tr>
                <tr><td>Password : </td><td><input class="form-control" type="password" id="password" required placeholder="Password"></td></tr>
                <tr><td>Re-Enter Password : </td><td><input class="form-control" type="password" id="password" required placeholder="Re-Enter   Password"></td></tr>
                </table>
                    </div>
                <div class="text-center">
                <input class="ms-5" type="checkbox" onclick="showPassword()"> Show Password
                <br>
                <input class="btn-primary" type="submit" value="Register">
                </div>
            </form>-->
            <!--<div class="page-content">
                <div class="form-v9-content" style="background-image: url('images/form-v9.jpg')">
                    <form class="form-detail" action="#" method="post">
                        <h2>Registration Form</h2>
                        <div class="form-row-total">
                            <div class="form-row">
                                <input type="text" name="full-name" id="full-name" class="input-text" placeholder="Your Name" required>
                            </div>
                            <div class="form-row">
                                <input type="text" name="account" id="account" class="input-text" placeholder="Account Name" required >
                            </div>
                        </div>
                        <div class="form-row-total">
                            
                            <div class="form-row-full">
                                <input type="text" name="your-email" id="your-email" class="input-text" placeholder="Your Email" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">
                            </div>
                        </div>
                        <div class="form-row-total">
                            <div class="form-row">
                                <input type="password" name="password" id="password" class="input-text" placeholder="Your Password" required>
                            </div>
                            <div class="form-row">
                                <input type="password" name="comfirm-password" id="comfirm-password" class="input-text" placeholder="Comfirm Password" required>
                            </div>
                        </div>
                        
                        <div class="form-row-last">
                            <input type="submit" name="register" class="register" value="Register">
                        </div>
                    </form>
                </div>
            </div>-->
            <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
                <div class="wrapper wrapper--w780">
                    <div class="card card-3">
                        <div class="card-heading"></div>
                        <div class="card-body">
                            <h2 class="title">Add Admin</h2>
                            <form action ="addAdmin"  method="POST">
                                <div class="input-group">
                                    <input class="input--style-3" type="text" placeholder="Name" name="name">
                                </div>
                                
                                <div class="input-group">
                                    <input class="input--style-3" type="email" placeholder="Email" name="email">
                                </div>
                                <div class="input-group">
                                    <input type="text" name="username" id="username" class="input--style-3" placeholder="Username" required >                                </div>
                                <div class="input-group">
                                    <input type="password" name="password" id="password" class="input--style-3" placeholder="Your Password" required>
                                </div>
                                
                                <div class="input-group">
                                    <input class="input--style-3" type="text" placeholder="Phone" name="phone">
                                </div>
                                
                                    
                                
                                <div class="input-group" style="flex-wrap: nowrap">
                                  Admin Course<input  type="checkbox"  name="role" value="1">        
                                </div>
                                <div class="input-group" style="flex-wrap: nowrap" >
                                  Admin Marketing<input  type="checkbox"  name="role" value="2">                                    
                                </div>
                                <div class="input-group" style="flex-wrap: nowrap" >
                                 Admin Order<input  type="checkbox"  name="role" value="3">                        
                                </div>
                                
                                <div class="p-t-10">
                                    <button class="btn btn--pill btn--green" type="submit">Submit</button>
                                </div>
                                <p style="color: red"> ${alert}</p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        
            <!-- Jquery JS-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <!-- Vendor JS-->
            <script src="vendor/select2/select2.min.js"></script>
            <script src="vendor/datepicker/moment.min.js"></script>
            <script src="vendor/datepicker/daterangepicker.js"></script>
        
            <!-- Main JS-->
            <script src="js/global.js"></script>
        
        </div>
        </body>

</html>
