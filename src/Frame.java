import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public Frame() {
		//setup the frame
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Time Standard Creator");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) screenSize.getWidth(), (int) (screenSize.getHeight() * .9));
		
		//add the tabs
		JTabbedPane tabs = new JTabbedPane();
		JPanel howItWorks, existingTimeStandards, createTimeStandard, about;
		howItWorks = new HowItWorksTab(this.getWidth(), this.getHeight());
		existingTimeStandards = new ExistingTimeStandardsTab(this.getWidth(), this.getHeight());
		about = new AboutTab(this.getWidth(), this.getHeight());
		createTimeStandard = new CreateTimeStandardTab(this.getWidth(), this.getHeight());
		tabs.addTab("About and Instructions", about);
		tabs.addTab("Create Time Standard", createTimeStandard);
		tabs.addTab("Existing Time Standards", existingTimeStandards);
		this.add(tabs);
				
		this.setVisible(true);
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
