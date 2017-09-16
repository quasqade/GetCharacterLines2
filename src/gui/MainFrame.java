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

		setMinimumSize(new Dimension(500, 600));
		setSize(new Dimension(500, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
