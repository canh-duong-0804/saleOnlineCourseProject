/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CourseVideoController;

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
 * @author TUF F15
 */
public class ManageCourseVideo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        CourseDAO dao= new CourseDAO();
//        List<Course> data = dao.GetCourseList1();
//        
//        req.setAttribute("data", data);
//        req.getRequestDispatcher("ManageVideo.jsp").forward(req, resp);
        CourseDAO dao = new CourseDAO();

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
        req.setAttribute("way", "viewCourseVideo");
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ManageVideo.jsp").forward(req, resp);

    }

}
