
package newproject;

import java.awt.Window;
import javax.swing.*;

/**
 *
 * @author sakshamchanouria
 */
public class Get_Customer_Details extends javax.swing.JFrame {
    JComboBox jc;
    myclient obj;
    String[] products;
    long gtotal;
    int[] qty,pprice;
    
    public Get_Customer_Details() {
        this(new String[0], 0, new int[0], new int[0]);
    }
    
    public Get_Customer_Details(String[] products,long gtotal,int[] qty,int[] pprice) {
        
        String ale[]={"Cash","UPI","Card"};
         
        initComponents();
        jc = new JComboBox(ale);
        obj = new myclient();
        this.products = products;
        this.gtotal = gtotal;
        this.pprice = pprice;
        this.qty = qty;
        
        jc.setBounds(210, 210, 120, 30);
        
        setLayout(null);
        
        add(jc);
        setSize(429,379);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setText("Phone Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 150, 100, 17);

        jLabel3.setText("Payment Type");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 200, 90, 40);

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setText("Customer Details");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 40, 340, 60);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 140, 160, 30);

        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 280, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String CPhone = jTextField2.getText();
        String payment_mode = (String)jc.getSelectedItem();
        int ans = obj.Buy_prod(CPhone,payment_mode,products,gtotal,qty,pprice);
        
        if(ans==1){
            JOptionPane.showMessageDialog(this, "Order Successful");
            
            for (Window window : Window.getWindows()) {
                if (window instanceof JFrame) {
                    ((JFrame) window).dispose();
                }
            }
            AdminHome obj = new AdminHome();
        }
        else if(ans ==0){
            JOptionPane.showMessageDialog(this, "Please fill Complete Details");
        }
        else if(ans==-1){
            JOptionPane.showMessageDialog(this, "Database Error");
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Internal Server Error");
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Get_Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Get_Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Get_Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Get_Customer_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Get_Customer_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
