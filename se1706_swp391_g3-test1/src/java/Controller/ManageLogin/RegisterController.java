/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageLogin;

import Controller.Lib;
import DAO.RegisterDAO;
import Model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getParameter("name");
        String birthdate = (String) req.getParameter("birthday");
        String email = (String) req.getParameter("email");
        String username = (String) req.getParameter("username");
        String password = (String) req.getParameter("password");
        String confirm_password = (String) req.getParameter("confirm_password");
        String phone = (String) req.getParameter("phone");
        String address = (String) req.getParameter("address");
        String message=Lib.checkPass(password, confirm_password);
        try {
            password=Lib.toHexString(Lib.getSHA(password));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        String[] s = birthdate.split("/");
        birthdate="";
        for (int i = s.length-1 ;i>0;i--){
            birthdate+=s[i]+"-";
        }
        birthdate+=s[0];
        User u = new User(username, password, name, birthdate, phone, address,email);
        RegisterDAO a = new RegisterDAO();
         if (!username.matches("^[a-zA-Z0-9]+$")) {
            req.setAttribute("message", "Username must not contains spaces or special characters.");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        } else if (username.length() > 40 || username.length() < 6) {
            req.setAttribute("message", "Username must have 6 - 40 characters");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
        if (a.checkUser(username) != 0) {
            req.setAttribute("message", "Account already exists");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }else if (!message.equals("Success")) {
            req.setAttribute("message", message);
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }else if (a.checkEmail(email)!=0){
            req.setAttribute("message", "Email already used");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        } else if(a.checkPhone(phone) != 0){
            req.setAttribute("message", "Phone already used");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
        else {
            a.addUser(u);
            HttpSession session = req.getSession();
            ServletContext sc = req.getServletContext();
//                session.setAttribute("account", u);
            session.setAttribute("mode", "user");
//                session.setAttribute("uid", u.getUserID());
//                session.setAttribute("user",username);
            
            session.setAttribute("username", username);
            sc.setAttribute("user", username);
            req.setAttribute("user", username);
            req.getRequestDispatcher("homePage").forward(req, resp);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Register.jsp");
    }

}
