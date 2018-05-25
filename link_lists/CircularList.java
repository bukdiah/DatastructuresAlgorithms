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
            newLink.next = current.next; // old current <-- new Link
            current.next = newLink; // old current --> newLink
            current = newLink; // current --> newLink
        }
    }

    public void delete()
    {
        if(!isEmpty())
        {
            long currentValue = current.dData;
            Link2 head = current.next;
            Link2 prev_current = current;
            step(); // current points to next link now
            System.out.println("Prev_current points to value "+ prev_current.dData);
            System.out.println("Current points to value: "+ current.dData);

            while(true)
            {
                if(currentValue != current.dData)
                {
                    prev_current = current;
                    step();
                }
                else
                {
                    current.next = null;
                    current = prev_current;
                    current.next = head;
                    break;
                }
            }
        }
    }

    public long deleteReturnVal()
    {
        long currentValue = current.dData;
        
        if(!isEmpty())
        {
            //long currentValue = current.dData;
            Link2 head = current.next;
            Link2 prev_current = current;
            step(); // current points to next link now
           // System.out.println("Prev_current points to value "+ prev_current.dData);
           // System.out.println("Current points to value: "+ current.dData);

            while(true)
            {
                if(currentValue != current.dData)
                {
                    prev_current = current;
                    step();
                }
                else
                {
                    current.next = null;
                    current = prev_current;
                    current.next = head;
                    break;
                }
            }
        }

        return currentValue;
    }

    public void search(long key)
    {
        if(!isEmpty())
        {
            //long currentValue = current.dData;

            while(true)
            {
                if(key == current.dData)
                {
                    System.out.println("Have FOUND item with the key " + key);
                    break;
                }
                else
                {
                    System.out.println("Searching for item with the key "+ key);
                    step();
                }
            }
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
            step();

            if(current.dData == currentValue)
                break;

        }
        System.out.println("");
   
    }

    public void step()
    {
        current = current.next;
    }
}