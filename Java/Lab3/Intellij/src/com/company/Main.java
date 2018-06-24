package com.company;

/**
 * Created by sandrapapo on 2017-09-12.
 */

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
class FaceComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        // Construct a rectangle and draw it
        Ellipse2D.Double head = new Ellipse2D.Double(50,50,100,100);
        g2.draw(head);
        Ellipse2D.Double eye1 = new Ellipse2D.Double(70,90,20,10);
        g2.draw(eye1);
        Ellipse2D.Double eye2 = new Ellipse2D.Double(110,90,20,10);
        g2.draw(eye2);
        Arc2D.Double smile = new Arc2D.Double(75, 100, 30, 30,0,-180,Arc2D.OPEN);
        g2.draw(smile);

    }
}


public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("Rosario's Face");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FaceComponent component = new FaceComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}
