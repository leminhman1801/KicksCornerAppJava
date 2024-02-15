/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
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
    public static void getMemberShip(DefaultTableModel membershipTable){  
        try {
            String sql = "Select * From Customer";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
//            int columnCount = result.getMetaData().getColumnCount();
            int columnCount = membershipTable.getColumnCount()-1;
            System.out.println(columnCount);
             int rowCount = 1;
            while(result.next()){
                Object[] rowData = new Object[columnCount+1];
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
    
    
    public static Object[] getEmployeeSignUp(JTextField name, JTextField username, JTextField password, JTextField phone){
        Object[] employeeInfo = new Object[4];
        employeeInfo[0] = name.getText();
        employeeInfo[1] = username.getText();
        employeeInfo[2] = password.getText();
        employeeInfo[3] = phone.getText();
        return employeeInfo;
    }
    
    public static void getEmployee(DefaultTableModel employeeModel){  
        try {
            String sql = "Select * From Employee";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
//            int columnCount = result.getMetaData().getColumnCount();
            int columnCount = employeeModel.getColumnCount()-1;
            System.out.println(columnCount);
             int rowCount = 1;
            while(result.next()){
                Object[] rowData = new Object[columnCount+1];
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
    
    public static void getProduct(DefaultTableModel productModel){  
        try {
            String sql = "Select * From Product";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet result = psmt.executeQuery();
//            int columnCount = result.getMetaData().getColumnCount();
            int columnCount = productModel.getColumnCount()-1;
            System.out.println(columnCount);
             int rowCount = 1;
            while(result.next()){
                Object[] rowData = new Object[columnCount+1];
               rowData[0] = rowCount;
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i] = result.getObject(i);
                }
                productModel.addRow(rowData);
                 rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
  
}
