class StackX
{
    private int maxSize;
    private Params[] stackArray;
    private int top;    // top of stack

    public StackX(int s)
    {
        maxSize = s;    // set arrau soze
        stackArray = new Params[maxSize];
        top = -1; // no items yet
    }

    public void push(Params p)
    {
        stackArray[++top] = p;
    }

    public Params pop()
    {
        return stackArray[top--];
    }

    public Params peek()
    {
        return stackArray[top];
    }
}