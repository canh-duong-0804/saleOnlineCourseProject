/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.News;
import Model.newsType;
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
 * @author admin
 */
public class NewsDAO {

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

    public void deleteNews(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strDelete = "update [dbo].[News] set\n"
                    + "NewsStatus=? "
                    + "where NewsID=?";

            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, String.valueOf("0"));

            pstm.setString(2, id);

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
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

    public News getBlogInfor(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsTitle,News,NewsImg from News where NewsID='" + id + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2).substring(0, 2) + " style=\"font-size: 18px\"" + rs.getString(2).substring(2, rs.getString(2).length()), rs.getString(3));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;

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
                    + "JOIN Admins ON News.AdminID = Admins.AdminID\n"
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID=?\n"
                    + "ORDER BY News.CreateNewDate DESC\n"
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
                String news = rs.getString(4).substring(0, 2) + "style=\"font-size: 20px\"" + rs.getString(4).substring(2, rs.getString(4).length() - 100);
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
                data.add(new News(newsID, final_date, newsTitle, text, extractedString, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<News> pagingNews() {
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

    public String getFullnameAdmin(String username) {
        cnn = (new DBContext()).connection;
        try {
            String strSelect = "select AdminID from Admins where Admins.Username='" + username + "';";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString(1);
                return fullname;
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return null;

    }

    public void addPostNewBlogs(News n) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[News]\n"
                    + "           ([CreateNewDate]\n"
                    + "           ,[NewsTitle]\n"
                    + "           ,[News]\n"
                    + "           ,[NewsImg]\n"
                    + "           ,[AdminID]\n"
                    + "           ,[NewsStatus]\n"
                    + "           ,[newsTypeID])\n"
                    + "     VALUES(?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, n.getCreatNewsDate());
            pstm.setString(2, n.getNewsTitle());
            pstm.setString(3, n.getNews());
            pstm.setString(4, n.getNewsImg());
            pstm.setString(5, n.getAdminID());
            pstm.setString(6, n.getNewsStatus());
            pstm.setString(7, n.getNewsTypeID());

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

    public List<News> getListBlogNew() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT TOP 4 NewsID,CreateNewDate,NewsTitle,News,NewsImg,Fullname,NewsStatus,newTypeName\n"
                    + "FROM News\n"
                    + "JOIN Admins ON News.AdminID = Admins.AdminID JOIN newsType ON News.newsTypeID = newsType.newsTypeID\n"
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID !='4' and News.newsTypeID !='5' and News.newsTypeID !='6' ORDER BY News.CreateNewDate DESC";

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
                text=text.substring(0, 2) + "style=\"font-size: 15px\"" + text.substring(2, text.length() - 100);
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

    public int getTotalNews() {
        connect();
        try {
            String strSelect = " select count (*) from News JOIN Admins ON News.AdminID = Admins.AdminID\n"
                    + "                    JOIN newsType ON News.AdminID = newsType.newsTypeID where News.NewsStatus != 0 and News.newsTypeID !='4' and News.newsTypeID !='5' and News.newsTypeID !='6'";
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
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID != 3 and News.newsTypeID != 4 and News.newsTypeID != 5 and News.newsTypeID != 6\n"
                    + "ORDER BY News.CreateNewDate DESC\n"
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
                data.add(new News(newsID, final_date, newsTitle, news,extractedString, adminID, NewsStatus, newsType));
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

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

    public void addNewstype(String typename) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[newsType]\n"
                    + "           ([newTypeName])\n"
                    + "     VALUES(?)";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, typename);

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }
    }

    public List<newsType> getNewsType() {

        List<newsType> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "select newsTypeID,newTypeName from newsType";
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
///////////////////////

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

    public News getNarbarClients(String id) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "select NewsID,NewsTitle,News,newsTypeID from News where NewsID='" + id + "' and NewsTypeID='4'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return blog;
                //newUser = new User(account, password, name, dob, gender, address);
            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getListUser:" + e.getMessage());
        }
        return null;

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

                News blog = new News(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return blog;
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
            pstm.setString(3, news.getNewsImg());
            pstm.setString(4, "3");

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
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

    public void postNarbarClients(String id, String format, String NewsTitle, String News) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[News]\n"
                    + "           ([CreateNewDate],[NewsTitle]\n"
                    + "           ,[News],[NewsTypeID],[NewsStatus])\n"
                    + "     VALUES(?,?,?,4,?) ";

            pstm = cnn.prepareStatement(strAdd);

            pstm.setString(1, format);
            pstm.setString(2, NewsTitle);
            pstm.setString(3, News);
            pstm.setString(4, "1");

            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

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

    public List<News> getBannerHomePage() {
        List<News> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT NewsID,NewsTitle,News,NewsImg FROM News\n"
                    + " WHERE News.NewsStatus != 0 and  News.newsTypeID= '6';";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String newsID = rs.getString(1);

                String newsTitle = rs.getString(2);
                String news = rs.getString(3);

//                System.out.println(text);
                String newsImg = rs.getString(4);
                Pattern pattern = Pattern.compile("src=\"([^\"]+)\"");
                Matcher matcher = pattern.matcher(newsImg);
                String extractedString = "";
                if (matcher.find()) {
                    extractedString = matcher.group(1);
                    System.out.println("Extracted string: " + extractedString);
                } else {
                    System.out.println("Không tìm thấy chuỗi cần trích xuất.");
                }
                data.add(new News(newsID, newsTitle, news, extractedString, ""));

            }
            cnn.close();
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
                    + "WHERE News.NewsStatus != 0 and News.newsTypeID !='4' and News.newsTypeID !='5' and News.newsTypeID !='6'\n"
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
                System.out.println("check: " + newsImg);
                System.out.println("check1: " + extractedString);
                String adminID = rs.getString(6);
                String NewsStatus = rs.getString(7);
                String newsType = rs.getString(8);
                data.add(new News(newsID, final_date, newsTitle, text, extractedString, adminID, NewsStatus, newsType));
            }
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }
//////////////////////////////////////////////////////////////////////////

    public List<newsType> getListFromNewsType() {
        List<newsType> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "SELECT *\n"
                    + "FROM newsType\n"
                    + "ORDER BY \n"
                    + "  CASE WHEN newTypeName = 'Show all news' THEN 0 ELSE 1 END, \n"
                    + "  newsTypeID;";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String newstypeID = rs.getString(1);

                String newstypename = rs.getString(2);

                data.add(new newsType(newstypeID, newstypename));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;

    }

    public List<newsType> getListFromNewsTypeClients() {
        List<newsType> data = new ArrayList<>();
        try {

            cnn = (new DBContext()).connection;
            String strSelect = "Select * from newsType where newTypeName='sale' or newTypeName='CourseNews'";

            pstm = cnn.prepareStatement(strSelect);

            rs = pstm.executeQuery();
            while (rs.next()) {
                
                
                
                String newstypeID = rs.getString(1);

                String newstypename = rs.getString(2);

                data.add(new newsType(newstypeID, newstypename));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getProduct:" + e.getMessage());
        }
        return data;
    }

}
