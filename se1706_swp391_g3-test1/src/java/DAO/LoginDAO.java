/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.Lib;
import Model.Admin;
import Model.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoginDAO {

    Connection cnn;//ket noi
    Statement stm;//Thuc thi cau lenh sql
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect failed");
            }
        } catch (Exception ex) {

        }
    }

    public int checkUser(String username, String password){
        connect();
        try {
            String status = "";
            String strSelect = "select * from Users "
                    + "where Username=? "
                    + " and Password=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, Lib.toHexString(Lib.getSHA(password)));
            System.out.println(Lib.toHexString(Lib.getSHA(password)));
            rs = pstm.executeQuery();
            if (!rs.next()) {
                strSelect = "select * from Admins "
                        + "where Username=? "
                        + " and Password=? ";
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, username);
                pstm.setString(2, Lib.toHexString(Lib.getSHA(password)));
                rs = pstm.executeQuery();
                if (rs.next()) {
                    status = rs.getString("adminStatus");
                    if (status.equals("0")) {
                        return 3;
                    }
                    return 2;
                }
            } else {
                status = rs.getString("accStatus");
                if (status.equals("0")) {
                    return 3;
                }
                return 1;
            }
        } catch (Exception ex) {
            System.out.println("checkUser: " + ex.getMessage());
        }
        return 0;
    }

    public List<User> getListUserProfile() {
        connect();
        List<User> data = new ArrayList<>();
        try {
            String strSelect = "select UserID,Username,Fullname,"
                    + "Dob,Phonenumber,Address,Email,uImage,googleID from Users";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String id = rs.getString(1);
                String username = rs.getString(2);
                String name = rs.getString(3);
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

                String dob = "";
                if (rs.getDate(4) != null) {
                    dob = f.format(rs.getDate(4));
                }
                String phone = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                String image = rs.getString(8);
                String gID = rs.getString(9);

                data.add(new User(id, username, name, dob, phone, address, email, image, gID));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return data;
    }

    public void updateUserProfile(String username, String name, String email, String phone, String address, String dob) {
        connect();
        try {
            String strUpdate = "update Users\n"
                    + "set Fullname = ? ,\n"
                    + "email = ?,\n"
                    + "Phonenumber = ?,\n"
                    + "Address = ? ,\n"
                    + "Dob= ? \n"
                    + "where Users.Username = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, phone);
            pstm.setString(4, address);
            pstm.setString(5, dob);
            pstm.setString(6, username);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public void updateUserProfile(String username, String name, String email, String phone, String address, String dob, String fileName) {
        connect();
        try {
            String strUpdate = "update Users \n"
                    + "set Fullname = ? ,\n"
                    + "email = ?,\n"
                    + "Phonenumber = ?,\n"
                    + "Address = ? ,\n"
                    + "Dob= ? \n,"
                    + "uImage = ? \n"
                    + "where Users.Username = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, phone);
            pstm.setString(4, address);
            pstm.setString(5, dob);
            pstm.setString(6, fileName);
            pstm.setString(7, username);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
    
    public String getId(String username) {
        connect();
        String id="";
        try {
            String status = "";
            String strSelect = "select AdminID from Admins "
                    + "where Username=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                return id;
            }
        } catch (Exception ex) {
            System.out.println("getid: " + ex.getMessage());
        }
        return id;
    }
    public String getRole(String username) {
        connect();
        String id="";
        try {
            String status = "";
            String strSelect = "select RoleA from Admins "
                    + "where Username=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
                return id;
            }
        } catch (Exception ex) {
            System.out.println("getid: " + ex.getMessage());
        }
        return id;
    } 
    public void addToken(String username, String token,String mode) {
        connect();
        try {
            String strUpdate;
            if(mode.equals("admin")){
                 strUpdate = "update Admins\n"
                    + "set RememberMe = ? \n"
                    + "where Username = ?";
            }
            else{
                strUpdate = "update Users\n"
                    + "set RememberMe = ? \n"
                    + "where Users.Username = ?";
            }
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, token);
            pstm.setString(2, username);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add Token:" + e.getMessage());
        }
    }
    public String getUsernamebyToken(String token,String mode) {
        connect();
        try {
            String strSelect;
            if(mode.equals("admin")){
                 strSelect = "select Username from Admins\n"
                    +" where RememberMe= ?";
            }
            else{
                strSelect = "select Username from Users\n"
                    +" where RememberMe= ?";
            }
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, token);
            rs=pstm.executeQuery();
            while(rs.next()){
                return rs.getString("Username");
            }
        } catch (Exception e) {
            System.out.println("Add Token:" + e.getMessage());
        }
        return "";
    }
    public void updateAdminProfile(String username, String name, String email, String phone, String address, String dob, String des) {
         connect();
        try {
            String strUpdate = "update Admins\n"
                    + "set Fullname = ? ,\n"
                    + "Email = ? ,\n"
                    + "Phonenumber= ?,\n"
                    + "Address = ? ,\n"
                    + "Dob = ?,\n"
                    + "TeacherDescription = ?\n"
                    + "where Admins.Username = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, phone);
            pstm.setString(4, address);
            pstm.setString(5, dob);
            pstm.setString(6, des);
            pstm.setString(7, username);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
    public void updateAdminProfile(String username, String name, String email, String phone, String address, String dob, String des, String fileName) {
        connect();
        try {
            String strUpdate = "update Admins\n"
                    + "set Fullname =  ? ,\n"
                    + "Email = ? ,\n"
                    + "Phonenumber= ? ,\n"
                    + "Address = ? ,\n"
                    + "Dob = ? ,\n"
                    + "TeacherDescription = ? ,\n"
                    + "aImage = ? \n"
                    + "where Admins.Username = ? ";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, email);
            pstm.setString(3, phone);
            pstm.setString(4, address);
            pstm.setString(5, dob);
            pstm.setString(6, des);
            pstm.setString(7, fileName);
            pstm.setString(8, username);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
    public ArrayList<Admin> getListAdminProfile() {
        ArrayList<Admin> data = new ArrayList<>();
        try {
            String strSelect = "select * from Admins";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String name = rs.getString(4);
                String phone = rs.getString(6);
                String email = rs.getString(8);
                String role = rs.getString(10);
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                String dob = "";
                if (rs.getDate(5) != null) {
                    dob = f.format(rs.getDate(5));
                }
                String address = rs.getString(7);
                String description = rs.getString(9);
                String image = rs.getString(12);

                data.add(new Admin(id, name, account, dob, phone, address, email, description, image));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return data;
    }
}
