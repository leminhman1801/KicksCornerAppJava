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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TableExample {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JButton addButton;
    private JButton editButton;
    private JButton cancelButton;
    private Object[] originalData; // Biến lưu trữ giá trị ban đầu của dòng được chọn

    public TableExample() {
        frame = new JFrame("Table Example");
        frame.setLayout(new BorderLayout());

        // Tạo bảng và thêm vào scroll pane
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
            {"1", "John", "25"},
            {"2", "Jane", "30"},
            {"3", "Doe", "40"}
        };
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tạo panel chứa các nút
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        cancelButton = new JButton("Cancel");

        // Thêm các nút vào panel
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(cancelButton);

        // Thêm panel vào frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Xử lý sự kiện cho các nút
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi click vào nút Add
                model.addRow(new Object[]{"", "", ""});
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi click vào nút Edit
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Lưu trữ giá trị ban đầu của dòng được chọn
                    originalData = model.getDataVector().get(selectedRow).toArray();
                    String id = (String) model.getValueAt(selectedRow, 0);
                    String name = (String) model.getValueAt(selectedRow, 1);
                    String age = (String) model.getValueAt(selectedRow, 2);
                    String input = JOptionPane.showInputDialog(frame, "Enter new data (ID, Name, Age):", id + ", " + name + ", " + age);
                    if (input != null) {
                        String[] newData = input.split(",");
                        if (newData.length == 3) {
                            model.setValueAt(newData[0].trim(), selectedRow, 0);
                            model.setValueAt(newData[1].trim(), selectedRow, 1);
                            model.setValueAt(newData[2].trim(), selectedRow, 2);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid input format!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to edit!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi click vào nút Cancel
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Khôi phục lại giá trị ban đầu của dòng được chọn
                    if (originalData != null) {
                        for (int i = 0; i < originalData.length; i++) {
                            model.setValueAt(originalData[i], selectedRow, i);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row!");
                }
            }
        });

        // Cài đặt cho frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableExample();
            }
        });
    }
}



