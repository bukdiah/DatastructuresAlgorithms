class Problem51
{
    public static void main(String[] args)
    {
        PQ thePQ = new PQ();
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);
        
        System.out.println("The Min: " + thePQ.peekMin());
        thePQ.displayList();


    }
}