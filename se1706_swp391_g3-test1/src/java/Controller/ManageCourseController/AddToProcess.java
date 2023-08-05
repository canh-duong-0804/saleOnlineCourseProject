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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class AddToProcess extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
        HttpSession session=  req.getSession(true);
        session.setAttribute("processId", id);
        CourseDAO dao= new CourseDAO();
        
        
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = dao.getTotalCourseProcess();
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        System.out.println("End page: "+endPage);
        List<Course> data = dao.pagingCourseProcess(index,id);
        System.out.println("Index :"+index);
        System.out.println("Id :"+id);
        System.out.println("Data length: "+data.size());
        req.setAttribute("way", "addtoprocess");
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("CourseToProcess.jsp").forward(req, resp);

    }
    
}
