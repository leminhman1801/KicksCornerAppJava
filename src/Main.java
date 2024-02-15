import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");
        DefaultTableModel model = new DefaultTableModel();

        // Tạo bảng với mô hình dữ liệu mặc định
        JTable table = new JTable(model);

        // Thêm cột cho bảng
        model.addColumn("Column 1");
        model.addColumn("Column 2");

        // Tạo các trường nhập liệu
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);

        // Tạo nút để thêm dữ liệu
        JButton addButton = new JButton("Add Data");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm dữ liệu vào mô hình ngay cả khi trường nhập liệu rỗng
                model.addRow(new Object[]{"", ""});
            }
        });

        // Tạo nút để lấy dữ liệu từ hàng vừa nhập
        JButton getDataButton = new JButton("Get Data");
        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    Object data1 = model.getValueAt(selectedRow, 0);
                    Object data2 = model.getValueAt(selectedRow, 1);

                    System.out.println("Data in selected row: " + data1 + ", " + data2);
                } else {
                    System.out.println("No row selected");
                }
            }
        });

        // Tạo panel cho các trường nhập liệu và nút
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Column 1:"));
        inputPanel.add(textField1);
        inputPanel.add(new JLabel("Column 2:"));
        inputPanel.add(textField2);
        inputPanel.add(addButton);
        inputPanel.add(getDataButton);

        // Thêm bảng và panel vào frame
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
