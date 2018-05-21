import javax.swing.*;
import java.awt.*;

/**
 * @author Ben Stoller
 *
 */
public class ExistingTimeStandardsTab extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextArea text;
	JPanel layer1;

	public ExistingTimeStandardsTab(int width, int height) {
		// create the internal JPanel
		layer1 = new JPanel();
		layer1.setLayout(new BoxLayout(layer1, BoxLayout.X_AXIS));
		layer1.setBorder(BorderFactory.createBevelBorder(10));
		layer1.add(Box.createHorizontalGlue());// holds the box in the middle of
												// the screen

		// create the text field
		text = new JTextArea();
		text.setPreferredSize(new Dimension((int) (width * .9), (int) (height * .9)));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.append(
				"Coordinated Universal Time- This form of time is used almost everywhere today when it comes to measuring time. The time is determined by calculating a weighted average of around 420 atomic cesium clocks all over the world. Simply put, the clock works by passing cesium atoms through an intense microwave field to get the microwave frequency to measure exactly 9,192,631,770 cycles per second. Once the microwave energy field reaches this perfect frequency, it is then divided by 9,192,631,770 to get a perfect second.\n\n");
		text.append(
				"Galactic Year – This is the most commonly used large scale time interval. The galactic year is based on the amount of time it takes the sun to orbit the Milky Way. This event is estimated to be about 220 to 250 million years.\n\n");
		text.append(
				"Decimal Time- Decimal time splits up a day into 10 decimal hours, each decimal hour into 100 decimal minutes, and each decimal minute into 100 decimal seconds. Decimal time has the benefit of simplified time conversions and representations, where it can be read from a single string of numbers. For example, 54561 would be 5 hours, 45 minutes, and 61 seconds. It was used during the French Revolution in the 1790s but was abandoned after only two years. It also existed in some form of use in ancient China. \n\n");
		text.append(
				"Dog years - According to the American Veterinary Medical Association, the first year of a dog’s life is equal to 15 years, then the second year is equal to nine years, and each year after that is equal to 5 years.\n\n");
		text.append(
				"Martian Time – Martian time is based on the planetary movements of Mars. A day, called a sol, is 24 hours, 39 minutes, and 35.2 seconds long. For potential future Mars astronauts, that means they will constantly be experiencing about 40 minutes of jet lag every day, which will surely have its negative effects. A Mars solar year is 668.59 sols.");
		text.setFont(new Font("Serif", Font.PLAIN, 29));
		// add the text field to the panel
		layer1.add(text);

		// add the panel to the ExistingTimeStandardsTab
		this.add(layer1);
	}

}
