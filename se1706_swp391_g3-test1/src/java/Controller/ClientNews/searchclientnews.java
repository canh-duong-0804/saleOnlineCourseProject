/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ClientNews;

import DAO.searchNewsFromDAO;
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
public class searchclientnews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searchNewsFromDAO find = new searchNewsFromDAO();
        String search = req.getParameter("search");
        String option = req.getParameter("filter");
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        System.out.println(option);

////        searchName find = new searchName();
//        List<TypeRoom> room = find.SearchForName(search);
//        searchNewsFromDAO find = new searchNewsFromDAO();
//            int index = Integer.parseInt(indexPage);
//            int count = find.getTotalAuthor(search);
//            System.out.println(count);
//            int endPage = count / 3;
//            if (count % 3 != 0) {
//                endPage++;
//            }
//            List<News> data = find.SearchForName(search);
//            req.setAttribute("data", data);
        int index = Integer.parseInt(indexPage);
        int count = find.getTotalSearch(search);
        System.out.println("Search: "+search);
        System.out.println("count: " + count);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        List<News> data = find.SearchForNameNewsClients(search, index);
        req.setAttribute("way", "searchnewsclients");
        req.setAttribute("option", "0");
        req.setAttribute("search", search);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("clientnewshomepage.jsp").forward(req, resp);

    }
}


