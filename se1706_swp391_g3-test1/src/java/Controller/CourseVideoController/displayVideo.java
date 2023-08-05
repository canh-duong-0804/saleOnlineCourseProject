/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CourseVideoController;

import DAO.CourseDAO;
import DAO.CourseVideoDAO;
import DAO.OrderDAO;
import Model.Course;
import Model.CourseDocument;
import Model.CourseVideo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.github.slugify.Slugify;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author TUF F15
 */
public class displayVideo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = "";
//        Cookie[] cook = req.getCookies();
//        for (Cookie s : cook) {
//            if (s.getName().equals("username")) {
//                username = s.getValue();
//                break;
//            }
//        }

//        String cID = req.getParameter("cID");
        String cName = "";
        String videoOrder = "";
        if (!req.getPathInfo().contains("&")) {
            cName = req.getPathInfo().substring(1).replace("-", " ");
        } else {
            String[] listParam = req.getPathInfo().split("&");
            cName = listParam[1].replace("-", " ");
            videoOrder = listParam[0].substring(1);
        }

        System.out.println("url: " + req.getPathInfo());
//        List<Integer> dataCheck = vDao.checkBoughtCourse(username);
//        System.out.println(dataCheck);

        CourseVideoDAO dao = new CourseVideoDAO();

//        if (dataCheck.contains(Integer.parseInt(cID))) {
        if (videoOrder.isEmpty()) {
            videoOrder = "1";
        }
        int cID = dao.getIdOfCourse(cName);
        if (dao.getListVideo(cID).isEmpty()) {
            req.setAttribute("message", "Khoa hoc dang duoc cap nhat");
            req.setAttribute("dataVideo",dao.getListVideo(cID));
            req.getRequestDispatcher("../listVideo.jsp").forward(req, resp);
        } else {
            List<CourseVideo> data = dao.getListVideo(cID);
            List<CourseDocument> dataDoc = dao.getListDocument(data.get(Integer.parseInt(videoOrder) - 1).getCourseVideoID());
            req.setAttribute("video", data.get(Integer.parseInt(videoOrder) - 1).getVideoLink());
            req.setAttribute("order", videoOrder);
            req.setAttribute("dataVideo", data);
            req.setAttribute("dataDoc", dataDoc);
            req.setAttribute("Name", cName);

            req.getRequestDispatcher("../listVideo.jsp").forward(req, resp);
        }
    }

    private String generateSlug(String text) {
        Slugify slugify = new Slugify();
        return slugify.slugify(text);
    }
}
