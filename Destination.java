package toursandtravel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Destination extends JFrame implements Runnable {

    private JLabel[] labels;
    private Thread th;
    private ImageIcon[] images;
    private String[] imagePaths = {
        "toursandtravel/Image/dest1.jpeg",
        "toursandtravel/Image/dest2.png",
        "toursandtravel/Image/dest3.jpg",
        "toursandtravel/Image/dest4.jpg",
        "toursandtravel/Image/dest5.jpg",
        "toursandtravel/Image/dest6.jpg",
        "toursandtravel/Image/dest7.jpeg",
        "toursandtravel/Image/dest8.jpg",
        "toursandtravel/Image/dest9.jpg",
        "toursandtravel/Image/dest10.jpg",
        "toursandtravel/Image/dest11.jpg"
    };

    public Destination() {
        setBounds(450, 50, 900, 700);
        getContentPane().setBackground(new Color(220, 250, 250));
        
        th = new Thread(this);

        labels = new JLabel[imagePaths.length];
        images = new ImageIcon[imagePaths.length];

        for (int i = 0; i < imagePaths.length; i++) {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(imagePaths[i]);
            if (stream != null) {
                try {
                    images[i] = new ImageIcon(ImageIO.read(stream));
                    Image image = images[i].getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
                    images[i] = new ImageIcon(image);
                    labels[i] = new JLabel(images[i]);
                    labels[i].setBounds(0, 0, 900, 700);
                    add(labels[i]);
                    labels[i].setVisible(false);
                } catch (Exception e) {
                    System.out.println("Error loading image: " + imagePaths[i]);
                }
            } else {
                System.out.println("Image file not found: " + imagePaths[i]);
            }
        }

        labels[0].setVisible(true);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < labels.length; i++) {
                labels[i].setVisible(true);
                Thread.sleep(1500);
                labels[i].setVisible(false);
            }
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Destination().setVisible(true);
    }
}