/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import Model.GoogleUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class RegisterDAO {
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
    public int checkUser(String username) {
        connect();
        try {
            String strSelect = "select * from Users "
                    + "where Username=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                strSelect = "select * from Admins "
                        + "where Username=? ";
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, username);
                rs = pstm.executeQuery();
                if(rs.next()){
                    return 2;
                }
            }
            else {
                return 1;
            }
        } catch (Exception ex) {
            System.out.println("checkUser: " + ex.getMessage());
        }
        return 0;
    }
    public void addUser(User u){
        connect();
        try {
            String strAdd = "insert into Users(Username,Password,Fullname,Dob,Phonenumber,Address,Email,accStatus) "
                    + "values \n"
                    + "(?,?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, u.getuUsername());
            pstm.setString(2, u.getuPassword());
            pstm.setString(3, u.getuName());
            pstm.setDate(4, java.sql.Date.valueOf(u.getuDob()));
            pstm.setString(5,u.getuPhoneNumber());
            pstm.setString(6, u.getuAddress());
            pstm.setString(7, u.getuEmail());
            pstm.setBoolean(8, u.isStatus());
            pstm.execute();
            
        } catch (Exception ex) {
            System.out.println("Add : " + ex.getMessage());
        }
    }
    
    public void addGoogleUser(GoogleUser u){
        connect();
        try {
            String strAdd = "insert into Users(Username,Fullname,Email,googleID,accStatus,uImage) "
                    + "values \n"
                    + "(?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getName());
            pstm.setString(3, u.getEmail());
            pstm.setString(4, u.getId());
            pstm.setBoolean(5,true);
            pstm.setString(6, u.getPicture());
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("AddGoogleUser : " + ex.getMessage());
        }
    }
     public int checkEmail(String email) {
        connect();
        try {
            String strSelect = "select * from Users "
                    + "where Email=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                strSelect = "select * from Admins "
                        + "where Email=? ";
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, email);
                rs = pstm.executeQuery();
                if(rs.next()){
                    return 2;
                }
            }
            else {
                return 1;
            }
            cnn.close();
        } catch (Exception ex) {
            System.out.println("checkEmail: " + ex.getMessage());
        }
        return 0;
    }
     
     public int checkPhone(String phone) {
        connect();
        try {
            String strSelect = "select Username from Users "
                    + "where Phonenumber=? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, phone);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                strSelect = "select Username from Admins "
                        + "where Phonenumber=? ";
                pstm = cnn.prepareStatement(strSelect);
                pstm.setString(1, phone);
                rs = pstm.executeQuery();
                if(rs.next()){
                    return 2;
                }
            }
            else {
                return 1;
            }
            cnn.close();
        } catch (Exception ex) {
            System.out.println("checkEmail: " + ex.getMessage());
        }
        return 0;
    }
}
