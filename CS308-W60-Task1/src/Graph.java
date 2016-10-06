import java.util.*;


public class Graph implements MultiGraphADT  {

	//Hashmap has Stations instead of INodes because Station is the concrete class and INode is just interface
	private ArrayList<IEdge> lineList = null;
	private HashMap<Integer, Station> graph = new HashMap<Integer, Station>();

	
	public Graph(int N) {
		lineList = new ArrayList<IEdge>();
		
	}
	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(int n1, int n2, String color) {
		if(!(isEdge(n1, n2, color))){
			lineList.add(new Line(n1, n2, color));
		}
	}
	
    //not sure if this method works
	public boolean isEdge(int node1, int node2, String label) 
    {
        int i=0; 
        while (i<nEdges())
        {
          if ((lineList.get(i).getIn() == node1) && (lineList.get(i).getOut() == node2) && (lineList.get(i).getColour().equals(label)))
             return true;
          else if((lineList.get(i).getIn() == node2) && (lineList.get(i).getOut() == node1) && (lineList.get(i).getColour().equals(label)))
             return true;
          else{
        	  i++;
          }
        }
        return false;
    }


    public int nEdges()
    {
        return lineList.size();
    }
    
	@Override
	public INode getNode(int id) {
		return graph.get(id);
	}
	
	/*public boolean isStation(INode station) { // existNode()
		return (getNode(station))
	}*/
	
	
	public void addNode(int id, String name) {
		graph.put(id,new Station(id,name));
	}
	
    public ArrayList<Integer> successors(int node) 
    {
        ArrayList<Integer> successorNodes = new ArrayList<Integer>();
        for (int i=0; i<nEdges(); i++)
           if (lineList.get(i).getIn() == node)
             successorNodes.add(lineList.get(i).getOut());
        return successorNodes;
    }
	@Override
	public void addNode(INode n) {		
	};

}
