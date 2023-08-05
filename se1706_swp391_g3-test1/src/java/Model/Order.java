/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class Order {

    private String orderID, courseID, UserID, OrderDate, TotalPrice, status, userName, courseImg;
    private boolean checkPaymentStatus;

    public Order() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public Order(String orderID, String courseID, String UserID, String status, String userName, String courseImg, boolean checkPaymentStatus) {
        this.orderID = orderID;
        this.courseID = courseID;
        this.UserID = UserID;
        this.status = status;
        this.userName = userName;
        this.courseImg = courseImg;
        this.checkPaymentStatus = checkPaymentStatus;
    }

    public Order(String orderID, String UserID, String OrderDate, String TotalPrice, String status, boolean checkPaymentStatus) {
        this.orderID = orderID;
        this.UserID = UserID;
        this.OrderDate = OrderDate;
        this.TotalPrice = TotalPrice;
        this.status = status;
        this.checkPaymentStatus = checkPaymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public boolean isCheckPaymentStatus() {
        return checkPaymentStatus;
    }

    public void setCheckPaymentStatus(boolean checkPaymentStatus) {
        this.checkPaymentStatus = checkPaymentStatus;
    }

}
