/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classSQL;

import backend.ProductIDListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.concurrent.CompletableFuture;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
 public class InventoryEditor implements ProductIDListener  {
    public static CompletableFuture<Integer> addInventory(JTable table, int selectedRow, ProductIDListener listener) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        final int[] productID = {0};
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField() {
            {
                addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        String productIdString = (String) table.getValueAt(selectedRow, 1);
                        if (!productIdString.isEmpty() && productIdString.matches("\\d+")) {
                            productID[0] = Integer.parseInt(productIdString);
                            future.complete(productID[0]); // Trả về ID sản phẩm
                        }
                    }
                });
            }
        }));
        return future;
    }

        @Override
        public void onProductIDUpdated(int productID) {
          System.out.println("Product ID updated: " + productID);
        }
    }
