package toursandtravel;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    
    Thread thread;

    public Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("toursandtravel/Image/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 600);
        add(image);

        thread = new Thread(this);
        thread.start();

        setVisible(true);
    }

    public void run() {
        try {
            // Keep the splash screen visible for 7 seconds
            Thread.sleep(2000);
            
            // Close the splash screen
            setVisible(false);
            
            // Open the Signup screen
            new Signup().setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;
        for (int i = 1; i <= 500; i += 6, x += 5) {
            frame.setLocation(750 - (x + i) / 2, 400 - i / 2);
            frame.setSize(x + i, i);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
