/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUF F15
 */
public class EmployeeDAO {

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

    public EmployeeDAO() {
        connect();
    }

    public List<Admin> getListAdmin() {
        ArrayList<Admin> data = new ArrayList<>();
        try {
            String strSelect = "select * from Admins";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String name = rs.getString(4);
                String password = rs.getString(3);
                String phone = rs.getString(6);
                String email = rs.getString(8);
                String role = rs.getString(10);
                String status = rs.getString(11);

                data.add(new Admin(id, name, account, password, phone, email, role, status));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return data;
    }

    public void deleteAdmin(String id) {
        try {
            String strDelete = "update Admins\n"
                    + "set adminStatus = 0 \n"
                    + "where AdminID = ? ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Delete:" + e.getMessage());
        }

    }

    public void setRoleAdmin(String id, String role) {
        try {
            String strUpdate = "update Admins\n"
                    + "set RoleA = ? \n"
                    + "where AdminID = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, role);
            pstm.setInt(2, Integer.parseInt(id));

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public void addAdmin(String username, String password, String email, String phone, String op, String name) {
        try {
            String strAdd = "insert into Admins(Username,Password,Email,Phonenumber,RoleA,Fullname,adminStatus)\n"
                    + "values (? ,? ,? ,? ,? ,? ,1)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.setString(3, email);
            pstm.setString(4, phone);
            pstm.setString(5, op);
            pstm.setString(6, name);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }
    }
    public int getTotalEmployee() {
        try {
            String strSelect = " select count (*) from Admins\n"
                    + "where Admins.RoleA != '4' and Admins.adminStatus != 0";
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

    public List<Admin> pagingAdmin(int index) {
        ArrayList<Admin> data = new ArrayList<>();
        try {
            String strUpdate = "select * from Admins where Admins.RoleA != '4'"
                    + "and Admins.adminStatus != 0 \n"
                    + "order by Admins.AdminID \n"
                    + "offset ? rows fetch next 3 rows only";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, (index - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String name = rs.getString(4);
                String password = rs.getString(3);
                String phone = rs.getString(6);
                String email = rs.getString(8);
                String role = "";
                String[] getRole = rs.getString(10).split(",");
                for (int i = 0; i < getRole.length - 1; i++) {
                    if (getRole[i].equals("1")) {
                        role += "Admin Product" + ",";
                    } else if (getRole[i].equals("2")) {
                        role += "Admin Marketing" + ",";
                    } else if (getRole[i].equals("3")) {
                        role += "Admin Sales" + ",";
                    }
                }
                if (getRole[getRole.length - 1].equals("1")) {
                    role += "Admin Course";
                } else if (getRole[getRole.length - 1].equals("2")) {
                    role += "Admin Marketing";
                } else if (getRole[getRole.length - 1].equals("3")) {
                    role += "Admin Order";
                }

                String status = rs.getString(11);

                data.add(new Admin(id, name, account, password, phone, email, role, status));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return data;
    }

}
