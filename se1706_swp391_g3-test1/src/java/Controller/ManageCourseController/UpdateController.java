/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
public class UpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO dao = new CourseDAO();
        DAO.LoginDAO a = new DAO.LoginDAO();
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("account");
        

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        price = price.replaceAll("[^\\d]", "");
        String description = req.getParameter("description");
        String discount = req.getParameter("discount");
        Part img = req.getPart("image");
        String link="";
        FileUtil.saveImage(img);
        FileUtil.saveFileToBuild(img);
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        if(!FileUtil.saveImage(img).equals(f)){
       
        String fileName = img.getSubmittedFileName();
        
        
        dao.updateCourse(id, name, price, description, fileName, link);
        String adminID = dao.getAdminID(admin.getaUsername());
        System.out.println(discount);
        System.out.println(adminID);
        dao.updateDiscount(discount, adminID, id);
        }else{
            dao.updateCourse(id, name, price, description, "nochange", link);
        String adminID = dao.getAdminID(admin.getaUsername());
        System.out.println(discount);
        System.out.println(adminID);
        dao.updateDiscount(discount, adminID, id);
        }
        
        
        resp.sendRedirect("coursecontroller");
    }

}
