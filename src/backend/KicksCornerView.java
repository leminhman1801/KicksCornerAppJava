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
public class KicksCornerView {
    public static Connection conn = ConnectionDB.getConnection();
    public static void MembershipView(){
        try{
            String sql = "Select * From Customer";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            while(result.next()){
                System.out.println(result.getString("customerID") + result.getString("customerName") + result.getString("customerPhone") + result.getInt("customerPoint"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KicksCornerView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
