
class PriorityQFastInsert
{
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQFastInsert(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }
    /*
    public void insert(long item)
    {
        int j;
        if(nItems==0)     // if no items,    
            queArray[nItems++] = item;     // insert at 0        
        else     // if items,    
        {
            for(j=nItems-1; j>=0; j--)         // start at end,        
            {
                if( item > queArray[j] )         // if new item larger,            
                    queArray[j+1] = queArray[j]; // shift upward
                else                // if smaller,            
                    break;    // done shifting                
            } 
            queArray[j+1] = item;       // insert it
            nItems++;
        } // end else (nItems > 0)
    } // end insert()
   */
    // Problem 4.4
    public void insert(long item)
    {
        //System.out.println("nItems = " + nItems);
        queArray[nItems] = item; // fast insert
        nItems++;
    }
    public long remove() // remove minimum item
    {
        //return queArray[--nItems];
        int minIndex = getMinIndex();
        System.out.println("Min Index: " + minIndex);
        long minValue = queArray[minIndex];
        System.out.println("minValue = " + minValue);

        for(int i = minIndex; i < nItems-1; i++)
        {
            queArray[i] = queArray[i+1];
        }
        nItems--;

        return minValue;
    }

    public int getMinIndex()
    {
        int minIndex = 0;
        for (int i = 0; i < nItems; i++)
        {
            //System.out.println("Index i: " + i);
            //System.out.println(queArray[minIndex] + " > " + queArray[i] + "?");
            if (queArray[minIndex] > queArray[i])
                minIndex = i;
        }

        return minIndex;
    }

    public void display()
    {
        long [] copy = queArray;
        long [] pqArray = new long[maxSize];

        for(int i=0; i < nItems; i++)
        {
            //long item = 
        }
    }
    public long peekMin() // peek at minimum item
    {
        return queArray[nItems-1];
    }

    public boolean isEmpty()
    {
        return (nItems==0); //return true if empty
    }

    public boolean isFull()
    {
        return (nItems==maxSize); // return true if full
    }
}