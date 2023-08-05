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
public class settingClientFooter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        NewsDAO post = new NewsDAO();
        News news = new News(address, phone, email);
        post.postClientsFooter(news);
        resp.sendRedirect("showlistnews");
//         req.getRequestDispatcher("showlistnews").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = "15";
//        editBlogDAO edit = new editBlogDAO();
        NewsDAO edit = new NewsDAO();
        News blog = edit.getClientFooter(id);
        System.out.println("Check: " + blog.getNewsImg());
        List<newsType> newsType = edit.getListFromNewsType();
            req.setAttribute("newsType", newsType);
        req.setAttribute("blog", blog);
        req.setAttribute("NewsID", id);

        req.getRequestDispatcher("SettingClients.jsp").forward(req, resp);

    }

}
