

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Admin" %>
<%@page import="Model.Order" %>
<%@page buffer="8192kb" autoFlush="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Order Manage</title>

        <!-- Google Font: Source Sans Pro -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
        <!-- overlayScrollbars -->
        <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        <!-- Template Stylesheet -->
        <link href="cssTable/style.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/db2444237b.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">           
        <link href="css/pagination.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    </head>
    <body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
        <div class="wrapper">

            <!--add hieu ung bang stat-->
            <!-- admin start -->
            <!-- hi?u ?ng js -->
            <script>
                $(document).ready(function () {
                    // Activate tooltip
                    $('[data-toggle="tooltip"]').tooltip();

                    // Select/Deselect checkboxes
                    var checkbox = $('table tbody input[type="checkbox"]');
                    $("#selectAll").click(function () {
                        if (this.checked) {
                            checkbox.each(function () {
                                this.checked = true;
                            });
                        } else {
                            checkbox.each(function () {
                                this.checked = false;
                            });
                        }
                    });
                    checkbox.click(function () {
                        if (!this.checked) {
                            $("#selectAll").prop("checked", false);
                        }
                    });
                });
            </script>
            <script>
                function searchChange(name) {
                    if (name === "OrderDate") {
                        document.getElementById("searchinput").style.display = "inline";
                        document.getElementById("truefalse").style.display = "none";
                        document.getElementById("status").style.display = "none";
                        document.getElementById("searchinput").type = "date";
                    }
                    if (name === "all" || name === "UserName" || name === "orderID") {
                        document.getElementById("searchinput").style.display = "inline";
                        document.getElementById("truefalse").style.display = "none";
                        document.getElementById("status").style.display = "none";
                        document.getElementById("searchinput").type = "text";
                    }
                    if (name === "payment") {
                        document.getElementById("truefalse").style.display = "inline";
                        document.getElementById("searchinput").style.display = "none";
                        document.getElementById("status").style.display = "none";
                    }
                    if (name === "status") {
                        document.getElementById("truefalse").style.display = "none";
                        document.getElementById("searchinput").style.display = "none";
                        document.getElementById("status").style.display = "inline";
                    }
                }
                ;
                function change() {
                    document.getElementById("sort").submit();
                }
            </script>

            <!-- hieu ung js end -->

            <!--add hieu ung bang end-->

            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="adminhome.jsp
                           "  class="nav-link">Home</a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="profile?username=${cookie.username.value}" class="nav-item nav-link">${cookie.username.value}</a>
                    </li>
                </ul>

                <!-- Right navbar links -->
                <ul class="navbar-nav ml-auto">
                    <!-- Navbar Search -->
                    <li class="nav-item">
                        <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                            <i class="fas fa-search"></i>
                        </a>
                        <div class="navbar-search-block">
                            <form class="form-inline">
                                <div class="input-group input-group-sm">
                                    <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                                    <div class="input-group-append">
                                        <button class="btn btn-navbar" type="submit">
                                            <i class="fas fa-search"></i>
                                        </button>
                                        <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                            <i class="fas fa-times"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Messages Dropdown Menu -->
                    <li class="nav-item dropdown">
                        <a class="nav-link" data-toggle="dropdown" href="#">
                            <i class="far fa-comments"></i>
                            <span class="badge badge-danger navbar-badge">3</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                            <a href="#" class="dropdown-item">
                                <!-- Message Start -->
                                <div class="media">
                                    <img src="dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            Brad Diesel
                                            <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">Call me whenever you can...</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                <!-- Message End -->
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <!-- Message Start -->
                                <div class="media">
                                    <img src="dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            John Pierce
                                            <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">I got your message bro</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                <!-- Message End -->
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <!-- Message Start -->
                                <div class="media">
                                    <img src="dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
                                    <div class="media-body">
                                        <h3 class="dropdown-item-title">
                                            Nora Silvester
                                            <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                        </h3>
                                        <p class="text-sm">The subject goes here</p>
                                        <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                                    </div>
                                </div>
                                <!-- Message End -->
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                        </div>
                    </li>
                    <!-- Notifications Dropdown Menu -->
                    <li class="nav-item dropdown">
                        <a class="nav-link" data-toggle="dropdown" href="#">
                            <i class="far fa-bell"></i>
                            <span class="badge badge-warning navbar-badge">15</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                            <span class="dropdown-item dropdown-header">15 Notifications</span>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-envelope mr-2"></i> 4 new messages
                                <span class="float-right text-muted text-sm">3 mins</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-users mr-2"></i> 8 friend requests
                                <span class="float-right text-muted text-sm">12 hours</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item">
                                <i class="fas fa-file mr-2"></i> 3 new reports
                                <span class="float-right text-muted text-sm">2 days</span>
                            </a>
                            <div class="dropdown-divider"></div>
                            <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                            <i class="fas fa-expand-arrows-alt"></i>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                            <i class="fas fa-th-large"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.navbar -->

            <!-- Main Sidebar Container -->
            <aside class="main-sidebar sidebar-dark-primary elevation-4">
                <!-- Brand Logo -->
                <a href="adminhome.jsp
                   " class="brand-link">
                    <img src="dist/img/AdminLTELogo.png" alt="" class="brand-image img-circle elevation-3" style="opacity: .8">
                    <span class="brand-text font-weight-light">E-Learning</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                        </div>
                        <div class="info">
                           <a href="profile?username=${cookie.username.value}" class="nav-item nav-link">${cookie.username.value}</a>
                        </div>
                    </div>

                    <!-- SidebarSearch Form -->
                    <div class="form-inline">
                        <div class="input-group" data-widget="sidebar-search">
                            <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-sidebar">
                                    <i class="fas fa-search fa-fw"></i>
                                </button>
                            </div>
                        </div>
                    </div>

                    <!-- Sidebar Menu -->
                    <!--                   
                    <%@include  file="sidebar.jsp" %>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->

            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Projects</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">Projects</li>
                                </ol>

                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">

                    <!-- Default box -->

                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Projects</h3>

                            <div class="card-tools">

                            </div>
                        </div>

                        <form method = "post" action="ordermanage" class="form-control-lg">
                            <label class="col-1" for="SearchBy">Search by </label>
                            <select class="form-control form-select-sm col-2" name="criteria" id="SearchBy"  class="form-select select2-dropdown--below" onchange="searchChange(this.value)" class="" style="display:inline;text-align: center">
                                <option value ="all" selected>
                                    All
                                </option>
                                <option value ="OrderDate">
                                    Date
                                </option>
                                <option value ="UserName">
                                    User Name
                                </option>
                                <option value ="orderID">
                                    Order ID
                                </option>
                                <option value ="payment">
                                    Payment Status
                                </option>
                                <option value ="status">
                                    Order Status
                                </option>
                            </select>
                            <input class="form-control form-select-sm col-3"type="text" readonly name="sort" value="${sort}" style="display:none">

                            <input class="form-control form-select-sm col-3" id = "searchinput" type="text" name="keyword" style="display:inline;">
                            <select class="form-control form-select-sm col-3" name="keywordpayment" id="truefalse" style="display:none;" >
                                <option value="true">
                                    True
                                </option>
                                <option value="false">
                                    False
                                </option>
                            </select>
                            <select class="form-control form-select-sm col-3" name="keywordstatus" id="status" style="display:none;" >
                                <option value="approved">
                                    Approved
                                </option>
                                <option value="canceled">
                                    Canceled
                                </option>
                                <option value="delivered">
                                    Delivered
                                </option>
                                <option value="delivering">
                                    Delivering
                                </option>
                            </select>
                            <button class="btn btn-default"style="margin-bottom: 0.25%" type="submit"> <i class="fa fa-search"></i></button>
                        </form>
                        <form class="form-control-lg" id ="sort" action="ordermanage?searched=${searched}&&criteria=${criteria}&&keyword=${keyword}&&keywordpayment=${keywordpayment}&&keywordstatus=${keywordstatus}" method="post">
                            <label class="col-1" for="SortBy">Sort By </label>
                            <select class="form-control form-select-sm col-2" id="SortBY" name="sort" onchange="change()" class="select2-dropdown--below" style="display:inline;text-align: center">
                                <option value="OrderID">
                                    Order ID
                                </option>
                                <option value="OrderDate">
                                    Date 
                                </option>
                                <option value="Totalprice">
                                    Price
                                </option>
                            </select>
                        </form>
                        <div class="card-body p-0">
                            <table class="table table-striped projects" style='text-align: center'>
                                <thead>
                                    <tr>
                                        <th style="width: 1%">
                                            OrderID 
                                        </th>
                                        <th style="width: 20%">
                                            User Name
                                        </th>
                                        <th style="width: 20%">
                                            Order Date
                                        </th>
                                        <th style="width: 5%">
                                            Payment Status
                                        </th>
                                        <th style="width: 10%" class="text-center">
                                            Order Status
                                        </th>
                                        <th style="width: 20%">
                                            Full Price
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.data}" var="item">
                                        <tr>
                                            <td>
                                                ${item.getOrderID()}
                                            </td>
                                            <td>
                                                ${item.getUserName()}
                                            </td>
                                            <td>
                                                ${item.getOrderDate()}
                                            </td>
                                            <td class="project-state">
                                                ${item.isCheckPaymentStatus()}
                                            </td>
                                            <td>
                                                ${item.getStatus()}
                                            </td>
                                            <td>
                                                ${item.getTotalPrice()}
                                            </td>
                                            <td class="project-actions text-right " style='width: 15%'>

                                                <a class="btn btn-info btn-sm" style="display:inline-block;color: #ffffff;width:30%" href="ordermanage?mode=approve&&orderID=${item.getOrderID()}&&sort=${sort}">
                                                    <i class="fas fa-pencil">
                                                    </i>
                                                </a>
                                                <a class="btn btn-danger btn-sm" style="display:inline-block;color: #ffffff;width:30%" href="ordermanage?mode=cancel&&orderID=${item.getOrderID()}&&sort=${sort}">
                                                    <i class="fas fa-trash">
                                                    </i>

                                                </a>
                                                <a  class="btn btn-dark btn-sm" style="display:inline-block;color: #ffffff;width:30%;background-color: #15d518;border-color:#15d518 " href="ordermanage?mode=viewdetails&&orderID=${item.getOrderID()}">
                                                    <i class="fas fa-info" aria-hidden="true"></i>
                                                </a>
                                                    <form method="post" action="export?mode=excel" target="_blank"  style="display:inline-block;text-align: center">
                                                    <input style="display:none" type="text" readonly name="orderID" value="${item.getOrderID()}">
                                                    <button class="btn btn-dark  btn-sm" style="text-align: center;width: 100%;margin-right: 1%;margin-top: 4%;" type="submit">
                                                        <i class="fas fa-file-excel" style="color: #15d518;"></i>                                                        </button>
                                                </form>
                                                    <form method="post" action="export?mode=pdf" target="_blank" style="display:inline-block;text-align: center">
                                                    <input style="display:none" type="text" readonly name="orderID" value="${item.getOrderID()}">
                                                    <button class="btn btn-dark  btn-sm" style="text-align: center;width: 100%;margin-right: 1%;margin-top: 4%;" type="submit">
                                                        <i class="fas fa-file-pdf" style="color: #ec3413;"></i>                                                        </button>
                                                </form>  
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->

                </section>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item "><a class="page-link ${tag == 1?"hidden":""}" href="ordermanage?index=${tag - 1}&&sort=${sort}&&searched=${searched}&&criteria=${criteria}&&keyword=${keyword}&&keywordpayment=${keywordpayment}&&keywordstatus=${keywordstatus}">Previous</a></li>
                            <c:forEach begin ="1" var="i" end = "${endPage}">    
                            <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="ordermanage?index=${i}&&sort=${sort}&&searched=${searched}&&criteria=${criteria}&&keyword=${keyword}&&keywordpayment=${keywordpayment}&&keywordstatus=${keywordstatus}">${i}</a></li>
                            </c:forEach>
                        <li class="page-item "><a class="page-link ${tag == endPage?"hidden":""}"  href="ordermanage?index=${tag + 1}&&sort=${sort}&&searched=${searched}&&criteria=${criteria}&&keyword=${keyword}&&keywordpayment=${keywordpayment}&&keywordstatus=${keywordstatus}">Next</a></li>
                    </ul>
                </nav>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">

            </footer>

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->
        </div>
        <!-- ./wrapper -->

        <!-- jQuery -->
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
                                $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 4 -->
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- overlayScrollbars -->
        <script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.js"></script>
        <!-- AdminLTE for demo purposes -->
        <!--<script src="dist/js/demo.js"></script>-->
    </body>
</html>

