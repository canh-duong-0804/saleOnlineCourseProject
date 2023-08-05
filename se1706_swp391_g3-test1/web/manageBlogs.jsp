-<%@page  import="Model.News" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  import="java.util.ArrayList" %>

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
                        <a href="profile?username=${user}" class="nav-item nav-link">${user}</a>
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
                                <form action="search" method="get">
                                    <div class="col-md-12">
                                        <div class="input-group"><input  type="text" id="search" value="${txtSearch}" placeholder="Search Here" class="input-sm form-control"name="search">
                                            <select name="filter" class="input-sm form-control">
                                                <option value="news">search by name news</option>
                                                <option value="author">search by name author</option>

                                            </select>

                                            <span class="input-group-btn">
                                                <input type="submit" class="input-sm form-control" value="Search"> </span>

                                        </div>

                                    </div>
                                </form>
                                <div class="row">
                                    <div class="col-md-6">
                                        <form action="filter" method="get">
                                            <div class="input-group">

                                                <!--lay tu database-->
                                                <select name="filter" class="form-control">
                                                    <c:forEach items="${newsType}" var="item">
                                                        <!--                    <option value="0">show all news</option>
                                                                            <option value="1">sale</option>
                                                                            <option value="2">course news</option>
                                                                            <option value="10">3 news gan nhat</option>
                                                                            <option value="Footer">Footer</option>
                                                                            <option value="Narbar">narbar</option>
                                                                            <option value="banner">banner</option>-->
                                                        <option value="${item.getNewsTypeID()}">${item.getNewsTypeName()}</option>
                                                    </c:forEach>
                                                    <!--lay tu database-->
                                                </select>
                                                <span class="input-group-btn">
                                                    <input type="submit" class="btn btn-primary" value="Filter">
                                                </span>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-md-6">
                                        <form action="showlistnews" method="get">
                                            <div class="input-group">
                                                <select name="totalnews" class="form-control">
                                                    <option value="3">3</option>
                                                    <option value="5">5</option>
                                                    <option value="10">10</option>
                                                    <option value="15">15</option>
                                                    <option value="20">20</option>
                                                </select>
                                                <span class="input-group-btn">
                                                    <input type="submit" class="btn btn-primary" value="Filter">
                                                </span>
                                            </div>
                                        </form>
                                    </div>
                                </div>

                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <!-- Content here -->
                                </div>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <form id="myForm" action="deletenewsselect" method="post">
                    <section class="content" id="titleSearch">

                        <!-- Default box -->

                        <div class="card">
                            <div class="card-header">


                                <div class="card-tools">
                                    <a href="postnews" class="btn btn-success"><i
                                            class="material-icons">&#xE147;</i> <span>Add</span></a>

                                    <!--                                                        <a > <button type="submit" class="btn btn-danger"><i
                                                                                            class="material-icons" >&#xE15C;</i> <span>Delete</span></button></a>-->
                                    <div class="btn btn-danger"  >



                                        <span><input type="submit" value="Delete" style="color: white;background-color: #dc3545;
                                                     border-color: #dc3545;border: 0px" onclick="return confirmDeleteSelect();"></span>
                                    </div>

                                    <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">

                                        <i class="fas fa-minus"></i>
                                    </button>
                                    <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </div>
                            </div>
                            <div class="card-body p-0">
                                <table class="table table-striped projects" >
                                    <thead>
                                        <tr>
                                            <th style="width: 1%">
                                                <span class="custom-checkbox">
                                                    <input type="checkbox" id="selectAll">
                                                    <label for="selectAll"></label>
                                                </span>
                                            </th>
                                            <th style="width: 1%">
                                                ID 
                                            </th>
                                            <th style="width: 10%">
                                                Type 
                                            </th>
                                            <th style="width: 10%">
                                                Title 
                                            </th>
                                            <th style="width: 10%">
                                                Thumbnails 
                                            </th>
                                            <th style="width: 10%" >
                                                Time post 
                                            </th>
                                            <th style="width: 10%">
                                                Create by Admin
                                            </th>
                                        </tr>
                                    </thead>


                                    <c:forEach items="${data}" var="item">
                                        <div id="titleSearch">

                                            <tbody>
                                                <tr>
                                                    <td >
                                                        <span class="custom-checkbox">
                                                            <input type="checkbox" id="checkbox1" name="options" value=" ${item.getNewsID()}">
                                                            <label for="checkbox1"></label>
                                                        </span>
                                                    </td>
                                                    <td >
                                                        <a>
                                                            ${item.getNewsID()}
                                                        </a>
                                                        <br/>

                                                    </td>
                                                    <td >
                                                        <a >
                                                            ${item.getNewsTypeID()}
                                                        </a>
                                                    </td>
                                                    <td >
                                                        <a >
                                                            ${item.getNewsTitle()}
                                                        </a>
                                                    </td>

                                                    <td >
                                                        <style>
                                                            .custom-div {
                                                                width: 200px;
                                                                height: 150px;
                                                            }

                                                            .custom-div img {
                                                                width: 100%;
                                                                height: 100%;
                                                                /*object-fit: cover;*/
                                                            }
                                                        </style>
                                                        <div class="custom-div">

                                                         <img   src="${item.getNewsImg()}"> 


                                                        </div>
                                                        <br/>

                                                    </td   >
                                                    <td  >
                                                        ${item.getCreatNewsDate()}
                                                    </td>
                                                    <td class="text-start" >
                                                        <span > ${item.getAdminID()}</span>
                                                    </td>
                                                    <td class="project-actions text-right">
                                                        <a class="btn btn-primary btn-sm" href="viewblogdetails/tintuc-${showBlogDetails.convertToSlug(item.getNewsTitle().replaceAll(" ","-"))}-${item.getNewsID()}">
                                                            <i class="fas fa-folder">
                                                            </i>

                                                        </a>
                                                        <a class="btn btn-info btn-sm" href="editblogs?id=${item.getNewsID()}">
                                                            <i class="fas fa-pencil-alt">
                                                            </i>

                                                        </a>

                                                        <a class="btn btn-danger btn-sm" data-toggle="modal" href="#" onclick="confirmDelete('${item.getNewsID()}')" >


                                                            <i class="fas fa-trash">
                                                            </i>

                                                        </a>

                                                    </td>
                                                    <td class="project-state">

                                                    </td>


                                                </tr>


                                            </tbody>
                                        </c:forEach>


                                </table>
                                <td colspan="10">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item "><a class="page-link ${tag == 1?"hidden":""}" href="${way}?index=${tag - 1}&filter=${option}&search=${search}">Previous</a></li>
                                                <c:forEach begin ="1" var="i" end = "${endPage}">    
                                                <li class="page-item"><a class="page-link ${tag == i?"active":""}" href="${way}?index=${i}&filter=${option}&search=${search}">${i}</a></li>
                                                </c:forEach>
                                            <li class="page-item "><a class="page-link ${tag == endPage?"hidden":""}"href="${way}?index=${tag + 1}&filter=${option}&search=${search}">Next</a></li>
                                        </ul>
                                    </nav>
                                    </section>

                                    <!--blog end--> 
                                    </form>
                                    <!-- /.content -->
                            </div>
                        </div>

                        <!-- /.content-wrapper -->

                        <!--            <footer class="main-footer">
                                        <div class="float-right d-none d-sm-block">
                                            <b>Version</b> 3.2.0
                                        </div>
                                        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
                                    </footer>-->

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

//                            function search(index) {
//                                var search = $("#search").val();
//                                var filter = $("#filter").val();
//                                var entry = $("#entry").val();
//                                console.log(entry);
//
//                                $.ajax({
//                                    url: "searchAjaxNewsClients",
//                                    data: {search: search, filter: filter, index: index},
//                                    type: "GET",
//                                    success: function (data) {
//                                        var searchList = document.getElementById('titleSearch');
//                                        searchList.innerHTML = data;
//                                        document.addEventListener('DOMContentLoaded', deleteCheckedBoxes());
//                                        //                        document.getElementById('clear').innerHTML = "";
//                                    }
//                                });
//                            }
//
//                            $(document).ready(function () {
//                                //                document.addEventListener('DOMContentLoaded', deleteCheckedBoxes());
//
//                                $("#search").on("keyup", function () {
//                                    search(-1);
//                                });
//
//                                $("#entry").on("change", function () {
//                                    search(-1);
//                                });
//
//                                $('button[name="pageLink"]').click(function () {
//                                    var pageIndex = $(this).val();
//                                    search(pageIndex);
//                                });
//                            });

                        </script>
                        <script>
                            function confirmDelete(itemId) {
                                document.getElementById('deleteItemId').innerText = itemId;
                                var deleteItemLink = document.getElementById('deleteItemLink');
                                deleteItemLink.href = 'deletenews?id=' + itemId;
                                $('#deletenews').modal('show');
                            }
                        </script>
                        <%--</c:forEach>--%>
                        <script>
                            function confirmDeleteSelect() {
                                var result = confirm("Are you sure you want to delete these products?");
                                if (result) {

                                    return true;
                                } else {

                                    return false;
                                }
                            }
                        </script>



                        <!-- jQuery -->
                        <script src="plugins/jquery/jquery.min.js"></script>
                        <!-- jQuery UI 1.11.4 -->
                        <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
                        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
                        <script>
                            $.widget.bridge('uibutton', $.ui.button)
                        </script>
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
                        <!-- overlayScrollbars -->
                        <script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
                        <!-- AdminLTE App -->
                        <script src="dist/js/adminlte.js"></script>

                        <!-- AdminLTE for demo purposes -->
                        <script src="dist/js/demo.js"></script>
                        </body>
                        </html>