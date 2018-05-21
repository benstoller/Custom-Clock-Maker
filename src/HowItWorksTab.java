import javax.swing.*;
import java.awt.*;

/**
 * @author Ben Stoller
 *
 */
public class HowItWorksTab extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextArea text;
	JPanel layer1;

	public HowItWorksTab(int width, int height) {
		//create the internal JPanel
		layer1 = new JPanel();
		layer1.setLayout(new BoxLayout(layer1, BoxLayout.X_AXIS));
		layer1.setBorder(BorderFactory.createBevelBorder(10));
		layer1.add(Box.createHorizontalGlue());//holds the box in the middle of the screen
		
		//create the text field
		text = new JTextArea();
		text.setPreferredSize(new Dimension((int) (width * .9), (int) (height * .8)));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		text.append("The how it works tab will discuss the algorithm that makes the create"
				+ " time standard possible and possibly the source code as well.");
		
		//add the text field to the panel
		layer1.add(text);
		
		//add the panel to the ExistingTimeStandardsTab
		this.add(layer1);
	}

}
