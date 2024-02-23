/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Customer;
import classSQL.Employee;
import classSQL.Inventory;
import classSQL.Product;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class KicksCornerUpdate {

    public static Connection conn = ConnectionDB.getConnection();

    public static void updateMembership(Customer newCustomer) {

        try {
            String sql = "Update Customer Set customerName = ?, customerPhone = ?, customerPoint = ? Where customerID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newCustomer.getCustomerName());
            psmt.setString(2, newCustomer.getCustomerPhone());
            psmt.setInt(3, newCustomer.getCustomerPoint());
            psmt.setInt(4, newCustomer.getCustomerID());
            psmt.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateProduct(Product editedProduct) {

        try {
            String sql = "Update Product Set productName = ?, price = ? Where productID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, editedProduct.getProductName());
            psmt.setBigDecimal(2, editedProduct.getPrice());
            psmt.setInt(3, editedProduct.getProductID());
            psmt.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void updateInventory(Inventory editedInventory) {

        try {
            String sql = "Update ProductSize Set amount = ?, discount = ? Where productID = ? And sizeID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, editedInventory.getAmount());
            psmt.setFloat(2, editedInventory.getDiscount());
            psmt.setInt(3, editedInventory.getProductID());
            psmt.setInt(4, editedInventory.getSizeID());
            psmt.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateEmployee(Employee editedEmployee) {

        try {
            String sql = "Update Employee Set employeeName = ?, roleID = ?, employeePhone = ? Where employeeID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);  
            psmt.setString(1, editedEmployee.getEmployeeName());
            psmt.setInt(2, editedEmployee.getRole());
            psmt.setString(3, editedEmployee.getEmployeePhone());
            psmt.setInt(4, editedEmployee.getEmployeeID());
            psmt.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
