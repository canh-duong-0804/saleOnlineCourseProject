<%-- 
    Document   : Register
    Created on : 14 May, 2023, 9:29:47 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList" %>
<%@page  import="Model.Course" %>
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
            <a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto p-4 p-lg-0">
                    <a href="homePage" class="nav-item nav-link active">Home</a>
                    <a href="about.html" class="nav-item nav-link">About</a>
                    <a href="displayCourse" class="nav-item nav-link">Courses</a>
                    <a href="learningPath" class="nav-item nav-link">Learning path</a> 
                    <a href="contact.html" class="nav-item nav-link">Contact</a>
                </div>
                <a href="Login.html" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Join Now<i class="fa fa-arrow-right ms-3"></i></a>
            </div>
        </nav>

        <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
            <div class="wrapper wrapper--w780">
                <div class="card card-3">

                    <div class="card-body">
                        <h2 class="title">Update Course</h2>

                        <form action="update2" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="id" value="${cs.getCourseID()}">
                            <div class="input-group">
                                Name:<input class="input--style-3" type="text"  name="name" value="${cs.getCourseName()}" required>
                            </div>
                            <div class="input-group">
                                Price<input class="input--style-3" type="text"  name="price" value="${cs.getCoursePrice()}" required>
                            </div>
                            <div class="input-group">
                                Discount<input class="input--style-3" type="text" placeholder="${discount}" name="discount"  required>
                            </div>
                            <div class="input-group">
                                Description<input type="text" name="description" id="description" class="input--style-3" placeholder="${cs.getCourseDescription()}" value="${cs.getCourseDescription()} " required>                   
                            </div>
                            <div class="input-group">
                                Image<input type="file" name="image" id="name" class="input--style-3" placeholder="${cs.getCourseImg()}" value="${cs.getCourseImg()}" accept="image/*" >
                            </div>
                            
                            <div class="p-t-10">
                                <button class="btn btn--pill btn--green" type="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            document.querySelector('input[name="price"]').addEventListener('input', event => {
                const value = event.target.value.replace(/\D/g, '');
                if (!isNaN(value)) {
                    event.target.value = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(value);
                    event.target.setSelectionRange(event.target.value.length, event.target.value.length);
                }
            });
        </script>
        <script>
            // JavaScript code to get the discount value from the URL parameters
            const urlParams = new URLSearchParams(window.location.search);
            const discountValue = urlParams.get('discount');

            // Set the discount value to the input element
            const discountInput = document.querySelector('input[name="discount"]');
            discountInput.value = discountValue;
        </script>
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
