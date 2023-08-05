/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageOrderController;

import DAO.OrderDAO;
import Model.Course_Book;
import Model.Course;
import Model.Course_Book;
import Model.Order;
import jakarta.servlet.ServletException;
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
public class OrderController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDAO a = new OrderDAO();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        String sort = "";
        String criteria = "";
        String keyword="";
        System.out.println(criteria);
        if (req.getParameter("criteria") != null) {
            criteria = req.getParameter("criteria");
        }
        int index = Integer.parseInt(indexPage);

        List<Order> data = a.Pagination(index);
        int count = a.getTotalOrder();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        if (req.getParameter("sort") != null && req.getParameter("criteria").isEmpty()) {
            sort = req.getParameter("sort");
            System.out.println(sort);
            if (sort.equals("OrderDate")) {
                data = a.PaginationOrderByDate(index);
                req.setAttribute("data", data);
                req.setAttribute("sort", sort);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
                return;
            }
            if (sort.equals("Totalprice")) {
                data = a.PaginationOrderByPrice(index);
                req.setAttribute("data", data);
                req.setAttribute("sort", sort);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
                return;
            }
        }
        if (!criteria.isEmpty()) {
            sort = "";
            String search = req.getParameter("searched");
            if (search == null) {
                index = 1;
            } else if (search.isEmpty()) {
                index = 1;
            }
            if (req.getParameter("sort") != null) {
                sort = req.getParameter("sort");
            }
            if (criteria.equals("all")) {

                keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByAll(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("OrderDate")) {
                keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByDate(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("UserName")) {
                keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByName(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("orderID")) {
                keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByID(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }              
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("payment")) {
                keyword = (String) req.getParameter("keywordpayment");
                data = a.PaginationSearchByPayment(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keywordpayment", keyword);
            } else if (criteria.equals("status")) {
                keyword = (String) req.getParameter("keywordstatus");
                data = a.PaginationSearchByStatus(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keywordstatus", keyword);
            }
            if (keyword.isEmpty()) {
                search = "";
            } else {
                search = "true";
            }
            req.setAttribute("sort", sort);
            req.setAttribute("data", data);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("searched", search);
            req.setAttribute("criteria", criteria);
            System.out.println("endpage:" + endPage);
            System.out.println("index:" + index);
            req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
            return;
        }
        if (req.getParameter("mode") == null) {
            sort = "";
            if (req.getParameter("sort") != null) {
                sort = req.getParameter("sort");
            }
            req.setAttribute("sort", sort);
            req.setAttribute("index", index);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            System.out.println("endpage:" + endPage);
            System.out.println("index:" + index);
            req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
        } else {
            String mode = (String) req.getParameter("mode");
            HttpSession sess = req.getSession();
            if (sess.getAttribute("account") == null) {
                resp.sendRedirect("Login.jsp");
                return;
            }
            if (mode.equals("update")) {
                String[] courses = req.getParameterValues("courseID");
                String orderID = (String) req.getParameter("orderID");
                a.updateOrder(orderID, courses);
                sort = "";
                if (req.getParameter("sort") != null) {
                    sort = req.getParameter("sort");
                }
                req.setAttribute("sort", sort);
                req.setAttribute("index", index);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                System.out.println("endpage:" + endPage);
                System.out.println("index:" + index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
            } else if (mode.equals("status")) {
                String orderID = (String) req.getParameter("orderID");
                String orderStatus = (String) req.getParameter("status");
                a.updateStatus(orderID, orderStatus);
                sort = "";
                if (req.getParameter("sort") != null) {
                    sort = req.getParameter("sort");
                }
                req.setAttribute("sort", sort);
                req.setAttribute("index", index);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                System.out.println("endpage:" + endPage);
                System.out.println("index:" + index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDAO a = new OrderDAO();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        System.out.println(index + "pre");
        String sort = "";
        String criteria = "";
        if (req.getParameter("criteria") != null) {
            criteria = req.getParameter("criteria");
        }
        List<Order> data = a.Pagination(index);
        int count = a.getTotalOrder();
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        if (req.getParameter("mode") != null) {
            String mode = (String) req.getParameter("mode");
            String orderID = (String) req.getParameter("orderID");
            if (mode.equals("approve")) {
                a.updateStatus(orderID, "approved");
            }
            if (mode.equals("cancel")) {
                a.updateStatus(orderID, "canceled");
            }
            if (mode.equals("viewdetails")) {
                ArrayList<Course> dataCourse = a.getCourseInOrder(orderID);
                ArrayList<Course_Book> dataBook = a.getBookInOrder(orderID);
                req.setAttribute("dataCourse", dataCourse);
                req.setAttribute("dataBook", dataBook);
                req.setAttribute("Totalprice", a.getTotalPrice(orderID));
                req.setAttribute("orderID", orderID);
                req.getRequestDispatcher("OrderDetails.jsp").forward(req, resp);
                return;
            }
        }
        if (req.getParameter("sort") != null && criteria.isEmpty()) {
            sort = req.getParameter("sort");
            System.out.println(sort);
            if (sort.equals("OrderDate")) {
                data = a.PaginationOrderByDate(index);
                req.setAttribute("data", data);
                req.setAttribute("sort", sort);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
                return;
            }
            if (sort.equals("Totalprice")) {
                data = a.PaginationOrderByPrice(index);
                req.setAttribute("data", data);
                req.setAttribute("sort", sort);
                req.setAttribute("endPage", endPage);
                req.setAttribute("tag", index);
                System.out.println("endpage:" + endPage);
                System.out.println("index:" + index);
                req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
                return;
            }
        }
        if (!criteria.isEmpty()) {
            criteria = (String) req.getParameter("criteria");
            sort = "";
            String search = req.getParameter("searched");
            if (search == null) {
                index = 1;
            } else if (search.isEmpty()) {
                index = 1;
            }
            if (req.getParameter("sort") != null) {
                sort = req.getParameter("sort");
            }
            if (criteria.equals("all")) {
                String keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                } else {
                    data = a.PaginationSearchByAll(index, keyword, sort);
                    endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                    req.setAttribute("keyword", keyword);
                    if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                        endPage++;
                    }
                }
            } else if (criteria.equals("OrderDate")) {
                String keyword = (String) req.getParameter("keyword");
                try{
                    keyword = java.sql.Date.valueOf(keyword).toString();
                }catch(Exception ex ){
                    System.out.println(ex.getMessage());
                }
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByDate(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("UserName")) {
                String keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByName(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("orderID")) {
                String keyword = (String) req.getParameter("keyword");
                if (keyword.isEmpty()) {
                    criteria = "";
                    search = "";
                }
                data = a.PaginationSearchByID(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keyword", keyword);
            } else if (criteria.equals("payment")) {
                String keyword = (String) req.getParameter("keywordpayment");
                data = a.PaginationSearchByPayment(index, keyword, sort);
                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keywordpayment", keyword);
            } else if (criteria.equals("status")) {
                String keyword = (String) req.getParameter("keywordstatus");
                data = a.PaginationSearchByStatus(index, keyword, sort);

                endPage = a.getNumOrderSearch(keyword, criteria) / 3;
                if (a.getNumOrderSearch(keyword, criteria) % 3 != 0) {
                    endPage++;
                }
                req.setAttribute("keywordstatus", keyword);
            }
            req.setAttribute("sort", sort);
            req.setAttribute("data", data);
            req.setAttribute("endPage", endPage);
            req.setAttribute("tag", index);
            req.setAttribute("searched", search);
            req.setAttribute("criteria", criteria);
            System.out.println(endPage);
            System.out.println(index + "after");
            req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("data", data);
        req.setAttribute("sort", sort);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        System.out.println("endpage:" + endPage);
        System.out.println("index:" + index);
        req.getRequestDispatcher("OrderManage.jsp").forward(req, resp);

    }
}
