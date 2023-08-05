/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class editBlogDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public News getBlog(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsTitle,News,NewsImg from News where NewsID='" + id + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;

    }

    public void updateBlogs(String id, String format, String titleDetails, String textTitle, String imgNews, String AdminID) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update News set "
                    + "CreateNewDate=?,"
                    + "NewsTitle=?,"
                    + "News=? ,"
                    + "NewsImg=? ,"
                    + "AdminID=? "
                    + "where NewsID=?";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, format);
            pstm.setString(2, titleDetails);
            pstm.setString(3, textTitle);
            pstm.setString(4, imgNews);
            pstm.setString(5, AdminID);
            pstm.setString(6, id);
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

    public String getAdminsInfo(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT Fullname FROM News\n"
                    + "JOIN admins ON news.AdminID = admins.AdminID where NewsTypeID='3'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                return rs.getString(1);
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;

    }

    public News getClientFooter(String id) {
         try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsTitle,News,NewsImg from News where NewsTypeID = 3";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;
    
    }

    public void postClientsFooter(News news) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update News set "
                    
                    + "NewsTitle=?,"
                    + "News=? ,"
                    + "NewsImg=? "
                  
                    + "where newsTypeID=?";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, news.getNewsTitle());
            pstm.setString(2, news.getNews());
            pstm.setString(3,news.getNewsImg() );
            pstm.setString(4,"3" );
           
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }

//    public News getClientNabar(String id) {
//      
//    
//    }

    public News getNarbarClients(String id) {
       try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsID,NewsTitle,News,newsTypeID from News where NewsID='" + id + "' and NewsTypeID='4'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;
    
    }

    public void updateNarbarClients(String id, String NewsTitle, String News) {
       try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update News set "
                   
                    + "NewsTitle=?,"
                    + "News=? "
                   
                    + "where NewsID= ? and NewsTypeID=4";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, NewsTitle);
            pstm.setString(2, News);
            
            pstm.setString(3, id);
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    
    }

    public List<News> getListBlogNew() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT TOP 4 NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "WHERE News.NewsStatus != 0 ORDER BY News.CreateNewDate DESC";

            pstm = cnn.prepareStatement(strSelect);
//            pstm.setInt(1, (index - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);
                String createNewDate = rs.getString(2);

                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.S");
                LocalDateTime date_object = LocalDateTime.parse(createNewDate, inputFormat);
                String final_date = date_object.format(outputFormat);

                String newsTitle = rs.getString(3);
                String news = rs.getString(4);
                System.out.println(news);
                String pattern = "<img (.*?) />";
                String text = news.replaceAll(pattern, "");
                System.out.println(text);
                String newsImg = rs.getString(5);
                String Image = newsImg.replaceAll(" width=\"\\d+\" height=\"\\d+\"", "").replaceAll("<img", "<img  class=\"img-fluid\"");
                System.out.println(Image);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, text, Image, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    
    }

    public void updateQuickLink(String id, String NewsTitle, String News) {
        try {
            cnn = (new DBContext()).connection;
            String strUpdate = "update News set "
                   
                    + "NewsTitle=?,"
                    + "News=? "
                   
                    + "where NewsID= ? and NewsTypeID=5";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, NewsTitle);
            pstm.setString(2, News);
            
            pstm.setString(3, id);
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    
    }

    public News getQuickLink(String id) {
         try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsID,NewsTitle,News,newsTypeID from News where NewsID='" + id + "' and NewsTypeID='5'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;
    
    }

    public List<News> getListQuickLink() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,NewsTitle,News,newsTypeID FROM News\n"
                    + " WHERE News.NewsStatus != 0 and  News.newsTypeID= '5';";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);

                String newsTitle = rs.getString(2);
                String news = rs.getString(3);

//                System.out.println(text);
                String newsTypeID = rs.getString(4);

                data.add(new News(newsID, newsTitle, news, newsTypeID));
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    
    }

    public News getBlogInfor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
