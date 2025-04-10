
package newproject;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;


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
public class Admin_Manage_Products extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Manage_Categories
     */
    ArrayList<String> categ_List;
    String categ_ListStr[];
    JComboBox jc;
    JFileChooser jfc;
    myclient obj;
    mytablemodel tm;
    ArrayList<Products> al;
    JLabel lb10;
    public Admin_Manage_Products() {
        setLayout(null);
        
        initComponents();
        lb10 = new JLabel();
        al = new ArrayList<>();
        obj = new myclient();

        tm = new mytablemodel();
        
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        lb10.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(lb10.getWidth(), lb10.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        lb10.setIcon(i2);
        
        categ_List = obj.fetchCategName();
        convertToStr();
        jc = new JComboBox(categ_ListStr);
        jfc = new JFileChooser();
        
        jc.setBounds(210, 320, 160, 40);
        add(jc);
        add(lb10);
        
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
        
        setTitle("Manage Products");
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

        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDesc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        quantityJSP = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        priceJSP = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productImage = new javax.swing.JLabel();
        fileChoose = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        photoLB = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        jLabel4.setText("Category Name");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Admin Manage Products");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 20, 520, 60);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Add Product");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 130, 250, 60);

        jLabel5.setText("Quantity");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 430, 100, 30);
        getContentPane().add(tfDesc);
        tfDesc.setBounds(210, 270, 200, 30);

        jLabel6.setText("Product Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 220, 100, 30);
        getContentPane().add(tfName);
        tfName.setBounds(210, 220, 200, 30);

        jLabel7.setText("Product Desc");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 270, 100, 30);
        getContentPane().add(quantityJSP);
        quantityJSP.setBounds(210, 430, 90, 30);

        jLabel8.setText("Category");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 330, 100, 30);
        getContentPane().add(priceJSP);
        priceJSP.setBounds(210, 380, 90, 30);

        jLabel9.setText("Price");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 380, 100, 30);

        jLabel10.setText("Photo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(70, 490, 90, 17);

        productImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(productImage);
        productImage.setBounds(210, 480, 140, 130);

        fileChoose.setText("Choose");
        fileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooseActionPerformed(evt);
            }
        });
        getContentPane().add(fileChoose);
        fileChoose.setBounds(380, 480, 78, 23);

        jButton1.setText("ADD Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 630, 200, 40);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Products List");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(960, 110, 180, 40);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(620, 160, 790, 510);

        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel11);
        jLabel11.setBounds(19, 127, 520, 560);

        photoLB.setText(".");
        getContentPane().add(photoLB);
        photoLB.setBounds(30, 30, 4, 17);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    File f;
    Path relativePath;
    private void fileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooseActionPerformed
        // TODO add your handling code here:
        int ans = jfc.showOpenDialog(this);
////
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            String absolutePath = f.getAbsolutePath();
            System.out.println("Absolute Path: " + absolutePath);
            
            // Define the base directory (can be project root or execution dir)
            File baseDir = new File(System.getProperty("user.dir")); // Project directory
            
            // Convert absolute path to relative path
            Path basePath = baseDir.toPath();
            Path filePath = f.toPath();
            relativePath = basePath.relativize(filePath);
            productImage.setIcon(new ImageIcon(relativePath + ""));

            ImageIcon i1 = new ImageIcon(f + "");
            Image resized = i1.getImage().getScaledInstance(productImage.getWidth(), productImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon i2 = new ImageIcon(resized);
            productImage.setIcon(i2);

            System.out.println(f);
        } else {
            System.out.println("Cancel Clicked");
        }
    }//GEN-LAST:event_fileChooseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String pname = tfName.getText();
        String pDesc = tfDesc.getText();
        String categName = (String)jc.getSelectedItem();
        int price = Integer.parseInt(priceJSP.getModel().getValue().toString());
        int quantity = Integer.parseInt(quantityJSP.getModel().getValue().toString());
        String photo = relativePath+"";
        
        int res = obj.add_Product(pname, pDesc, categName,price,quantity,photo);
        
        if (res == 1) 
        {
            JOptionPane.showMessageDialog(this, "Success");
            tfDesc.setText("");
            tfName.setText("");
            priceJSP.getModel().setValue(0);
            quantityJSP.getModel().setValue(0);
            productImage.setIcon(new ImageIcon(""));
        } 
        else if (res == -1) {
            JOptionPane.showMessageDialog(this, "Please fill complete details");
        } 
        else if (res == -2) {
            JOptionPane.showMessageDialog(this, "Please fill more than one value");
        } 
        else {
            JOptionPane.showMessageDialog(this, "Connection has not been establised");
        }
        al = obj.fetchProducts();
        tm.fireTableDataChanged();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        AdminHome obj = new AdminHome();
        dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Manage_Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Manage_Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Manage_Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton fileChoose;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoLB;
    private javax.swing.JSpinner priceJSP;
    private javax.swing.JLabel productImage;
    private javax.swing.JSpinner quantityJSP;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
