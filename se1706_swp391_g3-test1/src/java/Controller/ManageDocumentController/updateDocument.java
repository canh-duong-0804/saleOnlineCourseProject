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
/**
 *
 * @author Admin
 */
public class updateDocument extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DocumentDAO doc = new DocumentDAO();
        CourseDocument docx = doc.getCourseDocument(id);
        
        
        System.out.println(docx);
        req.setAttribute("docx", docx);
        req.setAttribute("ID", id);
        req.getRequestDispatcher("editDocument.jsp").forward(req, resp);

    }
}
