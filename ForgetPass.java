package toursandtravel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ForgetPass extends JFrame implements ActionListener {
    
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3,b4;
    
    public ForgetPass(){
        getContentPane().setBackground(Color.darkGray);
        setLayout(null);
        Font f = new Font("Tahoma",Font.BOLD,20);
        
        
        l1 = new JLabel("Username");
        l1.setFont(f);
        l1.setBounds(25,60,120,25);
        l1.setForeground(Color.WHITE);
        add(l1);
        t1 = new JTextField();
        t1.setFont(f);
        t1.setBounds(150,60,150,25);
        add(t1);
        b1 = new JButton("Search");
        b1.setFont(f);
        b1.setBounds(305,60,120,25);
        b1.setBackground(Color.CYAN);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        l2 = new JLabel("Name");
        l2.setFont(f);
        l2.setBounds(50,105,120,25);
        l2.setForeground(Color.WHITE);
        add(l2);
        t2 = new JTextField();
        t2.setFont(f);
        t2.setBounds(150,105,150,25);
        add(t2);
        
        l3 = new JLabel("Security question ");
        l3.setFont(f);
        l3.setBounds(10,140,200,25);
        l3.setForeground(Color.WHITE);
        add(l3);
        t3 = new JTextField();
        t3.setFont(f);
        t3.setBounds(215,140,150,25);
        add(t3);
        
        l4 = new JLabel("Answer");
        l4.setFont(f);
        l4.setBounds(50,195,120,25);
        l4.setForeground(Color.WHITE);
        add(l4);
        t4 = new JTextField();
        t4.setFont(f);
        t4.setBounds(150,195,150,25);
        add(t4);
        b2 = new JButton("Retreive");
        b2.setFont(f);
        b2.setBounds(305,195,120,25);
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        l5 = new JLabel("Password");
        l5.setFont(f);
        l5.setBounds(45,230,120,25);
        l5.setForeground(Color.WHITE);
        add(l5);
        t5 = new JTextField();
        t5.setFont(f);
        t5.setBounds(150,230,150,25);
        add(t5);
        
        b3 = new JButton("Login Page");
        b3.setFont(f);
        b3.setBounds(65,300,150,25);
        b3.setBackground(Color.CYAN);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3); 
        
        b4 = new JButton("Got Password");
        b4.setFont(f);
        b4.setBounds(235,300,200,25);
        b4.setBackground(Color.CYAN);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4); 
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/forget.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,125,250,250);
        add(image);
                
        
        
        setBounds(350,200,850,500);
        setVisible(true);
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
       String username = t1.getText();
        
    try{
        Conn c = new Conn();
        String query = "SELECT * FROM login WHERE username = '" + username + "'";
        ResultSet rs = c.s.executeQuery(query);
        if(rs.next()){
        t2.setText(rs.getString("name"));
        t3.setText(rs.getString("securityquestion"));
        }else{
            JOptionPane.showMessageDialog(null,"Invalid username. Please check the username.");
        }
    
    
    }catch(Exception e1){
    
    e1.printStackTrace();
    }
    
    
    }else if(ae.getSource()==b2){
       String answer = t4.getText();
       String username = t1.getText();
        
    try{
        Conn c = new Conn();
        String query = "SELECT * FROM login WHERE username = '" + username + "' AND answer = '" + answer + "'";
        ResultSet rs = c.s.executeQuery(query);
        if(rs.next()){
        t5.setText(rs.getString("password"));
        }else{
            JOptionPane.showMessageDialog(null,"Invalid answer. Please check the answer.");
        }
    
    
    }catch(Exception e1){
    
    e1.printStackTrace();
    }
    
    
    }else if(ae.getSource()==b4){
    
    JOptionPane.showMessageDialog(null,"Hope you get the password");
    setVisible(false);
    
    }else if(ae.getSource()==b3){
    
    new Login();
    setVisible(false);
    }
    
    
    }

    
    

    
    public static void main(String[] args) {
        new ForgetPass();
    }
    
}
