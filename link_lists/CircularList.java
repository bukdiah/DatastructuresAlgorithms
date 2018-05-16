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
            current = newLink;
            newLink.next = current;
        }
        else
        {
            
        }
        /*
        newLink.next = current;
        current = newLink;*/
    }

    public boolean isEmpty()
    {
        return current == null;
    }

    public void displayList()
    {
        Link2 temp = current; // start at current marker
        while(temp != null)
        {
            temp.displayLink();
            current = temp.next;
        }
        System.out.println("");
    }
}