package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Payment {

    private JFrame frame;
    private JTextField cardNumberField;
    private JTextField expirationDateField;
    private JTextField cvvField;
    private JLabel amountLabel; // Changed from JTextField to JLabel
    private JButton payButton;
    private JButton clearButton;
    private JTextField upiIdField;
    private JRadioButton cardRadioButton;
    private JRadioButton upiRadioButton;
    private ButtonGroup paymentMethodGroup;
    String username;

    public Payment(String username) {
        this.username = username;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Payment Gateway");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        cardRadioButton = new JRadioButton("Card");
        upiRadioButton = new JRadioButton("UPI");
        paymentMethodGroup = new ButtonGroup();
        paymentMethodGroup.add(cardRadioButton);
        paymentMethodGroup.add(upiRadioButton);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberField = new JTextField(20);

        JLabel expirationDateLabel = new JLabel("Expiration Date (MM/YY):");
        expirationDateField = new JTextField(5);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvField = new JTextField(3);

        JLabel upiIdLabel = new JLabel("UPI ID:");
        upiIdField = new JTextField(20);

        JLabel amountLabelText = new JLabel("Amount:");
        amountLabel = new JLabel(""); // Initialize as empty

        // Fetch the amount from the database
        fetchAmountForUsername();

        payButton = new JButton("Pay");
        clearButton = new JButton("Clear");

        payButton.addActionListener(new PayButtonListener());
        clearButton.addActionListener(new ClearButtonListener());

        // Adding components to the frame in a grid layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(paymentMethodLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(cardRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(upiRadioButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(cardNumberLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(cardNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(expirationDateLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(expirationDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(cvvLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        frame.add(cvvField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(upiIdLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        frame.add(upiIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(amountLabelText, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        frame.add(amountLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        frame.add(payButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        frame.add(clearButton, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 8;
        frame.add(usernameLabel, gbc);

        JLabel usernameField = new JLabel(this.username);
        usernameField.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 1;
        gbc.gridy = 8;
        frame.add(usernameField, gbc);

        frame.pack();
        frame.setVisible(true);
        frame.setBounds(150, 100, 800, 500);
    }

    private void fetchAmountForUsername() {
        // Use the Conn class to establish a connection
        Conn c = new Conn();
        String query = "SELECT cost FROM bookHotel WHERE username = ?";

        try (PreparedStatement pstmt = c.conn.prepareStatement(query)) {
            pstmt.setString(1, this.username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String amount = rs.getString("cost");
                amountLabel.setText(amount); // Set the fetched amount to the label
            } else {
                amountLabel.setText("No amount found"); // Handle case when no amount is found
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        } finally {
            try {
                c.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void storePaymentData(String paymentMethod, String cardNumber, String upiId, String amount) {
        // Use the Conn class to establish a connection
        Conn c = new Conn();
        String query = "INSERT INTO payments (username, payment_method, card_number, upi_id, amount) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.conn.prepareStatement(query)) {
            pstmt.setString(1, this.username);
            pstmt.setString(2, paymentMethod);
            pstmt.setString(3, cardNumber);
            pstmt.setString(4, upiId);
            pstmt.setString(5, amount);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        } finally {
            try {
                c.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private class PayButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String amount = amountLabel.getText(); // Now getting the amount from the label

            if (cardRadioButton.isSelected()) {
                String cardNumber = cardNumberField.getText();
                String expirationDate = expirationDateField.getText();
                String cvv = cvvField.getText();

                if (cardNumber.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty() || amount.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields");
                    return;
                }

                try {
                    Thread.sleep(1000); // Simulating payment processing delay
                    JOptionPane.showMessageDialog(frame, "Payment successful!");
                    storePaymentData("Card", cardNumber, null, amount); // Store data after successful payment
                    frame.dispose(); // Close the payment frame
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Payment failed: " + ex.getMessage());
                }

            } else if (upiRadioButton.isSelected()) {
                String upiId = upiIdField.getText();

                if (upiId.isEmpty() || amount.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields");
                    return;
                }

                try {
                    Thread.sleep(2000); // Simulating payment processing delay
                    JOptionPane.showMessageDialog(frame, "Payment successful!");
                    storePaymentData("UPI", null, upiId, amount); // Store data after successful payment
                    frame.dispose(); // Close the payment frame
                    new Dashboard(username);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(frame, "Payment failed: " + ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(frame, "Please select a payment method");
            }
        }
    }

    private class ClearButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardNumberField.setText("");
            expirationDateField.setText("");
            cvvField.setText("");
            upiIdField.setText("");
            paymentMethodGroup.clearSelection();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Payment("sohail"));
    }
}
