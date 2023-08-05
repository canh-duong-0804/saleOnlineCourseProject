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

/**
 *
 * @author admin
 */
public class homepageClients extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = "14";
        NewsDAO edit = new NewsDAO();
        News blog = edit.getClientFooter(id);
        System.out.println(blog);
        System.out.println("Check: " + blog.getNewsImg());
        req.setAttribute("blog", blog);
        req.setAttribute("NewsID", id);

        req.getRequestDispatcher("homePage").forward(req, resp);

    }
}
