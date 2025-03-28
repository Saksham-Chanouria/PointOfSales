
package newproject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

// <--------------- Code to render the image on to JTable ---------->
class ImageRenderer extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) value;
            Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Resize the image
            setIcon(new ImageIcon(img));  // Set the resized image
        } else {
            setIcon(null);
        }
        return this;
    }
}
// <----------------------------------------------------------------->


public class Admin_Manage_Quantity extends javax.swing.JFrame {

    ArrayList<String> categ_List;
    String categ_ListStr[];
    myclient obj = new myclient();
    mytablemodel tm;
    ArrayList<Products> al;
    public Admin_Manage_Quantity() {
        setLayout(null);
        
        initComponents();
        
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        photoLB.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB.getWidth(), photoLB.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        photoLB.setIcon(i2);
        
        al = new ArrayList<>();
        tm = new mytablemodel();
        
        categ_List = obj.fetchCategName();
        convertToStr();
        
        jTable1.setModel(tm);
        
        // <--------------- Code to render the image on to JTable ---------->
        jTable1.setRowHeight(100);  
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);  
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        // <----------------------------------------------------------------->

        al = obj.fetchProducts();
        tm.fireTableDataChanged();
        
        setTitle("Manage Quantity");
        setSize(d);
        setVisible(true);
    }
    
    public void convertToStr(){
        categ_ListStr = new String[categ_List.size()];
        for (int i = 0; i < categ_List.size(); i++) {
            categ_ListStr[i] = categ_List.get(i);
        }
    }
    
    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Products obj = al.get(rowIndex);

            if (columnIndex == 0) {
                return obj.name;
            } else if (columnIndex == 1) {
                return obj.desc;
            } else if(columnIndex==2){
                return obj.category;
            }
             else if(columnIndex==3){
                return obj.quantity;
            }
            else if(columnIndex==4){
                return obj.price;
            }
            else if(columnIndex==5){
                // <--------------- Code to render the image on to JTable ---------->
                String photoPath = obj.photo;
                if (photoPath != null && !photoPath.isEmpty()) {
                    ImageIcon imageIcon = new ImageIcon(photoPath);
                    Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Resize image
                    return new ImageIcon(img);
                } else {
                    return null;
                }
                // <----------------------------------------------------------------->
            }
            else{
                return null;
            }
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Name", "Description", "Category","Quantity","Price","Photo"};
            return col[j];
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        photoLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Products List");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(560, 100, 180, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 180, 710, 402);

        back.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(0, 51, 204));
        back.setText("Go Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(10, 20, 90, 24);

        photoLB.setText("jLabel1");
        getContentPane().add(photoLB);
        photoLB.setBounds(20, 60, 42, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String nm = "";
    int qty=0;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();

        if (row != -1 && column != -1) { // Ensure a valid selection
            Object value = jTable1.getValueAt(row, 0);
            nm = (String) value;
            System.out.println("Clicked : " + value);
            
            try {
                String input = JOptionPane.showInputDialog("Enter the quantity of the product");

                if (input == null) { // User clicked "Cancel" or closed the dialog
//                    JOptionPane.showMessageDialog(null, "Operation cancelled");
                    qty=0;
                } else {
                    qty = Integer.parseInt(input); // Parse only if input is not null
//                    JOptionPane.showMessageDialog(null, "Quantity entered: " + qty);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
                qty=0;
            }
            
            if(qty!=0){
                int res = obj.increaseQuantity(nm,qty);
                
                if (res == 1) 
                {
                    JOptionPane.showMessageDialog(this, "Quantity Increased");
                } 
                else if (res == 0) {
                    JOptionPane.showMessageDialog(this, "Database Error");
                } 
                else if (res == -1) {
                    JOptionPane.showMessageDialog(this, "Connection has not been establised");
                } 
                al = obj.fetchProducts();
                tm.fireTableDataChanged();
            }
            
            
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
        AdminHome obj = new AdminHome();
        dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Manage_Quantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Quantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Quantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Quantity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Manage_Quantity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoLB;
    // End of variables declaration//GEN-END:variables
}
