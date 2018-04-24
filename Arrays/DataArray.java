class DataArray 
{
    private Person[] a; //ref to array a
    private int nElems; // number of data items
    public DataArray(int max)
    {
        a = new Person[max]; //create array
        nElems = 0; // no items yet
    }

    public Person find(String searchName) // find specified value
    {
        int j;
        for(j=0; j <nElems; j++)
        {
            if(a[j].getLast().equals(searchName)) // found item?
                break; // exit loop before end
        }

        if (j == nElems)  // gone to end?
            return null;   // yes, cannot find it
        else
            return a[j];    // no, found it
    }
    public void insert(String last, String first, int age)
    {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }
    
    public boolean delete(String searchName)
    {
        int j;
        for(j=0; j<nElems; j++) // look for value
        {
            if(a[j].getLast().equals(searchName))
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

    public void displayA()
    {
        for(int j=0; j<nElems; j++)
        {
            a[j].displayPerson(); // display it
        }
    }
}