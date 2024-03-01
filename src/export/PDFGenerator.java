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
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.swing.JTable;



public class PDFGenerator {

    public static void generatePDF(JTable table, String title) {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("");
        try{
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}

