class DArray
{
    private long[] theArray; // ref to aray theArray
    private int nElems; // number of data items

    public DArray(it max)
    {
        theArray = new long[max];   // create array
        nElems = 0;
    }

    public void insert(long value)
    {
        theArray[nElems] = value;   // insert it
        nElems++;
    }

    public void display()   // displays array contents
    {
        for(int j=0; j<nElems; j++)
        {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }
}