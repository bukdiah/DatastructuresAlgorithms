class Queue
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // put item at rear of queue
    public void insert(long j)
    {
        // Deal with wraparound
        if (rear == maxSize-1)
        {
            rear = -1;
        }
        queArray[++rear] = j;   // increment rear and insert
        nItems++;
    } 

    // take item from front of queue
    public long remove()
    {
        long temp = queArray[front++]; // get value and increment front
        if(front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return temp;
    }

    //peek at front of queue
    public long peekFront()
    {
        return queArray[front];
    }

    // returns true if queue is empty
    public boolean isEmpty()
    {
        return (nItems == 0);
    }

    public boolean isFull() // true if queue is full
    {
        return (nItems==maxSize);
    }

    public int size() // number of items in queue
    {
        return nItems;
    }
    //Problem 41
    public void display()
    {
        // If no items
        if (isEmpty())
            System.out.print("No items in the queue.");
        
        // if one item
        if (nItems == 1)
        {
            if(front == rear) // if front and rear indices are the same
            {
                System.out.print("One item: "+ queArray[front]);
            }
        }

        //if array is full
        if(isFull() || nItems > 1)
        {
            if(front < rear) // contiguous
            {
                for(int i=front; i <= rear; i++)
                {
                    System.out.print(queArray[i]);
                    System.out.print(" ");
                }
            }
            else  // broken sequence?
            {
                // Loop from front index to end of array (maxSize-1)
                for(int i=front; i<= nItems-1; i++)
                {
                    System.out.print(queArray[i]);
                    System.out.print(" ");
                }

                for(int j = 0; j<=rear; j++)
                {
                    System.out.print(queArray[j]);
                    System.out.print(" ");                    
                }
            }
        }
    }
}