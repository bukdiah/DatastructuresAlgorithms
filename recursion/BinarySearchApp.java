class BinarySearchApp
{
    public static void main(String[] args)
    {
        int maxSize =100;
        OrderedArray arr;
        arr = new OrderedArray(maxSize);

        arr.insert(75);
        arr.insert(85);
        arr.insert(95);
        arr.insert(155);
        arr.insert(20);
        arr.insert(42);
        arr.insert(10);
        arr.insert(35);
        arr.insert(55);
        arr.insert(80);

        arr.display();

        int searchKey = 55;

        if(arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
    }
}