/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.LoginDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.FileUtil;

/**
 *
 * @author TUF F15
 */
@WebServlet(name = "editUser", urlPatterns = {"/editUser"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 30, // 30 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class editUserProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("username: " + username);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        boolean check = true;
        User u = (User) session.getAttribute("userInfo");
        Part filePart = req.getPart("image");
        FileUtil.saveImage(filePart);
        FileUtil.saveFileToBuild(filePart);
        String fileName = filePart.getSubmittedFileName();
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        LoginDAO login = new LoginDAO();
        System.out.println(FileUtil.saveImage(filePart));
        String alert = "";
        List<User> userArr = login.getListUserProfile();
        for (User s : userArr) {
            if (s.getuEmail().equals(email) && !s.getuUsername().equals(username)) {
                alert = "Email already used";
                req.setAttribute("alert", alert);
                check = false;
                break;
            }
        }
        if (check) {
            if (FileUtil.saveImage(filePart).equals(f)) {
                login.updateUserProfile(username, name, email, phone, address, dob);
                session.removeAttribute("userInfo");
                List<User> userArr1 = login.getListUserProfile();

                for (User s : userArr1) {
                    if (s.getGoogleID() != null) {

                        req.setAttribute("tag", "1");
                    } else {
                        req.setAttribute("tag", "0");
                    }
                    if (s.getuUsername().equals(username)) {
                        resp.sendRedirect("profile");
//                        req.setAttribute("userInfo", s);
//                        req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
                    }
                }
            } else {
                login.updateUserProfile(username, name, email, phone, address, dob, fileName);
                session.removeAttribute("userInfo");
                List<User> userArr1 = login.getListUserProfile();
                for (User s : userArr1) {
                    if (s.getGoogleID() != null) {

                        req.setAttribute("tag", "1");
                    } else {
                        req.setAttribute("tag", "0");
                    }
                    if (s.getuUsername().equals(username)) {
                        resp.sendRedirect("profile");
//                        req.setAttribute("userInfo", s);
//                        req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
                    }
                }

            }
        } else {
            session.removeAttribute("userInfo");
            List<User> userArr1 = login.getListUserProfile();
            for (User s : userArr1) {
                if (s.getGoogleID() != null) {

                    req.setAttribute("tag", "1");
                } else {
                    req.setAttribute("tag", "0");
                }
                if (s.getuUsername().equals(username)) {
                    resp.sendRedirect("profile");
//                    req.setAttribute("userInfo", s);
//                    req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
                }
            }
//            req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
        }

    }
}
