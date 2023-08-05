/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CourseVideoController;

import DAO.CourseDAO;
import DAO.CourseVideoDAO;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUF F15
 */
public class SearchCourseVideo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String search = req.getParameter("search");
//        String op = req.getParameter("option");
//        List<Course> data ;
//        CourseVideoDAO dao = new CourseVideoDAO();
//        if (op.equals("1")) {
//            data = dao.GetCourseListByName(search);
//            System.out.println(data);
//        } else {
//            data = dao.GetCourseListByCreator(search);
//            System.out.println(data);
//        }
//        req.setAttribute("data", data);
//        req.getRequestDispatcher("ManageVideo.jsp").forward(req, resp);
        String search = req.getParameter("search");
        String op = req.getParameter("option");
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        int count;
//        System.out.println(count);
        System.out.println(op);
        List<Course> data;
        CourseDAO dao = new CourseDAO();
        if (op.equals("1")) {
            data = dao.GetCourseListByName(search, index);
            count = dao.CountCourseByName(search);
            req.setAttribute("way", "searchCourseVideo");
            req.setAttribute("option", 1);
        } else {
            data = dao.GetCourseListByCreator(search, index);
            count = dao.CountCourseByCreator(search);
            req.setAttribute("way", "searchCourseVideo");
            req.setAttribute("option", 2);
        }
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        req.setAttribute("search", search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ManageVideo.jsp").forward(req, resp);
    }

}
