/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class Discount {

    private String discountID, discount, createDiscountDate, adminID, courseID;

    public Discount() {
    }

    public Discount(String discountID, String discount, String createDiscountDate, String adminID, String courseID) {
        this.discountID = discountID;
        this.discount = discount;
        this.createDiscountDate = createDiscountDate;
        this.adminID = adminID;
        this.courseID = courseID;
    }
    
    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCreateDiscountDate() {
        return createDiscountDate;
    }

    public void setCreateDiscountDate(String createDiscountDate) {
        this.createDiscountDate = createDiscountDate;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

}
