import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

class TreeMod
{
  // Tree class holds all the nodes
  private NodeMod root; // the only data field in tree

  public TreeMod()
  {
    root = null; // no nodes in tree yet
  }

  // retrieves root
  public NodeMod getRoot()
  {
    return root;
  }

    // retrieves root
  public void setRoot(NodeMod node)
  {
      this.root = node;
  }

  // In Order traversal
  // Nodes are visited in ASCENDING order based on their key values
  private void inOrder(NodeMod localRoot)
  {
    if(localRoot != null)
    {
      inOrder(localRoot.leftChild);

      System.out.print(localRoot.iData + " ");

      inOrder(localRoot.rightChild);
    }
  }

  // PreOrder Traversal
  // Creates prefix notation 
  // Infix: A*(B+C) --> *A+BC
  private void preOrder(NodeMod localRoot)
  {
    System.out.print(localRoot.iData + " ");

    preOrder(localRoot.leftChild);

    preOrder(localRoot.rightChild);
  }

  // postOrder Traversal
  // Creates postfix notation 
  // Infix: A*(B+C) --> ABC+*
  private void postOrder(NodeMod localRoot)
  {

    postOrder(localRoot.leftChild);

    postOrder(localRoot.rightChild);
    System.out.print(localRoot.iData + " ");
  }

    public void traverse(int traverseType)
    {
      switch(traverseType)
      {
        case 1: System.out.print("\nPreorder traversal: ");
          preOrder(root);
          break;
        case 2: System.out.print("\nInorder traversal: ");
          inOrder(root);
          break;
        case 3: System.out.print("\nPostorder traversal: ");
          postOrder(root);
          break;
      }
      System.out.println();
    }

    public void displayTree() 
    { 
      Stack globalStack = new Stack(); 
      globalStack.push(root); 
      int nBlanks = 32; 
      boolean isRowEmpty = false; 
      System.out.println( "......................................................");

      while(isRowEmpty == false)
      {
        Stack localStack = new Stack();
        isRowEmpty = true;

        for (int j=0; j<nBlanks; j++)
          System.out.print(' ');
        
          while(globalStack.isEmpty() == false)
          {
            NodeMod temp = (NodeMod) globalStack.pop();
            if(temp != null)
            {
              System.out.println(temp.iData);
              localStack.push(temp.leftChild);
              localStack.push(temp.rightChild);

              if(temp.leftChild != null || temp.rightChild !=null)
                isRowEmpty = false;
              else {
                System.out.print("--");
                localStack.push(null);
                localStack.push(null);
              }
            }
            for(int j=0; j<nBlanks*2-2; j++)
            {
              System.out.print(' ');
            }
          }
          System.out.println();
          nBlanks /= 2;
          while(localStack.isEmpty() == false)
            globalStack.push(localStack.pop());
      }
      System.out.println(".......................................................");
    }

}