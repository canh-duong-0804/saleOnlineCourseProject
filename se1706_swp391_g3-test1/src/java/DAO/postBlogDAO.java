/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class postBlogDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public void addPostNewBlogs(News n) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[News]\n"
                    + "           ([CreateNewDate]\n"
                    + "           ,[NewsTitle]\n"
                    + "           ,[News]\n"
                    + "           ,[NewsImg]\n"
                    + "           ,[AdminID]\n"
                    + "           ,[NewsStatus]\n"
                    + "           ,[newsTypeID])\n"
                    + "     VALUES(?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, n.getCreatNewsDate());
            pstm.setString(2, n.getNewsTitle());
            pstm.setString(3, n.getNews());
            pstm.setString(4, n.getNewsImg());
            pstm.setString(5, n.getAdminID());
            pstm.setString(6, n.getNewsStatus());
            pstm.setString(7, n.getNewsTypeID());

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

    public void addNewstype(String typename) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[newsType]\n"
                    + "           ([newTypeName])\n"
                    + "     VALUES(?)";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, typename);

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }
    }

    public String getFullnameAdmin(String username) {
        cnn = (new DBContext()).connection;
        try {
            String strSelect = "select AdminID from Admins where Admins.Username='" + username + "';";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString(1);
                return fullname;
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return null;

    }

    public void postNarbarClients(String id, String format,String NewsTitle, String News) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[News]\n"
                    + "           ([CreateNewDate],[NewsTitle]\n"
                    + "           ,[News],[NewsTypeID],[NewsStatus])\n"
                    + "     VALUES(?,?,?,4,?) ";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, format);
            pstm.setString(2, NewsTitle);
            pstm.setString(3, News);
            pstm.setString(4, "1");

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

}
