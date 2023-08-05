/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageDocumentController;

import jakarta.servlet.http.HttpServlet;
import DAO.DocumentDAO;
import Model.CourseDocument;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class searchDocument extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        DocumentDAO docx = new DocumentDAO();
        List<CourseDocument> data;
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        String op = req.getParameter("option");
        int index = Integer.parseInt(indexPage);
        int count;
         if (op.equals("1")) {
            data = docx.searchname(index, search);
            count = docx.getTotalSearchName(search);
           req.setAttribute("link", "searchDocument");
            req.setAttribute("option", 1);
        } else {
            data = docx.searchCourse(index, search);
            count = docx.getTotalSearch(search);
            req.setAttribute("link", "searchDocument");
            req.setAttribute("option", 2);
        }
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }
       
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("dataD", data);
        req.setAttribute("search", search);
        req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String search = req.getParameter("search");
        DocumentDAO docx = new DocumentDAO();
        List<CourseDocument> data;
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        String op = req.getParameter("option");
        int index = Integer.parseInt(indexPage);
        int count;
         if (op.equals("1")) {
            data = docx.searchname(index, search);
            count = docx.getTotalSearchName(search);
           req.setAttribute("link", "searchDocument");
            req.setAttribute("option", 1);
        } else {
            data = docx.searchCourse(index, search);
            count = docx.getTotalSearch(search);
            req.setAttribute("link", "searchDocument");
            req.setAttribute("option", 2);
        }
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }
       
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("dataD", data);
        req.setAttribute("search", search);
        req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
    }

}
