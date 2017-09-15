package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DumpProcessor {
    public static String processDump(File inputFile, Character character, Chapter chapter, boolean cleanGenerics, boolean ignoreGenerics, int contextBefore, int contextAfter, File outputFile, boolean fixOffset)
    {
        StringBuilder sb = new StringBuilder("");
        List<String> textBlocks = new ArrayList();

        ChapterMap chapterMap = new ChapterMap();
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
                }
                else
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


		Chapter currentChapter = Chapter.UNKNOWN;

		//Gather info about blocks and write it into a new list of Block objects
		//TODO parse character
		for (String block: textBlocks)
		{
			if (block.matches("(===|\\*\\*\\*)(.|\\n)*"))
			{
				Pattern patternLin = Pattern.compile("[^ ]+\\.lin");
				Matcher matcherLin = patternLin.matcher(block);
				if (matcherLin.find())
				{
					String lin = matcherLin.group();
					currentChapter = chapterMap.get(lin);
				}
			}
			else
			{
				Block customBlock = new Block();

				customBlock.text=block;
				customBlock.chapter = currentChapter;

				//Determine character
				Pattern patternChar = Pattern.compile("\\[.*\\]\\n");
				Matcher matcherChar = patternChar.matcher(block);
				if (matcherChar.find())
				{
					String s = matcherChar.group(0);
					s = s.substring(1, s.length()-2);
					customBlock.character=characters.get(s);
				}

				//Determine if voiced
				Pattern patternVoice = Pattern.compile("\\[Voice: [0-9]*.at3.*\\]\\n");
				Matcher matcherVoice = patternVoice.matcher(block);
				if (matcherVoice.find())
				{

					customBlock.isVoiced=true;
					String s = matcherVoice.group(0);


					//If voiced, determine voice ID
					Pattern patternID = Pattern.compile("[0-9]+");
					Matcher matcherID = patternID.matcher(s);
					if (matcherID.find())
					{

						customBlock.voiceFile = matcherID.group(0);
					}
					else
					{
						throw new InputMismatchException("Can't determine voice file for \n" + customBlock.text);
					}


					//If voiced, determine if generic voice
					Pattern patternGeneric = Pattern.compile("\\[Voice: [0-9]*.at3 \\(Generic\\)\\]\\n");
					Matcher matcherGeneric = patternGeneric.matcher(s);
					if (matcherGeneric.find())
					{
						customBlock.isGeneric=true;
					}
					else
					{
						customBlock.isGeneric=false;
					}
				}
				else
				{
					customBlock.isVoiced=false;
					customBlock.isGeneric=false;
				}
				blocks.add(customBlock);
			}
		}

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
				blocks.get(id).isGeneric=false;
			}

		}
		blocks.size();
       /* List<Block>toBeDeleted = new ArrayList<>();
        boolean isSequentialLine=false;
        List<String> sequentialBlocks = new ArrayList<>();
        for (Block block: blocks
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

        blocks.removeAll(toBeDeleted);*/

       /*
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
        */
       return null;
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
