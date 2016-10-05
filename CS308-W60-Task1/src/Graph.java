import java.util.*;


public class Graph implements MultiGraphADT  {

	private ArrayList<IEdge> lineList = null;
    List<Integer>[]	adjList;
	HashMap<Integer, INode> graph = new HashMap<Integer, INode>();
	private int NumNodes;
	

	
	public Graph(int N) {
		lineList = new ArrayList<IEdge>();
        adjList = new List[N];
		for(int i = 0; i < N; ++i) {
            adjList[i] = new ArrayList<Integer>();
		}
		this.NumNodes = N;
		
	}
	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(int n1, int n2, String color) {
		lineList.add(new Line(n1, n2, color));
	        IEdge edge = new Line(n1,n2, color);
	        lineList.add(edge);
	        adjList[n1].add(n2);
	        adjList[n2].add(n1);
		
	}


	@Override
	public INode getNode(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public boolean isStation(INode station) { // existNode()
		return (getNode(station))
	}*/
	

	@Override
	public void addNode(INode n) {
		// TODO Auto-generated method stub
		
	}
	
    ArrayList<Integer> successors(int node) {
    	ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i=0; i<nEdges(); i++)
            if (edges.get(i).node1 == node)
                successorNodes.add(edges.get(i).node2);
        return successorNodes;
    }


	

}
