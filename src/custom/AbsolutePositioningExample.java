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
import java.awt.*;
import java.awt.event.*;



public class AbsolutePositioningExample extends JFrame {
    public AbsolutePositioningExample() {
        setTitle("Absolute Positioning Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Sử dụng null layout manager

        // Tạo các thành phần
        JButton button = new JButton("Button");
        JTextField textField = new JTextField("TextField");
        JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});

        // Đặt vị trí và kích thước cho mỗi thành phần
        button.setBounds(20, 20, 80, 30);
        textField.setBounds(120, 20, 120, 30);
        list.setBounds(0, 0, 200, 100); // Đặt vị trí và kích thước của JList

        // Thêm các thành phần vào JFrame
        add(button);
        add(textField);
        add(list);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AbsolutePositioningExample::new);
    }
}


