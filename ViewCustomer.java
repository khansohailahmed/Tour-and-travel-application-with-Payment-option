package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JLabel l1;//heading label
    JLabel idLabel, numberLabel, nameLabel, genderLabel, countryLabel, addressLabel, phoneLabel, emailLabel, usernameLabel;
    JLabel idValue, numberValue, nameValue, genderValue, countryValue, addressValue, phoneValue, emailValue, usernameValue;
    JButton backButton;

    public ViewCustomer(String username) {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Font f = new Font("Tahoma", Font.BOLD, 30);
        Font f1 = new Font("Tahoma", Font.BOLD, 20);

        l1 = new JLabel("View User Details");
        l1.setFont(f);
        l1.setBounds(250, 10, 300, 50);
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

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(f1);
        nameLabel.setBounds(60, 190, 150, 25);
        add(nameLabel);
        nameValue = new JLabel();
        nameValue.setFont(f1);
        nameValue.setBounds(225, 190, 350, 25);
        add(nameValue);

        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(f1);
        genderLabel.setBounds(60, 230, 150, 25);
        add(genderLabel);
        genderValue = new JLabel();
        genderValue.setFont(f1);
        genderValue.setBounds(225, 230, 350, 25);
        add(genderValue);

        countryLabel = new JLabel("Country:");
        countryLabel.setFont(f1);
        countryLabel.setBounds(60, 270, 150, 25);
        add(countryLabel);
        countryValue = new JLabel();
        countryValue.setFont(f1);
        countryValue.setBounds(225, 270, 350, 25);
        add(countryValue);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(f1);
        addressLabel.setBounds(60, 310, 150, 25);
        add(addressLabel);
        addressValue = new JLabel();
        addressValue.setFont(f1);
        addressValue.setBounds(225, 310, 350, 25);
        add(addressValue);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(f1);
        phoneLabel.setBounds(60, 350, 150, 25);
        add(phoneLabel);
        phoneValue = new JLabel();
        phoneValue.setFont(f1);
        phoneValue.setBounds(225, 350, 350, 25);
        add(phoneValue);

        emailLabel = new JLabel("Email:");
        emailLabel.setFont(f1);
        emailLabel.setBounds(60, 390, 150, 25);
        add(emailLabel);
        emailValue = new JLabel();
        emailValue.setFont(f1);
        emailValue.setBounds(225, 390, 350, 25);
        add(emailValue);

        backButton = new JButton("Back");
        backButton.setFont(f1);
        backButton.setBounds(150, 450, 150, 35);
        backButton.setBackground(Color.darkGray);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        try {
            //idValue, numberValue, nameValue, genderValue, countryValue, addressValue, 
            //phoneValue, emailValue, usernameValue;
            Conn c = new Conn();
            String q = "Select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()) {
                usernameValue.setText(rs.getString("username"));
                idValue.setText(rs.getString("id"));
                numberValue.setText(rs.getString("number"));
                nameValue.setText(rs.getString("name"));
                genderValue.setText(rs.getString("gender"));
                countryValue.setText(rs.getString("country"));
                addressValue.setText(rs.getString("address"));
                phoneValue.setText(rs.getString("phone"));
                emailValue.setText(rs.getString("email"));
                //usernameValue.setText(rs.getString("username"));

            }

        } catch (Exception e1) {

            System.out.println(e1);
        }

        setBounds(350, 100, 900, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            // Handle the back button action here
            // For example, close this frame and go back to the previous screen
            this.dispose(); // Close the current frame
            new Dashboard(""); // Replace with your method to return to the dashboard or previous screen
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("");
    }
}
