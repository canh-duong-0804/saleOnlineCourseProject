<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>eLEARNING - eLearning WEB</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

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
        <%@include  file="narbarclients.jsp" %>
        <!-- header End -->


      <!-- Carousel Start -->
        <div class="container-fluid p-0 mb-5">
            <div class="owl-carousel header-carousel position-relative">
                <c:forEach items="${data}" var="item">

                    <div class="owl-carousel-item position-relative">
                        <img  src="${item.getNewsImg()}" width="500px" height="700px" alt="">
                        <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(24, 29, 56, .7);">
                            <div class="container">
                                <div class="row justify-content-start">
                                    <div class="col-sm-10 col-lg-8">
                                        <h5 class="text-primary text-uppercase mb-3 animated slideInDown">${item.getNewsTitle()}</h5>
                                        <h1 class="display-3 text-white animated slideInDown">The Best Online Learning Platform</h1>
                                        <p class="fs-5 text-white mb-4 pb-2">${item.getNews()}</p>
                                        <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                        <a href="" class="btn btn-light py-md-3 px-md-5 animated slideInRight">Join Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
        <!-- Carousel End -->


        <!-- Service Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="row g-4">
                    <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="service-item text-center pt-3">
                            <div class="p-4">
                                <i class="fa fa-3x fa-graduation-cap text-primary mb-4"></i>
                                <h5 class="mb-3">Develop creative thinking</h5>
                                <p>Learning to code helps you improve logical thinking and take you to a new level in solving problems</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                        <div class="service-item text-center pt-3">
                            <div class="p-4">
                                <i class="fa fa-3x fa-globe text-primary mb-4"></i>
                                <h5 class="mb-3">Get to know the technology world</h5>
                                <p>Learning to code to step into the world of Information Technology and adapt to the Industry 4.0.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                        <div class="service-item text-center pt-3">
                            <div class="p-4">
                                <i class="fa fa-3x fa-home text-primary mb-4"></i>
                                <h5 class="mb-3">Get more job opportunities</h5>
                                <p>Programming jobs are growing 50% faster than the overall job market with an average salary of 30% higher than that of other jobs.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                        <div class="service-item text-center pt-3">
                            <div class="p-4">
                                <i class="fa fa-3x fa-book-open text-primary mb-4"></i>
                                <h5 class="mb-3">Book Library</h5>
                                <p>Many reference materials to provide students during the learning process</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service End -->


        <!-- About Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px;">
                        <div class="position-relative h-100">
                            <img class="img-fluid position-absolute w-100 h-100" src="img/homepage1.png" alt="" style="object-fit: cover;">
                        </div>
                    </div>
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                        <h6 class="section-title bg-white text-start text-primary pe-3">About Us</h6>
                        <h1 class="mb-4">Welcome to eLEARNING</h1>
                        <p class="mb-4">Welcome to the MDN learning area. This set of articles aims to guide complete beginners to web development with all that they need to start coding websites.</p>
                        <p class="mb-4">The aim of this area of MDN is not to take you from "beginner" to "expert" but to take you from "beginner" to "comfortable." From there, you should be able to start making your way, learning from the rest of MDN, and other intermediate to advanced resources that assume a lot of previous knowledge.</p>
                        <div class="row gy-2 gx-4 mb-4">
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Skilled Instructors</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Online Classes</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>International Certificate</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Skilled Instructors</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Online Classes</p>
                            </div>
                            <div class="col-sm-6">
                                <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>International Certificate</p>
                            </div>
                        </div>
                        <a class="btn btn-primary py-3 px-5 mt-2" href="">Read More</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- About End -->



       <!-- Categories Start -->

        <div class="container-xxl py-5">

            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-5">Courses</h6>
                    <h1 class="mb-5">Popular Book of Courses</h1>
                </div>
                <div class="row g-4 justify-content-center">
                    <c:forEach items="${homePageCourseBook}" var="item">
                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                            <div class="course-item bg-light">
                                <div class="position-relative overflow-hidden">
                                   <img class="img-fluid w-100" style="width: 410px; height: 270px" src="${item.getBookImg()}" alt="">

                                    <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                        <a href="viewclientbookdetails/Sach-lap-trinh${showBlogDetails.convertToSlug(item.getBookName().replaceAll(" ","-"))}-${item.getCourse_BookID()}" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                        <a href="viewclientbookdetails/Sach-lap-trinh${showBlogDetails.convertToSlug(item.getBookName().replaceAll(" ","-"))}-${item.getCourse_BookID()}" class="flex-shrink-0 btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Join Now</a>
                                    </div>
                                </div>
                                <div class="text-center p-4 pb-0">
                                    <h3 class="mb-0">${item.getPrice()}</h3>

                                    <h5 class="mb-4"> ${item.getBookName()}</h5>
                                    <h5 class="mb-4">Quantity: ${item.getStockQuantity()}</h5>
                                </div>
                                <div class="d-flex border-top">
                                    <small class="flex-fill text-center border-end py-2"><div class="btn btn-primary btn-lg btn-flat">
                                            <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                            Add to Cart
                                        </div></small>
                                    <small class="flex-fill text-center border-end py-2"><div class="btn btn-default btn-lg btn-flat">
                                            <i class="fas fa-heart fa-lg mr-2"></i>
                                            Add to Wishlist
                                        </div></small>

                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </div>

            </div>
        </div> 


        <!-- Categories End -->


        <!-- Courses Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-3">Courses</h6>
                    <h1 class="mb-5">Popular Courses</h1>
                </div>
                <div class="row g-4 justify-content-center">
                    <!--                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <!--                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                                            <div class="course-item bg-light">
                                                <div class="position-relative overflow-hidden">
                                                    <img class="img-fluid" src="img/Introcourse5.jpg" alt="">
                                                    <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Join Now</a>
                                                    </div>
                                                </div>
                                                <div class="text-center p-4 pb-0">
                                                    <h3 class="mb-0">$149.00</h3>
                                                    <div class="mb-3">
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small>(123)</small>
                                                    </div>
                                                    <h5 class="mb-4">artificial intelligence</h5>
                                                </div>
                                                <div class="d-flex border-top">
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>John Doe</small>
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>1.49 Hrs</small>
                                                    <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>30 Students</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                                            <div class="course-item bg-light">
                                                <div class="position-relative overflow-hidden">
                                                    <img class="img-fluid" src="img/Introcourse2.jpg" alt="">
                                                    <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Join Now</a>
                                                    </div>
                                                </div>
                                                <div class="text-center p-4 pb-0">
                                                    <h3 class="mb-0">$149.00</h3>
                                                    <div class="mb-3">
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small>(123)</small>
                                                    </div>
                                                    <h5 class="mb-4">Mobile</h5>
                                                </div>
                                                <div class="d-flex border-top">
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>John Doe</small>
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>1.49 Hrs</small>
                                                    <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>30 Students</small>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                                            <div class="course-item bg-light">
                                                <div class="position-relative overflow-hidden">
                                                    <img class="img-fluid" src="img/Introcourse4.jpg" alt="">
                                                    <div class="w-100 d-flex justify-content-center position-absolute bottom-0 start-0 mb-4">
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3 border-end" style="border-radius: 30px 0 0 30px;">Read More</a>
                                                        <a href="#" class="flex-shrink-0 btn btn-sm btn-primary px-3" style="border-radius: 0 30px 30px 0;">Join Now</a>
                                                    </div>
                                                </div>
                                                <div class="text-center p-4 pb-0">
                                                    <h3 class="mb-0">$149.00</h3>
                                                    <div class="mb-3">
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small class="fa fa-star text-primary"></small>
                                                        <small>(123)</small>
                                                    </div>
                                                    <h5 class="mb-4">Back-end web</h5>
                                                </div>
                                                <div class="d-flex border-top">
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-user-tie text-primary me-2"></i>John Doe</small>
                                                    <small class="flex-fill text-center border-end py-2"><i class="fa fa-clock text-primary me-2"></i>1.49 Hrs</small>
                                                    <small class="flex-fill text-center py-2"><i class="fa fa-user text-primary me-2"></i>30 Students</small>
                                                </div>
                                            </div>
                                        </div>-->
                    <!--</div>-->
                    <c:forEach items="${homepage}" var="p">
                        <c:set var="cid" value="${p.getCourseID()}" />
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
                </div>
            </div>
            <!--</div>-->

        </div>
        <!-- Courses End -->




        <!-- Footer Start -->
        <%@include  file="footerclients.jsp" %>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <!-- JavaScript Libraries -->
        <script type="text/javascript">
            var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
            (function () {
                var s1 = document.createElement("script"), s0 = document.getElementsByTagName("script")[0];
                s1.async = true;
                s1.src = 'https://embed.tawk.to/6487c7c494cf5d49dc5d4c6c/1h2p68lvv';
                s1.charset = 'UTF-8';
                s1.setAttribute('crossorigin', '*');
                s0.parentNode.insertBefore(s1, s0);
            })();
        </script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script>
            const urlParams = new URLSearchParams(window.location.search);

// Retrieve specific parameter value
            const name = urlParams.get('vnp_TransactionStatus');
            if (name === "00") {
                window.alert("Transaction Success !");
            } else if (name === "02") {
                window.alert("Transaction Failed");
            }
        </script>
        <!-- Template Javascript -->
        <script src="js/homepage.js"></script>
    </body>

</html>