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

  public int hashFunc1(int key) {
    return key % arraySize; // hash function
  }

  public int hashFunc2(int key) {
    // non-zero, less than array size, different from hashFunc1
    // array size must be relatively prime to 5,4,3, and 2
    return 5 - key % 5; // hash function
  }

  // insert a DataItem
  public void insert(int key, DataItem item) {
    // assumes table is not full
    int hashVal = hashFunc1(key); // hash the key
    int stepSize = hashFunc2(key); // get step size

    // until empty cell or -1,
    while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // wraparound if necessary
    }
    hashArray[hashVal] = item; // insert item
  }
  
  // delete a DataItem
  public DataItem delete(int key) {
    int hashVal = hashFunc(key); // hash the key
    int stepSize = hashFunc2(key); // get the step size

    // until empty cell,
    while(hashArray[hashVal] != null) {
      // found the key?
      if(hashArray[hashVal].getKey() == key) {
        DataItem temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = nonItem; // delete item
        return temp;
      }

      hashVal += stepSize; // add the step
      hashVal %= arraySize; // wraparound if necessary
    }
    return null; // cannot find item 
  }

  // find item with key
  public DataItem find(int key) {
    int hashVal = hashFunc(key);
    int stepSize = hashFunc2(key);

    while(hashArray[hashVal] != null) {
      if(hashArray[hashVal].getKey() == key) {
        return hashArray[hashVal]; // found the key, so return the item
      }
      hashVal += stepSize;
      hashVal %= arraySize;
    }
    return null; //cannot find item
  }

}