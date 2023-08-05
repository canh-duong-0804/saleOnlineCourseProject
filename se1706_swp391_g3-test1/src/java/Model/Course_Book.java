/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Lib;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class Course_Book {
      private String Course_BookID,BookName,Price,Bookstatus,BookImg,Typeofbook,bDescription;
      private int stockQuantity,quantity;;
      
    public Course_Book(String Course_BookID, String BookName, String Price, String Bookstatus, String BookImg, String TypeOfBook, int StockQuantity) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
        this.Bookstatus = Bookstatus;
        this.BookImg = BookImg;
        this.Typeofbook = TypeOfBook;
        this.stockQuantity = StockQuantity;
    }

    public Course_Book(String Course_BookID, String BookName, String Price, String Bookstatus, String BookImg, String Typeofbook, String bDescription, int stockQuantity) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
        this.Bookstatus = Bookstatus;
        this.BookImg = BookImg;
        this.Typeofbook = Typeofbook;
        this.bDescription = bDescription;
        this.stockQuantity = stockQuantity;
    }

    public String getbDescription() {
        return bDescription;
    }

    public void setbDescription(String bDescription) {
        this.bDescription = bDescription;
    }

    public Course_Book(String Course_BookID, String BookName, String Price) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

    
    public String getTypeofbook() {
        return Typeofbook;
    }

    public void setTypeofbook(String Typeofbook) {
        this.Typeofbook = Typeofbook;
    }

    public Course_Book() {
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    

    public Course_Book(String Course_BookID, String BookName, String Price, String Bookstatus, String BookImg,String Typeofbook) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
        this.Bookstatus = Bookstatus;
        this.BookImg = BookImg;
        this.Typeofbook = Typeofbook;
    }
    public Course_Book( String BookName, String Price, String Bookstatus, String BookImg) {
   
        this.BookName = BookName;
        this.Price = Price;
        this.Bookstatus = Bookstatus;
     this.BookImg = BookImg;
    }

    public String getCourse_BookID() {
        return Course_BookID;
    }

    public void setCourse_BookID(String Course_BookID) {
        this.Course_BookID = Course_BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getBookstatus() {
        return Bookstatus;
    }

    public void setBookstatus(String Bookstatus) {
        this.Bookstatus = Bookstatus;
    }

    public String getBookImg() {
        return BookImg;
    }

    public void setBookImg(String BookImg) {
        this.BookImg = BookImg;
    }
      
    public Course_Book(String Course_BookID, String BookName, String Price, String BookImg, int quantity) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
        this.BookImg = BookImg;
        this.stockQuantity = quantity;
      
    }
    public Course_Book(String Course_BookID, String BookName, String Price, String BookImg, int quantity,String bDescription) {
        this.Course_BookID = Course_BookID;
        this.BookName = BookName;
        this.Price = Price;
        this.BookImg = BookImg;
        this.stockQuantity = quantity;
        this.bDescription=bDescription;
    }
    public String getTotalPrice() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat number = NumberFormat.getCurrencyInstance(locale);
        return number.format((Lib.convertVnPriceToInt(this.Price) * this.quantity));
    }
}
