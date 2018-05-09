class FirstLastList
{
    // refs to first and last links
    private Link2 first;
    private Link2 last;

    public FirstLastList()
    {
        // no links on list yet
        first = null;
        last = null;
    }

    // true if no links
    public boolean isEmpty()
    {
        return first==null;
    }

    // insert at front of list
    public void insertFirst(long dd)
    {
        Link2 newLink = new Link2(dd);

        if(isEmpty()) // if empty list,
            last = newLink; // newLink <-- last
        newLink.next = first; // newLink --> old first
        first = newLink;    // first --> newLink
    }

    public void insertLast(long dd)
    {
        Link2 newLink = new Link2(dd);

        if(isEmpty())
            first = newLink;   // first --> newLink
        else
            last.next = newLink;    // old last --> newLink
        last = newLink;     // newLink <-- last
    }

    //delete first link
    public long deleteFirst()
    {
        long temp = first.dData;

        if(first.next ==null) // if onlly one item
            last = null;  // null <-- last
        first = first.next; // first--> old next
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link2 current = first; // start at beginning

        while(current != null) // until end of list,
        {
            current.displayLink();
            current = current.next; // move to next link
        }
        System.out.println("");
    }
}