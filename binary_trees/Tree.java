import java.util.Stack;

class Tree
{
  // Tree class holds all the nodes
  private Node root; // the only data field in tree

  public Tree()
  {
    root = null; // no nodes in tree yet
  }
  // find node with given key (assumes non empty tree)
  public Node find(int key) {
    Node current = root; // start at roo

    // while no match
    while(current.iData != key)
    {
      if (key < current.iData) // go left?
        current = current.leftChild;
      else
        current = current.rightChild; // or go right
      
      if(current == null) // if no child, we didn't find it
        return null;
    }

    return current;
  }

  public void insert(int id, double dd) {
    Node newNode = new Node(id, dd); // make a new node

    if(root == null) // no node in root
      root = newNode;
    else
    {
      Node current = root; // start at root
      Node parent;
      while(true)
      {
        parent = current;
        if(id < current.iData) // go left?
        {
          current = current.leftChild;
          if(current == null) // if end of the line, insert on left
          {
            parent.leftChild = newNode;
            return;
          }
        }
        else  // or go right?
        {
          current = current.rightChild;
          if(current == null)
          {
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }

  }
  // deletes node with given key (assumes non-empty list)
  public boolean delete(int key) {
    Node current = root;
    Node parent = root;
    boolean isLeftChild = true;

    while (current.iData != key)  // search for node
    {
      parent = current;
      if(key < current.iData) // go left?
      {
        isLeftChild = true;
        current = current.leftChild;
      }
      else // or go right
      {
        isLeftChild = false;
        current = current.rightChild;
      }

      if (current == null)  // end of the line, didn't find it
        return false;
    }
    // Found the node to delete
    // if Node has no children, simply delete it
    if(current.leftChild == null && current.rightChild == null)
    {
      if(current == root) // if root
        root = null;    // tree is now empty
      else if(isLeftChild)
        parent.leftChild = null; // disconnect from parent
      else
        parent.rightChild = null; 
    }
    // Node has one child
    // if no right child, replace with left subtree
    else if(current.rightChild == null)
      if(current == root)
        root = current.leftChild;
      else if(isLeftChild) // left child of parent
        parent.leftChild = current.leftChild;
      else // right child of parent
        parent.rightChild = current.leftChild;
    // if no left child, replace with right subtree    
    else if(current.leftChild == null)
      if(current == root)
        root = current.rightChild;
      else if(isLeftChild)  // left child of parent
        parent.leftChild = current.rightChild;
      else  // right child of parent
        parent.rightChild = current.rightChild;
    else // two children, so replace with inorder successor
    {
      //get successor of node to delete (current)
      Node successor = getSuccessor(current);

      // connect parent of current to successor instead
      if (current == root)
        root = successor;
      else if(isLeftChild)
        parent.leftChild = successor;
      else
        parent.rightChild = successor;
      
      //connect successor to current's left child
      successor.leftChild = current.leftChild;
    }
    // successor cannot have a left child
    return true;
  }

  // returns node with the NEXT HIGHEST value after delNode
  // goes to right child, then right child's left descendants
  private Node getSuccessor(Node delNode)
  {
    Node successorParent = delNode;
    Node successor = delNode;
    Node current = delNode.rightChild; // go to right child

    while(current != null)  // until no more left children
    {
      successorParent = successor;
      successor = current;
      current = current.leftChild; // go to left child
    }
    // If successor is a left descendant of right child of delNode
    // if successor is not right child, make connections
    if (successor != delNode.rightChild)
    {
      successorParent.leftChild = successor.rightChild;
      successor.rightChild = delNode.rightChild;
    }
    return successor;
  }

  // In Order traversal
  // Nodes are visited in ASCENDING order based on their key values
  private void inOrder(Node localRoot)
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
  private void preOrder(Node localRoot)
  {
    System.out.print(localRoot.iData + " ");

    preOrder(localRoot.leftChild);

    preOrder(localRoot.rightChild);
  }

  // postOrder Traversal
  // Creates postfix notation 
  // Infix: A*(B+C) --> ABC+*
  private void postOrder(Node localRoot)
  {

    postOrder(localRoot.leftChild);

    postOrder(localRoot.rightChild);
    System.out.print(localRoot.iData + " ");
  }

  // returns node with minimum key value
  public Node minimum()
  {
    Node current, last;
    current = root; // start at root;

    while(current != null) // until bottom
    {
      last = current; // rmemeber node
      current = current.leftChild; // go to left child
    }

    return current;
  }

    // returns node with minimum key value
    public Node maximum()
    {
      Node current, last;
      current = root; // start at root;
  
      while(current != null) // until bottom
      {
        last = current; // rmemeber node
        current = current.rightChild; // go to right child
      }
  
      return current;
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
            Node temp = (Node) globalStack.pop();
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