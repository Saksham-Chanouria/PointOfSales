/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newproject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sakshamchanouria
 */
public class GenerateBill extends javax.swing.JFrame {
    ArrayList<BillProd> orig,prod;
    JPanel categJp,productJp;
    JScrollPane jsp1,jsp2;
    ArrayList<CategBill> al;
    ArrayList<ProductBill> al2;
    myclient obj = new myclient();
    JButton[] btArr = new JButton[20];
    JButton[] btArr2 = new JButton[100];
    mytablemodel tm;
    long totalAmount=0;
    
    
    class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return orig.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int column) {
            String[] col = {"Product","Category","Quantity","Price(Per Unit)","Amount"};
            return col[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            System.out.println("I am in this.");
            BillProd obj = orig.get(rowIndex);
            if(columnIndex==0){
                return obj.Pname;
            }
            else if(columnIndex==1){
                return obj.Cname;
            }
            else if(columnIndex==2){
                int qty = need;
                return obj.qty;
            }
            else if(columnIndex==3){
                int price = Integer.parseInt(obj.price);
                return price;
            }
            else if(columnIndex==4){
                int price = Integer.parseInt(obj.price);
                int qty=Integer.parseInt((String)obj.qty);
                totalAmount = totalAmount+(qty*price);
                amt.setText("Total Amount: "+totalAmount);
                return qty*price;
            }
            else{
                return null;
            }
        }
    }
    
    public GenerateBill() {
        initComponents();
        prod = new ArrayList<>();
        orig = new ArrayList<>();
        al = new ArrayList<>();
        al2 = new ArrayList<>();
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
        tm = new mytablemodel();
        
        categJp = new JPanel();
        productJp = new JPanel();
        
        
        categJp.setLayout(new BoxLayout(categJp,BoxLayout.Y_AXIS));
        productJp.setLayout(new BoxLayout(productJp,BoxLayout.Y_AXIS));
        
        al = obj.fetchCategNamePhoto();
        
        
        
//         Add labels to JPanel
        for (int i = 0; i < al.size(); i++) {
            CategBill obj = al.get(i);
            
            ImageIcon i1 = new ImageIcon(obj.photo);
            Image resized = i1.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
            i1 = new ImageIcon(resized);
            btArr[i] = new JButton(i1);
            btArr[i].setText(obj.name);
            
            btArr[i].setHorizontalTextPosition(SwingConstants.CENTER);
            btArr[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            final int index = i;
            
            
            
            jTable1.setModel(tm);
            categJp.add(btArr[i]);
            jsp2 = new JScrollPane(productJp);
            jsp2.setBounds(470, 60, 250, 650); 
            btArr[i].addActionListener(e -> buttonClicked(index));
        }

        System.out.println(al.toString());
        
        jsp1 = new JScrollPane(categJp);
        jsp1.setBounds(40, 60, 250, 650);
        
        add(jsp1);
        add(jsp2);
        
        setTitle("Generate Bill");
        setSize(d);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    void buttonClicked(int index){
        productJp.removeAll();  // Remove all components
        productJp.revalidate(); // Refresh layout
        productJp.repaint();    // Repaint UI
            
        String name = btArr[index].getText();
        al2 = obj.fetchProductNmPh(name);
        for (int i = 0; i < al2.size(); i++) {
            ProductBill obj = al2.get(i);
            
            ImageIcon i1 = new ImageIcon(obj.photo);
            Image resized = i1.getImage().getScaledInstance(200, 180, Image.SCALE_SMOOTH);
            i1 = new ImageIcon(resized);
            btArr2[i] = new JButton(i1);
            btArr2[i].setText(obj.name);
            
            
            btArr2[i].setHorizontalTextPosition(SwingConstants.CENTER);
            btArr2[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            productJp.add(btArr2[i]);
            btArr2[i].addActionListener(e -> productButtonClicked(index,obj.name));
        }
        
        
        
        add(jsp2);
    }
    
    
    int need=0;
    void productButtonClicked(int index,String name){
        
        String ans = JOptionPane.showInputDialog("Enter the quantity you want");
        String flag;
        if(ans!=null){
            try{
                need = Integer.parseInt(ans);
                flag = obj.checkQuantity(name,need);
                
                if(flag.equals("available")){
                    // <---------------------- LOGIC FOR ADDING PRODUCTS TO JTABLE ----------------------->
                    String pname = name;
                    prod = obj.getBillProd(pname,need);
                    orig.add(prod.get(0));
                    System.out.println("I am here noe");
                    System.out.println(prod.toString());
                    tm.fireTableDataChanged();
                    
                }
                else{
                    int available = Integer.parseInt(flag);
                    JOptionPane.showMessageDialog(this, "Sorry!! We don't have enough stock.\nWe only have "+flag+" in stock");
                }
            }
            catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Please enter an integer");
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        amt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(900, 50, 452, 402);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Products List");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 0, 300, 70);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setText("Category List");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 0, 300, 70);

        back.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(0, 51, 204));
        back.setText("Go Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(0, 10, 90, 24);

        jButton1.setText("BUY");
        getContentPane().add(jButton1);
        jButton1.setBounds(1140, 470, 160, 50);

        amt.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        amt.setText("Total Amount: ");
        getContentPane().add(amt);
        amt.setBounds(900, 470, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amt;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
