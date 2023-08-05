/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ManageBlogController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
@MultipartConfig()
public class uploadImgThumbnail extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ok");

        Part imagePart = req.getPart("file");

        String fileName = imagePart.getSubmittedFileName();

         String realPath = req.getServletContext().getRealPath("/upload/images/");
        imagePart.write(realPath + "\\" + fileName);
        System.out.println(realPath + "\\" + fileName);

      
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("location", fileName);
        
        PrintWriter prout = resp.getWriter();
        prout.print(jsonObject.toString());

        prout.flush();
    }

}
