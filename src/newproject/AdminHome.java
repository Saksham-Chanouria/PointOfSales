
package newproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminHome extends JFrame implements ActionListener{
    JButton[] bt;
    JLabel photoLB2;
    JLabel heading;
    public AdminHome(){
        setLayout(null);
        bt = new JButton[6];
//        try{
//            MyServer obj4 = new MyServer(8000);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
        
        
        heading = new JLabel("Point of Sales");
        photoLB2 = new JLabel("Hello");
        photoLB2.setBounds(10,10,5,5);
        bt[0] = new JButton("Manage Category");
        bt[1] = new JButton("Manage Products");
        bt[2] = new JButton("Manage Quantity");
        bt[3] = new JButton("Generate Bill");
        bt[4] = new JButton("Booking History");
        bt[5] = new JButton("Log Out");
        
        // <--------------                          Designing       ------------------------>
        
        bt[0].setBounds(170, 110, 410, 130);
        bt[1].setBounds(170, 310, 410, 130);
        bt[2].setBounds(170, 500, 410, 130);
        bt[3].setBounds(760, 110, 410, 130);
        bt[4].setBounds(760, 310, 410, 130);
        bt[5].setBounds(760, 500, 410, 130);
        heading.setBounds(550, 10, 290, 60);
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
 
        photoLB2.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB2.getWidth(), photoLB2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(resized);
        photoLB2.setIcon(i2);

        heading.setFont(new java.awt.Font("SansSerif", 1, 36));
        for(int i=0;i<bt.length;i++){
            bt[i].setBackground(new java.awt.Color(255, 186, 196)); 
            bt[i].setFont(new java.awt.Font("SansSerif", 0, 23)); 
            bt[i].setForeground(new java.awt.Color(9, 21, 64));
            
            add(bt[i]);
            bt[i].addActionListener(this);              // Adding Action Listener
        }
        add(heading);
        add(photoLB2);
                
        setTitle("Main Page");
        setSize(d);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt[0]){
            Admin_Manage_Category obj3 = new Admin_Manage_Category();
            dispose();
        }
        else if(e.getSource()==bt[1]){
            Admin_Manage_Products obj3 = new Admin_Manage_Products();
            dispose();
        }
        else if(e.getSource()==bt[2]){
            Admin_Manage_Quantity obj3 = new Admin_Manage_Quantity();
            dispose();
        }
        else if(e.getSource()==bt[3]){
            GenerateBill obj = new GenerateBill();
            dispose();
        }
        else if(e.getSource()==bt[4]){
            Admin_Booking_History obj = new Admin_Booking_History();
            dispose();
        }
        else if(e.getSource()==bt[5]){
            JOptionPane.showMessageDialog(this, "Logging Out");
            AdminLogin obj = new AdminLogin();
            dispose();
        }
    }
    
    
    public static void main(String[] args) {
        AdminHome obj = new AdminHome();
    }
}
