
package newproject;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class Admin_Manage_Category extends javax.swing.JFrame {
    JFileChooser jfc;
    ArrayList<Category> al;
    mytablemodel tm;

    public Admin_Manage_Category() {
        al = new ArrayList<>();

        tm = new mytablemodel();
        
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        photoLB.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB.getWidth(), photoLB.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        photoLB.setIcon(i2);

        jfc = new JFileChooser();
        jTable1.setModel(tm);
        
        // <--------------- Code to render the image on to JTable ---------->
        jTable1.setRowHeight(100);  
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);  
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);  
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);  
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        // <----------------------------------------------------------------->
        
        myclient obj = new myclient();
        al = obj.fetchCategories();
        
//        tm.fireTableDataChanged();

        setTitle("Manage Categories");
        setSize(d);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class mytablemodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Category obj = al.get(rowIndex);

            if (columnIndex == 0) {
                return obj.name;
            } else if (columnIndex == 1) {
                return obj.desc;
            } else if(columnIndex ==2){
                // return obj.photo;
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
            else {
                return null;
            }
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Name", "Description", "Photo"};
            return col[j];
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CategImage = new javax.swing.JLabel();
        fileChoose = new javax.swing.JButton();
        AddCategBt = new javax.swing.JButton();
        remCateg = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        photoLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Admin Manage Categories");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 20, 520, 60);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Add Categories");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 130, 250, 60);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Remove Category");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(870, 100, 230, 40);

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
        jScrollPane1.setBounds(680, 150, 660, 440);

        jLabel4.setText("Category Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 230, 100, 40);
        getContentPane().add(tf1);
        tf1.setBounds(210, 240, 200, 30);

        jLabel5.setText("Caregory Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 300, 130, 20);
        getContentPane().add(tf2);
        tf2.setBounds(210, 300, 200, 30);

        jLabel6.setText("Category Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 370, 100, 17);

        CategImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(CategImage);
        CategImage.setBounds(210, 360, 140, 130);

        fileChoose.setText("Choose");
        fileChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooseActionPerformed(evt);
            }
        });
        getContentPane().add(fileChoose);
        fileChoose.setBounds(370, 360, 78, 23);

        AddCategBt.setText("ADD Category");
        AddCategBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCategBtActionPerformed(evt);
            }
        });
        getContentPane().add(AddCategBt);
        AddCategBt.setBounds(140, 530, 220, 40);

        remCateg.setText("Remove Category");
        remCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remCategActionPerformed(evt);
            }
        });
        getContentPane().add(remCateg);
        remCateg.setBounds(940, 600, 170, 40);

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 110, 510, 500);

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

        photoLB.setText("jLabel8");
        getContentPane().add(photoLB);
        photoLB.setBounds(20, 60, 42, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File f;
    Path relativePath;
    private void fileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooseActionPerformed
        // TODO add your handling code here:
        int ans = jfc.showOpenDialog(this);

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
            CategImage.setIcon(new ImageIcon(relativePath + ""));

            ImageIcon i1 = new ImageIcon(relativePath + "");
            Image resized = i1.getImage().getScaledInstance(CategImage.getWidth(), CategImage.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon i2 = new ImageIcon(resized);
            CategImage.setIcon(i2);

            System.out.println(f);
            System.out.println(relativePath);
        } else {
            System.out.println("Cancel Clicked");
        }
    }//GEN-LAST:event_fileChooseActionPerformed

    private void AddCategBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCategBtActionPerformed
        // TODO add your handling code here:
        String categNm = tf1.getText();
        String categDsc = tf2.getText();
        String photo = "" + relativePath;
        System.out.println("Name : " + photo + " this");
        
        System.out.println(photo.length());
        myclient obj = new myclient();
        
        int res = obj.add_Category(categNm, categDsc, photo);
        
        if (res == 1) 
        {
            JOptionPane.showMessageDialog(this, "Category Added Successfully");
            tf1.setText("");
            tf2.setText("");
            CategImage.setIcon(new ImageIcon(""));
        } 
        else if (res == 0) {
            JOptionPane.showMessageDialog(this, "This Category Already Exists");
        } 
        else if (res == -1) {
            JOptionPane.showMessageDialog(this, "Please fill complete details");
        } 
        else {
            JOptionPane.showMessageDialog(this, "Connection has not been establised");
        }
        al = obj.fetchCategories();
        tm.fireTableDataChanged();
        
        
    }//GEN-LAST:event_AddCategBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        JOptionPane.showMessageDialog(this, "Hello");
    }
    
    private void remCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remCategActionPerformed
        // TODO add your handling code here:
        myclient obj = new myclient();
        int response = obj.removeCategory(nm);

        if (response == 1) {
            JOptionPane.showMessageDialog(this, "Row has been deleted.");
            al = obj.fetchCategories();
            tm.fireTableDataChanged();
            nm="";
        } else if (response == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item.");
        }

    }//GEN-LAST:event_remCategActionPerformed

    String nm = "";
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();

        if (row != -1 && column != -1) { // Ensure a valid selection
            Object value = jTable1.getValueAt(row, 0);
            nm = (String) value;
            System.out.println("Clicked : " + value);
        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
        AdminHome obj = new AdminHome();
        dispose();
    }//GEN-LAST:event_backActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Manage_Category().setVisible(true);
            }
        });
    }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCategBt;
    private javax.swing.JLabel CategImage;
    private javax.swing.JButton back;
    private javax.swing.JButton fileChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoLB;
    private javax.swing.JButton remCateg;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
