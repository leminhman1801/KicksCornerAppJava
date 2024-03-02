/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

/**
 *
 * @author Asus
 */
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.table.TableCellRenderer;

public class CustomCellNoRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
    private Border border = BorderFactory.createLineBorder(Color.BLACK); 
    public CustomCellNoRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER); 
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        
        ((JComponent) component).setBorder(BorderFactory.createCompoundBorder(border, new EmptyBorder(0, 5, 0, 5)));
        
       
       if (column == 0 && row >= 0) {
            setText(String.valueOf(row + 1));
            setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            
            setText(value != null ? value.toString() : "");
        }
        return component;
    }
}

