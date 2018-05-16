class DQ
{
    private Link3 first; // ref to first item
    private Link3 last;
    public DQ()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return first==null;
    }

    public void insertLeft(long dd)
    {
        Link3 newLink = new Link3(dd);
        
        if(isEmpty())   // if empty list
            last = newLink;
        else
            first.previous = newLink; //newLink <-- old first
        newLink.next = first;       // newLink --> old first
        first = newLink;        // first --> newLink
    }

    public void insertRight(long dd)
    {
        Link3 newLink = new Link3(dd);
        
        if(isEmpty())
            first = newLink;    // first-->newLink
        else
        {
            last.next = newLink;    //old last --> newLink
            newLink.previous = last;    // old last <-- newLink
        }
        last = newLink;     //newLink <-- last
    }

    public long removeLeft()
    {
        Link3 temp = first;
        if(first.next == null) // if only one item
            last = null;
        else
            first.next.previous = null; // null <-- old next
        first = first.next;
        return temp.dData;
    }

    public long removeRight()
    {
        Link3 temp = last;
        
        if(first.next == null)  // if only one item
            first = null;
        else
            last.previous.next = null; // old previous --> null
        last = last.previous;
        return temp.dData;
    }

    public void print()
    {
        //System.out.print("List (first-->last): ");
        Link3 current = first; // start at beginning

        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }
}