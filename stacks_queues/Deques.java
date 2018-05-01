class Deques
{
    private int maxSize;
    private long[] a;
    private int left;
    private int right;
    private int nItems;

    public Deques(int s)
    {
        maxSize = s;
        a = new long[maxSize];
        left = 0; // AKA front
        right = -1; // AKA rear
        nItems = 0;
    }

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
                System.out.println("nItems = " + nItems);
                for(int i=right; i >= left; i--)
                {
                    System.out.println("");
                    System.out.println("Value: " + a[i]);
                    System.out.println("Index: " + i);
                    System.out.println("Copying "+ a[i] + " from "+ i+ " index to " + (i+1)+" index");
                    a[i+1] = a[i]; // shift items
                }
                System.out.println("Inserting new item: "+item);
                a[left] = item; // insert item
                right++;
                nItems++;
            }
            /*
            for(int i = 0; i < nItems; i++)
            {
                System.out.println("Index: "+i+" ==> value: "+ a[i]);
            }
            System.out.println("Number of items: "+nItems);
            System.out.println("Value of right: "+right);*/

        }
    }

    public void insertRight(long item)
    {
        if(!isFull())
        {
            // If Queue is empty
            if (nItems == 0)
            {
                a[++right] = item;
                //right++; // move right marker
                nItems++; // incremenet number of items
            }
            else
            {
                a[right+1] = item;
                right++;
                nItems++;
            }
        }

    }

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

    public long removeRight()
    {
        long value = 0;
        if(!isEmpty())
        {
            value = a[right];
            right--;
        }
        nItems--;
        return value;
    }

    public void print()
    {
        for(int i = left; i <= right; i++)
        {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println("");
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