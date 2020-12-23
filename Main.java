import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	
	static double value = 0;
	
	public void addComponentsToPane(Container pane) {
	    pane.setLayout(null);
	    pane.setBackground(Color.LIGHT_GRAY);
	    
	    //Buttons 
	    JButton b1 = new JButton("Increase");
	    JButton b2 = new JButton("Decrease");
	
	    pane.add(b1);
	    pane.add(b2);
	    Insets insets = pane.getInsets();
	    Dimension size = b1.getPreferredSize();
	    b1.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
	    size = b2.getPreferredSize();
	    b2.setBounds(25 + insets.left, 40 + insets.top, size.width, size.height);
	    
	    //Action Listeners for Buttons
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = value + 0.1;
				double roundOff = Math.round(value*100)/100D;
				System.out.println(roundOff + "cm");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = value + -0.1;
				double roundOff = Math.round(value*100)/100D;
				System.out.println(roundOff + "cm");
			}
		});
		
		
		//Experimental JPanel for Cube, feel free to improve
		JPanel objectPanel = new JPanel();
	    pane.add(objectPanel);
	    objectPanel.setBounds(100 + insets.left, 500 + insets.top, 100, 100);
	    objectPanel.setBackground(Color.YELLOW);
  }

	/*
	 *Creates the GUI to be invoked from the main thread 
	 */
	private void createAndShowGUI() {
	    
	    //Create and set up the window.
	    JFrame frame = new JFrame("Caliper Program 2.01");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    //Set up the content pane.
	    addComponentsToPane(frame.getContentPane());
	
	    //Size and display the window.
	    Insets insets = frame.getInsets();
	    frame.setSize(900 + insets.left + insets.right, 900 + insets.top
	        + insets.bottom);
	    frame.setVisible(true);
	    
	    //Caliper Image 
	    JLabel label = new JLabel();
	    Image img = new ImageIcon(this.getClass().getResource("/Caliper Body.png")).getImage();
	    label.setIcon(new ImageIcon(img));
	    label.setBounds(0, 53, 840, 293);
	    frame.getContentPane().add(label);
  }

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Main GUI = new Main();
				GUI.createAndShowGUI();
			}
		});
  }
}
