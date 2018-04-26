class Problem44
{
    public static void main(String[] args)
    {
        
        PriorityQFastInsert thePQ = new PriorityQFastInsert(5);
        
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(5);

        thePQ.display();
        //thePQ.printArray();
        //System.out.println("Min Index: "+thePQ.getMinIndex());
        /*
        while(!thePQ.isEmpty())
        {
            long item = thePQ.remove();
            System.out.print(item + " "); // 5, 10, 30, 40, 50
        }
        System.out.println("");*/
        
        /*
        long[] array = {30,50,20};
        int min = 0;
        System.out.println("array.length" +array.length);

        for(int i = 0; i < array.length;i++)
        {
            System.out.println("Index i: " + i);
            System.out.println(array[min] + " > " + array[i] + "?");
            if(array[min] > array[i])
            {
                System.out.println("YES");
                System.out.println("index i = " + i);
                min = i;
            }
            else
            {
                System.out.println("NO");
                continue;
            }
        }
        System.out.println("Smallest Value: "+ array[min]);*/
        
    }
}