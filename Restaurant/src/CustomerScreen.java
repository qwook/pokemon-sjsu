import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CustomerScreen {

	public static void main(String[] args) {
		// Main Screen
		
		JFrame frame = new JFrame("Customer Screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setLayout(new GridBagLayout());
		GridBagConstraints screenPanel = new GridBagConstraints();
		screenPanel.gridx = 0;
		screenPanel.gridy = 0;
		screenPanel.fill = GridBagConstraints.BOTH;
		
		///
		
		JPanel screen1 = new JPanel();
		screen1.setLayout(new GridBagLayout());
		screen1.setBorder(new EmptyBorder(25, 25, 25, 25));
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
			screen1.add(label, gbc);
			
			JButton reserveButton = new JButton("Reserve a Table");
			reserveButton.setFont(new Font("Arial", Font.PLAIN, 20));
			reserveButton.setPreferredSize(new Dimension(0, 50));
			screen1.add(reserveButton, gbc);
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setFont(new Font("Arial", Font.PLAIN, 20));
			cancelButton.setPreferredSize(new Dimension(0, 50));
			screen1.add(cancelButton, gbc);
			
			content.add(screen1, screenPanel);
		}
		screen1.setVisible(false);
		
		///
		
		JPanel screen2 = new JPanel();
		screen2.setLayout(new GridBagLayout());
		screen2.setBorder(new EmptyBorder(25, 25, 25, 25));
		{
			// Todo: Fill this up with the second screen... lol
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = GridBagConstraints.RELATIVE;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(0,0,10,0);

			JPanel weekSelector = new JPanel();
			weekSelector.setLayout(new GridBagLayout());
			
			{
				
				JButton previousButton = new JButton("Prev");
				previousButton.setFont(new Font("Arial", Font.PLAIN, 20));
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 0;
				weekSelector.add(previousButton, gbc);
	
				JLabel dateLabel = new JLabel("<DATE> � <DATE>");
				dateLabel.setHorizontalAlignment(JLabel.CENTER);
				dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
				dateLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
				dateLabel.setPreferredSize(new Dimension(300, 40));
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.weightx = 1;
				weekSelector.add(dateLabel, gbc);
				
				JButton nextButton = new JButton("Next");
				nextButton.setFont(new Font("Arial", Font.PLAIN, 20));
				gbc.gridx = 2;
				gbc.gridy = 0;
				gbc.weightx = 0;
				gbc.gridwidth = GridBagConstraints.REMAINDER;
				weekSelector.add(nextButton, gbc);
	
			}

			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			screen2.add(weekSelector, gbc);
			
			JPanel datesGrid = new JPanel();
			datesGrid.setLayout(new GridBagLayout());

			{
				gbc.insets = new Insets(0,0,0,0);
				
				// Time Label
				JLabel timeLabel = new JLabel("Time");
				timeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
				gbc.weightx = 1;
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.gridwidth = 1;
				datesGrid.add(timeLabel, gbc);
				
				for (int i = 1; i < 8; i++) {
					JLabel label = new JLabel("10/8");
					label.setFont(new Font("Arial", Font.PLAIN, 12));
					label.setHorizontalAlignment(JLabel.CENTER);
					gbc.weightx = 1;
					gbc.gridx = i;
					gbc.gridy = 0;
					gbc.gridwidth = 1;
					datesGrid.add(label, gbc);
				}
				
				for (int y = 0; y < 13; y++) {
					// 8 AM, 9, 10, 11, 12 PM, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
					// Time
					
					// Hacky, but whatever!
					String timeString = "N/A";
					timeString = (((y + 7) % 12) + 1) + ":00 ";
					if (y+8 < 12) {
						timeString += "AM";
					} else {
						timeString += "PM";
					}
					JLabel label = new JLabel(timeString);
					label.setFont(new Font("Arial", Font.PLAIN, 12));
					gbc.weightx = 1;
					gbc.gridx = 0;
					gbc.gridy = y+1;
					gbc.gridwidth = 1;
					datesGrid.add(label, gbc);
					
					// Seats
					// i is day
					for (int i = 1; i < 8; i++) {
						JButton seatButton = new JButton("0");
						seatButton.setFont(new Font("Arial", Font.PLAIN, 12));
						seatButton.setEnabled(false);
						gbc.weightx = 1;
						gbc.gridx = i;
						gbc.gridy = y+1;
						gbc.gridwidth = 1;
						datesGrid.add(seatButton, gbc);
					}
				}
			}
			
			gbc.insets = new Insets(0,0,10,0);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridwidth = GridBagConstraints.NONE;
			screen2.add(datesGrid, gbc);

			content.add(screen2, screenPanel);
		}
		screen2.setVisible(true);
		
		///

		frame.add(content);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setVisible(true);
		frame.pack();
	}

}
