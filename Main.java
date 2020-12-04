import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main {
	
	/**
	 * Creates a GUI inside a JFrame window
	 * this method is initialized in the main method
	*/
	public static void createGUI() {
		
		//Initialize JFrame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		//Initialize JPanel
		JPanel panel = new JPanel();
		JButton btn1 = new JButton("Increase");
		JButton btn2 = new JButton("Decrease");
		
		//Adds 2 buttons to the JPanel
		panel.add(btn1);
		panel.add(btn2);
		
		//JPanel Settings
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setPreferredSize(new Dimension(100, 500));
		panel.setMaximumSize(new Dimension(100, 500));
		panel.setBorder(BorderFactory.createTitledBorder("Caliper"));
		
		//Adds JPanel to JFrame
		frame.getContentPane().add(panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setTitle("Caliper Program");
		
	}
	
	public static void main(String[] args) {
		
		createGUI();
		
	}
}
