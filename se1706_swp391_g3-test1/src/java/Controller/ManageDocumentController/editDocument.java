/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageDocumentController;

import DAO.DocumentDAO;
import Model.CourseDocument;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class editDocument extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String nameDoc = req.getParameter("name");
        String videoID = req.getParameter("videoID");
        DocumentDAO docx = new DocumentDAO();
        Part filePart = req.getPart("file");

        // Extract the filename from the part
        String fileName = getFileName(filePart);

        // Define the directory to save the uploaded file
        String savePath = "C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\DocsTest"; // Change this to your desired directory

        // Create the save directory if it doesn't exist
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        // Save the file to the specified directory
        try ( InputStream inputStream = filePart.getInputStream()) {
            Files.copy(inputStream, new File(saveDir, fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        docx.editDocument(id, nameDoc, fileName);
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        List<CourseDocument> data = docx.listDocument(index);
        int count = docx.getTotalDocument();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        System.out.println(indexPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("dataD", data);
        req.getRequestDispatcher("manageDocument.jsp").forward(req, resp);
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }

}
