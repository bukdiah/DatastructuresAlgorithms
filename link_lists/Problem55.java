import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

class Problem55
{
    public static void main(String[] args) throws IOException
    {
        CircularList theList = new CircularList();
        System.out.println("The Josephus Problem! ");
        System.out.print("Enter the number of people: ");

        int numOfPeople = getInt();
        System.out.println("");

        System.out.print("Enter the counting off number: ");

        int countOff = getInt();

        System.out.println("");
        
        System.out.print("Enter the number where counting starts: ");
        int start = getInt();
        System.out.println("");

        // populate out list
        for(int i = 1; i <= numOfPeople; i++)
        {
            theList.insert((long) i);
        }
        
        theList.displayList();
        System.out.println(theList.current.dData);
        
        System.out.println("Starting the game at position: "+ start);

        // Set starting position at "start"
        while(theList.current.dData != start)
        {
            theList.step();
        }

        while(true)
        {
            // only one person left
            if (theList.current.dData == theList.current.next.dData)
            {
                System.out.println("Winner: " + theList.deleteReturnVal());
                break;
            }

            for(int i = 0; i < countOff; i++)
            {
                theList.step();
            }

            System.out.println("Deleting: " + theList.deleteReturnVal());
            theList.step();
            
        }
        //System.out.println(theList.current.dData);
        /*
        while(true)
        {
            // set game at STARTING position

            // only one person left
            if (theList.current.dData == theList.current.next.dData)
            {
                System.out.print(theList.deleteReturnVal());
                break;
            }

            for(int i=0; i < countOff; i++)
            {
                theList.step();
            }

            System.out.print(theList.deleteReturnVal() + " ");

        }*/


        
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}