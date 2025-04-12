
package newproject;

import newproject.DBLoader;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author new user
 */
public class NewUser extends javax.swing.JFrame {

    /**
     * Creates new form DataEntry
     */
    public NewUser() {
        initComponents();

        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setTitle("Create User");

        ImageIcon icon = new ImageIcon("src/uploads/icon.png");
        setIconImage(icon.getImage());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 420);
        setLocationRelativeTo(null);
        setVisible(true);

        jLabel6.setBounds(0, 0, d.width / 2, d.height / 2);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        jLabel6.setIcon(i2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfGmail = new javax.swing.JTextField();
        tfPass = new javax.swing.JTextField();
        jpPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        passLb1 = new javax.swing.JLabel();
        passLb2 = new javax.swing.JLabel();
        DoublePass = new javax.swing.JLabel();
        gmailChecker = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(88, 27, 152));
        jLabel1.setText("Create New User");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 280, 50);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 21, 64));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 110, 90, 18);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(9, 21, 64));
        jLabel3.setText("Gmail");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 160, 100, 19);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 21, 64));
        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 260, 130, 20);

        tfGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfGmailActionPerformed(evt);
            }
        });
        tfGmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfGmailKeyReleased(evt);
            }
        });
        getContentPane().add(tfGmail);
        tfGmail.setBounds(280, 150, 150, 30);

        tfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPassActionPerformed(evt);
            }
        });
        tfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPassKeyReleased(evt);
            }
        });
        getContentPane().add(tfPass);
        tfPass.setBounds(280, 250, 150, 30);

        jpPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpPassKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpPassKeyReleased(evt);
            }
        });
        getContentPane().add(jpPass);
        jpPass.setBounds(280, 200, 150, 30);

        jButton1.setBackground(new java.awt.Color(255, 186, 196));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(9, 21, 64));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 320, 130, 40);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 21, 64));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 210, 100, 19);

        tfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserActionPerformed(evt);
            }
        });
        getContentPane().add(tfUser);
        tfUser.setBounds(280, 100, 150, 30);

        passLb1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        passLb1.setForeground(new java.awt.Color(255, 0, 0));
        passLb1.setText("  ");
        getContentPane().add(passLb1);
        passLb1.setBounds(440, 200, 230, 20);

        passLb2.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        passLb2.setForeground(new java.awt.Color(255, 0, 0));
        passLb2.setText(" ");
        getContentPane().add(passLb2);
        passLb2.setBounds(440, 220, 180, 15);

        DoublePass.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        DoublePass.setForeground(new java.awt.Color(255, 0, 0));
        DoublePass.setText("  ");
        getContentPane().add(DoublePass);
        DoublePass.setBounds(450, 260, 130, 15);

        gmailChecker.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        gmailChecker.setForeground(new java.awt.Color(255, 0, 0));
        gmailChecker.setText("  ");
        getContentPane().add(gmailChecker);
        gmailChecker.setBounds(450, 160, 130, 15);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(570, 200, 42, 17);

        setBounds(0, 0, 756, 415);
    }// </editor-fold>//GEN-END:initComponents

    private void tfGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfGmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfGmailActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String user = tfUser.getText();
        String pass = tfPass.getText();
        String conpass = tfPass.getText();
        String gmail = tfGmail.getText();

        try {
            // LocalHost
            ResultSet rs = DBLoader.executeSQL("Select * from test3.user where username = \'" + user + "\'");       
            ResultSet gg = DBLoader.executeSQL("Select * from test3.user where gmail = \'" + tfGmail.getText() + "\'");
            

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "This username already exists.");
            } else {
                if (tfUser.getText().equals("") || tfGmail.getText().equals("") || tfPass.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Empty field");
                } else {

                    if (jpPass.getText().equals(tfPass.getText())) {
                        if (pass.length() >= 6) {
                            if (tfGmail.getText().contains("@gmail.com")) {

                                if (gg.next()) {
                                    JOptionPane.showMessageDialog(this, "This Gmail already exists.");
                                } else {
                                    rs.moveToInsertRow();
                                    rs.updateString("username", user);
                                    rs.updateString("password", pass);
                                    rs.updateString("gmail", gmail);
                                    rs.insertRow();
                                    JOptionPane.showMessageDialog(this, "New User Entered.");
                                    dispose();

                                    ManageServer obj = new ManageServer();
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, "Invalid Gmail.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Password should contain atleast 6 characters.");
                        }
                    } else {

                        JOptionPane.showMessageDialog(this, "Password Mismatched.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserActionPerformed

    private void tfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassActionPerformed

    private void jpPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpPassKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jpPassKeyPressed

    private void jpPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpPassKeyReleased
        // TODO add your handling code here:
        String pass = jpPass.getText();
        String conpass = tfPass.getText();
        if (pass.length() >= 6 || pass.length() == 0) {
            passLb1.setText("");
            passLb2.setText("");
            if (jpPass.getText().equals(tfPass.getText())) {
                DoublePass.setText("");
            } else {
                if(conpass.length()!=0){
                    DoublePass.setText("Password Mismatched");
                }
                
            }
        } else {
            passLb1.setText("*Password should be");
            passLb2.setText("atleast 6 characters");
            DoublePass.setText("");
        }
    }//GEN-LAST:event_jpPassKeyReleased

    private void tfPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyReleased
        // TODO add your handling code here:
        String pass = jpPass.getText();
        if (jpPass.getText().equals(tfPass.getText()) || tfPass.getText().equals("")) {
            DoublePass.setText("");
        } else {
            if (passLb1.getText().equals("*Password should be") && passLb2.getText().equals("atleast 6 characters")) {

            } else {
                DoublePass.setText("*Password Mismatched");
            }
        }

    }//GEN-LAST:event_tfPassKeyReleased

    private void tfGmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGmailKeyReleased
        // TODO add your handling code here:
        String gmail = tfGmail.getText();
        if(gmail.contains("@gmail.com") || gmail.length()==0){
            gmailChecker.setText("");
        }
        else{
            gmailChecker.setText("*Invalid Gmail");
        }
    }//GEN-LAST:event_tfGmailKeyReleased

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoublePass;
    private javax.swing.JLabel gmailChecker;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPasswordField jpPass;
    private javax.swing.JLabel passLb1;
    private javax.swing.JLabel passLb2;
    private javax.swing.JTextField tfGmail;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
