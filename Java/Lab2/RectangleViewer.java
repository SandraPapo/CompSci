import java.awt.*;
import javax.swing.*;

class RectangleComponent extends JComponent {
    public void paintComponent(Graphics g) {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        // Construct a rectangle and draw it
        Rectangle box = new Rectangle(50, 70, 20, 30);
        g2.draw(box);
        // Move rectangle 15 units to the right and 25 units down
        box.translate(15, 25);
        // Draw moved rectangle
        g2.draw(box);
    }
}

/*
Create a Frame, set size, title and exit button, add a component, and make the frame visible.
*/
class RectangleViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 400);
        frame.setTitle("Two rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RectangleComponent component = new RectangleComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}