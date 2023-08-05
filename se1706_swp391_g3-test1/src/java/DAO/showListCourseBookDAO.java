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

/**
 *
 * @author Admin
 */
public class showListCourseBookDAO {

    Connection cnn; // Ket noi
    Statement stm; // thuc thi cac cau lenh sql
    ResultSet rs; // Luu tru va xu ly du lieu
    PreparedStatement pstm; // la nang cap cua stmde sua nhung loi gap phai

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

    public ArrayList<Course_Book> getListNews() {
        ArrayList<Course_Book> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName FROM Course\n"
                    + "JOIN BookOfCourse ON Course.CourseID = BookOfCourse.CourseID\n"
                    + "JOIN Course_Book ON BookOfCourse.Course_BookID = Course_Book.Course_BookID;";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String courseBookID = rs.getString(1);
                String BookName = rs.getString(2);

                double price = Double.parseDouble(rs.getString(3));
                String bookstatus = rs.getString(4);
                String bookImg = rs.getString(5);
//                NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMAN);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);

                if (bookstatus.equals("1")) {
                    data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook));
                }
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<Course_Book> pagingAdmin(int index) {
        connect();
        List<Course_Book> data = new ArrayList<>();
        try {

            String strUpdate = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName,StockQuantity\n"
                    + "FROM Course_Book\n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID\n"
                    + "WHERE Course_Book.Bookstatus != 0\n"
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
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);
                String StockQuantity = rs.getString(7);
                if (rs.getBoolean(4)) {
                    data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook, Integer.parseInt(StockQuantity)));
                }
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public int getTotalEmployee() {
        try {
            connect();
//            String strSelect = "select count (*) FROM Course_Book JOIN BookOfCourse ON "
//                    + "Course_Book.Course_BookID = BookOfCourse.Course_BookID  JOIN  \n"
//                    + "Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 and Course.CourseName= '"+namebook+"'";
            String strSelect = " select count (*) FROM Course_Book\n" +
"JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n" +
"JOIN Course ON BookOfCourse.CourseID = Course.CourseID\n" +
"WHERE Course_Book.Bookstatus != 0 ";
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

    public int getTotalEmployee1(String typebook) {

        connect();
        try {
//            String strSelect = " select count (*) from News\n"
//                    + "where News.NewsStatus != 0  and News.newsTypeID=?";
//            String strSelect = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName\n"
//                    + "FROM Course\n"
//                    + "JOIN BookOfCourse ON Course.CourseID = BookOfCourse.CourseID\n"
//                    + "JOIN Course_Book ON BookOfCourse.Course_BookID = Course_Book.Course_BookID\n"
//                    + "where Course.CourseName = ? and Course_Book.Bookstatus != 0";
//            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, typebook);

            rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public List<Course_Book> pagingAdmin1(int index, String typebook) {
        connect();
        List<Course_Book> data = new ArrayList<>();
        try {
//           
            String strUpdate = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName\n"
                    + "FROM Course_Book\n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID\n"
                    + "WHERE Course_Book.Bookstatus != 0 and Course.CourseName = ?\n"
                    + "ORDER BY Course_Book.Course_BookID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, typebook);
            pstm.setInt(2, (index - 1) * 3);


            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseBookID = rs.getString(1);
                String BookName = rs.getString(2);

                double price = Double.parseDouble(rs.getString(3));
                String bookstatus = rs.getString(4);
                String bookImg = rs.getString(5);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);

                data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public int getTotalEmployee3() {
        try {
            connect();
            String strSelect = " select count (*) from Course_Book";

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

    public int getTotalBook(String namebook) {
//        try {
//            connect();
//            String strSelect = "select count (*) FROM Course_Book JOIN BookOfCourse ON "
//                    + "Course_Book.Course_BookID = BookOfCourse.Course_BookID  JOIN  \n"
//                    + "Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 and Course.CourseName= ?";
//
//            pstm.setString(1, namebook);
//
//            rs = pstm.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(rs.getInt(1));
//                return rs.getInt(1);
//            }
//            cnn.close();
//        } catch (Exception e) {
//            System.out.println("getListProduct: " + e.getMessage());
//
//        }
//        return 0;

        try {
            connect();
            String strSelect = "select count (*) FROM Course_Book JOIN BookOfCourse ON "
                    + "Course_Book.Course_BookID = BookOfCourse.Course_BookID  JOIN  \n"
                    + "Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 and Course.CourseName= '" + namebook + "'";

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

    public int getTotalBookSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

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

    public List<Course_Book> pagingAdminSearch(int index, String search) {
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
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);

                data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    }
    public List<Course_Book> getCourseBookUserPage() {
        connect();
        List<Course_Book> data = new ArrayList<>();
        try {
//           SELECT *
//FROM articles
//ORDER BY publication_date DESC
//LIMIT 3;
            String strUpdate = "SELECT TOP 3 Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName,StockQuantity FROM Course_Book \n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 ORDER BY Course_Book.Course_BookID DESC";
            pstm = cnn.prepareStatement(strUpdate);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseBookID = rs.getString(1);
                String BookName = rs.getString(2);

                double price = Double.parseDouble(rs.getString(3));
                String bookstatus = rs.getString(4);
                String bookImg = rs.getString(5);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Typeofbook = rs.getString(6);
                String stockQuantity = rs.getString(7);

                data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook, Integer.parseInt(stockQuantity)));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

   public int getcountcoursebook() {
        try {
            connect();
            String strSelect = " select count (*) from Course_Book";

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

}
