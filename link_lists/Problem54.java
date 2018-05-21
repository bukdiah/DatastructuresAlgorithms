class Problem54
{
    public static void main(String [] args)
    {
        CLStack theStack = new CLStack();
        
        theStack.push(20);
        theStack.push(40);

        theStack.displayStack();

        theStack.push(60);
        theStack.push(80);

        theStack.displayStack();

        theStack.pop();
        theStack.pop();

        theStack.displayStack();
    }
}