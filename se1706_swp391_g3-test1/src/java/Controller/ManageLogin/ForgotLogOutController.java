/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageLogin;

import Controller.Lib;
import DAO.ForgotLogOutDAO;
import Model.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class ForgotLogOutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Thông tin tài khoản Twilio
    private static final String ACCOUNT_SID = "AC7c78656cb4d52f223a5d16b3b41a28da";
    private static final String AUTH_TOKEN = "346d37be7c73bb4ff4500045327cb5c1";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ForgotLogOutDAO dao = new ForgotLogOutDAO();
        HttpSession session = req.getSession();
        String phone = req.getParameter("phone");
        List<User> data = dao.checkPhone(phone);
        if (data.isEmpty()) {
            req.setAttribute("message", "Not found any user with that phone");
            req.getRequestDispatcher("ForgotPassword.jsp").forward(req, resp);
        } else {

            // Tạo mã xác thực ngẫu nhiên
            String verificationCode = generateVerificationCode();

            // Lưu mã xác thực vào session (hoặc cơ sở dữ liệu)
            req.getSession().setAttribute("verificationCode", verificationCode);

            // Gửi mã xác thực đến số điện thoại
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new PhoneNumber("+84" + phone.substring(1)), // Số điện thoại nhận tin nhắn
                    new PhoneNumber("+13156784365"), // Số điện thoại Twilio
                    "Nhap so dien thoai di onii-chan " + verificationCode) // Nội dung tin nhắn
                    .create();
            session.setAttribute("code", verificationCode);
            session.setAttribute("phone", phone);
            resp.sendRedirect("verifyCode.jsp"); // Chuyển hướng đến trang xác thực

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        ServletContext sc = getServletContext();
        Cookie[] cook = req.getCookies();
        boolean logged = false;
        if (sess.getAttribute("username") != null) {
            logged = true;
        }
        if (logged) {
            sess.invalidate();
            sc.removeAttribute("user");
            for (Cookie c : cook) {
                if (c.getName().equals("remember")) {
                    c.setMaxAge(0);
                    c.setValue("");
                    resp.addCookie(c);
                }
            }
        }
        req.getRequestDispatcher("homePage").forward(req, resp);
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(9000) + 1000; // Mã có 4 chữ số
        return String.valueOf(code);
    }

}
