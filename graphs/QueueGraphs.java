class QueueGraphs
{
  private final int SIZE = 20;
  private int[] queArray;
  private int front;
  private int rear;

  public QueueGraphs()
  {
    queArray = new int[SIZE];
    front =0;
    rear = -1;
  }

  public void insert(int j) // put item at rear of queue
  {
    if(rear == SIZE-1)
      rear =-1;
    queArray[++rear] = j;
  }

  public int remove()
  {
    int temp = queArray[front++];
    if(front == SIZE)
      front = 0;
    return temp;
  }

  public boolean isEmpty()
  {
    return (rear+1 == front || (front+SIZE-1 == rear));
  }

  //peek at front of queue
  public int peekFront()
  {
      return queArray[front];
  }
}