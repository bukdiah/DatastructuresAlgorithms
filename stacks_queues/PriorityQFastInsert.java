
class PriorityQFastInsert
{
    // array in sorted order, from max at 0 to min at size-1
    private int maxSize;
    private long[] queArray;
    private int nItems;
    private int front;
    private int rear;
    public PriorityQFastInsert(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
        front = 0;
        rear = -1;

    }

    // Problem 4.4
    public void insert(long item)
    {
        //System.out.println("nItems = " + nItems);

        //queArray[nItems] = item; // fast insert
        queArray[++rear] = item;
        nItems++;
    }
    public long remove() // remove minimum item
    {
        //return queArray[--nItems];
        int minIndex = getMinIndex();
        //System.out.println("Min Index: " + minIndex);
        long minValue = queArray[minIndex];
        //System.out.println("minValue = " + minValue);

        for(int i = minIndex; i < nItems-1; i++)
        {
            queArray[i] = queArray[i+1];
        }
        rear--;
        nItems--;

        return minValue;
    }

    public int getMinIndex()
    {
        int minIndex = 0;
        for (int i = 0; i < nItems; i++)
        {
            //System.out.println("Index i: " + i);
            //System.out.println(queArray[minIndex] + " > " + queArray[i] + "?");
            if (queArray[minIndex] > queArray[i])
                minIndex = i;
        }

        return minIndex;
    }
    // Problem 4.4
    public void display()
    {
        for(int i = front; i <= rear; i++)
        {
            System.out.print(queArray[i]);
            System.out.print(" ");
        }
        System.out.println(' ');
    }
    public long peekMin() // peek at minimum item
    {
        return queArray[nItems-1];
    }

    public boolean isEmpty()
    {
        return (nItems==0); //return true if empty
    }

    public boolean isFull()
    {
        return (nItems==maxSize); // return true if full
    }
}