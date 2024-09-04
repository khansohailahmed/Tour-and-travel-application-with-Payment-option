package toursandtravel;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t = new Thread(this);
    JProgressBar pb = new JProgressBar();
    String username;

    public void run() {
    try {
        for (int i = 1; i <= 100; i++) {
            int max = pb.getMaximum();
            int value = pb.getValue();
            if (value < max) {
                pb.setValue(pb.getValue() + 1);
            } else {
                setVisible(false);
                
                 // Pass the username to Dashboard
                 new Dashboard(username);
            }
            Thread.sleep(10);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}

public Loading(String username) {
    this.username = username;
    t = new Thread(this);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("Tour And Travel Application");
    heading.setForeground(Color.MAGENTA);
    heading.setBounds(150, 5, 700, 75);
    heading.setFont(new Font("Tahoma", Font.BOLD, 35));
    add(heading);

    pb = new JProgressBar();
    pb.setBounds(200, 90, 400, 45);
    pb.setStringPainted(true);
    add(pb);

    JLabel l1 = new JLabel("Loading, Please wait...");
    l1.setForeground(Color.BLUE);
    l1.setBounds(335, 150, 200, 35);
    l1.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(l1);

    JLabel l2 = new JLabel("Welcome " + username);
    l2.setForeground(Color.BLUE);
    l2.setBounds(50, 400, 200, 35); // Adjusted position
    l2.setFont(new Font("Tahoma", Font.BOLD, 25));
    add(l2);

    t.start();
    setBounds(300, 150, 825, 550);
    setVisible(true);
}


    public static void main(String[] args) {
        new Loading("");
    }
}
