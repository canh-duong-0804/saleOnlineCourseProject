/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import utils.FileUtil;

/**
 *
 * @author ADMIN
 */

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 30, // 30 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpdateProcess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Part img = req.getPart("image");
        System.out.println("img" +img);
        CourseDAO dao = new CourseDAO();
        FileUtil.saveImage(img);
        FileUtil.saveFileToBuild(img);
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        if (!FileUtil.saveImage(img).equals(f)) {

            String image = img.getSubmittedFileName();
            dao.updateProcess(id, name, image);
            System.out.println("1");
        } else {

            dao.updateProcess(id, name, "nochange");
            System.out.println("2");
        }

        resp.sendRedirect("processController");
    }

}
