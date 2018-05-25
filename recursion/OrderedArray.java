
class OrderedArray
{
    private long[] a;  //ref to array a
    private int nElems; // number of data items

    public OrderedArray(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size()
    {
        return nElems;
    }

    public int find(long searchKey)
    {
        return recFind(searchKey, 0, nElems-1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound)
    {
        int curIn;

        curIn = (lowerBound + upperBound) /2;

        if(a[curIn] == searchKey)
            return curIn;   // found it
        else if (lowerBound > upperBound)   
            return nElems;  // cannot find it
        else    // divide range
        {
            if(a[curIn] < searchKey)    // it's in upper half
                return recFind(searchKey, curIn+1, upperBound);
            else
                return recFind(searchKey, lowerBound, curIn-1);
        }
    }

    // Problem 2.5
    public void insert(long value) // put element into array
    {
        int lowerBound = 0;
        int upperBound = nElems -1;
        int index = 0;

        while(true)
        {
            index = (lowerBound + upperBound) / 2;

            if (nElems == 0)
                a[index] = value;
            
            if (a[index] < value)
            {
                lowerBound = index + 1; // in upper half
            }
            else
            {
                upperBound = index - 1; // in lower half
            }

            if(lowerBound > upperBound) // insertion point here
            {
                index = lowerBound;
                break;
            }

        }
  
        /*
        for(j=0; j<nElems; j++)             // find where it goes
            if(a[j] > value)             // (linear search)
                break;*/
 
        for(int k=nElems; k>index; k--)      // move bigger ones up
            a[k] = a[k-1];
        a[index] = value; // insert it
        nElems++; // increment size
    } // end insert()
    //-----------------------------------------------------------

    //-----------------------------------------------------------
    public void display()  // displays array contents
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }
    
}