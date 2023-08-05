<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <title>eLEARNING - eLearning WEB</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <base href="http://localhost:9999/SWP391_SE1706_G3/"/>
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <!--<link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">-->

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->


        <!-- Template Stylesheet -->
        <link href="css/homepage.css" rel="stylesheet">
        <link href="css/searchbar.css" rel="stylesheet">
        <link rel="stylesheet" href="css/video.css">
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <link href="css/bootstrap.min_homepage.css" rel="stylesheet">
        <style>
            .butt {
                background-color: red;
                color: white;
                padding: 1em 1.5em;
                text-decoration: none;
                text-transform: uppercase;
            }

            .butt:hover {
                background-color: #555;
            }

            .butt:active {
                background-color: black;
            }

            .butt:visited {
                background-color: #ccc;
            }
        </style>
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
        <!--        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                    <a href="homepage.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
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
        
                        search bar end
                        <div class="collapse navbar-collapse" id="navbarCollapse">
                            <div class="navbar-nav ms-auto p-4 p-lg-0">
                                 <a href="homePage" class="nav-item nav-link active">Home</a>
                                <a href="about.html" class="nav-item nav-link">About</a>
                                <a href="displayCourse" class="nav-item nav-link">Courses</a>
                                <a href="learningPath" class="nav-item nav-link">Learning path</a> 
                                <a href="#" class="nav-item nav-link">Contact</a>
                                <a href="profile?username=${user}" class="nav-item nav-link">${user}</a>
                            </div>
        
                        </div>
                </nav>-->
        <%@include  file="narbarclients.jsp" %>
        <!-- header End -->

        <h1 style="margin-top: 10px; text-align: center">
            <!--Begining Learning Java-->Your ${Name} Course
        </h1>
        <%--<c:set var = "salary" scope = "session" value = "${2000*2}"/>--%>
        <c:if test = "${not empty dataVideo}">
            <section class="hero--area section-padding-80">
                <div class="container">
                    <div class="row no-gutters">
                        <div class="col-12 col-md-7 col-lg-8">
                            <div class="tab-content">

                                <div class="tab-pane fade show active" id="video" role="tabpanel" aria-labelledby="post-1-tab"> 
                                    <iframe class="single-feature-post video-post" src="${video}" title="YouTube video player" frameborder="0" 
                                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                                </div>                
                            </div>
                        </div>

                        <div class="col-12 col-md-5 col-lg-4">
                            <ul class="nav vizew-nav-tab" role="tablist">
                                <c:forEach items="${dataVideo}" var="i">
                                    <li class="nav-item" style="width: 100%">
                                        <a class="nav-link ${order == i.getVideoOrder()?"active":""}" id="post-1-tab"  href="displayVideo/${i.getVideoOrder()}&${Name.replaceAll(" ","-")}" data-target="#video" role="tab" aria-controls="post-1" aria-selected="true">
                                            <!--Single Blog Post--> 
                                            <div class="single-blog-post style-2 d-flex align-items-center">

                                                <div class="post-content">
                                                    <h6 class="post-title">${i.getVideoName()}</h6>

                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>                                                  
                            </ul>

                        </div>
                        <c:forEach items="${dataDoc}" var="i"> 
                            <div><i style="color: #222660" class="fas fa-download"></i>
                                <a href="DocsTest/${i.getDocumentLink()}" download="${i.getDocumentLink()}"
                                   class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">${i.getDocumentLink()}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

            </section>
        </c:if>
        <c:if test = "${empty dataVideo}">
            <h1 style="margin-top: 10px; text-align: center">${message}</h1>
        </c:if>
        





        <!-- Footer Start -->
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

                </div>
            </div>
            <!--            <div class="container">
                            <div class="copyright">
                                <div class="row">
                                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                        &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.
            
                                        /*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/
                                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a><br><br>
                                        Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                                    </div>
                                    <div class="col-md-6 text-center text-md-end">
                                        <div class="footer-menu">
                                            <a href="">Home</a>
                                            <a href="">Cookies</a>
                                            <a href="">Help</a>
                                            <a href="">FAQs</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
        </div>
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

        <!-- Template Javascript -->
        <script src="js/homepage.js"></script>
        <script src="js/jquery/jquery-2.2.4.min.js"></script>
        <!--Popper js--> 
        <script src="js/bootstrap/popper.min.js"></script>
        <!--Bootstrap js--> 
        <script src="js/bootstrap/bootstrap.min.js"></script>
        <!--All Plugins js--> 
        <script src="js/plugins/plugins.js"></script>
        <!--Active js--> 
        <script src="js/active.js"></script>

    </body>

</html>