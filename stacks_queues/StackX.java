//Demonstrates stacks


class StackX
{
    private int maxSize;
    private char[] stackArray;
    private int top;
    //--------------------------------------------------------------
    public StackX(int max)
    // constructor
    {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }
    //--------------------------------------------------------------
    public void push(char j) // put item on top of stack
    {
        stackArray[++top] = j;
    }
    //--------------------------------------------------------------
    public char pop()
    // take item from top of stack
    {
        return stackArray[top--];
    }
    //--------------------------------------------------------------
    public char peek()
    // peek at top of stack
    {
        return stackArray[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
    //--------------------------------------------------------------
} // end class StackX

/*
For long numbers
class StackX
{
    private int maxSize;    // size of stack array
    private long[] stackArray;
    private int top;        // top of stack

    public StackX(int s)
    {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;   // no items yet
    }

    public void push(long j)    // put item on top of stack
    {
        stackArray[++top] = j;  // increment top, insert item
    }

    public char pop() // take item from top of stack
    {
        return stackArray[top--];
    }

    public char peek()  // peek at top of stack
    {
        return stackArray[top];
    }

    public boolean isEmpty() // tru if stack is empty
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == maxSize - 1);
    }
}*/