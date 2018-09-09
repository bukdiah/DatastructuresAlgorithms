class Graph
{
  private final int MAX_VERTS = 20;
  private Vertex vertexList[]; // array of vertices
  private int adjMat[][]; //adjacency matrix
  private int nVerts; // current number of vertices
  private StackX theStack; // used for DFS
  private QueueGraphs theQueue; // used for BFS

  public Graph()
  {
    vertexList = new Vertex[MAX_VERTS];

    //adjacency matrix
    adjMat = new int[MAX_VERTS][MAX_VERTS];

    nVerts = 0;

    for(int j=0; j<MAX_VERTS; j++)
    {
      for(int k=0; k<MAX_VERTS; k++) // set matrix to 0
        adjMat[j][k] = 0;
    }
    theStack = new StackX();
    theQueue = new QueueGraphs();
  }

  public void addVertex(char lab) // argument is label
  {
    vertexList[nVerts++] = new Vertex(lab);
  }

  public void addEdge(int start, int end)
  {
    /*
     Because of redundancy,when you add an edge to the graph, 
     you must make two entries in the adjacency matrix rather than one
    */
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  public void displayVertex(int v)
  {
    System.out.print(vertexList[v].label);
  }

  //return an unvisited vertex adjacent to v
  public int getAdjUnvisitedVertex(int v)
  {
    for(int j=0; j<nVerts;j++)
    {
      if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
        return j; // return first such vertex
    }
    return -1; // no such vertices
  }
  /*
    Does 4 things within the loop:
      1) It examines the vertex at the top of the stack using peek
      2) It tries to find an unvisited neighbor of this vertex
      3) If it doesn't find out, it pops the stack
      4) If it finds such a vertex, it visits that vertex and pushes
        it onto the stack
  */
  public void dfs()
  {
    // begin at vertex 0
    vertexList[0].wasVisited = true; // mark it
    displayVertex(0); // display it
    theStack.push(0); // push it

    while(!theStack.isEmpty()) // until stack empty,
    {
      // get an unvisited vertex adjacent to stack top
      int v = getAdjUnvisitedVertex(theStack.peek());

      if(v == -1) // if no such vertex,
        theStack.pop();
      else
      {
        vertexList[v].wasVisited = true; // mark it
        displayVertex(v); // display it
        theStack.push(v); // push it
      }
    }

    // stack is empty, so we're done
    // reset flags
    for(int j=0; j<nVerts; j++)
    {
      vertexList[j].wasVisited = false;
    }
  }

  // bfs
  // Outer loop waits for the queue to be empty
  // inner one looks in turn at each unvisited neighbor of the current
  // vertex
  public void bfs()
  {
    // begin with vertex 0
    vertexList[0].wasVisited = true; // mark it
    displayVertex(0); // display it
    theQueue.insert(0); // insert at tail
    int v2;

    while(!theQueue.isEmpty())
    {
      int v1 = theQueue.remove(); // remove vertex at head
      // until it has no unvisited neighbors
      while((v2 = getAdjUnvisitedVertex(v1)) != -1)
      { // get one
        vertexList[v2].wasVisited = true; // mark it
        displayVertex(v2); // display it
        theQueue.insert(v2); // insert it
      }
    }

    // queue is empty, so we're done
    for(int j=0; j<nVerts; j++)
    {
      vertexList[j].wasVisited = false;
    }

  }

  // minimum spanning tree
  public void mst() // depth first version
  {
    vertexList[0].wasVisited = true; // start at 0, mark it
    theStack.push(0); // push it

    while(!theStack.isEmpty())
    {
      int currentVertex = theStack.peek(); // get stack top
      // get next unvisited neighbor
      int v = getAdjUnvisitedVertex(currentVertex);

      if(v == -1) // if no more neighbors
        theStack.pop(); // pop it away
      else // got a neighbor
      {
        vertexList[v].wasVisited = true; // mark it
        theStack.push(v); // push it

        // display edge
        displayVertex(currentVertex); // from currentV
        displayVertex(v); // to v
        System.out.print(" ");
      }
    }

    // stack is empty, so we're done
    for(int j=0; j<nVerts; j++)
      vertexList[j].wasVisited = false;
  }

  //Problem 13.1
  // MST using BFS
  public void mst_2()
  {
    // begin with vertex 0
    vertexList[0].wasVisited = true; // mark it
    //displayVertex(0);
    theQueue.insert(0); // insert at tail
    int v2;

    while(!theQueue.isEmpty())
    {
      int currentVertex = theQueue.peekFront();
      int v1 = theQueue.remove(); // remove vertex at head
      // until it has no unvisited neighbors
      while((v2 = getAdjUnvisitedVertex(v1)) != -1)
      { // get one
        vertexList[v2].wasVisited = true; // mark it
        theQueue.insert(v2); // insert it
      }
    }

    // queue is empty, so we're done
    for(int j=0; j<nVerts; j++)
    {
      vertexList[j].wasVisited = false;
    }    
  }
}