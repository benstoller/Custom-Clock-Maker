import java.awt.Dimension;

import javax.swing.*;

public class TimeInterval extends JPanel implements Comparable<TimeInterval> {
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JTextField time;
	private JLabel nameLabel;
	private JLabel timeLabel;
	private JComboBox<String> intervals;
	
	public TimeInterval(int width, int height) {
		nameLabel = new JLabel("Name:");
		timeLabel = new JLabel("Time:");
		name = new JTextField(20);
		time = new JTextField(5);
		
		String[] times = {"Seconds", "Minutes", "Hours", "Days"};
		intervals = new JComboBox<String>(times);
		
		this.add(nameLabel);
		this.add(name);
		this.add(timeLabel);
		this.add(time);
		this.add(intervals);
	}
	
	public String getName() {
		return this.name.getText();
	}
	
	public double getTime() {
		String interval = (String) intervals.getSelectedItem();
		double tenthsOfASecond = Double.parseDouble(this.time.getText()) * 10;
		if (interval.equals("Minutes")) {
			tenthsOfASecond *= 60;
		} else if (interval.equals("Hours")) {
			tenthsOfASecond *= 3600;
		} else if (interval.equals("Days")) {
			tenthsOfASecond *= 86400;
		}
		
		return tenthsOfASecond;
	}
	
	public String getCurrentInterval() {
		return (String) this.intervals.getSelectedItem();
	}
	
	@Override
	public int compareTo(TimeInterval other) {
		if (this.getTime() > other.getTime()) {
			return 1;
		} else if (this.getTime() < other.getTime()) {
			return -1;
 		} else {
 			return 0;
 		}
	}
	
}
