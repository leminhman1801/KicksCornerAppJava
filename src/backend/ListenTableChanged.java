 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Customer;
import classSQL.Product;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
/**
 *
 * @author Asus
 */
public class ListenTableChanged {
    public static void addMembership(JTable table){
        final int[] nonEmptyCount = {0};
        table.getModel().addTableModelListener(new TableModelListener(){
         
         
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if(e.getType()== TableModelEvent.UPDATE && row >= 0 && column >= 0){
                   
                    Object cellValue = table.getValueAt(row, column); 
                     System.out.println("Updated");
                    if (cellValue != null && !cellValue.toString().trim().isEmpty()) {
                        nonEmptyCount[0]++;
                    } else {
                        nonEmptyCount[0]--;
                    }
                    
                    if (nonEmptyCount[0] == table.getColumnCount()-2) {
                        int newRowIndex = table.getRowCount() - 1;
                        Object[] newRowValue = new Object[table.getColumnCount()-2];
                        
                        for(int currentCol = 2; currentCol <  table.getColumnCount(); currentCol++ ){
                           newRowValue[currentCol-2] = table.getValueAt(newRowIndex, currentCol);
                            
                        }
                        System.out.println("" + newRowValue[0] + newRowValue[1] + newRowValue[2]);
                        
                        Customer newCustomer = new Customer(newRowValue);
                        KicksCornerInsert.insertMembership(newCustomer);
                    }
                }
                   
            }
        });
    }
     public static void addProduct(JTable table){
        final int[] nonEmptyCount = {0};
        table.getModel().addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if(e.getType()== TableModelEvent.UPDATE && row >= 0 && column >= 0){
                
                Object cellValue = table.getValueAt(row, column);
                System.out.println("Updated");
                if (cellValue != null && !cellValue.toString().trim().isEmpty()) {
                    nonEmptyCount[0]++;
                } else {
                    nonEmptyCount[0]--;
                }
                
                if (nonEmptyCount[0] == table.getColumnCount()-2) {
                    int newRowIndex = table.getRowCount() - 1;
                    Object[] newRowValue = new Object[table.getColumnCount()-2];
                    
                    for(int currentCol = 2; currentCol <  table.getColumnCount(); currentCol++ ){
                        newRowValue[currentCol-2] = table.getValueAt(newRowIndex, currentCol);
                        
                    }
                    System.out.println("" + newRowValue[0] + newRowValue[1]);      
                    Product newProduct = new Product(newRowValue);
                    KicksCornerInsert.insertProduct(newProduct);
                }
            }
        });
    }   
     public static void addProduct1(JTable table) {
    AtomicInteger nonEmptyCount = new AtomicInteger(0);
    table.getModel().addTableModelListener((TableModelEvent e) -> {
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() >= 0 && e.getLastRow() == table.getRowCount() - 1) {
            int lastRowIndex = e.getLastRow();
            boolean allColumnsNonEmpty = true;
            for (int column = 2; column < table.getColumnCount(); column++) {
                Object cellValue = table.getValueAt(lastRowIndex, column);
                if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                    allColumnsNonEmpty = false;
                    break;
                }
            }
            if (allColumnsNonEmpty) {
                nonEmptyCount.incrementAndGet();
            } else {
                nonEmptyCount.decrementAndGet();
            }
            if (nonEmptyCount.get() == table.getColumnCount() - 2) {
                Object[] newRowValue = new Object[table.getColumnCount() - 2];
                for (int currentCol = 2; currentCol < table.getColumnCount(); currentCol++) {
                    newRowValue[currentCol - 2] = table.getValueAt(lastRowIndex, currentCol);
                }
                Product newProduct = new Product(newRowValue);
                KicksCornerInsert.insertProduct(newProduct);
            }
        }
    });
}
}
