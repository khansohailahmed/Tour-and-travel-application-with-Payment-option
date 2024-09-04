package toursandtravel;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel username, password;
    JTextField usertf;
    JPasswordField passpf;
    JPanel p1, p2;
    JButton b1, b2, b3;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        p1 = new JPanel();
        p1.setBounds(0, 0, 300, 400);
        p1.setLayout(null);
        p1.setBackground(Color.cyan);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(15, 52, 250, 250);
        image.setBackground(Color.cyan);
        p1.add(image);

        p2 = new JPanel();
        p2.setBounds(350, 0, 400, 400);
        p2.setLayout(null);
        add(p2);

        username = new JLabel("User Name");
        username.setBounds(40, 30, 100, 30);
        p2.add(username);
        usertf = new JTextField();
        usertf.setBounds(150, 30, 150, 30);
        p2.add(usertf);

        password = new JLabel("Password");
        password.setBounds(40, 80, 100, 30);
        p2.add(password);
        passpf = new JPasswordField();
        passpf.setBounds(150, 80, 150, 30);
        p2.add(passpf);

        b1 = new JButton("Sign up");
        b1.setBounds(40, 150, 100, 35);
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Login");
        b2.setBounds(190, 150, 100, 35);
        b2.setBackground(Color.darkGray);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("Forget Password");
        b3.setBounds(95, 200, 150, 35);
        b3.setBackground(Color.darkGray);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        p2.add(b3);

        setSize(800, 400);
        setLocation(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
        new Signup();
        setVisible(false);
    } else if (ae.getSource() == b2) {
        String username = usertf.getText();
        String password = String.valueOf(passpf.getPassword());
        try {
            Conn c = new Conn();
            String query = "select * from login where username ='" + username + "' and password = '" + password + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Loading(username);
                // Pass the username to Loading
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Try again!");
            }
            
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
  new Dashboard(username);
    } else if (ae.getSource() == b3) {
        new ForgetPass();
        setVisible(false);
    }
}


    public static void main(String[] args) {
        new Login();
    }
}
