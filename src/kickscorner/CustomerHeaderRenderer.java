/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kickscorner;

/**
 *
 * @author Asus
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomerHeaderRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Thiết lập font cho header của bảng
            Font headerFont = new Font("Arial", Font.BOLD, 16);
            setFont(headerFont);

            // Căn giữa văn bản trong ô header của bảng
//            setHorizontalAlignment(JLabel.CENTER);
            
//                        setBorder(BorderFactory.BorderFactory.createLineBorder(Color.BLACK));
                   
            return this;
        }
    }
