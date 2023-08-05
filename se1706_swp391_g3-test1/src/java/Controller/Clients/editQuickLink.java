/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Clients;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class editQuickLink extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           try ( PrintWriter out = resp.getWriter()) {
//        String id = req.getParameter("id");
//        String textTitle = req.getParameter("texttitle");
//        String imgNews = req.getParameter("imgnews");
//        String titleDetails = req.getParameter("titledetails");
//        String AdminID = String.valueOf("1");
//                    System.out.println(id);
//                    System.out.println(imgNews);
//                    System.out.println(titleDetails);
//                    System.out.println(textTitle);
//                    System.out.println("Da dc goi den");
////        out.print(id);
////        out.print(textTitle);
////        out.print(imgNews);
////            String dateTime=String.valueOf(java.time.LocalDateTime.now());
//
////        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-DD HH:MI:SS ");
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
//
//        java.util.Date date = new java.util.Date();
String id=req.getParameter("id");
String NewsTitle=req.getParameter("namenarbar");
String News=req.getParameter("urlnarbar");
               System.out.println(id);
               System.out.println("check12: "+NewsTitle);
               System.out.println("check12: "+News);
        NewsDAO update = new NewsDAO();
        update.updateQuickLink(id,NewsTitle,News);
        //showListBlogDAO show = new showListBlogDAO();
        //List<News> data = show.getListNews();
        //req.setAttribute("data", data);
        resp.sendRedirect("showlistnews");
    }}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
     String id = req.getParameter("id");
        NewsDAO edit = new NewsDAO();
      
                News blog= edit.getQuickLink(id);
               
       req.setAttribute("blog", blog);
       req.setAttribute("NewsID", id);
       //dung chung voi quicklink
                    req.getRequestDispatcher("editQuickLink.jsp").forward(req, resp);
      
    }
    
    
    
}