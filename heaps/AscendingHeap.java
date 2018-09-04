class AscendingHeap
{
  private Node[] heapArray;
  private int maxSize; // size of array
  private int currentSize; // number of nodes in array

  // node at the root is the smallest versus largest
  public AscendingHeap(int mx)
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

    while(index > 0 && heapArray[parent].getKey() > bottom.getKey())
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
    int smallerChild;
    Node top = heapArray[index]; // save root

    while(index < currentSize/2) // while node has at least one child
    {
      int leftChild = 2*index + 1;
      int rightChild = leftChild + 1;

      // find larger child (rightChild exists?)
      if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
        smallerChild = leftChild;
      else
        smallerChild = rightChild;
      
        // top>=largerChild?
        if(top.getKey() <= heapArray[smallerChild].getKey())
          break;
        
        // shift child up
        heapArray[index] = heapArray[smallerChild];
        index = smallerChild; // go down
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
		for(int m = 0; m<currentSize; m++)
			if(heapArray != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		System.out.println();
		
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "............................";
		System.out.println(dots+dots);
		
		while(currentSize > 0)
		{
			if(column == 0)
				for(int k=0; k<nBlanks; k++)
					System.out.print(' ');
			System.out.print(heapArray[j].getKey());
			if(++j == currentSize)
				break;
			
			if(++column == itemsPerRow)
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for(int k = 0; k<nBlanks*2-2; k++)
					System.out.print(' ');
		}
		System.out.println("\n"+dots+dots);
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
