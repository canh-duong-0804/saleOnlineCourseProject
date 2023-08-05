/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course_Book;
import Model.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class editCourseBookDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public Course_Book getCourseBool(String id) {
        try {
            cnn = (new DBContext()).connection;
//            String strSelect = "select * from Course_Book where Course_BookID='" + id + "'";
            String strSelect = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName\n"
                    + "FROM Course\n"
                    + "JOIN BookOfCourse ON Course.CourseID = BookOfCourse.CourseID\n"
                    + "JOIN Course_Book ON BookOfCourse.Course_BookID = Course_Book.Course_BookID\n"
                    + "where Course_Book.Course_BookID='" + id + "' and Course_Book.Bookstatus != 0" ;
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                 
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
               
                Course_Book book = new Course_Book(rs.getString(1), rs.getString(2),number.format(Double.parseDouble(rs.getString(3))), rs.getString(4),rs.getString(5), rs.getString(6));
                return book;
//                News blog = new News(rs.getString(3), rs.getString(4), rs.getString(5));
//                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }

        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;

    }

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
