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
public class displayDocument extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        DocumentDAO docx = new DocumentDAO();
        int index = Integer.parseInt(indexPage);
        String[] ops = req.getParameterValues("delete");
        if (ops == null) {
            resp.sendRedirect("displayDocument?message=false");
        } else {
            List<CourseDocument> data = docx.listDocument(index);
            int count = docx.getTotalDocument();
            for (String s : ops) {
                docx.deleteDocument(s);
            }

            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }

            req.setAttribute("link", "displayDocument");
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("dataD", data);
            req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        DocumentDAO docx = new DocumentDAO();
        List<CourseDocument> data = docx.listDocument(index);
        int count = docx.getTotalDocument();
        int endPage = count / 10;
        if (count % 10 != 0) {
            endPage++;
        }
        req.setAttribute("link", "displayDocument");
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("dataD", data);
        req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
//    resp.sendRedirect("manageDocument.jsp");
    }

}
