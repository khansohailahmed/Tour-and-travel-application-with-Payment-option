package toursandtravel;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CheckPackage extends JFrame {

    public static void main(String[] args) {
        new CheckPackage().setVisible(true);
    }

    CheckPackage() {
        setBounds(550, 220, 900, 600);
        setVisible(true);
        String[] package1 = new String[]{"package1.jpg", "BRONZE PACKAGE", "6 days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Welcome drink", "Daily Buffet", "3 Island Cruise", "English Guide", "Book Now", "Summer Special", "Rs 12,000"};
        String[] package2 = new String[]{"package2.jpg", "SILVER PACKAGE", "4 days and 3 Nights", "Toll-free Tickets", "Meet and Greet", "Welcome drink", "Night Safari", "3 Island Cruise", "Cruise Dinner", "Book Now", "Winter Special", "Rs 25,000"};
        String[] package3 = new String[]{"package3.jpg", "GOLD PACKAGE", "6 days and 5 Nights", "Return Airfare", "Clubbing & Games", "Welcome drink", "Daily Buffet", "5 Star Hotel", "BBQ Dinner", "Book Now", "Winter Special", "Rs 32,000"};
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tabbedPane.addTab("Package 1", null, p1);

        JPanel p2 = createPackage(package2);
        tabbedPane.addTab("Package 2", null, p2);

        JPanel p3 = createPackage(package3);
        tabbedPane.addTab("Package 3", null, p3);

        add(tabbedPane, BorderLayout.CENTER);
    }

   public JPanel createPackage(String[] pack) {
    JPanel p1 = new JPanel();
    p1.setLayout(null);
    p1.setBackground(Color.WHITE);

    

    JLabel lblName = new JLabel(pack[1]);
    lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    lblName.setBounds(50, 5, 350, 53);
    p1.add(lblName);

    JLabel l3 = new JLabel(pack[2]);
    l3.setForeground(Color.RED);
    l3.setBounds(35, 70, 200, 14);
    p1.add(l3);

    JLabel lblId = new JLabel(pack[3]);
    lblId.setForeground(Color.BLUE);
    lblId.setBounds(35, 110, 200, 14);
    p1.add(lblId);

    JLabel l2 = new JLabel(pack[4]);
    l2.setForeground(Color.RED);
    l2.setBounds(35, 150, 200, 14);
    p1.add(l2);

    JLabel lblName_1 = new JLabel(pack[5]);
    lblName_1.setForeground(Color.BLUE);
    lblName_1.setBounds(35, 190, 200, 14);
    p1.add(lblName_1);

    JLabel lblGender = new JLabel(pack[6]);
    lblGender.setForeground(Color.RED);
    lblGender.setBounds(35, 230, 200, 14);
    p1.add(lblGender);

    JLabel lblCountry = new JLabel(pack[7]);
    lblCountry.setForeground(Color.BLUE);
    lblCountry.setBounds(35, 270, 200, 14);
    p1.add(lblCountry);

    JLabel lblReserveRoomNumber = new JLabel(pack[8]);
    lblReserveRoomNumber.setForeground(Color.RED);
    lblReserveRoomNumber.setBounds(35, 310, 200, 14);
    p1.add(lblReserveRoomNumber);

    JLabel lblCheckInStatus = new JLabel(pack[9]);
    lblCheckInStatus.setForeground(Color.BLUE);
    lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
    lblCheckInStatus.setBounds(35, 400, 200, 30);
    p1.add(lblCheckInStatus);

    JLabel lblDeposite = new JLabel(pack[10]);
    lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    lblDeposite.setBounds(35, 460, 400, 40);
    p1.add(lblDeposite);

    JLabel la1 = new JLabel(pack[11]);
    la1.setForeground(Color.RED);
    la1.setFont(new Font("Yu Mincho", Font.PLAIN, 30));
    la1.setBounds(600, 460, 400, 40);
    p1.add(la1);

    return p1;
}


}
