class LinkChain
{
  private int iData; // data item
  public LinkChain next; // next link in list

  public LinkChain(int it)
  {
    iData = it;
  }

  public int getKey()
  {
    return iData;
  }

  public void displayLink()
  {
    System.out.print(iData + " ");
  }
}