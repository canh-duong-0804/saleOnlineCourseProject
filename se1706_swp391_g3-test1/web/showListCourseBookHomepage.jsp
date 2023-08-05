<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page  import="Model.Course" %>
<%@page  import="Model.Course_Book" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Course book</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
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
        <div class="col-md-3">
           <form action="searchnamebookclients" method="Get">
                        <div class="SearchBox">
                            <input type="text" name="search" class="SearchBox-input" style="color: black;" placeholder="Search"> 

                            <button class="SearchBox-button">
                                <i class="SearchBox-icon  material-icons">search</i>
                            </button>
                        </div>
                    </form>
            <section class="panel">
                <header class="panel-heading">

                </header>

            </section>
            <section class="panel">
                
                <div class="panel-body sliders">
                    <div id="slider-range" class="slider"></div>
                    <div class="slider-info">
                        <span id="slider-range-amount"></span>
                    </div>
                </div>
            </section>
            <section class="panel">
                
                <div class="panel-body">
                    <form action="filterbookclient" method="Get">
                        <div class="form-group">
                            <label style="font-size: 20px">Filter</label>
                            <select class="form-control hasCustomSelect"  name="filter"
                                    style="-webkit-appearance: menulist-button; width: 231px; position: absolute; opacity: 0; height: 34px; font-size: 16px;">
                                <option value="all">all</option>
                                <c:forEach items="${list}" var="item">
                                    <option value="${item.getCourseName()}">${item.getCourseName()}</option>

                                </c:forEach>
                            </select>
                            <span class="customSelect form-control" style="display: inline-block;"><span
                                    class="customSelectInner"
                                    style="width: 209px; display: inline-block; font-size: 16px">Show all book</span></span>
                        </div>


                        <button class="btn btn-primary" type="submit">Filter</button>
                    </form>

                </div>
            </section>

        </div>
        <!-- Courses Start -->
        <div class="container-xxl py-5">

            <div class="container">
                <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                    <h6 class="section-title bg-white text-center text-primary px-5">Courses</h6>
                    <h1 class="mb-5">Popular Book of Courses</h1>
                </div>
                <div class="row g-4 justify-content-center">
                    <c:forEach items="${data}" var="item">
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
                                    <h5 class="mb-4">Stock Quantity: ${item.getStockQuantity()}</h5>
                                </div>
                                <div class="d-flex border-top">
                                    <a href="cart?bookID=${item.getCourse_BookID()}" >
                                        <small class="flex-fill text-center border-end py-2"><div class="btn btn-primary btn-lg btn-flat">
                                                <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                                Add to Cart
                                            </div> </small> </a>
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
</body>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item "><a class="page-link ${tag == 1?"hidden":""}" href="${way}?index=${tag - 1}&filter=${option}&search=${search}">Previous</a></li>
            <c:forEach begin ="1" var="i" end = "${endPage}">    
            <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="${way}?index=${i}&filter=${option}&search=${search}">${i}</a></li>
            </c:forEach>
        <li class="page-item "><a class="page-link ${tag == endPage?"hidden":""}"href="${way}?index=${tag + 1}&filter=${option}&search=${search}">Next</a></li>
    </ul>
</nav>  
</div>

<!-- Courses End -->












        <!-- Footer Start -->
        <%@include  file="footerclients.jsp" %>
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
</body>

</html>