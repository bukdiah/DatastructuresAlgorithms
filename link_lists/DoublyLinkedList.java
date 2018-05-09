class DoublyLinkedList
{
    private Link3 first; // ref to first item
    private Link3 last;

    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return first==null;
    }

    public void insertFirst(long dd) // insert at front of list
    {
        Link3 newLink = new Link3(dd);

        if(isEmpty())   // if empty list
            last = newLink;
        else
            first.previous = newLink; //newLink <-- old first
        newLink.next = first;       // newLink --> old first
        first = newLink;        // first --> newLink
    }

    public void insertLast(long dd) // insert at end of list
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

    public Link3 deleteFirst() // delete first link
    {
        Link3 temp = first;
        if(first.next == null) // if only one item
            last = null;
        else
            first.next.previous = null; // null <-- old next
        first = first.next;
        return temp;
    }

    public Link3 deleteLast() // delete last link
    {
        Link3 temp = last;

        if(first.next == null)  // if only one item
            first = null;
        else
            last.previous.next = null; // old previous --> null
        last = last.previous;
        return temp;
    }

    // insert dd just after key
    public boolean insertAfter(long key, long dd)
    {
        Link3 current = first; // start at beginning

        while(current.dData != key) // until match is found,
        {
            current = current.next; // move to next link
            
            if(current == null) // didn't find it
                return false;
        }

        Link3 newLink = new Link3(dd); // make new link

        if(current==last)    // if last link
        {
            newLink.next = null;    //newLink --> null
            last = newLink;    // newLink <--last
        }
        else
        {
            newLink.next = current.next;    // newLink --> old next
            current.next.previous = newLink; // newLink <-- old next
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true;
    }

    public Link3 deleteKey(long key)    // delete item w/ given key
    {
        Link3 current = first; // start at beginning

        while(current.dData != key) // until match is found
        {
            current = current.next; // move to next link
            
            if(current == null)
                return null;
        }

        if(current==first)  // found it; first item?
            first = current.next;   // first --> old next
        else    // not first
            current.previous.next = current.next;   // old previous --> old next
        
        if(current==last)
            last = current.previous; //old previous <-- last
        else
            current.next.previous = current.previous; //old previous <-- old next
        
        return current;
    }

    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        Link3 current = first; // start at beginning

        while(current != null)
        {
            current.displayLink();
            current = current.next;
        }

        System.out.println("");
    }

    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        Link3 current = first; // start at end

        while(current != null) // until start of list
        {
            current.displayLink();
            current = current.previous;
        }

        System.out.println("");
    }
}