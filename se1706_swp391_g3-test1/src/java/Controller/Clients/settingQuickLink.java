/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Clients;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import Model.News;
import Model.newsType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class settingQuickLink extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewsDAO edit = new NewsDAO();
        List<News> listQuickLink = edit.getListQuickLink();
//        News blog = edit.getClientNabar(newsTypeID);

//        System.out.println("Check: " + blog.getNewsImg());
//        req.setAttribute("blog", blog);

      
        List<newsType> newsType = edit.getListFromNewsType();
            req.setAttribute("newsType", newsType);
        req.setAttribute("listQuickLink", listQuickLink);

        req.getRequestDispatcher("SettingQuickLink.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      

     
      
    
    
    
    }

}
