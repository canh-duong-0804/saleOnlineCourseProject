package Controller.UserSiteController;

import DAO.LoginDAO;
import DAO.RegisterDAO;
import Model.User;
import Model.GoogleUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fpt
 */
public class LoginGoogle extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        System.out.println(code);
        LoginDAO login = new LoginDAO();
        RegisterDAO resgister = new RegisterDAO();
        List<User> data = login.getListUserProfile();
        HttpSession session = req.getSession();
        ServletContext sc = req.getServletContext();
        boolean checkExist = true;
        String accessToken = getToken(code);
        GoogleUser user = getUserInfo(accessToken);

        for (User s : data) {
            if (user.getEmail().equals(s.getuUsername())) {
                checkExist = false;
                break;
            }

        }
        System.out.println(checkExist);
        if (checkExist == true) {
            resgister.addGoogleUser(user);
            session.setAttribute("username", user.getEmail());
//            Cookie c = new Cookie("username", user.getEmail());
//            resp.addCookie(c);
            session.setAttribute("mode", "user");
            sc.setAttribute("user", user.getEmail());
//            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
//            req.getRequestDispatcher("homePage").forward(req, resp);
            resp.sendRedirect("homePage");

        } else {
            session.setAttribute("username", user.getEmail());
//            Cookie c = new Cookie("username", user.getEmail());
//            resp.addCookie(c);
            session.setAttribute("mode", "user");
            sc.setAttribute("user", user.getEmail());
//            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
//            req.getRequestDispatcher("homePage").forward(req, resp);
            resp.sendRedirect("homePage");

        }

//        System.out.println(user);
    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GoogleUser getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        GoogleUser googlePojo = new Gson().fromJson(response, GoogleUser.class);

        return googlePojo;
    }

}
