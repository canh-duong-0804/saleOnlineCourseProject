package Controller.ManageBlogController;

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
import java.util.Collection;
import jdk.nashorn.internal.objects.NativeError;

@MultipartConfig()
public class uploadImageMce extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part imagePart = req.getPart("file");

        String uploadDirectory = "C:\\Users\\admin\\Desktop\\project\\se1706_swp391_g3\\web\\upload\\images";

        // Lưu trữ ảnh vào thư mục uploadDirectory
        try ( InputStream inputStream = imagePart.getInputStream()) {
            Files.copy(inputStream, new File(uploadDirectory, imagePart.getSubmittedFileName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        // Gửi đường dẫn ảnh trở lại cho trình duyệt
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("{\"location\": \"" + imagePart.getSubmittedFileName() + "\"}");
    }

   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentType = req.getContentType();
        if (contentType != null && contentType.contains("multipart/form-data")) {
            try {
                Collection<Part> parts = req.getParts();
                for (Part part : parts) {
                    String fileName = getFileName(part);
                    if (fileName != null && !fileName.isEmpty()) {
                        String filePath = getServletContext().getRealPath("") + File.separator + "uploads" + File.separator + fileName;
                        part.write(filePath);
                        String imageUrl = req.getContextPath() + "/uploads/" + fileName;
                        resp.setContentType("application/json");
                        resp.getWriter().write("{\"location\": \"" + imageUrl + "\"}");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                resp.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
                // Xử lý lỗi nếu có
            }
        }
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