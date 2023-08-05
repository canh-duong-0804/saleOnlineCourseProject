<%-- 
    Document   : userProfile.jsp
    Created on : May 20, 2023, 5:24:17 PM
    Author     : TUF F15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AdminLTE 3 | User Profile</title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="./plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="./dist/css/adminlte.min.css">
        <link rel="stylesheet" href="./css/profile.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

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
    <body class="hold-transition sidebar-mini">
        <div class="wrapper">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
                <a href="adminhome.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
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


                        <form>
                            <div class="SearchBox">
                                <input type="text" class="SearchBox-input" style="color: black;" placeholder="BUSCA ALGO COOL">

                                <button class="SearchBox-button">
                                    <i class="SearchBox-icon  material-icons">search</i>
                                </button>

                            </div>
                        </form>

                    </main>

                    <!--search bar end-->
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <div class="navbar-nav ms-auto p-4 p-lg-0">
                            
                            <a href="forgot" class="nav-item nav-link">Logout</a>
                        </div>

                    </div>
            </nav>
            <!-- /.navbar -->



            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Profile</h1>
                            </div>

                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-3">

                                <!-- Profile Image -->
                                <div class="card card-primary card-outline">
                                    <div class="card-body box-profile">
                                        <div class="text-center">
                                            <img class="profile-user-img img-fluid img-circle"
                                                 src="./img/${userInfo.getImage()}"
                                                 alt="User profile picture">
                                        </div>

                                        <h3 class="profile-username text-center">${userInfo.getaName()}</h3>

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
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->

                                <!-- About Me Box -->
                                <div class="card card-primary">
                                    <div class="card-header">
                                        <h3 class="card-title">Information</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body">
                                        <strong><i class="fas fa-book mr-1"></i>Total Course </strong>

                                        <p class="text-muted">
                                            B.S. in Computer Science from the University of Tennessee at Knoxville
                                        </p>

                                        <hr>

                                        <strong><i class="fas fa-map-marker-alt mr-1"></i> Location</strong>

                                        <p class="text-muted">Malibu, California</p>

                                        <hr>

                                        <strong><i class="fas fa-pencil-alt mr-1"></i> Skills</strong>

                                        <p class="text-muted">
                                            <span class="tag tag-danger">UI Design</span>
                                            <span class="tag tag-success">Coding</span>
                                            <span class="tag tag-info">Javascript</span>
                                            <span class="tag tag-warning">PHP</span>
                                            <span class="tag tag-primary">Node.js</span>
                                        </p>

                                        <hr>

                                        <strong><i class="far fa-file-alt mr-1"></i> Notes</strong>

                                        <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
                                    </div>
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->
                            </div>
                            <!-- /.col -->
                            <div class="col-md-9">
                                <div class="card">
                                    <div class="card-header p-2">
                                        <ul class="nav nav-pills">
                                            <!-- <li class="nav-item"><a class="nav-link active" href="#activity" data-toggle="tab">Activity</a></li> -->
                                            <!-- <li class="nav-item"><a class="nav-link" href="#timeline" data-toggle="tab">Timeline</a></li> -->
                                            <li class="nav-item"><a class="nav-link" href="#" data-target="#settings" data-toggle="tab">Settings</a></li>
                                            <li class="nav-item"><a class="nav-link" href="#" data-target="#timeline" data-toggle="tab">TimeLine</a></li>
                                        </ul>
                                    </div><!-- /.card-header -->
                                    <div class="card-body">
                                        <div class="tab-content">

                                            <!-- /.tab-pane -->

                                            <div class="active tab-pane" id="settings">
                                                <form action="profile" method="post" class="form-horizontal" enctype='multipart/form-data'>
                                                    <div class="form-group row">
                                                        <label for="inputName" class="col-sm-2 col-form-label">UserName</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control0" name="username" value="${userInfo.getaUsername()}" id="inputName" placeholder="UserName" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputName" class="col-sm-2 col-form-label">Name</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="name" value="${userInfo.getaName()}" id="inputName" placeholder="Name">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                                        <div class="col-sm-10">
                                                            <input type="email" class="form-control" name="email" value="${userInfo.getaEmail()}" id="inputEmail" placeholder="Email">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputName2" class="col-sm-2 col-form-label">Phone</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" name="phone" value="${userInfo.getaPhone()}" id="inputName2" placeholder="Phone">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputExperience" class="col-sm-2 col-form-label">Address</label>
                                                        <div class="col-sm-10">
                                                            <textarea class="form-control" id="inputExperience" name="address" placeholder="Experience">${userInfo.getaAddress()}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputSkills" class="col-sm-2 col-form-label">Date of Birth</label>
                                                        <div class="col-sm-10">
                                                            <input type="date" value="${userInfo.getaDob()}" name="dob" class="form-control" id="inputSkills">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="inputSkills" class="col-sm-2 col-form-label">Description</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" value="${userInfo.getaDescription()}" name="description" class="form-control" id="inputSkills">
                                                        </div>
                                                    </div>
                                                    <div class="container">

                                                        <div class="avatar-upload">
                                                            <div class="avatar-edit">
                                                                <input type='file' id="imageUpload" name="image" class="image" accept=".png, .jpg, .jpeg" />
                                                                <label class="icons" for="imageUpload"><i class="material-icons">create</i></label>
                                                            </div>
                                                            <div class="avatar-preview">
                                                                <div id="imagePreview" style="background-image: url(img/${userInfo.getImage()})">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    

                                                    <div class="form-group row">
                                                        <div class="offset-sm-2 col-sm-10">
                                                            <button type="submit" class="btn btn-danger">Update</button>
                                                        </div>
                                                    </div>
                                                                <p style="color:red;">${alert}</p>
                                                </form>
                                            </div>
                                            <div class="tab-pane" id="timeline">
                                                <!-- The timeline -->
                                                <div class="timeline timeline-inverse">
                                                    <!-- timeline time label -->
                                                    <div class="time-label">
                                                        <span class="bg-danger">
                                                            10 Feb. 2014
                                                        </span>
                                                    </div>
                                                    <!-- /.timeline-label -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i class="fas fa-envelope bg-primary"></i>

                                                        <div class="timeline-item">
                                                            <span class="time"><i class="far fa-clock"></i> 12:05</span>

                                                            <h3 class="timeline-header"><a href="#">Support Team</a> sent you an email</h3>

                                                            <div class="timeline-body">
                                                                Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles,
                                                                weebly ning heekya handango imeem plugg dopplr jibjab, movity
                                                                jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle
                                                                quora plaxo ideeli hulu weebly balihoo...
                                                            </div>
                                                            <div class="timeline-footer">
                                                                <a href="#" class="btn btn-primary btn-sm">Read more</a>
                                                                <a href="#" class="btn btn-danger btn-sm">Delete</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i class="fas fa-user bg-info"></i>

                                                        <div class="timeline-item">
                                                            <span class="time"><i class="far fa-clock"></i> 5 mins ago</span>

                                                            <h3 class="timeline-header border-0"><a href="#">Sarah Young</a> accepted your friend request
                                                            </h3>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i class="fas fa-comments bg-warning"></i>

                                                        <div class="timeline-item">
                                                            <span class="time"><i class="far fa-clock"></i> 27 mins ago</span>

                                                            <h3 class="timeline-header"><a href="#">Jay White</a> commented on your post</h3>

                                                            <div class="timeline-body">
                                                                Take me to your leader!
                                                                Switzerland is small and neutral!
                                                                We are more like Germany, ambitious and misunderstood!
                                                            </div>
                                                            <div class="timeline-footer">
                                                                <a href="#" class="btn btn-warning btn-flat btn-sm">View comment</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <!-- timeline time label -->
                                                    <div class="time-label">
                                                        <span class="bg-success">
                                                            3 Jan. 2014
                                                        </span>
                                                    </div>
                                                    <!-- /.timeline-label -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i class="fas fa-camera bg-purple"></i>

                                                        <div class="timeline-item">
                                                            <span class="time"><i class="far fa-clock"></i> 2 days ago</span>

                                                            <h3 class="timeline-header"><a href="#">Mina Lee</a> uploaded new photos</h3>

                                                            <div class="timeline-body">
                                                                <img src="https://placehold.it/150x100" alt="...">
                                                                <img src="https://placehold.it/150x100" alt="...">
                                                                <img src="https://placehold.it/150x100" alt="...">
                                                                <img src="https://placehold.it/150x100" alt="...">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <div>
                                                        <i class="far fa-clock bg-gray"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- /.tab-pane -->
                                        </div>
                                        <!-- /.tab-content -->
                                    </div><!-- /.card-body -->
                                </div>
                                <!-- /.card -->
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                    </div><!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
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
                        <div class="col-lg-3 col-md-6">
                            <h4 class="text-white mb-3">Newsletter</h4>
                            <p>The best course provider in your area</p>
                            <div class="position-relative mx-auto" style="max-width: 400px;">
                                <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                                <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="copyright">
                        <div class="row">
                            <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved.

                                <!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
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
                </div>
            </div>
            <!-- Footer End -->

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->
        </div>
        <!-- ./wrapper -->

        <!-- jQuery -->
        <script src="./plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap 4 -->
        <script src="./plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE App -->
        <script src="./dist/js/adminlte.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <!--<script src="../../dist/js/demo.js"></script>-->
        <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
                        $('#imagePreview').hide();
                        $('#imagePreview').fadeIn(650);
                    }
                    reader.readAsDataURL(input.files[0]);
                }
            }
            $("#imageUpload").change(function () {
                readURL(this);
            });
        </script>
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

