<%-- 
    Document   : orderDetail
    Created on : May 24, 2023, 12:13:35 AM
    Author     : TUF F15
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="./css/orderDetail.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
  
<div>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body ">
                <div class="text-right"><a href="homePage"> <i class="fa fa-close close" data-dismiss="modal"></a></i> </div>
                
                <div class="px-4 py-5">

                    <h5 class="text-uppercase">${user}</h5>



                <h4 class="mt-5 theme-color mb-5">Thanks for your order</h4>

                <span class="theme-color">Payment Summary</span>
                <div class="mb-3">
                    <hr class="new1">
                </div>
                <c:forEach items="${listC}" var="item">
                <div class="d-flex justify-content-between">
                    <span class="font-weight-bold">${item.getCourseName()}(Qty:1)</span>
                    <span class="text-muted">${item.getCoursePrice()}</span>
                </div>
                </c:forEach>
                <c:forEach items="${listB}" var="item">
                <div class="d-flex justify-content-between">
                    <span class="font-weight-bold">${item.getBookName()}(Qty:${item.getQuantity()})</span>
                    <span class="text-muted">${item.getPrice()}</span>
                </div>
                </c:forEach>
                <div class="d-flex justify-content-between mt-3">
                    <span class="font-weight-bold">Total</span>
                    <span class="font-weight-bold theme-color">${total}</span>
                </div> 
                <div class="text-center mt-5">


                    <button class="btn btn-primary">Track your order</button>
                    


                </div>                   

                </div>


            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>