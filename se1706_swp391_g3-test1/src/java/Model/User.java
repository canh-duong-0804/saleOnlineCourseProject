    /*
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author TUF F15
 */
public class User {

    private String userID, uUsername, uPassword, uName, uDob, uPhoneNumber, uAddress, uEmail, uRole,image;
    private boolean status;
    private String googleID;
    public User() {


    }

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public User(String uUsername, String uName, String uEmail, String image, boolean status, String googleID) {
        this.uUsername = uUsername;
        this.uName = uName;
        this.uEmail = uEmail;
        this.image = image;
        this.status = status;
        this.googleID = googleID;
    }
    
    public User(String userID, String uUsername, String uName, String uDob, String uPhoneNumber, String uAddress, String uEmail, String image) {
        this.userID = userID;
        this.uUsername = uUsername;
        this.uName = uName;
        this.uDob = uDob;
        this.uPhoneNumber = uPhoneNumber;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.image = image;
    }
    
    public User(String uUsername, String uPassword, String uName, String uDob, String uPhoneNumber, String uAddress, String uEmail) {
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uName = uName;
        this.uDob = uDob;
        this.uPhoneNumber = uPhoneNumber;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.status=true;
    }

    public User(String userID, String uUsername, String uName, String uDob, String uPhoneNumber, String uAddress, String uEmail, String image, String googleID) {
        this.userID = userID;
        this.uUsername = uUsername;
        this.uName = uName;
        this.uDob = uDob;
        this.uPhoneNumber = uPhoneNumber;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.image = image;
        this.googleID = googleID;
    }
    public User(String userID, String uUsername, String uName, String uDob, String uPhoneNumber, String uAddress, String uEmail, String image, boolean status) {
        this.userID = userID;
        this.uUsername = uUsername;
        this.uName = uName;
        this.uDob = uDob;
        this.uPhoneNumber = uPhoneNumber;
        this.uAddress = uAddress;
        this.uEmail = uEmail;
        this.image = image;
        this.status = status;
    }
   

    public User(String uUsername, String uPassword) {
        this.uUsername = uUsername;
        this.uPassword = uPassword;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }


    public String getUserID() {
        return userID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuDob() {
        return uDob;
    }

    public void setuDob(String uDob) {
        this.uDob = uDob;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    public void setuPhoneNumber(String uPhoneNumber) {
        this.uPhoneNumber = uPhoneNumber;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", uUsername=" + uUsername + ", uPassword=" + uPassword + ", uName=" + uName + ", uDob=" + uDob + ", uPhoneNumber=" + uPhoneNumber + ", uAddress=" + uAddress + ", uEmail=" + uEmail + ", uRole=" + uRole + '}';
    }


    

}
