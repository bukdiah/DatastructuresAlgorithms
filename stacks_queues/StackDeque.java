class StackDeque
{
    private int maxSize;
    private long[] a;
    private int nItems;
    private int left, right;

    public StackDeque(int s)
    {
        maxSize = s;
        a = new long[maxSize];
        left = 0; // AKA front
        right = -1; // AKA rear
        nItems = 0;
    }

    // Push
    public void insertLeft(long item)
    {
        if(!isFull())
        {
            // If Queue is empty
            if (nItems == 0)
            {
                a[left] = item;
                System.out.println("Zero items. Inserting "+ item+ " to index "+ left);
                right++; // move right marker
                nItems++; // incremenet number of items
            }
            else
            {
                for(int i=right; i >= left; i--)
                {
                    a[i+1] = a[i]; // shift items
                }
                a[left] = item; // insert item
                right++;
                nItems++;
            }
        }
    }
    // Pop
    public long removeLeft()
    {
        long value = 0;
        if(!isEmpty())
        {
            value = a[left];
            left++; // move left marker
        }
        nItems--;
        return value;
    }

    public long peek()
    {
        long value = 0;
        if (!isEmpty())
        {
            value = a[right];
        }

        return value;
    }

    public boolean isFull()
    {
        return (nItems == maxSize);
    }

    public boolean isEmpty()
    {
        return (nItems == 0);
    }
}