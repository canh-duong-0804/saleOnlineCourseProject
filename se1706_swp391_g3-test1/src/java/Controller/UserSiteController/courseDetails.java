/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseDAO;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author TUF F15
 */
public class courseDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        CourseDAO course = new CourseDAO();
        Course c = course.GetCourseDetail(id); 
        req.setAttribute("course", c);
        req.setAttribute("id", id);
        req.getRequestDispatcher("coursedetails.jsp").forward(req, resp);

    }
}