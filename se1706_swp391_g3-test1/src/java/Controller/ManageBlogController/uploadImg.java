/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Collection;
//import org.json.JSONObject;

/**
 *
 * @author admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class uploadImg extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contentType = request.getContentType();
        System.out.println("check img");
        if (contentType != null && contentType.contains("multipart/form-data")) {
            try {
                Collection<Part> parts = request.getParts();

                for (Part part : parts) {
                    String fileName = getFileName(part);
                    if (fileName != null && !fileName.isEmpty()) {
                        String uploadDirectory = getServletContext().getRealPath("") + File.separator + "uploads";
                        String uploadWeb = getServletContext().getRealPath("") + request.getParameter("directory");
                        File uploadDir = new File(uploadDirectory);
                        uploadDir.mkdirs(); // Tạo thư mục 'uploads' nếu chưa tồn tại
                        File uploadDir1 = new File(uploadWeb);
                        uploadDir1.mkdirs(); // Tạo thư mục 'uploads' nếu chưa tồn tại
                        String filePath = uploadDirectory + File.separator + fileName;

                        part.write(filePath);
                        part.write(uploadWeb + File.separator + fileName);
//duong

                        // Trả về URL của ảnh đã tải lên
                        String imageUrl = request.getContextPath() + "/uploads/" + fileName;
                        response.setContentType("application/json");
                        response.getWriter().write("{\"location\": \"" + imageUrl + "\"}");
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
            }
        }

        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"error\": \"No file data found\"}");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] contentDispositionParts = contentDisposition.split(";");
        for (String partHeader : contentDispositionParts) {
            if (partHeader.trim().startsWith("filename")) {
                return partHeader.substring(partHeader.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
