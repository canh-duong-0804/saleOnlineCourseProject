/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class newsType {
    private String newsTypeID,newsTypeName;

    public newsType() {
    }

    public newsType(String newsTypeID, String newsTypeName) {
        this.newsTypeID = newsTypeID;
        this.newsTypeName = newsTypeName;
    }

    public String getNewsTypeID() {
        return newsTypeID;
    }

    public void setNewsTypeID(String newsTypeID) {
        this.newsTypeID = newsTypeID;
    }

    public String getNewsTypeName() {
        return newsTypeName;
    }

    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }

   
}
