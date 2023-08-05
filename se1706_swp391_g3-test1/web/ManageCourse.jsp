<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  import="Model.Course" %>
<%@page  import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!--check box all-->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <!--css check box-->
        <link rel="stylesheet" href="./css/checkbox.css">
        <link href="css/pagination.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
        <div class="wrapper">

            <!-- Navbar -->
            <nav class="main-header navbar navbar-expand navbar-white navbar-light">
                <!-- Left navbar links -->
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
                    </li>
                    <li class="nav-item d-none d-sm-inline-block">
                        <a href="index3.jsp" class="nav-link">Home</a>
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
                <a href="adminhome.jsp" class="brand-link">
                    <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
                    <span class="brand-text font-weight-light">E-learning</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar">
                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                        <div class="image">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                        </div>
                        <div class="info">
                            <a href="profile?username=${user}">${user}</a>
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
                    <!--                    <nav class="mt-2">
                                            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                                                 Add icons to the links using the .nav-icon class
                                                     with font-awesome or any other icon font library 
                                                <li class="nav-item menu-open">
                                                    <a href="#" class="nav-link active">
                                                        <i class="nav-icon fas fa-tachometer-alt"></i>
                                                        <p>
                                                            Manage
                                                            <i class="right fas fa-angle-left"></i>
                                                        </p>
                                                    </a>
                                                    <ul class="nav nav-treeview">
                    
                    
                                                        <li class="nav-item">
                                                            <div class="nav-link">
                                                                <a href="readTeacher
                                                                   " >
                                                                    <i class="far fa-circle nav-icon"></i>
                                                                    <p>Verify the instructor account</p>
                    
                                                                </a>
                                                            </div>
                                                        </li>
                                                        <li class="nav-item">
                                                            <div class="nav-link">
                                                                <a href="coursecontroller
                                                                   " >
                                                                    <i class="far fa-circle nav-icon"></i>
                                                                    <p>Course Management</p>
                                                                </a>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </li>-->
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
                                <h1>Courses</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active">Courses</li>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="d-flex form-inputs">
                        <form action="searchcourse" method="POST">
                            <label for="validationCustom05">Search</label>
                            <input  class="form-control" type="text" name="search" ><!-- comment -->
                            <select id="option" name="option" class="custom-select mr-sm-2 ">
                                <option value="1">By Name</option>
                                <option value="2">By Creator</option>
                            </select>
                            <input class="btn btn-primary" type="submit" >

                        </form>
                    </div>
                    <!-- Default box -->

                    <div class="card">
                        <form action="coursedeleteselect" method="GET" >
                            <div class="card-header">
                                <h3 class="card-title">Course</h3>

                                <div class="card-tools">
                                    
                                    <a class="btn btn-primary btn-sm" href="AddCourse.jsp" title="Add Course">
                                        <i class="fas fa-plus">
                                        </i>

                                    </a>
                                    <a class="btn btn-dark btn-sm" href="processController" title="Process">
                                        <i class="fas fa-folder">
                                        </i>

                                    </a>

                                    <a class="btn btn-danger btn-sm" >
                                        <span><input type="submit" value="Delete" style="color: white;background-color: #dc3545;
                                                     border-color: #dc3545;border: 0px" onclick="return confirmDeleteSelect();"></span>
                                    </a>
                                </div>
                            </div>
                            <div class="card-body p-0">
                                <table class="table table-striped projects">
                                    <thead>
                                        <tr>
                                            <th style="width: 1%">
                                                <span class="custom-checkbox">
                                                    <input type="checkbox" id="selectAll">
                                                    <label for="selectAll"></label>
                                                </span>
                                            </th>
                                            <th style="width: 4%">
                                                ID
                                            </th>
                                            <th style="width: 15%">
                                                Course name
                                            </th>
                                            <th style="width: 10%">
                                                Course price
                                            </th>
                                            <th style="width: 5%" class="text-center">
                                                Discount
                                            </th>

                                            <th style="width: 20%" class="text-center">
                                                Course description
                                            </th>
                                            <th style="width: 10%" >
                                                Creator
                                            </th>
                                            <th style="width: 10%">
                                                Upload date
                                            </th>
                                            <th style="width: 20%">
                                                Actions
                                            </th>                                                    <th></th>

                                        </tr>
                                    </thead>





                                    <tbody>
                                        <c:forEach items="${data}" var="item">


                                            <tr>
                                                <td >
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options" value="${item.getCourseID()}">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>
                                                    ${item.getCourseID()}
                                                </td>
                                                <td>

                                                    ${item.getCourseName()}
                                                </td>
                                                <td>
                                                    ${item.getCoursePrice()}

                                                </td>
                                                <td class="text-center">
                                                    ${item.getDiscount()}%
                                                </td>
                                                <td class="text-center">
                                                    ${item.getCourseDescription()}
                                                </td>
                                                <td>
                                                    ${item.getAdminID()}
                                                </td>
                                                <td>
                                                    ${item.getCourseCreateDate()}
                                                </td>

                                                <td class="project-actions">

                                                    <a class="btn btn-info btn-sm" href="updatecourse?id=${item.getCourseID()}&discount=${item.getDiscount()}" title="Update Course">
                                                        <i class="fas fa-pencil-alt">
                                                        </i>

                                                    </a>
                                                    <a class="btn btn-danger btn-sm"  href="deletecourse?id=${item.getCourseID()}" onclick="return confirmDeleteSelect();" title="Delete" >
                                                        <i class="fas fa-trash">
                                                        </i>

                                                    </a>
                                                    <a class="btn btn-dark btn-sm"  href="getcoursedetail?id=${item.getCourseID()}" title="view" >
                                                        <i class="fas fa-eye">
                                                        </i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </form>

                    </div>
                </section>  <!--</form>-->
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item "><a class="page-link " ${tag == 1?"hidden":""} href="${way}?index=${tag - 1}&option=${option}&search=${search}">Previous</a></li>
                            <c:forEach begin ="1" var="i" end = "${endPage}">
                            <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="${way}?index=${i}&option=${option}&search=${search}"   >${i}</a></li>
                            </c:forEach>
                        <li class="page-item "><a class="page-link " ${tag == endPage?"hidden":""}  href="${way}?index=${tag + 1}&option=${option}&search=${search}">Next</a></li>
                    </ul>
                </nav>
            </div>

            <!--blog end--> 
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <footer class="main-footer">
            <div class="float-right d-none d-sm-block">
                <b>Version</b> 3.2.0
            </div>
            <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
        </footer>

        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->
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
        function confirmDeleteSelect() {
            var result = confirm("Are you sure you want to delete these products?");

            if (result) {
                // N?u xác nh?n xóa, g?i d? li?u lên servlet
                return true;
            } else {
                // N?u không xác nh?n xóa, h?y thao tác xóa
                return false;
            }
        }
    </script>
    <!-- Delete Modal HTML -->

    <%--<c:forEach items="${data}" var="item">--%>
    <div id="deletenews" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form>
                    <div class="modal-header">						
                        <h4 class="modal-title">Delete Employee</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these Records?</p>
                        <p class="text-warning"><small>This action cannot be undone. id=<span id="deleteItemId"></span></small></p>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <a id="deleteItemLink" class="btn btn-info btn-sm" href="#">delete</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        function confirmDelete(itemId) {
            document.getElementById('deleteItemId').innerText = itemId;
            var deleteItemLink = document.getElementById('deleteItemLink');
            deleteItemLink.href = 'deletecourse?id=' + itemId;
            $('#deletecourse').modal('show');
        }
    </script>
    <%--</c:forEach>--%>




    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button)
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
