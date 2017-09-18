package gui;

import common.Character;
import logic.ChapterTree;
import logic.Characters;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by user on 16-Sep-17.
 */
public class MainPanel extends JPanel
{
	//Logic stuff
	private ChapterTree chapterTree;

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
	private JScrollPane chapterScrollPane;
	private JCheckBoxTree chapterJTree;
	private JButton chapterConfirmButton;
	private JPanel chapterPanel;

	//Additional options
	private JCheckBox cleanGenericsCB;
	private JCheckBox outputGenericsCB;
	private JCheckBox onlyVoicedCB;
	private JCheckBox enableContext;
	private JLabel offsetLabel;
	private JSpinner offsetSpinner;
	private JButton miscBtn;
	private JPanel miscPanel;

	//Output
	private JButton outFileBtn;
	private JPanel outFilePanel;

	//parameters
	private File inputFile;


	public MainPanel()
	{
		super();

		chapterTree = new ChapterTree();

		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);

		//File input
		inputFileLabel = new JLabel("<html>Укажите путь </br> к дампу текста:</html>");
		inputFileTextField = new JTextField(15);
		inputFileTextField.setMinimumSize(new Dimension(200, 20));
		inputFileTextField.setEnabled(false);
		inputFileButton = new JButton("Open...");
		inputFileButton.setMinimumSize(new Dimension(50, 20));
		inputFileStep = new JPanel();
		//inputFileStep.setBorder(BorderFactory.createEtchedBorder());
		inputFileStep.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dump"));

		inputFileLayout();

		//Character selection
		characterLabel = new JLabel("<html>Выберите персонажа:</html>");

		characterCombobox = new JComboBox(new Characters().getCharacters().toArray());
		characterConfirmButton = new JButton("Select");
		characterPanel = new JPanel();
		//characterPanel.setBorder(BorderFactory.createEtchedBorder());
		characterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Character"));

		characterSelectionLayout();

		//Chapter selection

		chapterLabel = new JLabel("<html>Выберите главы:</html>");
		chapterScrollPane = new JScrollPane();
		chapterScrollPane.setMinimumSize(new Dimension(300, 200));
		chapterScrollPane.setPreferredSize(new Dimension(400, 300));
		chapterJTree = new JCheckBoxTree();
		chapterJTree.setModel(chapterTree.getTreeModel());
		chapterJTree.updateUI();
		chapterJTree.addCheckChangeEventListener(new JCheckBoxTree.CheckChangeEventListener()
		{
			@Override
			public void checkStateChanged(JCheckBoxTree.CheckChangeEvent event)
			{
				TreePath[] paths = chapterJTree.getCheckedPaths();
				for (TreePath tp : paths) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)tp.getLastPathComponent();
					if (node.getUserObject().getClass().equals(String.class))
					System.out.println(tp.getLastPathComponent());
				}
			}
		});
		chapterConfirmButton = new JButton("Select");
		chapterPanel = new JPanel();
		chapterPanel.setPreferredSize(new Dimension(400, 800));
		chapterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Chapters"));

		chapterSelectionLayout();

		//Additional Options
		SpinnerNumberModel offsetSpinnerModel = new SpinnerNumberModel(-15, -100, 100, 1);
		offsetSpinner = new JSpinner(offsetSpinnerModel);
		miscPanel = new JPanel();
		miscPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Additional options"));
		cleanGenericsCB = new JCheckBox("Clean Generics");
		cleanGenericsCB.setSelected(true);
		outputGenericsCB = new JCheckBox("Output Generics");
		enableContext = new JCheckBox("Enable context");
		enableContext.setSelected(true);
		onlyVoicedCB = new JCheckBox("Only voiced lines");
		onlyVoicedCB.setSelected(true);
		offsetLabel = new JLabel("Offset voice files (except Naegi):");
		miscBtn = new JButton("Confirm");

		miscLayout();

		//File output
		outFileBtn = new JButton("Output file...");
		outFilePanel = new JPanel();
		outFilePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "File output"));

		outFileLayout();

		layoutComponents();

		functionality();
	}

	private void functionality()
	{
		inputFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser inputFileChooser = new JFileChooser();
			}
		});
	}

	private void outFileLayout()
	{
		outFilePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 200;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		outFilePanel.add(outFileBtn, gbc);
	}

	private void miscLayout()
	{
		miscPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 100;
		gbc.weighty = 100;

		//First column
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(cleanGenericsCB, gbc);

		//Second column
		gbc.gridx++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(outputGenericsCB, gbc);

		//Second row
		gbc.gridx=0;
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(onlyVoicedCB, gbc);

		//Second column
		gbc.gridx++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(enableContext, gbc);

		//Third row
		gbc.gridx=0;
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(offsetLabel, gbc);

		//Second column
		gbc.gridx++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(offsetSpinner, gbc);

		//Fourth row
		gbc.gridx=0;
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		miscPanel.add(miscBtn, gbc);
	}

	private void inputFileLayout()
	{
		inputFileStep.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc.weightx = 100;

/*		//First column
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		inputFileStep.add(inputFileLabel, gbc);*/

		//Second column
		gbc.gridx=0;
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

	/*	//First column
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(5,5,5,5);

		characterPanel.add(characterLabel, gbc);
*/
		//Second column
		gbc.gridx=0;
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
	gbc.weighty = 100;

	//Second column
	gbc.gridx=0;
	gbc.weightx = 200;
	gbc.fill = GridBagConstraints.BOTH;
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.insets = new Insets(5,5,5,5);

	chapterScrollPane.getViewport().add(chapterJTree);
	chapterPanel.add(chapterScrollPane, gbc);

	//Second row
	gbc.gridx=0;
	gbc.gridy++;
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

		gbc.weighty=100;

		//First step
		gbc.gridx=0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(inputFileStep, gbc);

		//Next step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(characterPanel, gbc);

		//Next step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.weighty = 200;
		gbc.fill = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(chapterPanel, gbc);

		//Next step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.weighty=100;
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(miscPanel, gbc);

		//Next step
		gbc.gridx=0;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets=new Insets(5, 5,5,5);
		add(outFilePanel, gbc);
	}

}
