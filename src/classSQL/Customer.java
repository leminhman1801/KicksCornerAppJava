/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class Customer {
    int customerID;
    String customerName;
    String customerPhone;
    int customerPoint;
    public Customer(Object[] newCustomer){
        this.customerName = (String) newCustomer[0];
        this.customerPhone = (String) newCustomer[1];
        this.customerPoint = Integer.parseInt((String) newCustomer[2]);
    }
     public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public int getCustomerPoint() {
        return customerPoint;
    }
}
