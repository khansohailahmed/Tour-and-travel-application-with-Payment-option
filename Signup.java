package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {
    
    JPanel p1, p2;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JPasswordField pass;
    JButton b1, b2;
    Choice c;
    
    public Signup() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Font f = new Font("Tahoma", Font.BOLD, 15);
        
        p1 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setBounds(5, 5, 400, 550);
        p1.setLayout(null);
        add(p1);
        
        l1 = new JLabel("Username");
        l1.setBounds(40, 60, 100, 25);
        l1.setFont(f);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBounds(150, 60, 150, 25);
        t1.setFont(f);
        p1.add(t1);
        
        l2 = new JLabel("Name");
        l2.setBounds(60, 95, 100, 25);
        l2.setFont(f);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(150, 95, 150, 25);
        t2.setFont(f);
        p1.add(t2);
        
        l3 = new JLabel("Password");
        l3.setBounds(55, 135, 100, 25);
        l3.setFont(f);
        p1.add(l3);
        
        pass = new JPasswordField();
        pass.setBounds(150, 135, 150, 25);
        pass.setFont(f);
        p1.add(pass);
        
        l4 = new JLabel("Security Question");
        l4.setBounds(10, 170, 151, 25);
        l4.setFont(f);
        p1.add(l4);
        
        c = new Choice();
        c.add("Your pet's Name");
        c.add("Favorite animal");
        c.add("Favorite Subject");
        c.add("Favorite Superhero");
        c.setFont(f);
        c.setBounds(170, 170, 150, 30);
        p1.add(c);
        
        l5 = new JLabel("Answer");
        l5.setBounds(55, 210, 100, 25);
        l5.setFont(f);
        p1.add(l5);
        
        t3 = new JPasswordField();
        t3.setBounds(150, 210, 150, 25);
        t3.setFont(f);
        p1.add(t3);
        
        b1 = new JButton("Login");
        b1.setBounds(60, 250, 100, 35);
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Submit");
        b2.setBounds(190, 250, 100, 35);
        b2.setBackground(Color.darkGray);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p1.add(b2);
        
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(425, 5, 350, 550);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 50, 280, 280);
        p2.add(image);
        
        setSize(800, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Login();
        } else if (ae.getSource() == b2) {
            String username = t1.getText();
            String name = t2.getText();
            String password = new String(pass.getPassword());
            String securityQuestion = c.getSelectedItem();
            String answer = t3.getText();
            
            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "'";
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already taken. Try another username.");
                } else {
                    query = "INSERT INTO login (username, name, password, securityquestion, answer) VALUES ('" + username + "', '" + name + "', '" + password + "', '" + securityQuestion + "', '" + answer + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "User Registered Successfully");
                    
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Signup();
    }
}
