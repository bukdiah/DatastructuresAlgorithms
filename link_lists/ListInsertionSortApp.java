class ListInsertionSortApp
{
    public static void main(String[] args)
    {
        int size = 10;

        Link2[] linkArray = new Link2[size];

        for (int j = 0; j<size; j++)
        {
            int n = (int)(Math.random()*99);
            Link2 newLink = new Link2(n);   // make link
            linkArray[j] = newLink; // put in array
        }

        System.out.print("Unsorted array: ");
        for(int j=0; j<size; j++)
            System.out.print(linkArray[j].dData+" ");
        System.out.println("");

        // create new list
        // initialized with array

        SortedList2 theSortedList = new SortedList2(linkArray);

        for(int j=0; j<size; j++)   // links from list to array
            linkArray[j] = theSortedList.remove();
        
        System.out.print("Sorted array: ");
        
        for(int j=0; j<size; j++)
            System.out.print(linkArray[j].dData + " ");
        System.out.println("");
    } // end main()
} // end class ListInsertionSortApp
