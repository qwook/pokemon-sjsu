import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GreetingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GreetingPanel() {

		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(25, 25, 25, 25));
		{
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(0,0,10,0);
	
			
			JLabel label = new JLabel("Welcome to My Restaurant");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(new Font("Arial", Font.BOLD, 24));
			label.setBorder(new EmptyBorder(0, 0, 50, 0));
			this.add(label, gbc);
			
			JButton reserveButton = new JButton("Reserve a Table");
			reserveButton.setFont(new Font("Arial", Font.PLAIN, 20));
			reserveButton.setPreferredSize(new Dimension(0, 50));
			this.add(reserveButton, gbc);
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setFont(new Font("Arial", Font.PLAIN, 20));
			cancelButton.setPreferredSize(new Dimension(0, 50));
			this.add(cancelButton, gbc);
		}
		
	}

}
