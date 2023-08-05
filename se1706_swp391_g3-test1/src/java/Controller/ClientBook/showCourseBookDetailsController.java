/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ClientBook;

import DAO.CourseBookDAO;
import DAO.editCourseBookDAO;
import Model.Course_Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class showCourseBookDetailsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id="";
        String input= req.getPathInfo();
         int lastDashIndex = input.lastIndexOf("-");
        if (lastDashIndex != -1 && lastDashIndex + 1 < input.length()) {
             id=input.substring(lastDashIndex + 1);
        }
        CourseBookDAO edit =new CourseBookDAO();
        Course_Book book=edit.getCourseBook(id);
//        editBlogDAO edit = new editBlogDAO();
//        News blog = edit.getBlog(id);
//
        req.setAttribute("book", book);
        req.setAttribute("bookID", id);
//
        req.getRequestDispatcher("../viewbookclientdetails.jsp").forward(req, resp);

    }
}
