import common.Chapter;
import gui.MainFrame;
import logic.Characters;
import common.Character;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

/**
 * Created by user on 23-Jun-17.
 */
public class Main
{
public static void main (String[] args)
{
	SwingUtilities.invokeLater(new Runnable()
	{
		@Override
		public void run()
		{
			new MainFrame();
		}
	});
}
}
