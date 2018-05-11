class LinkList_IT
{
    private Link2 first; // ref to first item on list

    public LinkList_IT()
    {
        first = null;   // no items on list yet
    }

    public Link2 getFirst() // get value of first
    {
        return first;
    }

    public void setFirst(Link2 f)   // set first to new link
    {
        first = f;
    }

    public boolean isEmpty()    // true if list is empty
    {
        return first == null;
    }

    public ListIterator getIterator() // return iterator
    {
        return new ListIterator(this); // initlized with this list
    }

    public void displayList()
    {
        Link2 current = first;  // start at beginning of list
        while(current !=null)   // until end of list,
        {
            current.displayLink();  // print data
            current=current.next;   // move to next link
        }

        System.out.println("");
    }
}