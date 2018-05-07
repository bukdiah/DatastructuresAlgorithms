class LinkList
{
    private Link first; // ref to first link on list

    public void LinkList()
    {
        first = null; // no items on list yet
    }

    public boolean isEmpty() // true if list is empty
    {
        return (first==null);
    }

    // insert at start of list
    public void insertFirst(int id, double dd)
    {
        Link newLink = new Link(id, dd); // make new link
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    // find link with given key; assumes non-empty list
    public Link find(int key)
    {   
        Link current = first; // start at first
        while(current.iData != key) // while no match
        {
            if(current.next == null) // if at end of list; didn't find it
                return null;
            else
                current = current.next; // go to next link
        }
        return current; // found it
    }

    public Link delete(int key)
    {
        Link current = first; // search for link
        Link previous = first;

        while(current.iData != key)
        {
            if(current.next == null)
                return null;        // did not find it
            else
            {
                previous = current; // go to next link
                current = current.next;
            }
        }   // found it

        if (current == first) // if first link
            first = first.next; // change first
        else    //otherwise,
            previous.next = current.next; // bypass it
        return current;
    }

    // delete first item: assumes list is NOT empty
    public Link deleteFirst()
    {
        Link temp = first; // save reference to link
        first = first.next; // delete it: first --> old next
        return temp;
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while(current != null)  // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }

        System.out.println("");
    }
}