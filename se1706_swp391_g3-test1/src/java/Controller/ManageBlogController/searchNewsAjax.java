/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.searchNewsFromDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author admin
 */
public class searchNewsAjax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searchNewsFromDAO find = new searchNewsFromDAO();
        String search = req.getParameter("search");
        String option = req.getParameter("filter");
        String indexPage = req.getParameter("index");
        System.out.println("ok");
        if (indexPage.equals("-1")) {
            indexPage = "1";
        }
        System.out.println(option);
        if (option.equals("author")) {
            System.out.println("true");
            System.out.println("Search:" + search);
//            List<News> data = find.SearchForNameAuthor(search);
//            req.setAttribute("data", data);
//            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);

            int index = Integer.parseInt(indexPage);
            int count = find.getTotalAuthor(search);
            System.out.println("check count:"+count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<News> data = find.searchNewsFromNameAuthor(search, index);
//            PrintWriter out = resp.getWriter();
//            for (News item : data) {
//                
//        
//            out.print(""
//                   
//                    + "                                                <tr>\n"
//                    + "                                                    <td >\n"
//                    + "                                                        <span class=\"custom-checkbox\">\n"
//                    + "                                                            <input type=\"checkbox\" id=\"checkbox1\" name=\"options\" value=\" ${item.getNewsID()}\">\n"
//                    + "                                                            <label for=\"checkbox1\"></label>\n"
//                    + "                                                        </span>\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td >\n"
//                    + "                                                        <a>\n"
//                    + "                                                            "+item.getNewsID()+"\n"
//                    + "                                                        </a>\n"
//                    + "                                                        <br/>\n"
//                    + "\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td >\n"
//                    + "                                                        <a >\n"
//                    + "                                                            "+item.getNewsTypeID()+"\n"
//                    + "                                                        </a>\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td >\n"
//                    + "                                                        <a >\n"
//                    + "                                                            "+item.getNewsTitle()+"\n"
//                    + "                                                        </a>\n"
//                    + "                                                    </td>\n"
//                    + "\n"
//                    + "                                                    <td >\n"
//                    + "                                                        <style>\n"
//                    + "                                                            .custom-div {\n"
//                    + "                                                                width: 200px;\n"
//                    + "                                                                height: 150px;\n"
//                    + "                                                            }\n"
//                    + "\n"
//                    + "                                                            .custom-div img {\n"
//                    + "                                                                width: 100%;\n"
//                    + "                                                                height: 100%;\n"
//                    + "                                                                /*object-fit: cover;*/\n"
//                    + "                                                            }\n"
//                    + "                                                        </style>\n"
//                    + "                                                        <div class=\"custom-div\">\n"
//                    + "\n"
//                    + "                                                           "+item.getNewsImg()+"\n"
//                    + "\n"
//                    + "\n"
//                    + "                                                        </div>\n"
//                    + "                                                        <br/>\n"
//                    + "\n"
//                    + "                                                    </td   >\n"
//                    + "                                                    <td  >\n"
//                    + "                                                        "+item.getCreatNewsDate()+"\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td class=\"text-start\" >\n"
//                    + "                                                        <span > "+item.getAdminID()+"</span>\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td class=\"project-actions text-right\">\n"
//                    + "                                                        <a class=\"btn btn-primary btn-sm\" href=\"viewblogdetails?id=${item.getNewsID()}\">\n"
//                    + "                                                            <i class=\"fas fa-folder\">\n"
//                    + "                                                            </i>\n"
//                    + "\n"
//                    + "                                                        </a>\n"
//                    + "                                                        <a class=\"btn btn-info btn-sm\" href=\"editblogs?id=${item.getNewsID()}\">\n"
//                    + "                                                            <i class=\"fas fa-pencil-alt\">\n"
//                    + "                                                            </i>\n"
//                    + "\n"
//                    + "                                                        </a>\n"
//                    + "\n"
//                    + "                                                        <a class=\"btn btn-danger btn-sm\" data-toggle=\"modal\" href=\"#\" onclick=\"confirmDelete('${item.getNewsID()}')\" >\n"
//                    + "\n"
//                    + "\n"
//                    + "                                                            <i class=\"fas fa-trash\">\n"
//                    + "                                                            </i>\n"
//                    + "\n"
//                    + "                                                        </a>\n"
//                    + "\n"
//                    + "                                                    </td>\n"
//                    + "                                                    <td class=\"project-state\">\n"
//                    + "\n"
//                    + "                                                    </td>\n"
//                    + "\n"
//                    + "                                                </tr>\n"
//                    + "\n"
//                    + "\n"
//                    + "                                            </tbody>");
//            out.print("\n"
//                    + "                                                        <nav aria-label=\"Page navigation\">\n"
//                    + "                                                            <ul class=\"pagination justify-content-end\">\n"
//                    + "                                                                <li class=\"page-item\">\n"
//                    + "                                                                    <button type=\"button\" class=\"page-link\"  " + (index > 1 ? "" : "disabled") + "  onclick=\"search(" + (index - 1) + ")\" aria-label=\"Previous\">\n"
//                    + "                                                                        <span aria-hidden=\"true\">&laquo;</span>\n"
//                    + "                                                                        <span class=\"sr-only\">Previous</span>\n"
//                    + "                                                                    </button>\n"
//                    + "                                                                </li>\n");
//    }
//            for (int i = 1; i <= endPage; i++) {
//                out.print("<li class=\"page-item " + (index == i ? "active" : "") + " \">\n"
//                        + "                                                                        <button class=\"page-link\" type=\"button\" name=\"pageLink\" id=\"pageLink\" onclick=\"search(" + i + ")\">" + i + "</button>\n"
//                        + "                                                                    </li>");
//            }
//
//            out.print("                                                                <li class=\"page-item\">\n"
//                    + "                                                                    <button type=\"button\" class=\"page-link\" " + (index < endPage ? "" : "disabled") + " onclick=\"search(" + (index + 1) + ")\" aria-label=\"Next\">\n"
//                    + "                                                                        <span aria-hidden=\"true\">&raquo;</span>\n"
//                    + "                                                                        <span class=\"sr-only\">Next</span>\n"
//                    + "                                                                    </button>\n"
//                    + "                                                                </li>\n"
//                    + "                                                            </ul>\n"
//                    + "                                                        </nav>  \n"
//                    + "                                                    ");

        } else {
//        searchName find = new searchName();
//        List<TypeRoom> room = find.SearchForName(search);
//        searchNewsFromDAO find = new searchNewsFromDAO();

            System.out.println("hear");

            int index = Integer.parseInt(indexPage);
            int count = find.getTotalSearch(search);
            System.out.println("count: " + count);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<News> data = find.SearchForNameNewsAdmins(search, index);
            req.setAttribute("way", "search");
            req.setAttribute("option", "0");
            req.setAttribute("search", search);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);
            req.setAttribute("txtSearch", search);
            req.getRequestDispatcher("manageBlogs.jsp").forward(req, resp);

        }
    }

}
