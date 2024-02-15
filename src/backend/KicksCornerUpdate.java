/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Customer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
public class KicksCornerUpdate {
    public static Connection conn = ConnectionDB.getConnection();
   public static void UpdateMembership(Customer newCustomer){
       
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
}
