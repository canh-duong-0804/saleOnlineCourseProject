package Controller.UserSiteController;

import Controller.Lib;
import DAO.ForgotLogOutDAO;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fpt
 */
public class VerifyController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ForgotLogOutDAO dao = new ForgotLogOutDAO();
        String otp = req.getParameter("otp");
        String verifyOtp = (String) session.getAttribute("code");
        String phone = (String) session.getAttribute("phone");
        List<User> data = dao.checkPhone(phone);
        if (otp.equals(verifyOtp)) {
            req.setAttribute("data", data.get(0).getuUsername());
            session.setAttribute("data", data.get(0).getuUsername());
            req.getRequestDispatcher("RecoverPassword.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "OTP is not matched");
            req.getRequestDispatcher("verifyCode.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ForgotLogOutDAO dao = new ForgotLogOutDAO();
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter(("confirm_password"));
        String message = Lib.checkPass(password, confirm_password);
        String data = (String) session.getAttribute("data");

        req.setAttribute("message", message);
        if (!message.equals("Success")) {
            req.setAttribute("data", data);
            req.getRequestDispatcher("RecoverPassword.jsp").forward(req, resp);
        } else {
//            try {
//                password = Lib.toHexString(Lib.getSHA(password));
//            } catch (NoSuchAlgorithmException ex) {
//                Logger.getLogger(VerifyController.class.getName()).log(Level.SEVERE, null, ex);
//            }
            dao.updatePassword(username, password);
            session.setAttribute("username", username);
            resp.sendRedirect("homePage");
        }
    }

}

// Hàm tạo mã xác thực ngẫu nhiên

