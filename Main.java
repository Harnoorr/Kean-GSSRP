import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	static Boolean updated = false;
	static Boolean running = false;
	static double value = 0;
	static double measure = 119;
	JButton b1 = new JButton("Increase");
	JButton b2 = new JButton("Decrease");
	JFrame frame = new JFrame("Caliper Program 3.0");
	JPanel objectPanel = new JPanel();
	JLabel label0 = new JLabel();
	JLabel label = new JLabel();
	
	//Increases the value of the caliper measure
	public void Increase() {
		value = value + 0.1;
		double roundOff = Math.round(value*100)/100D;
		System.out.println(roundOff + "cm");
	}
	
	//Decreases the value of the caliper measure
	public void Decrease() {
		value = value - 0.1;
		double roundOff = Math.round(value*100)/100D;
		System.out.println(roundOff + "cm");
	}
	
	//Adds buttons and panels to a pane that will be added to a frame
	public void addComponentsToPane(Container pane) {
		pane.setLayout(null);
		
		pane.add(b1);
		pane.add(b2);
		pane.add(objectPanel);
		
		//Button Dimensions
		Insets insets = pane.getInsets();
		Dimension size = b1.getPreferredSize();
		b1.setBounds(25 + insets.left, 5+ insets.top, size.width, size.height);
		size = b2.getPreferredSize();
		b2.setBounds(25 + insets.left, 40 + insets.top, size.width, size.height);
		
		//EXPERIMENTAL CODE FOR SQUARE, FEEL FREE TO IMPROVE
	    objectPanel.setBounds(100 + insets.left, 500 + insets.top, 100, 100);
	    objectPanel.setBackground(Color.YELLOW);		
	}
	
	//Updates the current values of the images and adds them to the pane
	public void Update() {
		addComponentsToPane(frame.getContentPane());
		
	    Image img0 = new ImageIcon(this.getClass().getResource("/Caliper Bottom.png")).getImage();
	    label0.setIcon(new ImageIcon(img0));
	    label0.setBounds((int) (measure + value), 115, 840, 293);
	    frame.getContentPane().add(label0);
	    
	    Image img = new ImageIcon(this.getClass().getResource("/Caliper Body.png")).getImage();
	    label.setIcon(new ImageIcon(img));
	    label.setBounds(0, 53, 840, 293);
	    frame.getContentPane().add(label);
	    
		updated = true;
	}
	
	//JFrame dimensions
	public void createGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    Insets insets = frame.getInsets();
	    frame.setSize(900 + insets.left + insets.right, 900 + insets.top
	        + insets.bottom);
	    frame.setVisible(true);
	}
	
	//Separate method to compile previous methods and add listeners to the button
	public void runProgram() {
		running = true;
		createGUI();
		Update();
		
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Increase();
				Update();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Decrease();
				Update();
			}
		});

	}
	
	//Executes runProgram() method in a separate thread
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Main GUI = new Main();
				GUI.runProgram();
				
			}
		});
		
	}

}
