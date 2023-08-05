<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page  import="Model.Course" %>
<%@page  import="Model.Course_Book" %>
<%@page import="java.util.ArrayList"%>
<%@page  import="Model.News" %>
<%@ page import="Controller.ManageBlogController.showBlogDetails" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>${blog.getNewsTitle()}</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <base href="http://localhost:9999/SWP391_SE1706_G3/"/>
        <link href="css/bootstrap3.css" rel="stylesheet">
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
        <style>
            #loginA{
                font-size: 15px;
                padding-top: 2.5rem !important;
                padding-right: 3rem !important;
                padding-left: 3rem !important;
            }
        </style>


        <!--        <form action="filterclientnews" method="post">
                    <select name="filter">
                        <option value="0">show all news</option>
                        <option value="1">sale</option>
                        <option value="2">course news</option>
                        <option value="3">technology</option>
                        <option value="10">3 news gan nhat</option>
                        <option value="11">tac gia</option>
                    </select><input type="submit"></form>-->



        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <div class="container bootdey">
            <div class="col-md-3">
                <!--                <div class="card card-primary card-outline">
                                    <div class="card-body box-profile">
                                        <div class="text-center">
                                            <img class="profile-user-img img-fluid img-circle"
                                                 src="./img/${userInfo.getImage()}"
                                                 alt="User profile picture">
                                        </div>
                
                                        <h3 class="profile-username text-center">${fullname}</h3>
                
                                        <p class="text-muted text-center">Software Engineer</p>
                
                                        <ul class="list-group list-group-unbordered mb-3">
                                            <li class="list-group-item">
                                                <b>Followers</b> <a class="float-right">1,322</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Following</b> <a class="float-right">543</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Friends</b> <a class="float-right">13,287</a>
                                            </li>
                                        </ul>
                
                                        <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
                                    </div>
                                     /.card-body 
                                </div>-->

            </div>
            <div class="container-xxl py-5">
                <div class="container">
                    <div style="padding-left: 50px;font-size: 15px"
                         <!--view blog stat-->
                        <div class="row">
                            <div class="col-md-10">
                                <h1>${blog.getNewsTitle()}</h1>



                            </div>
                            <div class="col-md-10">
                                <p>${blog.getNews()}</p>
                            </div>

                        </div>



                        <!--view blog end-->
                    </div>    
                </div>
            </div>


        </div>
        <div class="recent-news">
            <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">-->
            <style>
                /*  .container {
                    display: flex;
                    flex-wrap: wrap;
                    justify-content: space-between;
                  }
                
                  .news-item {
                    flex: 0 0 23%;
                    margin-bottom: 20px;
                    border: 1px solid #ddd;
                    border-radius: 4px;
                    padding: 10px;
                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                  }
                
                  .news-item img {
                    width: 100%;
                    height: 50px;  ?i?u ch?nh chi?u cao c?a ?nh 
                    object-fit: cover;
                    border-radius: 4px;
                    margin-bottom: 10px;
                  }
                
                  .news-item h3 {
                    font-size: 18px;
                    margin-bottom: 10px;
                  }
                
                  .news-item p {
                    font-size: 14px;
                    color: #777;
                  }*/
                .image-container {
                    position: relative;
                    width: 100%;
                    padding-top: 56.25%; /* T? l? 16:9 */
                }

                .image-container img {
                    position: absolute;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 100%;
                    object-fit: cover; /* C?n ch?nh ?nh */
                }

            </style>

            <h1>Recent News</h1>
            <!-- Service Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="row g-4"> <c:forEach items="${data}" var="item">
                            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                                <div class="service-item text-center pt-3">
                                    <div class="p-4">

                                        <div class="image-container">
                                            ${item.getNewsImg()} 
                                        </div>
                                            <h5 class="mb-3"style="font-size: 16px"><a href="viewblogdetails/tintuc-${showBlogDetails.convertToSlug(item.getNewsTitle().replaceAll(" ","-"))}-${item.getNewsID()}">${item.getNewsTitle()}</a></h5>
                                        <c:set var="fullText" value="${item.getNews()}" />
                                        <p style="font-size: 20px">${fn:substring(fullText, 0, 350)}...</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
            <!-- Service End -->





            <!-- Li?n k?t ??n Bootstrap JS v? jQuery -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        </div>
        <!-- ?o?n m? HTML ?? hi?n th? giao di?n -->










        <%@include  file="footerclients.jsp" %>


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
            $(document).ready(function () {
                $('p').find('img').each(function () {
                    $(this).wrap('<a data-fancybox="gallery" href="' + $(this).attr('src') + '"></a>');
                });

                // K?ch ho?t Fancybox
                $('[data-fancybox="gallery"]').fancybox({
                    buttons: [
                        'zoom',
                        'slideShow',
                        'fullScreen',
                        'close'
                    ],
                    loop: true
                });
            });
        </script>

        <!-- Template Javascript -->
        <script src="js/homepage.js"></script>
    </body>

</html>