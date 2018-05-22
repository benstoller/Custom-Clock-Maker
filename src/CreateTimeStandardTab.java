
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
	//private JButton decipherTimeStandard;
	private JTextArea clock;
	private JButton editTimeStandard;
	private JButton createNewStandard;
	int clockTicker = 0;/// this is measured in 10th of seconds
	Timer t;
	private int width;
	private int height;

	public CreateTimeStandardTab(int width, int height) {
		this.width = width;
		this.height = height;
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

		// Add Time Interval button
		addTimeInterval = new JButton("Add Time Interval");
		addTimeInterval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeInterval interval = new TimeInterval(40, 40);
				mainPanel.add(interval);
				revalidate();
			}
		});
		buttons.add(addTimeInterval);

//		// Remove Time Interval Button
//		remove = new JButton("Remove Time Interval");
//		remove.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (mainPanel.getComponentCount() > 2) {
//					mainPanel.remove(mainPanel.getComponentCount() - 1);
//				}
//				revalidate();
//			}
//		});
//		buttons.add(remove);

		// Create Time Standard Button
		createTimeStandard = new JButton("Create Time Standard");
		createTimeStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TimeInterval> intervals = new ArrayList<TimeInterval>();
				// add all intervals from the main panel
				for (int i = 0; i < mainPanel.getComponentCount(); i++) {
					if (mainPanel.getComponent(i) instanceof TimeInterval) {
						TimeInterval curInterval = (TimeInterval) mainPanel.getComponent(i);
						intervals.add(curInterval);
					}
				}

				mainPanel.removeAll();
				ActionListener updateClockAction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						mainPanel.remove(1);
						clockTicker++;
						Collections.sort(intervals);
						Collections.reverse(intervals);
						double clockMaker = clockTicker;
						String timeText = "";
						String timeClock = "";
						for (TimeInterval interval : intervals) {
							timeText += "\n" + (int) (clockMaker / interval.getTime()) + " " + interval.getName();
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
						clock.setSize((int) (screenSize.getWidth() * .8), (int) (screenSize.getHeight() * .8));
						clock.setFont(new Font("Serif", Font.PLAIN, 40));
						mainPanel.add(clock);

						revalidate();
					}
				};
				t = new Timer(100, updateClockAction);
				t.start();

				// add button to edit current time standard
				editTimeStandard = new JButton("Edit Time Standard");
				editTimeStandard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.stop();
						mainPanel.removeAll();
						clockTicker = 0;
						refreshPage(width, height);
						for (TimeInterval interval : intervals) {
							mainPanel.add(interval);
						}
						revalidate();
					}
				});

				// add button to create new time standard
				createNewStandard = new JButton("Create New Time Standard");
				createNewStandard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.stop();
						mainPanel.removeAll();
						clockTicker = 0;
						intervals.clear();
						refreshPage(width, height);
						revalidate();
					}
				});

				JPanel clockButtons = new JPanel();
				clockButtons.add(editTimeStandard);
				clockButtons.add(createNewStandard);
				mainPanel.add(clockButtons);

				// add empty text area for the first remove in update clock
				// action
				mainPanel.add(new JTextArea());
				revalidate();
			}
		});
		buttons.add(createTimeStandard);

		mainPanel.add(buttons);
		this.add(mainPanel);
		this.setVisible(true);
	}

}