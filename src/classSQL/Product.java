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
        this.productName = (String) newProduct[0];
        this.price = new BigDecimal((String) newProduct[1]);
    }
   
   
    public String getProductName(){
        return productName;
    }
    public BigDecimal getPrice(){
        return price;
    }
}
