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
public class deleteBookDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    private void connect() {
        try {
            //mo ket noi voi sql sểcr
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail");
            }
        } catch (Exception e) {

        }
    }

    public void deleteProduct(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strDelete = "update [dbo].[Course_Book] set\n"
                    
                    + "Bookstatus=? "
                    
                    + "where Course_BookID=?";


          pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, String.valueOf("0"));

            pstm.setInt(2, Integer.parseInt(id));

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }
}
