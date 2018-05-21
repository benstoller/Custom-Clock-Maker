import javax.swing.*;
import java.awt.*;

/**
 * @author Ben Stoller
 *
 */
public class AboutTab extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextArea text;
	JPanel mainPanel;

	public AboutTab(int width, int height) {
		// create the internal JPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.setBorder(BorderFactory.createBevelBorder(10));

		// create the text field
		text = new JTextArea();
		text.setPreferredSize(new Dimension((int) (width * .9), (int) (height * .8)));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.append(
				"This program takes events which occur over a specific interval of time and converts those intervals into a clock. The new clock now exists with these events replacing things likes seconds, minutes, hours, etc. For example, the average person types a character every .3 seconds. Usain Bolt ran his world record 100m dash in 9.58 seconds. It takes 12 minutes to boil an egg. So if 37 minutes and 28 seconds of time passed while this new clock was running, it would read 3 egg batches, 9 world record 100m dashes, and 5 typed characters.");
		text.append(
				"\n\nHow it works:\n1.Use the Add Time Interval button to add the desired amount of intervals you wish to use in the clock\n-The remove time interval button can be used to remove the last interval in the list.\n2.For each interval:\n\ta. Enter the name.\n\tb. Enter the length.\n\tc.Select the appropriate current time standard from the dropdown list.\n3. Click the Create Time Standard button\n*At its current stage, the program must be restarted each time to create a new time standard. This will be fixed in a future update");
		text.append(
				"\n\nAbout:\nMy name is Ben Stoller and I am a sophomore computer science student at James Madison University. This program was created for JMU’s Honors 300 It’s About Time class. I chose to pursue this project because I thought it would be intriguing to be able to visualize how different intervals of time pass, and I thought a clock would be a great way to do that. If you run into any issues with this program, please contact me at stollebh@dukes.jmu.edu. ");
		text.setFont(new Font("Serif", Font.PLAIN, 28));

		// add the text field to the panel
		mainPanel.add(text);

		// add the panel to the AboutTab
		this.add(mainPanel);
	}

}
