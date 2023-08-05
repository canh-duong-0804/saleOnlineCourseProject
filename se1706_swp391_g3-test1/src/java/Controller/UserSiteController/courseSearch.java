/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import Model.Course;
import DAO.CourseDAO;
import Model.CourseCategory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class courseSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session = req.getSession();
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }
        String search = req.getParameter("search");
        CourseDAO dao = new CourseDAO();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);
        List<Course> data = dao.GetCourseListBySearch(search, username, index);
        int count = dao.getTotalSearch(search, username);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        List<CourseCategory> course = dao.Category();
        System.out.println(data);
        req.setAttribute("username", username);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.setAttribute("search", search);
        req.setAttribute("link", "courseSearch");
        req.getRequestDispatcher("Course.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session = req.getSession();
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }
        String search = req.getParameter("search");
        CourseDAO dao = new CourseDAO();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);
        List<Course> data = dao.GetCourseListBySearch(search, username, index);
        int count = dao.getTotalSearch(search, username);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        List<CourseCategory> course = dao.Category();
        System.out.println(data);
        req.setAttribute("link", "courseSearch");
        req.setAttribute("data", data);
        req.setAttribute("username", username);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("search", search);
        session.setAttribute("CourseCategory", course);
        req.getRequestDispatcher("Course.jsp").forward(req, resp);
    }

}
