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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class searchBookFromAdminDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public ArrayList<Course_Book> SearchForNameBook(String search) {
        ArrayList<Course_Book> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String sql = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName\n"
                    + "FROM Course\n"
                    + "JOIN BookOfCourse ON Course.CourseID = BookOfCourse.CourseID\n"
                    + "JOIN Course_Book ON BookOfCourse.Course_BookID = Course_Book.Course_BookID\n"
                    + "where [BookName] like ?";
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {
                String courseBookID = rs.getString(1);
                String BookName = rs.getString(2);

                double price = Double.parseDouble(rs.getString(3));
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String bookstatus = rs.getString(4);
                String bookImg = rs.getString(5);
                String typeofbook = rs.getString(6);
                NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
                if (bookstatus.equals("1")) {
                    list.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, typeofbook));
                }
            }
            cnn.close();
        } catch (Exception e) {

            System.out.println("Update:" + e.getMessage());
        }
        return list;
    }

    public void connect() {

        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception e) {
        }
    }

    public int getTotalSearchBook(String search) {
        try {
            connect();
//            String strSelect = "select count (*) FROM Course_Book JOIN BookOfCourse ON "
//                    + "Course_Book.Course_BookID = BookOfCourse.Course_BookID  JOIN  \n"
//                    + "Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 and Course.CourseName= '"+namebook+"'";
            String strSelect = " select count (*) FROM Course_Book \n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID \n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID where \n"
                    + "Course_Book.Bookstatus!=0 and BookName like '%" + search + "%'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;

    }

    public List<Course_Book> pagingAdminSearchCourseBook(int index, String search) {
        connect();
        List<Course_Book> data = new ArrayList<>();
        try {

            String strUpdate = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName\n"
                    + "FROM Course_Book\n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID\n"
                    + "WHERE Course_Book.Bookstatus != 0 and BookName like '%" + search + "%'\n"
                    + "ORDER BY Course_Book.Course_BookID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, (index - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseBookID = rs.getString(1);
                String BookName = rs.getString(2);

                double price = Double.parseDouble(rs.getString(3));
                String bookstatus = rs.getString(4);
                String bookImg = rs.getString(5);
                 Pattern pattern = Pattern.compile("src=\"([^\"]+)\"");
                Matcher matcher = pattern.matcher(bookImg);
                String extractedString = "";
                if (matcher.find()) {
                    extractedString = matcher.group(1);
                    System.out.println("Extracted string: " + extractedString);
                } else {
                    System.out.println("Không tìm thấy chuỗi cần trích xuất.");
                }
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);

                data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus,extractedString, Typeofbook));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    }

}
