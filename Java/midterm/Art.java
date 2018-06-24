import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;



class Background{

	private int frameWidth;
	private int frameHeight;
	
	public Background(int frameWidth, int frameHeight){
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}

	public void drawCheckerBoardPattern(Graphics2D g2){
		g2.setColor(Color.GREEN);
		Rectangle myBox = new Rectangle(0 , 0, 5, 5);
		for(int i = 0; i < frameHeight/5 ;i++){


			for (int j = 0; j < frameWidth/5; j++) {
				g2.draw(myBox);

				if(i % 2 == 0 && j % 2 == 0)
					g2.fill(myBox);
				if(i % 2 != 0 && j % 2 != 0)
					g2.fill(myBox);

				myBox.translate(5,0);
			}
			
			g2.draw(myBox);
			myBox.translate(0,5);
			myBox.translate(-1*frameWidth,0);
		}
	}

	public void rosario(Graphics2D g2){

		Ellipse2D.Double circle = new Ellipse2D.Double(frameWidth/2 - 40 , frameHeight/2 - 50, 80, 100);
		g2.setColor(Color.WHITE);
		g2.fill(circle);
		g2.setColor(Color.BLACK);
		g2.draw(circle);
		
		circle.setFrame(frameWidth/2 - 20 , frameHeight/2 - 5, 10, 10);
		g2.fill(circle);
		circle.setFrame(frameWidth/2 + 10 , frameHeight/2 - 5, 10, 10);
		g2.fill(circle);

		Line2D.Double smile = new Line2D.Double(frameWidth/2 - 20,frameHeight/2 + 20,frameWidth/2 + 20,frameHeight/2 + 20);
		g2.draw(smile);

		g2.setColor(Color.RED);
		Arc2D.Double hat = new Arc2D.Double(frameWidth/2 - 45,frameHeight/2 - 60,90,100,0,180,Arc2D.OPEN);
		g2.fill(hat);

		g2.setColor(Color.WHITE);
		circle.setFrame(frameWidth/2 - 20 , frameHeight/2 - 90, 40, 40);
		g2.fill(circle);
		g2.setColor(Color.BLACK);
		g2.draw(circle);
	}

}

class BoxPatternBackground extends JComponent{
	
	private int frameWidth;
	private int frameHeight;
	
	public BoxPatternBackground(int frameWidth, int frameHeight){
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
	}



	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g; // casting graphics format over to graphics2d format
		Background myBackground = new Background(frameWidth,frameHeight);
		myBackground.drawCheckerBoardPattern(g2);
		myBackground.rosario(g2);

	}
}

public class Art{
	public static void main(String[] args){
		int width = 500, height = 500;
		JFrame myFrame = new JFrame();
		myFrame.setSize(width, height);
		myFrame.setTitle("My Drawing");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BoxPatternBackground drawing = new BoxPatternBackground(width,height);
		myFrame.add(drawing);
		myFrame.setVisible(true);

	}
}
