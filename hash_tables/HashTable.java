class HashTable
{
  private DataItem[] hashArray; // array holds hash table
  private int arraySize;
  private DataItem nonItem; // for deleted items

  public HashTable(int size)
  {
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

  // insert a DataItem
  public void insert(DataItem item) {
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