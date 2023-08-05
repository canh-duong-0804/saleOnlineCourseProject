/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course_Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class postBook {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public void addPostNewBlogs(Course_Book n,String typeBook) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "DECLARE @ScopeIdentity int\n"
                    + "INSERT INTO Course_Book(BookName,Price,Bookstatus,BookImg,StockQuantity) values(?,?,?,?,?) \n"
                    + "SELECT @ScopeIdentity = SCOPE_IDENTITY()\n"
                    + "INSERT INTO BookOfCourse(Course_BookID,CourseID) values(@ScopeIdentity , ? )";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, n.getBookName());

            String cleanedStr = n.getPrice().replaceAll("[^0-9.]", ""); // Loại bỏ tất cả các ký tự không phải số và dấu "."
            double value = Double.parseDouble(cleanedStr);
            pstm.setDouble(2, value);
            pstm.setString(3, n.getBookstatus());
            pstm.setString(4, n.getBookImg());
            pstm.setString(6, typeBook);

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

    public void PostTypeBook(String typebook, int count) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[BookOfCourse]\n"
                    + "           ([Course_BookID]\n"
                    + "           ,[CourseID])\n"
                    + "     VALUES\n"
                    + "           (?,?)";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setInt(1, count);
            pstm.setString(2, typebook);

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

}
