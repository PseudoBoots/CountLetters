/*
* @author Victor Bieniek
* 11/14/17
* This class reads a given file and lists how many occurrences of each character exists in the file
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class CountLetters
{
	public static void main(String[] args)
	{
		//check if a file name is given
		if(args.length == 0)
		{
			System.out.println("Useage: java CountLetters <file>");
			System.exit(0);
		}

		try (
			DataInputStream in = new DataInputStream(new FileInputStream(new File(args[0])));
		) {
			int[] letterCounts = new int[26];
			char current;

			while(true)
			{
				try {
					current = (char)in.readByte();
					if(current >= 65 && current <= 90)
					{
						current -= 65;
						letterCounts[current]++;
					}
					else if(current >= 97 && current <= 122)
					{
						current -= 97;
						letterCounts[current]++;
					}
				} catch (EOFException e) {
					//end of file is reached
					break;
				}
			}
			for(int i = 0; i < 26; i++)
			{
				System.out.printf("%c: %d\n", i+65, letterCounts[i]);
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Invalid file name");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}