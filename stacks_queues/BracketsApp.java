import java.io.IOException;
import java.io.*;

class BracketsApp
{
    public static void main(String[] args) throws IOException
    {
        String input;
        while(true)
        {
            System.out.print("Enter the string containing delimters: ");
            System.out.flush();
            input = getString(); // read a string from keyboard

            if(input.equals(""))
            {
                break;
            }

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check(); // check brackets
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}