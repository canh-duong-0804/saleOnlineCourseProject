
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList" %>
<%@page  import="Model.News" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
        <!-- overlayScrollbars -->
        <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
        <!-- summernote -->
        <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
        <link rel="stylesheet" href="css/CourseBookHomePage.css">
        
          <title>CourseProcess</title>
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
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <link href="css/searchbar.css" rel="stylesheet">

        <!-- Template Javascript -->
        <script src="js/register.js"></script>
        <!-- header -->
        <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
            <a href="index.html" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
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
                        <a href="homePage" class="nav-item nav-link active">Home</a>
                        <a href="about.html" class="nav-item nav-link">About</a>
                        <a href="displayCourse" class="nav-item nav-link">Courses</a>
                        <a href="learningPath" class="nav-item nav-link">Learning path</a> 
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                        <a href="contact.html" class="nav-item nav-link">Register</a>
                    </div>
                    <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block">Login Now<i class="fa fa-arrow-right ms-3"></i></a>
                </div>
        </nav>
        <!-- header End -->
    </head>
    
    <body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
        <div class="container">
            <div class="bg-white rounded d-flex align-items-center justify-content-between" id="header"> <button
                    class="btn btn-hide text-uppercase" type="button" data-toggle="collapse" data-target="#filterbar"
                    aria-expanded="false" aria-controls="filterbar" id="filter-btn" onclick="changeBtnTxt()"> <span
                        class="fas fa-angle-left" id="filter-angle"></span> <span id="btn-txt">Hide filters</span> </button>
                <nav class="navbar navbar-expand-lg navbar-light pl-lg-0 pl-auto"> <button class="navbar-toggler" type="button"
                                                                                           data-toggle="collapse" data-target="#mynav" aria-controls="mynav" aria-expanded="false"
                                                                                           aria-label="Toggle navigation" onclick="chnageIcon()" id="icon"> <span
                            class="navbar-toggler-icon"></span> </button>
                    <div class="collapse navbar-collapse" id="mynav">
                        <ul class="navbar-nav d-lg-flex align-items-lg-center">
                            <li class="nav-item active"> <select name="sort" id="sort">
                                    <option value="" hidden selected>Sort by</option>
                                    <option value="price">Price</option>
                                    <option value="popularity">Popularity</option>
                                    <option value="rating">Rating</option>
                                </select> </li>
                            <li class="nav-item d-inline-flex align-items-center justify-content-between mb-lg-0 mb-3">
                                <div class="d-inline-flex align-items-center mx-lg-2" id="select2">
                                    <div class="pl-2">Products:</div> <select name="pro" id="pro">
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                    </select>
                                </div>
                                <div class="font-weight-bold mx-2 result">18 from 200</div>
                            </li>
                            <li class="nav-item d-lg-none d-inline-flex"> </li>
                        </ul>
                    </div>
                </nav>
                <div class="ml-auto mt-3 mr-2">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"> <a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true"
                                                                                                              class="font-weight-bold">&lt;</span> <span class="sr-only">Previous</span> </a> </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">..</a></li>
                            <li class="page-item"><a class="page-link" href="#">24</a></li>
                            <li class="page-item"> <a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true"
                                                                                                          class="font-weight-bold">&gt;</span> <span class="sr-only">Next</span> </a> </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div id="content" class="my-5">
                <div id="filterbar" class="collapse">
                    <div class="box border-bottom">
                        <div class="form-group text-center">
                            <div class="btn-group" data-toggle="buttons"> <label class="btn btn-success form-check-label">
                                    <input class="form-check-input" type="radio"> Reset </label> <label
                                    class="btn btn-success form-check-label active"> <input class="form-check-input"
                                                                                        type="radio" checked> Apply </label> </div>
                        </div>
                        <div> <label class="tick">New <input type="checkbox" checked="checked"> <span class="check"></span>
                            </label> </div>
                        <div> <label class="tick">Sale <input type="checkbox"> <span class="check"></span> </label> </div>
                    </div>
                    <div class="box border-bottom">
                        <div class="box-label text-uppercase d-flex align-items-center">Outerwear <button class="btn ml-auto"
                                                                                                          type="button" data-toggle="collapse" data-target="#inner-box" aria-expanded="false"
                                                                                                          aria-controls="inner-box" id="out" onclick="outerFilter()"> <span class="fas fa-plus"></span>
                            </button> </div>
                        <div id="inner-box" class="collapse mt-2 mr-1">
                            <div class="my-1"> <label class="tick">Windbreaker <input type="checkbox" checked="checked"> <span
                                        class="check"></span> </label> </div>
                            <div class="my-1"> <label class="tick">Jumpsuit <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Jacket <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Coat <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Raincoat <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Handbag <input type="checkbox" checked> <span
                                        class="check"></span> </label> </div>
                            <div class="my-1"> <label class="tick">Warm vest <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Wallets <input type="checkbox" checked> <span
                                        class="check"></span> </label> </div>
                        </div>
                    </div>
                    <div class="box border-bottom">
                        <div class="box-label text-uppercase d-flex align-items-center">season <button class="btn ml-auto"
                                                                                                       type="button" data-toggle="collapse" data-target="#inner-box2" aria-expanded="false"
                                                                                                       aria-controls="inner-box2"><span class="fas fa-plus"></span></button> </div>
                        <div id="inner-box2" class="collapse mt-2 mr-1">
                            <div class="my-1"> <label class="tick">Spring <input type="checkbox" checked="checked"> <span
                                        class="check"></span> </label> </div>
                            <div class="my-1"> <label class="tick">Summer <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Autumn <input type="checkbox" checked> <span
                                        class="check"></span> </label> </div>
                            <div class="my-1"> <label class="tick">Winter <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                            <div class="my-1"> <label class="tick">Rainy <input type="checkbox"> <span class="check"></span>
                                </label> </div>
                        </div>
                    </div>
                    <div class="box border-bottom">
                        <div class="box-label text-uppercase d-flex align-items-center">price <button class="btn ml-auto"
                                                                                                      type="button" data-toggle="collapse" data-target="#price" aria-expanded="false"
                                                                                                      aria-controls="price"><span class="fas fa-plus"></span></button> </div>
                        <div class="collapse" id="price">
                            <div class="middle">
                                <div class="multi-range-slider"> <input type="range" id="input-left" min="0" max="100"
                                                                        value="10"> <input type="range" id="input-right" min="0" max="100" value="50">
                                    <div class="slider">
                                        <div class="track"></div>
                                        <div class="range"></div>
                                        <div class="thumb left"></div>
                                        <div class="thumb right"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-2">
                                <div> <span id="amount-left" class="font-weight-bold"></span> uah </div>
                                <div> <span id="amount-right" class="font-weight-bold"></span> uah </div>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-label text-uppercase d-flex align-items-center">size <button class="btn ml-auto"
                                                                                                     type="button" data-toggle="collapse" data-target="#size" aria-expanded="false"
                                                                                                     aria-controls="size"><span class="fas fa-plus"></span></button> </div>
                        <div id="size" class="collapse">
                            <div class="btn-group d-flex align-items-center flex-wrap" data-toggle="buttons"> <label
                                    class="btn btn-success form-check-label"> <input class="form-check-input" type="checkbox">
                                    80 </label> <label class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                                    type="checkbox" checked> 92 </label> <label class="btn btn-success form-check-label">
                                    <input class="form-check-input" type="checkbox" checked> 102 </label> <label
                                    class="btn btn-success form-check-label"> <input class="form-check-input" type="checkbox"
                                                                                 checked> 104 </label> <label class="btn btn-success form-check-label"> <input
                                        class="form-check-input" type="checkbox" checked> 106 </label> <label
                                    class="btn btn-success form-check-label"> <input class="form-check-input" type="checkbox"
                                                                                 checked> 108 </label> </div>
                        </div>
                    </div>
                </div>
                <div id="products">
                    <div class="row mx-0">
                        <div class="col-lg-4 col-md-6">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name">Torn Jeans for Men</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/jeans-png/jeans-mens-pants-cliparts-download-clip-art-37.png"
                                        alt=""> </div>
                                <div class="card-body pt-5">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-red form-check-label"> <input class="form-check-input"
                                                                                         type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-blue form-check-label active"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-green form-check-label"> <input class="form-check-input"
                                                                                           type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-orange form-check-label"> <input class="form-check-input"
                                                                                            type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-pink form-check-label"> <input class="form-check-input"
                                                                                          type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center price">
                                        <div class="del mr-2"><span class="text-dark">5500 uah</span></div>
                                        <div class="font-weight-bold">4500 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 pt-md-0 pt-3">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name">Nike Tshirts for Men</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/t-shirt-png/t-shirt-png-printed-shirts-south-africa-20.png"
                                        alt="" height="100" id="shirt"> </div>
                                <div class="text-muted text-center mt-auto">Available Sizes</div>
                                <div id="avail-size">
                                    <div class="btn-group d-flex align-items-center flex-wrap" data-toggle="buttons"> <label
                                            class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                         type="checkbox"> 80 </label> <label class="btn btn-success form-check-label">
                                            <input class="form-check-input" type="checkbox" checked> 92 </label> <label
                                            class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                         type="checkbox" checked> 102 </label> <label
                                            class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                         type="checkbox" checked> 104 </label> <label
                                            class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                         type="checkbox" checked> 106 </label> <label
                                            class="btn btn-success form-check-label"> <input class="form-check-input"
                                                                                         type="checkbox" checked> 108 </label> </div>
                                </div>
                                <div class="card-body pt-0">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-light border form-check-label"> <input class="form-check-input"
                                                                                                  type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-blue form-check-label active"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-green form-check-label"> <input class="form-check-input"
                                                                                           type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-orange form-check-label"> <input class="form-check-input"
                                                                                            type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-pink form-check-label"> <input class="form-check-input"
                                                                                          type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center price">
                                        <div class="del mr-2"><span class="text-dark">5500 uah</span></div>
                                        <div class="font-weight-bold">4500 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 pt-lg-0 pt-md-4 pt-3">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name text-center">Casual Dress Belts For Men</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/belts-png/casual-dress-belts-for-men-28.png"
                                        alt=""> </div>
                                <div class="card-body pt-5">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-dark border form-check-label"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-brown form-check-label active"> <input class="form-check-input"
                                                                                                  type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center price">
                                        <div class="font-weight-bold">500 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 pt-md-4 pt-3">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name text-center">Footwear For Women</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/women-shoes-png/download-women-shoes-png-image-png-image-pngimg-2.png"
                                        alt=""> </div>
                                <div class="card-body pt-5">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-dark border form-check-label"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-brown form-check-label active"> <input class="form-check-input"
                                                                                                  type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-pink form-check-label"> <input class="form-check-input"
                                                                                          type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-red form-check-label"> <input class="form-check-input"
                                                                                         type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center price">
                                        <div class="font-weight-bold">1500 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 pt-md-4 pt-3">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name text-center">Nike Jogging shoes For Men</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/shoes-png/find-your-perfect-running-shoes-26.png"
                                        alt=""> </div>
                                <div class="card-body pt-5">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-dark border form-check-label"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-pink form-check-label active"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-blue form-check-label"> <input class="form-check-input"
                                                                                          type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-orange form-check-label"> <input class="form-check-input"
                                                                                            type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center price">
                                        <div class="font-weight-bold">1200 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 pt-md-4 pt-3">
                            <div class="card d-flex flex-column align-items-center">
                                <div class="product-name text-center">Leather Wallets For Men</div>
                                <div class="card-img"> <img
                                        src="https://www.freepnglogos.com/uploads/money-png/money-wallet-dollar-image-money-pictures-download-27.png"
                                        alt=""> </div>
                                <div class="card-body pt-5">
                                    <div class="text-muted text-center mt-auto">Available Colors</div>
                                    <div class="d-flex align-items-center justify-content-center colors my-2">
                                        <div class="btn-group" data-toggle="buttons" data-tooltip="tooltip"
                                             data-placement="right" title="choose color"> <label
                                                class="btn btn-dark border form-check-label"> <input class="form-check-input"
                                                                                                 type="radio" autocomplete="off"> </label> <label
                                                class="btn btn-brown form-check-label active"> <input class="form-check-input"
                                                                                                  type="radio" autocomplete="off"> </label> </div>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-center price">
                                        <div class="font-weight-bold">900 uah</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>





        <!-- ./wrapper -->
        <!-- jQuery -->
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
                                                                                                              $.widget.bridge('uibutton', $.ui.button)
        </script>
        <!-- Bootstrap 4 -->
        <script src="./js/jsShowCourseBookHomepage.js"></script>
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- overlayScrollbars -->
        <script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
    </body>
</html>
