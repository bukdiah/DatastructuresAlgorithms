// parameters to save on stack
class Params
{
    public int n;
    public int returnAddress;

    public Params(int nn, int ra)
    {
        n = nn;
        returnAddress = ra;
    }
}