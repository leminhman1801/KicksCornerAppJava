/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
public class KicksCornerDelete {
    public static Connection conn = ConnectionDB.getConnection();
    
    public static void deleteMembership (int customerID){
       
        try {
            String sql = "Delete From Customer Where customerID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, customerID);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteEmployee (int employeeID){
       
        try {
            String sql = "Delete From Employee Where employeeID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, employeeID);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteProduct (int productID){
       
        try {
            String sql = "Delete From Product Where productID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productID);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void deleteInventory (int productID){
       
        try {
            String sql = "Delete From ProductSize Where productID = ?";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, productID);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
