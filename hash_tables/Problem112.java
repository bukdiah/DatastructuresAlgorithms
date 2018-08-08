import java.io.*;
class Problem112
{
  public static void main(String[] args) throws IOException
  {
    DataItemStrings aDataItem;
    String aKey; 
    int number;
    int size, n, keysPerCell;

    //get sizes
    System.out.print("Enter size of hash table: ");
    size = getInt();
    System.out.print("Etner intial number of items: ");
    n = getInt();
    keysPerCell = 10;

    // make table
    HashTableStrings theHashTable = new HashTableStrings(size);

    // insert data
    /*
    for(int j=0; j<n; j++) {
      number = (int)(java.lang.Math.random() * keysPerCell * size);
      aDataItem = new DataItemStrings("POOP"+number);
      theHashTable.insert(aDataItem);
    }*/

    // interact with user
    while(true) {
      System.out.print("Enter first letter of ");
      System.out.print("show, insert, delete, or find: ");
      char choice = getChar();

      switch(choice)
      {
        case 's':
          theHashTable.displayTable();
          break;
        case 'i':
          System.out.print("Enter key value to insert: ");
          aKey = getString();
          aDataItem = new DataItemStrings(aKey);
          theHashTable.insert(aDataItem);
          break;
        case 'd':
          System.out.print("Enter key value to delete: ");
          aKey = getString();
          theHashTable.delete(aKey);
          break;
        case 'f':
          System.out.print("Enter key value to find: ");
          aKey = getString();
          aDataItem = theHashTable.find(aKey);

          if(aDataItem != null)
            System.out.println("Found " + aKey);
          else
            System.out.println("Could not find " + aKey);
          break;
        default:
          System.out.print("Invalid entry\n");
      }
    }
  }

  public static String getString() throws IOException { 
    InputStreamReader isr = new InputStreamReader(System.in); 
    BufferedReader br = new BufferedReader(isr); 
    String s = br.readLine(); 
    return s; 
  }

  public static char getChar() throws IOException { 
    String s = getString(); 
    return s.charAt(0); 
  } 

  public static int getInt() throws IOException { 
    String s = getString(); 
    return Integer.parseInt(s); 
  } 
}