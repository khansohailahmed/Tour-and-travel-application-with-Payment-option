package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPakage extends JFrame implements ActionListener {

    JLabel l1;
    JLabel idLabel, numberLabel, usernameLabel;
    JLabel idValue, numberValue, usernameValue;
    JLabel packageLabel, selectpack, totalperson, totalpersonlf, price, pricelf;
    JButton backButton;

    public ViewPakage(String username) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Font f = new Font("Tahoma", Font.BOLD, 30);
        Font f1 = new Font("Tahoma", Font.BOLD, 20);

        l1 = new JLabel("View Booked Package");
        l1.setFont(f);
        l1.setBounds(250, 10, 400, 50);
        l1.setForeground(new Color(102, 178, 255));
        add(l1);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(f1);
        usernameLabel.setBounds(60, 70, 150, 25);
        add(usernameLabel);
        usernameValue = new JLabel();
        usernameValue.setFont(f1);
        usernameValue.setBounds(225, 70, 350, 25);
        add(usernameValue);

        idLabel = new JLabel("ID:");
        idLabel.setFont(f1);
        idLabel.setBounds(60, 110, 150, 25);
        add(idLabel);
        idValue = new JLabel();
        idValue.setFont(f1);
        idValue.setBounds(225, 110, 350, 25);
        add(idValue);

        numberLabel = new JLabel("Number:");
        numberLabel.setFont(f1);
        numberLabel.setBounds(60, 150, 150, 25);
        add(numberLabel);
        numberValue = new JLabel();
        numberValue.setFont(f1);
        numberValue.setBounds(225, 150, 350, 25);
        add(numberValue);

        packageLabel = new JLabel("Selected Package:");
        packageLabel.setFont(f1);
        packageLabel.setBounds(50, 190, 200, 25);
       // packageLabel.setForeground(new Color(102, 178, 255));
        add(packageLabel);
        selectpack = new JLabel();
        selectpack.setFont(f1);
        selectpack.setBounds(240, 190, 350, 25);
        add(selectpack);

        totalperson = new JLabel("Total Persons:");
        totalperson.setFont(f1);
        totalperson.setBounds(50, 230, 200, 25);
        //totalperson.setForeground(new Color(102, 178, 255));
        add(totalperson);
        totalpersonlf = new JLabel();
        totalpersonlf.setFont(f1);
        totalpersonlf.setBounds(225, 230, 350, 25);
        add(totalpersonlf);

        price = new JLabel("Total Price:");
        price.setFont(f1);
        price.setBounds(50, 270, 200, 25);
       // price.setForeground(new Color(102, 178, 255));
        add(price);
        pricelf = new JLabel();
        pricelf.setFont(f1);
        pricelf.setBounds(225, 270, 350, 25);
        add(pricelf);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(f1);
        phoneLabel.setBounds(60, 310, 150, 25);
        add(phoneLabel);
        JLabel phoneValue = new JLabel();
        phoneValue.setFont(f1);
        phoneValue.setBounds(225, 310, 350, 25);
        add(phoneValue);

        backButton = new JButton("Back");
        backButton.setFont(f1);
        backButton.setBounds(350, 400, 150, 35);
        backButton.setBackground(Color.DARK_GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        try {
            Conn c = new Conn();
            String q = "Select * from bookpackage where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()) {
                usernameValue.setText(rs.getString("username"));
                idValue.setText(rs.getString("id"));
                numberValue.setText(rs.getString("number"));
                phoneValue.setText(rs.getString("phone"));
                selectpack.setText(rs.getString("package"));
                totalpersonlf.setText(rs.getString("tperson"));
                pricelf.setText(rs.getString("price"));
            }
        } catch (Exception e1) {
            System.out.println(e1);
        }

        setBounds(350, 100, 900, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            this.dispose();
            new Dashboard("");
        }
    }

    public static void main(String[] args) {
        new ViewPakage("");
    }
}
