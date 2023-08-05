/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBookController;

import DAO.showListBlogDAO;
import DAO.showListCourseBookDAO;
import Model.Course_Book;
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
public class showBookCourseHomepageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        showListBlogDAO show = new showListBlogDAO();
//        showListCourseBookDAO show = new showListCourseBookDAO();
////        ArrayList<Course_Book> data = show.getListNews();
//        String indexPage = req.getParameter("index");
//        String search = req.getParameter("search");
//        int index = Integer.parseInt(indexPage);
//        int count = show.getTotalBookSearch();
//        System.out.println("count: "+count  );
//        int endPage = count / 3;
//        if (count % 3 != 0) {
//            endPage++;
//        }
//        System.out.println(index);
//        List<Course_Book> data = show.pagingAdmin(index);
//        req.setAttribute("endPage", endPage);
//        req.setAttribute("tag", index);
//        req.setAttribute("data", data);
//        req.setAttribute("search", search);
//        req.setAttribute("way", "searchbook");
//
//        req.getRequestDispatcher("showListCourseBookHomepage.jsp").forward(req, resp);
    }
}
