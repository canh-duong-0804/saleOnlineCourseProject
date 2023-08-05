/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.LoginDAO;
import DAO.EmployeeDAO;
import DAO.OrderDAO;
import Model.Admin;
import Model.Order;
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
@WebServlet(name = "profile", urlPatterns = {"/profile"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 30, // 30 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class profileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        String des = req.getParameter("description");
        boolean check = true;
       
        Admin u = (Admin) session.getAttribute("userInfo");
        Part filePart = req.getPart("image");
        FileUtil.saveImage(filePart);
        FileUtil.saveFileToBuild(filePart);
        String fileName = filePart.getSubmittedFileName();
        File f = new File("C:\\Users\\TUF F15\\Desktop\\Project\\se1706_swp391_g3\\web\\img");
        LoginDAO t = new LoginDAO();
        System.out.println(FileUtil.saveImage(filePart));
        String alert = "";
        ArrayList<Admin> adminArr = t.getListAdminProfile();
        for (Admin s : adminArr) {
            if (s.getaEmail().equals(email) && !s.getaUsername().equals(username)) {
                alert = "Email already used";
                req.setAttribute("alert", alert);
                check = false;
                break;
            }
        }
        if (check) {
            if (FileUtil.saveImage(filePart).equals(f)) {
                t.updateAdminProfile(username, name, email, phone, address, dob, des);
//                session.removeAttribute("userInfo");
//                ArrayList<Admin> adminArr1 = t.getListAdminProfile();
//                for (Admin s : adminArr1) {
//                    if (s.getaUsername().equals(username)) {
//                        req.setAttribute("userInfo", s);
//                        req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
//                    }
//                }
            resp.sendRedirect("profile");
            } else {
                t.updateAdminProfile(username, name, email, phone, address, dob, des, fileName);
//                session.removeAttribute("userInfo");
//                ArrayList<Admin> adminArr1 = t.getListAdminProfile();
//                for (Admin s : adminArr1) {
//                    if (s.getaUsername().equals(username)) {
//                        req.setAttribute("userInfo", s);
//                        req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
//                    }
//                }
                resp.sendRedirect("profile");

            }
        } else {
            session.removeAttribute("userInfo");
//            ArrayList<Admin> adminArr1 = t.getListAdminProfile();
//            for (Admin s : adminArr1) {
//                if (s.getaUsername().equals(username)) {
//                    req.setAttribute("userInfo", s);
//                    req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
//                }
//            }
//            req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
            resp.sendRedirect("profile");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDAO login = new LoginDAO();
        EmployeeDAO t = new EmployeeDAO();
        OrderDAO uOrder = new OrderDAO();
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("useranme: " + username);
//        String username = req.getParameter("username");    
        List<User> userArr = login.getListUserProfile();
        ArrayList<Admin> adminArr = login.getListAdminProfile();
        
//        req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
        for (User s : userArr) {
            if (s.getuUsername().equals(username)) {
                ArrayList<Order> dataOrder = uOrder.getUserOrderList(Integer.parseInt(s.getUserID()));
                System.out.println(s.getGoogleID());
                if(s.getGoogleID() != null){
                    
                   req.setAttribute("tag", "1");
                }else{
                    req.setAttribute("tag", "0");
                }
                req.setAttribute("userInfo", s);
                session.setAttribute("userInfo", s);
                req.setAttribute("user", username);
                req.setAttribute("dataOrder", dataOrder);
                req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
            }
        }
        for (Admin a : adminArr) {
            if (a.getaUsername().equals(username)) {
                req.setAttribute("userInfo", a);
                session.setAttribute("userInfo", a);
                req.setAttribute("user", username);
                req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
            }
        }

    }

}


//        