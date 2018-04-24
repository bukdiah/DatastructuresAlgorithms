
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
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound) /2;
            if(a[curIn] == searchKey)
                return curIn;   // found it
            else if (lowerBound > upperBound)
                return nElems; // can't find it
            else // divide range
            {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1; //it's in upper half
                else
                    upperBound = curIn - 1 ; //it's in lower half
            }
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
    public boolean delete(long value)
    {
        int j = find(value);
        if(j==nElems)
            // can’t find it
        return false;
        else // found it
        {
            for(int k=j; k<nElems; k++) // move bigger ones down
                a[k] = a[k+1];
            nElems--; // decrement size
            return true;
        }
    } // end delete()
    //-----------------------------------------------------------
    public void display()  // displays array contents
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    public static OrderedArray merge(OrderedArray array1, OrderedArray array2)
    {
        System.out.println("Inside merge");
        OrderedArray destination = new OrderedArray(array1.size() + array2.size());

        // loop thru array1 and array2
        // find the smallest values in both of them and delete from their arrays
        // compare array1 small element and array2 small element
        // whichever is smallest, insert into destination array
        // continue until array1 and array2 size is 0

        while (array1.size() != 0 && array2.size() != 0)
        {
            System.out.println("Inside While loop");
            long array1_smallest = array1.a[0]; // the first index should be the smallest item

            long array2_smallest = array2.a[0];

            System.out.println("array1_smallest: " + array1_smallest +" < " + array2_smallest + " ?" );
            if (array1_smallest < array2_smallest)
            {
                destination.insert(array1_smallest);
                array1.delete(array1_smallest); // should decrement array1 size                
            }
            else
            {
                destination.insert(array2_smallest);
                array2.delete(array2_smallest);
                
            }
        }

        return destination;
    }
    
}