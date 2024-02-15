/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import classSQL.Customer;
import classSQL.Employee;
import classSQL.Product;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
public class KicksCornerInsert {
    public static Connection conn = ConnectionDB.getConnection();
    public static void insertMembership(Customer newCustomer){
        
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
    public static void insertEmployee(Employee newEmployee){
        
        try {
            String sql = "Insert Into Employee (employeeName, role, employeePhone, username, password) Values (?, 'Employee', ?, ?, ?)";
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
    public static void insertProduct(Product newProduct){
        
        try {
            String sql = "Insert Into Product (productName, price) Values (?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newProduct.getProductName());
            psmt.setBigDecimal(2, newProduct.getPrice());
          
            psmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
}
