/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Clients;

import DAO.CourseDAO;
import DAO.NewsDAO;
import DAO.editBlogDAO;
import DAO.showListBlogDAO;
import Model.Course;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author admin
 */
public class showlistuserclients extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = "";
        NewsDAO edit = new NewsDAO();
        News blog = edit.getClientFooter(id);
        
        
         String newsTypeID = "";

        NewsDAO show = new NewsDAO();
        System.out.println("okee");
        List<News> listNabar = show.getListNarbarClient(newsTypeID);
        for (News news : listNabar) {
            System.out.println("check213: "+news);
            
        }

       
        request.setAttribute("blog", blog);
        request.setAttribute("NewsID", id);

        request.setAttribute("listNabar", listNabar);
       
        request.getRequestDispatcher("narbarclients.jsp").forward(request, response);

        

    }
}