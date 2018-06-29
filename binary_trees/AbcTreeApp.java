import java.io.*;
import java.util.*;

class AbcTreeApp
{
	public static void main(String[] args) throws IOException
	{
		int value;
		String initString = "ABCDEFG";
		AbcTree theTree = new AbcTree(initString);
		
		while(true)
		{
			System.out.print("Enter first letter of show"
					+ " or traverse: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.print("Enter type 1, 2, or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry!\n");
			} // end switch
		} // end while
	} // end main()
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
}