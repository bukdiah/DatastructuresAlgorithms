class PQ
{
    private Link2 first; // ref to first item on list
    
    public PQ()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insert(long key) // insert, in order, small --> big
    {
        Link2 newLink = new Link2(key); // make new link
        Link2 previous = null; // start at first
        Link2 current = first;

        while(current != null && key > current.dData) // until end of list,
        {                                   // or key > current
            previous = current;
            current = current.next;     // go to next item
        }

        if(previous == null)    // at beginning of list
            first = newLink;        // first --> newLink
        else    // not at beginning
            previous.next = newLink;    //old prev --> newLink
        newLink.next = current;         // newLink --> old current
    }
    
    public long remove()    // return & delete first link
    {
        Link2 temp = first;
        first = first.next; //delete it: first--> old next
        return temp.dData;
    }

    public long peekMin() // peek at minimum item
    {
        return first.dData;
    }

    public void displayList()
    {
        Link2 current = first; // start at beginning of list
        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}