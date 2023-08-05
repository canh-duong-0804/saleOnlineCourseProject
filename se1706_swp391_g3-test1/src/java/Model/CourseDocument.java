/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class CourseDocument {

    private String course_DocumentID, documentName, videoID, documentLink, typeOfDocument;
    boolean status;

    public CourseDocument() {
    }

    public CourseDocument(String course_DocumentID, String documentName, String videoID, String documentLink, String typeOfDocument, boolean status) {
        this.course_DocumentID = course_DocumentID;
        this.documentName = documentName;
        this.videoID = videoID;
        this.documentLink = documentLink;
        this.typeOfDocument = typeOfDocument;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCourseID() {
        return videoID;
    }

    public void setCourseID(String courseID) {
        this.videoID = courseID;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getCourse_DocumentID() {
        return course_DocumentID;
    }

    public void setCourse_DocumentID(String course_DocumentID) {
        this.course_DocumentID = course_DocumentID;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentLink() {
        return documentLink;
    }

    public void setDocumentLink(String documentLink) {
        this.documentLink = documentLink;
    }

    public CourseDocument(String course_DocumentID, String documentName, String documentLink, boolean status) {
        this.course_DocumentID = course_DocumentID;
        this.documentName = documentName;
        this.documentLink = documentLink;
        this.status = status;
    }

    public CourseDocument(String course_DocumentID, String documentName, String videoID, String documentLink, boolean status) {
        this.course_DocumentID = course_DocumentID;
        this.documentName = documentName;
        this.videoID = videoID;
        this.documentLink = documentLink;
        this.status = status;
    }

}
