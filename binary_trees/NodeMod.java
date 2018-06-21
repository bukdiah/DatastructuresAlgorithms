class NodeMod
{
  char iData;  // data used as key value
  NodeMod leftChild;
  NodeMod rightChild;

  public NodeMod(char iData)
  {
    this.iData = iData;
    
  }
  public void displayNode()
  {
    System.out.print('{');
    System.out.print(iData);
    System.out.print("} ");
  }
}