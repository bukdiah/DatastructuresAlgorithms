class Link2
{
    public long dData; // data item
    public Link2 next; // next link in list

    public Link2(long d)
    {
        dData = d;
    }

    public void displayLink()
    {
        System.out.print(dData + " ");
    }
}