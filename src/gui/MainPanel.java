package gui;

import common.Character;
import logic.Characters;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;

/**
 * Created by user on 16-Sep-17.
 */
public class MainPanel extends JPanel
{
	//File input
	private JButton inputFileButton;
	private JLabel inputFileLabel;
	private JTextField inputFileTextField;
	private JPanel inputFileStep;

	//Character selection
	private JLabel characterLabel;
	private JComboBox characterCombobox;
	private JButton characterConfirmButton;
	private JPanel characterPanel;

	//Chapter selection
	private JLabel chapterLabel;
	private JCheckBoxTree chapterTree;
	private JButton chapterConfirmButton;
	private JPanel chapterPanel;


	public MainPanel()
	{
		super();

		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);

		//File input
		inputFileLabel = new JLabel("<html>Укажите путь </br> к дампу текста:</html>");
		inputFileTextField = new JTextField(15);
		inputFileTextField.setMinimumSize(new Dimension(100, 30));
		inputFileTextField.setEnabled(false);
		inputFileButton = new JButton("Open...");
		inputFileStep = new JPanel();
		inputFileStep.setBorder(BorderFactory.createEtchedBorder());

		inputFileLayout();

		//Character selection
		characterLabel = new JLabel("<html>Выберите персонажа:</html>");

		characterCombobox = new JComboBox(new Characters().getCharacters().toArray());
		characterConfirmButton = new JButton("Select");
		characterPanel = new JPanel();
		characterPanel.setBorder(BorderFactory.createEtchedBorder());

		characterSelectionLayout();

		//Chapter selection

		chapterLabel = new JLabel("<html>Выберите главы:</html>");
		chapterTree = new JCheckBoxTree();
		chapterTree.addCheckChangeEventListener(new JCheckBoxTree.CheckChangeEventListener()
		{
			@Override
			public void checkStateChanged(JCheckBoxTree.CheckChangeEvent event)
			{
				TreePath[] paths = chapterTree.getCheckedPaths();
				for (TreePath tp : paths) {
					for (Object pathPart : tp.getPath()) {
						System.out.print(pathPart + ",");
					}
					System.out.println();
				}
			}
		});
		chapterConfirmButton = new JButton("Select");
		chapterPanel = new JPanel();
		chapterPanel.setBorder(BorderFactory.createEtchedBorder());

		chapterSelectionLayout();


		layoutComponents();
	}

	private void inputFileLayout()
	{
		inputFileStep.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 100;

		//First column
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		inputFileStep.add(inputFileLabel, gbc);

		//Second column
		gbc.gridx++;
		gbc.weightx = 200;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		inputFileStep.add(inputFileTextField, gbc);

		//Third column
		gbc.gridx++;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5,5,5,5);


		inputFileStep.add(inputFileButton, gbc);
	}

	private void characterSelectionLayout()
	{
		characterPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 100;

		//First column
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		characterPanel.add(characterLabel, gbc);

		//Second column
		gbc.gridx++;
		gbc.weightx = 200;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		characterPanel.add(characterCombobox, gbc);

		//Third column
		gbc.gridx++;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(5,5,5,5);


		characterPanel.add(characterConfirmButton, gbc);
	}

private void chapterSelectionLayout()
{
	chapterPanel.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();

	gbc.gridx = 0;
	gbc.gridy = 0;

	gbc.weightx = 100;

	//First column
	gbc.gridx = 0;
	gbc.fill = GridBagConstraints.NONE;
	gbc.anchor = GridBagConstraints.FIRST_LINE_START;
	gbc.insets = new Insets(5,5,5,5);

	chapterPanel.add(chapterLabel, gbc);

	//Second column
	gbc.gridx++;
	gbc.weightx = 200;
	gbc.fill = GridBagConstraints.NONE;
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets = new Insets(5,5,5,5);

	chapterPanel.add(chapterTree, gbc);

	//Third column
	gbc.gridx++;
	gbc.weightx = 100;
	gbc.fill = GridBagConstraints.NONE;
	gbc.anchor = GridBagConstraints.LINE_END;
	gbc.insets = new Insets(5,5,5,5);


	chapterPanel.add(chapterConfirmButton, gbc);
}

	public void layoutComponents()
	{
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.gridx = 0;

		gbc.weighty=1;

		//First step
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(inputFileStep, gbc);

		//Second step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(characterPanel, gbc);

		//Third step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(chapterPanel, gbc);

	}

}
