/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


import classSQL.OrderTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import kickscorner.RegisterCustomer;

/**
 *
 * @author Asus
 */
public class KicksCornerShow1 {

    public static Connection conn = ConnectionDB.getConnection();
    
    public static void showNewRowMembership(DefaultTableModel membershipModel) {
        try {
            String sql = "Select TOP 1 * From Customer ORDER BY customerID DESC";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();
            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];

                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                System.out.println("" + rowData[0] + rowData[1] + rowData[2] + rowData[3] + rowData[4]);
                membershipModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showNewRowEmployee(DefaultTableModel employeeModel) {
        try {
            String sql = "Select TOP 1 employeeID, employeeName, roleID, employeePhone From Employee ORDER BY employeeID DESC";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();

            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                employeeModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showNewRowProduct(DefaultTableModel productModel) {
        try {
            String sql = "Select TOP 1 * From Product ORDER BY productID DESC";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();

            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                productModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void showNewRegisterCustomer(DefaultTableModel membershipModel, String phone) {
        try {
            String sql = "Select * From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();

            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                membershipModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showNewRowOrder(DefaultTableModel orderModel, OrderTable newOrder) {
        try {
            String sql = """
                     SELECT p.productID, p.productName, s.sizeName, p.price, ps.discount
                     FROM Product p
                     INNER JOIN ProductSize ps ON p.productID = ps.productID
                     INNER JOIN Size s ON ps.sizeID = s.sizeID
                     WHERE p.productID = ? AND ps.sizeID = ?;""";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, newOrder.getProductID());
            psmt.setInt(2, newOrder.getSizeID());
            ResultSet result = psmt.executeQuery();

            if (!result.next()) {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Object[] rowData = new Object[8];
            rowData[0] = orderModel.getRowCount() + 1;
            rowData[1] = result.getInt("productID");
            rowData[2] = result.getString("productName");
            rowData[3] = result.getFloat("sizeName");
            rowData[4] = 1; // Quantity mặc định là 1
            double price = result.getDouble("price");
            double discount = result.getDouble("discount");
            double amount = price * (1 - discount / 100);
            rowData[5] = price;
            rowData[6] = discount;
            rowData[7] = amount;
            orderModel.addRow(rowData);
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public static void showProduct(DefaultTableModel inventoryModel, int selectedRow, int productID) {
    boolean productFound = false;
    while (!productFound) {
        try {
            String sql = "Select productName, price From Product Where productID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productID);
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                String productName = result.getString("productName");
                double price = result.getDouble("price");
                String formattedPrice = String.format("%.2f", price);
                inventoryModel.setValueAt(productName, selectedRow, 2);
                inventoryModel.setValueAt(formattedPrice, selectedRow, 4);
                productFound = true;
            } else {
                JOptionPane.showMessageDialog(null, "No product found with the entered ID. Please try again.", "Message", JOptionPane.WARNING_MESSAGE);
                // Prompt the user to enter a new product ID
                String input = JOptionPane.showInputDialog("Enter product ID:");
                // Convert the input to an integer
                try {
                    productID = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // Handle invalid input (not an integer)
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid product ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    public static void showNewPrice(JTable table, DefaultTableModel inventoryModel, int selectedRow, int productID, int sizeID) {

        try {
            String sql = "SELECT p.price, ps.discount "
                    + "FROM Product p "
                    + "INNER JOIN ProductSize ps ON p.productID = ps.productID "
                    + "WHERE p.productID = ? AND ps.sizeID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productID);
            psmt.setInt(2, sizeID);
            ResultSet result = psmt.executeQuery();
            System.out.println("Row: " + selectedRow);

            if (result.next()) {
                float price = result.getFloat("price");
                int newDiscount = result.getInt("discount");
                float newPrice = price - (price * newDiscount / 100);
                int modelRow = table.convertRowIndexToModel(selectedRow);
                inventoryModel.setValueAt(newPrice, modelRow, 4);
                System.out.println("result");
            }
            result.close();
            psmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void showPoint(String phone, JLabel label) {
        try {
            String sql = "Select customerName, customerPoint From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone);
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                int customerPoint = result.getInt("customerPoint");
                String customerName = result.getString("customerName");
                label.setText(String.valueOf("Name: " + customerName + ", point: " + customerPoint));
            } else {
//               
                int option = JOptionPane.showConfirmDialog(null, "This phone number is not registered. Do you want to sign up as a member?", "Membership Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    RegisterCustomer registerCustomer = new RegisterCustomer();
                    registerCustomer.getJTextFieldPhoneNewCustomer().setText(phone);
                    registerCustomer.setVisible(true);
                } else {
                   
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
   
}
