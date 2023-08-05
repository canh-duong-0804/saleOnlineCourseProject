/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import Model.Order;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDAO extends User {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public int getTotalUsers() {
        cnn = (new DBContext()).connection;
        try {
            String strSelect = " select count (*) from  Users where accStatus !=0";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }
    public int getTotalUsersBan() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from  Users  where accStatus !=1";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }

    public List<User> Pagination(int page) {
        List<User> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT * FROM Users where accStatus !=0\n"
                    + "order by UserID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String username = rs.getString(2);
                String fullname = rs.getString(4);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

                String dob = "";
                if (rs.getDate(5) != null) {
                    dob = f.format(rs.getDate(5));
                }
                String phone = rs.getString(6);
                String address = rs.getString(7);
                String email = rs.getString(8);
                String img = rs.getString(10);
                boolean status = rs.getBoolean(9);
                data.add(new User(id, username, fullname, dob, phone, address, email, img, status));
                
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;
    }

    public void banUsers(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "UPDATE Users\n"
                    + "SET accStatus= 0   "
                    + "      WHERE UserID=?;";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Ban: " + e.getMessage());
        }
    }
    
    public List<User> banPagination(int page) {
        List<User> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT * FROM Users where accStatus !=1\n"
                    + "order by UserID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String username = rs.getString(2);
                String fullname = rs.getString(4);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

                String dob = "";
                if (rs.getDate(5) != null) {
                    dob = f.format(rs.getDate(5));
                }
                String phone = rs.getString(6);
                String address = rs.getString(7);
                String email = rs.getString(8);
                String img = rs.getString(10);
                boolean status = rs.getBoolean(9);
                data.add(new User(id, username, fullname, dob, phone, address, email, img, status));
                
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;
    }
    public void recoverUsers(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "UPDATE Users\n"
                    + "SET accStatus= 1   "
                    + "      WHERE UserID=?;";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Ban: " + e.getMessage());
        }
    }
    

    public User getUserInfo(String username) {
        User u = new User();
        cnn = (new DBContext()).connection;
        try{
            String strSelect = "SELECT UserID,Fullname,Dob,Phonenumber,Address,Email\n"
                + "FROM Users where Username=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs=pstm.executeQuery();
            while(rs.next()){
                String Id=rs.getString("UserID");
                String fullname = rs.getNString("Fullname");
                String dob=rs.getString("Dob");
                String Phonenumber = rs.getString("Phonenumber");
                String address = rs.getNString("Address");
                String Email = rs.getString("Email");
                u.setUserID(Id);
                u.setuUsername(username);
                u.setuName(fullname);
                u.setuEmail(Email);
                u.setuAddress(address);
                u.setuPhoneNumber(Phonenumber);
                u.setuDob(dob);
                
            }
            cnn.close();
        }
        catch(Exception ex){
            System.out.println("getUserInfo: " + ex.getMessage());
        }
        return u;
    }
    public String getUserID(String username){
        cnn = (new DBContext()).connection;
        String result="";
        try{
            String strSelect = "SELECT UserID \n"
                + "FROM Users where Username=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs=pstm.executeQuery();
            while(rs.next()){
                result=rs.getString("UserID");
                cnn.close();
            }
        }
        catch(Exception ex){
            System.out.println("getUserInfo: " + ex.getMessage());
        }
        return result;
    }
    public List<Order> purchasedCourse(String Username, int page) {
        List<Order> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT DISTINCT Orders.OrderID ,Course.CourseID,Orders.UserID,Course.CourseName,Admins.Fullname,Course.CourseImage,Orders.CheckPaymentStatus\n"
                    + "FROM (Course INNER JOIN OrderDetail ON  OrderDetail.CourseID = Course.CourseID) \n"
                    + "INNER JOIN  Orders ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Users on Users.UserID = Orders.UserID\n"
                    + "where Orders.CheckPaymentStatus !=0  and Users.Username = ? \n"
                    + "order by Orders.OrderID OFFSET ? ROWS\n"
                    + "FETCH NEXT 6 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Username);
            pstm.setInt(2, (page - 1) * 6);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString(1);
                String CourseID = rs.getString(2);
                String UserID = rs.getString(3);
                String CourseName = rs.getString(4);
                String creator = rs.getString(5);
                String imgCourse = rs.getString(6);
                boolean payStatus = rs.getBoolean(7);
                data.add(new Order(OrderID, CourseID, UserID, creator, CourseName, imgCourse, payStatus));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getRoom:" + e.getMessage());
        }
        return data;
    }

    public int getTotalpurchasedCourse(String Username) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " SELECT count (*)\n"
                    + "FROM   (Course INNER JOIN OrderDetail ON  OrderDetail.CourseID = Course.CourseID) \n"
                    + "INNER JOIN  Orders ON OrderDetail.OrderID = Orders.OrderID\n"
                    + "JOIN Admins ON Course.adminID = Admins.AdminID\n"
                    + "JOIN Users on Users.UserID = Orders.UserID\n"
                    + "where Orders.CheckPaymentStatus !=0  and Users.Username = ? ";
             pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Username);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }
}
