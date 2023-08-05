/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course;
import Model.CourseDocument;
import Model.CourseVideo;
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
 * @author TUF F15
 */
public class CourseVideoDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

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

    public List<CourseVideo> getListVideo(int courseID) {
        connect();
        List<CourseVideo> data = new ArrayList<>();
        try {

            String strSelect = "select CourseVideoID,VideoOrder, VideoName,VideoLink,CourseID from CourseVideo where CourseID= ? and status != 0"
                    + " order by VideoOrder asc ";
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, courseID);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String order = rs.getString(2);
                String name = rs.getString(3);
                String link = rs.getString(4);
                String cID = rs.getString(5);

                data.add(new CourseVideo(Integer.parseInt(id), Integer.parseInt(order), link, name, Integer.parseInt(cID)));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getVideo:" + e.getMessage());
        }
        return data;
    }

    public List<String> getListVideoName(int courseID) {
        connect();
        List<String> data = new ArrayList<>();
        try {

            String strSelect = " select VideoName from CourseVideo where CourseID= ? \n"
                    + "  order by VideoOrder asc";
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, courseID);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                data.add(name);

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getVideoName:" + e.getMessage());
        }
        return data;
    }

    public List<CourseVideo> pagingVideo(int courseID, int index) {
        connect();
        List<CourseVideo> data = new ArrayList<>();
        try {

            String strSelect = "select CourseVideoID,VideoOrder, VideoName,VideoLink,CourseID from CourseVideo where CourseID= ? and CourseVideo.status != 0 \n"
                    + " order by VideoOrder asc \n"
                    + "offset ? rows fetch next 5 rows only";
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, courseID);
            pstm.setInt(2, (index - 1) * 5);

            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String order = rs.getString(2);
                String name = rs.getString(3);
                String link = rs.getString(4);
                String cID = rs.getString(5);

                data.add(new CourseVideo(Integer.parseInt(id), Integer.parseInt(order), link, name, Integer.parseInt(cID)));

            }
            cnn.close();
        } catch (SQLException e) {

            System.out.println("getVideo:" + e.getMessage());
        }
        return data;
    }

    public int getTotalVideo(int courseID) {
        connect();
        try {
            String strSelect = " select count(*) from CourseVideo\n"
                    + "                    where CourseVideo.CourseID = ? and CourseVideo.status != 0";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, courseID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }

    public List<CourseDocument> getListDocument(int videoID) {
        connect();
        List<CourseDocument> data = new ArrayList<>();
        try {
            String strSelect = "select * from Course_Document where CourseVideoID = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, Integer.toString(videoID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String docID = rs.getString(1);
                String name = rs.getString(2);
                String link = rs.getString(3);
                boolean Status = rs.getBoolean(4);

                data.add(new CourseDocument(docID, name, link, Status));
            }
        } catch (SQLException e) {
            System.out.println("getDocs:" + e.getMessage());
        }
        return data;
    }

    public int getMaxVideoOrder(int courseID) {
        connect();
        try {
            String strSelect = " select Max(VideoOrder) from CourseVideo\n"
                    + "where CourseID = ?  and CourseVideo.status != 0 ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, courseID);
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("getMaxOrder:" + e.getMessage());
        }
        return 0;
    }

    public void addNewVideo(String name, String embed, int maxVideoOrder, int courseid) {
        connect();
        try {
            String strAdd = "INSERT INTO [dbo].[CourseVideo]\n"
                    + "           ([VideoName]\n"
                    + "           ,[VideoOrder]\n"
                    + "           ,[VideoLink]\n"
                    + "           ,[CourseID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (? ,? ,? ,? ,1)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, name);
            pstm.setInt(2, (maxVideoOrder + 1));
            pstm.setString(3, embed);
            pstm.setInt(4, courseid);
            pstm.execute();
        } catch (SQLException e) {
            System.out.println("getMaxOrder:" + e.getMessage());
        }
    }

    public void deleteVideo(int videoID) {
        System.out.println(videoID);
        connect();
        try {
            String strDelete = "update CourseVideo \n"
                    + "                    set status = 0 \n"
                    + "                    where CourseVideoID = ? ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setInt(1, videoID);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Delete Video:" + e.getMessage());
        }
    }

//    public List<Integer> checkBoughtCourse(String username) {
//        connect();
//        List<Integer> data = new ArrayList<>();
//        try {
//
//            String strSelect = "select distinct OrderDetail.CourseID  from Users \n"
//                    + "join Orders on Users.UserID = Orders.UserID\n"
//                    + "join OrderDetail on OrderDetail.OrderID = Orders.OrderID\n"
//                    + "where Users.Username = ? and Orders.CheckPaymentStatus = 1";
////            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            pstm = cnn.prepareStatement(strSelect);
//            pstm.setString(1, username);
//
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                String courseID = rs.getString(1);
//                data.add(Integer.parseInt(courseID));
//
//            }
//            cnn.close();
//        } catch (SQLException e) {
//
//            System.out.println("getCourseID:" + e.getMessage());
//        }
//        return data;
//    }

    public void updateVideo(String videoName, String embed) {
        connect();
        try {
            String strUpdate = "update CourseVideo\n"
                    + "set VideoLink = ? \n"
                    + " where CourseVideo.VideoName = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1,embed );
            pstm.setString(2, videoName);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
    }
    public int getIdOfCourse(String cName) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "Select CourseID from Course where CourseName = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, cName);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return 0;
    }
}
