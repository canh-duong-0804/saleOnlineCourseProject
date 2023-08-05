/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageOrderController;

import Controller.Lib;
import DAO.CourseDAO;
import DAO.OrderDAO;
import DAO.UserDAO;
import Model.Course_Book;
import Model.Course;
import Model.Course_Book;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class RegisterOrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Course> listCourse = new ArrayList<>();
        ArrayList<Course_Book> listBook = new ArrayList<>();
        CourseDAO cDao = new CourseDAO();
        HttpSession sess = req.getSession();
        String username = "";
        username = (String) sess.getAttribute("username");
        if (sess.getAttribute("ListBook") != null) {
            listBook = (ArrayList) sess.getAttribute("ListBook");
        }
        if (sess.getAttribute("ListCourse") != null) {
            listCourse = (ArrayList) sess.getAttribute("ListCourse");
        }
        String price;
        if (!(listCourse.isEmpty() && listBook.isEmpty())) {
            Locale locale = new Locale("vi", "VN");
            NumberFormat number = NumberFormat.getCurrencyInstance(locale);
            price = number.format(Double.parseDouble(cDao.TotalPriceCart(listCourse, listBook)));
        } else {
            resp.sendRedirect("cart?showCart=true");
            return;
        }
        User u = new UserDAO().getUserInfo(username);
        OrderDAO order = new OrderDAO();
        String orderID;
        if (sess.getAttribute("orderCreated") == null) {
            orderID = order.generateNewOrder(u.getUserID(), "" + Lib.convertVnPriceToInt(price));
        } else {
            orderID = (String) sess.getAttribute("orderID");
            order.updateOrder2(orderID, "" + Lib.convertVnPriceToInt(price));
        }
        order.deleteOrderItems(orderID);
        order.deleteOrderBook(orderID);
        for (Course c : listCourse) {
            order.addOrderCourseItems(orderID, "" + Lib.convertVnPriceToInt(c.getCoursePrice()), c.getCourseID());
        }
        for (Course_Book b : listBook) {
            System.out.println(b.getQuantity());
            order.addOrderBookItems(orderID, "" + Lib.convertVnPriceToInt(b.getPrice()), b.getCourse_BookID(), "" + b.getQuantity());
        }
        sess.setAttribute("orderCreated", "true");
        sess.setAttribute("orderID", orderID);
        req.setAttribute("user", u);
        req.setAttribute("OrderID", orderID);
        req.setAttribute("Totalprice", price);
        req.setAttribute("dataCourse", listCourse);
        req.setAttribute("dataBook", listBook);
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }
}
