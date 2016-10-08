import java.util.*;

import static javax.swing.UIManager.get;


public class Graph implements MultiGraphADT {

    //Hashmap has Stations instead of INodes because Station is the concrete class and INode is just interface
    private ArrayList<Line> lineList = null;
    private HashMap<Integer, Set<IEdge>> nodeEdges = new HashMap<>();
    private HashMap<Integer, Station> graph = new HashMap<>();


    public Graph(int N) {
        lineList = new ArrayList<>();

    }

    @Override
    public void addEdge(int n1, int n2, String color) {
       if (!(isEdge(n1, n2, color))) {
            nodeEdges.get(n1).add(new Line(n1, n2, color));
            nodeEdges.get(n2).add(new Line(n1, n2, color));
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

	/*public boolean isStation(INode station) { // existNode()
		return (getNode(station))
	}*/

    public boolean isNode(int node) {
        return nodeEdges.containsKey(node);
    }

    public void addNode(int id, String name) {
        graph.put(id, new Station(id, name));
    }

    public ArrayList<Integer> successors(int node) {
        ArrayList<Integer> successorNodes = new ArrayList<>();
        for (int i = 0; i < nEdges(); i++)
            if (lineList.get(i).getIn() == node)
                successorNodes.add(lineList.get(i).getOut());
        return successorNodes;
    }

    @Override
    public void addNode(INode n) {
    }



    private boolean isEdge(int n1, int n2) { // needed?
        int i = 0;
        while (i < nEdges()) {
            if ((lineList.get(i).getIn() == n1) && (lineList.get(i).getOut() == n2)
                    || (lineList.get(i).getIn() == n2) && (lineList.get(i).getOut() == n1))
                return true;
            else {
                i++;
            }
        }
        return false;
    }

    @Override
    public ArrayList<INode> search(int start, int finish) {

        int in = 0, out = 0;

        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        if (isEdge(start, finish)) {
            q.add(start);
            q.add(finish);
        } else {
            visited.add(start);
            q.add(start);
            while (!q.isEmpty()) {
                int m = q.remove();
                //in = graph.get(m).getLines().get(j).getIn();// J should be variable of the size of number of lines that this node is connected to
                //out = graph.get(m).getLines().get(j).getOut();
                if (in == finish) {
                    visited.add(in);
                    return findPath(visited);
                } else if (out == finish) {
                    visited.add(out);
                    return findPath(visited);
                } else {
                    if (!visited.contains(in) && 0 != in)
                        visited.add(in);
                    if (!visited.contains(out) && 0 != out)
                        visited.add(out);
                    if (m != in && 0 != in)
                        q.add(in);
                    if (m != out && 0 != out)
                        q.add(out);
                }
            }
        }
        //we should never get to here as there should always be a path
        return null;
    }

    private ArrayList<INode> findPath(ArrayList<Integer> nodes) {//dont touch
        ArrayList<INode> path = new ArrayList<>();

        path.add(graph.get(nodes.get(nodes.size() - 1)));

        int index = nodes.size() - 1;

        while (index != 0) {
            for (int i = 0; i < index; i++) {
                if (isEdge(path.get(path.size() - 1).getId(), nodes.get(i))) {
                    path.add(graph.get(nodes.get(i)));
                    index = i;
                }
            }
        }
        Collections.reverse(path);
        return path;
    }

}
