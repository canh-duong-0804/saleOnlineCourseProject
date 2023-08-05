/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class CourseVideo {
    private int CourseVideoID,CourseID,videoOrder;
    private String VideoLink,videoName;
    

    public int getCourseVideoID() {
        return CourseVideoID;
    }

    public void setCourseVideoID(int CourseVideoID) {
        this.CourseVideoID = CourseVideoID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getVideoLink() {
        return VideoLink;
    }

    public void setVideoLink(String VideoLink) {
        this.VideoLink = VideoLink;
    }

    public CourseVideo() {
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getVideoOrder() {
        return videoOrder;
    }

    public void setVideoOrder(int videoOrder) {
        this.videoOrder = videoOrder;
    }

    public CourseVideo(int CourseVideoID, int videoOrder, String VideoLink, String videoName,int CourseID) {
        this.CourseVideoID = CourseVideoID;
        this.videoOrder = videoOrder;
        this.VideoLink = VideoLink;
        this.videoName = videoName;
        this.CourseID = CourseID;
    }
    
    
    
    
}
