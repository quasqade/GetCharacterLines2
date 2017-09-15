import java.io.*;

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

	File file = new Fiple(args[0]);
	String str = logic.DumpProcessor.processDump(file, character);

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





}
