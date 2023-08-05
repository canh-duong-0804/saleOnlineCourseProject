/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Course_Book;
import Model.Course;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TUF F15
 */
public class OrderDAO {

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

    public OrderDAO() {
        connect();
    }

    public ArrayList<Order> getUserOrderList(int id) {

        ArrayList<Order> data = new ArrayList<>();
        try {
            String strUpdate = "select * from Orders join Users \n"
                    + "on Orders.UserID = Users.UserID\n"
                    + "where Users.UserID = ? \n"
                    + "order by OrderID";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String oID = rs.getString(1);
                String uID = rs.getString(2);
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

                String date = "";
                if (rs.getDate(3) != null) {
                    date = f.format(rs.getDate(3));
                }
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String price = number.format(Double.parseDouble(rs.getString(5)));
                String status = rs.getString(6);
                boolean paymentStatus = rs.getBoolean(4);

                data.add(new Order(oID, uID, date, price, status, paymentStatus));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());

        }
        return data;

    }

    public ArrayList<Order> getOrderList() {
        connect();
        ArrayList<Order> data = new ArrayList<Order>();
        try {
            /*String strSelect = "with t as (\n"
                    + "     select Course.CourseID as CourseID,Course.CoursePrice as price,OrderDetail.OrderID as OrderID from OrderDetail \n"
                    + "     join Course on Course.CourseID=OrderDetail.CourseID \n"
                    + "        )\n"
                    + ", s as (\n"
                    + "	select Orders.OrderID as OrderID, (OrderBook.price*OrderBook.quantity) as price from Orders \n"
                    + "	join OrderBook on OrderBook.OrderID =Orders.OrderID\n"
                    + ")\n"
                    + "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,sum(t.price+IsNULL(s.price,0)) as FullPrice from Orders\n"
                    + "join t on Orders.OrderID=t.OrderID \n"
                    + "left join s on Orders.OrderID=s.OrderID\n"
                    + "group by Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus";*/
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (Exception ex) {
            System.out.println("OrderList: " + ex.getMessage());
        }
        return data;
    }

    public int getTotalOrder() {
        cnn = (new DBContext()).connection;
        try {
            String strSelect = " select count (*) from  Orders";
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

    public List<Order> Pagination(int page) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "order by OrderID\n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getPage:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationOrderByDate(int page) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "order by OrderDate desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getDate:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationOrderByPrice(int page) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "order by TotalPrice desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getbyPrice:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByAll(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where OrderID LIKE '%" + keyword + "%' "
                    + "OR OrderDate LIKE '%" + keyword + "%' "
                    + "OR orderStatus LIKE '%" + keyword + "%' "
                    + "OR TotalPrice LIKE '%" + keyword + "%' "
                    + "OR Fullname LIKE '%" + keyword + "%' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("GetbyAll:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByDate(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where OrderDate = '" + keyword + "' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            System.out.println(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getbyDate:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByName(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where Fullname LIKE '%" + keyword + "%' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getbyName:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByID(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where OrderID LIKE '%" + keyword + "%' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getbyID:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByPayment(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where CheckPaymentStatus = '" + keyword + "' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getbyPayment:" + e.getMessage());
        }
        return data;
    }

    public List<Order> PaginationSearchByStatus(int page, String keyword, String sort) {
        cnn = (new DBContext()).connection;
        List<Order> data = new ArrayList<>();
        if (sort.isEmpty()) {
            sort = "OrderID";
        }
        try {
            String strSelect = "select Orders.OrderID,Orders.UserID,Orders.OrderDate,CheckPaymentStatus,orderStatus ,TotalPrice,Fullname from Orders join Users on Orders.UserID=Users.UserID\n"
                    + "where orderStatus = '" + keyword + "' "
                    + "order by " + sort + " desc \n"
                    + "OFFSET ? ROWS\n"
                    + "FETCH NEXT 3 ROWS ONLY";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, (page - 1) * 3);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String UserID = rs.getString("UserID");
                String OrderDate = rs.getString("OrderDate");
                boolean checkpaymentstatus = rs.getBoolean("CheckPaymentStatus");
                String OrderStatus = rs.getString("orderStatus");
                Locale locale = new Locale("vi", "VN");
                String fullname = rs.getString("Fullname");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String fullPrice = number.format(Double.parseDouble(rs.getString("TotalPrice")));
                Order a = new Order(OrderID, UserID, OrderDate, fullPrice, OrderStatus, checkpaymentstatus);
                a.setUserName(fullname);
                data.add(a);
            }
        } catch (SQLException e) {

            System.out.println("getByPayment:" + e.getMessage());
        }
        return data;
    }

    public int getNumOrderSearch(String keyword, String method) {
        connect();
        int count = 0;

        try {
            String select = "SELECT COUNT(OrderID) AS count FROM Orders";
            String whereClause = "";
            List<String> params = new ArrayList<>();

            if (method.equals("status")) {
                whereClause = "WHERE orderStatus = ?";
                params.add(keyword);
            } else if (method.equals("payment")) {
                whereClause = "WHERE CheckPaymentStatus = ?";
                params.add(keyword);
            } else if (method.equals("all")) {
                whereClause = "JOIN Users ON Orders.UserID = Users.UserID "
                        + "WHERE OrderID LIKE ? OR OrderDate LIKE ? OR orderStatus LIKE ? "
                        + "OR TotalPrice LIKE ? OR Fullname LIKE ?";
                String likeKeyword = "%" + keyword + "%";
                params.add(likeKeyword);
                params.add(likeKeyword);
                params.add(likeKeyword);
                params.add(likeKeyword);
                params.add(likeKeyword);
            } else if (method.equals("orderID")) {
                whereClause = "WHERE orderID LIKE ?";
                params.add(keyword);
            } else if (method.equals("UserName")) {
                whereClause = "JOIN Users ON Orders.UserID = Users.UserID "
                        + "WHERE Fullname LIKE ?";
                params.add("%" + keyword + "%");
            } else if (method.equals("OrderDate")) {
                whereClause = "WHERE orderDate = ?";
                params.add(keyword);
                System.out.println(keyword);
            } else {
                System.out.println("Error");
            }
            select += " " + whereClause;
            System.out.println(select);

            pstm = cnn.prepareStatement(select);

            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }

            rs = pstm.executeQuery();

            if (rs.next()) {
                count = rs.getInt("count");
            }

            cnn.close();
        } catch (Exception ex) {
            System.out.println("GetCount: " + ex.getMessage());
        }

        System.out.println("Count: " + count);
        return count;
    }

    public String getTotalPrice(String orderID) {
        String strSelect = "select TotalPrice from Orders \n"
                + "where OrderID=?";
        String res = "";
        try {
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(orderID));
            rs = pstm.executeQuery();
            Locale locale = new Locale("vi", "VN");
            NumberFormat number = NumberFormat.getCurrencyInstance(locale);
            while (rs.next()) {
                res = number.format(Double.parseDouble(rs.getString("TotalPrice")));
            }

        } catch (Exception ex) {
            System.out.println("Get TotalPrice: " + ex.getMessage());
        }
        return res;

    }

    public String getTotalCoursePrice(String orderID) {
        String strSelect = "select sum(OrderDetail.price) as TotalPrice from OrderDetail\n"
                + "where OrderID = ?";
        String res = "";
        try {
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(orderID));
            rs = pstm.executeQuery();
            Locale locale = new Locale("vi", "VN");
            NumberFormat number = NumberFormat.getCurrencyInstance(locale);
            while (rs.next()) {
                res = number.format(Double.parseDouble(rs.getString("TotalPrice")));
            }

        } catch (Exception ex) {
            System.out.println("Get TotalPrice1: " + ex.getMessage());
        }
        return res;

    }

    public ArrayList<Course> getCourseInOrder(String OrderID) {
        connect();
        ArrayList<Course> data = new ArrayList<Course>();
        try {
            String strSelect = "select OrderID,OrderDetail.CourseID as CourseID,Course.CoursePrice ,CourseName,CourseImage from OrderDetail \n"
                    + "join Course on OrderDetail.CourseID=Course.CourseID\n"
                    + "where OrderID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(OrderID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CourseID = rs.getString("CourseID");
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String CoursePrice = number.format(Double.parseDouble(rs.getString("CoursePrice")));
                String CourseName = rs.getString("CourseName");
                String CourseImage = "img/" + rs.getString("CourseImage");
                Course a = new Course(CourseID, CourseName, CoursePrice);
                a.setCourseImg(CourseImage);
                data.add(a);
            }
        } catch (Exception ex) {
            System.out.println("Get Course: " + ex.getMessage());
        }
        return data;
    }

    public ArrayList<Course_Book> getBookInOrder(String OrderID) {
        connect();
        ArrayList<Course_Book> data = new ArrayList<Course_Book>();
        try {
            String strSelect = "select Course_Book.Course_BookID as Course_BookID, OrderBook.price as Price,OrderBook.quantity  as quantity,BookName,BookImg from Orders \n"
                    + "	join OrderBook on OrderBook.OrderID =Orders.OrderID\n"
                    + "	join Course_Book on OrderBook.Course_BookID=Course_Book.Course_BookID\n"
                    + "	where Orders.OrderID = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(OrderID));
            rs = pstm.executeQuery();
            while (rs.next()) {
                String BookID = rs.getString("Course_BookID");
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String BookPrice = number.format(Double.parseDouble(rs.getString("Price")));
                String BookName = rs.getString("BookName");
                String BookImg = "img/" + rs.getString("BookImg");
                int quantity = rs.getInt("quantity");
                
                Course_Book a = new Course_Book(BookID, BookName, BookPrice, BookImg, quantity);
                a.setQuantity(quantity);
                data.add(a);
            }
        } catch (Exception ex) {
            System.out.println("Get Course: " + ex.getMessage());
        }
        return data;
    }

    public ArrayList<Course> getListCourse() {
        connect();
        ArrayList<Course> data = new ArrayList<Course>();
        try {
            String strSelect = "  select CourseID,CourseName,CoursePrice,CourseDescription from Course";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String CourseID = rs.getString("CourseID");
                Locale locale = new Locale("vi", "VN");
                NumberFormat number = NumberFormat.getCurrencyInstance(locale);
                String CoursePrice = number.format(Double.parseDouble(rs.getString("CoursePrice")));
                String CourseDescription = rs.getString("CourseDescription");
                String CourseName = rs.getString("CourseName");
                Course a = new Course(CourseID, CourseName, CoursePrice, CourseDescription);
                data.add(a);
            }
        } catch (Exception ex) {
            System.out.println("Get Course List: " + ex.getMessage());
        }
        return data;
    }

    public void updateOrder(String orderID, String[] courses) {
        ArrayList<Course> courseData = getCourseInOrder(orderID);
        boolean contained;
        for (String course : courses) {
            contained = false;
            for (Course c : courseData) {
                if (c.getCourseID().equals(course)) {
                    contained = true;
                    break;
                }
            }
            if (!contained) {
                connect();
                try {
                    String strAdd = "insert into OrderDetail(OrderID,CourseID) "
                            + "values \n"
                            + "(?,?)";
                    pstm = cnn.prepareStatement(strAdd);
                    pstm.setInt(1, Integer.parseInt(orderID));
                    pstm.setInt(2, Integer.parseInt(course));
                    pstm.execute();
                } catch (Exception ex) {
                    System.out.println("Update add : " + ex.getMessage());
                }
            }
        }
        for (Course c : courseData) {
            contained = true;
            for (String course : courses) {
                if (c.getCourseID().equals(course)) {
                    contained = false;
                }
            }
            if (contained) {
                connect();
                try {
                    String strdelete = "  delete from OrderDetail\n"
                            + "  where OrderID=? and CourseID=?";
                    pstm = cnn.prepareStatement(strdelete);
                    pstm.setInt(1, Integer.parseInt(orderID));
                    pstm.setInt(2, Integer.parseInt(c.getCourseID()));
                    pstm.execute();
                } catch (Exception ex) {
                    System.out.println("Update delete : " + ex.getMessage());
                }
            }
        }
        connect();
        try {
            String strUpdate = "update Orders "
                    + "set OrderDate=? \n"
                    + "where OrderID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pstm.setInt(2, Integer.parseInt(orderID));
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("Update course : " + ex.getMessage());
        }
    }

    public void updateStatus(String orderID, String orderStatus) {
        connect();
        try {
            System.out.println(orderID);
            String strUpdate = "update Orders "
                    + "set OrderDate=? , "
                    + "orderStatus=? "
                    + "where OrderID=?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pstm.setString(2, orderStatus);
            pstm.setInt(3, Integer.parseInt(orderID));
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("Update status : " + ex.getMessage());
        }
    }

    public void updateStatusUser(String orderID) {
        connect();
        try {
            System.out.println(orderID);
            String strUpdate = "update Orders "
                    + "set "
                    + "orderStatus= 'canceled' "
                    + "where OrderID=?";
            pstm = cnn.prepareStatement(strUpdate);

            pstm.setInt(1, Integer.parseInt(orderID));
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("Update status : " + ex.getMessage());
        }
    }

    public String generateNewOrder(String uid, String TotalPrice) {
        String strInsert = "insert Orders(UserID,OrderDate,CheckPaymentStatus,TotalPrice,orderStatus)\n"
                + "values (?,?,0,?,'approved')";
        try {
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, uid);
            pstm.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            pstm.setString(3, TotalPrice);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("newOrder : " + ex.getMessage());
        }
        String id = "";
        String strSelect = "select OrderID from Orders\n"
                + "where UserID = ? and OrderDate=(select max(OrderDate) from Orders where UserID=?)";
        try {
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, uid);
            pstm.setString(2, uid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getString("OrderID");
            }
        } catch (Exception ex) {
            System.out.println("getNewestOrderID : " + ex.getMessage());
        }
        return id;
    }

    public void addOrderCourseItems(String orderID, String Price, String CourseID) {
        connect();
        String strInsert = "insert OrderDetail(OrderID,CourseID,Price)\n"
                + "values (?,?,?)";
        try {
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, orderID);
            pstm.setString(2, CourseID);
            pstm.setString(3, Price);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("newOrder : " + ex.getMessage());
        }
    }
    public String getOrderDate(String orderID){
        connect();
        String strSelect="select OrderDate from Orders where OrderID =?";
        try{
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, orderID);
            rs=pstm.executeQuery();
            while(rs.next()){
                return rs.getString("OrderDate");
            }
        }catch(Exception ex ){
            System.out.println("get OrderDate : " + ex.getMessage());
        }
        return "";
    }
    public void addOrderBookItems(String orderID,String Price,String BookID,String Quantity){
        connect();
        String strInsert = "insert OrderBook(OrderID,Course_BookID,Price,Quantity)\n"
                + "values (?,?,?,?)";
        try {
            pstm = cnn.prepareStatement(strInsert);
            pstm.setString(1, orderID);
            pstm.setString(2, BookID);
            pstm.setString(3, Price);
            pstm.setString(4, Quantity);
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("newOrder : " + ex.getMessage());
        }
    }

    public void deleteOrderItems(String orderID) {
        connect();
        String strDelete = "delete from OrderDetail where orderID=?";
        try {
            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, orderID);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("delete : " + ex.getMessage());
        }
    }
    public void deleteOrderBook(String orderID){
        connect();
        String strDelete="delete from OrderBook where orderID=?";
        try {
            pstm=cnn.prepareStatement(strDelete);
            pstm.setString(1, orderID);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("delete : " + ex.getMessage());
        }
    }
    public String getUsername(String OrderID){
        connect();
        String strSelect="Select Username from Users join Orders on Users.UserID=Orders.UserID where OrderID=?";
        try {
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, OrderID);
            rs=pstm.executeQuery();
            while (rs.next()){
                return rs.getString("Username");
            }
        } catch (Exception e) {
            System.out.println("getUsername : " + e.getMessage());
        }
        return "";
    }
    public void updateOrder2(String OrderID,String TotalPrice){
        connect();
        String strUpdate = "update Orders\n"
                + "set TotalPrice=?,"
                + " OrderDate = ?"
                + " where OrderID=?";
        try {
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, TotalPrice);
            pstm.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            pstm.setString(3, OrderID);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println("Update Order : " + ex.getMessage());
        }
    }

    public void updatePaymentStatus(String orderID) {
        connect();
        try {
            System.out.println(orderID);
            String strUpdate = "update Orders                   \n"
                    + "set CheckPaymentStatus= 1 \n"
                    + " where OrderID= ?";
            pstm = cnn.prepareStatement(strUpdate);           
            pstm.setInt(1, Integer.parseInt(orderID));
            pstm.execute();
        } catch (Exception ex) {
            System.out.println("Update status : " + ex.getMessage());
        }
    }
}

//    public static void main(String[] args){
//        OrderDAO u = new OrderDAO();
//        ArrayList<Order> data = u.getFullOrderDetail(1);
//        for(Order s : data){
//            System.out.println(s.getOrderID());
//            System.out.println(s.getBookID());
//            System.out.println(s.getBookName());
//            System.out.println(s.getBookPrice());
//            System.out.println(s.getQuantity());
//            System.out.println("---------------------------");
//        }
//    }

