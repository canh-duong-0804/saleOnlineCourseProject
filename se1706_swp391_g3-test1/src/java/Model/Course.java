/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class Course {

    private String courseID, courseName, coursePrice, coursePropose, courseDescription, courseCreateDate, courseImg,adminID,discount,
            numberstudentEnroll, courseVideo;
    private boolean ccpStatus;
    public Course() {
    }

    public String getCoursevideo() {
        return courseVideo;
    }

    public void setCoursevideo(String coursevideo) {
        this.courseVideo = coursevideo;
    }
    public Course(String courseID, String courseName, String coursePrice) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public Course(String courseID, String courseName, String coursePrice, String courseDescription) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseDescription = courseDescription;
    }

    public Course(String courseID, String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo, boolean status,String admin,String discount) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coursePropose = coursePropose;
        this.courseDescription = courseDescription;
        this.courseCreateDate = courseCreateDate;
        this.courseImg = courseImg;
        this.numberstudentEnroll = numberstudentEnroll;
        this.courseVideo = courseVideo;
        this.ccpStatus = status;
        this.adminID= admin;
        this.discount=discount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    
    

    public String getCourseID() {
        return courseID;
    }

    

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

   

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public boolean isCcpStatus() {
        return ccpStatus;
    }

    public void setCcpStatus(boolean ccpStatus) {
        this.ccpStatus = ccpStatus;
    }
    
     
    public Course(String courseID, String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo, boolean status) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coursePropose = coursePropose;
        this.courseDescription = courseDescription;
        this.courseCreateDate = courseCreateDate;
        this.courseImg = courseImg;
        this.numberstudentEnroll = numberstudentEnroll;
        this.courseVideo = courseVideo;
        this.ccpStatus = status;
    }



      public Course( String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coursePropose = coursePropose;
        this.courseDescription = courseDescription;
        this.courseCreateDate = courseCreateDate;
        this.courseImg = courseImg;
        this.numberstudentEnroll = numberstudentEnroll;
        this.courseVideo = courseVideo;
    }

    @Override
    public String toString() {
        return courseName+ " "+ coursePrice+" "+courseDescription+" "+courseCreateDate+" "+ courseImg+ " " +adminID;
    }
    public Course( String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo,String adminID) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coursePropose = coursePropose;
        this.courseDescription = courseDescription;
        this.courseCreateDate = courseCreateDate;
        this.courseImg = courseImg;
        this.numberstudentEnroll = numberstudentEnroll;
        this.courseVideo = courseVideo;
        this.adminID=adminID;
    }
    
    public Course(String courseID, String courseName, String coursePrice, String coursePropose, String courseDescription, String courseCreateDate, String courseImg, String numberstudentEnroll, String courseVideo, boolean status,String admin) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.coursePropose = coursePropose;
        this.courseDescription = courseDescription;
        this.courseCreateDate = courseCreateDate;
        this.courseImg = courseImg;
        this.numberstudentEnroll = numberstudentEnroll;
        this.courseVideo = courseVideo;
        this.ccpStatus = status;
        this.adminID= admin;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCoursePropose() {
        return coursePropose;
    }

    public void setCoursePropose(String coursePropose) {
        this.coursePropose = coursePropose;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseCreateDate() {
        return courseCreateDate;
    }

    public void setCourseCreateDate(String courseCreateDate) {
        this.courseCreateDate = courseCreateDate;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getNumberstudentEnroll() {
        return numberstudentEnroll;
    }

    public void setNumberstudentEnroll(String numberstudentEnroll) {
        this.numberstudentEnroll = numberstudentEnroll;
    }

   

   
    
    
    
}
