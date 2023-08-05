package Controller.UserSiteController;

import Controller.ManageEmployeeController.setRoleByAdmin;
import DAO.OrderDAO;
import DAO.UserDAO;
import Model.Course_Book;
import Model.Course;
import Model.User;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class ExportController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = "";
        String orderID = "";
        OrderDAO u = new OrderDAO();
        ArrayList<Course> datac = new ArrayList<>();
        ArrayList<Course_Book> dataB = new ArrayList<>();
        if (req.getParameter("mode") != null) {
            orderID = req.getParameter("orderID");
            mode = req.getParameter("mode");
            datac = u.getCourseInOrder(orderID);
            dataB = u.getBookInOrder(orderID);
        }
        User user = new UserDAO().getUserInfo(new OrderDAO().getUsername(orderID));
        if (mode.equals("excel")) {
            try {
                //khai báo tên file muốn tạo

                //gọi phương thức creatSheet() và truyền tên file muốn tạo //tạo một đối tượng của lớp HSSFWorkbook
                HSSFWorkbook workbook = new HSSFWorkbook();
                //gọi phương thức creatSheet() và truyền tên file muốn tạo
                HSSFSheet sheet = workbook.createSheet("Order" + orderID);
                //tạo hàng thứ 0 sử dụng phương thức createRow()

                Row row1 = sheet.createRow(0);
                Cell cell1 = row1.createCell(0);
                Cell cell3 = row1.createCell(6);
                // Set values for the cells
                cell1.setCellValue("Elearning");
                cell3.setCellValue("Address : Hoa Lac,Ha Noi");
                // Merge cells
                int firstColumn = 0; // First column index of the merged region
                int lastColumn = 1; // Last column index of the merged region
                int rowIndex = 0; // Row index of the merged region
                int lastRowIndex = 0; // Last row index of the merged region
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, lastRowIndex, firstColumn, lastColumn));
                firstColumn = 6; // First column index of the merged region
                lastColumn = 9; // Last column index of the merged region
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, lastRowIndex, firstColumn, lastColumn));
                row1 = sheet.createRow(1);
                cell1 = row1.createCell(6);
                cell1.setCellValue("Contact : 0999999999");
                rowIndex = 1;
                lastRowIndex = 1;
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, lastRowIndex, firstColumn, lastColumn));
                row1 = sheet.createRow(3);
                cell1 = row1.createCell(3);
                cell1.setCellValue("ORDER #" + orderID);
                firstColumn = 3; // First column index of the merged region
                lastColumn = 5;
                rowIndex = 2;
                lastRowIndex = 2;
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, lastRowIndex, firstColumn, lastColumn));
                cell1 = row1.createCell(6);
                cell1.setCellValue(new OrderDAO().getOrderDate(orderID));
                firstColumn = 6; // First column index of the merged region
                lastColumn = 9; // Last column index of the merged region
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, lastRowIndex, firstColumn, lastColumn));
                row1 = sheet.createRow(5);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Customer Info");
                sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
                row1 = sheet.createRow(7);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Name : " + user.getuName());
                sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 4));
                row1 = sheet.createRow(8);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Contact : " + user.getuPhoneNumber());
                sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 4));
                row1 = sheet.createRow(9);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Email : " + user.getuEmail());
                sheet.addMergedRegion(new CellRangeAddress(9, 9, 0, 4));
                row1 = sheet.createRow(10);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Address : " + user.getuAddress());
                sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 4));
                row1 = sheet.createRow(12);
                cell1 = row1.createCell(0);
                cell1.setCellValue("Order Info");
                HSSFRow rowhead = sheet.createRow(14);
                sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 2));
                //tạo ô bằng cách sử dụng phương thức createCell() và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
                rowhead.createCell(1).setCellValue("Product No");
                rowhead.createCell(2).setCellValue("Product Name");
                rowhead.createCell(3).setCellValue("Quantity");
                rowhead.createCell(4).setCellValue("ItemPrice");
                rowhead.createCell(5).setCellValue("TotalPrice");
                int rownum = 15;
                //tạo hàng 
                for (Course c : datac) {
                    HSSFRow row = sheet.createRow(rownum);
                    row.createCell(1).setCellValue(rownum - 14);
                    row.createCell(2).setCellValue(c.getCourseName());
                    row.createCell(3).setCellValue(1);
                    row.createCell(4).setCellValue(c.getCoursePrice());
                    row.createCell(5).setCellValue(c.getCoursePrice());
                    rownum++;
                }
                for (Course_Book b : dataB) {
                    HSSFRow row = sheet.createRow(rownum);
                    row.createCell(1).setCellValue(rownum - 14);
                    row.createCell(2).setCellValue(b.getBookName());
                    row.createCell(3).setCellValue(b.getQuantity());
                    row.createCell(4).setCellValue(b.getPrice());
                    row.createCell(5).setCellValue(b.getTotalPrice());
                    rownum++;
                }
                HSSFRow row = sheet.createRow(rownum);
                row.createCell(2).setCellValue("Total");
                row.createCell(5).setCellValue(u.getTotalPrice(orderID));
                resp.setContentType("text/xls");
                resp.setHeader("Content-disposition", "attachment;filename=" + "Order" + orderID + ".xls");
                try ( ServletOutputStream fileOut = resp.getOutputStream()) {
                    workbook.write(fileOut);
                    //đóng stream
                    fileOut.close();
                    //đóng workbook
                    workbook.close();
                }

            } catch (IOException e) {

            }
            try ( PrintWriter out = resp.getWriter()) {
                out.print("<script>\n"
                        + "  setTimeout(function() {\n"
                        + "      window.close()\n"
                        + "  }, 0);\n"
                        + "</script>");
            }
        } else if (mode.equals("pdf")) {
            try {

                Document document = new Document();
                // Specify the output file path
                PdfWriter.getInstance(document, resp.getOutputStream());
                document.open();
                PdfPTable table1 = new PdfPTable(2);
                table1.setWidthPercentage(100);

                // Create the left-aligned cell
                PdfPCell leftCell = new PdfPCell(new Paragraph("ELEARNING"));
                leftCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                leftCell.setPaddingRight(20);
                leftCell.setBorder(PdfPCell.NO_BORDER);
                table1.addCell(leftCell);

                // Create the right-aligned cell
                PdfPCell rightCell = new PdfPCell(new Paragraph("Address : Hoa Lac,Ha Noi\nContact : 0999999999"));
                rightCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                rightCell.setPaddingLeft(100);
                rightCell.setBorder(PdfPCell.NO_BORDER);
                table1.addCell(rightCell);
                // Add the table to the document
                document.add(table1);
                Paragraph orderNum = new Paragraph(new Chunk("Order # " + orderID + "\n"));
                orderNum.setAlignment(Element.ALIGN_CENTER);
                orderNum.setSpacingBefore(20);
                orderNum.setSpacingAfter(20);
                
                document.add(orderNum);
                Paragraph Paragraph1 = new Paragraph("Order Date : " + new OrderDAO().getOrderDate(orderID));
                Paragraph1.setAlignment(Element.ALIGN_RIGHT);
                document.add(Paragraph1);
                Paragraph1 = new Paragraph("Customer Info");
                Paragraph1.setSpacingAfter(10);
                document.add(Paragraph1);
                Paragraph1 = new Paragraph("\tName : " + user.getuName()
                        +"\n\tContact : " + user.getuPhoneNumber()
                        +"\n\tEmail : " + user.getuEmail()
                +"\n\tAddress : " + user.getuAddress());
                Paragraph1.setSpacingAfter(10);
                document.add(Paragraph1);
                Paragraph1 = new Paragraph("Order Info");
                Paragraph1.setSpacingAfter(20);
                document.add(Paragraph1);
                PdfPTable table = new PdfPTable(4);
                table.addCell("Product No");
                table.addCell("Product Name");
                table.addCell("Quantity");
                table.addCell("Price");
                int count = 1;
                for (Course c : datac) {
                    String productNo = "" + count;
                    table.addCell(productNo);
                    table.addCell(c.getCourseName());
                    PdfPCell quantity = new PdfPCell(new Paragraph("1"));
                    quantity.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(quantity);
                    PdfPCell Price = new PdfPCell(new Paragraph(c.getCoursePrice()));
                    Price.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    PdfPCell totalPrice = new PdfPCell(new Paragraph(c.getCoursePrice()));
                    totalPrice.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(totalPrice);
                    count++;
                }
                for (Course_Book b : dataB) {
                    String productNo = "" + count;
                    table.addCell(productNo);
                    table.addCell(b.getBookName());
                    PdfPCell quantity = new PdfPCell(new Paragraph("" + b.getQuantity()));
                    quantity.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(quantity);
                    PdfPCell Price = new PdfPCell(new Paragraph(b.getPrice()));
                    Price.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    PdfPCell totalPrice = new PdfPCell(new Paragraph(b.getTotalPrice()));
                    totalPrice.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(totalPrice);
                    count++;
                }
                // Add content to the document
                document.add(table);
                table = new PdfPTable(2);
                PdfPCell label = new PdfPCell(new Paragraph("Total Price"));
                label.setBorder(PdfPCell.NO_BORDER);
                label.setHorizontalAlignment(Element.ALIGN_RIGHT);
                // Add content to the document
                table.addCell(label);
                PdfPCell totalPrice = new PdfPCell(new Paragraph(u.getTotalPrice(orderID)));
                totalPrice.setBorder(PdfPCell.NO_BORDER);
                totalPrice.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(totalPrice);
                document.add(table);
                // Close the document
                document.close();
                resp.getOutputStream().close();
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("ordermanage");
    }

    private Paragraph createFormField(String label, String value) {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(label));
        paragraph.add(new Paragraph(value));
        paragraph.add(new Paragraph("________________________________________"));
        paragraph.setAlignment(Element.ALIGN_LEFT);
        return paragraph;
    }
}
