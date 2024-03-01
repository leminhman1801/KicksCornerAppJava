/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import classSQL.Customer;
import classSQL.Employee;
import classSQL.Inventory;
import classSQL.Product;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import kickscorner.KicksCorner;
import static kickscorner.KicksCorner.discountChanged;

/**
 *
 * @author Asus
 */
public class ListenTableChanged {

    public static boolean changedDiscount;

    public static void addMembership(JTable table) {
        final int[] nonEmptyCount = {0};
        table.getModel().addTableModelListener((TableModelEvent e) -> {
            int row = table.getSelectedRow();
            int column = e.getColumn();
            if (e.getType() == TableModelEvent.INSERT && row >= 0 && column >= 0) {

                Object cellValue = table.getValueAt(row, column);
                System.out.println("Updated");
                if (cellValue != null && !cellValue.toString().trim().isEmpty()) {
                    nonEmptyCount[0]++;
                } else {
                    nonEmptyCount[0]--;
                }

                if (nonEmptyCount[0] == table.getColumnCount() - 2) {
                    int newRowIndex = table.getRowCount() - 1;
                    Object[] newRowValue = new Object[table.getColumnCount() - 1];
                    for (int currentCol = 1; currentCol < table.getColumnCount() - 1; currentCol++) {
                        newRowValue[currentCol - 1] = table.getValueAt(newRowIndex, currentCol);

                    }
                    System.out.println("" + newRowValue[0] + newRowValue[1] + newRowValue[2]);

                    Customer newCustomer = new Customer(newRowValue);
                    KicksCornerUpdate.updateMembership(newCustomer);
                }
            }
        });
    }

//    public static void addProduct(JTable table) {
//        final int[] nonEmptyCount = {0};
//        table.getModel().addTableModelListener((TableModelEvent e) -> {
//            int row = e.getFirstRow();
//            int column = e.getColumn();
//            if (e.getType() == TableModelEvent.UPDATE && row >= 0 && column >= 0) {
//
//                Object cellValue = table.getValueAt(row, column);
//                if (column == 3) { // Kiểm tra cột giá sản phẩm (đếm từ 0)
//                if (cellValue != null) {
//                    String price = cellValue.toString();
//                    // Kiểm tra giá trị nhập vào bằng regex
//                    if (!price.matches("^\\d*\\.?\\d{0,2}$")) {
//                        // Nếu giá trị không hợp lệ, thông báo lỗi và đặt lại giá trị là null
//                        JOptionPane.showMessageDialog(null, "Price must be a valid number with up to 2 decimal places.");
//                        table.setValueAt(null, row, column);
//                    }
//                }
//            }
//                System.out.println("Updated");
//                if (cellValue != null && !cellValue.toString().trim().isEmpty()) {
//                    nonEmptyCount[0]++;
//                } else {
//                    nonEmptyCount[0]--;
//                }
//
//                if (nonEmptyCount[0] == table.getColumnCount() - 2) {
//                    int newRowIndex = table.getRowCount() - 1;
//                    Object[] newRowValue = new Object[table.getColumnCount() - 1];
//
//                    for (int currentCol = 1; currentCol < table.getColumnCount(); currentCol++) {
//                        newRowValue[currentCol - 1] = table.getValueAt(newRowIndex, currentCol);
//
//                    }
//                    System.out.println("" + newRowValue[0] + newRowValue[1]);
//                    Product newProduct = new Product(newRowValue);
//                    KicksCornerUpdate.updateProduct(newProduct);
//                }
//            }
//        });
//    }
    public static void addProduct(JTable table) {
        final int[] nonEmptyCount = {0};
        table.getModel().addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            int column = e.getColumn();
            if (e.getType() == TableModelEvent.UPDATE && row >= 0 && column >= 0) {

                if (column == 3) {
                    Object cellValue = table.getValueAt(row, column);
                    if (cellValue != null) {
                        BigDecimal price;
                        try {
                            price = new BigDecimal(cellValue.toString()).setScale(2);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a valid number.");
                            // Đặt giá trị mặc định cho ô đó hoặc xử lý lỗi theo ý muốn của bạn
                            table.setValueAt(null, row, column);
                            return;
                        }
                        // Đặt lại giá trị đã định dạng vào ô đó
                        table.setValueAt(price, row, column);
                    }
                }
                System.out.println("Updated");
                if (table.getValueAt(row, column) != null && !table.getValueAt(row, column).toString().trim().isEmpty()) {
                    nonEmptyCount[0]++;
                } else {
                    nonEmptyCount[0]--;
                }

                if (nonEmptyCount[0] == table.getColumnCount() - 2) {
                    int newRowIndex = table.getRowCount() - 1;
                    Object[] newRowValue = new Object[table.getColumnCount() - 1];

                    for (int currentCol = 1; currentCol < table.getColumnCount(); currentCol++) {
                        newRowValue[currentCol - 1] = table.getValueAt(newRowIndex, currentCol);
                    }
                    System.out.println("" + newRowValue[0] + newRowValue[1]);
                    Product newProduct = new Product(newRowValue, table, row, column);
                    KicksCornerUpdate.updateProduct(newProduct);
                }
            }
        });
    }

    public static void addInventory(JTable table) {
        table.getModel().addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) { // Kiểm tra xem có sự kiện cập nhật ô trong bảng không
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Kiểm tra xem ô được cập nhật có thuộc hàng mới được thêm vào không
                if (row == table.getRowCount() - 1) {
                    boolean allCellsFilled = true;
                    for (int i = 1; i < table.getColumnCount(); i++) { // Bắt đầu từ cột 1 (loại bỏ cột "No.")
                        Object cellValue = table.getValueAt(row, i);
                        if (cellValue == null || cellValue.toString().trim().isEmpty()) {
                            allCellsFilled = false;
                            break;
                        }
                    }

                    // Nếu tất cả các ô đã được nhập, thực hiện xử lý sự kiện
                    if (allCellsFilled) {
                        int newRowIndex = table.getRowCount() - 1;
                        Object[] newRowValue = new Object[table.getColumnCount() - 1];
                        newRowValue[0] = table.getValueAt(newRowIndex, 1);
                        newRowValue[1] = table.getValueAt(newRowIndex, 3);
                        newRowValue[2] = table.getValueAt(newRowIndex, 5);
                        newRowValue[3] = table.getValueAt(newRowIndex, 6);
                        System.out.println("All cells in row " + row + " filled.");
                        System.out.println("" + newRowValue[0] + newRowValue[1] + newRowValue[2] + newRowValue[3]);
                        Inventory newProductSize = new Inventory(newRowValue);
                        KicksCornerInsert.insertInventory(newProductSize);

                    }
                }
            }
        });
    }

    public static void editMembership(JTable table) {

        table.getModel().addTableModelListener((TableModelEvent e) -> {

            if (e.getType() == TableModelEvent.UPDATE) {
                int row = table.getSelectedRow();
                int column = e.getColumn();

                System.out.println("Updated");
                if (column == 0) {

                    return;
                }
                System.out.println("Table Column: " + table.getColumnCount());
                Object[] editedRowValue = new Object[table.getColumnCount() - 1];
                if (row >= 0 && column >= 0) {

                    for (int currentCol = 1; currentCol < table.getColumnCount(); currentCol++) {
                        editedRowValue[currentCol - 1] = table.getValueAt(row, currentCol);
                    }
                }
                for (Object value : editedRowValue) {
                    System.out.println(value);
                }
                System.out.println("" + editedRowValue[0] + editedRowValue[1] + editedRowValue[2] + editedRowValue[3]);
                Customer editedProductValue = new Customer(editedRowValue);
                KicksCornerUpdate.updateMembership(editedProductValue);
            }
        });
    }

    public static void editEmployee(JTable table) {

        table.getModel().addTableModelListener((TableModelEvent e) -> {

            if (e.getType() == TableModelEvent.UPDATE) {
                int row = table.getSelectedRow();
                int column = e.getColumn();

                System.out.println("Updated");
                if (column == 0) {

                    return;
                }
                Object[] editedRowValue = new Object[table.getColumnCount() - 1];
                if (row >= 0 && column >= 0) {

                    for (int currentCol = 1; currentCol < table.getColumnCount(); currentCol++) {
                        editedRowValue[currentCol - 1] = table.getValueAt(row, currentCol);
                    }
                }
                for (Object value : editedRowValue) {
                    System.out.println(value);
                }
                int employeeID = (int) editedRowValue[0];
                String employeeName = (String) editedRowValue[1];
                int roleID = (int) editedRowValue[2];
                String employeePhone = (String) editedRowValue[3];
                System.out.println("" + editedRowValue[0] + editedRowValue[1] + editedRowValue[2] + editedRowValue[3]);
                Employee editedEmployee = new Employee(employeeID, employeeName, roleID, employeePhone);
                KicksCornerUpdate.updateEmployee(editedEmployee);
            }
        });
    }

    public static void editProduct(JTable table) {

        table.getModel().addTableModelListener((TableModelEvent e) -> {

            if (e.getType() == TableModelEvent.UPDATE) {
                int row = table.getSelectedRow();
                int column = e.getColumn();

                System.out.println("Updated");
                Object[] editedRowValue = new Object[table.getColumnCount() - 1];
                if (row >= 0 && column >= 0) {

                    for (int currentCol = 1; currentCol < table.getColumnCount(); currentCol++) {
                        editedRowValue[currentCol - 1] = table.getValueAt(row, currentCol);
                    }
                }
                System.out.println("" + editedRowValue[0] + editedRowValue[1] + editedRowValue[2]);
                Product editedProductValue = new Product(editedRowValue, table, row, column);
                KicksCornerUpdate.updateProduct(editedProductValue);
            }
        });
    }

    public static void editInventory(JTable table, DefaultTableModel inventoryModel) {

        table.getModel().addTableModelListener((TableModelEvent e) -> {

            if (e.getType() == TableModelEvent.UPDATE) {
                int row = table.getSelectedRow();
                int column = e.getColumn();
                int productID;
                int sizeID;
                System.out.println("Updated");
                Object[] editedRowValue = new Object[table.getColumnCount() - 1];
                if (row >= 0 && column >= 0) {

                    editedRowValue[0] = table.getValueAt(row, 1);
                    editedRowValue[1] = table.getValueAt(row, 3);
                    editedRowValue[2] = table.getValueAt(row, 5);
                    editedRowValue[3] = table.getValueAt(row, 6);

                }
                productID = Integer.parseInt(editedRowValue[0].toString());
                sizeID = Integer.parseInt(editedRowValue[1].toString());
                System.out.println("" + editedRowValue[0] + editedRowValue[1] + editedRowValue[2] + editedRowValue[3]);
                int priceColumnIndex = inventoryModel.findColumn("Price");
                System.out.println("Column: " + priceColumnIndex);
                Inventory editedProductValue = new Inventory(editedRowValue);
                KicksCornerUpdate.updateInventory(editedProductValue);

                if (!KicksCorner.discountChanged) {
                    System.out.println("la sao");
                    // Đặt biến cờ thành true trước khi gọi showNewPrice
                    KicksCorner.setDiscountChangedtTrue();
                    KicksCornerShow.showNewPrice(table, inventoryModel, row, productID, sizeID);

                    KicksCorner.setDiscountChangedtFalse();
                }

            }

        });

    }

}
