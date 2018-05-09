class LinkStack
{
    private LinkList2 theList;

    public LinkStack()
    {
        theList = new LinkList2();
    }

    public void push(long j) // put item on top of stack
    {
       theList.insertFirst(j);
    }

    public long pop()
    {
        return theList.deleteFirst();
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