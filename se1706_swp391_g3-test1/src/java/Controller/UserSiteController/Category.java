/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseDAO;
import Model.Course;
import Model.CourseCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String Category = (String)req.getParameter("Category").replace("-", " ");
        CourseDAO dao = new CourseDAO();
        HttpSession session = req.getSession();
        session = req.getSession();
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<CourseCategory> courses = dao.CourseCategory(Category, username, index);
        int count = dao.getTotalCourseCategory(Category, username);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        List<CourseCategory> course = dao.Category();
        req.setAttribute("link", "Category");
        req.setAttribute("Category", Category);
        req.setAttribute("username", username);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", courses);
        session.setAttribute("CourseCategory", course);
        req.getRequestDispatcher("Course.jsp").forward(req, resp);
    }

}
