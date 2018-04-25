class Problem41
{
    public static void main(String[] args)
    {
        Queue theQueue = new Queue(10); // queue holds 10 items
        
        // Full Queue with front > rear
        theQueue.insert(10); // front
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
        theQueue.insert(90);
        theQueue.insert(100); // rear

        System.out.println("Full Queue with front < rear");

        theQueue.display();

        System.out.println("");
        System.out.println("Full Queue with front > rear");
        theQueue.remove(); // remove two items (10,20)
        theQueue.remove();

        theQueue.insert(200); // broken sequence/ wrap around
        theQueue.insert(300);

        theQueue.display();

        System.out.println("");

        System.out.println("Broken Sequence Queue with 8 items");
        theQueue.remove(); // remove 30, 40
        theQueue.remove();

        theQueue.display();

        System.out.println("Queue with only ONE item");
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.display();
        System.out.println("");
        
        System.out.println("Queue with NO items");
        theQueue.remove();

        theQueue.display();
        
    }
}