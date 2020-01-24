class Problem131
{
  public static void main(String [] args)
  {
    Graph theGraph = new Graph();
    /*
    theGraph.addVertex('A'); // 0 (start for mst)
    theGraph.addVertex('B'); // 1
    theGraph.addVertex('C'); // 2
    theGraph.addVertex('D'); // 3
    theGraph.addVertex('E'); // 4

    theGraph.addEdge(0, 1);     // AB 
    theGraph.addEdge(0, 2);     // AC 
    theGraph.addEdge(0, 3);     // AD 
    theGraph.addEdge(0, 4);     // AE 
    theGraph.addEdge(1, 2);     // BC 
    theGraph.addEdge(1, 3);     // BD 
    theGraph.addEdge(1, 4);     // BE 
    theGraph.addEdge(2, 3);     // CD 
    theGraph.addEdge(2, 4);     // CE 
    theGraph.addEdge(3, 4);     // DE */

    theGraph.addVertex('A');	// 0 (start for mst)
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addVertex('H');
		theGraph.addVertex('I');
		
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 7);
		theGraph.addEdge(7, 8);
		theGraph.addEdge(1, 8);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 2);
		theGraph.addEdge(2, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(3, 5);
		theGraph.addEdge(3, 6);
		theGraph.addEdge(4, 5);
    theGraph.addEdge(5, 6);
    
    System.out.print("Minimum spanning tree: ");
    theGraph.mst_2();
    System.out.println();
  }
}