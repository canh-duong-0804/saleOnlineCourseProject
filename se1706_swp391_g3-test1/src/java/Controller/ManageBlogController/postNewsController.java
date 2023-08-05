/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.postBlogDAO;
import DAO.showListBlogDAO;
import Model.News;
import Model.newsType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author admin
 */
public class postNewsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        System.out.println("Method: " + method);
//        try ( PrintWriter out = resp.getWriter()) {
//        postBlogDAO post = new postBlogDAO();
        NewsDAO post = new NewsDAO();
        String textTitle = req.getParameter("texttitle");
        String typenews = req.getParameter("typenews");
        String imgNews = req.getParameter("imgnews");
        String titleDetails = req.getParameter("titledetails");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String fullnameAdmin = post.getFullnameAdmin(username);
        System.out.println("Fullname : " + fullnameAdmin);

//        String AdminID = String.valueOf("1");
        String NewsStatus = String.valueOf("1");
        String typeNews = req.getParameter("typenews");
//            String dateTime=String.valueOf(java.time.LocalDateTime.now());

//        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS ");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");

        java.util.Date date = new java.util.Date();

        System.out.println(textTitle);
        System.out.println(titleDetails);

//            News n = new News(ft.format(date), titleDetails, textTitle, imgNews, AdminID,NewsStatus);
        News n = new News(ft.format(date), titleDetails, textTitle, imgNews, fullnameAdmin, NewsStatus, typeNews);

        post.addPostNewBlogs(n);
        showListBlogDAO show = new showListBlogDAO();
        List<News> data = show.getListNews();
        req.setAttribute("data", data);
        resp.sendRedirect("showlistnews");
//        req.getRequestDispatcher("manageBook.jsp").forward(req, resp);

//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showListBlogDAO show = new showListBlogDAO();
        List<newsType> typenews = show.getNewsType();
//           for (int i = 0; i < typenews.size(); i++) {
//               System.out.println(typenews.get(i).getNewsTypeID());
//        }
        req.setAttribute("typenews", typenews);
        req.getRequestDispatcher("postNews.jsp").forward(req, resp);
    }

}
