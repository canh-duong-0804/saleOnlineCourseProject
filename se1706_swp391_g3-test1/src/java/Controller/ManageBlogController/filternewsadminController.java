/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.showListBlogDAO;
import Model.News;
import Model.newsType;
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
public class filternewsadminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        showListBlogDAO show = new showListBlogDAO();
        NewsDAO show = new NewsDAO();
        String indexPage = req.getParameter("index");

        String option = req.getParameter("filter");
        System.out.println("test: " + option);
        if (indexPage == null) {
            indexPage = "1";
        }

        if (option.equals("3")) {
            resp.sendRedirect("settingClients");

        } else if (option.equals("4")) {
            resp.sendRedirect("showlistnarbar");

        } else if (option.equals("5")) {
            resp.sendRedirect("showListQuickLink");

        } else if (option.equals("6")) {
            resp.sendRedirect("showbanner");

        } else if (option.equals("7")) {
            resp.sendRedirect("showlistnews");
        } else {
            int index = Integer.parseInt(indexPage);
            int count = show.getTotalNews(option);
//        System.out.println(count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<News> data = show.pagingNewsFilter(index, option);
            List<newsType> newsType = show.getListFromNewsType();
            req.setAttribute("newsType", newsType);
            req.setAttribute("way", "filter");
            req.setAttribute("option", option);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);
            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);

        }

//        sale
//        if (option.equals("1")) {
//            int index = Integer.parseInt(indexPage);
//            int count = show.getTotalNews(option);
////        System.out.println(count);
//            int endPage = count / 3;
//            if (count % 3 != 0) {
//                endPage++;
//            }
//            List<News> data = show.pagingNewsFilter(index, option);
//
//            req.setAttribute("way", "filter");
//            req.setAttribute("option", "1");
//            req.setAttribute("endPage", endPage);
//            req.setAttribute("tag", index);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
//
//        } else if (option.equals("2")) {
//            int index = Integer.parseInt(indexPage);
//            int count = show.getTotalNews(option);
////        System.out.println(count);
//            int endPage = count / 3;
//            if (count % 3 != 0) {
//                endPage++;
//            }
//            List<News> data = show.pagingNewsFilter(index, option);
//            req.setAttribute("way", "filter");
//            req.setAttribute("option", "2");
//            req.setAttribute("endPage", endPage);
//            req.setAttribute("tag", index);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
//        } else if (option.equals("0")) {
//
//            req.getRequestDispatcher("showlistnews").forward(req, resp);
//        } else if (option.equals("10")) {
//            int index = Integer.parseInt(indexPage);
//            int count = show.getTotalNews(option);
////        System.out.println(count);
//            int endPage = count / 3;
//            if (count % 3 != 0) {
//                endPage++;
//            }
//            List<News> data = show.pagingNews();
//            req.setAttribute("way", "filter");
//            req.setAttribute("option", "10");
//            req.setAttribute("endPage", endPage);
//            req.setAttribute("tag", index);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
//
//        } else if (option.equals("11")) {
//            int index = Integer.parseInt(indexPage);
//            int count = show.getTotalNews(option);
////        System.out.println(count);
//            int endPage = count / 3;
//            if (count % 3 != 0) {
//                endPage++;
//            }
//            List<News> data = show.pagingNewsFilter(index, option);
//
//            req.setAttribute("endPage", endPage);
//            req.setAttribute("tag", index);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
//
//        } else if (option.equals("Footer")) {
//            resp.sendRedirect("settingClients");
//
//        } else if (option.equals("Narbar")) {
//            resp.sendRedirect("showlistnarbar");
//
//        } else if (option.equals("Quick link")) {
//            resp.sendRedirect("showListQuickLink");
//
//        } else if (option.equals("banner")) {
//            resp.sendRedirect("showbanner");
//
//        } else {
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);
//        }
    }
}
