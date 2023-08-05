/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageLogin;

import Controller.Lib;
import DAO.LoginDAO;
import Model.Admin;
import Model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        LoginDAO a = new LoginDAO();
        ServletContext sc = req.getServletContext();
        if (a.checkUser(username, password) == 1) {
            System.out.println(password);
            HttpSession session = req.getSession();
//                session.setAttribute("account", u);
            session.setAttribute("mode", "user");
//                session.setAttribute("uid", u.getUserID());
//                session.setAttribute("uid", u.getUserID());
            session.setAttribute("user", username);
            session.setAttribute("username", username);
            sc.setAttribute("user", username);
            req.setAttribute("user", username);
            session.setAttribute("password", password);
            Cookie c = new Cookie("username", username);
            if (req.getParameterValues("remember") != null) {
                try {

                    String token;
                    do {
                        token = Lib.toHexString(Lib.getSHA(Lib.getAlphaNumericString((int) 20)));
                    } while ((!a.getUsernamebyToken(token, "admin").isEmpty()) && (!a.getUsernamebyToken(token, "user").isEmpty()));
                    a.addToken(username, token, "user");
                    c = new Cookie("remember", token);
                    c.setMaxAge(60 * 60 * 24);
                    resp.addCookie(c);
                } catch (NoSuchAlgorithmException ex) {

                }
            }
            resp.addCookie(c);
            session.setAttribute("username", username);
            req.getRequestDispatcher("homePage").forward(req, resp);
//                resp.sendRedirect("userpage.jsp");
        } else if (a.checkUser(username, password) == 2) {
            Admin admin = new Admin(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("account", admin);
            session.setAttribute("username", username);
            System.out.println("Adminsss:" + admin);
            session.setAttribute("mode1", "admin");
            session.setAttribute("password", password);
            req.setAttribute("user", username);
            Cookie c = new Cookie("username", username);
            if (req.getParameterValues("remember") != null) {
                try {

                    String token;
                    do {
                        token = Lib.toHexString(Lib.getSHA(Lib.getAlphaNumericString((int) 20)));
                    } while ((!a.getUsernamebyToken(token, "admin").isEmpty()) && (!a.getUsernamebyToken(token, "user").isEmpty()));
                    a.addToken(username, token, "admin");
                    c = new Cookie("remember", token);
                    c.setMaxAge(60 * 60 * 24);
                    resp.addCookie(c);
                } catch (NoSuchAlgorithmException ex) {

                }
            }
            resp.addCookie(c);
            sc.setAttribute("user", username);
            req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
//                resp.sendRedirect("adminhome.jsp");
        } else if (a.checkUser(username, password) == 3) {
            req.setAttribute("message", "Account not available !");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Wrong username or password");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String token = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("remember")) {
                    token = c.getValue();
                }
            }
            LoginDAO a = new LoginDAO();
            if (!token.isEmpty()) {
                String username = a.getUsernamebyToken(token, "user");
                HttpSession session = req.getSession();
                ServletContext sc = req.getServletContext();
                if (!username.isEmpty()) {
                    session.setAttribute("mode", "user");
                    sc.setAttribute("user", username);
                    session.setAttribute("username", username);
                    req.getRequestDispatcher("homePage").forward(req, resp);
                    return;
                } else {
                    username = a.getUsernamebyToken(token, "admin");
                    if (!username.isEmpty()) {
                        session.setAttribute("mode", "admin");
                        sc.setAttribute("user", username);
                        session.setAttribute("username", username);
                        
                        sc.setAttribute("user", username);
                        Admin admin = new Admin(username);
                        session.setAttribute("account", admin);
                        session.setAttribute("uid1", admin.getAdminID());
                        session.setAttribute("mode1", "admin");
                        req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
                        return;
                    }
                }
            }
        }
        resp.sendRedirect("Login.jsp");
    }

}
