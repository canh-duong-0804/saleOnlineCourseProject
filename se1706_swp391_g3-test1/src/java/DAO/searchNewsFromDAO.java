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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class searchNewsFromDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public List<News> SearchForNameNewsAdmins(String search, int index) {
        List<News> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String sql = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName FROM News JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "JOIN newsType ON News.AdminID = newsType.newsTypeID\n"
                    + "where [NewsTitle] like ? and  News.NewsStatus != 0 and News.newsTypeID != 4 and News.newsTypeID != 5 and News.newsTypeID != 6 \n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (index - 1) * 3);

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
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                list.add(new News(newsID, final_date, newsTitle, news, newsImg, adminID, NewsStatus, newsType));
            }
        } catch (Exception e) {

            System.out.println("Update:" + e.getMessage());
        }
        return list;
    }

    public List<News> SearchForNameAuthor(String search) {
        List<News> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String sql = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName FROM News JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "JOIN newsType ON News.AdminID = newsType.newsTypeID\n"
                    + "where [NewsTitle] like ? and  News.NewsStatus != 0\n"
                    + "ORDER BY News.NewsID\n";
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");

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
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                list.add(new News(newsID, final_date, newsTitle, news, newsImg, adminID, NewsStatus, newsID));
            }
        } catch (Exception e) {

            System.out.println("Update:" + e.getMessage());
        }
        return list;

    }

    public int getTotalEmployee1(String search) {
        try {
            cnn = (new DBContext()).connection;

            String strSelect = " SELECT COUNT(*) AS Count\n"
                    + "FROM Admins\n"
                    + "JOIN News ON Admins.AdminID = News.AdminID\n"
                    + "WHERE News.NewsStatus = 1\n"
                    + " AND News.NewsTitle LIKE ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public List<News> pagingAdmin1(int index, String search) {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "WHERE News.NewsStatus != 0 and  News.NewsTitle LIKE ?\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (index - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);
                String createNewDate = rs.getString(2);

                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(createNewDate, inputFormat);
                String final_date = date_object.format(outputFormat);

                String newsTitle = rs.getString(3);
                String news = rs.getString(4);
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, createNewDate, newsTitle, news, newsImg, adminID, NewsStatus, newsType));
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public int getTotalAuthor(String search) {

        try {
            cnn = (new DBContext()).connection;

            String strSelect = " select count (*) FROM News JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID WHERE \n" +
"News.NewsStatus != 0 and News.newsTypeID != 4 and News.newsTypeID != 5 and News.newsTypeID != 6 and  Admins.Fullname LIKE N'%" + search + "%'";
            pstm = cnn.prepareStatement(strSelect);
            //pstm.setString(1, "N'%" + search + "%'");

            rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println("ok: " + rs.getInt(1));
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("total: " + e.getMessage());

        }
        System.out.println("fail");
        return 0;

    }

    public List<News> searchNewsFromNameAuthor(String search, int index) {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID\n"
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID != 4 and News.newsTypeID != 5 and News.newsTypeID != 6 and Admins.Fullname LIKE N'%"+search+"%'\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            //pstm.setString(1, "N'%" + search + "%'");
            pstm.setInt(1, (index - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);
                String createNewDate = rs.getString(2);

                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss.S dd-MM-yyyy");
                LocalDateTime date_object = LocalDateTime.parse(createNewDate, inputFormat);
                String final_date = date_object.format(outputFormat);

                String newsTitle = rs.getString(3);
                String news = rs.getString(4);
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, createNewDate, newsTitle, news, newsImg, adminID, NewsStatus, newsType));
                System.out.println("ok");
                System.out.println("check size: " + data.size());
            }
            cnn.close();
        } catch (SQLException e) {
            System.out.println("ok");
            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    }

    public int getTotalSearch(String search) {
        try {
            cnn = (new DBContext()).connection;

            String strSelect = " select count (*) FROM News JOIN Admins \n"
                    + "ON News.newsTypeID = Admins.AdminID JOIN newsType ON News.AdminID = newsType.newsTypeID \n"
                    + "where [NewsTitle] like ? and  News.NewsStatus != 0 and News.newsTypeID != 4 and News.newsTypeID != 5 and News.newsTypeID != 6 ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println("ok: " + rs.getInt(1));
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("total: " + e.getMessage());

        }
        System.out.println("fail");
        return 0;

    }

    public List<News> SearchForNameNewsClients(String search, int index) {
       List<News> list = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String sql = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName FROM News JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "where [NewsTitle] like ? and  News.NewsStatus != 0\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(sql);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (index - 1) * 3);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);
                String createNewDate = rs.getString(2);

                DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.S");
                LocalDateTime date_object = LocalDateTime.parse(createNewDate, inputFormat);
                String final_date = date_object.format(outputFormat);

                String newsTitle = rs.getString(3);
                 String news = rs.getString(4).substring(0, 2) + "style=\"font-size: 20px\"" + rs.getString(4).substring(2, rs.getString(4).length());
                System.out.println(news);
                String pattern = "<img (.*?) />";
                String text = news.replaceAll(pattern, "");
                System.out.println(text);
                String newsImg = rs.getString(5);
                Pattern pattern1 = Pattern.compile("src=\"([^\"]+)\"");
                Matcher matcher = pattern1.matcher(newsImg);
                String extractedString = "";
                if (matcher.find()) {
                    extractedString = matcher.group(1);
                    System.out.println("Extracted string: " + extractedString);
                } else {
                    System.out.println("Không tìm thấy chuỗi cần trích xuất.");
                }
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                list.add(new News(newsID, final_date, newsTitle, text.substring(0, 350), extractedString, adminID, NewsStatus, newsType));
            }
        } catch (Exception e) {

            System.out.println("Update:" + e.getMessage());
        }
        return list;
    }
}
