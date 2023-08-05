/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Admin;
import Model.Course_Book;
import Model.News;
import Model.newsType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class showListBlogDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    private void connect() {
        try {
            //mo ket noi voi sql sểcr
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail");
            }
        } catch (Exception e) {

        }
    }

    public List<News> getListNews() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select * from News";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
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

                if (NewsStatus.equals("1")) {
//                    data.add(new News(newsID, final_date, newsTitle, news, newsImg, adminID, NewsStatus));
                }
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public int getTotalNews() {
        connect();
        try {
            String strSelect = " select count (*) from News JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "                    JOIN newsType ON News.AdminID = newsType.newsTypeID where News.NewsStatus != 0";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = stm.executeQuery(strSelect);

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

    public List<News> pagingnews(int index, int totalNews) {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "WHERE News.NewsStatus != 0\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT " + totalNews + " ROWS ONLY;";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 3);
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

//                System.out.println(text);
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, news, newsImg, adminID, NewsStatus, newsType));
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<newsType> getNewsType() {

        List<newsType> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select newsTypeID,newTypeName from newsType WHERE newsTypeID != 3 and newsTypeID != 4 and newsTypeID != 5 and newsTypeID != 6 and newsTypeID != 7 and newsTypeID != 8";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                data.add(new newsType(rs.getString(1), rs.getString(2)));

            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public int getTotalNews(String option) {
        connect();
        try {
            String strSelect = " select count (*) from News "
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "where News.NewsStatus != 0  and News.newsTypeID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(option));

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

    public List<News> pagingNewsFilter(int index, String option) {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID=?\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(option));
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
                System.out.println(news);
                String pattern = "<img (.*?) />";
                String text = news.replaceAll(pattern, "");
                System.out.println(text);
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, text, newsImg, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }
//SELECT TOP 3 *
//FROM Course
//ORDER BY CourseCreateDate DESC;

    public List<News> paging() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT TOP 3 *\n"
                    + "FROM News\n"
                    + "JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "JOIN Admins ON News.newsTypeID = Admins.AdminID\n"
                    + "WHERE News.NewsStatus != 0 ORDER BY News.CreateNewDate DESC";
            pstm = cnn.prepareStatement(strSelect);

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
                System.out.println(news);
                String pattern = "<img (.*?) />";
                String text = news.replaceAll(pattern, "");
                System.out.println(text);
                String newsImg = rs.getString(5);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, text, newsImg, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<News> pagingShowClientNews(int index) {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "WHERE News.NewsStatus != 0\n"
                    + "ORDER BY News.NewsID\n"
                    + "OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY;";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (index - 1) * 3);
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
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, text, newsImg, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<News> getListNarbarClient(String newsType) {

        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,NewsTitle,News,newsTypeID FROM News\n"
                    + " WHERE News.NewsStatus != 0 and  News.newsTypeID= '4';";

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

}
