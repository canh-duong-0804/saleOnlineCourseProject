<%-- 
    Document   : Product.jsp
    Created on : 14 May, 2023, 9:28:55 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Course</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginRegister.css">
        <link rel="stylesheet" href="css/bootstrap.min_loginRegister.css">
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
        <link href="css/searchbar.css" rel="stylesheet">
    </head>

    <body>
        <!-- header -->
        <!--        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                    <a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
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
                                <a href="index.html" class="nav-item nav-link active">Home</a>
                                <a href="about.html" class="nav-item nav-link">About</a>
                                <a href="displayCourse" class="nav-item nav-link">Courses</a>
                                <a href="learningPath" class="nav-item nav-link">Learning path</a> 
                                <a href="contact.html" class="nav-item nav-link">Contact</a>
                                <a href="contact.html" class="nav-item nav-link">Register</a>
                            </div>
                            <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Login Now<i class="fa fa-arrow-right ms-3"></i></a>
                        </div>
                </nav>-->
        <%@include  file="narbarclients.jsp" %>
        <!-- header End -->


        <div class="col-md-2 float mt-5 ms-3 col-sm-12 col-xs-12 category">
            <aside >
                <div class="module">
                    <h3>Categories</h3>
                    <ul>
                        <li>
                            <a href="#">Top</a>
                        </li>
                        <li>
                            <a href="#">Recommended</a>
                        </li>
                        <li>
                            <a href="#">Free</a>
                        </li>
                        <li>
                            <a href="#">Paid</a>
                        </li>
                        <li>
                            <a href="#">Combo</a></li>
                        </li>
                    </ul>
                </div>
                <div class="module">
                    <h3>Groups</h3>
                    <ul>
                        <li>
                            <a href="#">Group A</a>
                        </li>
                        <li>
                            <a href="#">Group B</a>
                        </li>
                        <li>
                            <a href="#">Group C</a>
                        </li>
                        <li>
                            <a href="#">Group D</a>
                        </li>
                    </ul>
                </div>
            </aside>
        </div>

        <div class="col-md-9 float mt-5 p_display">

            <!--view blog stat-->
            ${blog.getNewsTitle()}

            ${blog.getNews()}

            <img src="${blog.getNewsImg()}">

            <!--view blog end-->
        </div>    
    </body> 
</html>
