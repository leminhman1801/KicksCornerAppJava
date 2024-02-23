/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Asus
 */
public class Search {
    public static void search(JTextField textField, DefaultTableModel tableModel, JTable table ){
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable(textField, tableModel, table );
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable(textField, tableModel, table);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable(textField, tableModel, table);
            }
        });
    }
    public static void filterTable(JTextField textField, DefaultTableModel tableModel, JTable table) {
        String searchText = textField.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);

        if (searchText.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
        }
    }
}
