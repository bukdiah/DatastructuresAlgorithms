class CLStack
{
    private CircularList theList;

    public CLStack()
    {
        theList = new CircularList();
    }

    public void push(long j) // put item on top of stack
    {
       theList.insert(j);
    }

    public void pop()
    {
        theList.delete();
    }

    public boolean isEmpty()
    {
        return (theList.isEmpty());
    }

    public void displayStack()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}