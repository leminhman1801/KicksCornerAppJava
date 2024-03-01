/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package export;

/**
 *
 * @author Asus
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class PDFGeneratorBOX {

    public static void generatePDF(JTable table) {
    try {
        // Tạo một tài liệu PDF mới
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Tạo một ContentStream để vẽ trên trang PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Vẽ nội dung của bảng từ dữ liệu của JTable
        drawTableContent(contentStream, page, table); // Chuyển page vào hàm vẽ

        // Đóng ContentStream và lưu tài liệu PDF
        contentStream.close();
        document.save("Table.pdf");
        document.close();

        // Mở tài liệu PDF
        File file = new File("Table.pdf");
        Desktop.getDesktop().open(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

//private static void drawTableContent(PDPageContentStream contentStream, PDPage page, JTable table) throws IOException {
//    // Lấy số lượng hàng và cột của JTable
//    int rowCount = table.getRowCount();
//    int colCount = table.getColumnCount();
//
//    // Thiết lập kích thước và vị trí của bảng trong PDF
//    float margin = 50;
//    float yStart = page.getMediaBox().getHeight() - margin;
//    float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
//    float yPosition = yStart;
//
//    // Vẽ nội dung của bảng từ dữ liệu của JTable
//    for (int row = 0; row < rowCount; row++) {
//        for (int col = 0; col < colCount; col++) {
//            Object cellData = table.getValueAt(row, col);
//            // Vẽ ô
//            contentStream.beginText();
//            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
//            contentStream.newLineAtOffset(margin + (col * 100), yPosition);
//            contentStream.showText(cellData != null ? cellData.toString() : "");
//            contentStream.endText();
//        }
//        yPosition -= 20; // Di chuyển xuống hàng tiếp theo
//    }
//}
    private static void drawTableContent(PDPageContentStream contentStream, PDPage page, JTable table) throws IOException {
        // Lấy số lượng hàng và cột của JTable
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();

        // Thiết lập kích thước và vị trí của bảng trong PDF
        float margin = 50;
        float yStart = page.getMediaBox().getHeight() - margin;
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yPosition = yStart;

        // Thiết lập kích thước cột
        float[] columnWidths = {150, 150, 150}; // Điều chỉnh kích thước cột tùy theo số cột của bảng

        // Vẽ nội dung của bảng từ dữ liệu của JTable
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Object cellData = table.getValueAt(row, col);
                // Vẽ ô
                contentStream.beginText();
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);
                contentStream.newLineAtOffset(margin + getColumnXPosition(col, columnWidths), yPosition);
                contentStream.showText(cellData != null ? cellData.toString() : "");
                contentStream.endText();
            }
            yPosition -= 20; // Di chuyển xuống hàng tiếp theo
        }

        // Vẽ khung bảng
        drawTableBorders(contentStream, margin, yStart, tableWidth, rowCount, colCount, columnWidths);
    }

    private static float getColumnXPosition(int colIndex, float[] columnWidths) {
        float xPosition = 0;
        for (int i = 0; i < colIndex; i++) {
            xPosition += columnWidths[i];
        }
        return xPosition;
    }

    private static void drawTableBorders(PDPageContentStream contentStream, float margin, float yStart, float tableWidth, int rowCount, int colCount, float[] columnWidths) throws IOException {
        float cellHeight = 20;
        float tableHeight = rowCount * cellHeight;

        // Vẽ đường kẻ ngang
        float nextY = yStart;
        for (int i = 0; i <= rowCount; i++) {
            contentStream.moveTo(margin, nextY);
            contentStream.lineTo(margin + tableWidth, nextY);
            contentStream.stroke();
            nextY -= cellHeight;
        }

        // Vẽ đường kẻ dọc
        float nextX = margin;
        for (int i = 0; i <= colCount; i++) {
            contentStream.moveTo(nextX, yStart);
            contentStream.lineTo(nextX, yStart - tableHeight);
            contentStream.stroke();
            if (i < colCount) {
                nextX += columnWidths[i];
            }
        }
    }
}

