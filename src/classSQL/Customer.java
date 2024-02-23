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

    public Customer(Object[] newCustomer) {
        this.customerID = (int) newCustomer[0];
        this.customerName = (String) newCustomer[1];
        this.customerPhone = (String) newCustomer[2];
//        this.customerPoint = Integer.parseInt((String) newCustomer[3]);
        if (newCustomer[3] != null) {
            this.customerPoint = Integer.parseInt((String) newCustomer[3]);
        } else {
            // Xử lý khi newCustomer[3] là null, ví dụ gán giá trị mặc định
            this.customerPoint = 0; // hoặc bất kỳ giá trị mặc định nào khác
        }
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
