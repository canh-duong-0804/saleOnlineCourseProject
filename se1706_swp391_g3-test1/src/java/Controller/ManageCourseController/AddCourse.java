/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import DAO.CourseDAO;
import DAO.LoginDAO;
import Model.Admin;
import Model.Course;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.Date;
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
public class AddCourse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.LoginDAO a = new DAO.LoginDAO();
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("account");
        String adminId=a.getId(admin.getaUsername());
        CourseDAO dao = new CourseDAO();
        LoginDAO login = new LoginDAO();
        
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        price = price.replaceAll("[^\\d]", "");
        //System.out.println("Course price?"+price);
        Part img = req.getPart("image");
        FileUtil.saveImage(img);
        FileUtil.saveFileToBuild(img);
        String fileName = img.getSubmittedFileName();
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        String link = req.getParameter("link");
        Date date = new Date();
        String date1 = date.toString();
        Course cs = new Course(name, price, "True", description, date1, fileName, "0", link, adminId);
        System.out.println(cs);
        dao.addCourse(cs);
        resp.sendRedirect("coursecontroller");
      
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.LoginDAO a = new DAO.LoginDAO();
        HttpSession session = req.getSession(true);
        Admin admin = (Admin) session.getAttribute("account");
        String adminId=a.getId(admin.getaUsername());
        CourseDAO dao = new CourseDAO();
        LoginDAO login = new LoginDAO();
        
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        price = price.replaceAll("[^\\d]", "");
        //System.out.println("Course price?"+price);
        Part img = req.getPart("image");
        FileUtil.saveImage(img);
        FileUtil.saveFileToBuild(img);
        String fileName = img.getSubmittedFileName();
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        String link = req.getParameter("link");
        Date date = new Date();
        String date1 = date.toString();
        Course cs = new Course(name, price, "True", description, date1, fileName, "0", link, adminId);
        System.out.println(cs);
        dao.addCourse(cs);
        resp.sendRedirect("coursecontroller");
    }

}
