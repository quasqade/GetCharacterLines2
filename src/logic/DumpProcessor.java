package logic;

import common.Chapter;
import common.Character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DumpProcessor {
    public static String processDump(File inputFile, Character character, Chapter chapter, boolean cleanGenerics, boolean ignoreGenerics, int contextBefore, int contextAfter, boolean fixOffset, boolean onlyVoiced, int maximumSpacing)
    {
        StringBuilder sb = new StringBuilder("");
        List<String> textBlocks = new ArrayList<>();

        ChapterMap chapterMap = new ChapterMap();
        Characters characters = new Characters();
		Chapters chapters = new Chapters();

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
				while (matcherChar.find())
				{
					String s = matcherChar.group(matcherChar.groupCount());
					s = s.substring(1, s.length()-2);
					if (characters.contains(s))
					{
						customBlock.character=characters.get(s);
						break;
					}
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

		textBlocks=null; //just to help GC
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
				blocks.get(id).isGeneric=false;
			}

		}
		blocks.size();

		//Filter output
		List<Integer> linesToDump = new ArrayList<>();
		for (Block block: blocks
			 )
		{
			block.text=stripTxt(block.text);
			if (!block.character.equals(character) && !character.equals(Character.EVERYBODY))
			{
				continue;
			}
			if (!chapters.isContained(block.chapter, chapter))
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
			for (int id: linesToDump
				 )
			{
				sb.append(blocks.get(id));
			}
			return sb.toString();
		}

		for(int i = 0; i<blocks.size(); i++)
		{
			//"Smart"  block grouping for context
			if (linesToDump.contains(i))
			{
				sb.append("===================\n");
				int currentBlockPos = i;
				int noSelectedCharInARow = 0;//how many blocks have we passed without encountering a block from selected character?

				List<Integer> blockGroupIDs = new ArrayList<>();
				blockGroupIDs.add(currentBlockPos);
				//Start going backwards
				while (noSelectedCharInARow<maximumSpacing+1)
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
				currentBlockPos=i;
				noSelectedCharInARow=0;
				//Same but forwards
				while (noSelectedCharInARow<maximumSpacing)
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

				Collections.sort(blockGroupIDs);
				for (int id: blockGroupIDs
					 )
				{
					sb.append(blocks.get(id).text);
				}

				i=currentBlockPos;
			}
		}

       return sb.toString();
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
