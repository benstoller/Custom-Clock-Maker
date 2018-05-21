
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

/**
 * 
 * @author Ben Stoller
 *
 */
public class CreateTimeStandardTab extends JPanel {
	private JPanel buttons;
	private JPanel mainPanel;
	private JButton addTimeInterval;
	private JButton createTimeStandard;
	private JButton decipherTimeStandard;
	private JButton remove;
	private ArrayList<TimeInterval> intervals;
	private JTextArea clock;
	private JButton editTimeStandard; 
	int clockTicker = 0;/// this is measured in 10th of seconds
	Timer t;

	public CreateTimeStandardTab(int width, int height) {
		refreshPage(width, height);
	}
	
	public void refreshPage(int width, int height) {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createBevelBorder(10));
		mainPanel.add(Box.createHorizontalGlue());

		// create the internal JPanel
		buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		buttons.setBorder(BorderFactory.createBevelBorder(10));
		buttons.add(Box.createHorizontalGlue());


		//Add Time Interval button
		intervals = new ArrayList<TimeInterval>();
		addTimeInterval = new JButton("Add Time Interval");
		addTimeInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeInterval interval = new TimeInterval(40, 40);
				intervals.add(interval);
				mainPanel.add(interval);
				revalidate();
			}
		});
		buttons.add(addTimeInterval);
		
		//Remove Time Interval Button
		remove = new JButton("Remove Time Interval");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainPanel.getComponentCount() > 2) {
					mainPanel.remove(mainPanel.getComponentCount() - 1);
					intervals.remove(intervals.size() - 1);
				}
				revalidate();
			}
		});
		buttons.add(remove);
		
		//Create Time Standard Button
		createTimeStandard = new JButton("Create Time Standard");
		createTimeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll();
				ActionListener updateClockAction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(mainPanel.getComponentCount());
						mainPanel.remove(1);
						clockTicker++;
						Collections.sort(intervals);
						Collections.reverse(intervals);
						double clockMaker = clockTicker;
						String timeText = "";
						String timeClock = "";
						for (TimeInterval interval : intervals) {
							timeText += "\n" + (int) (clockMaker / interval.getTime()) + " "+ interval.getName();
							timeClock += (int) (clockMaker / interval.getTime());
							if (!interval.equals(intervals.get(intervals.size() - 1))) {
								timeClock += ":";
							}
							clockMaker %= interval.getTime();
						}
						clock = new JTextArea(timeClock + "\n" + timeText);
						clock.setLineWrap(true);
						clock.setEditable(false);
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						//clock.setSize(screenSize);
						clock.setSize((int) (screenSize.getWidth() * .8), (int) (screenSize.getHeight() * .8));
						clock.setFont(new Font("Serif", Font.PLAIN, 40));
//						mainPanel.removeAll();
						// mainPanel.remove(mainPanel.getComponentCount() - 1);
						mainPanel.add(clock);
						

						
						
						revalidate();
					}
				};
				t = new Timer(100, updateClockAction);
				t.start();
				//
				//add button to refresh
				editTimeStandard = new JButton("Edit Time Standard");
				editTimeStandard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.stop();
						mainPanel.removeAll();
						System.out.println("sadfafd");
						revalidate();
					}
				});
				mainPanel.add(editTimeStandard);
				//add empty text area for the first remove in update clock action
				mainPanel.add(new JTextArea());
				revalidate();
			}
		});
		buttons.add(createTimeStandard);

		mainPanel.add(buttons);
		this.add(mainPanel);
	}
	
	//createEditButton
	
}
