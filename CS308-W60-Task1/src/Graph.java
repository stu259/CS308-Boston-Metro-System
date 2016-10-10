import java.util.*;

import static javax.swing.UIManager.get;


public class Graph implements MultiGraphADT {

    //Hashmap has Stations instead of INodes because Station is the concrete class and INode is just interface
    private HashMap<Integer, Set<IEdge>> nodeEdges = new HashMap<>();
    private HashMap<Integer, Station> graph = new HashMap<>();

    public Graph() {

    }

    @Override
    public void addEdge(int n1, int n2, String color) {
       if (!(isEdge(n1, n2, color))) {
            nodeEdges.get(n1).add(new Line(n1, n2, color));
            nodeEdges.get(n2).add(new Line(n2, n1, color));
       }
    }

    //not sure if this method works
    private boolean isEdge(int node1, int node2, String label) {
        if (!nodeEdges.containsKey(node1)) {
            nodeEdges.put(node1, new HashSet<>());
        }
        if (!nodeEdges.containsKey(node2)) {
            nodeEdges.put(node2, new HashSet<>());
        }
        for (IEdge edge : nodeEdges.get(node1)) {
            if (edge.getIn() == node2 && edge.getColour().equals(label)
                    || edge.getOut() == node2 && edge.getColour().equals(label)) {
                return true;
            }

        }
        return false;
    }

    public HashMap<Integer, Station> getStationList() {
        return graph;
    }

    public int nEdges() {
        int size = 0;
        for(int i = 0; i < nodeEdges.size() ; ++i) {
            size += nodeEdges.get(i).size();
        }
        return size;
    }

    @Override
    public INode getNode(int id) {
        return graph.get(id);
    }
    
    public List<String> getColourList(int id) {
    	List<String> colourList = new ArrayList<>();
    	for(IEdge edge : nodeEdges.get(id)) {
    		if(!colourList.contains(edge.getColour()))
    			colourList.add(edge.getColour());
    	}
    	return colourList;
    }
    
    public INode getNeighbour(int id){
    	return graph.get(successors(id).get(0));
    }

	/*public boolean isStation(INode station) { // existNode()
		return (getNode(station))
	}*/

    public boolean isNode(int node) {
        return nodeEdges.containsKey(node);
    }

    public void addNode(int id, String name) {
        graph.put(id, new Station(id, name));
    }

    private ArrayList<Integer> successors(int node) {
        ArrayList<Integer> successorNodes = new ArrayList<>();
        Iterator<IEdge> iter = nodeEdges.get(node).iterator();
    	while (iter.hasNext()) {
    		successorNodes.add(iter.next().getOut());
    	}
        return successorNodes;
    }
    

    @Override
    public void addNode(INode n) {
    }

    @Override
    public ArrayList<INode> search(int start, int finish) {

        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> outNodes = new ArrayList<>();

        q.add(start);
        while (!q.isEmpty()) {
        	int m = q.remove();
        	visited.add(m);
        	outNodes = successors(m);
        	for(int out: outNodes){
        		if(out == finish){
        	    	visited.add(out);
        	    	return findPath(visited);
        	    }
        	    if(!visited.contains(out) && out != 0 && !q.contains(out)){
            	    q.add(out);	
        	    }
        	}         
        }
        return findPath(visited);
    }
    
    
    private ArrayList<INode> findPath(ArrayList<Integer> nodes) {
        ArrayList<INode> path = new ArrayList<>();
        
        //add finish to the path
        path.add(graph.get(nodes.get(nodes.size() - 1)));

        int index = nodes.size() - 1;
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();;

        while (index != 0) {
        	connectedNodes = successors(nodes.get(index));
            for (int i = 0; i < index; i++) {
            	if(connectedNodes.contains(nodes.get(i))){
            		path.add(graph.get(nodes.get(i)));
            		index = i;
            	}
            }
        }
        Collections.reverse(path);
        return path;
    }
    

}
