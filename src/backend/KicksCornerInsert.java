/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Customer;
import classSQL.Employee;
import classSQL.Inventory;
import classSQL.Order;
import classSQL.OrderDetail;
import classSQL.Product;
import classSQL.Role;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class KicksCornerInsert {

    public static Connection conn = ConnectionDB.getConnection();

    public static void insertMembership(Customer newCustomer) {
        try {
            String sql = "Insert Into Customer (customerName, customerPhone, customerPoint) Values ( ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newCustomer.getCustomerName());
            psmt.setString(2, newCustomer.getCustomerPhone());
            psmt.setInt(3, newCustomer.getCustomerPoint());
            psmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void insertEmployee(Employee newEmployee) {

        try {
            String sql = "Insert Into Employee (roleID, employeeName, employeePhone, username, password) Values (2, ?, ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newEmployee.getEmployeeName());
            psmt.setString(2, newEmployee.getEmployeePhone());
            psmt.setString(3, newEmployee.getUsername());
            psmt.setString(4, newEmployee.getPassword());
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void insertProduct(Product newProduct) {

        try {
            String sql = "Insert Into Product (productName, price) Values (?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newProduct.getProductName());
            psmt.setDouble(2, newProduct.getPrice());

            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void insertInventory(Inventory newProductSize) {
        try {
            String sql = "Insert Into ProductSize (productID, sizeID, amount, discount) Values ( ?, ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, newProductSize.getProductID());
            psmt.setInt(2, newProductSize.getSizeID());
            psmt.setInt(3, newProductSize.getAmount());
            psmt.setFloat(4, newProductSize.getDiscount());
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void insertOrder(Order newOrder) {

        try {
            String sql = "Insert Into OrderTable (orderID, customerID, employeeID, orderDate) Values (?, ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newOrder.getOrderID());
            psmt.setInt(2, newOrder.getCustomerID());

            psmt.setInt(3, newOrder.getEmployeeID());
            LocalDateTime orderDate = newOrder.getOrderDate();
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            psmt.setTimestamp(4, timestamp);
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void insertOrderDetail(OrderDetail newOrderDetail) {
        try {
            String sql = "Insert Into OrderDetail (orderID, productID, sizeID, price, quantity) Values (?, ?, ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newOrderDetail.getOrderID());
            psmt.setInt(2, newOrderDetail.getProductID());
            psmt.setInt(3, newOrderDetail.getSizeID());
            psmt.setDouble(4, newOrderDetail.getPrice());
            psmt.setInt(5, newOrderDetail.getQuantity());
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     public static void insertRole(Role role) {
        try {
            String sql = "Insert Into [Role] (roleID, roleName, permission) Values (?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, role.getRoleID());
            psmt.setString(2, role.getRoleName());
            psmt.setString(3, role.getPermission());
       
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
