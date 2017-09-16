import common.Chapter;
import gui.MainFrame;
import logic.Chapters;
import logic.Characters;
import common.Character;

import javax.swing.*;
import java.io.*;

/**
 * Created by user on 23-Jun-17.
 */
public class Main
{
public static void main (String[] args)
{

	Characters characters = new Characters();

	SwingUtilities.invokeLater(new Runnable()
	{
		@Override
		public void run()
		{
			new MainFrame();
		}
	});

	File file = new File("ru_dump.txt");
	String str = logic.DumpProcessor.processDump(file, Character.NAEGI, Chapter.CHAPTER1, true, true, 1, 1, true, true, 1);

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
