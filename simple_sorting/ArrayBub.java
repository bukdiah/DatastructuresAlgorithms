class ArrayBub
{
    private long[] a;   // ref to array a
    private int nElems;  // number of data items

    public ArrayBub(int max)
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

    public void bubbleSort()
    {
        int out, in;

        for (out=nElems-1; out > 1; out --)   // outer loop (moves backward)
        {
            for (in = 0; in<out; in++)        // inner loop (forward)
            {
                if (a[in] > a[in+1])            // out of order?
                {
                    swap(in, in+1);             // swap them
                }
            }
        }
    }

    // Problem 3.1
    // Bidirectional Bubble Sort
    public void biBubbleSort()
    {
        int out1, in, out2;
        for(out2=0; out2<nElems; out2++)
        {
            for (out1=nElems-1; out1 > 1; out1 --)   // outer loop (moves backward)
            {
                for (in = 0; in<out1; in++)        // inner loop (forward)
                {
                    if (a[in] > a[in+1])            // out of order?
                    {
                        swap(in, in+1);             // swap them
                    }
                }
            }
            if (a[out1] < a[out1-1])   // if element on the right is smaller than element on the left
            {
                swap(out1, out1-1);
            }
        }

    }

    private void swap (int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    // Problem 3.4 odd-even sort   ?
    public void odd_even_sort()
    {
        int out, in;

        for (out=nElems-1; out > 1; out --)   // outer loop (moves backward)
        {
            for (in = 0; in<out; in++)        // inner loop (forward)
            {
                if (in % 2 ==0)
                {
                    if (a[in] > a[in+1])            // out of order?
                    {
                        swap(in, in+1);             // swap them
                    }
                }
                else
                {
                    if (a[in] > a[in+1])            // out of order?
                    {
                        swap(in, in+1);             // swap them
                    }
                }
            }
        }
    }
}