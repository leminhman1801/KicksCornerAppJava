/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kickscorner;

import backend.GetData;
import backend.KicksCornerCreate;
import backend.KicksCornerDelete;
import backend.KicksCornerInsert;
import backend.KicksCornerShow1;
import backend.KicksCornerUpdate;
import backend.ListenTableChanged;

import backend.ProductIDListener;
import classSQL.Employee;
import classSQL.Inventory;
import classSQL.InventoryEditor;
import classSQL.Order;
import classSQL.OrderDetail;
import classSQL.OrderTable;
import custom.CustomCellNoRenderer;
import custom.Search;
import export.ExportToExcel;
import export.PDFGenerator;
import export.PDFGeneratorBOX;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.EventObject;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class KicksCorner extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public static JTable currentTable;
    public static DefaultTableModel currentModel;
    public static JTextField currentTextField;
    public static String currentTitle;
    private Employee employee;

    private static Consumer<Integer> deleteFunction;

    private static Object selectedID;
    CardLayout cardLayout;
    public static DefaultTableModel membershipModel;
    public static DefaultTableModel inventoryModel;
    public static DefaultTableModel employeeModel;
    public static DefaultTableModel productModel;
    public static DefaultTableModel roleModel;
    public static DefaultTableModel orderModel;
    public static DefaultTableModel invoiceModel;

    public static boolean discountChanged = false;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 8;
    private static int customerPoint;
    private static int editableRow = -1;
    private static int editableRowEmployee = -1;
    private static int editableRowInventory = -1;
    private static int editableRowProduct = -1;
    private static int editableRowOrder = -1;
    private static int editableRowRole = -1;
    private static int selectedRow = -1;
    private static int currentRole;

    public KicksCorner() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/KicksCornerIcon.png")));
        initComponents();
        menu.add(jPanelSearchList);
        cardLayout = (CardLayout) (jPanelCardLayout.getLayout());
        GetData.getMemberShip(membershipModel);
        GetData.getEmployee(employeeModel);
        GetData.getProduct(productModel);
        GetData.getRole(roleModel);
        GetData.getInventory(inventoryModel);
        setLocationRelativeTo(null);
        jTableMembership.getColumnModel().getColumn(0).setCellRenderer(new CustomCellNoRenderer());

    }

    public static DefaultTableModel getMembershipModel() {
        return membershipModel;
    }
    private boolean isEmptyRow(JTable table, int row) {
    for (int col = 0; col < table.getColumnCount(); col++) {
        Object value = table.getValueAt(row, col);
        if (value != null && !value.toString().isEmpty()) {
            return false;
        }
    }
    return true;
}
    public static String generateOrderID() {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setUsername(String username) {
        jLabelEmployeeName.setText(username);

    }

    public static void search(JTextField textField, DefaultTableModel model, JTable table) {
        Search.search(textField, model, table);
    }

    public static void setDiscountChangedtTrue() {
        discountChanged = true;
    }

    public static void setDiscountChangedtFalse() {
        discountChanged = false;
    }

    public static void onYes(JTable table, DefaultTableModel model, Consumer<Integer> deleteFunction) {
        selectedRow = table.getSelectedRow();
        deleteFunction.accept((int) selectedID);
        model.removeRow(selectedRow);
        table.repaint();
    }

    public void activeFeatureByRole(int role) {
        if (role == 2) {
            jButtonDashboard.setEnabled(false);
            jButtonProduct.setEnabled(false);
            jButtonMembership.setEnabled(false);
            jButtonEmployee.setEnabled(false);
            jButtonRole.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDelete = new javax.swing.JDialog();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jButtonNoDeleteMemberShip = new javax.swing.JButton();
        jButtonYesDeleteMemberShip = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelSearchList = new javax.swing.JPanel();
        searchList = new java.awt.List();
        menu = new javax.swing.JPopupMenu();
        jPanelBill = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabelSubtotalBlock = new javax.swing.JLabel();
        jLabelPointBlock = new javax.swing.JLabel();
        jLabelTotalBlock = new javax.swing.JLabel();
        jLabelCashBlock = new javax.swing.JLabel();
        jLabelChangeBlock = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();
        jTableInvoice = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonInventory = new javax.swing.JButton();
        jButtonOrder = new javax.swing.JButton();
        jButtonMembership = new javax.swing.JButton();
        jButtonDashboard = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonEmployee = new javax.swing.JButton();
        jButtonProduct = new javax.swing.JButton();
        jButtonRole = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelEmployeeName = new javax.swing.JLabel();
        jButtonLogOut = new javax.swing.JButton();
        jPanelCardLayout = new javax.swing.JPanel();
        jPanelOrder = new javax.swing.JPanel();
        jTextFieldProductIDOrder = new javax.swing.JTextField();
        jLabelNamePhone = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jButtonAddProductOrder = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabelChange = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelUsingPoint = new javax.swing.JLabel();
        jTextFieldUsingPoint = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabelSubTotal = new javax.swing.JLabel();
        jLabelTotalText = new javax.swing.JLabel();
        jLabelTotalInvoice = new javax.swing.JLabel();
        jButtonConfirmOrder = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCash = new javax.swing.JTextField();
        jLabelTotalOrderTable = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jButtonEditOrder = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextFieldSizeIDOrder = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldPhoneOrder = new javax.swing.JTextField();
        jPanelDashboard = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanelMembership = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMembership = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButtonAddMembership = new javax.swing.JButton();
        jButtonDeleteMembership = new javax.swing.JButton();
        jButtonEditMembership = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jTextFieldSearchMembership = new javax.swing.JTextField();
        jPanelInventory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInventory = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextFieldSearchInventory = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButtonAddInventory = new javax.swing.JButton();
        jButtonDeleteInventory = new javax.swing.JButton();
        jButtonEditInventory = new javax.swing.JButton();
        jPanelEmployee = new javax.swing.JPanel();
        jPanelEmployeeBlock = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jTextFieldSearchEmployee = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jButtonAddEmployee = new javax.swing.JButton();
        jButtonDeleteEmployee = new javax.swing.JButton();
        jButtonEditEmployee = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jPanelProduct = new javax.swing.JPanel();
        jPanelProductBlock = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jButtonExportExcelProduct = new javax.swing.JButton();
        jButtonPrintProduct = new javax.swing.JButton();
        jTextFieldSearchProduct = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jButtonAddNewProduct = new javax.swing.JButton();
        jButtonDeleteProduct = new javax.swing.JButton();
        jButtonEditProduct = new javax.swing.JButton();
        jPanelRole = new javax.swing.JPanel();
        jPanelRoleBlock = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableRole = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jButtonAddRole = new javax.swing.JButton();
        jButtonDeleteRole = new javax.swing.JButton();
        jButtonEditRole = new javax.swing.JButton();

        jDialogDelete.setSize(300, 200);
        jDialogDelete.setLocationRelativeTo(null);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setPreferredSize(new java.awt.Dimension(200, 200));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jButtonNoDeleteMemberShip.setText("No");
        jButtonNoDeleteMemberShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoDeleteMemberShipActionPerformed(evt);
            }
        });
        jPanel29.add(jButtonNoDeleteMemberShip);

        jButtonYesDeleteMemberShip.setText("Yes");
        jButtonYesDeleteMemberShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonYesDeleteMemberShipActionPerformed(evt);
            }
        });
        jPanel29.add(jButtonYesDeleteMemberShip);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Are you sure to delete?");
        jPanel30.add(jLabel6);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jDialogDeleteLayout = new javax.swing.GroupLayout(jDialogDelete.getContentPane());
        jDialogDelete.getContentPane().setLayout(jDialogDeleteLayout);
        jDialogDeleteLayout.setHorizontalGroup(
            jDialogDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jDialogDeleteLayout.setVerticalGroup(
            jDialogDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogDeleteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        searchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchListLayout = new javax.swing.GroupLayout(jPanelSearchList);
        jPanelSearchList.setLayout(jPanelSearchListLayout);
        jPanelSearchListLayout.setHorizontalGroup(
            jPanelSearchListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchList, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        jPanelSearchListLayout.setVerticalGroup(
            jPanelSearchListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchList, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );

        menu.setFocusable(false);

        jPanelBill.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 15));
        jPanel24.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Kicks Corner");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Bill");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Bill ID:");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Date time:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Customer: ");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setText("Phone: 0898691801");
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13))
                .addContainerGap())
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addContainerGap(112, Short.MAX_VALUE)))
        );

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 15));
        jPanel37.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Subtotal:");
        jLabel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("Point used:");
        jLabel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 153, 153));
        jLabel32.setText("Total:");
        jLabel32.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel33.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setText("Cash: ");
        jLabel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jLabel36.setText("Change:");
        jLabel36.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 1, 0, 0));

        jLabelSubtotalBlock.setText("jLabel12");

        jLabelPointBlock.setText("jLabel12");

        jLabelTotalBlock.setText("jLabel12");

        jLabelCashBlock.setText("jLabel12");

        jLabelChangeBlock.setText("jLabel12");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSubtotalBlock))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPointBlock))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotalBlock))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCashBlock))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelChangeBlock)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubtotalBlock)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPointBlock)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalBlock)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCashBlock)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChangeBlock)
                    .addComponent(jLabel36))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelBody.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBody.setForeground(new java.awt.Color(0, 0, 0));

        invoiceModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Product ID", "Name", "Size", "Quantity", "Price","Discount", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }

            public boolean isCellEditable(int row, int column) {
                return row == editableRowOrder && column == 4; // Chỉ cho cột Quantity có thể chỉnh sửa
            }

        };
        jTableInvoice.setBackground(new java.awt.Color(255, 255, 255));
        jTableInvoice.setForeground(new java.awt.Color(0, 0, 0));
        jTableInvoice.setModel(invoiceModel);
        jTableInvoice.setFont(new java.awt.Font("SansSerif", 0, 8)); // NOI18N
        JTableHeader headerInvoice = jTableInvoice.getTableHeader();
        jTableInvoice.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerInvoice.setDefaultRenderer(new CustomCellNoRenderer());

        jTableInvoice.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableInvoice.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableInvoice.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableInvoice.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableInvoice.getColumnModel().getColumn(1).setMinWidth(0);
        jTableInvoice.getColumnModel().getColumn(1).setMaxWidth(0);

        jTableInvoice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableInvoice.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableInvoice.getSelectedRow();

                    if (selectedRow != -1) {
                        selectedID = jTableInvoice.getValueAt(selectedRow, 1);
                        System.out.println("Selected ID: " +selectedID);
                    }
                }
            }
        });

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBodyLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jTableInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTableInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelBillLayout = new javax.swing.GroupLayout(jPanelBill);
        jPanelBill.setLayout(jPanelBillLayout);
        jPanelBillLayout.setHorizontalGroup(
            jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelBillLayout.createSequentialGroup()
                .addGroup(jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBillLayout.setVerticalGroup(
            jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBillLayout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 622));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 1, 1));

        jButtonInventory.setBackground(new java.awt.Color(242, 242, 242));
        jButtonInventory.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonInventory.setText("Inventory");
        jButtonInventory.setBorder(null);
        jButtonInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventoryActionPerformed(evt);
            }
        });

        jButtonOrder.setBackground(new java.awt.Color(242, 242, 242));
        jButtonOrder.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonOrder.setText("Order");
        jButtonOrder.setBorder(null);
        jButtonOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrderActionPerformed(evt);
            }
        });

        jButtonMembership.setBackground(new java.awt.Color(242, 242, 242));
        jButtonMembership.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonMembership.setText("Membership");
        jButtonMembership.setBorder(null);
        jButtonMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMembershipActionPerformed(evt);
            }
        });

        jButtonDashboard.setBackground(new java.awt.Color(242, 242, 242));
        jButtonDashboard.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonDashboard.setText("Dashboard");
        jButtonDashboard.setBorder(null);
        jButtonDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDashboardActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Open");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Management");

        jButtonEmployee.setBackground(new java.awt.Color(242, 242, 242));
        jButtonEmployee.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonEmployee.setText("Employee");
        jButtonEmployee.setBorder(null);
        jButtonEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmployeeActionPerformed(evt);
            }
        });

        jButtonProduct.setBackground(new java.awt.Color(242, 242, 242));
        jButtonProduct.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonProduct.setText("Product");
        jButtonProduct.setBorder(null);
        jButtonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductActionPerformed(evt);
            }
        });

        jButtonRole.setBackground(new java.awt.Color(242, 242, 242));
        jButtonRole.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jButtonRole.setText("Role");
        jButtonRole.setBorder(null);
        jButtonRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMembership, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jButtonEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRole, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel1.setText("Kicks Corner");

        jLabelEmployeeName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabelEmployeeName.setText("username");

        jButtonLogOut.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelEmployeeName)
                .addGap(113, 113, 113)
                .addComponent(jButtonLogOut)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogOut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCardLayout.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCardLayout.setLayout(new java.awt.CardLayout());
        jPanelCardLayout.add(jPanelMembership);
        jPanelCardLayout.add(jPanelOrder);

        jPanelOrder.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldProductIDOrder.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTextFieldProductIDOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductIDOrderActionPerformed(evt);
            }
        });

        jLabelNamePhone.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        orderModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Product ID", "Name", "Size", "Quantity", "Price","Discount", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }

            public boolean isCellEditable(int row, int column) {
                return row == editableRowOrder && column == 4; // Chỉ cho cột Quantity có thể chỉnh sửa
            }

        };
        orderModel.addTableModelListener(new TableModelListener() {
            int quantity;
            double price;
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    for (int i = 0; i < orderModel.getRowCount(); i++) {
                        orderModel.setValueAt(i + 1, i, 0); // Cập nhật lại số thứ tự
                    }
                } else if (e.getType() == TableModelEvent.UPDATE) { // Kiểm tra sự kiện là sửa đổi dòng
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 4) { // Kiểm tra cột số lượng đã thay đổi
                        // Lấy số lượng mới từ bảng
                        Object quantityObj = orderModel.getValueAt(row, 4);

                        if (quantityObj instanceof String) {
                            quantity = Integer.parseInt((String) quantityObj);
                        } else {

                        }
                        // Lấy giá tiền từ cột Price
                        Object priceObj = orderModel.getValueAt(row, 5);

                        if (priceObj instanceof Double) {
                            price = (Double) priceObj;
                        } else {

                        }
                        // Tính toán lại amount
                        double amount = quantity * price;
                        // Cập nhật giá trị mới vào cột Amount trong bảng
                        orderModel.setValueAt(amount, row, 7);
                    }
                }

                // Tính toán lại tổng số tiền sau khi thay đổi
                Double totalAmount = 0.0;
                for (int row = 0; row < orderModel.getRowCount(); row++) {
                    Object amountObj = orderModel.getValueAt(row, 7); // Lấy giá trị ở cột Amount
                    if (amountObj instanceof Double) {
                        Double amount = (Double) amountObj;
                        totalAmount += amount; // Thực hiện phép cộng với Double
                    }
                }

                // Cập nhật giá trị của Label hiển thị tổng số tiền
                jLabelTotalOrderTable.setText("Total: " + String.valueOf(totalAmount));
                jLabelSubTotal.setText(String.valueOf(totalAmount));

            }
        });
        jTableOrder.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        JTableHeader headerOrder = jTableOrder.getTableHeader();
        jTableOrder.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerOrder.setDefaultRenderer(new CustomCellNoRenderer());
        jTableOrder.setModel(orderModel);
        jTableOrder.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableOrder.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableOrder.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableOrder.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableOrder.getColumnModel().getColumn(1).setMinWidth(0);
        jTableOrder.getColumnModel().getColumn(1).setMaxWidth(0);
        int productIDOrderColumnIndex = 1;
        jTableOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableOrder.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableOrder.getSelectedRow();

                    if (selectedRow != -1) {
                        selectedID = jTableOrder.getValueAt(selectedRow, productIDOrderColumnIndex);
                        System.out.println("Selected ID: " +selectedID);
                    }
                }
            }
        });
        jTableOrder.setRowHeight(30);
        jScrollPane2.setViewportView(jTableOrder);

        jButtonAddProductOrder.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddProductOrder.setText(" Add Product");
        jButtonAddProductOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddProductOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductOrderActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Order");

        jLabelChange.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelChange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelChange.setText("0");
        jLabelChange.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 7)));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel20.setText("Subtotal");

        jLabelUsingPoint.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabelUsingPoint.setText("Using point");

        jTextFieldUsingPoint.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTextFieldUsingPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldUsingPoint.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5)));
        jTextFieldUsingPoint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsingPointFocusLost(evt);
            }
        });
        jTextFieldUsingPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsingPointActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel14.setText("Change");

        jLabelSubTotal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabelSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSubTotal.setText("0");
        jLabelSubTotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 7)));

        jLabelTotalText.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelTotalText.setText("Total");

        jLabelTotalInvoice.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelTotalInvoice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalInvoice.setText("0");
        jLabelTotalInvoice.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 7)));

        jButtonConfirmOrder.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonConfirmOrder.setText("Confirm");
        jButtonConfirmOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmOrderActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel15.setText("Cash");

        jTextFieldCash.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jTextFieldCash.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldCash.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5)));
        jTextFieldCash.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCashFocusLost(evt);
            }
        });
        jTextFieldCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelUsingPoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsingPoint, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelSubTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelTotalInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTotalText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelChange, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jButtonConfirmOrder)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCash, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelTotalInvoice, jTextFieldCash});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelSubTotal, jTextFieldUsingPoint});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUsingPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsingPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelChange, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabelChange, jLabelSubTotal, jLabelTotalInvoice, jTextFieldCash, jTextFieldUsingPoint});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel14, jLabel20});

        jLabelChange.getAccessibleContext().setAccessibleDescription("");

        jLabelTotalOrderTable.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelTotalOrderTable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalOrderTable.setText("Total: 0");
        jLabelTotalOrderTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("Product ID");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 0));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jButtonEditOrder.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditOrder.setText("Edit");
        jButtonEditOrder.setPreferredSize(new java.awt.Dimension(76, 38));
        jButtonEditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditOrderActionPerformed(evt);
            }
        });
        jPanel22.add(jButtonEditOrder);

        jButton7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton7.setText("Delete");
        jButton7.setPreferredSize(new java.awt.Dimension(76, 38));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton7);

        jTextFieldSizeIDOrder.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextFieldSizeIDOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSizeIDOrderActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel30.setText("Size ID");
        jLabel30.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 4, 0, 0));

        jLabel31.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel31.setText("Phone");

        jTextFieldPhoneOrder.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextFieldPhoneOrder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPhoneOrderFocusLost(evt);
            }
        });
        jTextFieldPhoneOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrderLayout = new javax.swing.GroupLayout(jPanelOrder);
        jPanelOrder.setLayout(jPanelOrderLayout);
        jPanelOrderLayout.setHorizontalGroup(
            jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldPhoneOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                        .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelTotalOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelOrderLayout.createSequentialGroup()
                                        .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldProductIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel30)
                                                    .addComponent(jTextFieldSizeIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonAddProductOrder))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(538, 538, 538)))
                        .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addComponent(jLabelNamePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelOrderLayout.setVerticalGroup(
            jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrderLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelNamePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrderLayout.createSequentialGroup()
                        .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel30))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelOrderLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldProductIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPhoneOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAddProductOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSizeIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrderLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTotalOrderTable)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelCardLayout.add(jPanelOrder, "card4");

        jPanelDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("27");
        jLabel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel23.add(jLabel25, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel23, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setText("Sales |");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setText("Today");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Dashboard");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel34.setText("Customer |");

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("Today");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel20.setLayout(new java.awt.BorderLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel37.setText("27");
        jPanel21.add(jLabel37);

        jPanel20.add(jPanel21, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel20, java.awt.BorderLayout.CENTER);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("27");
        jLabel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel18.add(jLabel26, java.awt.BorderLayout.CENTER);

        jPanel17.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel18.setText("Revenue |");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("Today");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel19, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanelDashboardLayout = new javax.swing.GroupLayout(jPanelDashboard);
        jPanelDashboard.setLayout(jPanelDashboardLayout);
        jPanelDashboardLayout.setHorizontalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDashboardLayout.createSequentialGroup()
                .addGroup(jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDashboardLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDashboardLayout.setVerticalGroup(
            jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDashboardLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        jPanelCardLayout.add(jPanelDashboard, "card6");

        jPanelMembership.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Membership");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        membershipModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Customer ID", "Customer Name", "Phone", "Point"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            //    public void setValueAt(Object aValue, int row, int column) {
                //       if (column == 0) { // Chỉ cập nhật lại số thứ tự cho cột STT
                    //        super.setValueAt(aValue, row, column);
                    //        // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    //        for (int i = 0; i < getRowCount(); i++) {
                        //            setValueAt(i + 1, i, 0); // Cột STT (index 0)
                        //        }
                    //    } else {
                    //        super.setValueAt(aValue, row, column);
                    //    }
                //    }
            public void setValueAt(Object aValue, int row, int column) {
                // Gọi phương thức của lớp cha để thực hiện việc cập nhật dữ liệu
                super.setValueAt(aValue, row, column);
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }

            public boolean isCellEditable(int row, int column) {
                return row == editableRow && column != 0;
            }

        };
        membershipModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                // Kiểm tra xem có thay đổi trong dữ liệu không
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    for (int i = 0; i < membershipModel.getRowCount(); i++) {
                        membershipModel.setValueAt(i + 1, i, 0); // Cột STT (index 0)
                    }
                }
            }
        });
        jTableMembership.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jTableMembership.setFont(new java.awt.Font("SansSerif", 0, 16));
        JTableHeader headerMembership = jTableMembership.getTableHeader();
        jTableMembership.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerMembership.setDefaultRenderer(new CustomCellNoRenderer());
        jTableMembership.setModel(membershipModel);
        int customerIDColumnIndex = 1;
        jTableMembership.getColumnModel().getColumn(1).setMinWidth(0);
        jTableMembership.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableMembership.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableMembership.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableMembership.getSelectedRow();

                    if (selectedRow != -1) {
                        // Assuming customerID is in the first column (column index 0)
                        selectedID = jTableMembership.getValueAt(selectedRow, customerIDColumnIndex);
                        System.out.println("Selected Customer ID: " + selectedID);
                    }
                }
            }
        });
        jTableMembership.setRowHeight(30);
        jTableMembership.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMembershipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMembership);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddMembership.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddMembership.setText("Add");
        jButtonAddMembership.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonAddMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMembershipActionPerformed(evt);
            }
        });

        jButtonDeleteMembership.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonDeleteMembership.setText("Delete");
        jButtonDeleteMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteMembershipActionPerformed(evt);
            }
        });

        jButtonEditMembership.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditMembership.setText("Edit");
        jButtonEditMembership.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonEditMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditMembershipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonAddMembership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditMembership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteMembership)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel15.add(jPanel16);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 294, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton14.setText("Export Excel");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton16.setText("Print");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jTextFieldSearchMembership.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchMembership.setText("Enter Customer ID");
        jTextFieldSearchMembership.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchMembershipFocusGained(evt);
            }
        });
        jTextFieldSearchMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchMembershipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jTextFieldSearchMembership, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearchMembership))
                        .addGap(7, 7, 7))))
        );

        javax.swing.GroupLayout jPanelMembershipLayout = new javax.swing.GroupLayout(jPanelMembership);
        jPanelMembership.setLayout(jPanelMembershipLayout);
        jPanelMembershipLayout.setHorizontalGroup(
            jPanelMembershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMembershipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMembershipLayout.setVerticalGroup(
            jPanelMembershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMembershipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelCardLayout.add(jPanelMembership, "card3");

        jPanelInventory.setBackground(new java.awt.Color(255, 255, 255));

        inventoryModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Product ID", "Product Name", "Size ID", "Price", "Amount", "Discount(%)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };

            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }

            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int row, int column) {
                return row == editableRowInventory && column != 0;
            }
        };
        inventoryModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                // Kiểm tra xem có thay đổi trong dữ liệu không
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    for (int i = 0; i < inventoryModel.getRowCount(); i++) {
                        inventoryModel.setValueAt(i + 1, i, 0); // Cột STT (index 0)
                    }
                }
            }
        });
        jTableInventory.setFont(new java.awt.Font("SansSerif", 0, 16));
        JTableHeader headerInventory = jTableInventory.getTableHeader();
        jTableInventory.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerInventory.setDefaultRenderer(new CustomCellNoRenderer());
        jTableInventory.setModel(inventoryModel);
        jTableInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableInventory.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableInventory.getSelectedRow();

                    if (selectedRow != -1) {
                        // Assuming customerID is in the first column (column index 0)
                        selectedID = jTableInventory.getValueAt(selectedRow, 1);
                        System.out.println("Selected ID: " +selectedID);
                    }
                }
            }
        });
        jTableInventory.setRowHeight(30);
        jScrollPane3.setViewportView(jTableInventory);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton9.setText("Export Excel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextFieldSearchInventory.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchInventory.setText("Enter Product ID");
        jTextFieldSearchInventory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchInventoryFocusGained(evt);
            }
        });
        jTextFieldSearchInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jTextFieldSearchInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearchInventory))
                        .addGap(7, 7, 7))))
        );

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Inventory");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddInventory.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddInventory.setText("Add");
        jButtonAddInventory.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonAddInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInventoryActionPerformed(evt);
            }
        });

        jButtonDeleteInventory.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonDeleteInventory.setText("Delete");
        jButtonDeleteInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteInventoryActionPerformed(evt);
            }
        });

        jButtonEditInventory.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditInventory.setText("Edit");
        jButtonEditInventory.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonEditInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonAddInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteInventory)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel13.add(jPanel14);

        javax.swing.GroupLayout jPanelInventoryLayout = new javax.swing.GroupLayout(jPanelInventory);
        jPanelInventory.setLayout(jPanelInventoryLayout);
        jPanelInventoryLayout.setHorizontalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInventoryLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanelInventoryLayout.setVerticalGroup(
            jPanelInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        jPanelCardLayout.add(jPanelInventory, "card5");

        jPanelEmployeeBlock.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Employee");

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jButton26.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton26.setText("Export Excel");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton28.setText("Print");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jTextFieldSearchEmployee.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchEmployee.setText("Enter Employee ID");
        jTextFieldSearchEmployee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchEmployeeFocusGained(evt);
            }
        });
        jTextFieldSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton26)
                .addGap(18, 18, 18)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jTextFieldSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldSearchEmployee))
                .addGap(7, 7, 7))
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(274, 64));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddEmployee.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddEmployee.setText("Add");
        jButtonAddEmployee.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEmployeeActionPerformed(evt);
            }
        });

        jButtonDeleteEmployee.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonDeleteEmployee.setText("Delete");
        jButtonDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteEmployeeActionPerformed(evt);
            }
        });

        jButtonEditEmployee.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditEmployee.setText("Edit");
        jButtonEditEmployee.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonEditEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteEmployee)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel25.add(jPanel26);

        employeeModel = new DefaultTableModel(
            null,
            new String [] {
                "No.","Employee ID", "Employee Name", "Role", "Phone"
            }
        ){
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class; // Cột số thứ tự là kiểu số nguyên
                }
                return super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int row, int column) {
                return row == editableRowEmployee && column != 0;
            }
        };
        employeeModel.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                // Kiểm tra xem có thay đổi trong dữ liệu không
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    for (int i = 0; i < employeeModel.getRowCount(); i++) {
                        employeeModel.setValueAt(i + 1, i, 0); // Cột STT (index 0)
                    }
                }
            }
        });
        jTableEmployee.setFont(new java.awt.Font("SansSerif", 0, 16));
        jTableEmployee.setModel(employeeModel);
        JTableHeader headerEmployee = jTableEmployee.getTableHeader();
        jTableEmployee.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerEmployee.setDefaultRenderer(new CustomCellNoRenderer());
        int employeeIDColumnIndex = 1;
        jTableEmployee.getColumnModel().getColumn(1).setMinWidth(0);
        jTableEmployee.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableEmployee.getSelectedRow();

                    if (selectedRow != -1) {
                        // Assuming customerID is in the first column (column index 0)
                        selectedID = jTableEmployee.getValueAt(selectedRow, employeeIDColumnIndex);
                    }
                }
            }
        });
        jTableEmployee.setRowHeight(30);
        jScrollPane7.setViewportView(jTableEmployee);

        javax.swing.GroupLayout jPanelEmployeeBlockLayout = new javax.swing.GroupLayout(jPanelEmployeeBlock);
        jPanelEmployeeBlock.setLayout(jPanelEmployeeBlockLayout);
        jPanelEmployeeBlockLayout.setHorizontalGroup(
            jPanelEmployeeBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelEmployeeBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmployeeBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeeBlockLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmployeeBlockLayout.createSequentialGroup()
                        .addGroup(jPanelEmployeeBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane7))
                        .addContainerGap())))
        );
        jPanelEmployeeBlockLayout.setVerticalGroup(
            jPanelEmployeeBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeeBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelEmployeeLayout = new javax.swing.GroupLayout(jPanelEmployee);
        jPanelEmployee.setLayout(jPanelEmployeeLayout);
        jPanelEmployeeLayout.setHorizontalGroup(
            jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEmployeeBlock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelEmployeeLayout.setVerticalGroup(
            jPanelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEmployeeBlock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelCardLayout.add(jPanelEmployee, "card7");

        jPanelProductBlock.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductBlock.setPreferredSize(new java.awt.Dimension(810, 557));

        productModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Product ID", "Product Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int row, int column) {
                return row == editableRowProduct && column != 0;
            }
        };
        productModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                // Kiểm tra xem có thay đổi trong dữ liệu không
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    for (int i = 0; i < productModel.getRowCount(); i++) {
                        productModel.setValueAt(i + 1, i, 0); // Cột STT (index 0)
                    }
                }
            }
        });
        jTableProduct.setFont(new java.awt.Font("SansSerif", 0, 16));
        int productIDColumnIndex = 1;
        JTableHeader headerMemProduct = jTableProduct.getTableHeader();
        jTableProduct.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerMemProduct.setDefaultRenderer(new CustomCellNoRenderer());
        jTableProduct.setModel(productModel);
        jTableProduct.getColumnModel().getColumn(1).setMinWidth(0);
        jTableProduct.getColumnModel().getColumn(1).setMaxWidth(0);
        jTableProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableProduct.getSelectedRow();

                    if (selectedRow != -1) {
                        // Assuming customerID is in the first column (column index 0)
                        selectedID = jTableProduct.getValueAt(selectedRow, productIDColumnIndex);
                        System.out.println("Selected Customer ID: " + selectedID);
                    }
                }
            }
        });
        jTableProduct.setRowHeight(30);
        jScrollPane5.setViewportView(jTableProduct);

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jButtonExportExcelProduct.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonExportExcelProduct.setText("Export Excel");
        jButtonExportExcelProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportExcelProductActionPerformed(evt);
            }
        });

        jButtonPrintProduct.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonPrintProduct.setText("Print");
        jButtonPrintProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintProductActionPerformed(evt);
            }
        });

        jTextFieldSearchProduct.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearchProduct.setText("Enter Product ID");
        jTextFieldSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchProductFocusGained(evt);
            }
        });
        jTextFieldSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonExportExcelProduct)
                .addGap(18, 18, 18)
                .addComponent(jButtonPrintProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jTextFieldSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSearchProduct)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExportExcelProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPrintProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Product");

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddNewProduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddNewProduct.setText("Add");
        jButtonAddNewProduct.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonAddNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewProductActionPerformed(evt);
            }
        });

        jButtonDeleteProduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonDeleteProduct.setText("Delete");
        jButtonDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteProductActionPerformed(evt);
            }
        });

        jButtonEditProduct.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditProduct.setText("Edit");
        jButtonEditProduct.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonAddNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteProduct)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel32.add(jPanel33);

        javax.swing.GroupLayout jPanelProductBlockLayout = new javax.swing.GroupLayout(jPanelProductBlock);
        jPanelProductBlock.setLayout(jPanelProductBlockLayout);
        jPanelProductBlockLayout.setHorizontalGroup(
            jPanelProductBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelProductBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProductBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanelProductBlockLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelProductBlockLayout.setVerticalGroup(
            jPanelProductBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelProductLayout = new javax.swing.GroupLayout(jPanelProduct);
        jPanelProduct.setLayout(jPanelProductLayout);
        jPanelProductLayout.setHorizontalGroup(
            jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductBlock, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
        );
        jPanelProductLayout.setVerticalGroup(
            jPanelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductBlock, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );

        jPanelCardLayout.add(jPanelProduct, "card8");

        jPanelRoleBlock.setBackground(new java.awt.Color(255, 255, 255));

        roleModel = new DefaultTableModel(
            null,
            new String [] {
                "No.", "Role ID", "Role Name", "Permission"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column);
            }

            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int row, int column) {
                return row == editableRowRole && column != 0;
            }
        };
        roleModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                // Kiểm tra xem có thay đổi trong dữ liệu không
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    // Cập nhật lại số thứ tự cho các hàng sau mỗi lần thay đổi dữ liệu
                    for (int i = 0; i < roleModel.getRowCount(); i++) {
                        roleModel.setValueAt(i + 1, i, 0); // Cột STT (index 0)
                    }
                }
            }
        });
        jTableRole.setFont(new java.awt.Font("SansSerif", 0, 16));
        jTableRole.setModel(roleModel);
        JTableHeader headerRole = jTableRole.getTableHeader();
        jTableRole.setDefaultRenderer(Object.class, new CustomCellNoRenderer());
        headerRole.setDefaultRenderer(new CustomCellNoRenderer());
        int roleIDColumnIndex = 1;
        jTableRole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableRole.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTableRole.getSelectedRow();

                    if (selectedRow != -1) {
                        // Assuming customerID is in the first column (column index 0)
                        selectedID = jTableRole.getValueAt(selectedRow, roleIDColumnIndex);
                    }
                }
            }
        });
        jTableRole.setRowHeight(30);
        jTableRole.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTableRoleFocusLost(evt);
            }
        });
        jScrollPane6.setViewportView(jTableRole);

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jButton17.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton17.setText("Export Excel");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton21.setText("Print");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addGap(703, 703, 703))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Role");

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAddRole.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonAddRole.setText("Add");
        jButtonAddRole.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonAddRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRoleActionPerformed(evt);
            }
        });

        jButtonDeleteRole.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonDeleteRole.setText("Delete");
        jButtonDeleteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRoleActionPerformed(evt);
            }
        });

        jButtonEditRole.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButtonEditRole.setText("Edit");
        jButtonEditRole.setPreferredSize(new java.awt.Dimension(72, 23));
        jButtonEditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditRoleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDeleteRole)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel35.add(jPanel36);

        javax.swing.GroupLayout jPanelRoleBlockLayout = new javax.swing.GroupLayout(jPanelRoleBlock);
        jPanelRoleBlock.setLayout(jPanelRoleBlockLayout);
        jPanelRoleBlockLayout.setHorizontalGroup(
            jPanelRoleBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRoleBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoleBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelRoleBlockLayout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanelRoleBlockLayout.setVerticalGroup(
            jPanelRoleBlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoleBlockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelRoleLayout = new javax.swing.GroupLayout(jPanelRole);
        jPanelRole.setLayout(jPanelRoleLayout);
        jPanelRoleLayout.setHorizontalGroup(
            jPanelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
            .addGroup(jPanelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelRoleBlock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRoleLayout.setVerticalGroup(
            jPanelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(jPanelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRoleLayout.createSequentialGroup()
                    .addComponent(jPanelRoleBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelCardLayout.add(jPanelRole, "card9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelCardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCardLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventoryActionPerformed
        cardLayout.show(jPanelCardLayout, "card5");
        currentTable = jTableInventory;
        currentModel = inventoryModel;
        currentTextField = jTextFieldSearchInventory;
        deleteFunction = KicksCornerDelete::deleteInventory;
        search(currentTextField, currentModel, currentTable);
    }//GEN-LAST:event_jButtonInventoryActionPerformed

    private void jButtonOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrderActionPerformed

        cardLayout.show(jPanelCardLayout, "card4");
    }//GEN-LAST:event_jButtonOrderActionPerformed

    private void jButtonDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDashboardActionPerformed
        cardLayout.show(jPanelCardLayout, "card6");
    }//GEN-LAST:event_jButtonDashboardActionPerformed

    private void jButtonMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMembershipActionPerformed
        cardLayout.show(jPanelCardLayout, "card3");
        currentTable = jTableMembership;
        currentModel = membershipModel;
        currentTextField = jTextFieldSearchMembership;
        deleteFunction = KicksCornerDelete::deleteMembership;
        search(jTextFieldSearchMembership, currentModel, currentTable);
    }//GEN-LAST:event_jButtonMembershipActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Log Out Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            // Perform logout actions here
            KicksCorner.this.dispose(); // Assuming this disposes the current window
        }
        Login login = new Login();
        login.setVisible(true);

    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButtonAddInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInventoryActionPerformed
        inventoryModel.addRow(new Object[]{"", "", "", "", "", "", ""});
        selectedRow = jTableInventory.getRowCount() - 1;
        if (selectedRow != -1) {
            editableRowInventory = selectedRow;
        }
        ProductIDListener listener = new InventoryEditor();
//        InventoryEditor.addInventory(jTableInventory, selectedRow, listener);
        CompletableFuture<Integer> future = InventoryEditor.addInventory(jTableInventory, selectedRow, listener);
        future.thenAccept(productID -> {

            KicksCornerShow1.showProduct(inventoryModel, selectedRow, productID);
        });
        ListenTableChanged.addInventory(jTableInventory);
    }//GEN-LAST:event_jButtonAddInventoryActionPerformed

    private void jButtonDeleteInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteInventoryActionPerformed
        jDialogDelete.setVisible(true);
    }//GEN-LAST:event_jButtonDeleteInventoryActionPerformed

    private void jButtonEditInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditInventoryActionPerformed
        selectedRow = jTableInventory.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableInventory.convertRowIndexToModel(selectedRow);
            editableRowInventory = modelRow;
        }
        ListenTableChanged.editInventory(jTableInventory, inventoryModel);

    }//GEN-LAST:event_jButtonEditInventoryActionPerformed

    private void jButtonEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmployeeActionPerformed
        cardLayout.show(jPanelCardLayout, "card7");
        currentTable = jTableEmployee;
        currentModel = employeeModel;
        currentTextField = jTextFieldSearchEmployee;
        deleteFunction = KicksCornerDelete::deleteEmployee;
        search(jTextFieldSearchEmployee, employeeModel, jTableEmployee);
    }//GEN-LAST:event_jButtonEmployeeActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jTableMembershipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMembershipMouseClicked

    }//GEN-LAST:event_jTableMembershipMouseClicked

    private void jButtonYesDeleteMemberShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYesDeleteMemberShipActionPerformed
        onYes(currentTable, currentModel, deleteFunction);
        jDialogDelete.dispose();
        System.out.println("Deleted");
    }//GEN-LAST:event_jButtonYesDeleteMemberShipActionPerformed

    private void jButtonNoDeleteMemberShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoDeleteMemberShipActionPerformed
        jDialogDelete.dispose();
    }//GEN-LAST:event_jButtonNoDeleteMemberShipActionPerformed

    private void jButtonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductActionPerformed
        cardLayout.show(jPanelCardLayout, "card8");
        currentTitle = jButtonProduct.getText();
        currentTable = jTableProduct;
        currentModel = productModel;
        currentTextField = jTextFieldSearchProduct;
        deleteFunction = KicksCornerDelete::deleteProduct;
        search(currentTextField, currentModel, currentTable);
    }//GEN-LAST:event_jButtonProductActionPerformed

    private void jButtonExportExcelProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportExcelProductActionPerformed
        KicksCorner kicksCorner = new KicksCorner();
        ExportToExcel.clickExport(kicksCorner, jTableProduct);

    }//GEN-LAST:event_jButtonExportExcelProductActionPerformed

    private void jButtonPrintProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintProductActionPerformed
        PDFGenerator.generatePDF(jTableProduct, currentTitle);

    }//GEN-LAST:event_jButtonPrintProductActionPerformed

    private void jButtonAddNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewProductActionPerformed
        KicksCornerCreate.createNewRowProduct();

        KicksCornerShow1.showNewRowProduct(productModel);
        selectedRow = jTableProduct.getRowCount() - 1;
        if (selectedRow != -1) {
            editableRowProduct = selectedRow;
        }
        ListenTableChanged.addProduct(jTableProduct);
    }//GEN-LAST:event_jButtonAddNewProductActionPerformed

    private void jButtonDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteProductActionPerformed
        jDialogDelete.setVisible(true);
    }//GEN-LAST:event_jButtonDeleteProductActionPerformed

    private void jButtonEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditProductActionPerformed
        selectedRow = jTableProduct.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableProduct.convertRowIndexToModel(selectedRow);
            editableRowProduct = modelRow;
        }
        ListenTableChanged.editProduct(jTableProduct);
    }//GEN-LAST:event_jButtonEditProductActionPerformed

    private void jButtonRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoleActionPerformed
        cardLayout.show(jPanelCardLayout, "card9");
    }//GEN-LAST:event_jButtonRoleActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButtonAddRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRoleActionPerformed
        roleModel.addRow(new Object[]{"", "", "", ""});
        selectedRow = jTableRole.getRowCount() - 1;
        if (selectedRow != -1) {
            editableRowRole = selectedRow;
             jTableRole.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField()));
        }
        ListenTableChanged.addRole(jTableRole);
    }//GEN-LAST:event_jButtonAddRoleActionPerformed

    private void jButtonDeleteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteRoleActionPerformed

    private void jButtonEditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditRoleActionPerformed
          selectedRow = jTableRole.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableRole.convertRowIndexToModel(selectedRow);
            editableRowRole = modelRow;
            jTableRole.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(EventObject e) {
                return false; // Khi click edit, cột 1 sẽ không thể chỉnh sửa
            }
        });
        }
        ListenTableChanged.editRole(jTableRole);
    }//GEN-LAST:event_jButtonEditRoleActionPerformed

    private void jButtonEditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditOrderActionPerformed
        selectedRow = jTableOrder.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableOrder.convertRowIndexToModel(selectedRow);
            editableRowOrder = modelRow;
        }
//        ListenTableChanged.editProduct(jTableProduct);
    }//GEN-LAST:event_jButtonEditOrderActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCashActionPerformed
        KicksCorner.this.requestFocus();
    }//GEN-LAST:event_jTextFieldCashActionPerformed

    private void jButtonConfirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmOrderActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to confirm the order?", "Confirm Order", JOptionPane.YES_NO_OPTION);
        Object[][] data = GetData.getOrderTable(jTableOrder, orderModel);
        String[] title = {"Name", "S.", "Q.", "Price", "Discount", "Amount"};
        String phone = null;
        if (!jTextFieldPhoneOrder.getText().equals("")) {
            phone = jTextFieldPhoneOrder.getText();
        }
        if (dialogResult == JOptionPane.YES_OPTION) {
            int customerID = GetData.getCustomerID(jTextFieldPhoneOrder);
            int employeeID = employee.getEmployeeID();

            Object[] invoiceInfo = GetData.getInvoiceInfo(jTextFieldProductIDOrder, jTextFieldSizeIDOrder, jTextFieldPhoneOrder, jTextFieldUsingPoint, jTextFieldCash, jLabelSubTotal, jLabelTotalInvoice, jLabelChange, jLabelEmployeeName);
            LocalDateTime time = LocalDateTime.now();
            String employeeName = employee.getEmployeeName();
            System.out.println("Employee: " + employee.getEmployeeName());
            String orderID = generateOrderID();
            boolean isUsed = true;
            while (isUsed) {
                orderID = generateOrderID();
                isUsed = GetData.isOrderIDUsed(orderID);
            }
            Order order = new Order(orderID, customerID, employeeID, time);
            KicksCornerInsert.insertOrder(order);
            String customerName = GetData.getCustomerName(jTextFieldPhoneOrder);
            int pointUsed = Integer.parseInt(jTextFieldUsingPoint.getText());
            double total = Double.parseDouble(jLabelTotalInvoice.getText());
            double subTotal = Double.parseDouble(jLabelSubTotal.getText());
            double cash = Double.parseDouble(jTextFieldCash.getText());
            double change = Double.parseDouble(jLabelChange.getText());
            double rewardPoints = total * 0.05;
            int initPoint = GetData.getPoint(phone);
            int currentPoint = initPoint - pointUsed + (int)rewardPoints;
            KicksCornerUpdate.updateMembership(currentPoint, phone);
            membershipModel.setRowCount(0);
            GetData.getMemberShip(membershipModel);
            for (int i = 0; i < data.length; i++) {

                int productID = (int) data[i][0];
                String productName = (String) data[i][1];
                float size = (float) data[i][2];
                int sizeID = GetData.getSizeID(size);
                int quantity = (int) data[i][3];
                double price = (double) data[i][4];
                double discount = (double) data[i][5];
                double amount = (double) data[i][6];

                OrderDetail orderDetail = new OrderDetail(orderID, productID, sizeID, price, quantity);
                KicksCornerInsert.insertOrderDetail(orderDetail);
            }
            PDFGenerator.printPanel(orderID, time, customerName, employeeName, phone, data, title, subTotal, pointUsed, total, cash, change);
            jTextFieldPhoneOrder.setText("");
            jTextFieldProductIDOrder.setText("");
            jTextFieldSizeIDOrder.setText("");
            jTextFieldUsingPoint.setText("");
            jTextFieldCash.setText("");
            jLabelNamePhone.setText("");
            jLabelSubTotal.setText("0.0");
            jLabelTotalInvoice.setText("0.0");
            jLabelChange.setText("0.0");
            orderModel.setRowCount(0);
        } else {
        }

    }//GEN-LAST:event_jButtonConfirmOrderActionPerformed

    private void jTextFieldUsingPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsingPointActionPerformed

        KicksCorner.this.requestFocus();
    }//GEN-LAST:event_jTextFieldUsingPointActionPerformed

    private void jButtonAddProductOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductOrderActionPerformed

        Object[] infoOrder = GetData.getProductByID(jTextFieldProductIDOrder, jTextFieldSizeIDOrder);
        OrderTable newOrder = new OrderTable(infoOrder);
        KicksCornerShow1.showNewRowOrder(orderModel, newOrder);

    }//GEN-LAST:event_jButtonAddProductOrderActionPerformed

    private void jTextFieldProductIDOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProductIDOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProductIDOrderActionPerformed

    private void jTextFieldPhoneOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneOrderActionPerformed
        KicksCorner.this.requestFocus();
    }//GEN-LAST:event_jTextFieldPhoneOrderActionPerformed

    private void jButtonEditEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditEmployeeActionPerformed
        selectedRow = jTableEmployee.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableEmployee.convertRowIndexToModel(selectedRow);
            editableRowEmployee = modelRow;
        }
        ListenTableChanged.editEmployee(jTableEmployee);

    }//GEN-LAST:event_jButtonEditEmployeeActionPerformed

    private void jButtonDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteEmployeeActionPerformed
        jDialogDelete.setVisible(true);
    }//GEN-LAST:event_jButtonDeleteEmployeeActionPerformed

    private void jButtonAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEmployeeActionPerformed
        Register newRegister = new Register();
        newRegister.setVisible(true);
    }//GEN-LAST:event_jButtonAddEmployeeActionPerformed

    private void jButtonAddMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMembershipActionPerformed
        KicksCornerCreate.createNewRowMembership();
        KicksCornerShow1.showNewRowMembership(membershipModel);
        selectedRow = jTableMembership.getRowCount() - 1;
        if (selectedRow != -1) {
            editableRow = selectedRow;
        }

        ListenTableChanged.addMembership(jTableMembership);
    }//GEN-LAST:event_jButtonAddMembershipActionPerformed

    private void jButtonDeleteMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteMembershipActionPerformed
        jDialogDelete.setVisible(true);
    }//GEN-LAST:event_jButtonDeleteMembershipActionPerformed

    private void jButtonEditMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditMembershipActionPerformed
        selectedRow = jTableMembership.getSelectedRow();
        if (selectedRow != -1) {
            int modelRow = jTableMembership.convertRowIndexToModel(selectedRow);
            editableRow = modelRow;
        }
        ListenTableChanged.editMembership(jTableMembership);
    }//GEN-LAST:event_jButtonEditMembershipActionPerformed

    private void jTextFieldSearchMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchMembershipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchMembershipActionPerformed

    private void jTextFieldSearchMembershipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchMembershipFocusGained
        if (jTextFieldSearchMembership.getText().equals("Enter Customer ID")) {
            jTextFieldSearchMembership.setText("");
        }
        jTextFieldSearchMembership.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldSearchMembershipFocusGained

    private void jTextFieldSearchInventoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchInventoryFocusGained
        if (jTextFieldSearchInventory.getText().equals("Enter Product ID")) {
            jTextFieldSearchInventory.setText("");
        }
        jTextFieldSearchInventory.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldSearchInventoryFocusGained

    private void jTextFieldSearchInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchInventoryActionPerformed

    }//GEN-LAST:event_jTextFieldSearchInventoryActionPerformed

    private void jTextFieldSearchEmployeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchEmployeeFocusGained
        if (jTextFieldSearchEmployee.getText().equals("Enter Employee ID")) {
            jTextFieldSearchEmployee.setText("");
        }
        jTextFieldSearchEmployee.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldSearchEmployeeFocusGained

    private void jTextFieldSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchEmployeeActionPerformed

    private void jTextFieldSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductFocusGained
        if (jTextFieldSearchProduct.getText().equals("Enter Product ID")) {
            jTextFieldSearchProduct.setText("");
        }
        jTextFieldSearchProduct.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldSearchProductFocusGained

    private void jTextFieldSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchProductActionPerformed

    private void jTextFieldSizeIDOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSizeIDOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSizeIDOrderActionPerformed

    private void jTextFieldPhoneOrderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPhoneOrderFocusLost
        String phone = jTextFieldPhoneOrder.getText().trim();
        if (!phone.isEmpty()) {
            if (phone.matches("^0[0-9]{9}$")) {
                KicksCornerShow1.showPoint(phone, jLabelNamePhone);
                customerPoint = GetData.getPoint(phone);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid phone number starting with 0 and containing only digits (10 digits in total).", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextFieldPhoneOrderFocusLost

    private void searchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListActionPerformed

    private void jTextFieldUsingPointFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsingPointFocusLost
        String stringPoint = jTextFieldUsingPoint.getText();
        try {
            // Chuyển đổi giá trị thành kiểu int
            int value = Integer.parseInt(stringPoint);

            // So sánh giá trị
            if (value <= customerPoint) {
                double subTotal = Double.parseDouble(jLabelSubTotal.getText());
                double usingPoint = Double.parseDouble(jTextFieldUsingPoint.getText());
                double invoiceValue = subTotal - usingPoint;
                jLabelTotalInvoice.setText(String.valueOf(invoiceValue));

            } else {
                JOptionPane.showMessageDialog(this, "The value is invalid. Please enter a value less than or equal to " + customerPoint, "Error", JOptionPane.ERROR_MESSAGE);

                jTextFieldUsingPoint.setText("");
            }
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Please enter a valid integer value.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jTextFieldUsingPointFocusLost

    private void jTextFieldCashFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCashFocusLost

        try {
            double cash = Double.parseDouble(jTextFieldCash.getText());
            double totalInvoice = Double.parseDouble(jLabelTotalInvoice.getText());

            if (cash < totalInvoice) {
                // Hiển thị thông báo lỗi nếu cash nhỏ hơn totalInvoice
                JOptionPane.showMessageDialog(this, "Cash must be equal or greater than total invoice.", "Error", JOptionPane.ERROR_MESSAGE);

                // Xóa giá trị khỏi jTextFieldCash (tùy chọn)
                jTextFieldCash.setText("");
            } else {
                double change = cash - totalInvoice;
                jLabelChange.setText(String.valueOf(change));
            }
        } catch (NumberFormatException ex) {
            // Xử lý nếu không thể chuyển đổi thành số
            JOptionPane.showMessageDialog(this, "Please enter a valid number for cash.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextFieldCashFocusLost

    private void jTableRoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTableRoleFocusLost
        
    }//GEN-LAST:event_jTableRoleFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KicksCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KicksCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KicksCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KicksCorner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KicksCorner().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAddEmployee;
    private javax.swing.JButton jButtonAddInventory;
    private javax.swing.JButton jButtonAddMembership;
    private javax.swing.JButton jButtonAddNewProduct;
    private javax.swing.JButton jButtonAddProductOrder;
    private javax.swing.JButton jButtonAddRole;
    private javax.swing.JButton jButtonConfirmOrder;
    private javax.swing.JButton jButtonDashboard;
    private javax.swing.JButton jButtonDeleteEmployee;
    private javax.swing.JButton jButtonDeleteInventory;
    private javax.swing.JButton jButtonDeleteMembership;
    private javax.swing.JButton jButtonDeleteProduct;
    private javax.swing.JButton jButtonDeleteRole;
    private javax.swing.JButton jButtonEditEmployee;
    private javax.swing.JButton jButtonEditInventory;
    private javax.swing.JButton jButtonEditMembership;
    private javax.swing.JButton jButtonEditOrder;
    private javax.swing.JButton jButtonEditProduct;
    private javax.swing.JButton jButtonEditRole;
    private javax.swing.JButton jButtonEmployee;
    private javax.swing.JButton jButtonExportExcelProduct;
    private javax.swing.JButton jButtonInventory;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonMembership;
    private javax.swing.JButton jButtonNoDeleteMemberShip;
    private javax.swing.JButton jButtonOrder;
    private javax.swing.JButton jButtonPrintProduct;
    private javax.swing.JButton jButtonProduct;
    private javax.swing.JButton jButtonRole;
    private javax.swing.JButton jButtonYesDeleteMemberShip;
    private javax.swing.JDialog jDialogDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCashBlock;
    private javax.swing.JLabel jLabelChange;
    private javax.swing.JLabel jLabelChangeBlock;
    private javax.swing.JLabel jLabelEmployeeName;
    private javax.swing.JLabel jLabelNamePhone;
    private javax.swing.JLabel jLabelPointBlock;
    private javax.swing.JLabel jLabelSubTotal;
    private javax.swing.JLabel jLabelSubtotalBlock;
    private javax.swing.JLabel jLabelTotalBlock;
    private javax.swing.JLabel jLabelTotalInvoice;
    private javax.swing.JLabel jLabelTotalOrderTable;
    private javax.swing.JLabel jLabelTotalText;
    private javax.swing.JLabel jLabelUsingPoint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBill;
    private static javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelCardLayout;
    private javax.swing.JPanel jPanelDashboard;
    private javax.swing.JPanel jPanelEmployee;
    private javax.swing.JPanel jPanelEmployeeBlock;
    private javax.swing.JPanel jPanelInventory;
    private javax.swing.JPanel jPanelMembership;
    private javax.swing.JPanel jPanelOrder;
    private javax.swing.JPanel jPanelProduct;
    private javax.swing.JPanel jPanelProductBlock;
    private javax.swing.JPanel jPanelRole;
    private javax.swing.JPanel jPanelRoleBlock;
    private javax.swing.JPanel jPanelSearchList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTable jTableInventory;
    private javax.swing.JTable jTableInvoice;
    private javax.swing.JTable jTableMembership;
    private javax.swing.JTable jTableOrder;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableRole;
    private javax.swing.JTextField jTextFieldCash;
    private javax.swing.JTextField jTextFieldPhoneOrder;
    private javax.swing.JTextField jTextFieldProductIDOrder;
    private static javax.swing.JTextField jTextFieldSearchEmployee;
    private static javax.swing.JTextField jTextFieldSearchInventory;
    private static javax.swing.JTextField jTextFieldSearchMembership;
    private static javax.swing.JTextField jTextFieldSearchProduct;
    private javax.swing.JTextField jTextFieldSizeIDOrder;
    private javax.swing.JTextField jTextFieldUsingPoint;
    private javax.swing.JPopupMenu menu;
    private java.awt.List searchList;
    // End of variables declaration//GEN-END:variables
}
