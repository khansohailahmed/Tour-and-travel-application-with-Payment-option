package toursandtravel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPaymentDetails extends JFrame {
    private JPanel contentPane;
    private String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewPaymentDetails frame = new ViewPaymentDetails("sohail");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewPaymentDetails(String username) {
        this.username = username;
        setBounds(580, 220, 850, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("VIEW PAYMENT DETAILS");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(88, 11, 350, 53);
        contentPane.add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(35, 70, 200, 14);
        contentPane.add(lblUsername);

        JLabel l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblPaymentMethod = new JLabel("Payment Method:");
        lblPaymentMethod.setBounds(35, 110, 200, 14);
        contentPane.add(lblPaymentMethod);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setBounds(35, 150, 200, 14);
        contentPane.add(lblCardNumber);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblUpiId = new JLabel("UPI ID:");
        lblUpiId.setBounds(35, 190, 200, 14);
        contentPane.add(lblUpiId);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(35, 230, 200, 14);
        contentPane.add(lblAmount);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);
        
        

        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM payments WHERE username = '" + username + "'");
            if (rs.next()) {
                l1.setText(rs.getString("username"));
                l2.setText(rs.getString("payment_method"));
                l3.setText(rs.getString("card_number"));
                l4.setText(rs.getString("upi_id"));
                l5.setText(rs.getString("amount"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Dashboard(username);
            }
        });
        btnExit.setBounds(160, 470, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
