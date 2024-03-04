/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class OrderDetail {

    String orderID;
    int productID;
    int sizeID;
    double price;
    int quantity;

    // Constructor
    public OrderDetail(String orderID, int productID, int sizeID, double price, int quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.sizeID = sizeID;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getOrderID() {
        return orderID;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
