package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    JLabel usernameField, idField, idNumberField, phoneField, l1, totalfield, l5;
    JButton backButton, checkprice, bookPackageButton;
    JComboBox<String> packageChoice;
    JTextField totalPersonsField;
    String username;
    private static final Font FONT = new Font("Tahoma", Font.BOLD, 20);

    public BookPackage(String username) {
        this.username = username;
        setTitle("Book Package");
        setLayout(null);

        l1 = new JLabel("Book package");
        l1.setBounds(150, 10, 350, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 35));
        l1.setForeground(new Color(102, 178, 255));
        add(l1);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(FONT);
        usernameLabel.setBounds(100, 100, 150, 30);
        usernameLabel.setForeground(new Color(102, 178, 255));
        add(usernameLabel);
        usernameField = new JLabel();
        usernameField.setFont(FONT);
        usernameField.setBounds(250, 100, 200, 30);
        add(usernameField);

        JLabel packageLabel = new JLabel("Select Package: ");
        packageLabel.setFont(FONT);
        packageLabel.setBounds(70, 150, 250, 30);
        packageLabel.setForeground(new Color(102, 178, 255));
        add(packageLabel);
        String[] packages = {"Gold Package", "Silver Package", "Bronze Package"};
        packageChoice = new JComboBox<>(packages);
        packageChoice.setFont(FONT);
        packageChoice.setBounds(250, 150, 200, 30);
        add(packageChoice);

        JLabel totalPersonsLabel = new JLabel("Total Persons: ");
        totalPersonsLabel.setFont(FONT);
        totalPersonsLabel.setBounds(100, 200, 150, 30);
        totalPersonsLabel.setForeground(new Color(102, 178, 255));
        add(totalPersonsLabel);
        totalPersonsField = new JTextField();
        totalPersonsField.setFont(FONT);
        totalPersonsField.setBounds(250, 200, 200, 30);
        add(totalPersonsField);

        JLabel idLabel = new JLabel("ID: ");
        idLabel.setFont(FONT);
        idLabel.setBounds(100, 250, 150, 30);
        idLabel.setForeground(new Color(102, 178, 255));
        add(idLabel);
        idField = new JLabel();
        idField.setFont(FONT);
        idField.setBounds(250, 250, 200, 30);
        add(idField);

        JLabel idNumberLabel = new JLabel("ID Number: ");
        idNumberLabel.setFont(FONT);
        idNumberLabel.setBounds(100, 300, 150, 30);
        idNumberLabel.setForeground(new Color(102, 178, 255));
        add(idNumberLabel);
        idNumberField = new JLabel();
        idNumberField.setFont(FONT);
        idNumberField.setBounds(250, 300, 200, 30);
        add(idNumberField);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setFont(FONT);
        phoneLabel.setBounds(100, 350, 150, 30);
        phoneLabel.setForeground(new Color(102, 178, 255));
        add(phoneLabel);
        phoneField = new JLabel();
        phoneField.setFont(FONT);
        phoneField.setBounds(250, 350, 200, 30);
        add(phoneField);

        JLabel totalPriceLabel = new JLabel("Total Price: ");
        totalPriceLabel.setFont(FONT);
        totalPriceLabel.setBounds(100, 400, 150, 30);
        totalPriceLabel.setForeground(new Color(102, 178, 255));
        add(totalPriceLabel);
        l5 = new JLabel();
        l5.setFont(FONT);
        l5.setBounds(250, 400, 200, 30);
        add(l5);

        backButton = new JButton("Back");
        backButton.setFont(FONT);
        backButton.setBounds(100, 550, 100, 30);
        backButton.setBackground(new Color(102, 178, 255));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        checkprice = new JButton("Check Price");
        checkprice.setFont(FONT);
        checkprice.setBounds(235, 550, 190, 30);
        checkprice.setBackground(new Color(102, 178, 255));
        checkprice.setForeground(Color.WHITE);
        checkprice.addActionListener(this);
        add(checkprice);

        bookPackageButton = new JButton("Book Package");
        bookPackageButton.setFont(FONT);
        bookPackageButton.setBounds(450, 550, 180, 30);
        bookPackageButton.setBackground(new Color(102, 178, 255));
        bookPackageButton.setForeground(Color.WHITE);
        bookPackageButton.addActionListener(this);
        add(bookPackageButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/bookpack.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(570, 120, 250, 250);
        add(image);

        try {
            Conn c = new Conn();

            String q = "Select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()) {
                usernameField.setText(rs.getString("username"));
                idField.setText(rs.getString("id"));
                idNumberField.setText(rs.getString("number"));
                phoneField.setText(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            new Dashboard(username);
        } else if (ae.getSource() == checkprice) {
            String p = (String) packageChoice.getSelectedItem();
            int cost = 0;
            if (p.equals("Gold Package")) {
                cost += 32000;
            } else if (p.equals("Silver Package")) {
                cost += 25000;
            } else if (p.equals("Bronze Package")) {
                cost += 12000;
            }
            cost *= Integer.parseInt(totalPersonsField.getText());
            l5.setText("Rs " + cost);
        } else if (ae.getSource() == bookPackageButton) {
            String id = idField.getText();
            String number = idNumberField.getText();
            String phone = phoneField.getText();
            String tperson = totalPersonsField.getText();
            String price = l5.getText();
            String pack = (String) packageChoice.getSelectedItem();

            // Insert data into the database
            try {
                Conn c = new Conn();
                String query = "insert into bookpackage (username, id, number, phone, tperson, price, package) values('" + username + "','" + id + "','" + number + "','" + phone + "','" + tperson + "','" + price + "','" + pack + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                new Dashboard(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookPackage("");
    }
}
