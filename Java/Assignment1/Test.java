/*
Author: Sandra Papo
Date: 09/27/2017

The code implemented solves the following question: 


Type in the following program. Then, using the Jave API Documentation on Internet, try to complete
the first two lines of the code. Then try to run the program and fix any compile-time errors you find in it.
After the successful run, modify it to show a different greeting and image.
import java.net. ...;
import javax. ...;
import javax.swing.ImageIcon;
public Class Test
public Static main(String[] args) throws Exception {
URL imageLocation = new URL(
“http://horstmann.com/java4everyone/duke.gif”);
JOptionPane.showMessageDialog(null, “Hello”, “Title”,
JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation))
}
*/

import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Test{
	public static void main(String[] args) throws Exception {
		URL imageLocation = new URL("https://68.media.tumblr.com/avatar_bfdd754bb5fb_128.png");
		JOptionPane.showMessageDialog(null, "Have a Good Day!", "Sandra's Assignment", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
	}
}