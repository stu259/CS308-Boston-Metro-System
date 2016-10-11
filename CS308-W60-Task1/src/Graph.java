import java.util.*;


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
    
    private ArrayList<IEdge> getEdges(int n1, int n2){
    	ArrayList<IEdge> edges = new ArrayList<>();
    	for(int i = 0; i < nodeEdges.size(); i++){
    		for(IEdge e: nodeEdges.get(i)){
    			if(e.getIn() == n1 && e.getOut() == n2)
    				edges.add(e);
    		}
    	}
    	return edges;
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
    public ArrayList<IEdge> search(int start, int finish) {

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
    
    
    private ArrayList<IEdge> findPath(ArrayList<Integer> nodes) {
        //ArrayList<INode> path = new ArrayList<>();
        ArrayList<IEdge> path = new ArrayList<>();
        ArrayList<IEdge> edges = new ArrayList<>();
        //add finish to the path
        //path.add(graph.get(nodes.get(nodes.size() - 1)));

        int index = nodes.size() - 1;
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();;

        while (index != 0) {
        	connectedNodes = successors(nodes.get(index));
            for (int i = 0; i < index; i++) {
            	if(connectedNodes.contains(nodes.get(i))){
            		edges = getEdges(nodes.get(index),nodes.get(i));
            		if(edges.size() > 1){
            			if(path.isEmpty()){
            				/*Get the first node's edge list and its colours.
            				 * Check if the first colour match the last edge's colour
            				 * IF it matches then add the edge with the same colour in the path
            				 * otherwise add the other edge (there should only be 2 edges with different colours and same nodes)
            				 * */
            				if((getColourList(nodes.get(nodes.size() - 1)).get(0).equals(getEdges(nodes.get(0),nodes.get(1)).get(0).getColour()))){
            					path.add(edges.get(0));
            				}else{
            					path.add(edges.get(1));
            				}
            			}else{
            				if(path.get(path.size()-1).getColour().equals(edges.get(0).getColour()))
            					path.add(edges.get(0));
            				else
            					path.add(edges.get(1));
            				
            			}
            		}else{
            			path.add(edges.get(0));
            		}
            		index = i;
            	}
            }
        }
        Collections.reverse(path);
        return path;
    }
    

}
