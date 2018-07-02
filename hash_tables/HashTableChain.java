class HashTableChain
{
  private SortedListChain[] hashArray; // array of lists
  private int arraySize;
  

  public HashTableChain(int size)
  {
    arraySize = size;
    hashArray = new SortedListChain[arraySize];
    
    for(int j=0; j < arraySize; j++)
      hashArray[j] = new SortedListChain();
  }

  public void displayTable() {
    for(int j=0; j<arraySize; j++)
    {
      System.out.print(j + ". "); // display cell number
      hashArray[j].displayList(); // display list
    }
  }

  public int hashFunc(int key) {
    return key % arraySize; // hash function
  }

  // insert a LinkChain
  public void insert(LinkChain theLinkChain) {
    int key = theLinkChain.getKey();
    int hashVal = hashFunc(key); // hash the key
    hashArray[hashVal].insert(theLinkChain); // insert at hashVal
  }
  
  // delete a Link
  public void delete(int key) 
  {
    int hashVal = hashFunc(key);
    hashArray[hashVal].delete(key);
  }

  // find item with key
  public LinkChain find(int key) {
    int hashVal = hashFunc(key);
    LinkChain theLink = hashArray[hashVal].find(key); // get link
    return theLink;
  }
}