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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Admin
 */
public class addnewstypecontroller extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try ( PrintWriter out = resp.getWriter()) {
        String typename = req.getParameter("typenewsname");
        


        



           NewsDAO post = new NewsDAO();
            post.addNewstype(typename);
            
showListBlogDAO show = new showListBlogDAO();
            List<newsType> typenews = show.getNewsType();
//           for (int i = 0; i < typenews.size(); i++) {
//               System.out.println(typenews.get(i).getNewsTypeID());
//        }
             req.setAttribute("typenews", typenews);
        req.getRequestDispatcher("postNews.jsp").forward(req, resp);

//        }
    }

}