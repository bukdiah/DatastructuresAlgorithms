class LinkList2
{
    private Link2 first; // ref to first item on list

    public LinkList2()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first==null);
    }

    public void insertFirst(long dd)
    {
        Link2 newLink = new Link2(dd);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    public long deleteFirst()
    {
        Link2 temp = first;
        first = first.next; //delete it: first--> old next
        return temp.dData;
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