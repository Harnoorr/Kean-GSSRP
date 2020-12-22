import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main{
	
	Button btn1;
	Button btn2;
	static double value = 0;
	
	/**
	 * 
	 * Creates a JComponent that includes Graphics to be 
	 * used as an argument for JPanel
	 *
	 */
	public class MyGraphics extends JComponent {
		

		private static final long serialVersionUID = 1L;

		MyGraphics(){
			setPreferredSize(new Dimension(800, 600));
		}
		
		@Override
		public void paintComponent(Graphics g) {
			g.fillRect(80,  80,  100,  100);
		}
	}
	
	
	
	/**
	 * 
	 * Creates a GUI inside a JFrame window
	 * this method is initialized in the main method
	 * 
	*/
	public void createGUI() {
		
		//Initialize JFrame
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2));
		
		//Initialize JPanel
		JPanel panel = new JPanel();
		JPanel objectPanel = new JPanel();
		JPanel caliperPanel = new JPanel();
		JButton btn1 = new JButton("Increase");
		JButton btn2 = new JButton("Decrease");
		
		//KeyListeners for Counter
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = value + 0.1;
				double roundOff = Math.round(value*100)/100D;
				System.out.println(roundOff + "cm");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = value + -0.1;
				double roundOff = Math.round(value*100)/100D;
				System.out.println(roundOff + "cm");
			}
		});
		
		
		//Adds 2 buttons to the JPanel
		panel.add(btn1);
		panel.add(btn2);
		
		/*
		//JPanel Settings
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setPreferredSize(new Dimension(100, 500));
		panel.setMaximumSize(new Dimension(100, 500));
		panel.setBorder(BorderFactory.createTitledBorder("Caliper"));
		*/
		
		//Adds JPanels to JFrame
		frame.getContentPane().add(panel);
		frame.add(caliperPanel);
		frame.getContentPane().add(objectPanel);
		frame.setSize(1920, 1080);
		frame.setVisible(true);
		frame.setTitle("Caliper Program");
		
		//Adds Graphics to objectPanel
		objectPanel.add(new MyGraphics());
		
		//Adds Caliper Image to caliperPanel
		JLabel imageLabel = new JLabel();
		imageLabel.setIcon(new ImageIcon("Insert File Path to Caliper Body"));
		caliperPanel.add(imageLabel);
		
	}
	
	
	public static void main(String[] args) {
		
		//Overrides static instance to run createGUI() in main 
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Main GUI = new Main();
				GUI.createGUI();
			}
		});
		
	}
}
