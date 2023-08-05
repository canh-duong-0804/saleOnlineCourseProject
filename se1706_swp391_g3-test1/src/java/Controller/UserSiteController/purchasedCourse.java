/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseDAO;
import DAO.UserDAO;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class purchasedCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "";
       

        HttpSession session = req.getSession();
        if(session.getAttribute("username") != null){
            username = (String)session.getAttribute("username");
        }
        // phân trang

        String indexPage = req.getParameter("index");

        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        UserDAO dao = new UserDAO();
        List<Order> order = dao.purchasedCourse(username, index);
        int count = dao.getTotalpurchasedCourse(username);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        
        req.setAttribute("username", username);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("purchased", order);
        req.getRequestDispatcher("purchasedCourse.jsp").forward(req, resp);
    }

}
