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
}