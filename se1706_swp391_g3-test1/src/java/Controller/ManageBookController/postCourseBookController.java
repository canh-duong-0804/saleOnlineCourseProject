/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBookController;

import DAO.CourseBookDAO;
import DAO.CourseDAO;

import Model.Course;
import Model.Course_Book;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class postCourseBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        List<Course> list = dao.GetCourseList1();
        System.out.println(list);
        req.setAttribute("listtypebook", list);
        req.getRequestDispatcher("postBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hel");
//     //        try ( PrintWriter out = resp.getWriter()) {
        String NameBook = req.getParameter("bookname");
        String price = req.getParameter("pricebook");
        String stock = req.getParameter("stock");
        
        String bookStatus = String.valueOf("1");
        String bookImg = req.getParameter("imgbook");
        String bookDescription = req.getParameter("description");
//           
        String typebook = req.getParameter("typebook");
        System.out.println("Check price "+price);
        Course_Book book = new Course_Book("1", NameBook, price.replaceAll("[^\\d]", ""), bookImg, Integer.parseInt(stock),bookDescription);
        CourseBookDAO post = new CourseBookDAO();
        post.postCourseBook(book, typebook);
        CourseBookDAO show = new CourseBookDAO();

        //int count = show.getcountcoursebook();
        //post.PostTypeBook(typebook,count);
//        ArrayList<Course_Book> data = show.getListNews();
//
//        req.setAttribute("data", data);

        resp.sendRedirect("showlistbook");

//        }
    }

}
