class Heap
{
  private Node[] heapArray;
  private int maxSize; // size of array
  private int currentSize; // number of nodes in array

  public Heap(int mx)
  {
    maxSize = mx;
    currentSize = 0;
    heapArray = new Node[maxSize]; // create array
  }

  public boolean isEmpty()
  {
    return currentSize == 0;
  }

  public boolean insert(int key)
  {
    if(currentSize == maxSize) // if array is full
      return false; // failure
    Node newNode = new Node(key); // make a new node
    heapArray[currentSize] = newNode; // put it at the end of array
    trickleUp(currentSize++); // trickle it up
    return true; // success
  }

  public void trickleUp(int index)
  {
    int parent = (index - 1) / 2;
    Node bottom = heapArray[index];

    while(index > 0 && heapArray[parent].getKey() < bottom.getKey())
    {
      heapArray[index] = heapArray[parent]; // move node down
      index = parent; // move index up
      parent = (parent - 1) /2; // parent <- its parent
    }
    heapArray[index] = bottom;
  }

  public Node remove() // delete item with max key
  {
    Node root = heapArray[0]; // save the root
    heapArray[0] = heapArray[--currentSize]; // root <- last
    trickleDown(0); // trickle down the root
    return root; // return removed node
  }

  public void trickleDown(int index)
  {
    int largerChild;
    Node top = heapArray[index]; // save root

    while(index < currentSize/2) // while node has at least one child
    {
      int leftChild = 2*index + 1;
      int rightChild = leftChild + 1;

      // find larger child (rightChild exists?)
      if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
        largerChild = rightChild;
      else
        largerChild = leftChild;
      
        // top>=largerChild?
        if(top.getKey() >= heapArray[largerChild].getKey())
          break;
        
        // shift child up
        heapArray[index] = heapArray[largerChild];
        index = largerChild; // go down
    }
    heapArray[index] = top; // root to index
  }

  public boolean change(int index, int newValue)
  {
    if(index < 0 || index >= currentSize)
      return false;
    
      int oldValue = heapArray[index].getKey(); // remember old
      heapArray[index].setKey(newValue); // change to new

      if(oldValue < newValue) // if raised,
        trickleUp(index);     // trickle it up
      else                    // if lowered
        trickleDown(index); // trickle it down
      return true;
  }

  public void displayHeap() 
  { 
    System.out.print("heapArray: ");    
    // array format 
    for(int m=0; m<currentSize; m++) 
      if(heapArray[m] != null) 
        System.out.print( heapArray[m].getKey() + ' '); 
      else 
        System.out.print("--"); 
    System.out.println(); 
    // heap format 
    int nBlanks = 32; 
    int itemsPerRow = 1; 
    int column = 0; 
    int j = 0; // current item
    String dots = ".....................................";
    System.out.println(dots+dots); // dotted top line
    
    while(currentSize > 0)
    {
      if(column ==0) // first item in row?
        for(int k=0; k<nBlanks; k++) // preceding blanks
        {
          System.out.print(' ');
/*         // display item
          System.out.print(heapArray[j].getKey());

          if(++j == currentSize) // done?
            break;
          
          //end of row?
          if(++column ==itemsPerRow)
          {
            nBlanks /= 2; // half the blanks
            itemsPerRow *= 2; // twice the items
            column = 0; // start over on
            System.out.println(); // new row
          }
          else // next item on row
          {
            for(int i=0; i<nBlanks*2-2; i++)
              System.out.print(' ');
          }
          System.out.println(dots+dots); // dotted top line */
        }
        // display item
        System.out.print(heapArray[j].getKey());

        if(++j == currentSize) // done?
          break;
        
          //end of row?
          if(++column ==itemsPerRow)
          {
            nBlanks /= 2; // half the blanks
            itemsPerRow *= 2; // twice the items
            column = 0; // start over on
            System.out.println(); // new row
          }
          else // next item on row
          {
            for(int k=0; k<nBlanks*2-2; k++)
              System.out.print(' ');
          }
          System.out.println(dots+dots); // dotted top line 
    }
  }

  public void displayArray()
  {
    for(int j=0; j<maxSize; j++)
    {
      System.out.print(heapArray[j].getKey() + " ");
    }
    System.out.println("");
  }

  public void insertAt(int index, Node newNode)
  {
    heapArray[index] = newNode;
  }

  public void incrementSize()
  {
    currentSize++;
  }       
}
