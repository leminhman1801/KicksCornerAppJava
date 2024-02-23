/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class Employee {
    int employeeID;
    int roleID;
    String employeeName;
    String username;
    String password;
    String employeePhone;
    
    public Employee (Object[] newEmployee){
        this.employeeID = (int) newEmployee[0];
        this.employeeName = (String) newEmployee[1];
        this.username = (String) newEmployee[2];
        this.password = (String) newEmployee[3];
        this.employeePhone = (String) newEmployee[4];
        this.roleID = 2;
    }
    public Employee (int employeeID, String employeeName, int roleID, String employeePhone){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.roleID = roleID;
    }
    public int getEmployeeID(){
        return employeeID;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getEmployeePhone(){
        return employeePhone;
    }
    public int getRole(){
        return roleID;
    }
    
    
}
