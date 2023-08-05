/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.Lib;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ForgotLogOutDAO {

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

    public List<User> checkPhone(String phone) {
        connect();
        List<User> data = new ArrayList<>();
        try {
            String strSelect = "select Username,Fullname from Users\n"
                    + "where Phonenumber= ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, phone);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String name = rs.getString(2);
                User u = new User();
                u.setuUsername(username);
                u.setuName(name);
                data.add(u);
            }
            cnn.close();
        } catch (Exception ex) {
            System.out.println("checkUser: " + ex.getMessage());
        }

        return data;
    }

    public void updatePassword(String username, String password) {
        connect();
        try {
            String strUpdate = "update Users "
                    + "set Password=?"
                    + " where Username=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, Lib.toHexString(Lib.getSHA(password)));
            pstm.setString(2, username);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("Update:" + ex.getMessage());
        }

    }
}
