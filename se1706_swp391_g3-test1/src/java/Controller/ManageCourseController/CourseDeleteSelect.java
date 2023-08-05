/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import Model.Course;
import Model.CourseProcess;
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
public class CourseDeleteSelect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedValues = req.getParameterValues("options");
        CourseDAO dao = new CourseDAO();
        

        if (selectedValues != null) {
            for (String value : selectedValues) {
                // Xử lý giá trị được gửi từ JavaScript ở đây

                dao.deleteCourse(value);
                System.out.println(value);
            }
        }
        List<Course> data = dao.GetCourseList1();

        req.setAttribute("data", data);
        req.getRequestDispatcher("ManageCourse.jsp").forward(req, resp);

    }

}
