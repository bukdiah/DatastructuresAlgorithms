
class OrderedApp
{
    public static void main(String[] args)
    {
      //int maxSize = 100;
      OrderedArray source1 = new OrderedArray(25);
      OrderedArray source2 = new OrderedArray(25);
      
      /*
      source1.insert(30);
      source1.insert(50);
      source1.insert(20);
      source1.insert(40);
      source1.insert(66);
      source1.insert(88);
      source1.insert(25);
      source1.insert(15);
      source1.insert(80);
      source1.insert(99);

      source1.display();*/
      
      OrderedArray dest;
      for(int i = 0; i < 10; i++)
      {
        long rand = (long)(Math.random() * 100 + 1);

        source1.insert(rand);
      }

      source1.display();

      for(int i = 0; i < 15; i++)
      {
        long rand = (long)(Math.random() * 100 + 1);

        source2.insert(rand);
      }

      source2.display();

      //dest = new OrderedArray(source1.size() + source2.size());

      System.out.println("Attempting to merge source1 and source2");
      dest = OrderedArray.merge(source1, source2);

      
      dest.display();
      /*
        // array size
       OrderedArray arr;
        // reference to array
       arr = new OrderedArray(maxSize); // create the array

       arr.insert(77);       // insert 10 items       
       arr.insert(99);
       arr.insert(44);
       arr.insert(55);
       arr.insert(22);
       arr.insert(88);
       arr.insert(11);
       arr.insert(00);
       arr.insert(66);
       arr.insert(33);

       arr.display();   //display items

       int searchKey = 55;
        // search for item
       if( arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
       else
            System.out.println("Can’t find " + searchKey);
       
       arr.delete(00);          // delete 3 items
       arr.delete(55);
       arr.delete(99);

       arr.display();           // display items again*/
       
    }
}