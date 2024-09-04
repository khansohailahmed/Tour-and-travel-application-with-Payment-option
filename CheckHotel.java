package toursandtravel;

import javax.swing.*;
import java.awt.*;

public class CheckHotel extends JFrame implements Runnable {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19;
    JLabel caption;
    Thread th;

    public void run() {
        try {
            l2.setVisible(true);
            caption.setText("JW Marriott Hotel");
            Thread.sleep(2800);
            l2.setVisible(false);
            
            l3.setVisible(true);
            caption.setText("Mandarin Oriental Hotel");
            Thread.sleep(2800);
            l3.setVisible(false);
            
            l4.setVisible(true);
            caption.setText("Four Seasons Hotel");
            Thread.sleep(2800);
            l4.setVisible(false);
            
            l5.setVisible(true);
            caption.setText("Radisson Hotel");
            Thread.sleep(2800);
            l5.setVisible(false);
            
            l6.setVisible(true);
            caption.setText("Classio Hotel");
            Thread.sleep(2800);
            l6.setVisible(false);
            
            l7.setVisible(true);
            caption.setText("The Bay Club Hotel");
            Thread.sleep(2800);
            l7.setVisible(false);
            
            l8.setVisible(true);
            caption.setText("Breeze Blows Hotel");
            Thread.sleep(2800);
            l8.setVisible(false);
            
            l9.setVisible(true);
            caption.setText("Quick Stop Hotel");
            Thread.sleep(2800);
            l9.setVisible(false);
            
            l10.setVisible(true);
            caption.setText("Happy Mornings Motel");
            Thread.sleep(2800);
            l10.setVisible(false);
            
            l11.setVisible(true);
            caption.setText("Moss View Hotel");
            Thread.sleep(2800);
            l11.setVisible(false);
            
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CheckHotel() {
        setBounds(400, 50, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        
        th = new Thread(this);
    
        caption = new JLabel();
        caption.setBounds(50, 550, 1000, 70);
        caption.setForeground(Color.WHITE);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(caption);
        
        setLayout(null);

        l2 = createLabel("toursandtravel/Image/hotel1.jpg");
        l3 = createLabel("toursandtravel/Image/hotel2.jpg");
        l4 = createLabel("toursandtravel/Image/hotel3.jpg");
        l5 = createLabel("toursandtravel/Image/hotel4.jpg");
        l6 = createLabel("toursandtravel/Image/hotel5.jpg");
        l7 = createLabel("toursandtravel/Image/hotel6.jpg");
        l8 = createLabel("toursandtravel/Image/hotel7.jpg");
        l9 = createLabel("toursandtravel/Image/hotel8.jpg");
        l10 = createLabel("toursandtravel/Image/hotel9.jpg");
        l11 = createLabel("toursandtravel/Image/hotel10.jpg");

        th.start();
    }

    private JLabel createLabel(String path) {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(path));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 700);
        label.setVisible(false);
        add(label);
        return label;
    }

    public static void main(String args[]) {
        new CheckHotel().setVisible(true);
    }
}
