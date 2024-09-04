package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JPanel p1, p2;
    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;
    String username;

    public Dashboard(String username) {
        this.username = username;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Panel 1 (Top Bar)
        p1 = new JPanel();
        p1.setBounds(0, 0, 1600, 100);
        p1.setBackground(new Color(102, 178, 255));
        p1.setLayout(null);
        add(p1);

        // Logo and title in p1
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/dashlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390, 31, 70, 70);
        p1.add(image);

        l1 = new JLabel("Dashboard - Welcome, " + username);
        l1.setFont(new Font("Tahoma", Font.BOLD, 25));
        l1.setBounds(470, 50, 450, 30); // Positioned next to the right side of the image
        p1.add(l1);

        // Panel 2 (Left Sidebar)
        p2 = new JPanel();
        p2.setBounds(0, 30, 350, 800); // Positioned below p1
        p2.setBackground(new Color(102, 178, 255));
        p2.setLayout(new GridLayout(14, 1, 3, 3)); // GridLayout for vertical alignment with reduced gaps
        add(p2);

        // Font setting for buttons
        Font f = new Font("Tahoma", Font.BOLD, 12);
        Color buttonColor = new Color(102, 178, 255);

        // Adding buttons to p2
        b1 = new JButton("Add Personal Details");
        b1.setFont(f);
        b1.setBackground(buttonColor);
        //b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Update Personal Details");
        b2.setFont(f);
        b2.setBackground(buttonColor);
        //b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("View Details");
        b3.setFont(f);
        b3.setBackground(buttonColor);
        // b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        p2.add(b3);

        b4 = new JButton("Delete Personal");
        b4.setFont(f);
        b4.setBackground(buttonColor);
        // b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        p2.add(b4);

        b5 = new JButton("Check Packages");
        b5.setFont(f);
        b5.setBackground(buttonColor);
        // b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        p2.add(b5);

        b6 = new JButton("Book Packages");
        b6.setFont(f);
        b6.setBackground(buttonColor);
        // b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        p2.add(b6);

        b7 = new JButton("View Packages");
        b7.setFont(f);
        b7.setBackground(buttonColor);
        //  b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        p2.add(b7);

        b8 = new JButton("View Hotel");
        b8.setFont(f);
        b8.setBackground(buttonColor);
        //b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        p2.add(b8);

        b9 = new JButton("Book Hotel");
        b9.setFont(f);
        b9.setBackground(buttonColor);
        // b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        p2.add(b9);

        b10 = new JButton("View Book Hotel");
        b10.setFont(f);
        b10.setBackground(buttonColor);
        // b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        p2.add(b10);

        b11 = new JButton("Destination");
        b11.setFont(f);
        b11.setBackground(buttonColor);
        // b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        p2.add(b11);

        b12 = new JButton("Payment");
        b12.setFont(f);
        b12.setBackground(buttonColor);
        // b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        p2.add(b12);

        b13 = new JButton("Notepad");
        b13.setFont(f);
        b13.setBackground(buttonColor);
        //   b13.setForeground(Color.WHITE);
        b13.addActionListener(this);
        p2.add(b13);

        b14 = new JButton("View Payment details");
        b14.setFont(f);
        b14.setBackground(buttonColor);
        //   b14.setForeground(Color.WHITE);
        b14.addActionListener(this);
        p2.add(b14);

        // Background Image
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/dash.jpg"));
        Image i6 = i5.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image2 = new JLabel(i7);
        image2.setBounds(0, 0, 1600, 900); // Adjusted bounds for the background image
        add(image2);

        // Ensure p1 and p2 are on top of image2
        setComponentZOrder(p1, 0);
        setComponentZOrder(p2, 1);
        setComponentZOrder(image2, 2);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            
            new Addpersonaldetails(username);
           
        } else if (ae.getSource() == b3) {
            new ViewCustomer(username);
            
        } else if (ae.getSource() == b2) {
            new Updatepersonal(username);
            
        } else if (ae.getSource() == b5) {
            new CheckPackage();
          
        }else if (ae.getSource()==b6){
            new BookPackage(username);
          
        }else if (ae.getSource()==b6){
            new BookPackage(username);
           
        }else if (ae.getSource()==b7){
            new ViewPakage(username);
          
        }else if (ae.getSource()==b8){
            new CheckHotel().setVisible(true);
            
        }else if (ae.getSource()==b11){
            new Destination().setVisible(true);
            
        }else if (ae.getSource()==b9){
            new BookHotel(username).setVisible(true);
           
        }else if (ae.getSource()==b11){
            new Destination().setVisible(true);
       
        }else if (ae.getSource()==b10){
            new ViewBookedHotel(username).setVisible(true);
            
        }else if (ae.getSource()==b12){
            new Payment(username);
            
        }else if (ae.getSource()==b13){
            try{
            Runtime.getRuntime().exec("Notepad.exe");
            }catch(Exception e){
                System.out.println(e);
            }
            
            
        }else if (ae.getSource()==b14){
            new ViewPaymentDetails(username).setVisible(true);
            
            
            
        }else if (ae.getSource()==b4){
            try{
            new DeleteCustomer(username).setVisible(true);
       }catch(Exception e1){
           e1.printStackTrace();
           
           
       }
    }
}


    public static void main(String[] args) {
        new Dashboard("");
    }
}
