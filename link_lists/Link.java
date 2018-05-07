class Link
{
    public int iData;   // data item
    public double dData; //data item
    public Link next; // next link in list

    public Link(int id, double dd)
    {
        iData = id; // iniatlize data
        dData = dd; // 'next' is automatically set to null
        next = null;
    }

    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}