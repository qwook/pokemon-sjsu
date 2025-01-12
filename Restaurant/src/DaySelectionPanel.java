import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class DaySelectionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar[] days = new Calendar[7];

	private DateFormat fullDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	private DateFormat dayAndMonthFormat = new SimpleDateFormat("MM/dd");
	
	private JLabel [] dateLabels = new JLabel[7];
	private JButton[] selectionButtons = new JButton[7*13];
	private JLabel dateSelectionLabel;
	
	public DaySelectionPanel() {

		// Fill out the current displayed dates
		for (int i = 0; i < 7; i++) {
			Calendar futureDate = Calendar.getInstance();
			futureDate.add(Calendar.DATE, i);
			days[i] = futureDate;
		}
		
		this.setLayout(new GridBagLayout());
		this.setBorder(new EmptyBorder(25, 25, 25, 25));
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
				previousButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						DaySelectionPanel.this.GoToPreviousWeek();
					}
				});
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 0;
				weekSelector.add(previousButton, gbc);
	
				dateSelectionLabel = new JLabel(fullDateFormat.format(days[0].getTime()) + " � " + fullDateFormat.format(days[6].getTime()));
				dateSelectionLabel.setHorizontalAlignment(JLabel.CENTER);
				dateSelectionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
				dateSelectionLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
				dateSelectionLabel.setPreferredSize(new Dimension(300, 40));
				gbc.gridx = 1;
				gbc.gridy = 0;
				gbc.weightx = 1;
				weekSelector.add(dateSelectionLabel, gbc);
				
				JButton nextButton = new JButton("Next");
				nextButton.setFont(new Font("Arial", Font.PLAIN, 20));
				nextButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						DaySelectionPanel.this.GoToNextWeek();
					}
				});
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
			this.add(weekSelector, gbc);
			
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
					dateLabels[i-1] = new JLabel(dayAndMonthFormat.format(days[i-1].getTime()));
					dateLabels[i-1].setFont(new Font("Arial", Font.PLAIN, 12));
					dateLabels[i-1].setHorizontalAlignment(JLabel.CENTER);
					gbc.weightx = 1;
					gbc.gridx = i;
					gbc.gridy = 0;
					gbc.gridwidth = 1;
					datesGrid.add(dateLabels[i-1], gbc);
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
			this.add(datesGrid, gbc);
		}
		
	}
	
	private void GoToNextWeek() {
		for (int i = 0; i < 7; i++) {
			days[i].add(Calendar.DATE, 7);
			dateLabels[i].setText(dayAndMonthFormat.format(days[i].getTime()));
		}
		
		dateSelectionLabel.setText(fullDateFormat.format(days[0].getTime()) + " � " + fullDateFormat.format(days[6].getTime()));
	}
	
	private void GoToPreviousWeek() {
		for (int i = 0; i < 7; i++) {
			days[i].add(Calendar.DATE, 7);
			dateLabels[i].setText(dayAndMonthFormat.format(days[i].getTime()));
		}
		
		dateSelectionLabel.setText(fullDateFormat.format(days[0].getTime()) + " � " + fullDateFormat.format(days[6].getTime()));
	}
	
}
