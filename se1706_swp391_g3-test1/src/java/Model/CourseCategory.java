/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class CourseCategory extends Course{
    private int categoryID;
    private String categoryName,categoryImg;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImg() {
        return categoryImg;
    }
    public CourseCategory(String courseID, String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo, boolean status, String admin) {
        super(courseID, courseName, coursePrice, coursePropose, courseDescription, courseCreateDate, courseImg, numberstudentEnroll, courseVideo, status, admin);
    }
    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    public CourseCategory() {
    }

    public CourseCategory(int categoryID, String categoryName, String categoryImg) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }
    
}
