<%@page  import="Model.News" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  import="java.util.ArrayList" %>
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
        <script src="https://kit.fontawesome.com/db2444237b.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <!-- Spinner Start -->
        <!--        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>-->
        <!-- Spinner End -->


        <!-- header -->
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
            <a href="homePage" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--searchbar stat-->
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

                <!--search bar end-->
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto p-4 p-lg-0">
                        <!--                        <a href="homePage" class="nav-item nav-link">Home</a>
                        
                        
                                                <a href="displayCourse" class="nav-item nav-link">Courses</a>
                                                <a href="clientbookcourse" class="nav-item nav-link">Book Of Courses</a>
                                                <a href="learningPath" class="nav-item nav-link">Learning path</a> -->
                        <c:forEach items="${sessionScope.listNabar}" var="item"> 
                            <a href="${item.getNews()}" class="nav-item nav-link">${item.getNewsTitle()}</a>
                        </c:forEach>

                        <%  
                            boolean logged=false;
                            String username="";
                            session = request.getSession();
                            if(session.getAttribute("username")!=null){
                                username=(String)session.getAttribute("username");
                                logged=true;
                            }
                            
                            if (logged){
//                                out.print("<a href='purchasedCourse' class='nav-item nav-link'>Own Course</a>");
                                out.print("<a href=\"profile\" class=\"nav-item nav-link\">"+username+"</a>");
                                out.print("<a href='forgot' class='nav-item nav-link'>Logout</a>");
                                out.print(" <a href='cart' class='nav-item nav-link'><i class='fa-solid fa-cart-shopping'></i></a>  ");
                            }
                            else{
                            out.print("<a href='Register.jsp' class='nav-item nav-link'>Register</a>");
                                out.print("<a href='login' id='loginA' class='btn btn-primary py-4 px-lg-5 d-none d-lg-block'>Login Now<i class='fa fa-arrow-right ms-3'></i></a>");
                            }
                        %>

                    </div>
                    <!--<a href="Login.jsp" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Login Now<i class="fa fa-arrow-right ms-3"></i></a>-->

                </div>
        </nav>
    </body>
</html>
