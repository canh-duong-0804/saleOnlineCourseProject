/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class CourseProcess {

    String id, name, image, status, courseName;

    public CourseProcess() {
    }

    public CourseProcess(String id, String name, String image,String status ) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status= status;}

    public CourseProcess(String id, String name, String image,String status ,String courseName) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status= status;
        this.courseName = courseName;
    }

    public CourseProcess(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

}
