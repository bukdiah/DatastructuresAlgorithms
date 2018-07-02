class SortedListChain
{
  private LinkChain first; // refer to first list item

  public void SortedListChain()
  {
    first = null;
  }
  // insert LinkChain, in order
  public void insert(LinkChain theLinkChain)
  {
    int key = theLinkChain.getKey();
    LinkChain previous = null; // start at first
    LinkChain current = first;

    // until end of list,
    while(current != null && key > current.getKey())
    {
      previous = current;
      current = current.next; // go to next item
    }

    if(previous == null) // if beginning of the list,
      first = theLinkChain; // first --> new LinkChain
    else // not at beginning
      previous.next = theLinkChain; // prev --> new LinkChain
    theLinkChain.next = current; // new LinkChain --> current
  }

  public void delete(int key)
  {
    LinkChain previous = null; // starts at first
    LinkChain current = first;

    // until end of list,
    while(current != null && key > current.getKey())
    {
      previous = current;
      current = current.next; // go to next item
    }
    // if beginning of list
    if(previous == null)
      first = first.next; // delete first LinkChain
    else
      previous.next = current.next; // delete current LinkChain
  }

  public LinkChain find(int key) // find LinkChain
  {
    LinkChain current = first; // start at first

    // until end of list, or key too small
    while(current != null && current.getKey() <= key)
    {
      if(current.getKey() == key) // is this the LinkChain
        return current; // found it, return LinkChain
      current = current.next; // go to next item
    }
    return null; // didn't find it
  }

  public void displayList()
  {
    System.out.print("List (first-->last): ");
    LinkChain current = first; // start at beginning of list
    
    while(current != null)
    {
      current.displayLink(); // print data
      current = current.next;
    }

    System.out.println("");
  }
}