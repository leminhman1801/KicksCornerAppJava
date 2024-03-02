/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GetData {

    public static Connection conn = ConnectionDB.getConnection();
    private static int customerPoint;
    public static void getMemberShip(DefaultTableModel membershipTable) {
        try {
            String sql = "Select * From Customer";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
//            int columnCount = result.getMetaData().getColumnCount();
            int columnCount = membershipTable.getColumnCount() - 1;
            int rowCount = 1;
            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                rowData[0] = rowCount;
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                membershipTable.addRow(rowData);
                rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Object[] getEmployeeSignUp(JTextField name, JTextField username, JTextField password, JTextField phone) {
        Object[] employeeInfo = new Object[4];
        employeeInfo[0] = name.getText();
        employeeInfo[1] = username.getText();
        employeeInfo[2] = phone.getText();
        employeeInfo[3] = password.getText();
        return employeeInfo;
    }
     public static Object[] getNewCustomer(JTextField name, JTextField phone) {
        Object[] newCustomer = new Object[2];
        newCustomer[0] = name.getText();
        newCustomer[1] = phone.getText();
        return newCustomer;
    }
    public static Object[] getInfoOrder(JTextField productId, JTextField sizeID) {
        Object[] infoOrder = new Object[4];
        infoOrder[0] = productId.getText();
        infoOrder[1] = sizeID.getText();
        return infoOrder;
    }
    public static void getEmployee(DefaultTableModel employeeModel) {
        try {
            String sql = "Select employeeID, employeeName, roleID, employeePhone From Employee";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();

            int columnCount = employeeModel.getColumnCount() - 1;
            int rowCount = 1;
            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                rowData[0] = rowCount;
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                employeeModel.addRow(rowData);
                rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getProduct(DefaultTableModel productModel) {
        try {
            String sql = "Select productID, productName, price From Product";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
//            int columnCount = result.getMetaData().getColumnCount();
            int rowCount = 1;
            while (result.next()) {
                 Object[] rowData = new Object[4];
            rowData[0] = rowCount;
            rowData[1] = result.getObject("productID");
            rowData[2] = result.getObject("productName");
            
            BigDecimal price = result.getBigDecimal("price");
            BigDecimal formattedPrice = price.setScale(2, RoundingMode.HALF_UP);
            rowData[3] = formattedPrice;

            productModel.addRow(rowData);
            rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getRole(DefaultTableModel roleModel) {
        try {
            String sql = "Select * From Role";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = roleModel.getColumnCount() - 1;
            int rowCount = 1;
            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];
                rowData[0] = rowCount;
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                roleModel.addRow(rowData);
                rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getInventory(DefaultTableModel inventoryModel) {
        try {
            String sql = "Select Product.productID, Product.productName, ProductSize.sizeID, Product.price, ProductSize.amount, ProductSize.discount\n"
                    + "From Product\n" + "Inner Join ProductSize On Product.productID = ProductSize.productID";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = inventoryModel.getColumnCount() - 1;

            while (result.next()) {
                Object[] rowData = new Object[columnCount + 1];

                BigDecimal price = result.getBigDecimal("price");
                // Lấy discount từ cột discount
                int discount = result.getInt("discount");

//                BigDecimal discountedPrice = (BigDecimal) (price - (price * discount / 100));
               BigDecimal discountedPrice = price.subtract(price.multiply(BigDecimal.valueOf(discount / 100.0)))
                    .setScale(2, RoundingMode.HALF_UP);

                rowData[1] = result.getObject("productID");
                rowData[2] = result.getObject("productName");
                rowData[3] = result.getObject("sizeID");
                rowData[4] = discountedPrice;
                rowData[5] = result.getObject("amount");
                rowData[6] = result.getObject("discount");
                inventoryModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static int getPoint(String phone) {
        
        try {
            String sql = "Select  customerPoint From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone);
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                customerPoint = result.getInt("customerPoint");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerPoint;
    }

}
