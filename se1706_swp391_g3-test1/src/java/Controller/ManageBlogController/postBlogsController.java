/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.postBlogDAO;
import DAO.showListBlogDAO;
import Model.News;
import Model.newsType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.*;
import java.text.*;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class postBlogsController extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        showListBlogDAO show = new showListBlogDAO();
//        List<newsType> typenews = show.getNewsType();
////           for (int i = 0; i < typenews.size(); i++) {
////               System.out.println(typenews.get(i).getNewsTypeID());
////        }
//        req.setAttribute("typenews", typenews);
//        req.getRequestDispatcher("postNews.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        try ( PrintWriter out = resp.getWriter()) {
//        postBlogDAO post = new postBlogDAO();
//        String textTitle = req.getParameter("texttitle");
//        String typenews = req.getParameter("typenews");
//        String imgNews = req.getParameter("imgnews");
//        String titleDetails = req.getParameter("titledetails");
//        Cookie ck;
//        Cookie[] cook = req.getCookies();
//        String username = "";
//        for (Cookie c : cook) {
//
//            if (c.getName().equals("username")) {
//                username = c.getValue();
//            }
//        }
//        String fullnameAdmin = post.getFullnameAdmin(username);
//        String AdminID = String.valueOf("1");
//        String NewsStatus = String.valueOf("1");
//        String typeNews = req.getParameter("typenews");
////            String dateTime=String.valueOf(java.time.LocalDateTime.now());
//
////        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS ");
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
//
//        java.util.Date date = new java.util.Date();
//
//        System.out.println(textTitle);
//        System.out.println(titleDetails);
//
////            News n = new News(ft.format(date), titleDetails, textTitle, imgNews, AdminID,NewsStatus);
//        News n = new News(ft.format(date), titleDetails, textTitle, imgNews, AdminID, NewsStatus, typeNews);
//        post.addPostNewBlogs(n);
//        showListBlogDAO show = new showListBlogDAO();
//        List<News> data = show.getListNews();
//        req.setAttribute("data", data);
//        req.getRequestDispatcher("showlistnews").forward(req, resp);
//
////        }
//    }

}
