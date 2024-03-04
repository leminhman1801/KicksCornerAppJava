/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Employee;
import classSQL.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
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

    public static int getCustomerID(JTextField phone) {
        int customerID = -1;
        try {
            String sql = "Select customerID From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone.getText());
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                customerID = result.getInt("customerID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerID;
    }
    public static String getCustomerName(JTextField phone) {
        String customerName = null;
        try {
            String sql = "Select customerName From Customer Where customerPhone = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, phone.getText());
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                customerName = result.getString("customerName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerName;
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

    public static Object[] getProductByID(JTextField productId, JTextField sizeID) {
        Object[] infoOrder = new Object[4];
        infoOrder[0] = productId.getText();
        infoOrder[1] = sizeID.getText();
        return infoOrder;
    }

    public static Object[][] getOrderTable(JTable table, DefaultTableModel model) {

        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        Object[][] lastSixColumnsData = new Object[rowCount][7];
        for (int row = 0; row < rowCount; row++) {

            for (int col = columnCount - 7, j = 0; col < columnCount; col++, j++) {

                lastSixColumnsData[row][j] = model.getValueAt(row, col);
            }
        }
        return lastSixColumnsData;
    }

    public static Object[][] getLastSixColumnsFromTable(JTable table, DefaultTableModel model) {

        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        Object[][] lastSixColumnsData = new Object[rowCount][6];
        for (int row = 0; row < rowCount; row++) {

            for (int col = columnCount - 6, j = 0; col < columnCount; col++, j++) {

                lastSixColumnsData[row][j] = model.getValueAt(row, col);
            }
        }
        return lastSixColumnsData;
    }

    public static Object[] getInvoiceInfo(JTextField productIDOrder, JTextField sizeIDOrder, JTextField phoneOrder, JTextField usingPointField, JTextField cashField, JLabel subTotalLabel, JLabel totalInvoiceLabel, JLabel changeLabel, JLabel employeeNameLabel) {
        
        int productID = Integer.parseInt(productIDOrder.getText());
        int sizeID = Integer.parseInt(sizeIDOrder.getText());
        String phone = phoneOrder.getText();
        String employeeName = employeeNameLabel.getText();
        int usingPoint = Integer.parseInt(usingPointField.getText());
        double cash = Double.parseDouble(cashField.getText());

        
        double price = Double.parseDouble(subTotalLabel.getText());
        double totalInvoice = Double.parseDouble(totalInvoiceLabel.getText());
        double change = Double.parseDouble(changeLabel.getText());

        // Tạo một mảng Object chứa thông tin hóa đơn
        Object[] invoiceInfo = {productID, sizeID, phone, usingPoint, cash, price, totalInvoice, change, employeeName};

        return invoiceInfo;
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

    public static int getSizeID(Float sizeName) {
       int sizeID = -1;
        try {
            String sql = "Select sizeID From Size Where sizeName = ? ";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setFloat(1, sizeName);
            ResultSet result = psmt.executeQuery();

            if (result.next()) {

                sizeID = result.getInt("sizeID");
            }

        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sizeID;
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

    public static Employee getUser(String username, String password) {
        Employee user = null;
        try {
            String sql = "Select * From Employee WHERE username = ? AND password = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            ResultSet result = psmt.executeQuery();

            if (result.next()) {
                user = new Employee(
                        result.getInt("employeeID"),
                        result.getInt("roleID"),
                        result.getString("employeeName"),
                        result.getString("employeePhone"),
                        result.getString("username")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static boolean isValidUser(String username, String password) {
        boolean isValid = false;

        try {
            String sql = "SELECT username, password From Employee WHERE username = ? AND password = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);

            ResultSet result = psmt.executeQuery();

            isValid = result.next();
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isValid;
    }
    public static boolean isOrderIDUsed(String orderID) {
    boolean isUsed = false;
    try {
        String sql = "SELECT orderID FROM OrderTable WHERE orderID = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, orderID);
        ResultSet result = psmt.executeQuery();
        isUsed = result.next(); 
    } catch (SQLException ex) {
        Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return isUsed;
}
}
