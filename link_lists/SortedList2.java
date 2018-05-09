class SortedList2
{
    private Link2 first; // ref to first item on list

    public SortedList2()
    {
        first = null;   // init list
    }

    public SortedList2(Link2[] linkArry)
    {
        first = null;
        for(int j=0; j<linkArry.length;j++) // copy array
        {
            //System.out.println(linkArry[j].dData);
            insert(linkArry[j]); // to list
        }
    }

    public void insert(Link2 k) // insert (in order)
    {
        Link2 previous = null; // start at first
        Link2 current = first;

        while(current != null && k.dData > current.dData)
        {                                   // or key > current,
            previous = current;
            current = current.next; // go to next item
        }

        if (previous == null)   // at beginning of the list
        {
            first = k;          // first --> k
        }
        else    // not at beginning
        {
            previous.next = k;  // old prev --> k
        }
        k.next = current;
    }

    // return and delete first link
    public Link2 remove()
    {
        Link2 temp = first; // save first
        first = first.next;     // delete first
        return temp;
    }
}