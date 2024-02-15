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
    String employeeName;
    String username;
    String password;
    String employeePhone;
    String role;
    
    public Employee (Object[] newEmployee){
       
        this.employeeName = (String) newEmployee[0];
        this.username = (String) newEmployee[1];
        this.password = (String) newEmployee[2];
        this.employeePhone = (String) newEmployee[3];
        this.role = "Employee";
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
    public String getRole(){
        return role;
    }
    
    
}
