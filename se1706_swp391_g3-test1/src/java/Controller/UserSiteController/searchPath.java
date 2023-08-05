/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseDAO;
import Model.CourseProcess;
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
public class searchPath extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        String search = req.getParameter("search"); 
         String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);
        List<CourseProcess> c = dao.SearchProcessCourse(search,index);
        int count = dao.getTotalSearchProcessCourse(search);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        req.setAttribute("link", "searchPath");
        req.setAttribute("search", search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", c);
        req.getRequestDispatcher("learningPath.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        String search = req.getParameter("search"); 
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);
        List<CourseProcess> c = dao.SearchProcessCourse(search,index);
        int count = dao.getTotalSearchProcessCourse(search);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        req.setAttribute("link", "searchPath");
        req.setAttribute("search", search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", c);
        req.getRequestDispatcher("learningPath.jsp").forward(req, resp);
    }
    
    
    
}
