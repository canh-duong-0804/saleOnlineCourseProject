/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DBContext;
import DAO.EmployeeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author TUF F15
 */
public class Admin {

    private String adminID, aName, aUsername, aPassword, aDob, aPhone, aAddress, aEmail, aDescription, aRole,status,image;

    public Admin(String aUsername) {
        this.aUsername = aUsername;
    }
    
    public Admin(String adminID, String aName, String aUsername, String aDob, String aPhone, String aAddress, String aEmail, String aDescription, String image) {
        this.adminID = adminID;
        this.aName = aName;
        this.aUsername = aUsername;
        this.aDob = aDob;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.aEmail = aEmail;
        this.aDescription = aDescription;
        this.image = image;
    }

    public Admin(String adminID, String aName, String aUsername, String aDob, String aPhone, String aAddress, String aEmail, String aDescription, String aRole, String image) {
        this.adminID = adminID;
        this.aName = aName;
        this.aUsername = aUsername;
        this.aDob = aDob;
        this.aPhone = aPhone;
        this.aAddress = aAddress;
        this.aEmail = aEmail;
        this.aDescription = aDescription;
        this.aRole = aRole;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getaDob() {
        return aDob;
    }
    

    public void setaDob(String aDob) {
        this.aDob = aDob;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaEmail() {
        return aEmail;
    }


    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getaDescription() {
        return aDescription;
    }

    public void setaDescription(String aDescription) {
        this.aDescription = aDescription;
    }

    public String getaRole() {
        return aRole;
    }

    public void setaRole(String aRole) {
        this.aRole = aRole;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
    
    public Admin(String aUsername, String aPassword) {
        this.aUsername = aUsername;
        this.aPassword = aPassword;
        
    }

    public Admin() {
//        connect();
    }
    
    public Admin(String adminID,String aName, String aUsername, String aPassword, String aPhone, String aEmail,String aRole,String status) {
        this.adminID = adminID;
        this.aName = aName;
        this.aUsername = aUsername;
        this.aPassword = aPassword;
        this.aPhone = aPhone;
        this.aEmail = aEmail;
        this.aRole = aRole;
        this.status = status;
        
    }

    public Admin(String adminID, String aName, String aUsername, String aPassword) {
        this.adminID = adminID;
        this.aName = aName;
        this.aUsername = aUsername;
        this.aPassword = aPassword;
        
    }

    
    
       
}
