import java.io.IOException;
import java.io.*;

class Problem81
{
  public static void main(String[] args) throws IOException {
    TreeMod oneNodeTreesArray[] = new TreeMod[5];
    NodeMod nodesArray[] = new NodeMod[5];

    int itemCount = 0;

    while(true) {
      if(itemCount == 5) {
        System.out.println("Cannot insert anymore letters.");
        break;
      }
      
      System.out.print("Enter a letter to put in a node: ");

      char choice = getChar();


      
      NodeMod node = new NodeMod(choice);
      //TreeMod oneNodeTree = new TreeMod();
      //oneNodeTree.setRoot(node); // creates one-node tree

      //oneNodeTreesArray[itemCount++] = oneNodeTree;
      nodesArray[itemCount++] = node;
    }

    System.out.println("");
    System.out.println("Creating tree using + as the root");

    TreeMod newTree = new TreeMod();

    for (int i=0; i < itemCount; i++)
    {
      if(newTree.getRoot() == null) // empty tree
      {
        NodeMod parent = new NodeMod('+');
        newTree.setRoot(parent);
      }
      // no left child
      if(newTree.getRoot().leftChild == null) {
        //newTree.getRoot().leftChild = oneNodeTreesArray[i];
        newTree.getRoot().leftChild = nodesArray[i];
        continue;
      }

      // no right child
      if(newTree.getRoot().rightChild == null) {
        //newTree.getRoot().rightChild = oneNodeTreesArray[i];
        newTree.getRoot().rightChild = nodesArray[i];
        continue;
      }
      // if our root node has two children
      if(newTree.getRoot().leftChild != null && newTree.getRoot().rightChild !=null) {
        NodeMod oldParent = newTree.getRoot(); // obtain current parent/root node
        NodeMod newParent = new NodeMod('+');
        newTree.setRoot(newParent);

        newTree.getRoot().leftChild = oldParent;
        //newTree.getRoot().rightChild = oneNodeTreesArray[i];
        newTree.getRoot().rightChild = nodesArray[i];
      }

    }

    // display the tree now
    newTree.displayTree();

  }

  public static String getString() throws IOException { 
    InputStreamReader isr = new InputStreamReader(System.in); 
    BufferedReader br = new BufferedReader(isr); 
    String s = br.readLine(); 
    return s; 
  }

  public static char getChar() throws IOException { 
    String s = getString(); 
    return s.charAt(0); 
  }
  


}