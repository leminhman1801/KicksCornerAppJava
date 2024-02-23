/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

/**
 *
 * @author Asus
 */
public class Inventory {
    int productID;
    int sizeID;
    int amount;
    float discount;
    public Inventory(Object[] newProductSize){
        if (newProductSize[0] instanceof String) {
            this.productID = Integer.parseInt((String) newProductSize[0]);
        } else {
            this.productID = (Integer) newProductSize[0];
        }
        if (newProductSize[1] instanceof String) {
            this.sizeID = Integer.parseInt((String) newProductSize[1]);
        } else {
            this.sizeID = (Integer) newProductSize[1];
        }
        if (newProductSize[2] instanceof String) {
            this.amount = Integer.parseInt((String) newProductSize[2]);
        } else {
            this.amount = (Integer) newProductSize[2];
        }
        if (newProductSize[3] instanceof String) {
                this.discount = Integer.parseInt((String) newProductSize[3]);
            } else {
                this.discount = (Integer) newProductSize[3];
        }
    }
    public int getProductID(){
        return productID;
    }
    public int getSizeID(){
        return sizeID;
    }
    public int getAmount(){
        return amount;
    }
    public float getDiscount(){
        return discount;
    }
}
