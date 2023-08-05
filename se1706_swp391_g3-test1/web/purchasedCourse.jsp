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


        <!-- header -->
        <!-- header -->
        <%@include  file="narbarclients.jsp" %>
        <style>
            #loginA{
                font-size: 15px;
                padding-top: 2.5rem !important;
                padding-right: 3rem !important;
                padding-left: 3rem !important;
            }
        </style>
        <!-- header End -->



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
                    <c:forEach items="${purchased}" var="p">
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
                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <c:set var="detailid" value="${p.getCourseID()}" />
                                    <a href="displayVideo/${p.getUserName().replaceAll(" ","-")}" style="font-size:160%;" class="h6 text-decoration-none text-truncate" >My ${p.getUserName()} Course</a>
                                </div>
                                <div class="card-footer d-flex justify-content-between bg-light border">
                                    <h8 style="font-size:150%; font-family: Times New Roman ;" class="fa text-primary me-2">Creator: ${p.getStatus()}</h8>


                                </div>
                            </div>
                        </div>

                    </c:forEach>  
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item "><a class="page-link " ${tag == 1?"hidden":""} href="purchasedCourse?username=${username}&&index=${tag - 1}">Previous</a></li>
                                <c:forEach begin ="1" var="i" end = "${endPage}">    
                                <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="purchasedCourse?username=${username}&&index=${i}">${i}</a></li>
                                </c:forEach>

                            <li class="page-item "><a class="page-link " ${tag == endPage?"hidden":""}  href="purchasedCourse?username=${username}&&index=${tag + 1}">Next</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- Courses End -->
        </div>
        <!-- Footer Start -->
        <%@include  file="footerclients.jsp" %>
        <!--Back to Top--> 
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        <script>
            var url = window.location.pathname;
            if(url === "/khoa-hoc-chua-cap-nhat"){
                window.alert("Vui lòng ??i website c?p nh?t video");
            }
        </script>
        <!--JavaScript Libraries--> 
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!--Template Javascript--> 
        <script src="js/homepage.js"></script>

    </body>

</html>