/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.CourseDAO;
import Model.Course;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CourseController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao= new CourseDAO();
        
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = dao.getTotalCourse();
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        List<Course> data = dao.pagingCourse(index);
        req.setAttribute("way", "coursecontroller");
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ManageCourse.jsp").forward(req, resp);
    }
    
}
