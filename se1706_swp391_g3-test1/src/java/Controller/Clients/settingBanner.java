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
import java.util.List;

/**
 *
 * @author admin
 */
public class settingBanner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String id = "15";
//        editBlogDAO edit = new editBlogDAO();
        NewsDAO edit = new NewsDAO();
        List<News> data = edit.getBannerHomePage();
         List<newsType> newsType = edit.getListFromNewsType();
            req.setAttribute("newsType", newsType);
//        System.out.println("Check: " + blog.getNewsImg());
//        req.setAttribute("blog", blog);
//        req.setAttribute("NewsID", id);
        req.setAttribute("data", data);

        req.getRequestDispatcher("manageBanner.jsp").forward(req, resp);

    }
}
