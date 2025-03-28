
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sakshamchanouria
 */
public class three extends JFrame implements ActionListener{
    JButton bt;
    JTextField tf;
    public three(){
        setLayout(null);
        
        bt = new JButton("Hello");
        tf = new JTextField("");
        bt.setBounds(100,200,100,70);
        tf.setBounds(100,100,200,50);
        
        add(bt);
        add(tf);
        tf.addActionListener(this);
        
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tf){
            JOptionPane.showMessageDialog(this, "Hello");
        }
    }
    
    public static void main(String[] args) {
        three obj = new three();
    }
    
}
