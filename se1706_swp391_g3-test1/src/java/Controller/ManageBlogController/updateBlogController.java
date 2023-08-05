/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import DAO.postBlogDAO;
import DAO.showListBlogDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class updateBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                try ( PrintWriter out = resp.getWriter()) {
       NewsDAO update = new NewsDAO();
        String id = req.getParameter("id");
        String textTitle = req.getParameter("texttitle");
        String imgNews = req.getParameter("imgnews");
        String titleDetails = req.getParameter("titledetails");
//        String AdminID = String.valueOf("1");
        HttpSession session =req.getSession();
        String username = (String)session.getAttribute("username");
        String fullnameAdmin = update.getFullnameAdmin(username);
                    System.out.println(id);
                    System.out.println(imgNews);
                    System.out.println(titleDetails);
                    System.out.println(textTitle);
                    System.out.println("Da dc goi den");
//        out.print(id);
//        out.print(textTitle);
//        out.print(imgNews);
//            String dateTime=String.valueOf(java.time.LocalDateTime.now());

//        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS ");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");

        java.util.Date date = new java.util.Date();

        
        update.updateBlogs(id,ft.format(date), titleDetails,textTitle, imgNews, fullnameAdmin);
        //showListBlogDAO show = new showListBlogDAO();
        //List<News> data = show.getListNews();
        //req.setAttribute("data", data);
        resp.sendRedirect("showlistnews");

    }

}
}