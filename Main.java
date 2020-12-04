import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[]args) {
		
		//Creates a 800x600 Window
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setTitle("Caliper Program");
		
    //Creates an ImageIcon object called "caliper"
		ImageIcon caliper = new ImageIcon("caliper.jpg");
		Image logo = caliper.getImage();
		frame.setIconImage(logo);
		
		frame.setResizable(false);

	}
	
}
