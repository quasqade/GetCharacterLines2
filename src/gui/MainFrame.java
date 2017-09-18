package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
	private MainPanel mainPanel;

	public MainFrame()
	{
		super("GetCharacterLines");

		setLayout(new BorderLayout());
		mainPanel = new MainPanel();

		add(mainPanel, BorderLayout.CENTER);

		setMinimumSize(new Dimension(450, 700));
		setSize(new Dimension(500, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
