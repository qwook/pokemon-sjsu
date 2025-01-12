import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomerScreen {

	public static void main(String[] args) {
		// Main Screen
		
		JFrame frame = new JFrame("Customer Screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new GridBagLayout());
		GridBagConstraints screenPanel = new GridBagConstraints();
		screenPanel.gridx = 0;
		screenPanel.gridy = 0;
		screenPanel.fill = GridBagConstraints.BOTH;
		
		///
		
		GreetingPanel screen1 = new GreetingPanel();
		wrapper.add(screen1, screenPanel);
		screen1.setVisible(false);
		
		///
		
		DaySelectionPanel screen2 = new DaySelectionPanel();
		wrapper.add(screen2, screenPanel);
		screen2.setVisible(true);
		
		///

		frame.add(wrapper);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setVisible(true);
		frame.pack();
	}

}
