/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author TUF F15
 */
public class News {

    private String newsID, creatNewsDate, newsTitle, news, newsImg, adminID, NewsStatus,newsTypeID;

    public News() {
    }

    public News(String newsID, String creatNewsDate, String newsTitle, String news, String newsImg, String adminID, String NewsStatus, String newsTypeID) {
        this.newsID = newsID;
        this.creatNewsDate = creatNewsDate;
        this.newsTitle = newsTitle;
        this.news = news;
        this.newsImg = newsImg;
        this.adminID = adminID;
        this.NewsStatus = NewsStatus;
        this.newsTypeID = newsTypeID;
    }
    public News(String newsID, String newsTitle, String news, String newsImg, String adminID) {
        this.newsID = newsID;
        
        this.newsTitle = newsTitle;
        this.news = news;
        this.newsImg = newsImg;
        this.adminID = adminID;
        
    }
    public News(String newsID, String newsTitle, String news, String newsTypeID) {
        this.newsID = newsID;
       
        this.newsTitle = newsTitle;
        this.news = news;
       
        
        this.newsTypeID = newsTypeID;
    }

    public String getNewsTypeID() {
        return newsTypeID;
    }

    public void setNewsTypeID(String newsTypeID) {
        this.newsTypeID = newsTypeID;
    }

    
    public News( String creatNewsDate, String newsTitle, String news, String newsImg, String adminID, String NewsStatus, String newsTypeID) {
      
        this.creatNewsDate = creatNewsDate;
        this.newsTitle = newsTitle;
        this.news = news;
        this.newsImg = newsImg;
        this.adminID = adminID;
        this.NewsStatus = NewsStatus;
          this.newsTypeID = newsTypeID;
    }

    public String getNewsStatus() {
        return NewsStatus;
    }

    public void setNewsStatus(String NewsStatus) {
        this.NewsStatus = NewsStatus;
    }

    public News(String newsTitle, String news, String newsImg) {

        this.newsTitle = newsTitle;
        this.news = news;
        this.newsImg = newsImg;

    }

   

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getCreatNewsDate() {
        return creatNewsDate;
    }

    public void setCreatNewsDate(String creatNewsDate) {
        this.creatNewsDate = creatNewsDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

}
