
package newproject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AdminLogin extends javax.swing.JFrame {

    
    public AdminLogin() {
        initComponents();
        try{
            MyServer obj4 = new MyServer(8000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        // Background Image
        photoLB.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB.getWidth(), photoLB.getHeight(), Image.SCALE_SMOOTH);
        i1 = new ImageIcon(resized);
        photoLB.setIcon(i1);
        
        setSize(410,304);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jp1 = new javax.swing.JPasswordField();
        newUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        forgot = new javax.swing.JButton();
        photoLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 21, 64));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 70, 80, 19);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 21, 64));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 130, 66, 18);

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(180, 60, 138, 30);

        jButton1.setBackground(new java.awt.Color(255, 186, 196));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(9, 21, 64));
        jButton1.setText("Login");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 200, 110, 40);

        jp1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(jp1);
        jp1.setBounds(180, 120, 140, 31);

        newUser.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        newUser.setForeground(new java.awt.Color(0, 102, 255));
        newUser.setText("Sign Up");
        newUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserActionPerformed(evt);
            }
        });
        getContentPane().add(newUser);
        newUser.setBounds(170, 250, 80, 22);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Not a User?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 250, 70, 20);

        forgot.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        forgot.setText("Forgot Password?");
        forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotActionPerformed(evt);
            }
        });
        getContentPane().add(forgot);
        forgot.setBounds(20, 165, 160, 20);

        photoLB.setText("jLabel5");
        getContentPane().add(photoLB);
        photoLB.setBounds(10, 10, 42, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = tf1.getText();
        String password = jp1.getText();
        
        myclient obj = new myclient();
        int res = obj.send_data(username, password);
        if(res==1){
            JOptionPane.showMessageDialog(this, "Login Successful");
            dispose();
            AdminHome obj2 = new AdminHome();
        }
        else if(res==0){
            JOptionPane.showMessageDialog(this, "Login Failed");
        }
        else if(res==-1){
            JOptionPane.showMessageDialog(this, "Please fill complete details");
        }
        else{
            JOptionPane.showMessageDialog(this, "Internal Server Error");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserActionPerformed
        // TODO add your handling code here:'
        
    }//GEN-LAST:event_newUserActionPerformed

    private void forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_forgotActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
  
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgot;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JButton newUser;
    private javax.swing.JLabel photoLB;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
