/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.deleteBlogDAO;
import DAO.postBlogDAO;
import DAO.showListBlogDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class deleteSelectNews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedValues = req.getParameterValues("options");
        NewsDAO delete = new NewsDAO();
        NewsDAO show = new NewsDAO();

        if (selectedValues != null) {
            for (String value : selectedValues) {
                System.out.println("check option: "+value);
                // Xử lý giá trị được gửi từ JavaScript ở đây

                delete.deleteNews(value);

            }
        }
        List<News> data = show.getListNews();

        req.setAttribute("data", data);
        resp.sendRedirect("showlistnews");
//        req.getRequestDispatcher("showlistnews").forward(req, resp);
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        try ( PrintWriter out = resp.getWriter()) {
//        String textTitle = req.getParameter("texttitle");
//        String typenews = req.getParameter("typenews");
//        String imgNews = req.getParameter("imgnews");
//        String titleDetails = req.getParameter("titledetails");
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
//        System.out.println("Check: "+textTitle);
////            News n = new News(ft.format(date), titleDetails, textTitle, imgNews, AdminID,NewsStatus);
//        News n = new News(ft.format(date), titleDetails, textTitle, imgNews, AdminID, NewsStatus, typeNews);
//        postBlogDAO post = new postBlogDAO();
//        post.addPostNewBlogs(n);
//        showListBlogDAO show = new showListBlogDAO();
//        List<News> data = show.getListNews();
//        req.setAttribute("data", data);
//        req.getRequestDispatcher("showlistnews").forward(req, resp);
//
////        }
//    }

}
