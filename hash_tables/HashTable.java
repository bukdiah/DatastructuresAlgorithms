import java.util.*;

class HashTable
{
  private DataItem[] hashArray; // array holds hash table
  private int arraySize;
  private DataItem nonItem; // for deleted items
  private static double numItems; // number of items in hash table

  public HashTable(int size)
  {
    numItems = 0;
    arraySize = size;
    hashArray = new DataItem[arraySize];
    nonItem = new DataItem(-1); // deleted item key is -1
  }

  public void displayTable() {
    System.out.print("Table: ");
    for(int j=0; j<arraySize; j++) {
      if(hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }

  public int hashFunc(int key) {
    return key % arraySize; // hash function
  }

  // Problem 11.4 rehash() method
  public void rehash(DataItem item)
  {
    numItems = 0; // restart the count because we are ignoring deleted items
    // cleanArray contains zero deleted items (-1)
    ArrayList<DataItem> cleanArray = new ArrayList<DataItem>();

    for(int i=0; i<arraySize; i++)
    {
      // if item is not a deleted item
      if(hashArray[i] != null)
      {
        if(hashArray[i].getKey() != -1)
        {
          cleanArray.add(hashArray[i]);
          //numItems++;
        }
      }
    }

    int newSize = getPrime(arraySize*2);
    arraySize = newSize;

    hashArray = new DataItem[arraySize];
    // insert items into newly sized hash table
    for(DataItem arrayItem: cleanArray)
    {
      System.out.println("Inserting " + arrayItem.getKey() + " from old array to new array");
      insert(arrayItem); // copy old items to new hash table
    }
    insert(item); // insert new item to new hash table
  }

  private int getPrime(int min) // returns 1st prime > min
  {
    // for all j > min
    for(int j=min+1; true; j++)
    {
      if(isPrime(j)) // is j prime?
        return j; // yes, return it
    }
  }
  // is n prime?
  private boolean isPrime(int n)
  {
    for(int j=2; (j*j <=n); j++)
    {
      if(n %j == 0) // divids evenly by j?
        return false; // yes, so not prime
    }
    return true; // no, so prime;
  }

  // insert a DataItem
  public void insert(DataItem item) {
    numItems++;

    double loadFactor = numItems / arraySize;
    System.out.println(numItems + "/" + arraySize +"  = " +loadFactor);

    if(loadFactor > 0.5)
    {
      System.out.println("REHASHING!");
      rehash(item);
    }
    else
    {
      // assumes table is not full
      int key = item.getKey(); // extract key
      int hashVal = hashFunc(key); // hash the key

      // until empty cell or -1,
      while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
        ++hashVal; // go to next cell
        hashVal %= arraySize; // wraparound if necessary
      }
      hashArray[hashVal] = item; // insert item
    }
  }
  
  // delete a DataItem
  public DataItem delete(int key) {
    int hashVal = hashFunc(key); // hash the key

    // until empty cell,
    while(hashArray[hashVal] != null) {
      // found the key?
      if(hashArray[hashVal].getKey() == key) {
        DataItem temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = nonItem; // delete item
        return temp;
      }

      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    return null; // cannot find item 
  }

  // find item with key
  public DataItem find(int key) {
    int hashVal = hashFunc(key);

    while(hashArray[hashVal] != null) {
      if(hashArray[hashVal].getKey() == key) {
        return hashArray[hashVal]; // found the key, so return the item
      }
      ++hashVal;
      hashVal %= arraySize;
    }
    return null; //cannot find item
  }

}