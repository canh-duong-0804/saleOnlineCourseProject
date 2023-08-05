/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseDAO;
import Model.Course;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import org.apache.tomcat.util.http.parser.HttpParser;

/**
 *
 * @author Admin
 */
public class comboCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        session = req.getSession();
        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }

        String id = req.getParameter("id");
        CourseDAO dao = new CourseDAO();
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }

        int index = Integer.parseInt(indexPage);

        int count = dao.getTotalCombo(index, username);
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        req.setAttribute("username", username);
        req.setAttribute("id", id);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        List<Course> c = dao.comboCourses(Integer.parseInt(id), username, index);
        System.out.println(index);
        System.out.println(c);
        req.setAttribute("combo", c);
        req.getRequestDispatcher("comboCourse.jsp").forward(req, resp);
    }

}
