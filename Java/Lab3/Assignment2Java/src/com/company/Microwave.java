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

    }
}

/*
Create a Frame, set size, title and exit button, add a component, and make the frame visible.
*/
class Problem1 {
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