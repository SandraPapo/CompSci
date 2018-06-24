/*
Sandra Papo
Problem1.java

October 16, 2017

Assignment 2
This is the answer to the first question.
*/

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

class TrafficLights extends JComponent {

    private int frameWidth;
    private int frameHeight;

    public TrafficLights(int frameWidth, int frameHeight){
        this.frameWidth =frameWidth;
        this.frameHeight = frameHeight;
    }
   

    public void paintComponent(Graphics g) {
        // Recover Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        // Construct a rectangle and draw it

        Rectangle2D.Double box = new Rectangle2D.Double(20 , frameHeight/2 - 35 - 30,50,130);
        g2.draw(box);

        Ellipse2D.Double circleRed = new Ellipse2D.Double(30,frameHeight/2 - 15 - 40,30,30);
        g2.setColor(Color.RED);
        g2.fill(circleRed);
        g2.setColor(Color.BLACK);
        g2.draw(circleRed);

        Ellipse2D.Double circleYellow = new Ellipse2D.Double(30,frameHeight/2 - 15,30,30);
        g2.draw(circleYellow);

        Ellipse2D.Double circleGreen = new Ellipse2D.Double(30,frameHeight/2 - 15 + 40,30,30);
        g2.draw(circleGreen);

        
        Rectangle2D.Double box2 = new Rectangle2D.Double(frameWidth/2 - 15 - 10, frameHeight/2 - 35 - 30,50,130);
        g2.draw(box2);

        Ellipse2D.Double circle2Red = new Ellipse2D.Double(frameWidth/2 - 15,frameHeight/2 - 15 - 40,30,30);
        g2.draw(circle2Red);

        Ellipse2D.Double circle2Yellow = new Ellipse2D.Double(frameWidth/2 - 15,frameHeight/2 - 15,30,30);
        g2.setColor(Color.YELLOW);
        g2.fill(circle2Yellow);
        g2.setColor(Color.BLACK);
        g2.draw(circle2Yellow);

        Ellipse2D.Double circle2Green = new Ellipse2D.Double(frameWidth/2 - 15,frameHeight/2 - 15 + 40,30,30);
        g2.draw(circle2Green);


        Rectangle2D.Double box3 = new Rectangle2D.Double(frameWidth - 30 - 30 -10 , frameHeight/2 - 35 - 30,50,130);
        g2.draw(box3);

        Ellipse2D.Double circle3Red = new Ellipse2D.Double(frameWidth - 30 - 30,frameHeight/2 - 15 - 40,30,30);
        g2.draw(circle3Red);

        Ellipse2D.Double circle3Yellow = new Ellipse2D.Double(frameWidth - 30 - 30,frameHeight/2 - 15,30,30);
        g2.draw(circle3Yellow);

        Ellipse2D.Double circle3Green = new Ellipse2D.Double(frameWidth - 30 - 30,frameHeight/2 - 15 +40,30,30);
        g2.setColor(Color.GREEN);
        g2.fill(circle3Green);
        g2.setColor(Color.BLACK);
        g2.draw(circle3Green);





    }
}

/*
Create a Frame, set size, title and exit button, add a component, and make the frame visible.
*/
class Problem1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setTitle("Three Traffic Lights");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TrafficLights component = new TrafficLights(400,500);
        frame.add(component);
        frame.setVisible(true);
    }
}