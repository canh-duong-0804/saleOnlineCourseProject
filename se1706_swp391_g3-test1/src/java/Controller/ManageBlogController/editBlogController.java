/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class editBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        NewsDAO edit = new NewsDAO();
        News blog = edit.getBlogInfor(id);
        String banner = req.getParameter("setting");
        System.out.println("ch: "+banner);
        req.setAttribute("blog", blog);
        req.setAttribute("NewsID", id);
        if (banner!=null) {
            req.getRequestDispatcher("editBanner.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("editPostnews.jsp").forward(req, resp);
        }
    }

}
