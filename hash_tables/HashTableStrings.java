class HashTableStrings
{
  private DataItemStrings[] hashArray; // array holds hash table
  private int arraySize;
  private DataItemStrings nonItem; // for deleted items

  public HashTableStrings(int size)
  {
    arraySize = size;
    hashArray = new DataItemStrings[arraySize];
    nonItem = new DataItemStrings("--"); // deleted item key is --
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

  public int hashFunc(String key) {
    int hashVal = 0;
    for(int j=0; j<key.length(); j++) // left to right
    {
      int letter = key.charAt(j) - 96; // get char code
      hashVal = (hashVal * 27 + letter) % arraySize; // mod
    }
    System.out.println("Hash Value of "+key+" = "+hashVal);
    return hashVal; // no mod
  }

  // insert a DataItemStrings
  public void insert(DataItemStrings item) {
    // assumes table is not full
    String key = item.getKey(); // extract key
    int hashVal = hashFunc(key); // hash the key

    // until empty cell or -1,
    while(hashArray[hashVal] != null && !hashArray[hashVal].getKey().equals("--")) {
      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    hashArray[hashVal] = item; // insert item
  }
  
  // delete a DataItemStrings
  public DataItemStrings delete(String key) {
    int hashVal = hashFunc(key); // hash the key

    // until empty cell,
    while(hashArray[hashVal] != null) {
      // found the key?
      if(hashArray[hashVal].getKey().equals(key)) {
        DataItemStrings temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = nonItem; // delete item
        return temp;
      }

      ++hashVal; // go to next cell
      hashVal %= arraySize; // wraparound if necessary
    }
    return null; // cannot find item 
  }

  // find item with key
  public DataItemStrings find(String key) {
    int hashVal = hashFunc(key);

    while(hashArray[hashVal] != null) {
      if(hashArray[hashVal].getKey().equals(key)) {
        return hashArray[hashVal]; // found the key, so return the item
      }
      ++hashVal;
      hashVal %= arraySize;
    }
    return null; //cannot find item
  }

}