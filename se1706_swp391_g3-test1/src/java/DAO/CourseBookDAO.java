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
 * @author TUF F15
 */
public class CourseBookDAO {

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

    public ArrayList<Course_Book> getListNews() {
        ArrayList<Course_Book> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,CourseName,bDescription FROM Course\n"
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
                String description = rs.getString(7);

                if (bookstatus.equals("1")) {
                    //data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, bookImg, Typeofbook,b));
                    data.add(new Course_Book(courseBookID, BookName, bookImg, bookstatus, bookImg, Typeofbook, description, 0));
                }
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public Course_Book getCourseBook(String id) {
        try {
            cnn = (new DBContext()).connection;
//            String strSelect = "select * from Course_Book where Course_BookID='" + id + "'";
            String strSelect = "SELECT Course_Book.Course_BookID,BookName,Price,Bookstatus,BookImg,Course.CourseName,bDescription,Course_Book.StockQuantity\n"
                    + "FROM Course\n"
                    + "JOIN BookOfCourse ON Course.CourseID = BookOfCourse.CourseID\n"
                    + "JOIN Course_Book ON BookOfCourse.Course_BookID = Course_Book.Course_BookID\n"
                    + "where Course_Book.Course_BookID='" + id + "' and Course_Book.Bookstatus != 0";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);

                Course_Book book = new Course_Book(rs.getString(1), rs.getString(2), number.format(Double.parseDouble(rs.getString(3))), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), Integer.parseInt(rs.getString(8)));

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

    public void deleteCourseBook(String id) {
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

    public int getTotalBook(String namebook) {

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

    public List<Course_Book> pagingCourseBookAdmin(int index, String typebook) {
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

    public void postCourseBook(Course_Book n, String typeBook) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "DECLARE @ScopeIdentity int\n"
                    + "INSERT INTO Course_Book(BookName,Price,Bookstatus,BookImg,StockQuantity,bDescription) values(?,?,?,?,?,?) \n"
                    + "SELECT @ScopeIdentity = SCOPE_IDENTITY()\n"
                    + "INSERT INTO BookOfCourse(Course_BookID,CourseID) values(@ScopeIdentity , ? )";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, n.getBookName());

            String cleanedStr = n.getPrice().replaceAll("[^0-9.]", ""); // Loại bỏ tất cả các ký tự không phải số và dấu "."
            double value = Double.parseDouble(cleanedStr);
            pstm.setDouble(2, value);
            pstm.setBoolean(3, true);
            pstm.setString(4, n.getBookImg());
            pstm.setInt(5, n.getStockQuantity());
            pstm.setString(6, n.getbDescription());
            pstm.setString(7, typeBook);
            System.out.println("check: " + n.getStockQuantity());

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add fail:" + e.getMessage());
        }

    }

    public int getTotalCourseBook() {
        try {
            connect();
//            String strSelect = "select count (*) FROM Course_Book JOIN BookOfCourse ON "
//                    + "Course_Book.Course_BookID = BookOfCourse.Course_BookID  JOIN  \n"
//                    + "Course ON BookOfCourse.CourseID = Course.CourseID WHERE Course_Book.Bookstatus != 0 and Course.CourseName= '"+namebook+"'";
            String strSelect = " select count (*) FROM Course_Book\n"
                    + "JOIN BookOfCourse ON Course_Book.Course_BookID = BookOfCourse.Course_BookID\n"
                    + "JOIN Course ON BookOfCourse.CourseID = Course.CourseID\n"
                    + "WHERE Course_Book.Bookstatus != 0 ";
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

    public List<Course_Book> pagingAdminCourseBook(int index) {
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

    public void updateCourseBook(String id, String bookname, String price, String bookStatus, String bookImg, String bookDescription, String typebook) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update Course_Book set "
                    + "BookName=?,"
                    + "Price=?,"
                    + "Bookstatus=? ,"
                    + "BookImg=? ,"
                    + "bDescription=? "
                    + "where Course_BookID=?  "
                   
                    + " update BookOfCourse set CourseID= ? where Course_BookID=?";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, bookname);
            pstm.setString(2, price);
            pstm.setString(3, String.valueOf("1"));
            pstm.setString(4, bookImg);

            pstm.setString(5, bookDescription);
            pstm.setString(6, id);
            pstm.setString(7, typebook);
            pstm.setString(8, id);
            pstm.execute();
            System.out.println("ok");
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
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
                String stockQuantity = rs.getString(7);

                data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus, extractedString, Typeofbook, Integer.parseInt(stockQuantity)));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<Course_Book> pagingCourseBookFilter(int index, String typebook) {
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
//note check sds

    public List<Course_Book> pagingClientCourseBook(int index) {
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
                String StockQuantity = rs.getString(7);
                if (rs.getBoolean(4)) {
                    data.add(new Course_Book(courseBookID, BookName, number.format(price), bookstatus,extractedString, Typeofbook, Integer.parseInt(StockQuantity)));
                }
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
      
    }
}
