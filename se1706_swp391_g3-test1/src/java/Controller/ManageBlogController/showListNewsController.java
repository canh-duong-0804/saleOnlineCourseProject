/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.showListBlogDAO;
import Model.Admin;
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
 * @author Admin
 */
public class showListNewsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDAO show = new NewsDAO();
        
        String indexPage = req.getParameter("index");
        String totalnews = req.getParameter("totalnews");
        if (indexPage == null) {
            indexPage = "1";
        }
        if (totalnews == null) {
            totalnews = "3";
        }
        int index = Integer.parseInt(indexPage);
        int totalNewsInonepage=Integer.parseInt(totalnews);
        int count = show.getTotalNews();
//        System.out.println(count);
         int endPage = count / totalNewsInonepage;
        if (count % totalNewsInonepage != 0) {
            endPage++;
        }
        List<News> data = show.pagingnews(index,totalNewsInonepage);
        System.out.println("Total NEws: "+totalNewsInonepage);
        
        //filter news
        List<newsType> newsType=show.getListFromNewsType();
        //filter emd
        
        
        
        req.setAttribute("newsType", newsType);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.setAttribute("way", "showlistnews");
        req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
    }

}
