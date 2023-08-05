<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page  import="Model.Course" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>eLEARNING - eLearning WEB</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <link href="css/bootstrap3.css" rel="stylesheet">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <!--<link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">-->
        <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700,900' rel='stylesheet' type='text/css' />

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

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

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min_homepage.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/homepage.css" rel="stylesheet">
        <link href="css/searchbar.css" rel="stylesheet">
    </head>

    <body>
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->



        <!--        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                    <a href="homePage" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                        <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
                    </a>
                    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
                        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
                        <main>
        
        
                            <form action="courseSearch" method="POST">
                                <div class="SearchBox">
                                    <input type="text" name="search" class="SearchBox-input" style="color: black;" placeholder="Search"> 
        
                                    <button class="SearchBox-button">
                                        <i class="SearchBox-icon  material-icons">search</i>
                                    </button>
                                </div>
                            </form>
                           
                        </main>
        
                        
                        <div class="collapse navbar-collapse" id="navbarCollapse">
                            <div class="navbar-nav ms-auto p-4 p-lg-0">
                                <a href="homePage" class="nav-item nav-link active">Home</a>
        
        
                                <a href="displayCourse" class="nav-item nav-link">Courses</a>
                                <a href="learningPath" class="nav-item nav-link">Learning path</a> 
        
                                <a href="contact.html" class="nav-item nav-link">Register</a>
                            </div>
                            <a href="Login.jsp" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block" style="font-size: 15px;padding-top: 2.5rem !important;padding-right: 3rem !important;
                               padding-left: 3rem !important">Login Now<i class="fa fa-arrow-right ms-3"></i></a>
        
                        </div>
                         </div>
                </nav>-->
        <%@include  file="narbarclients.jsp" %>
        <!-- header End -->
        <style type="text/css">
            #loginA{
                font-size: 15px;
                padding-top: 2.5rem !important;
                padding-right: 3rem !important;
                padding-left: 3rem !important;
            }
            body {
                margin-top: 20px;
                background: #f1f2f7;
                margin: 0;

            }

            /*panel*/
            .panel {
                border: none;
                box-shadow: none;
            }

            .panel-heading {
                border-color: #eff2f7;
                font-size: 16px;
                font-weight: 300;
            }

            .panel-title {
                color: #2A3542;
                font-size: 14px;
                font-weight: 400;
                margin-bottom: 0;
                margin-top: 0;
                font-family: 'Open Sans', sans-serif;
            }


            /*product list*/

            .prod-cat li a {
                border-bottom: 1px dashed #d9d9d9;
            }

            .prod-cat li a {
                color: #3b3b3b;
            }

            .prod-cat li ul {
                margin-left: 30px;
            }

            .prod-cat li ul li a {
                border-bottom: none;
            }

            .prod-cat li ul li a:hover,
            .prod-cat li ul li a:focus,
            .prod-cat li ul li.active a,
            .prod-cat li a:hover,
            .prod-cat li a:focus,
            .prod-cat li a.active {
                background: none;
                color: #ff7261;
            }

            .pro-lab {
                margin-right: 20px;
                font-weight: normal;
            }

            .pro-sort {
                padding-right: 20px;
                float: left;
            }

            .pro-page-list {
                margin: 5px 0 0 0;
            }

            .product-list img {
                width: 100%;
                border-radius: 4px 4px 0 0;
                -webkit-border-radius: 4px 4px 0 0;
            }

            .product-list .pro-img-box {
                position: relative;
            }

            .adtocart {
                background: #fc5959;
                width: 50px;
                height: 50px;
                border-radius: 50%;
                -webkit-border-radius: 50%;
                color: #fff;
                display: inline-block;
                text-align: center;
                border: 3px solid #fff;
                left: 45%;
                bottom: -25px;
                position: absolute;
            }

            .adtocart i {
                color: #fff;
                font-size: 25px;
                line-height: 42px;
            }

            .pro-title {
                color: #5A5A5A;
                display: inline-block;
                margin-top: 20px;
                font-size: 16px;
            }

            .product-list .price {
                color: #fc5959;
                font-size: 15px;
            }

            .pro-img-details {
                margin-left: -15px;
            }

            .pro-img-details img {
                width: 100%;
            }

            .pro-d-title {
                font-size: 16px;
                margin-top: 0;
            }

            .product_meta {
                border-top: 1px solid #eee;
                border-bottom: 1px solid #eee;
                padding: 10px 0;
                margin: 15px 0;
            }

            .product_meta span {
                display: block;
                margin-bottom: 10px;
            }

            .product_meta a,
            .pro-price {
                color: #fc5959;
            }

            .pro-price,
            .amount-old {
                font-size: 18px;
                padding: 0 10px;
            }

            .amount-old {
                text-decoration: line-through;
            }

            .quantity {
                width: 120px;
            }

            .pro-img-list {
                margin: 10px 0 0 -15px;
                width: 100%;
                display: inline-block;
            }

            .pro-img-list a {
                float: left;
                margin-right: 10px;
                margin-bottom: 10px;
            }

            .pro-d-head {
                font-size: 18px;
                font-weight: 300;
            }
        </style>


        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <div class="container bootdey">
            <!-- Courses Start -->
            <!--<div class="col-md-12">-->

            <!--<div class="col-lg-9 col-md-8">-->
            <div class="col-md-9 col-md-push-3">
                <div class="row pb-3">
                    <!--                <div class="col-12 pb-1">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                        </div>
                                    </div>-->
                    <c:forEach items="${data}" var="p">
                        <c:set var="pid" value="${p.getCourseID()}" />
                        <c:set var="idproc" value="${p.getCourseID()}" />
                        <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                            <div class="product-item bg-light mb-4">
                                <div class="product-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100" style="width: 410px; height: 270px" src="./img/${p.getCourseImg()}" alt="">
                                    <div class="product-action" style="
                                         display:flex;
                                         justify-content: center;
                                         align-items: center;
                                         ">
                                        <!--<a href="displayVideo?id=${p.getCourseID()}" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px; font-size:120%;">Read More</a>-->
                                        <a href="cart?courseID=${p.getCourseID()}" class="flex-shrink-0 btn btn-sm btn-primary px-3" style="border-radius: 30px 30px 30px 30px; font-size:120%;">Join Now</a>
                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <c:set var="detailid" value="${p.getCourseID()}" />
                                    <a style="font-size:160%;" class="h6 text-decoration-none text-truncate" href="courseDetails?id=${p.getCourseID()}">${p.getCourseName()}</a>
                                    <div class="d-flex align-items-center justify-content-center mt-2">
                                        <h5 style="font-size:150%; color: #ee4d2d">${p.getCoursePrice()}</h5>
                                        <h6 class="text-muted ml-2"></h6> 
                                    </div>
                                </div>
                                <div class="card-footer d-flex justify-content-between bg-light border">
                                   <h9 style="font-size:150%; font-family: Times New Roman ;" class="fa text-primary me-2">Creator: ${p.getAdminID()}</h9>
                                    <h10 style="font-size:150%;" class="fas fa-eye text-primary mr-1"><s:formatNumber value="${p.getNumberstudentEnroll()}"/></h10>                           

                                </div>
                            </div>
                        </div>

                    </c:forEach>  
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item "><a class="page-link ${tag == 1?"hidden":""}" href="${link}?Category=${Category.replace(" ","-")}&index=${tag - 1}&search=${search}">Previous</a></li>
                                <c:forEach begin ="1" var="i" end = "${endPage}">    
                                <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="${link}?Category=${Category.replace(" ","-")}&index=${i}&search=${search}">${i}</a></li>
                                </c:forEach>
                            <li class="page-item "><a class="page-link ${tag == endPage?"hidden":""}"  href="${link}?Category=${Category.replace(" ","-")}&index=${tag + 1}&search=${search}">Next</a></li>
                        </ul>
                    </nav>  
                </div>
            </div>
            <!-- Courses End -->
            <div class="col-md-3 col-md-pull-9">              
                <section class="panel">
                    <header  style="font-size:250%;" class="panel-heading">
                        Category
                    </header>

                     <div class="panel-body">
                        <ul class="nav prod-cat">
                            <li>
                                <c:forEach items="${CourseCategory}" var="p">
                                    <a  style="font-size:160%;" href="Category?Category=${p.getCategoryName().replace(" ","-")}" ><i class="fa fa-angle-right"></i> ${p.getCategoryName()}</a>
                                </c:forEach>  

                            </li>

                        </ul>
                    </div>
                </section>
            </div>
        </div>

        <!-- Footer Start -->
        <%@include  file="footerclients.jsp" %>
        <!--</div>-->
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script>
        const urlParams = new URLSearchParams(window.location.search);

        // Retrieve specific parameter value
        const name = urlParams.get('check');
        if (name === "true") {
            window.alert("You must buy the Course!");
        }
        </script>
        <!-- Template Javascript -->
        <script src="js/homepage.js"></script>
    </body>

</html>