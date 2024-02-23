/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static backend.GetData.conn;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class KicksCornerShow {

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

    public static void showProduct(DefaultTableModel inventoryModel, int selectedRow, int productID) {
        try {
            String sql = "Select productName, price From Product Where productID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productID);
            ResultSet result = psmt.executeQuery();

            while (result.next()) {
                String productName = result.getString("productName");
                float price = result.getFloat("price");
                inventoryModel.setValueAt(productName, selectedRow, 2);
                inventoryModel.setValueAt(price, selectedRow, 4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
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
                float newPrice = price - (price*newDiscount/100);
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
    
    public static void showPoint(String phone, JTextField textfield) {
        try {
            String sql = "Select customerPoint From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone);
            ResultSet result = psmt.executeQuery();
          

            if (result.next()) {

                String customerPoint = result.getString("customerPoint");
              
                textfield.setText(customerPoint);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
