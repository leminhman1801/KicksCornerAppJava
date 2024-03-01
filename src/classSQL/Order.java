/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class Order {

    int productID;
    int sizeID;
    String customerPhone;
    int point;

    public Order(Object[] newOrder) {
        if (newOrder[0] instanceof Integer) {
            this.productID = (int) newOrder[0];
        } else if (newOrder[0] instanceof String) {
            try {
                this.productID = Integer.parseInt((String) newOrder[0]);
            } catch (NumberFormatException e) {
             
                this.productID = 0; 
            }
        } else {
            
            this.productID = 0; 
        }
        if (newOrder[1] instanceof Integer) {
            this.sizeID = (int) newOrder[1];
        } else if (newOrder[1] instanceof String) {
            try {
                this.sizeID = Integer.parseInt((String) newOrder[1]);
            } catch (NumberFormatException e) {
                
                this.sizeID = 0; 
            }
        } else {
            
            this.sizeID = 0; 
        }
        this.customerPhone = (String) newOrder[2];
        if (newOrder[3] instanceof String) {
            try {
                this.point = Integer.parseInt((String) newOrder[3]);
            } catch (NumberFormatException e) {
              
                this.point = 0; 
            }
        } else {
           
            this.point = 0; 
        }
    }
    public int getProductID(){
        return productID;
    }
    public int getSizeID(){
        return sizeID;
    }
    public String getCustomerPhone(){
        return customerPhone;
    }
    public int getPoint(){
        return point;
    }
}
