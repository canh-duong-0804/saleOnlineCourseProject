<%-- 
    Document   : Login
    Created on : 14 May, 2023, 9:28:10 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="jakarta.servlet.http.Cookie" %>
<html>
    <%      if(request.getCookies() != null){
                boolean logged=false;
                Cookie[] cookie = request.getCookies();
                for(Cookie c : cookie){
                    if(c.getName().equals("username")){
                        logged=true;
                    }
                }
                if(logged){
                    response.sendRedirect("homePage");
                    return;
                }
            }
    
            
        
    %>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginRegister.css">
        <link rel="stylesheet" href="css/bootstrap.min_loginRegister.css">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&amp;display=swap" rel="stylesheet">
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
        <script src="js/main.js"></script>
    </head>

    <body>
        <!-- header -->
        <!--        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                    <a href="homePage" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
                        <h2 class="m-0 text-primary"><i class="fa fa-book me-3"></i>eLEARNING</h2>
                    </a>
                    <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <div class="navbar-nav ms-auto p-4 p-lg-0">
                            <a href="homePage" class="nav-item nav-link active">Home</a>
                            <a href="#" class="nav-item nav-link">About</a>
                            <a href="displayCourse" class="nav-item nav-link">Courses</a>
                            <a href="learningPath" class="nav-item nav-link">Learning path</a> 
                            <a href="#" class="nav-item nav-link">Contact</a>
                            <a href="Register.jsp" class="nav-item nav-link">Register</a>
                        </div>
                        <a href="#" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Login Now<i class="fa fa-arrow-right ms-3"></i></a>
                    </div>
                </nav>-->
        <%@include  file="narbarclients.jsp" %>
        <!-- header End -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 order-md-2">
                    </div>
                    <div class="col-md-6 contents">
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <div class="mt-5 mb-4">
                                    <h3>Sign In to <strong>eLEARNING</strong></h3>
                                </div>
                                <form action='login' method="post">
                                    <div class="form-group first">
                                        <label for="username">Username</label>
                                        <input type="text" class="form-control" required id="username" value ="${username}" name ="username">
                                    </div>
                                    <div class="form-group last mb-4">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" required id="password" value = "${password}" name ="password">
                                    </div>
                                    ${message}
                                    <div class="d-flex mb-5 align-items-center">   
                                        <input type="checkbox" name="remember" value="remember" checked="checked">
                                        <label class="control control--checkbox mb-0"><span class="caption" style="margin-right: 5px">Remember me</span>
                                            <div class="control__indicator"></div>
                                        </label>
                                        <span class="ml-5"><a href="ForgotPassword.jsp" class="forgot-pass"> Forgot Password</a></span>
                                    </div>
                                    <input type="submit" value="Log In" class="btn text-white btn-block btn-primary">
                                    <span class="d-block text-left my-4 text-muted"> or sign in with</span>
                                    <div class="social-login">
                                        <a href="#" class="facebook">
                                            <span class="icon-facebook mr-3"></span>
                                        </a>
                                        <a href="#" class="twitter">
                                            <span class="icon-twitter mr-3"></span>
                                        </a>
                                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile&redirect_uri=http://localhost:9999/SWP391_SE1706_G3/loginGoogle&response_type=code
                                           &client_id=691522855475-b8gvvqmp3bksu9psposomtlhfjkdris4.apps.googleusercontent.com&approval_prompt=force" class="google">
                                            <span class="icon-google mr-3"></span>
                                        </a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
