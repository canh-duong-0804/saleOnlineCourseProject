<%-- 
    Document   : AddOrderAdmin
    Created on : 22 May, 2023, 4:13:41 PM
    Author     : ADMIN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Admin" %>
<%@page import="Model.Course" %>
<%@page buffer="8192kb" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cart</title>
        <link rel="stylesheet" href="css/bootstrap.min_homepage.css"/>
        <link rel="stylesheet" href="css/Cart.css"/>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body >
        <%@include  file="narbarclients.jsp" %>
        <script>
            function incrementValue(inputId) {
                var input = document.getElementById(inputId);
                var value = parseInt(input.value);
                var date = new Date();
                input.value = value + 1;
                sendData(inputId, value + 1);
            }

            function decrementValue(inputId) {
                var input = document.getElementById(inputId);
                var value = parseInt(input.value);
                if (input.value > 1) {
                    input.value = value - 1;
                    sendData(inputId, value - 1);
                }
            }
            function sendData(name, quantity) {
                var data = {};
                data[name] = quantity;
                console.log(name + "," + quantity);
                $.ajax({
                    url: '/SWP391_SE1706_G3/cart',
                    type: 'POST',
                    data: data,
                    success: function (response) {
                        // Handle the server's response
                        console.log("success");
                    },
                    error: function (error) {
                        // Handle any errors
                        console.error("Error occurred: ", error);
                    }
                });
            }
        </script>

        <style>

            .quantity {
                display: inline-block;
                width: 100%;
                border: none;
                text-align: center;
                background-color: #f5f5f5;
            }

            .minus-btn, .plus-btn {
                display: inline-block;
                justify-content: center;
                align-items: center;
                width: 45%;
                height: 15%;
                font-size: 150%;
                text-align: center;
                border: none;
                background-color: transparent;
                cursor: pointer;
                outline: none;
            }

            .minus-btn:hover, .plus-btn:hover {
                background-color: #ddd;
            }

        </style>
        <section class="h-100 h-custom">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12">
                        <div class="card card-registration card-registration-2" style="border-radius: 15px; background-color: cornsilk">
                            <div class="card-body p-0">
                                <div class="row g-0">
                                    <div class="col-lg-8">
                                        <div class="p-5">
                                            <div class="d-flex justify-content-between align-items-center mb-5">
                                                <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                                                <h6 class="mb-0 text-muted">${dataCourse.size()+dataBook.size()}</h6>
                                            </div>
                                            <c:forEach items="${requestScope.dataCourse}" var="item">
                                                <hr class="my-4">

                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        <img
                                                            src="${item.getCourseImg()}"
                                                            class="img-fluid rounded-3" alt="">
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        <h6 class="text-muted">Course</h6>
                                                        <h6 class="text-black mb-0">${item.getCourseName()}</h6>
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        1
                                                    </div>
                                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                        <h6 class="mb-0">${item.getCoursePrice()}</h6>
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="cart?delete=true&&courseID=${item.getCourseID()}"class="text-muted"><i class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <c:forEach items="${requestScope.dataBook}" var="item">
                                                <hr class="my-4">

                                                <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                                        <h6 class="text-muted">Book</h6>
                                                        <h6 class="text-black mb-0">${item.getBookName()}</h6>
                                                    </div>
                                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                        <button class="minus-btn" type="button" onclick="decrementValue('${item.getCourse_BookID()}Quantity')">-</button>
                                                        <input value = "${item.getQuantity()}" id="${item.getCourse_BookID()}Quantity" readonly class="quantity" name = "quantity${item.getCourse_BookID()}" type="number">
                                                        <button class="plus-btn" type="button" onclick="incrementValue('${item.getCourse_BookID()}Quantity')">+</button>
                                                    </div>
                                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                        <h6 class="mb-0">${item.getPrice()}</h6>
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="cart?delete=true&&bookID=${item.getCourse_BookID()}"class="text-muted" onclick="deleteCookie('${item.getCourse_BookID()}Quantity${cookie.username.value}Book')"><i class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                            </c:forEach>    
                                            <hr class="my-4">

                                            <div class="pt-5">
                                                <h6 class="mb-0"><a href="displayCourse" class="text-body"><i
                                                            class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 bg-grey">
                                        <div class="p-5">
                                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                            <hr class="my-4">

                                            <div class="d-flex justify-content-between mb-4">
                                                <h5 class="text-uppercase">items ${dataCourse.size()+dataBook.size()}</h5>
                                            </div>

                                            

                                            <hr class="my-4">

                                            <a href="RegisterOrder">
                                                <button type="button" class="btn btn-dark btn-block btn-lg"
                                                        data-mdb-ripple-color="dark">Register</button></a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
                                                    
                                                            <%@include  file="footerclients.jsp" %>
    </body>
</html>

