/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import DAO.NewsDAO;
import DAO.editBlogDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class showBlogDetails extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("check12: " + req.getParameter("tin-tuc-11"));
        String cName = "";
        String BlogOrder = "";
        if (!req.getPathInfo().contains("&")) {
            cName = req.getPathInfo().substring(1).replace("-", " ");

        } else {
            String[] listParam = req.getPathInfo().split("&");
            cName = listParam[1].replace("-", " ");
            BlogOrder = listParam[0].substring(1);
        }
        String result = getFirstNumberAfterDash(req.getPathInfo());
        System.out.println("url: " + req.getPathInfo());
        String id = result;
        System.out.println("Check id: " + id);
        NewsDAO edit = new NewsDAO();
        News blog = edit.getBlogInfor(id);
        String fullname = edit.getAdminsInfo(id);

        System.out.println(fullname);
        List<News> data = edit.getListBlogNew();
        req.setAttribute("blog", blog);
        req.setAttribute("fullname", fullname);
        req.setAttribute("data", data);
//       req.setAttribute("NewsID", id);

        req.getRequestDispatcher("../viewblogdetails.jsp").forward(req, resp);
    }

    public static String getFirstNumberAfterDash(String input) {
        int lastDashIndex = input.lastIndexOf("-");
        if (lastDashIndex != -1 && lastDashIndex + 1 < input.length()) {
            return input.substring(lastDashIndex + 1);
        }
        return null; // No number found after the last dash
    }
    public static String convertToSlug(String input) {
        // Loại bỏ dấu thanh và dấu đặc biệt
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String withoutDiacritics = pattern.matcher(normalized).replaceAll("");

        // Thay thế các ký tự không phải chữ cái và số bằng dấu gạch ngang
        String slug = withoutDiacritics.replaceAll("[^a-zA-Z0-9]+", "-").toLowerCase();

        // Loại bỏ dấu gạch ngang ở đầu và cuối
        slug = slug.replaceAll("^-+|-+$", "");

        return slug;
    
}}
    
    

