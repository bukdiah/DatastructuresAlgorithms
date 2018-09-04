class PriorityQHeap
{
  private Heap theHeap;

  public PriorityQHeap(int s)
  {
    theHeap = new Heap(s);
  }
  public void insert(int item)
  {
    theHeap.insert(item);
  } // end insert()
 

  public int remove() // remove max item
  {
      Node removed = theHeap.remove();
      return removed.getKey();
  }

  public boolean isEmpty()
  {
     return theHeap.isEmpty();
  }
  
}