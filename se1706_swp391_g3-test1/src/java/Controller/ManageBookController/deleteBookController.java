/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBookController;

import DAO.CourseBookDAO;
import DAO.deleteBlogDAO;
import DAO.deleteBookDAO;
import DAO.showListBlogDAO;

import DAO.showListCourseBookDAO;
import Model.Course_Book;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class deleteBookController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//         deleteBlogDAO delete = new deleteBlogDAO();
//         showListBlogDAO show = new showListBlogDAO();
//        delete.deleteProduct(id);
//         ArrayList<News> data = show.getListNews();
        CourseBookDAO delete = new CourseBookDAO();
        showListCourseBookDAO show = new showListCourseBookDAO();
        delete.deleteCourseBook(id);
//        ArrayList<Course_Book> data = show.getListNews();
//
//        req.setAttribute("data", data);
//        req.getRequestDispatcher("manageBook.jsp").forward(req, resp);
resp.sendRedirect("showlistbook");
    }

}
