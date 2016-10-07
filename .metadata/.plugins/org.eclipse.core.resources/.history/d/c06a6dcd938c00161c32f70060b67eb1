import java.util.*;
public class Graph implements MultiGraphADT  {
	
	//Hashmap has Stations instead of INodes because Station is the concrete class and INode is just interface
	private ArrayList<Line>lineList;
	private HashMap<Integer, Station> graph = new HashMap<Integer, Station>();
	
	public Graph(int N) 
	{
		lineList = new ArrayList<Line>();
	}
	
	@Override
	public void addEdge(int n1, int n2, String color) {
		Line edge = new Line(n1,n2, color);
		lineList.add(edge);
	        
		
	}
	
    public int nEdges()
    {
        return lineList.size();
    }
    
	@Override
	public INode getNode(int id)
	{
		return graph.get(id);
	}
	
	/*public boolean isStation(INode station) { // existNode()
		return (getNode(station))
	}*/
	
	
	public void addNode(int id, String name) 
	{
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
	public void addNode(INode n) 
	{
		
	}
	
	public boolean isEdge(int in, int out){
		int l = 0;
		boolean found = false;
		while (!found && l<nEdges())
		{
			if ((lineList.get(l).getIn() == in) && (lineList.get(out).getOut() == out))
				found = true;
			else
				l++;
				
		}
		return found;
	}

	@Override
	public void search(int start, int finish) {
		
		int front,rear, in, out = 0;
		
		for(int i = 0; i<nEdges();i++){
			lineList.get(i).setVisited(false);
		}
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> route = new LinkedList<Integer>();
		
		if(isEdge(start,finish)==true){
			route.add(start);
			route.add(finish);
		}
		else{
			visited.add(start);
			route.add(start);
			while(!route.isEmpty())
			{
				int m = route.remove();
				in = lineList.get(m).getIn();
				out = lineList.get(m).getOut();
				visited.add(in);
				visited.add(out);
				if(in == finish){
					//finish and print route
				}
				else if(out == finish){
					//finish and print route
				}
				else{
					route.add(in);
					route.add(out);
				}
			}
		}
		
		
		
	}
	
	
}