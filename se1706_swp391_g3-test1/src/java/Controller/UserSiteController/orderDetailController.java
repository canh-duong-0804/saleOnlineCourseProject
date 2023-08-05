/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.OrderDAO;
import Model.Course_Book;
import Model.Course;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author TUF F15
 */
public class orderDetailController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderID = req.getParameter("id");
        String total = req.getParameter("total");
        int oID = Integer.parseInt(orderID);
        OrderDAO u = new OrderDAO();
        ArrayList<Course> listC = u.getCourseInOrder(orderID);
        ArrayList<Course_Book> listB = u.getBookInOrder(orderID);
        for(Course s : listC){
            System.out.println(s.getCourseName());
            System.out.println(s.getCoursePrice());
            
        }
        for(Course_Book s : listB){
            System.out.println(s.getBookName());
            System.out.println(s.getPrice());
            System.out.println(s.getQuantity());
            
        }
        req.setAttribute("listC", listC);
        req.setAttribute("listB", listB);
//        ArrayList<Order> data = u.getFullOrderDetail(oID);   
        req.setAttribute("total", total);
//        req.setAttribute("data", data);
        req.getRequestDispatcher("orderDetail.jsp").forward(req, resp);
    }
    
}
