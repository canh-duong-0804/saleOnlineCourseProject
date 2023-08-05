/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ClientBook;

import DAO.searchBookFromAdminDAO;
import DAO.searchNewsFromDAO;
import DAO.showListCourseBookDAO;
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
 * @author admin
 */
public class searchbookclients extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
       
      //        showListBlogDAO show = new showListBlogDAO();
        searchBookFromAdminDAO show = new searchBookFromAdminDAO();
//        ArrayList<Course_Book> data = show.getListNews();
 String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        String search=req.getParameter("search");
        int index = Integer.parseInt(indexPage);
         int count = show.getTotalSearchBook(search);
         System.out.println("check: "+count);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        System.out.println(index);
        List<Course_Book> data = show.pagingAdminSearchCourseBook(index,search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.setAttribute("search", search);
        req.setAttribute("way", "searchnamebookclients");

        req.getRequestDispatcher("showListCourseBookHomepage.jsp").forward(req, resp);
    }
}
