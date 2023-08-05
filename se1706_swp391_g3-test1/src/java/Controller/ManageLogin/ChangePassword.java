/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageLogin;

import Controller.Lib;
import DAO.EmployeeDAO;
import DAO.ForgotLogOutDAO;
import DAO.LoginDAO;
import DAO.OrderDAO;

import Model.Admin;
import Model.Order;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChangePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String old_password = req.getParameter("old_password");
        String new_password = req.getParameter("new_password");
        String confirm_password = req.getParameter("confirm_password");
        
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        String message = Lib.checkPass(new_password, confirm_password);
        if (message.equals("Success")) {
            LoginDAO a = new LoginDAO();
            if (a.checkUser(username, old_password) == 1) {
                if (!old_password.equals(new_password)) {
                    ForgotLogOutDAO b = new ForgotLogOutDAO();
                    b.updatePassword(username, new_password);
                    LoginDAO login = new LoginDAO();
                    EmployeeDAO t = new EmployeeDAO();
                    OrderDAO uOrder = new OrderDAO();
                    
                    String user = (String) session.getAttribute("user");
                    List<User> userArr = login.getListUserProfile();
                    ArrayList<Admin> adminArr = a.getListAdminProfile();
                    System.out.println("ssss"+adminArr);
                    req.setAttribute("messages", "Password Changed");
//        req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
                    for (User s : userArr) {
                        if (s.getuUsername().equals(username)) {
                            ArrayList<Order> dataOrder = uOrder.getUserOrderList(Integer.parseInt(s.getUserID()));
                            System.out.println(s.getGoogleID());
                            if (s.getGoogleID() != null) {
                                req.setAttribute("tag", "1");
                            } else {
                                req.setAttribute("tag", "0");
                            }
                            req.setAttribute("userInfo", s);
                            session.setAttribute("userInfo", s);
                            req.setAttribute("user", user);
                            req.setAttribute("dataOrder", dataOrder);
                            req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
                        }
                    }
                    for (Admin c : adminArr) {
                        if (c.getaUsername().equals(username)) {
                            req.setAttribute("userInfo", a);
                            session.setAttribute("userInfo", a);
                            req.setAttribute("user", user);
                            req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
                        }
                    }

                    return;
                } else {
                    message = "New password must not be the same as old password";
                    req.setAttribute("messagee", message);
                }
            } else {
                message = "Wrong old password !";
                req.setAttribute("messagee", message);
            }
        } else {
            req.setAttribute("messagee", message);
        }
        LoginDAO login = new LoginDAO();
        EmployeeDAO t = new EmployeeDAO();
        OrderDAO uOrder = new OrderDAO();
        
        String user = (String) session.getAttribute("username");
        List<User> userArr = login.getListUserProfile();
        ArrayList<Admin> adminArr = login.getListAdminProfile();
        System.out.println("ssss"+adminArr);

//        req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
        for (User s : userArr) {
            if (s.getuUsername().equals(username)) {
                ArrayList<Order> dataOrder = uOrder.getUserOrderList(Integer.parseInt(s.getUserID()));
                System.out.println(s.getGoogleID());
                if (s.getGoogleID() != null) {
                    req.setAttribute("tag", "1");
                } else {
                    req.setAttribute("tag", "0");
                }
                req.setAttribute("userInfo", s);
                session.setAttribute("userInfo", s);
                req.setAttribute("user", user);
                req.setAttribute("dataOrder", dataOrder);
                req.getRequestDispatcher("userProfile.jsp").forward(req, resp);
            }
        }
        for (Admin a : adminArr) {
            if (a.getaUsername().equals(username)) {
                req.setAttribute("userInfo", a);
                session.setAttribute("userInfo", a);
                req.setAttribute("user", user);
                req.getRequestDispatcher("adminProfile.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
