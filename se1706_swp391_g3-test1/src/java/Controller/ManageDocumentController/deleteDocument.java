/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageDocumentController;
import DAO.DocumentDAO;
import Model.CourseDocument;
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
public class deleteDocument extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        DocumentDAO docx = new DocumentDAO();
        String id = req.getParameter("id");
        docx.deleteDocument(id);
        int count = docx.getTotalDocument();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        System.out.println(indexPage);
        List<CourseDocument> data = docx.listDocument(index);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("dataD", data);
        req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
    }
    
}
