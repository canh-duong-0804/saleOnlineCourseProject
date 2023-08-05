<%-- 
    Document   : sidebar
    Created on : May 23, 2023, 3:42:11 PM
    Author     : TUF F15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title></title>

        <!-- Google Font: Source Sans Pro -->
        <!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">-->
        <!-- Font Awesome -->
        <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/adminlte.min.css">
        <!-- overlayScrollbars -->
        <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
        
    </head>
    <body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Manage Employee
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="readTeacher">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Employee Management</p>

                                </a>
                            </div>
                        </li>


                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Manage Order
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="ordermanage">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Order manage</p>

                                </a>
                            </div>
                        </li>


                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-edit"></i>
                        <p>
                            Manage Blogs
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="postnews" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Post Blog</p>
                                </a>
                            </div>
                        </li>

                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="showlistnews" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Manage Blogs</p>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="https://dashboard.tawk.to/#/admin/6487c7c494cf5d49dc5d4c6c/channels/chat-widget" target="_blank" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Chat box</p>
                                </a>
                            </div>
                        </li>

                    </ul>
                </li> 
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-edit"></i>
                        <p>
                            Manage Course
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">

                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="coursecontroller" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Course Management</p>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="processController" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Process Management</p>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="viewCourseVideo" >
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Video Management</p>
                                </a>
                            </div>
                        </li>

                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Manage Course Book
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="postcoursebook">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Post Course Book</p>
                                </a></div>
                        </li>
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="showlistbook">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>List Course Book</p>
                                </a>
                            </div>
                        </li>

                    </ul>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-tachometer-alt"></i>
                        <p>
                            Manage Users
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="displayUser">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Users Management</p>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="listBan">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Users Ban Management</p>

                                </a>
                            </div>
                        </li>

                    </ul>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-table"></i>
                        <p>
                            Manage Course Document
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <div class="nav-link">
                                <a href="displayDocument">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Course Document Management</p>
                                </a>
                            </div>
                        </li>

                    </ul>
                
                </li>
               
                <li class="nav-item">
                    <div class="nav-link">
                        <a href="logout">
                            <i class="far fa-circle nav-icon"></i>
                            <p>Log Out</p>

                        </a>
                    </div>
                </li>
            </ul>
        </nav>
        <!-- ./wrapper -->

        <!-- jQuery -->
        <!--<script src="plugins/jquery/jquery.min.js"></script>-->
        <!-- Bootstrap 4 -->
        <!--<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>-->
        <!-- AdminLTE App -->
        <!--<script src="dist/js/adminlte.min.js"></script>-->
        <!-- AdminLTE for demo purposes -->
        <!--<script src="dist/js/demo.js"></script>-->
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- AdminLTE -->
        <script src="dist/js/adminlte.js"></script>

        <!-- OPTIONAL SCRIPTS -->
        <script src="plugins/chart.js/Chart.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="dist/js/pages/dashboard3.js"></script>
    </body>
</html>
