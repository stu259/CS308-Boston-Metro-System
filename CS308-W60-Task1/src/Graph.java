import java.util.*;


public class Graph implements MultiGraphADT  {

	private ArrayList<IEdge> lineList = null;
	private HashMap<Integer, INode> graph = new HashMap<Integer, INode>();
	private int NumNodes;
	

	
	public Graph(int N) {
		lineList = new ArrayList<IEdge>();
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
		
	}

	public int nNodes() {
		return NumNodes;
	}

    public int nEdges()
    {
        return lineList.size();
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
	
    public ArrayList<Integer> successors(int node) 
    {
        ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i=0; i<nEdges(); i++)
           if (lineList.get(i).getIn() == node)
             successorNodes.add(lineList.get(i).getOut());
        return successorNodes;
    };


	

}
