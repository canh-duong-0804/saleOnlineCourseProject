<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Course" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>eLEARNING - eLearning WEB</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="author" content="">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min_homepage.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/homepage.css" rel="stylesheet">
        <link href="css/searchbar.css" rel="stylesheet">
        <script src="./js/jquery/jquery-1.11.3.min.js"></script>
    </head>
    <body>
        <!-- header -->
        <!--        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                    <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                        <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
                    </a>
                    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    searchbar stat
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
                                <a href="index.jsp" class="nav-item nav-link active">Home</a>
                                <a href="about.jsp" class="nav-item nav-link">About</a>
                                <a href="courses.jsp" class="nav-item nav-link">Courses</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Learning path</a>
                                    <div class="dropdown-menu fade-down m-0">
                                        <a href="team.jsp" class="dropdown-item">Learning path of course A</a>
                                        <a href="testimonial.jsp" class="dropdown-item">Learning path of course B</a>
                                        <a href="404.jsp" class="dropdown-item">Learning path of course C</a>
                                    </div>
                                </div>
                                <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                            </div>
                            <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Join Now<i class="fa fa-arrow-right ms-3"></i></a>
                        </div>
                </nav>-->
        <%@include  file="narbarclients.jsp" %>
        <!-- end header -->

        <main role="main">

            <div class="container mt-4">
                <form class="needs-validation" name="frmCreateOrder" id="frmCreateOrder" action="vnpay" method="post">

                    <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

                    <div class="py-5 text-center">
                        <i class="fa fa-credit-card fa-4x" aria-hidden="true"></i>
                        <h2>Payment</h2>
                        <p class="lead">Please make sure your information that you provide us is correct.</p>
                    </div>

                    <div class="row">
                        <div class="col-md-4 order-md-2 mb-4">
                            <h4 class="d-flex justify-content-between align-items-center mb-3">
                                <span class="text-muted">Cart</span>
                                <span class="badge badge-secondary badge-pill">2</span>
                            </h4>
                            <ul class="list-group mb-3">
                                <c:forEach items="${requestScope.dataCourse}" var="item">
                                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                                        <div>
                                            <h6 class="my-0">${item.getCourseName()}</h6>
                                            <small class="text-muted">1 </small>
                                        </div>
                                        <span class="text-muted">${item.getCoursePrice()}</span>
                                    </li>
                                </c:forEach>
                                <c:forEach items="${requestScope.dataBook}" var="item">
                                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                                        <div>
                                            <h6 class="my-0">${item.getBookName()}</h6>
                                            <small class="text-muted">${item.getQuantity()} </small>
                                        </div>
                                        <span class="text-muted">${item.getTotalPrice()}</span>
                                    </li>
                                </c:forEach>

                                <li class="list-group-item d-flex justify-content-between">
                                    <span>Total</span>
                                    <strong name="amount">${Totalprice}</strong>
                                </li>
                            </ul>


                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Coupon">
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-secondary">Confirm</button>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-8 order-md-1">
                            <h4 class="mb-3">Personal Information</h4>

                            <div class="row">
                                <div class="col-md-12">
                                    <label for="kh_ten">Name</label>
                                    <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                           value="${user.getuName()}" readonly="">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_diachi">Address</label>
                                    <input type="text" class="form-control" name="kh_diachi" id="kh_diachi"
                                           value="${user.getuAddress()}" readonly="">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_dienthoai">Phone</label>
                                    <input type="text" class="form-control" name="kh_dienthoai" id="kh_dienthoai"
                                           value="${user.getuPhoneNumber()}" readonly="">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_email">Email</label>
                                    <input type="text" class="form-control" name="kh_email" id="kh_email"
                                           value="${user.getuEmail()}" readonly="">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_ngaysinh">Date of Birth</label>
                                    <input type="date" value="${user.getuDob()}" class="form-control" readonly="" name="kh_ngaysinh" id="kh_ngaysinh">
                                </div>
                                <div class="col-md-12">
                                    <label for="kh_dienthoai">Order ID</label>
                                    <input type="text" class="form-control" name="orderId" id="kh_dienthoai"
                                           value="${OrderID}" readonly="">
                                </div>
                            </div>

                            <h4 class="mb-3">Payment Method</h4>

                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="httt-1" name="paymentMethod" type="radio" class="custom-control-input" required
                                           value="1">
                                    <label class="custom-control-label" for="httt-1">VNPAY</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="httt-2" name="paymentMethod" type="radio" class="custom-control-input" required
                                           value="2">
                                    <label class="custom-control-label" for="httt-2">&#84;&#104;&#97;&#110;&#104;&#32;&#116;&#111;&aacute;&#110;&#32;&#107;&#104;&#105;&#32;&#110;&#104;&#7853;&#110;&#32;&#104;&agrave;&#110;&#103;</label>
                                </div>

                            </div> 
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="submit" name="btnDatHang">Order</button>

                        </div>
                    </div>
                </form>

            </div>
            <!-- End block content -->

        </main>

        <!-- footer -->
        <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
            <div class="container py-5">
                <div class="row g-5">
                    <div class="col-lg-3 col-md-6">
                        <h4 class="text-white mb-3">Quick Link</h4>
                        <a class="btn btn-link" href="">About Us</a>
                        <a class="btn btn-link" href="">Contact Us</a>
                        <a class="btn btn-link" href="">Privacy Policy</a>
                        <a class="btn btn-link" href="">Terms & Condition</a>
                        <a class="btn btn-link" href="">FAQs & Help</a>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="text-white mb-3">Contact</h4>
                        <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                        <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                        <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                        <div class="d-flex pt-2">
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                            <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="text-white mb-3">Gallery</h4>
                        <div class="row g-2 pt-2">
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                            </div>
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                            </div>
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                            </div>
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-2.jpg" alt="">
                            </div>
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-3.jpg" alt="">
                            </div>
                            <div class="col-4">
                                <img class="img-fluid bg-light p-1" src="img/course-1.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <h4 class="text-white mb-3">Newsletter</h4>
                        <p>The best course provider in your area</p>
                        <div class="position-relative mx-auto" style="max-width: 400px;">
                            <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                            <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="copyright">
                    <div class="row">
                        <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                            &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                            <!--/*** This template is free as long as you keep the footer author?s credit link/attribution link/backlink. If you'd like to use the template without the footer author?s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a><br><br>
                            Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                        </div>
                        <div class="col-md-6 text-center text-md-end">
                            <div class="footer-menu">
                                <a href="">Home</a>
                                <a href="">Cookies</a>
                                <a href="">Help</a>
                                <a href="">FQAs</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>        
        <!-- end footer -->

        <!-- Optional JavaScript -->
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            location.href = x.data;
                        }
                    }
                });
                return false;
            });
        </script>       
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/popperjs/popper.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Custom script - C�c file js do m�nh t? vi?t -->
        <script src="../assets/js/app.js"></script>


    </body>
</html>
