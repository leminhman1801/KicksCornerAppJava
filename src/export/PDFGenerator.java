/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package export;

/**
 *
 * @author Asus
 */
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import javax.swing.JTable;

public class PDFGenerator {

    public static void generatePDF(JTable table, String title) {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("");
        try {
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void printPanel(String orderID, LocalDateTime dateTime, String customerName, String employeeName,  String phone, Object[][] data, String[] columnHeaders, double subTotal, int pointUsed, double total, double cash, double change) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        PageFormat pageFormat = job.defaultPage();
        pageFormat.setOrientation(PageFormat.LANDSCAPE);
        Paper paper = new Paper();
        paper.setSize(595.0, 842.0); // Kích thước A4: 595x842 điểm ảnh
        paper.setImageableArea(0.0, 0.0, 595.0, 842.0); // Khu vực có thể in

        pageFormat.setPaper(paper);
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum) throws PrinterException {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.47, 0.47);

                // In các thông tin cần thiết
                g2.drawString("KicksCorner", 100, 100);
                g2.drawString("Bill ID: " + orderID, 100, 120);
                g2.drawString("Date Time: " + dateTime, 100, 140);
                g2.drawString("Customer: " + customerName, 100, 160);
                g2.drawString("Phone: " + phone, 100, 180);
                g2.drawString("Cashier: " + employeeName, 100, 200);
                
                int columnSpacing = 50;
                // In tiêu đề cột
                int x = 100;
                int y = 200 + columnSpacing;
                int startIndex = data[0].length - 6;
                for (String columnHeader : columnHeaders) {
                    g2.drawString(columnHeader, x, y);
                    x += 80; // Điều chỉnh khoảng cách giữa các tiêu đề cột
                }

                x = 100;
                y += 20; // Xuống dòng
                for (Object[] rowData : data) {
                    x = 100;
                    // Chạy vòng lặp từ startIndex đến data[0].length - 1 để chỉ lấy 6 cột cuối cùng
                    for (int i = startIndex; i < data[0].length; i++) {
                        g2.drawString(rowData[i].toString(), x, y);
                        x += 80; // Điều chỉnh khoảng cách giữa các dữ liệu
                    }
                    y += 20; // Xuống dòng
                }

                // In các thông tin khác
                int tableHeight = data.length * 20; // Giả sử mỗi hàng có chiều cao là 20 (cần điều chỉnh tùy thuộc vào kích thước thực tế của bảng)
                int yBottomRight = y + tableHeight + 20; // 20 là khoảng cách giữa bảng và các thông tin bên dưới

                g2.drawString("SubTotal: " + subTotal, 100, yBottomRight);
                g2.drawString("Point Used: " + pointUsed, 100, yBottomRight + 20);
                g2.drawString("Total: " + total, 100, yBottomRight + 40);
                g2.drawString("Cash: " + cash, 100, yBottomRight + 60);
                g2.drawString("Change: " + change, 100, yBottomRight + 80);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
