class Node
{
  int iData;  // data used as key value
  double dData; // other data
  Node leftChild;
  Node rightChild;

  public Node(int iData, double fData)
  {
    this.iData = iData;
    this.fData = fData;
  }
  public void displayNode()
  {
    System.out.print('{');
    System.out.print(iData);
    System.out.print(", ");
    System.out.print(dData);
    System.out.print("} ");
  }
}