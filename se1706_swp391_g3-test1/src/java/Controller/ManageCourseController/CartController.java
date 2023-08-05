/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageCourseController;

import DAO.CourseDAO;
import Model.Course_Book;
import Model.Course;
import Model.Course_Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Course_Book> listBook;
        if (session.getAttribute("ListBook") != null) {
            listBook = (ArrayList) session.getAttribute("ListBook");
        } else {
            listBook = new ArrayList<>();
        }
        for (Course_Book b : listBook) {
            String Parametername = b.getCourse_BookID() + "Quantity";
            if (req.getParameter(Parametername) != null) {
                b.setQuantity(Integer.parseInt((String) req.getParameter(Parametername)));
            }
        }
        session.setAttribute("ListBook", listBook);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cDao = new CourseDAO();
        boolean logged = false;
        String username = "";
        HttpSession session = req.getSession();
        ArrayList<Course> listCourse;
        if (session.getAttribute("ListCourse") != null) {
            listCourse = (ArrayList) session.getAttribute("ListCourse");
        } else {
            listCourse = new ArrayList<>();
        }
        ArrayList<Course_Book> listBook;
        if (session.getAttribute("ListBook") != null) {
            listBook = (ArrayList) session.getAttribute("ListBook");
        } else {
            listBook = new ArrayList<>();
        }
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
            logged = true;
        }
        if (!logged) {
            resp.sendRedirect("login");
            return;
        }
        for (Course_Book b : listBook) {
            String Parametername = b.getCourse_BookID() + "Quantity";
            System.out.println(req.getParameter(Parametername));
            if (req.getParameter(Parametername) != null) {
                b.setQuantity(Integer.parseInt((String) session.getAttribute(Parametername)));
            }
        }
        boolean added = false;
        if (req.getParameter("courseID") != null && req.getParameter("delete") == null) {
            String courseID = (String) req.getParameter("courseID");
            Course course = cDao.GetCourseForCart(courseID);
            for (Course c : listCourse) {
                if (c.getCourseID().equals(courseID)) {
                    added = true;
                }
            }
            if (!added) {
                listCourse.add(course);
                session.setAttribute("ListCourse", listCourse);
            }
            resp.sendRedirect("cart");
            return;
        }
        if (req.getParameter("bookID") != null && req.getParameter("delete") == null) {
            String BookID = (String) req.getParameter("bookID");
            Course_Book book = cDao.GetBookForCart(BookID);
            for (Course_Book b : listBook) {
                if (b.getCourse_BookID().equals(BookID)) {
                    added = true;
                }
            }
            if (!added) {
                listBook.add(book);
                session.setAttribute("ListBook", listBook);
            }
            resp.sendRedirect("cart");
            return;
        }
        if (req.getParameter("delete") != null) {
            String id;
            if (req.getParameter("courseID") != null) {
                id = (String) req.getParameter("courseID");
                for (Course c : listCourse) {
                    if (c.getCourseID().equals(id)) {
                        listCourse.remove(c);
                        break;
                    }
                }
            } else if (req.getParameter("bookID") != null) {
                id = (String) req.getParameter("bookID");
                for (Course_Book c : listBook) {
                    if (c.getCourse_BookID().equals(id)) {
                        listBook.remove(c);
                        break;
                    }
                }
            }
        }
        req.setAttribute("dataCourse", listCourse);
        req.setAttribute("dataBook", listBook);
        req.getRequestDispatcher("ShowCart.jsp").forward(req, resp);
    }
}

