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
public class ConnectionDB {
    
  public static Connection getConnection(){
      Connection conn = null;
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=KicksCorner;encrypt=true;trustServerCertificate=true;", "sa", "sa");
      } catch (ClassNotFoundException ex) {
          System.out.println(ex);
      } catch (SQLException ex) {
          System.out.println(ex);
      }
      return conn;
      
  }
  public static void main(String[] args){
      String str = getConnection() == null ? "Failure" : "Success";
      System.out.println(str);
  }
}
