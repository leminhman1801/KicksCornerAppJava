/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Asus
 */
public class Product {

    int productID;
    String productName;
    double price;

    public Product(Object[] newProduct, JTable table, int row, int column) {
        this.productID = (int) newProduct[0];
        this.productName = (String) newProduct[1];

        try {
            if (newProduct[2] instanceof Integer) {
                int intValue = (int) newProduct[2];
                this.price = (double) intValue;
                
            } else {
                 this.price = Double.parseDouble((String) newProduct[2]);
            }
             this.price = Math.round(this.price * 100.0) / 100.0;
            if (this.price <= 0) {
                JOptionPane.showMessageDialog(null, "Price must be greater than 0. Please enter a valid price.");
                table.setValueAt(null, row, column);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a valid number.");
            table.setValueAt(null, row, column);
        }
        
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
