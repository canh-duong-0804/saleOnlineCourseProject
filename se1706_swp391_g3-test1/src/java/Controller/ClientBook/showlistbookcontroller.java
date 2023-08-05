/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ClientBook;

import DAO.CourseBookDAO;
import DAO.CourseDAO;
import DAO.showListBlogDAO;
import DAO.showListCourseBookDAO;
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
public class showlistbookcontroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        showListBlogDAO show = new showListBlogDAO();
        CourseBookDAO show = new CourseBookDAO();
//        ArrayList<Course_Book> data = show.getListNews();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = show.getTotalCourseBook();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        System.out.println(index);
        CourseDAO dao = new CourseDAO();
        List<Course> list = dao.GetCourseList1();
        req.setAttribute("list", list);
        List<Course_Book> data = show.pagingClientCourseBook(index);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.setAttribute("way", "clientbookcourse");
        req.getRequestDispatcher("showListCourseBookHomepage.jsp").forward(req, resp);
    }

}
