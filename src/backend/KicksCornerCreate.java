/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class KicksCornerCreate {

    public static Connection conn = ConnectionDB.getConnection();

    public static void createNewRowMembership() {
        try {
            String sql = "Insert Into Customer (customerName, customerPhone, customerPoint) Values (null, null, null)";
            PreparedStatement psmt = conn.prepareStatement(sql);

            psmt.executeUpdate();
            System.out.println("Created ID");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createNewRowProduct() {

        try {
            String sql = "Insert Into Product (productName, price) Values (null, null)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.executeUpdate();
            System.out.println("Created ID");
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
