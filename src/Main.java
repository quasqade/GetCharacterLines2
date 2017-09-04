import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 23-Jun-17.
 */
public class Main
{
public static void main (String[] args)
{
	File characterFile = new File("character.txt");
	String character = "";
	try
	{
		BufferedReader br1 = new BufferedReader(new FileReader(characterFile));
		String line;
		while ((line = br1.readLine()) != null)
		{
			character = line;
		}
	} catch (Exception e)
	{
		e.printStackTrace();
	}
	if (character.equals(""))
		return;

	File file = new File(args[0]);
	String str = parseFile(file, character);

	File theDir = new File("./output");

// if the directory does not exist, create it
	if (!theDir.exists()) {
		System.out.println("creating directory: " + theDir.getName());
		boolean result = false;

		try{
			theDir.mkdir();
			result = true;
		}
		catch(SecurityException se){
			//handle it
		}
		if(result) {
			System.out.println("DIR created");
		}
	}
	File outFile = new File("./output/"+character+".txt");

	System.out.println(outFile.getAbsolutePath());
	try {
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(outFile), "UTF-8"));
		out.write(str);
		out.close();
	} catch (Exception e){
		e.printStackTrace();
	}

}

public static String parseFile(File file, String character)
{
	StringBuilder sb = new StringBuilder("");
	List<String> blocks = new ArrayList();

	try
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		boolean selectingStrings = false;
		while ((line = br.readLine()) != null)
		{
			if (!line.equals(""))
			{
				Pattern p = Pattern.compile("([0-9]*).at3");
				Matcher matcher = p.matcher(line);
				if (matcher.find())
				{
					int i = Integer.parseInt(matcher.group(1));
					int j = i;
					line = line.replaceAll(Integer.toString(i), Integer.toString(j));
				}
				sb.append(line);
				sb.append("\n");
			}
			else
			{
				blocks.add(sb.toString());
				sb = new StringBuilder();
			}
		}
	} catch (Exception e)
	{
		e.printStackTrace();
	}

	Set<String> genericVoiceovers = new HashSet<>();
	Set<String> genericDuplicates = new HashSet<>();

	List<String> toBeDeleted = new ArrayList<>();

	for (String block: blocks
		 )
	{
		if (block.matches("(===|\\*\\*\\*)(.|\\n)*"))
		{
			toBeDeleted.add(block);
		}
		else
		{
			Pattern p = Pattern.compile("\\[Voice: [0-9]*.at3 \\(Generic\\)\\]\\n");
			Matcher m = p.matcher(block);
			if (m.find())
			{
				String s = m.group();
				Pattern pattern = Pattern.compile("[0-9]+");
				Matcher matcher = pattern.matcher(s);
				if (matcher.find())
				{
					String voiceID = matcher.group(0);
					if (!genericVoiceovers.add(voiceID))
					{
						genericDuplicates.add(voiceID);
					}
				}
			}
		}
	}

	List uniqueGenerics = new ArrayList(genericVoiceovers);
	uniqueGenerics.removeAll(genericDuplicates);


	blocks.removeAll(toBeDeleted);

	List<Integer> uniqueGenericIDs = new ArrayList<>();

	for (int i = 0; i<blocks.size(); i++)
	{
		Pattern p = Pattern.compile("\\[Voice: [0-9]*.at3 \\(Generic\\)\\]\\n");
		Matcher m = p.matcher(blocks.get(i));
		if (m.find())
		{
			String s = m.group();
			Pattern pattern = Pattern.compile("[0-9]+");
			Matcher matcher = pattern.matcher(s);
			if (matcher.find())
			{
				String voiceID = matcher.group(0);
				if (uniqueGenerics.contains(voiceID))
				{
					uniqueGenericIDs.add(i);
				}
			}
		}
	}

	for (Integer id: uniqueGenericIDs
		 )
	{
		String s = blocks.get(id);
		s = s.replaceAll(" \\(Generic\\)", "");
		blocks.set(id, s);
	}

	toBeDeleted = new ArrayList<>();
	boolean isSequentialLine=false;
	List<String> sequentialBlocks = new ArrayList<>();
	for (String block: blocks
		 )
	{
		if (isCharacterBlock(block, character))
		{
			if (!isSequentialLine)
			{
				sequentialBlocks=new ArrayList<>();
				isSequentialLine=true;
				sequentialBlocks.add(block);
			}
			else
			{
				sequentialBlocks.add(block);
			}
		}
		else
		{
			if (isSequentialLine)
			{
				isSequentialLine=false;
				StringBuilder seqSB = new StringBuilder();
				for (String sequentialBlock: sequentialBlocks
					 )
				{
					seqSB.append(sequentialBlock);
				}
				if (sequentialBlocks.size()>1)
				{
					toBeDeleted.addAll(sequentialBlocks);
					blocks.set(blocks.indexOf(block) - 1, seqSB.toString());
				}
			}
		}
	}

	blocks.removeAll(toBeDeleted);

	List<String> output = new ArrayList<String>();
	for (String block: blocks
		 )
	{

		if (isCharacterBlock(block, character))
		{

			if (blocks.indexOf(block)>1)
			{
				if(!toBeDeleted.contains(blocks.get(blocks.indexOf(block)-2)))
					output.add(blocks.get(blocks.indexOf(block)-2));
			}
if (blocks.indexOf(block)>0)
{
	if(!toBeDeleted.contains(blocks.get(blocks.indexOf(block)-1)))
	output.add(blocks.get(blocks.indexOf(block)-1));
}
output.add("\n********************\n");
output.add(block);
output.add("********************\n\n");
if (blocks.indexOf(block)!=blocks.size()-1)
{
	if(!toBeDeleted.contains(blocks.get(blocks.indexOf(block)+1)))
	output.add(blocks.get(blocks.indexOf(block)+1));
}
output.add("------------------------------------------------------------\n");
		}
	}

	sb = new StringBuilder();

	for (String outblock: output
		 )
	{
		String outblockStripped = outblock;
		if (!isCharacterBlock(outblock, character))
		{
			outblockStripped = stripVoice(outblockStripped);
		}
		outblockStripped = stripTxt(outblockStripped);
		sb.append(outblockStripped);
	}

return sb.toString();
}

public static boolean isCharacterBlock(String block, String character)
{
	Matcher m = Pattern.compile("(\\[" + character + "\\])(\\n)(\\[Voice: [0-9]*.at3.*?\\])").matcher(block);
	return m.find();
}


public static String stripTxt(String block)
{
return block.replaceAll("\\[.*?.txt\\]\n","");
}

public static String stripVoice(String block)
{
return block.replaceAll("\\[Voice: [0-9]*.at3.*?\\]\\n","");
}
}
