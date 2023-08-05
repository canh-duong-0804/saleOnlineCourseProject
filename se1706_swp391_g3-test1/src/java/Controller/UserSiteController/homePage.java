/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.UserSiteController;

import DAO.CourseBookDAO;
import DAO.CourseDAO;
import DAO.NewsDAO;
import DAO.OrderDAO;
import DAO.editBlogDAO;
import DAO.showListBlogDAO;
import DAO.showListCourseBookDAO;
import Model.Course;
import Model.Course_Book;
import Model.News;
import jakarta.servlet.ServletContext;
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
public class homePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = "";
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") != null){
            username = (String)session.getAttribute("username");
        }
        
        CourseBookDAO show1 = new CourseBookDAO();
          List<Course_Book>  homePageCourseBook= show1.getCourseBookUserPage();
        CourseDAO dao = new CourseDAO();
        List<Course> c = dao.homapage(username);
        
        String id = "9";
       NewsDAO edit = new NewsDAO();
        String newsTypeID = "";
        News informationFooter = edit.getClientFooter(id);
        NewsDAO show = new NewsDAO();
        List<News> listNabar = show.getListNarbarClient(newsTypeID);
//        List<News> banner = edit.getBannerHomePage();
//
//        request.setAttribute("banner",banner);
        List<News> listQuickLink = edit.getListQuickLink();
        
        for (News news : listNabar) {
            System.out.println("check213: " + news);

        }
        
        String tranStatus = request.getParameter("vnp_TransactionStatus");
        ServletContext sc = request.getServletContext();
        if (tranStatus != null) {
            String option = sc.getAttribute("option").toString();
            String orderID = sc.getAttribute("orderID").toString();
            OrderDAO dao1 = new OrderDAO();
            if (tranStatus.equals("00")) {

                if (option.equals("1")) {
                    session.removeAttribute("orderCreated");
                    session.removeAttribute("orderID");
                    session.removeAttribute("ListBook");
                    session.removeAttribute("ListCourse");
                    dao1.updatePaymentStatus(orderID);
                    
                    

                } else if (option.equals("2")) {
                    session.removeAttribute("orderCreated");
                    session.removeAttribute("orderID");
                    session.removeAttribute("ListBook");
                    session.removeAttribute("ListCourse");
                    
                }
            }

        }
        List<News> data = edit.getBannerHomePage();
        request.setAttribute("data", data);
        session.setAttribute("listQuickLink", listQuickLink);
        request.setAttribute("homePageCourseBook", homePageCourseBook);
        request.setAttribute("message", request.getParameter("message"));
        session.setAttribute("informationFooter", informationFooter);
        session.setAttribute("NewsID", id);
        request.setAttribute("username", username);
        request.setAttribute("homepage", c);
        session.setAttribute("listNabar", listNabar);
        request.getRequestDispatcher("userpage.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("homePage");
    }

}
