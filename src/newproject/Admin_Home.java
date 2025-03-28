
package newproject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Admin_Home extends javax.swing.JFrame {
    JButton bt;
    public Admin_Home() {
        initComponents();
        bt = new JButton("Add");
        
        try{
            MyServer obj4 = new MyServer(8000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
 
        photoLB2.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB2.getWidth(), photoLB2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        photoLB2.setIcon(i2);
        
        setSize(d);
        setLocationRelativeTo(null);
        setTitle("Main Page");
        setVisible(true);
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        photoLB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        photoLB2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bt1.setBackground(new java.awt.Color(255, 186, 196));
        bt1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt1.setForeground(new java.awt.Color(9, 21, 64));
        bt1.setText("Manage Category");
        bt1.setMaximumSize(new java.awt.Dimension(410, 130));
        bt1.setMinimumSize(new java.awt.Dimension(410, 130));
        bt1.setPreferredSize(new java.awt.Dimension(410, 130));
        bt1.setSize(new java.awt.Dimension(410, 130));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(170, 110, 410, 130);

        bt2.setBackground(new java.awt.Color(255, 186, 196));
        bt2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt2.setForeground(new java.awt.Color(9, 21, 64));
        bt2.setText("Manage Products");
        bt2.setMaximumSize(new java.awt.Dimension(410, 130));
        bt2.setMinimumSize(new java.awt.Dimension(410, 130));
        bt2.setPreferredSize(new java.awt.Dimension(410, 130));
        bt2.setSize(new java.awt.Dimension(410, 130));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(170, 310, 410, 130);

        bt3.setBackground(new java.awt.Color(255, 186, 196));
        bt3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt3.setForeground(new java.awt.Color(9, 21, 64));
        bt3.setText("Manage Quantity");
        bt3.setMaximumSize(new java.awt.Dimension(410, 130));
        bt3.setMinimumSize(new java.awt.Dimension(410, 130));
        bt3.setPreferredSize(new java.awt.Dimension(410, 130));
        bt3.setSize(new java.awt.Dimension(410, 130));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });
        getContentPane().add(bt3);
        bt3.setBounds(170, 500, 410, 130);

        bt4.setBackground(new java.awt.Color(255, 186, 196));
        bt4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt4.setForeground(new java.awt.Color(9, 21, 64));
        bt4.setText("Generate Bill");
        bt4.setMaximumSize(new java.awt.Dimension(410, 130));
        bt4.setMinimumSize(new java.awt.Dimension(410, 130));
        bt4.setPreferredSize(new java.awt.Dimension(410, 130));
        bt4.setSize(new java.awt.Dimension(410, 130));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        getContentPane().add(bt4);
        bt4.setBounds(760, 110, 410, 130);

        bt5.setBackground(new java.awt.Color(255, 186, 196));
        bt5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt5.setForeground(new java.awt.Color(9, 21, 64));
        bt5.setText("Booking History");
        bt5.setMaximumSize(new java.awt.Dimension(410, 130));
        bt5.setMinimumSize(new java.awt.Dimension(410, 130));
        bt5.setPreferredSize(new java.awt.Dimension(410, 130));
        bt5.setSize(new java.awt.Dimension(410, 130));
        getContentPane().add(bt5);
        bt5.setBounds(760, 310, 410, 130);

        bt6.setBackground(new java.awt.Color(255, 186, 196));
        bt6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt6.setForeground(new java.awt.Color(9, 21, 64));
        bt6.setText("Log Out");
        bt6.setMaximumSize(new java.awt.Dimension(410, 130));
        bt6.setMinimumSize(new java.awt.Dimension(410, 130));
        bt6.setPreferredSize(new java.awt.Dimension(410, 130));
        bt6.setSize(new java.awt.Dimension(410, 130));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });
        getContentPane().add(bt6);
        bt6.setBounds(760, 500, 410, 130);
        getContentPane().add(photoLB);
        photoLB.setBounds(10, 10, 0, 0);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setText("Point of Sales");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(550, 10, 290, 60);
        getContentPane().add(photoLB2);
        photoLB2.setBounds(20, 30, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        
         Admin_Manage_Category obj3 = new Admin_Manage_Category();
         dispose();
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        
        Admin_Manage_Products obj = new Admin_Manage_Products();
        dispose();
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        
        Admin_Manage_Quantity obj = new Admin_Manage_Quantity();
        dispose();
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        
        GenerateBill obj = new GenerateBill();
        dispose();
    }//GEN-LAST:event_bt4ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel photoLB;
    private javax.swing.JLabel photoLB2;
    // End of variables declaration//GEN-END:variables
}
