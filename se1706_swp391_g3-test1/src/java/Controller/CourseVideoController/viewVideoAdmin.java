/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CourseVideoController;

import static Controller.CourseVideoController.addDeleteVideo.isYouTubeURL;
import DAO.CourseVideoDAO;
import Model.CourseVideo;
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
public class viewVideoAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indexPage = req.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        HttpSession session = req.getSession();
        int index = Integer.parseInt(indexPage);

        String id = req.getParameter("id");
        CourseVideoDAO dao = new CourseVideoDAO();
        int count = dao.getTotalVideo(Integer.parseInt(id));
        int endPage = count / 5;
        System.out.println(index);
        System.out.println(endPage);
        if (count % 5 != 0) {
            endPage++;
        }
        List<CourseVideo> data = dao.pagingVideo(Integer.parseInt(id), index);
        session.setAttribute("courseID", id);
        req.setAttribute("id", id);
        req.setAttribute("endPage", endPage);
        req.setAttribute("tag", index);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ManageVideoDetail.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("videoName");
        String link = req.getParameter("videoLink");
        CourseVideoDAO dao = new CourseVideoDAO();
        HttpSession session = req.getSession();
        String courseid = (String) session.getAttribute("courseID");

        System.out.println(link);

        if (isYouTubeURL(link)) {
            String embed = convertYoutubeToEmbed(link);

            req.setAttribute("message", "Update video sucessfully!");
            dao.updateVideo(name, embed);
            resp.sendRedirect("viewVideo?id=" + courseid + "&&modal=active");
        } else {
            req.setAttribute("message", "Update video failed!");
            resp.sendRedirect("viewVideo?id=" + courseid + "&&modal=fail");
        }

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
