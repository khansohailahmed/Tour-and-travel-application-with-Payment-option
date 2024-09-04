package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Updatepersonal extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JTextField t1, t2, t3, t4, t5, gendertf, idtf;
    JRadioButton rbmale, rbfemale, rbother;
    Choice c;
    Font f, f1;
    JButton b1, b2;
    String username;

    public Updatepersonal(String username) {
        this.username = username;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Fonts
        f = new Font("Tahoma", Font.BOLD, 25);
        f1 = new Font("Tahoma", Font.BOLD, 20);

        // Labels
        l1 = new JLabel("Update Customer Details");
        l1.setFont(f);
        l1.setBounds(100, 50, 350, 50);
        l1.setForeground(new Color(102, 178, 255));
        add(l1);

        l2 = new JLabel("Username:");
        l2.setFont(f1);
        l2.setBounds(60, 120, 150, 25);
        add(l2);
        l3 = new JLabel();
        l3.setFont(f1);
        l3.setBounds(225, 120, 150, 25);
        add(l3);

        l4 = new JLabel("Choose ID:");
        l4.setFont(f1);
        l4.setBounds(60, 165, 150, 25);
        add(l4);
        idtf = new JTextField();
        idtf.setFont(f1);
        idtf.setBounds(225, 165, 200, 25);
        add(idtf);

        l5 = new JLabel("ID No:");
        l5.setFont(f1);
        l5.setBounds(85, 210, 150, 25);
        add(l5);
        t1 = new JTextField();
        t1.setFont(f1);
        t1.setBounds(225, 210, 200, 25);
        add(t1);

        l6 = new JLabel("Name:");
        l6.setFont(f1);
        l6.setBounds(80, 260, 150, 25);
        add(l6);
        l7 = new JLabel();
        l7.setFont(f1);
        l7.setBounds(225, 260, 150, 25);
        add(l7);

        // Gender Radio Buttons
        l8 = new JLabel("Gender:");
        l8.setFont(f1);
        l8.setBounds(60, 300, 150, 25);
        add(l8);
        gendertf = new JTextField();
        gendertf.setFont(f1);
        gendertf.setBounds(225, 300, 150, 25);
        add(gendertf);

        l9 = new JLabel("Country:");
        l9.setFont(f1);
        l9.setBounds(60, 340, 150, 25);
        add(l9);
        t2 = new JTextField();
        t2.setFont(f1);
        t2.setBounds(225, 340, 200, 25);
        add(t2);

        l10 = new JLabel("Address:");
        l10.setFont(f1);
        l10.setBounds(60, 380, 150, 25);
        add(l10);
        t3 = new JTextField();
        t3.setFont(f1);
        t3.setBounds(225, 380, 200, 25);
        add(t3);

        l11 = new JLabel("Phone:");
        l11.setFont(f1);
        l11.setBounds(60, 420, 150, 25);
        add(l11);
        t4 = new JTextField();
        t4.setFont(f1);
        t4.setBounds(225, 420, 200, 25);
        add(t4);

        l12 = new JLabel("Email ID:");
        l12.setFont(f1);
        l12.setBounds(60, 460, 150, 25);
        add(l12);
        t5 = new JTextField();
        t5.setFont(f1);
        t5.setBounds(225, 460, 200, 25);
        add(t5);

        // Buttons
        b1 = new JButton("Back");
        b1.setBounds(120, 525, 200, 50);
        b1.setBackground(new Color(102, 178, 255));
        b1.setFont(f1);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update Details");
        b2.setBounds(380, 525, 200, 50);
        b2.setBackground(new Color(102, 178, 255));
        b2.setFont(f1);
        b2.addActionListener(this);
        add(b2);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/addcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570, 200, 250, 250);
        image.setBackground(Color.cyan);
        add(image);

        // Retrieve customer details based on username
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                l3.setText(rs.getString("username"));
                l7.setText(rs.getString("name"));
                idtf.setText(rs.getString("id"));
                gendertf.setText(rs.getString("gender"));
                t1.setText(rs.getString("number"));
                t2.setText(rs.getString("country"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("phone"));
                t5.setText(rs.getString("email"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(300, 100, 900, 700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new Dashboard(username);
            setVisible(false);

        } else if (ae.getSource() == b2) {
            // Retrieving input data
            String username = l3.getText();
            String id = idtf.getText();
            String number = t1.getText();
            String name = l7.getText();
            String country = t2.getText();
            String address = t3.getText();
            String phone = t4.getText();
            String email = t5.getText();
            String gender = gendertf.getText();

            // Update data in the database
            try {
                Conn c = new Conn();
                String query = "UPDATE customer SET id='" + id + "', number='" + number + "', name='" + name + "', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "' WHERE username='" + username + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
                new Dashboard(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Updatepersonal("");
    }
}
