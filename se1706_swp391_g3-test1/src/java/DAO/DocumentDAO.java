/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CourseDocument;
import Model.CourseVideo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DocumentDAO {

    Connection cnn;//kết nối
    Statement stm;// Thực thi các câu lệnh sql
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    PreparedStatement pstm;

    public int getTotalDocument() {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " select count (*) from  Course_Document where status !=0";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }

    public List<CourseDocument> searchname(int page, String search) {
        List<CourseDocument> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT d.Course_DocumentID,d.DocumentName,i.VideoName,d.DocumentLink, c.CourseName,d.status\n"
                    + "FROM   (Course c INNER JOIN CourseVideo i ON  i.CourseID = c.CourseID) \n"
                    + "INNER JOIN  Course_Document d ON  i.CourseVideoID = d.CourseVideoID \n"
                    + "WHERE d.status !=0 AND  d.DocumentName LIKE ? \n"
                    + "order by d.Course_DocumentID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 10 ROWS ONLY  \n";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (page - 1) * 10);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String videoID = rs.getString(3);
                String link = rs.getString(4);
                String type = rs.getString(5);
                boolean status = rs.getBoolean(6);
                data.add(new CourseDocument(id, name, videoID, link, type, status));
            }
            cnn.close();
        } catch (Exception e) {
        }
        return data;
    }
    public List<CourseDocument> searchCourse(int page, String search) {
        List<CourseDocument> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "SELECT d.Course_DocumentID,d.DocumentName,i.VideoName,d.DocumentLink, c.CourseName,d.status\n"
                    + "FROM   (Course c INNER JOIN CourseVideo i ON  i.CourseID = c.CourseID) \n"
                    + "INNER JOIN  Course_Document d ON  i.CourseVideoID = d.CourseVideoID \n"
                    + "WHERE d.status !=0 AND c.CourseName LIKE ? \n"
                    + "order by d.Course_DocumentID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 10 ROWS ONLY  \n";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            pstm.setInt(2, (page - 1) * 10);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String videoID = rs.getString(3);
                String link = rs.getString(4);
                String type = rs.getString(5);
                boolean status = rs.getBoolean(6);
                data.add(new CourseDocument(id, name, videoID, link, type, status));
            }
            cnn.close();
        } catch (Exception e) {
        }
        return data;
    }

    public List<CourseDocument> listDocument(int page) {

        List<CourseDocument> data = new ArrayList<>();
        try {
            cnn = (new DBContext()).connection;
            String strSelect = "select d.Course_DocumentID,d.DocumentName,i.VideoName,d.DocumentLink, c.CourseName,d.status\n"
                    + "                   FROM   (Course c INNER JOIN CourseVideo i ON  i.CourseID = c.CourseID) \n"
                    + "                 INNER JOIN  Course_Document d ON  i.CourseVideoID = d.CourseVideoID where d.status !=0\n"
                    + "                 order by d.Course_DocumentID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 10 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 10);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String videoID = rs.getString(3);
                String link = rs.getString(4);
                String type = rs.getString(5);
                boolean status = rs.getBoolean(6);
                data.add(new CourseDocument(id, name, videoID, link, type, status));
            }
            cnn.close();
        } catch (Exception e) {
        }
        return data;
    }

    public CourseDocument getCourseDocument(String ID) {
        try {
            cnn = (new DBContext()).connection;
            int id = Integer.parseInt(ID);
            String strSelect = "SELECT Course_Document.Course_DocumentID,Course_Document.DocumentName,CourseVideo.CourseVideoID,CourseVideo.VideoName,Course_Document.DocumentLink, Course_Document.status\n"
                    + "                 FROM  CourseVideo  INNER JOIN  Course_Document  ON  CourseVideo.CourseVideoID = Course_Document.CourseVideoID\n"
                    + "WHERE Course_Document.Course_DocumentID =? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ID = rs.getString(1);
                String name = rs.getString(2);
                String link = rs.getString(5);
                String video = rs.getString(4);
                boolean status = rs.getBoolean(6);
                String videoID = rs.getString(3);
                //DocumentID, String documentName, String videoID, String documentLink, String typeOfDocument, boolean status)
                CourseDocument docx = new CourseDocument(ID, name, videoID, link, video, status);
                return docx;
            }
            cnn.close();
        } catch (Exception e) {
        }
        return null;
    }

    public void deleteDocument(String id) {
        try {
            cnn = (new DBContext()).connection;
            int ID = Integer.parseInt(id);

            String strUpdate = "UPDATE [dbo].[Course_Document]\n"
                    + "    SET status= 0         "
                    + "      WHERE Course_DocumentID=?;";

            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, ID);

            pstm.execute();
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
    }

    public void addDocument(String Docname, String link, String Status, String VideoID) {
        try {
            cnn = (new DBContext()).connection;
            String strAdd = "INSERT INTO [dbo].[Course_Document]\n"
                    + "           ([DocumentName]\n"
                    + "           ,[DocumentLink]\n"
                    + "           ,[status]\n"
                    + "           ,[CourseVideoID])\n"
                    + "     VALUES(?,?,?,?)";

            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, Docname);
            pstm.setString(2, link);
            pstm.setString(3, Status);
            pstm.setString(4, VideoID);
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add:" + e.getMessage());
        }

    }

    public void editDocument(String id, String name, String link) {
        try {
            cnn = (new DBContext()).connection;
            int ID = Integer.parseInt(id);

            String strUpdate = "UPDATE [dbo].[Course_Document]\n"
                    + "  SET DocumentName= ?,"
                    + "      DocumentLink =?"
                    + "      WHERE Course_DocumentID=?;";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setString(2, link);
            pstm.setInt(3, ID);
            pstm.execute();
            cnn.close();
        } catch (Exception e) {
            System.out.println("Edit: " + e.getMessage());
        }
    }

    public CourseVideo getCourseVideo(String name) {
        try {
            cnn = (new DBContext()).connection;

            String strSelect = "SELECT CourseVideoID,VideoOrder,VideoLink,VideoName,CourseID\n"
                    + "FROM  CourseVideo WHERE VideoName = ? ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String order = rs.getString(2);
                name = rs.getString(4);
                String link = rs.getString(3);
                String cID = rs.getString(5);
                CourseVideo docx = new CourseVideo(Integer.parseInt(id), Integer.parseInt(order), link, name, Integer.parseInt(cID));
                return docx;
            }
            cnn.close();
        } catch (Exception e) {
            System.out.println("Add video: " + e.getMessage());
        }
        return null;
    }
    public int getTotalSearchName(String search) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " SELECT count (*)\n"
                    + "FROM   (Course c INNER JOIN CourseVideo i ON  i.CourseID = c.CourseID) \n"
                    + "INNER JOIN  Course_Document d ON  i.CourseVideoID = d.CourseVideoID \n"
                    + "WHERE d.status !=0 AND  d.DocumentName LIKE ?  ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }
    public int getTotalSearch(String search) {
        try {
            cnn = (new DBContext()).connection;
            String strSelect = " SELECT count (*)\n"
                    + "FROM   (Course c INNER JOIN CourseVideo i ON  i.CourseID = c.CourseID) \n"
                    + "INNER JOIN  Course_Document d ON  i.CourseVideoID = d.CourseVideoID \n"
                    + "WHERE d.status !=0 AND c.CourseName LIKE ?  ";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + search + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println("getList: " + e.getMessage());

        }
        return 0;
    }
}
