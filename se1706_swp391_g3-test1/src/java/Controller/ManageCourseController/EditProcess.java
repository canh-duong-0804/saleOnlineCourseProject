/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import Model.CourseProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class EditProcess extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao= new CourseDAO();
        String id=req.getParameter("id");
        CourseProcess pc=dao.GetProcess(id);
        req.setAttribute("pc", pc);
        req.getRequestDispatcher("UpdateProcess.jsp").forward(req, resp);
    }
    
}
