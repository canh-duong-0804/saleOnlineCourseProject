/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class updateCourseBookDAO {
Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;
    public void updateCourseBook(String id,String bookname, Double price, String bookStatus, String bookImg) {
       try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update Course_Book set "
                    + "BookName=?,"
                    + "Price=?,"
                    
                    
                    + "Bookstatus=? ,"
                    + "BookImg=? "
                    
                    + "where Course_BookID=?";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, bookname);
            pstm.setDouble(2, price);
            pstm.setString(3, String.valueOf("1"));
            pstm.setString(4, bookImg);
           
            pstm.setString(5, id);
            pstm.execute();
            System.out.println("ok");
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
}
