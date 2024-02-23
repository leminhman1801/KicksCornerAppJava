/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

import java.math.BigDecimal;

/**
 *
 * @author Asus
 */
public class Product {
    int productID;
    String productName;
    BigDecimal price;
    public Product(Object[] newProduct){
        this.productID = (int) newProduct[0];   
        this.productName = (String) newProduct[1];
        if (newProduct[2] instanceof Integer) {
                int intValue = (int) newProduct[2];
                this.price = BigDecimal.valueOf(intValue);
            } else {
                this.price = new BigDecimal((String) newProduct[2]);
            }
    }
    public int getProductID(){
        return productID;
    }
    public String getProductName(){
        return productName;
    }
    public BigDecimal getPrice(){
        return price;
    }
}
