/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Clients;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import DAO.postBlogDAO;
import DAO.showListBlogDAO;
import Model.News;
import Model.newsType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author admin
 */
public class showlistclientnarbar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("namenarbar");
        String NewsTitle = req.getParameter("namenarbar");
        String News = req.getParameter("urlnarbar");
        System.out.println(id);
        System.out.println("check12: " + NewsTitle);
        System.out.println("check12: " + News);
         NewsDAO post = new NewsDAO();
         SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");

        java.util.Date date = new java.util.Date();
        System.out.println(ft.format(date));
        post.postNarbarClients(id,ft.format(date) ,NewsTitle, News);
        //showListBlogDAO show = new showListBlogDAO();
        //List<News> data = show.getListNews();
        //req.setAttribute("data", data);
        resp.sendRedirect("showlistnews");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newsTypeID = "4";
//        editBlogDAO edit = new editBlogDAO();
//        News blog = edit.getClientNabar(newsTypeID);

//        System.out.println("Check: " + blog.getNewsImg());
//        req.setAttribute("blog", blog);
//        req.setAttribute("blog", blog);
        NewsDAO show = new NewsDAO();
         
       
        List<newsType> newsType = show.getListFromNewsType();
        req.setAttribute("newsType", newsType);
        System.out.println("okee");
        List<News> listNabar = show.getListNarbarClient(newsTypeID);
        System.out.println("check: " + listNabar.size());
        req.setAttribute("data", listNabar);

        req.getRequestDispatcher("manageNabarAdmin.jsp").forward(req, resp);

    }

}
