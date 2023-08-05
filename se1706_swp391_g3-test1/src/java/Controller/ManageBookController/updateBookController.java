/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBookController;

import DAO.CourseBookDAO;

import Model.Course_Book;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class updateBookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//                try ( PrintWriter out = resp.getWriter()) {
        String id = req.getParameter("id");
        String bookname = req.getParameter("bookname");
        String price = req.getParameter("pricebook");
        String bookStatus = "1";
        String bookImg = req.getParameter("imgbook");
        String pr = "" + price.replace("?", "").replace(",", ".");
        String bookDescription = req.getParameter("description");
        System.out.println("Check:");
        System.out.println("id: " + id);
        System.out.println(bookname);
        System.out.println(pr);
        System.out.println(bookImg);
        System.out.println(price.replace("?", "").replace(",", "."));
String typebook=req.getParameter("typebook");
        String cleanedStr = price.replaceAll("[^0-9.]", ""); // Loại bỏ tất cả các ký tự không phải số và dấu "."
        //double value = Double.parseDouble(cleanedStr);
//           
//        Course_Book book = new Course_Book(bookname, price, bookStatus, bookImg);
//        updateCourseBookDAO update = new updateCourseBookDAO();
        CourseBookDAO update = new CourseBookDAO();
        update.updateCourseBook(id, bookname, price.replaceAll("[^\\d]", ""), bookStatus, bookImg,bookDescription,typebook);

//        editBlogDAO update = new editBlogDAO();
//        update.updateBlogs(id,ft.format(date), titleDetails,textTitle, imgNews, AdminID);
//        showListCourseBookDAO show = new showListCourseBookDAO();
//        ArrayList<Course_Book> data = show.getListNews();
//
//        req.setAttribute("data", data);
        resp.sendRedirect("showlistbook");

    }

}
