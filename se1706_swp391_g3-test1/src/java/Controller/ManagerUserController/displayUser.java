/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManagerUserController;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class displayUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        String[] ops = req.getParameterValues("ban");
        if (ops == null) {
            resp.sendRedirect("displayUser?message=false");
        } else {
            UserDAO user = new UserDAO();
            List<User> data = user.Pagination(index);
            for (String s : ops) {
                user.banUsers(s);
            }
            int count = user.getTotalUsers();
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }

            System.out.println(indexPage);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("data", data);
            req.getRequestDispatcher("ManagerUser.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        UserDAO user = new UserDAO();
        List<User> data = user.Pagination(index);
        int count = user.getTotalUsers();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        System.out.println(indexPage);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ManagerUser.jsp").forward(req, resp);
    }

}
