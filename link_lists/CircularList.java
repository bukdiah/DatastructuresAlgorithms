class CircularList
{
    Link2 current;

    public CircularList()
    {
        current = null;
    }

    public void insert(long dd)
    {
  
        Link2 newLink = new Link2(dd);
        if(isEmpty())
        {
            current = newLink;      // current --> newLink
            newLink.next = current; // current <-- newLink
        }
        else
        {
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        }
    }

    public boolean isEmpty()
    {
        return current == null;
    }

    public void displayList()
    {
        long currentValue = current.dData;

        while(true)
        {
            current.displayLink();
            current = current.next;

        }
   
    }
}