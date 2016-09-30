
public interface Edge {

	boolean visited = false;	
	Node in = null;
	Node out = null;
	
	public Node getIn();

	public Node getOut();
	
	public void setIn(Node node);
	
	public void setOut(Node node);
	
	public boolean isVisited();
	
	public String getColour(Node node);
	
}
