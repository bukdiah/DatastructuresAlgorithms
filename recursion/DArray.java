import javax.swing.text.Highlighter.HighlightPainter;

class DArray
{
    private long[] theArray; // ref to aray theArray
    private int nElems; // number of data items

    public DArray(int max)
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

    public void mergeSort() // called by main(), provides workspace
    {
        long [] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }

    private void recMergeSort(long[] workspace, int lowerBound, int upperBound)
    {
        if (lowerBound == upperBound)   // if range is 1, no use sorting
            return;
        else
        {
            int mid = (lowerBound+upperBound)/2;    // find mid point

            // sort low half
            recMergeSort(workspace, lowerBound, mid);

            // sort high half
            recMergeSort(workspace, mid+1, upperBound);

            merge(workspace, lowerBound, mid+1, upperBound);

        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound)
    {
        int j = 0; //workspace index
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1;    // # of items

        while(lowPtr <= mid && highPtr <= upperBound)
        {
            if(theArray[lowPtr] < theArray[highPtr])
            {
                workSpace[j++] = theArray[lowPtr++];
            }
            else
            {
                workSpace[j++] = theArray[highPtr++];
            }
        }

        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        
        for (j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }
}