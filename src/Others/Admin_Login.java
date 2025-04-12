
package Others;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import newproject.AdminHome;
import newproject.MyServer;
import newproject.myclient;


public class Admin_Login extends JFrame implements ActionListener{

    JTextField userTf;
    JPasswordField passTf;
    JLabel username,password;
    JButton bt;
    JLabel photoLB2;
    public Admin_Login(){
        setLayout(null);
        
        photoLB2 = new JLabel();
        photoLB2.setBounds(10,10,5,5);
        username = new JLabel("Username");
        password = new JLabel("Password");
        bt = new JButton("Login");
        userTf = new JTextField();
        passTf = new JPasswordField();
        
        Font font = new Font("Trebuchet MS", 0, 22);
        Color color = new Color(9, 21, 64);
        
        username.setFont(font); 
        username.setForeground(color);
        
        password.setFont(font); 
        password.setForeground(color);
        
        bt.setFont(new Font("Trebuchet MS",0,18)); 
        bt.setForeground(color);
        
        username.setBounds(75,35,200,150);
        password.setBounds(75,105,200,150);
        userTf.setBounds(195,78,250,50);
        passTf.setBounds(195,158,250,50);
        bt.setBounds(245,230,110,40);
        
        Dimension d= new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
 
        photoLB2.setBounds(0,0,d.width,d.height);
        ImageIcon i1 = new ImageIcon("src/uploads/background.jpg");
        Image resized = i1.getImage().getScaledInstance(photoLB2.getWidth(), photoLB2.getHeight(), Image.SCALE_SMOOTH);
        i1 = new ImageIcon(resized);
        photoLB2.setIcon(i1);
        
        add(username);
        add(password);
        add(userTf);
        add(passTf);
        add(bt);
        add(photoLB2);
        
        bt.addActionListener(this);
        setTitle("Admin Login");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        try{
            MyServer obj = new MyServer(8000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTf.getText();
        String password = passTf.getText();
        
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
        else{
            JOptionPane.showMessageDialog(this, "Please fill complete details");
        }
    }
    
    
    public static void main(String[] args) {
        Admin_Login obj = new Admin_Login();
    }
}
