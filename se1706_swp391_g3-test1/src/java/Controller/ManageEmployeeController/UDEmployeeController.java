/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageEmployeeController;

import DAO.EmployeeDAO;
import Model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUF F15
 */
public class UDEmployeeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        String id = req.getParameter("id");
        EmployeeDAO t = new EmployeeDAO();
        t.deleteAdmin(id);
        int count = t.getTotalEmployee();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }

//        ArrayList<Admin> data = new ArrayList<>();
        List<Admin> data = t.pagingAdmin(index);
//        for(Admin s : data1){
//            if(!s.getaRole().equals("manager") && !s.getStatus().equals("0")){
//                data.add(s);
//            }
//        }
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("verifyAccount.jsp").forward(req, resp);
    }

}
