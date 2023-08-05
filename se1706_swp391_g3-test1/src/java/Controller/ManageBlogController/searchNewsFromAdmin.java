/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.searchNewsFromDAO;
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
public class searchNewsFromAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        searchNewsFromDAO find = new searchNewsFromDAO();
        String search = req.getParameter("search");
        String option = req.getParameter("filter");
        String indexPage = req.getParameter("index");
         NewsDAO show = new NewsDAO();
        if (indexPage == null) {
            indexPage = "1";
        }
        System.out.println(option);
        if (option.equals("author")) {
            System.out.println("true");
            System.out.println("Search:" + search);
//            List<News> data = find.SearchForNameAuthor(search);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);

            int index = Integer.parseInt(indexPage);
            int count = find.getTotalAuthor(search);
            System.out.println("check count: "+count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
             List<newsType> newsType=show.getListFromNewsType();
        //filter emd
        
        
        
        req.setAttribute("newsType", newsType);
            List<News> data = find.searchNewsFromNameAuthor(search, index);

            req.setAttribute("way", "search");
            req.setAttribute("option", "1");
            req.setAttribute("search", search);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);
            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
        } else {
//        searchName find = new searchName();
//        List<TypeRoom> room = find.SearchForName(search);
//        searchNewsFromDAO find = new searchNewsFromDAO();
        int index = Integer.parseInt(indexPage);
        int count = find.getTotalSearch(search);
        System.out.println("count: " + count);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        List<newsType> newsType=show.getListFromNewsType();
        //filter emd
        
        
        
        req.setAttribute("newsType", newsType);
        List<News> data = find.SearchForNameNewsAdmins(search, index);
        req.setAttribute("way", "search");
        req.setAttribute("option", "0");
        req.setAttribute("search", search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.setAttribute("txtSearch", search);
        req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);

    }
}

}
