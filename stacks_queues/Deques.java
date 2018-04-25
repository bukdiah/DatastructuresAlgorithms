class Deques
{
    private int maxSize;
    private long[] array;
    private int left;
    private int right;
    private int nItems;
    private int top;

    public Deques(int s)
    {
        maxSize = s;
        array = new long[maxSize];
        right = 0;  // right index, will move towards right when inserting
        left = maxSize-1; // left index, will move towards left when inserting
        nItems = 0;
    }
}