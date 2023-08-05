/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course_Book;
import Model.Course;
import Model.CourseCategory;
import Model.CourseProcess;
import Model.CourseProcess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADMIN
 */
public class CourseDAO extends Course {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

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

    public List<Course> GetCourseList1() {
        List<Course> data = new ArrayList<>();
        Locale lc = new Locale("vi", "VN");
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID;";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance(lc);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                String adminName = rs.getString(11);
                String discount = rs.getString(12);
                if (rs.getBoolean(10)) {
                    data.add(new Course(id, name, numberFormat.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), adminName, discount));
                }
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public Course GetCourse(String n) {
        Course cs = new Course();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID "
                    + " WHERE Course.CourseID = ?";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, n);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                cs = new Course(id, name, price, propose, description, courseCreationDate, image, student, video, Boolean.parseBoolean(status));

                return cs;
            }

        } catch (SQLException e) {

            System.out.println("updateCourse:" + e.getMessage());
        }
        return cs;
    }

    public void deleteCourse(String id) {
        try {
            cnn = (new DBContext()).connection;
            int ID = Integer.parseInt(id);

            String strUpdate = "UPDATE [dbo].[Course]\n"
                    + "    SET courseStatus= 0         "
                    + "      WHERE CourseID=?;";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, ID);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
    }

    public void addCourse(Course cs) {
        try {
            java.util.Date utilDate = new java.util.Date();
            Date date = new Date(utilDate.getTime());
            cnn = (new DBContext()).connection;
            String strAdd = "DECLARE @CourseID int;\n"
                    + "INSERT INTO Course (CourseName, CoursePrice, CoursePropose, CourseDescription, CourseCreateDate, CourseImage, NumberStudentEnrolled, LinkCourse, courseStatus, adminID)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1, ?);\n"
                    + "\n"
                    + "SET @CourseID = SCOPE_IDENTITY();\n"
                    + "\n"
                    + "INSERT INTO Discount (Discount, CreateDiscountDate, AdminID, CourseID, discountStatus)\n"
                    + "VALUES (0, GETDATE(), 1, @CourseID, 1);";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, cs.getCourseName());
            pstm.setFloat(2, Float.parseFloat(cs.getCoursePrice()));
            pstm.setBoolean(3, Boolean.parseBoolean(cs.getCoursePropose()));
            pstm.setString(4, cs.getCourseDescription());
            pstm.setDate(5, date);
            pstm.setString(6, cs.getCourseImg());
            pstm.setInt(7, 0);
            pstm.setString(8, "Empty");
            pstm.setInt(9, Integer.parseInt(cs.getAdminID()));

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add: " + e.getMessage());
        }
    }

    public void updateCourse(String id, String name, String price, String description, String image, String link) {
        try {
            cnn = (new DBContext()).connection;
            if (image.equals("nochange")) {
                String strUpdate = "UPDATE [dbo].[Course]\n"
                        + "   SET [CourseName] = ?\n"
                        + "      ,[CoursePrice] = ?\n"
                        + "      ,[CourseDescription] = ?\n"
                        + "      ,[LinkCourse] =? \n"
                        + " WHERE CourseID=?";
                pstm = cnn.prepareStatement(strUpdate);

                pstm.setString(1, name);
                pstm.setFloat(2, Float.parseFloat(price));
                pstm.setString(3, description);
                pstm.setString(4, link);
                pstm.setInt(5, Integer.parseInt(id));
            } else {
                String strUpdate = "UPDATE [dbo].[Course]\n"
                        + "   SET [CourseName] = ?\n"
                        + "      ,[CoursePrice] = ?\n"
                        + "      ,[CourseDescription] = ?\n"
                        + "      ,[CourseImage] = ?\n"
                        + "      ,[LinkCourse] =? \n"
                        + " WHERE CourseID=?";
                pstm = cnn.prepareStatement(strUpdate);

                pstm.setString(1, name);
                pstm.setFloat(2, Float.parseFloat(price));
                pstm.setString(3, description);
                pstm.setString(4, image);
                pstm.setString(5, link);

                pstm.setInt(6, Integer.parseInt(id));
            }

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public List<Course> GetCourseListBySearch(String search, String Username, int page) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Fullname\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "WHERE Admins.Fullname LIKE ? OR Course.CourseName LIKE ? AND  (Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1   ))\n"
                    + "order by Course.CourseID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setString(2, "%" + search + "%");
            pstm.setString(3, Username);
            pstm.setInt(4, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String creator = rs.getString(11);
                data.add(new Course(id, name, price, propose, description, courseCreationDate, image, student, video, status, creator));
            }
        } catch (SQLException e) {

            System.out.println("Search:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public List<CourseProcess> ProcessCourse(int page) {
        List<CourseProcess> data = new ArrayList<>();
        try {
            String strSelect = "select * from Course_Process\n"
                    + "where cpStatus != 0\n"
                    + "order by Course_ProcessID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String img = rs.getString(3);
                String status = rs.getString(4);

                data.add(new CourseProcess(id, name, img, status));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public List<Course> comboCourses(int ProcessID, String Username, int page) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Fullname\n"
                    + "FROM(Course INNER JOIN include i ON  i.CourseID = Course.CourseID) \n"
                    + "INNER JOIN  Course_Process p ON p.Course_ProcessID = i.Course_ProcessID\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "where p.Course_ProcessID = ? and  ( Course.courseStatus !=0 and Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1))\n"
                    + "order by Course.CourseID    \n"
                    + " OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, ProcessID);
            pstm.setString(2, Username);
            pstm.setInt(3, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String creator = rs.getString(11);
                data.add(new Course(id, name, price, propose, description, courseCreationDate, image, student, video, status, creator));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public List<Course> homapage(String Username) {
        List<Course> data = new ArrayList<>();
        Locale lc = new Locale("vi", "VN");
        try {
            String strSelect = "SELECT top 3 Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Fullname\n"
                    + "FROM Course JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "where Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1)\n"
                    + "order by Course.NumberStudentEnrolled desc";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String creator = rs.getString(11);
                data.add(new Course(id, name, price, propose, description, courseCreationDate, image, student, video, status, creator));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;
    }

    public CourseDAO() {
        connect();
    }

    public void CreateProcess(String name, String image) {
        try {
            cnn = (new DBContext()).connection;
            String insertSQL = "INSERT INTO [dbo].[Course_Process]\n"
                    + "           ([Course_ProcessName]\n"
                    + "           ,[Course_ProcessImage]\n"
                    + "           ,[cpStatus])\n"
                    + "           VALUES"
                    + "           (?,?,?)";
            pstm = cnn.prepareStatement(insertSQL);
            pstm.setString(1, name);
            pstm.setString(2, image);
            pstm.setBoolean(3, true);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Create:" + e.getMessage());
        }

    }

    public List<CourseProcess> GetProcessList() {
        List<CourseProcess> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from Course_Process";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                String status = rs.getString(4);

                if (rs.getBoolean(4)) {
                    data.add(new CourseProcess(id, name, image, status));
                }
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public List<CourseProcess> GetCourseProcessList() {
        List<CourseProcess> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT c.CourseName, cp.Course_ProcessName, cp.Course_ProcessImage\n"
                    + "FROM Course c\n"
                    + "JOIN include i\n"
                    + "ON c.CourseID = i.CourseID\n"
                    + "JOIN Course_Process cp\n"
                    + "ON i.Course_ProcessID = cp.Course_ProcessID";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                if (!data.equals(rs.getString(1))) {
                    String id = rs.getString(1);
                    String courseName = rs.getString(2);
                    String processName = rs.getString(3);
                    String image = rs.getString(4);

                    if (rs.getBoolean(5)) {
                        data.add(new CourseProcess(id, processName, image, courseName));
                    }
                }

            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public void addCourseToProcess(String courseID, String processID) {
        try {

            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[include]\n"
                    + "           ([CourseID]"
                    + "           ,[Course_ProcessID])\n"
                    + "             VALUES\n"
                    + "           (?,?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, courseID);
            pstm.setString(2, processID);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add: " + e.getMessage());
        }
    }

    public CourseProcess GetProcess(String n) {
        CourseProcess pc = new CourseProcess();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from Course_Process where Course_ProcessID=?";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, n);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String image = rs.getString(3);

                pc = new CourseProcess(id, name, image);
                return pc;
            }

        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return pc;
    }

    public void updateProcess(String id, String name, String image) {
        try {
            cnn = (new DBContext()).connection;
            if (!image.equals("nochange")) {
                String strUpdate = "UPDATE [dbo].[Course_Process]\n"
                        + "   SET [Course_ProcessName] = ?,\n"
                        + "      [Course_ProcessImage] = ? \n"
                        + " WHERE Course_ProcessID=?";
                pstm = cnn.prepareStatement(strUpdate);

                pstm.setString(1, name);
                pstm.setString(2, image);
                pstm.setString(3, id);
            } else {
                String strUpdate = "UPDATE [dbo].[Course_Process] \n"
                        + "   SET [Course_ProcessName] = ? \n"
                        + " WHERE Course_ProcessID=?";
                pstm = cnn.prepareStatement(strUpdate);

                pstm.setString(1, name);
                pstm.setString(2, id);
            }

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public void deleteProcess(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "UPDATE [dbo].[Course_Process]\n"
                    + "   SET [cpStatus] = ? \n"
                    + " WHERE Course_ProcessID=?";
            pstm = cnn.prepareStatement(strUpdate);

            pstm.setString(1, String.valueOf("0"));
            pstm.setInt(2, Integer.parseInt(id));

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Delete Course:" + e.getMessage());
        }
    }

    public List<Course> GetCourseListByName(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect
                    = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID\n"
                    + "where CourseName like ?\n"
                    + "order by CourseID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (index - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number1 = NumberFormat.getCurrencyInstance(locale);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                String admin = rs.getString(11);
                String discount = rs.getString(12);
                if (rs.getBoolean(10)) {
                    data.add(new Course(id, name, number1.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), admin, discount));
                }

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("SearchCreator:" + e.getMessage());
        }
        System.out.println(data);

        return data;
    }

    public List<Course> GetCourseListByName(String search) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from Course"
                    + " where CourseName like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number1 = NumberFormat.getCurrencyInstance(locale);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                if (rs.getBoolean(10)) {
                    data.add(new Course(id, name, number1.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status)));
                }
            }
        } catch (SQLException e) {

            System.out.println("Search:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public List<CourseProcess> GetProcessListBySearch(String search) {
        List<CourseProcess> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from Course_Process"
                    + " where Course_ProcessName like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                String status = rs.getString(4);

                if (rs.getBoolean(4)) {
                    data.add(new CourseProcess(id, name, image, status));
                }
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public Course GetCourseForCart(String n) {
        Course cs = new Course();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select CourseName,CoursePrice,CourseDescription from Course where CourseID=?";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, n);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String courseName = rs.getString("CourseName");
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String coursePrice = number.format(Double.parseDouble(rs.getString("CoursePrice")));
                String courseDescription = rs.getString("CourseDescription");
                cs = new Course(n, courseName, coursePrice, courseDescription);
                cnn.close();
                return cs;
            }

        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return cs;
    }

    public Course_Book GetBookForCart(String n) {
        Course_Book book = new Course_Book();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select BookName,Price from Course_Book where Course_BookID=?";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, n);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String BookName = rs.getString("BookName");
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String Price = number.format(Double.parseDouble(rs.getString("Price")));
                book = new Course_Book(n, BookName, Price);
                book.setQuantity(1);
                cnn.close();
                return book;
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }

        return book;
    }

    public String TotalPriceCart(ArrayList<Course> list, ArrayList<Course_Book> listb) {

        String strSelect = "with t as (select CourseID , CoursePrice from Course \n"
                + "where Course.CourseID= ?";
        for (int i = 1; i < list.size(); i++) {
            strSelect += " or Course.CourseID= " + list.get(i).getCourseID();
        }
        strSelect += " ) select sum(CoursePrice) as price from t";
        String price = "0";
        try {
            connect();
            if (!list.isEmpty()) {
                System.out.println(strSelect);
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, list.get(0).getCourseID());
                rs = pstm.executeQuery();
                while (rs.next()) {
                    // Locale locale = new Locale("vi", "VN");
                    // NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                    // return number.format(Double.parseDouble(rs.getString("price")));
                    price = rs.getString("price");
                }
            }
            if (!listb.isEmpty()) {
                System.out.println("listb : " + listb.size());
                strSelect = "select Course_BookID , Price from Course_Book \n"
                        + "where Course_Book.Course_BookID= ?";
                for (int i = 1; i < listb.size(); i++) {
                    strSelect += " or Course_Book.Course_BookID= " + listb.get(i).getCourse_BookID();
                }
                System.out.println(strSelect);
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, listb.get(0).getCourse_BookID());
                rs = pstm.executeQuery();
                while (rs.next()) {
                    for (Course_Book book : listb) {
                        if (book.getCourse_BookID().equals(rs.getString("Course_BookID"))) {
                            double priceint = rs.getDouble("Price") * book.getQuantity();
                            double total = Double.parseDouble(price) + priceint;
                            price = "" + total;
                        }
                    }
                }
            }
            return price;
        } catch (Exception ex) {
            System.out.println("GetPriceCart : " + ex.getMessage());
        }
        return "";
    }

    public List<Course> Category(int ID) {
        List<Course> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT c.*, p.Course_CategoryID\n"
                    + "                                FROM   (Course c INNER JOIN hasCategory i ON  i.CourseID = c.CourseID) \n"
                    + "                                INNER JOIN  Course_Category p ON  p.Course_CategoryID = i.Course_CategoryID\n"
                    + "where  p.Course_CategoryID = ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, ID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);

                data.add(new Course(id, name, price, propose, description, courseCreationDate, image, student, video, Boolean.parseBoolean(status)));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public List<Course> Pagination(String username, int start) {
        List<Course> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, \n"
                    + "Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Fullname\n"
                    + "FROM Course JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID \n"
                    + "where Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1)\n"
                    + "order by Course.CourseID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setInt(2, (start - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String creator = rs.getString(11);
                data.add(new Course(id, name, price, propose, description, courseCreationDate, image, student, video, status, creator));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public int getTotalCourse() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from Course where Course.courseStatus != 0";

            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getTotalSearch(String search) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from Course"
                    + " where CourseName like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getTotalCourseCategory(String CategoryName, String Username) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*)            \n"
                    + "FROM   (Course INNER JOIN hasCategory i ON  i.CourseID = Course.CourseID) \n"
                    + "INNER JOIN  Course_Category p ON  p.Course_CategoryID = i.Course_CategoryID\n"
                    + "where  p.Course_CategoryName = ? and (Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1  GROUP BY OrderDetail.CourseID )) ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, CategoryName);
            pstm.setString(2, Username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public List<CourseCategory> Category() {
        List<CourseCategory> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "select* from Course_Category ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);

                data.add(new CourseCategory(id, name, image));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public List<CourseCategory> CourseCategory(String CategoryName, String Username, int page) {
        List<CourseCategory> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Fullname\n"
                    + "FROM  (Course  INNER JOIN hasCategory i ON  i.CourseID = Course.CourseID)\n"
                    + "INNER JOIN  Course_Category p ON  p.Course_CategoryID = i.Course_CategoryID\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "where  p.Course_CategoryName = ?  and (Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1))\n"
                    + "order by p.Course_CategoryID  \n"
                    + " OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, CategoryName);
            pstm.setString(2, Username);
            pstm.setInt(3, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(3)));
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String creator = rs.getString(11);
                data.add(new CourseCategory(id, name, price, propose, description, courseCreationDate, image, student, video, status, creator));
            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;

    }

    public List<Course> GetCourseListByCreator(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect
                    = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID\n"
                    + "where Username like ?\n"
                    + "order by CourseID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (index - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number1 = NumberFormat.getCurrencyInstance(locale);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                String admin = rs.getString(11);
                String discount = rs.getString(12);
                if (rs.getBoolean(10)) {
                    data.add(new Course(id, name, number1.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), admin, discount));
                }

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("SearchCreator:" + e.getMessage());
        }
        System.out.println(data);

        return data;
    }

    public List<Course> pagingCourse(int index) {
        List<Course> data = new ArrayList<>();
        Locale lc = new Locale("vi", "VN");

        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID\n"
                    + "order by CourseID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance(lc);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                String adminName = rs.getString(11);
                String discount = rs.getString(12);
                if (rs.getBoolean(10)) {
                    data.add(new Course(id, name, numberFormat.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), adminName, discount));
                }
            }
        } catch (SQLException e) {

            System.out.println("getCourseList:" + e.getMessage());
        }
        System.out.println(data);
        return data;

    }

    public int getTotalProcess() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from Course_Process";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getCount: " + e.getMessage());

        }
        return 0;

    }

    public Course GetCourseListClient(String index) {
        Course data = new Course();
        try {
//SELECT CourseID,CourseName,CoursePrice,CoursePropose,CourseDescription,CourseCreateDate,CourseImage,NumberStudentEnrolled,LinkCourse,courseStatus,Admins.AdminID,Admins.Fullname
//
//from Course JOIN Admins ON Admins.AdminID = Course.adminID
// where Course.courseStatus!=0 and CourseID = 1
            cnn = (new DBContext()).connection;
            String strSelect = " SELECT CourseID,CourseName,CoursePrice,CoursePropose,CourseDescription,CourseCreateDate,CourseImage,"
                    + "NumberStudentEnrolled,LinkCourse,courseStatus,Admins.AdminID,Admins.Fullname\n"
                    + "from Course JOIN Admins ON Admins.AdminID = Course.adminID\n"
                    + "where Course.courseStatus!=0 and CourseID = '" + Integer.parseInt(index) + "'";
            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                Locale locale = new Locale("vi", "VN");
                NumberFormat number1 = NumberFormat.getCurrencyInstance(locale);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);

                if (rs.getBoolean(10)) {
                    data = new Course(id, name, number1.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), rs.getString(12));
                }
                cnn.close();
            }
        } catch (SQLException e) {

            System.out.println("Search:" + e.getMessage());
        }
        System.out.println(data);
        return data;

    }

    public List<CourseProcess> pagingProcess(int index) {
        List<CourseProcess> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from Course_Process\n"
                    + "order by Course_ProcessID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                String status = rs.getString(4);

                if (rs.getBoolean(4)) {
                    data.add(new CourseProcess(id, name, image, status));
                }
            }
        } catch (SQLException e) {

            System.out.println("getProcess:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public int CountCourseByName(String search) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select count (*) from Course"
                    + " where CourseName like ?;";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {

            System.out.println("Search:" + e.getMessage());
        }
        System.out.println(data);
        return 0;
    }

    public int CountCourseByCreator(String search) {
        List<Course> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT count (*) "
                    + "                    FROM Course \n"
                    + "                  INNER JOIN Admins \n"
                    + "                  ON Course.adminID = Admins.AdminID \n"
                    + "					 where Username like ?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {

            System.out.println("Search:" + e.getMessage());
        }
        System.out.println(data);
        return 0;
    }

    public Course GetCourseDetail(String id) {
        Locale lc = new Locale("vi", "VN");
        Course cs = new Course();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID "
                    + "WHERE Course.CourseID='" + id + "';";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                String Id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance(lc);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);

                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                String status = rs.getString(10);
                String adminName = rs.getString(11);
                String discount = rs.getString(12);
                cs = new Course(id, name, numberFormat.format(number), propose, description, date_object.format(outputFormat), image, student, video, Boolean.parseBoolean(status), adminName, discount);
                return cs;

            }
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        System.out.println(cs);
        return cs;

    }

    public List<String> getListVideo(String id) {
        List<String> list = new ArrayList();
        try {
            String sqlSelect = "Select VideoName From CourseVideo where CourseID=?";
            pstm = cnn.prepareStatement(sqlSelect);
            pstm.setInt(1, Integer.parseInt(id));
            rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception e) {
            System.out.println("getVideo:" + e.getMessage());
        }

        return list;
    }

    public void updateDiscount(String discount, String adminID, String id) {
        try {
            System.out.println("helo " + discount);

            System.out.println("dadadada: " + adminID);
            cnn = (new DBContext()).connection;
            String strUpdate = "UPDATE [dbo].[Discount]\n"
                    + "   SET [Discount] = ? \n"
                    + "      ,[CreateDiscountDate] = GETDATE() \n"
                    + "      ,[AdminID] = ? \n"
                    + " WHERE CourseID= ?";
            pstm = cnn.prepareStatement(strUpdate);

            pstm.setInt(1, Integer.parseInt(discount));
            pstm.setInt(2, Integer.parseInt(adminID));
            pstm.setInt(3, Integer.parseInt(id));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }

    }

    public String getAdminID(String name) {
        System.out.println("name: " + name);
        try {
            cnn = (new DBContext()).connection;
            String select = "SELECT AdminID FROM Admins WHERE Username = '" + name + "'";
            pstm = cnn.prepareStatement(select);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception ex) {

        }
        return "";
    }

    public int getTotalCourseProcess() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " SELECT COUNT(*)\n"
                    + "FROM Course\n"
                    + "LEFT JOIN include\n"
                    + "ON Course.CourseID = include.CourseID AND include.Course_ProcessID = ? \n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID \n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID  \n"
                    + "WHERE Course.courseStatus != 0 AND include.Course_ProcessID IS NULL";

            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public List<Course> pagingCourseProcess(int index, String id) {
        List<Course> data = new ArrayList<>();
        Locale lc = new Locale("vi", "VN");

        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Course.CourseID, Course.CourseName, Course.CoursePrice, Course.CoursePropose, Course.CourseDescription, Course.CourseCreateDate, Course.CourseImage, Course.NumberStudentEnrolled, Course.LinkCourse, Course.courseStatus, Admins.Username, Discount.Discount\n"
                    + "FROM Course\n"
                    + "LEFT JOIN include\n"
                    + "ON Course.CourseID = include.CourseID AND include.Course_ProcessID = ?\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID \n"
                    + "JOIN Discount ON Course.CourseID = Discount.CourseID  \n"
                    + "WHERE Course.courseStatus != 0 AND include.Course_ProcessID IS NULL\n"
                    + "ORDER BY Course.CourseID\n"
                    + "OFFSET ? ROWS \n"
                    + "FETCH NEXT 6 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.setInt(2, (index - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {

                String cid = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                double number = Double.parseDouble(price);
                NumberFormat numberFormat = NumberFormat.getCurrencyInstance(lc);
                String propose = rs.getString(4);
                String description = rs.getString(5);
                String courseCreationDate = rs.getString(6);
                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(courseCreationDate, inputFormat);
                String image = rs.getString(7);
                String student = rs.getString(8);
                String video = rs.getString(9);
                boolean status = rs.getBoolean(10);
                String adminName = rs.getString(11);
                String discount = rs.getString(12);
                if (rs.getBoolean(10)) {
                    data.add(new Course(cid, name, numberFormat.format(number), propose, description, date_object.format(outputFormat), image, student, video, status, adminName, discount));
                }
            }
        } catch (SQLException e) {

            System.out.println("getCourseList:" + e.getMessage());
        }
        System.out.println(data);
        return data;
    }

    public List<CourseProcess> SearchProcessCourse(String search, int page) {
        List<CourseProcess> data = new ArrayList<>();
        try {
            String strSelect = "select * from Course_Process\n"
                    + "where cpStatus != 0 and Course_ProcessName like ? \n"
                    + "order by Course_ProcessID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY\n";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String img = rs.getString(3);
                String status = rs.getString(4);

                data.add(new CourseProcess(id, name, img, status));
            }
        } catch (Exception e) {
        }
        return data;
    }

    public int getTotalSearchProcessCourse(String search) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from Course_Process where cpStatus != 0 and Course_ProcessName like ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getTotalCourseUser(String Username) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) FROM Course JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "where Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ?  AND Orders.CheckPaymentStatus = 1 GROUP BY OrderDetail.CourseID)";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getTotalProcessCourse() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from Course_Process where cpStatus != 0";

            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getTotalCombo(int ID, String username) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "  select count (*) FROM Course JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + " INNER JOIN include i ON  i.CourseID = Course.CourseID\n"
                    + "INNER JOIN  Course_Process p ON  p.Course_ProcessID = i.Course_ProcessID\n"
                    + "where p.Course_ProcessID = ? and (Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ?  AND Orders.CheckPaymentStatus = 1 GROUP BY OrderDetail.CourseID))";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, ID);
            pstm.setString(2, username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getTotalSearch(String search, String Username) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) \n"
                    + "FROM Course\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "WHERE Admins.Fullname LIKE ? OR Course.CourseName LIKE ? AND  (Course.courseStatus != 0 and  Course.CourseID NOT IN (\n"
                    + "SELECT DISTINCT OrderDetail.CourseID\n"
                    + "FROM Users\n"
                    + "JOIN Orders ON Users.UserID = Orders.UserID\n"
                    + "JOIN OrderDetail ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "RIGHT JOIN Course ON Course.CourseID = OrderDetail.CourseID\n"
                    + "WHERE Users.Username = ? AND Orders.CheckPaymentStatus = 1 GROUP BY OrderDetail.CourseID  ))";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setString(2, "%" + search + "%");
            pstm.setString(3, Username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public int getIdOfCourse(String cName) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "Select CourseID from Course where CourseName = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, cName);

            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

}
