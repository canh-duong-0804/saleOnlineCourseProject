/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageEmployeeController;

import Controller.Lib;
import DAO.EmployeeDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TUF F15
 */
public class addAdmin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password ="";
        try {
            password = Lib.toHexString(Lib.getSHA(req.getParameter("password")));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(addAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String phone = req.getParameter("phone");
        String[] listRole = req.getParameterValues("role");
         String alert = "";
        if(listRole == null){
            alert = "Please chooose role";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("addAdmin.jsp").forward(req, resp);
        }
        String role = new String();
        
        for(int i = 0; i < listRole.length - 1;i++){
            role += listRole[i] + ",";
        }
        role += listRole[listRole.length - 1];
        EmployeeDAO t = new EmployeeDAO();
        List<Admin> check = t.getListAdmin();
       
        
        for(Admin s : check){
            if(s.getaUsername().equals(username)){
                alert = "Username has existed";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("addAdmin.jsp").forward(req, resp);
            }
        }
        for(Admin s : check){
            if(s.getaEmail().equals(email)){
                alert = "Email already used";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("addAdmin.jsp").forward(req, resp);
            }
        }
        if(phone.length() != 10){
                alert = "Phone must has 10 number";
                req.setAttribute("alert", alert);
                req.getRequestDispatcher("addAdmin.jsp").forward(req, resp);
        }
        
        t.addAdmin(username, password, email, phone, role,name);
        req.getRequestDispatcher("adminhome.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
}
