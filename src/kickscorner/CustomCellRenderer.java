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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    private Border border = BorderFactory.createLineBorder(Color.BLACK); // Đường viền màu đen

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Áp dụng đường viền cho ô
        ((JComponent) component).setBorder(border);
        setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(0, 5, 0, 0)));
         if (column == 0 && row >= 0) { // Kiểm tra row >= 0 để loại bỏ tiêu đề của cột STT
            setText(String.valueOf(row + 1));
            setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            // Đảm bảo không thay đổi nội dung của ô
            setText(value != null ? value.toString() : "");
        }
        return component;
    }

   
}

