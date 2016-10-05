import java.util.*;


public class MetroSystem implements MultiGraphADT  {

	private ArrayList<IEdge> lineList = null;
    List<INode>[]	adjList;
	HashMap<Integer, INode> graph = new HashMap<Integer, INode>();
	private int NumNodes;
	

	
	public MetroSystem(int N) {
		lineList = new ArrayList<IEdge>();
        adjList = new List[N];
		for(int i = 0; i < N; ++i) {
            adjList[i] = new ArrayList<INode>();
		}
		this.NumNodes = N;
		
	}
	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(INode n1, INode n2, String color) {
		lineList.add(new Line(n1, n2, color));
	        IEdge edge = new Line(n1,n2, color);
	        lineList.add(edge);
	        adjList[n1.getId()].add(n2);
	        adjList[n2.getId()].add(n1);
		
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

	

}
