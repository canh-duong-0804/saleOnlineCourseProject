/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class GetCourseDetail extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao= new CourseDAO();
        String id= req.getParameter("id");
        Course cs= dao.GetCourseDetail(id);
        req.setAttribute("cs", cs);
        List<String> list= dao.getListVideo(id);
        req.setAttribute("size", list.size());
        req.setAttribute("list", list);
        req.getRequestDispatcher("CourseDetail.jsp").forward(req, resp);
        }
    
    
}
