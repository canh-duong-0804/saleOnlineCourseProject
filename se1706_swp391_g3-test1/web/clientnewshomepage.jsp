<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page  import="Model.Course" %>
<%@page  import="Model.News" %>
<%@page import="java.util.ArrayList"%>
<%@ page import="Controller.ManageBlogController.showBlogDetails" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>News</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
        <!--        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
        
        <!-- Spinner End -->



        <!-- header -->
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



    <body>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
        <div class="container bootdey">
            <div class="col-md-3">
                <section class="panel">

                </section>
                <section class="panel">
                    <header class="panel-heading">
                        <form action="searchnewsclients" method="get" >
                            <div class="SearchBox">
                                <input type="text" oninput="searchByName(this)" id="search" value="${txtSearch}" class="SearchBox-input" name="search" style="color: white;" placeholder="Search here">

                                <button class="SearchBox-button">
                                    <i class="SearchBox-icon  material-icons">search</i>
                                </button>

                            </div>
                        </form>
                    </header>

                </section>
                <section class="panel">
                    <header class="panel-heading">

                    </header>
                    <div class="panel-body sliders">
                        <div id="slider-range" class="slider"></div>
                        <div class="slider-info">
                            <span id="slider-range-amount"></span>
                        </div>
                    </div>
                </section>
                <section class="panel">

                    <div class="panel-body">
                        <form action="filternewsclient" method="get">

                            <div class="form-group">
                                <label style="font-size: 20px">Filter</label>

                                <select class="form-control hasCustomSelect"  name="filter"
                                        style="-webkit-appearance: menulist-button; width: 231px; position: absolute; opacity: 0; height: 34px; font-size: 12px;">
                                    <c:forEach items="${newsType}" var="item">

                                        <option value="${item.getNewsTypeID()}" style="font-size: 16px">${item.getNewsTypeName()}</option>
                                    </c:forEach>
                                </select>
                                <span class="customSelect form-control" style="display: inline-block;"><span
                                        class="customSelectInner"
                                        style="width: 209px; display: inline-block; font-size: 16px">show all news</span></span>

                                <button class="btn btn-primary" style="font-size: 20px" type="submit">Filter</button>
                            </div>
                        </form>
                    </div>
                </section>

            </div>
            <!-- Courses Start -->


            <!-- About Start -->
            <div class="container-xxl py-5" >
                <style>
                    .custom-div {
                        width: 370px;
                        height: 250px;
                    }

                    .custom-div img {
                        width: 100%;
                        height: 100%;
                        /*object-fit: cover;*/
                    }
                </style>
                <div class="container">

                    <!--<div id="content1">-->
                    <div class="row g-5" id="titleSearch" >

                        <!--                        <div id="titleSearch">-->
                        <c:forEach items="${data}" var="item">
                            <div class="col-lg-6 wow fadeInUp"  style="width: 400px;height: 250px">
                                <div class="position-relative h-100">
                                    <div class="custom-div">
                                        <img class="img-fluid position-absolute w-100 h-100" src="${item.getNewsImg()}" >

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 wow fadeInUp" >
                                <h6 class="section-title bg-white text-start text-primary pe-3"style="font-size: 20px"> ${item.getNewsTypeID()}</h6>
                                <h1 class="mb-4" ><a href="viewblogdetails/tintuc-${showBlogDetails.convertToSlug(item.getNewsTitle().replaceAll(" ","-"))}-${item.getNewsID()}" style="color: #20542b"> ${item.getNewsTitle()}</a></h1>

                                <c:set var="fullText" value="${item.getNews()}" />
                                <style> mb-4 p{
                                        font-size: 20px
                                    }
                                </style>

                                <p class="mb-4" style="font-size: 20px"> ${fn:substring(fullText, 0, 350)}...</p>

                                <div class="row gy-2 gx-4 mb-4">



                                </div>
                                <a class="btn btn-primary py-3 px-5 mt-2" href="viewblogdetails/tintuc-${showBlogDetails.convertToSlug(item.getNewsTitle().replaceAll(" ","-"))}-${item.getNewsID()}">Read More</a>
                            </div>
                        </c:forEach>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item "><a class="page-link ${tag == 1?"hidden":""}" href="${way}?index=${tag - 1}&filter=${option}&search=${search}">Previous</a></li>
                                    <c:forEach begin ="1" var="i" end = "${endPage}">    
                                    <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="${way}?index=${i}&filter=${option}&search=${search}">${i}</a></li>
                                    </c:forEach>
                                <li class="page-item "><a class="page-link ${tag == endPage?"hidden":""}"href="${way}?index=${tag + 1}&filter=${option}&search=${search}">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<!--</div>-->
<!-- About End -->



<!-- Courses End -->




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    //        function searchByName(param) {
    //            var txtSearch = param.value;
    //            $.ajax({
    //                url: "/SWP391_SE1706_G3/searchAjaxNewsClients",
    //                type: "get", //send it through get method
    //                data: {
    //                    txt: txtSearch
    //                },
    //                success: function (list) {
    //                    var row = document.getElementById("titleSearch");
    //                    row.innerHTML = list;
    //    
    //                },
    //                error: function (xhr) {
    //    //Do Something to handle error
    //                }
    //            }
    //            );
    //        }

    function search(index) {
        var search = $("#search").val();
        var filter = $("#filter").val();
        var entry = $("#entry").val();
        console.log(entry);

        $.ajax({
            url: "searchAjaxNewsClients",
            data: {search: search, filter: filter, index: index},
            type: "GET",
            success: function (data) {
                var searchList = document.getElementById('titleSearch');
                searchList.innerHTML = data;
                document.addEventListener('DOMContentLoaded', deleteCheckedBoxes());
                //                        document.getElementById('clear').innerHTML = "";
            }
        });
    }

    $(document).ready(function () {
        //                document.addEventListener('DOMContentLoaded', deleteCheckedBoxes());

        $("#search").on("keyup", function () {
            search(-1);
        });

        $("#entry").on("change", function () {
            search(-1);
        });

        $('button[name="pageLink"]').click(function () {
            var pageIndex = $(this).val();
            search(pageIndex);
        });
    });

</script>


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