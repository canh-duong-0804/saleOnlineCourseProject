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
public class deleteSelectBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedValues = req.getParameterValues("options");
       CourseBookDAO delete = new CourseBookDAO();
        
         
        if (selectedValues != null) {
            for (String value : selectedValues) {
                // Xử lý giá trị được gửi từ JavaScript ở đây
                
        delete.deleteCourseBook(value);
                
        
            }
        }
//        CourseBookDAO show = new CourseBookDAO();
//        ArrayList<Course_Book> data = show.getListNews();

//        req.setAttribute("data", data);
//        req.getRequestDispatcher("manageBook.jsp").forward(req, resp);
    resp.sendRedirect("showlistbook");
    }

}

