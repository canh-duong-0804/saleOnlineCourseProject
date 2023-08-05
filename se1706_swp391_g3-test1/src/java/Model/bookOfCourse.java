/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class bookOfCourse {
   private String Course_BookID,CourseID;

    public bookOfCourse() {
    }

    public bookOfCourse(String Course_BookID, String CourseID) {
        this.Course_BookID = Course_BookID;
        this.CourseID = CourseID;
    }

    public String getCourse_BookID() {
        return Course_BookID;
    }

    public void setCourse_BookID(String Course_BookID) {
        this.Course_BookID = Course_BookID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }
   
    
}
