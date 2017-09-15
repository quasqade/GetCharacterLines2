import common.Chapter;
import logic.Chapters;
import logic.Characters;
import common.Character;

import java.io.*;

/**
 * Created by user on 23-Jun-17.
 */
public class Main
{
public static void main (String[] args)
{
	Characters characters = new Characters();
	Chapters chapters = new Chapters();

	File file = new File("ru_dump.txt");
	String str = logic.DumpProcessor.processDump(file, Character.NAEGI, Chapter.CHAPTER1_TRIAL, true, true, 1, 1, file, true, true, 1);

	File outFile = new File("output.txt");

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





}
