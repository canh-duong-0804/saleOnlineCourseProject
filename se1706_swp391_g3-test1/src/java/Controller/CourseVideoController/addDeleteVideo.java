/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CourseVideoController;

import DAO.CourseVideoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TUF F15
 */
public class addDeleteVideo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("videoName");
        String link = req.getParameter("videoLink");
        CourseVideoDAO dao = new CourseVideoDAO();
        HttpSession session = req.getSession();
        String courseid = (String) session.getAttribute("courseID");
        List<String> listVideoName = dao.getListVideoName(Integer.parseInt(courseid));
       
        if (listVideoName.contains(name)) {
            resp.sendRedirect("viewVideo?id=" + courseid + "&&modal=fail");
            
        } else {
            if (isYouTubeURL(link)) {
                String embed = convertYoutubeToEmbed(link);

                int maxVideoOrder = dao.getMaxVideoOrder(Integer.parseInt(courseid));

                req.setAttribute("message", "Add video sucessfully!");
                dao.addNewVideo(name, embed, maxVideoOrder, Integer.parseInt(courseid));
                resp.sendRedirect("viewVideo?id=" + courseid + "&&modal=active");
            } else {
                req.setAttribute("message", "Add video failed!");
                resp.sendRedirect("viewVideo?id=" + courseid + "&&modal=fail");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int videoID = Integer.parseInt(id);
        HttpSession session = req.getSession();
        String courseid = (String) session.getAttribute("courseID");
        CourseVideoDAO dao = new CourseVideoDAO();
        dao.deleteVideo(videoID);
        resp.sendRedirect("viewVideo?id=" + courseid);

    }

    public String convertYoutubeToEmbed(String youtubeURL) {
//        String youtubeURL = "https://www.youtube.com/watch?v=8hjX4BO2-ao&list=RD8hjX4BO2-ao&start_radio=1";
        String embedURL = youtubeURL.replace("www.youtube.com/watch?v=", "www.youtube.com/embed/");
        String[] parts = embedURL.split("&");
        System.out.println(parts.length);

        String finalEmbedUrl = parts[0];
        return finalEmbedUrl;
    }

    public static boolean isYouTubeURL(String url) {
        String pattern = "^(?:https?:\\/\\/)?(?:www\\.)?(?:youtube\\.com\\/+"
                + "(?:embed\\/|v\\/|watch\\?v=|watch\\?.+&v=|attribution_link\\?a=.+&u=|embed\\/watch\\"
                + "?feature=player_embedded&amp;v=|embed\\/watch\\?v=)|youtu\\.be\\/)([-_a-zA-Z0-9]+)(?:\\?t=(\\d+))?(?:&.+)?$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);
        return matcher.matches();
    }

}
