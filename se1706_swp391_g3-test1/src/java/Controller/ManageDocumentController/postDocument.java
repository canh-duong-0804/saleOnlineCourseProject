/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageDocumentController;

import DAO.DocumentDAO;
import Model.CourseDocument;
import Model.CourseVideo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class postDocument extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameVideo = req.getParameter("nameVideo");
        DocumentDAO doc = new DocumentDAO();
        CourseVideo video = doc.getCourseVideo(nameVideo);
        System.out.println(video + "data");
        req.setAttribute("video", video);
        req.setAttribute("nameVideo", nameVideo);
        req.getRequestDispatcher("addDocument.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String nameVideo = req.getParameter("nameVideo");
        DocumentDAO docx = new DocumentDAO();
        CourseVideo video = docx.getCourseVideo(nameVideo);
        System.out.println("check: " + video);
        String id = req.getParameter("id");
        String nameDoc = req.getParameter("name");
        String Status = String.valueOf("1");
        String videoID = Integer.toString(video.getCourseVideoID());
        
        Part filePart = req.getPart("file");

        // Extract the filename from the part
        String fileName = (String) getFileName(filePart);

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
        docx.addDocument(nameDoc, fileName, Status, videoID);
        req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
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
