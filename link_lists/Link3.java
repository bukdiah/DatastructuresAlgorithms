class Link3
{
    public long dData; // data item
    public Link3 next; // next link in list
    public Link3 previous; // previous link in list

    public Link3(long d)
    {
        dData = d;
    }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}