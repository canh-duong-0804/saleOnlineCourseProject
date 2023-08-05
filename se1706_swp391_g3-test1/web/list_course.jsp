<%-- 
    Document   : list_course
    Created on : May 15, 2023, 2:51:02 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>TEAM3</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon" />

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap"
      rel="stylesheet"
    />

    <!-- Icon Font Stylesheet -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet" />
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min_listcourse.css" rel="stylesheet" />

    <!-- Template Stylesheet -->
    <link href="css/list_course.css" rel="stylesheet" />
  </head>
  <body>
    <!-- Page Preloder -->
    <div id="preloder">
      <div class="loader"></div>
    </div>
    <!-- Navbar Start -->
    <nav
      class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0"
    >
      <a
        href="index.html"
        class="navbar-brand d-flex align-items-center px-4 px-lg-5"
      >
        <h2 class="m-0 text-primary">
          <i class="fa fa-book me-3"></i>eLEARNING
        </h2>
      </a>
      <button
        type="button"
        class="navbar-toggler me-4"
        data-bs-toggle="collapse"
        data-bs-target="#navbarCollapse"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto p-4 p-lg-0">
          <a href="index.html" class="nav-item nav-link">Home</a>
          <a href="about.html" class="nav-item nav-link">About</a>
          <a href="list_course.jsp" class="nav-item nav-link active"
            >Lộ trình học</a
          >
          <div class="nav-item dropdown">
            <a
              href="#"
              class="nav-link dropdown-toggle"
              data-bs-toggle="dropdown"
              >Pages</a
            >
            <div class="dropdown-menu fade-down m-0">
              <a href="team.html" class="dropdown-item">Our Team</a>
              <a href="testimonial.html" class="dropdown-item">Testimonial</a>
              <a href="404.html" class="dropdown-item">404 Page</a>
            </div>
          </div>
          <a href="contact.html" class="nav-item nav-link">Contact</a>
        </div>
        <a href="" class="btn btn-primary py-4 px-lg-5 d-none d-lg-block"
          >Join Now<i class="fa fa-arrow-right ms-3"></i
        ></a>
      </div>
    </nav>
    <!-- Navbar End -->
    <!-- menu dọc trái -->

    <!-- Shop Start -->
    <div class="container-fluid pt-5">
      <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-md-2 float mt-5 ms-3 col-sm-12 col-xs-12 category">
          <aside >
              <div class="menu">
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
              <div class="menu">
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

        <div class="col-lg-9 col-md-12">
          <div class="row pb-3">
            <div class="col-12 pb-1">
              <div
                class="d-flex align-items-center justify-content-between mb-4"
              >
                <form action="">
                  <div class="input-group">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Search by name"
                    />
                    <div class="input-group-append">
                      <span
                        class="input-group-text bg-transparent text-primary"
                      >
                        <i class="fa fa-search"></i>
                      </span>
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
              <div class="card product-item border-0 mb-4">
                <div
                  class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                >
                  <img class="img-fluid w-100" src="img/Hoa-hoc-8.jpg" alt="" />
                </div>
                <div
                  class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                >
                  <h6 class="text-truncate mb-3">Chemistry 8</h6>
                  <div class="d-flex justify-content-center">
                    <h6></h6>
                    <h6 class="text-muted ml-2"></h6>
                  </div>
                </div>
                <div
                  class="card-footer d-flex justify-content-between bg-light border"
                >
                  <a href="" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                  >
                  <a href="" class="btn btn-sm text-dark p-0"><i></i></a>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
              <div class="card product-item border-0 mb-4">
                <div
                  class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                >
                  <img
                    class="img-fluid w-100"
                    src="img/325203dccb43c6e425ef9e2bcae6c4c5.jpg"
                    alt=""
                  />
                </div>
                <div
                  class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                >
                  <h6 class="text-truncate mb-3">Combo 3 môn toán lí hóa 9</h6>
                  <div class="d-flex justify-content-center">
                    <!-- <h6>VND:300.000</h6>
                    <h6 class="text-muted ml-2"><del>500.000</del></h6> -->
                  </div>
                </div>
                <div
                  class="card-footer d-flex justify-content-between bg-light border"
                >
                  <a href="combo_1.jsp" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                  >
                  <!-- <a href="" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-shopping-cart text-primary mr-1"></i>Add
                    To Cart</a
                  > -->
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
              <div class="card product-item border-0 mb-4">
                <div
                  class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                >
                  <img
                    class="img-fluid w-100"
                    src="img/576aaea60ec505d3b9017d1d36c998de.jpg"
                    alt=""
                  />
                </div>
                <div
                  class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                >
                  <h6 class="text-truncate mb-3">Combo 3 môn Toán Anh Văn 9</h6>
                  <div class="d-flex justify-content-center">
                    <!-- <h6>VND:350.000</h6>
                    <h6 class="text-muted ml-2"><del>500.000</del></h6> -->
                  </div>
                </div>
                <div
                  class="card-footer d-flex justify-content-between bg-light border"
                >
                  <a href="combo_2.jsp" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                  >
                  <!-- <a href="" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-shopping-cart text-primary mr-1"></i>Add
                    To Cart</a
                  > -->
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
              <div class="card product-item border-0 mb-4">
                <div
                  class="card-header product-img position-relative overflow-hidden bg-transparent border p-0"
                >
                  <img
                    class="img-fluid w-100"
                    src="img/Toan-9-Tap-1.jpg"
                    alt=""
                  />
                </div>
                <div
                  class="card-body border-left border-right text-center p-0 pt-4 pb-3"
                >
                  <h6 class="text-truncate mb-3">Math 9</h6>
                  <div class="d-flex justify-content-center">
                    <!-- <h6>VND:450.000</h6> -->
                  </div>
                </div>
                <div
                  class="card-footer d-flex justify-content-between bg-light border"
                >
                  <a href="" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-eye text-primary mr-1"></i>View Detail</a
                  >
                  <!-- <a href="" class="btn btn-sm text-dark p-0"
                    ><i class="fas fa-shopping-cart text-primary mr-1"></i>Add
                    To Cart</a
                  > -->
                </div>
              </div>
            </div>
            <div class="col-12 pb-1">
              <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center mb-3">
                  <li class="page-item disabled">
                    <a class="page-link" href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
                  <li class="page-item active">
                    <a class="page-link" href="#">1</a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
        <!-- Shop Product End -->
      </div>
    </div>
    <!-- Shop End -->

    <!-- Footer Start -->
    <div
      class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn"
      data-wow-delay="0.1s"
    >
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
            <p class="mb-2">
              <i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA
            </p>
            <p class="mb-2">
              <i class="fa fa-phone-alt me-3"></i>+012 345 67890
            </p>
            <p class="mb-2">
              <i class="fa fa-envelope me-3"></i>info@example.com
            </p>
            <div class="d-flex pt-2">
              <a class="btn btn-outline-light btn-social" href=""
                ><i class="fab fa-twitter"></i
              ></a>
              <a class="btn btn-outline-light btn-social" href=""
                ><i class="fab fa-facebook-f"></i
              ></a>
              <a class="btn btn-outline-light btn-social" href=""
                ><i class="fab fa-youtube"></i
              ></a>
              <a class="btn btn-outline-light btn-social" href=""
                ><i class="fab fa-linkedin-in"></i
              ></a>
            </div>
          </div>
          <div class="col-lg-3 col-md-6">
            <h4 class="text-white mb-3">Gallery</h4>
            <div class="row g-2 pt-2">
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-1.jpg"
                  alt=""
                />
              </div>
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-2.jpg"
                  alt=""
                />
              </div>
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-3.jpg"
                  alt=""
                />
              </div>
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-2.jpg"
                  alt=""
                />
              </div>
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-3.jpg"
                  alt=""
                />
              </div>
              <div class="col-4">
                <img
                  class="img-fluid bg-light p-1"
                  src="img/course-1.jpg"
                  alt=""
                />
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6">
            <h4 class="text-white mb-3">Newsletter</h4>
            <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
            <div class="position-relative mx-auto" style="max-width: 400px">
              <input
                class="form-control border-0 w-100 py-3 ps-4 pe-5"
                type="text"
                placeholder="Your email"
              />
              <button
                type="button"
                class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2"
              >
                SignUp
              </button>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="copyright">
          <div class="row">
            <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
              &copy; <a class="border-bottom" href="#">Your Site Name</a>, All
              Right Reserved.

              <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
              Designed By
              <a class="border-bottom" href="https://htmlcodex.com"
                >HTML Codex</a
              ><br /><br />
              Distributed By
              <a class="border-bottom" href="https://themewagon.com"
                >ThemeWagon</a
              >
            </div>
            <div class="col-md-6 text-center text-md-end">
              <div class="footer-menu">
                <a href="">Home</a>
                <a href="">Cookies</a>
                <a href="">Help</a>
                <a href="">FQAs</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer End -->
    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
  </body>
</html>

