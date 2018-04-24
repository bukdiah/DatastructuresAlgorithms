class HighArray
{
    private long[] a; //ref to array a
    private int nElems; // number of data items
    public HighArray(int max)
    {
        a = new long[max]; //create array
        nElems = 0; // no items yet
    }

    public boolean find(long searchKey) // find specified value
    {
        int j;
        for(j=0; j <nElems; j++)
        {
            if(a[j] == searchKey) // found item?
                break; // exit loop before end
        }

        if (j == nElems)  // gone to end?
            return false;   // yes, cannot find it
        else
            return true;    // no, found it
    }
    public void insert(long value)
    {
        a[nElems] = value; //insert it
        nElems++;
    }
    
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++) // look for value
        {
            if(value == a[j])
                break;
        }

        if(j==nElems)   // can't find it
            return false;
        else
        {
            for(int k=j; k<nElems; k++)  // move higher ones down
            {
                a[k] = a[k+1];
            }
            nElems--; //decrement size
            return true;
        }
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
        {
            System.out.print(a[j] + " ");
        }

        System.out.println("");
    }

    // Problem 2.1
    public long getMax()
    {
        if (nElems == 0)
            return -1;

        int i;
        int currentMaxIndex = 0;

        for (i=0; i < nElems; i++ )
        {
            if (a[i] > a[currentMaxIndex])
                currentMaxIndex = i;
            else
                continue;
        }
        System.out.println("Max Value Found is " + a[currentMaxIndex]);

        long maxValue = a[currentMaxIndex];

        return maxValue;
    }

    // Problem 2.2
    public long removeMax()
    {
        long maxValue = getMax();
        System.out.println("Remove max value of " + maxValue + " from array");
        delete(maxValue);

        return maxValue;
    }

    public void noDups()
    {
        int i;
        for (i=0; i< nElems; i++)
        {
            for(int j=i+1; j < nElems; j++)
            {
                if (a[i] == a[j]) // if two values are equal
                {
                    a[j] = -1; // assign null to the duplicate
                }
            }
        }

        for(int k = 0; k < nElems; k++)
        {
            delete(-1);
        }
    }
}