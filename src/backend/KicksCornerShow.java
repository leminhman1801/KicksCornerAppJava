/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static backend.GetData.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class KicksCornerShow {
    public static Connection conn = ConnectionDB.getConnection();
    public static void showNewRowMembership(DefaultTableModel membershipModel){
         try {
            String sql = "Select TOP 1 * From Customer ORDER BY customerID DESC";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();
            int num = 1;
            while(result.next()){
                Object[] rowData = new Object[columnCount + 1];
                rowData[0] = num;
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                membershipModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public static void showNewRowEmployee(DefaultTableModel employeeModel){
         try {
            String sql = "Select TOP 1 employeeID, employeeName, role, employeePhone From Employee ORDER BY employeeID DESC";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
            int columnCount = result.getMetaData().getColumnCount();

            while(result.next()){
                Object[] rowData = new Object[columnCount+1];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                employeeModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
