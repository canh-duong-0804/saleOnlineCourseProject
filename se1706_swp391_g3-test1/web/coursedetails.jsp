
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList" %>
<%@page  import="Model.News" %>
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

        <link href="css/bootstrap3.css" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <!--        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">-->

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <!--<link href="css/bootstrap.min_homepage.css" rel="stylesheet">-->

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
        <style>
            #loginA{
                font-size: 15px;
                padding-top: 2.5rem !important;
                padding-right: 3rem !important;
                padding-left: 3rem !important;
            }
        </style>
        <!-- header End -->





        <!-- Content Wrapper. Contains page content -->
         <div class="content-wrapper" style="width: 70%;margin-left: 250px;">
            <!-- Content Header (Page header) -->
<!--            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Course</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="displayCourse">Course</a></li>
                                <li class="breadcrumb-item active">Course Details</li>
                            </ol>
                        </div>
                    </div>
                </div> /.container-fluid 
            </section>-->

            <!-- Main content -->
            <section class="content">

                <!-- Default box -->
                <div class="card card-solid">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12 col-sm-6">
                                <h3 class="d-inline-block d-sm-none"></h3>
                                <div class="col-12">
                                    <div class="custom-div">
                                        <img class="img-fluid w-100" style="width: 410px; height: 270px" src="./img/${course.getCourseImg()}" alt="">
                                    <div class="product-action" style="
                                         display:flex;
                                         justify-content: center;
                                         align-items: center;
                                         ">
                                    </div> 
                                    </div> 
                                </div> 
                                <style>
                                    .custom-div {
                                        width: 80%;
                                        height: 80%;

                                    }

                                    .custom-div img {
                                        width: 100%;
                                        height: 100%;

                                        /*object-fit: cover;*/
                                    }
                                </style>
                                <div class="col-12 product-image-thumbs">
                                    <div class="product-image-thumb active">
                                    </div>

                                </div>
                            </div>
                            <div class="col-12 col-sm-6">
                                <h3 class="my-3">${course.getCourseName()} </h3>
                               

                                <hr>




                                <div class="bg-green py-2 px-3 mt-4">
                                    <h2 class="mb-0">
                                        ${course.getCoursePrice()}
                                    </h2>

                                </div>

                                <div class="mt-4">
                                    <a href="cart?courseID=${id}">
                                        <div class="btn btn-primary btn-lg btn-flat">
                                            <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                            Add to Cart
                                        </div></a>

                                    
                                </div>

                               

                            </div>
                        </div>
                        <div class="row mt-4">
                            <nav class="w-100">
                                <div class="nav nav-tabs" id="product-tab" role="tablist">
                                    <a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab" href="#product-desc"
                                     style="font-size:160%;"  role="tab" aria-controls="product-desc" aria-selected="true">Description</a>
                                     
                                </div>
                                <h3 class="my-3">${course.getCourseDescription()} </h3>
                            </nav>
                            <div class="tab-content p-3" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="product-desc" role="tabpanel"
                                     aria-labelledby="product-desc-tab"> </div>
                                <div class="tab-pane fade" id="product-comments" role="tabpanel" aria-labelledby="product-comments-tab">
                                </div>
                                <div class="tab-pane fade" id="product-rating" role="tabpanel" aria-labelledby="product-rating-tab">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->

            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->













        <!-- Footer Start -->
<%@include  file="footerclients.jsp" %>
        <!--</div>-->
        <!-- Footer End -->


        <!-- Back to Top -->
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