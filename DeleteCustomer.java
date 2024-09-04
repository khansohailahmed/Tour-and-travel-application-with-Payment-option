package toursandtravel;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame {
    private JPanel contentPane;
    Choice c1;
    String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteCustomer frame = new DeleteCustomer("");
                    
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteCustomer(String username) throws SQLException {
        this.username = username;
        setBounds(580, 220, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("DELETE CUSTOMER DETAILS");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Username :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        c1 = new Choice();
        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("username"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 70, 150, 30);
        contentPane.add(c1);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        JLabel l2 = new JLabel();
        l2.setBounds(271, 110, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("Number :");
        lb2.setBounds(35, 150, 200, 14);
        contentPane.add(lb2);

        JLabel l3 = new JLabel();
        l3.setBounds(271, 150, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 190, 200, 14);
        contentPane.add(lblName_1);

        JLabel l4 = new JLabel();
        l4.setBounds(271, 190, 200, 14);
        contentPane.add(l4);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 230, 200, 14);
        contentPane.add(lblGender);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 230, 200, 14);
        contentPane.add(l5);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 270, 200, 14);
        contentPane.add(lblCountry);

        JLabel l6 = new JLabel();
        l6.setBounds(271, 270, 200, 14);
        contentPane.add(l6);

        JLabel lblReserveRoomNumber = new JLabel("Permanent Address :");
        lblReserveRoomNumber.setBounds(35, 310, 200, 14);
        contentPane.add(lblReserveRoomNumber);

        JLabel l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Phone :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        JLabel l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        contentPane.add(l8);

        JLabel lblDeposite = new JLabel("Email :");
        lblDeposite.setBounds(35, 390, 200, 14);
        contentPane.add(lblDeposite);

        JLabel l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        contentPane.add(l9);

        JButton b1 = new JButton("Check");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String username = c1.getSelectedItem();
                    ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
                    if (rs.next()) {
                        l2.setText(rs.getString("id"));
                        l3.setText(rs.getString("number"));
                        l4.setText(rs.getString("name"));
                        l5.setText(rs.getString("gender"));
                        l6.setText(rs.getString("country"));
                        l7.setText(rs.getString("address"));
                        l8.setText(rs.getString("phone"));
                        l9.setText(rs.getString("email"));
                    }
                    rs.close();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        });
        b1.setBounds(425, 70, 80, 22);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try {
                    String username = c1.getSelectedItem();

                    // Delete customer details from all relevant tables
                    String[] queries = {
                        "delete from customer where username = '" + username + "'",
                        "delete from bookHotel where username = '" + username + "'",
                        "delete from bookpackage where username = '" + username + "'"
                    };

                    for (String query : queries) {
                        c.s.executeUpdate(query);
                    }

                    JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
                    setVisible(false);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(100, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                // Optionally, you can navigate back to a previous screen, e.g., new Dashboard().setVisible(true);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
