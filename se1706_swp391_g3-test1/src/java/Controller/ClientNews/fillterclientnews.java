/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ClientNews;

import DAO.NewsDAO;
import DAO.showListBlogDAO;
import Model.News;
import Model.newsType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class fillterclientnews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDAO show = new NewsDAO();

        String indexPage = req.getParameter("index");

        String option = req.getParameter("filter");
        System.out.println("test: " + option);
        if (indexPage == null) {
            indexPage = "1";
        }

//        sale
        if (option.equals("1")) {
            int index = Integer.parseInt(indexPage);
            int count = show.getTotalNews(option);
//        System.out.println(count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<News> data = show.pagingNewsFilter(index, option);
            List<newsType> newsType = show.getListFromNewsTypeClients();
            //filter emd

            req.setAttribute("newsType", newsType);
            req.setAttribute("way", "filternewsclient");
            req.setAttribute("option", "1");
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);

            req.getRequestDispatcher("clientnewshomepage.jsp").forward(req, resp);

        } else if (option.equals("2")) {
            int index = Integer.parseInt(indexPage);
            int count = show.getTotalNews(option);
//        System.out.println(count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
             List<newsType> newsType=show.getListFromNewsTypeClients();
        //filter emd
        
        
        
        req.setAttribute("newsType", newsType);
            List<News> data = show.pagingNewsFilter(index, option);
            req.setAttribute("way", "filternewsclient");
            req.setAttribute("option", "2");
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);
            req.getRequestDispatcher("clientnewshomepage.jsp").forward(req, resp);
        }
    }

}
