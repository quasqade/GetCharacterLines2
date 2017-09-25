package logic;

import common.Chapter;
import common.Character;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DumpProcessor extends SwingWorker<Boolean, Integer>
{
private File inputFile;
private Character character;
private List<String> linFiles;
private boolean cleanGenerics;
private boolean ignoreGenerics;
private int contextBefore;
private int contextAfter;
private int voiceOffset;
private boolean onlyVoiced;
private int maximumSpacing;
private boolean enableContext;
private ActionListener workListener;
private File outputFile;


public DumpProcessor(ActionListener workListener, File outputFile, File inputFile, Character character, List<String> linFiles, boolean cleanGenerics, boolean ignoreGenerics, int contextBefore, int contextAfter, int voiceOffset, boolean onlyVoiced, int maximumSpacing, boolean enableContext)
{
	this.outputFile = outputFile;
	this.inputFile = inputFile;
	this.character = character;
	this.linFiles = linFiles;
	this.cleanGenerics = cleanGenerics;
	this.ignoreGenerics = ignoreGenerics;
	this.contextBefore = contextBefore;
	this.contextAfter = contextAfter;
	this.voiceOffset = voiceOffset;
	this.onlyVoiced = onlyVoiced;
	this.maximumSpacing = maximumSpacing;
	this.workListener=workListener;
	this.enableContext=enableContext;
}

private String processDump()
{
	StringBuilder sb = new StringBuilder("");
	List<String> textBlocks = new ArrayList<>();

	ChapterTree chapterTree = new ChapterTree();
	Characters characters = new Characters();

	try
	{
		//Open file for reading
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		//Read file and split in blocks
		String line;
		while ((line = br.readLine()) != null)
		{
			if (!line.equals(""))
			{
				sb.append(line);
				sb.append("\n");
			} else
			{
				textBlocks.add(sb.toString());
				sb = new StringBuilder();
			}
		}
	} catch (Exception e)
	{
		e.printStackTrace();
	}

	List<Block> blocks = new ArrayList<>();


	String currentFile = "UNKNOWN.dat";

	//Gather info about blocks and write it into a new list of Block objects
	for (String block : textBlocks)
	{
		if (block.matches("(===|\\*\\*\\*)(.|\\n)*"))
		{
			Pattern patternLin = Pattern.compile("[^ ]+\\.lin");
			Matcher matcherLin = patternLin.matcher(block);
			if (matcherLin.find())
			{
				currentFile = matcherLin.group();
			}
		} else
		{
			Block customBlock = new Block();

			customBlock.text = block;
			customBlock.linFile = currentFile;

			//Determine character
			Pattern patternChar = Pattern.compile("\\[.*\\]\\n");
			Matcher matcherChar = patternChar.matcher(block);
			while (matcherChar.find())
			{
				String s = matcherChar.group(matcherChar.groupCount());
				s = s.substring(1, s.length() - 2);
				if (characters.contains(s))
				{
					customBlock.character = characters.get(s);
					break;
				}
				customBlock.character = characters.get(s);
			}

			//Determine if voiced
			Pattern patternVoice = Pattern.compile("\\[Voice: [0-9]*.at3.*\\]\\n");
			Matcher matcherVoice = patternVoice.matcher(block);
			if (matcherVoice.find())
			{

				customBlock.isVoiced = true;
				String s = matcherVoice.group(0);


				//If voiced, determine voice ID
				Pattern patternID = Pattern.compile("[0-9]+");
				Matcher matcherID = patternID.matcher(s);
				if (matcherID.find())
				{

					customBlock.voiceFile = matcherID.group(0);
				} else
				{
					throw new InputMismatchException("Can't determine voice file for \n" + customBlock.text);
				}


				//If voiced, determine if generic voice
				Pattern patternGeneric = Pattern.compile("\\[Voice: [0-9]*.at3 \\(Generic\\)\\]\\n");
				Matcher matcherGeneric = patternGeneric.matcher(s);
				if (matcherGeneric.find())
				{
					customBlock.isGeneric = true;
				} else
				{
					customBlock.isGeneric = false;
				}
			} else
			{
				customBlock.isVoiced = false;
				customBlock.isGeneric = false;
			}
			blocks.add(customBlock);
		}
	}

	textBlocks = null; //just to help GC
	System.gc();

	//Remove Generic tag from unique generics
	if (cleanGenerics)
	{
		Set<String> genericVoiceovers = new HashSet<>();
		Set<String> genericDuplicates = new HashSet<>();
		for (Block block : blocks)
		{
			if (!genericVoiceovers.add(block.voiceFile))
			{
				genericDuplicates.add(block.voiceFile);
			}
		}

		List uniqueGenerics = new ArrayList(genericVoiceovers);
		uniqueGenerics.removeAll(genericDuplicates);


		List<Integer> uniqueGenericIDs = new ArrayList<>();

		for (int i = 0; i < blocks.size(); i++)
		{
			if (uniqueGenerics.contains(blocks.get(i).voiceFile))
			{
				uniqueGenericIDs.add(i);
			}
		}

		for (Integer id : uniqueGenericIDs)
		{
			String s = blocks.get(id).text;
			s = s.replaceAll(" \\(Generic\\)", "");
			blocks.get(id).text = s;
			blocks.get(id).isGeneric = false;
		}

	}
	blocks.size();

	//Filter output
	List<Integer> linesToDump = new ArrayList<>();
	for (Block block : blocks)
	{
		block.text = stripTxt(block.text);
		if (voiceOffset != 0)
		{
			if (block.isVoiced && block.character != Character.NAEGI)
			{
				Pattern p = Pattern.compile("([0-9]*).at3");
				Matcher matcher = p.matcher(block.text);
				if (matcher.find())
				{
					int i = Integer.parseInt(matcher.group(1));
					block.text = block.text.replaceAll(Integer.toString(i), Integer.toString(i + voiceOffset));
				}
			}
		}
		if (!block.character.equals(character) && !character.equals(Character.EVERYBODY))
		{
			continue;
		}
		boolean stop = false;
		for (String file : linFiles)
		{
			if (block.linFile.equals(file))
				stop = true;
		}
		if (!stop)
		{
			continue;
		}
		if (onlyVoiced && !block.isVoiced)
		{
			continue;
		}
		if (ignoreGenerics && block.isGeneric)
		{
			continue;
		}

		linesToDump.add(blocks.indexOf(block));
	}


	sb = new StringBuilder("");

	//Form output
	if (character.equals(Character.EVERYBODY))
	{
		for (int id : linesToDump)
		{
			sb.append(blocks.get(id).text);
		}
		return sb.toString();
	}

	for (int i = 0; i < blocks.size(); i++)
	{
		//"Smart"  block grouping for context
		if (linesToDump.contains(i))
		{
			sb.append("===================\n");
			int currentBlockPos = i;
			int noSelectedCharInARow = 0;//how many blocks have we passed without encountering a block from selected character?

			List<Integer> blockGroupIDs = new ArrayList<>();
			blockGroupIDs.add(currentBlockPos);
			if (enableContext)
			{
				//Start going backwards
				while (noSelectedCharInARow < maximumSpacing + 1)
				{
					currentBlockPos--;
					noSelectedCharInARow++;
					//if (blocks.get(currentBlockPos).character.equals(character))
					if (linesToDump.contains(currentBlockPos))
					{
						noSelectedCharInARow = 0;
					}

					blockGroupIDs.add(currentBlockPos);
				}

				blockGroupIDs.remove(new Integer(currentBlockPos));
				currentBlockPos = i;
				noSelectedCharInARow = 0;
				//Same but forwards
				while (noSelectedCharInARow < maximumSpacing + 1)
				{
					currentBlockPos++;
					noSelectedCharInARow++;
					//if (blocks.get(currentBlockPos).character.equals(character))
					if (linesToDump.contains(currentBlockPos))
					{
						noSelectedCharInARow = 0;
					}

					blockGroupIDs.add(currentBlockPos);
				}
				blockGroupIDs.remove(new Integer(currentBlockPos));
				Collections.sort(blockGroupIDs);
			}
			for (int id : blockGroupIDs)
			{
				Block block = blocks.get(id);
				if (block.character!=character)
					block.text = stripVoice(block.text);
				sb.append(block.text);
			}

			i = currentBlockPos;
		}
	}

	return sb.toString();
}

public static String stripTxt(String block)
{
	return block.replaceAll("\\[.*?.txt\\]\n", "");
}

public static String stripVoice(String block)
{
	return block.replaceAll("\\[Voice: [0-9]*.at3.*?\\]\\n", "");
}

@Override
protected Boolean doInBackground() throws Exception
{
	return writeFile(processDump());
}

private boolean writeFile(String string)
{
	try {
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outputFile), "UTF-8"));
		out.write(string);
		out.close();
	} catch (Exception e){
		e.printStackTrace();
	}
	return true;
}

@Override
protected void done()
{
workListener.actionPerformed(null);
}
}
