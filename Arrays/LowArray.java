//lowArray
// demonstrates array class with low-level interface

public class LowArray
{
    private long[] a; // ref to array a

    public LowArray(int size)
    {
        a = new long[size];
    }

    public void setElem(int index, long value)
    {
        a[index] = value; // set value
    }

    public long getElem(int index)
    {
        return a[index];
    }
}