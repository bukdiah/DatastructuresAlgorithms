class ArrayIns
{
    private long[] a;   // ref to array a
    private int nElems;  // number of data items

    public ArrayIns(int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value)  // put the element into array
    {
        a[nElems] = value;
        nElems++;
    }

    public void display()
    {
        for (int j = 0; j < nElems; j++)
        {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public void insertionSort()
    {
        int in, out;

        for(out=1; out<nElems; out++)   // out is dividing line
        {
            long temp = a[out];     // remove marked item
            in = out;               // start shifts at out

            while(in>0 && a[in-1] >= temp)  // until one is smaller,
            {
                a[in] = a[in-1];        // shift item to right
                --in;                   // go to left one position
            }
            a[in] = temp;               // insert marked item
        }
    }
    // Problem 3.5
    public void insertionSortMod()
    {
        int in, out;
        int copyCount = 0;
        int compareCount = 0;

        for(out=1; out<nElems; out++)   // out is dividing line
        {
            long temp = a[out];     // remove marked item
            copyCount++;            // count the times a copy is made
            in = out;               // start shifts at out

            while(in>0)  // until one is smaller,
            {
                if (a[in-1] >= temp)
                {
                    compareCount++;
                    a[in] = a[in-1];        // shift item to right
                    --in;                   // go to left one position
                }
                else
                {
                    compareCount++;
                    break;
                }
            }
            a[in] = temp;               // insert marked item
            copyCount++;
        }
        System.out.println("Copies: " + copyCount);
		System.out.println("Comparisons: " + compareCount);
    }

    private void swap (int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    // Problem 3.2 median() method
    public long median()
    {
        int startIndex = 0;
        int endIndex = nElems -1;

        int medianIndex = (startIndex + endIndex) /2 ;

        long median = a[medianIndex];

        return median;
    }
    // Problem 3.3
    public void noDups()
    {
        
    }
}