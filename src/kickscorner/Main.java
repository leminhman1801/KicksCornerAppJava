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
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JTable table; // Biến table được khai báo ở mức độ toàn cục

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"STT", "Tên", "Tuổi"}, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }
        };

        table = new JTable(model); // Khởi tạo biến table ở đây
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Thiết lập renderer cho cột số thứ tự
        table.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(String.valueOf(row + 1));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });

        // Thêm dữ liệu mẫu
        model.addRow(new Object[]{null, "John", 30});
        model.addRow(new Object[]{null, "Alice", 25});
        model.addRow(new Object[]{null, "Bob", 35});

        // Button xóa hàng được thêm vào để xóa hàng được chọn
        JButton deleteButton = new JButton("Xóa hàng");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    updateRowNumbers(); // Cập nhật lại số thứ tự sau khi xóa hàng
                }
            }
        });
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Hàm này cập nhật lại số thứ tự của các hàng sau khi một hàng được xóa
    private static void updateRowNumbers() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Cập nhật số thứ tự trong cột 0
        }
    }
}



