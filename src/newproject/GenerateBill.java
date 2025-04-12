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
    ArrayList<String> bill_pname;
    String currentRow;
    boolean nextWindow = false;
    
    
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
                
                return qty*price;
            }
            else{
                return null;
            }
        }
        
        public void removeRow(int rowIndex){
            orig.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
            
        }
        
        public void addQuantity(int val,int row){
            BillProd obj = orig.get(row);
            obj.setQty(val+"");
        }
    }
    
    public GenerateBill() {
        initComponents();
        bill_pname = new ArrayList<>();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        prod = new ArrayList<>();
        orig = new ArrayList<>();
        al = new ArrayList<>();
        al2 = new ArrayList<>();
        
        
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
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
//            photoLB.setBounds(0,0,d.width,d.height);
//            ImageIcon i2 = new ImageIcon("src/uploads/background.jpg");
//            Image resized2 = i2.getImage().getScaledInstance(photoLB.getWidth(), photoLB.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon i3 = new ImageIcon(resized2);
//            photoLB.setIcon(i3);
        
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
    
    void setText(){
        long myAmount =0;
        int columnIndex = 4; // change this to the column you want to iterate
        int rowCount = jTable1.getRowCount();
        
        for (int row = 0; row < rowCount; row++) {
            Object value = jTable1.getValueAt(row, columnIndex);
            myAmount += (Integer)value;
        }
        amt.setText("Total Amount: "+myAmount);
        
    }
    
    int need=0;
    void productButtonClicked(int index,String name){
        boolean dupFlag = false;
        for(int i=0;i<bill_pname.size();i++){
            if(name.equals(bill_pname.get(i))){
                dupFlag=true;
            }
        }
        System.out.println("I am checking the products");
        
        if(dupFlag){
            JOptionPane.showMessageDialog(this, "You have already added this product");
        }
        else{
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
                        System.out.println(prod.toString());
                        bill_pname.add(name);
                        tm.fireTableDataChanged();
                        setText();
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        photoLB = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1030, 510, 160, 50);

        amt.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        amt.setText("Total Amount: ");
        getContentPane().add(amt);
        amt.setBounds(900, 470, 220, 40);

        jButton2.setText("Increase");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1008, 590, 80, 23);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1130, 590, 78, 23);
        getContentPane().add(photoLB);
        photoLB.setBounds(20, 60, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:

        AdminHome obj = new AdminHome();
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        
        if(row!=-1){
            int need = Integer.parseInt(JOptionPane.showInputDialog(this,"Enter the quantity you want to add."));
            Object qty = jTable1.getValueAt(row, 2);
            Object o2 = jTable1.getValueAt(row, 0);
            String name = (String)o2;
            String qs = (String)qty;
            int quantity = Integer.parseInt(qs);
            String flag = obj.checkQuantity(name,need+quantity);

                    if(flag.equals("available")){
                        tm.addQuantity(need+quantity,row);
                        tm.fireTableDataChanged();
                        setText();
                    }
                    else{
                        int available = Integer.parseInt(flag);
                        JOptionPane.showMessageDialog(this, "Sorry!! We don't have enough stock.\nWe only have "+flag+" in stock");
                    }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();
        
        if(row!=-1 && column != -1){
            
            Object value = jTable1.getValueAt(row, 0);
            Object value2 = jTable1.getValueAt(row, 4);
            
            currentRow = (String) value;
            int val = (Integer)value2;
            JOptionPane.showMessageDialog(this, "Product Removed");
            tm.removeRow(row);
            bill_pname.remove(currentRow);
            setText();
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        long myAmount=0;
        int rowCount = jTable1.getRowCount();
        String products[] =new String[rowCount];
        int[] pprice = new int[rowCount];
        int[] qty = new int[rowCount];
         
        if(rowCount>0){
            for (int row = 0; row < rowCount; row++) {
                Object value = jTable1.getValueAt(row, 4);
                Object nm = jTable1.getValueAt(row, 0);
                Object qt = jTable1.getValueAt(row, 2);
                Object pp = jTable1.getValueAt(row, 3);
                myAmount += (Integer)value;
                products[row] = (String)nm;
                String qStr = qt+"";
                String pStr = pp+"";
                
                pprice[row] = Integer.parseInt(pStr);
                qty[row] = Integer.parseInt(qStr);
            }
            for(int i=0;i<qty.length;i++){
                System.out.println(qty[i]);
            }
            Get_Customer_Details obj = new Get_Customer_Details(products,myAmount,qty,pprice);
//            Get_Customer_Details obj = new Get_Customer_Details();
        }
        else{
            JOptionPane.showMessageDialog(this, "Buy some products");
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel photoLB;
    // End of variables declaration//GEN-END:variables
}
