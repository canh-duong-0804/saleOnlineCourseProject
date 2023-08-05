/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBookController;

import DAO.CourseBookDAO;
import DAO.CourseDAO;
import DAO.editBlogDAO;
import DAO.editCourseBookDAO;
import Model.Course;
import Model.Course_Book;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class editCourseBookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
CourseDAO dao = new CourseDAO();
        String id = req.getParameter("id");
        CourseBookDAO edit =new CourseBookDAO();
        Course_Book book=edit.getCourseBook(id);
        List<Course> list = dao.GetCourseList1();
        System.out.println(list);
        req.setAttribute("listtypebook", list);
        System.out.println("check: "+book.getbDescription());
//        editBlogDAO edit = new editBlogDAO();
//        News blog = edit.getBlog(id);
//
        req.setAttribute("book", book);
        req.setAttribute("bookID", id);
//
        req.getRequestDispatcher("editbook.jsp").forward(req, resp);

    }
}
