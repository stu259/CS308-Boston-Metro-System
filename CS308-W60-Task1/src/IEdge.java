
public interface IEdge {

	boolean visited = false;	
	INode in = null;
	INode out = null;
	
	public INode getIn();

	public INode getOut();
	
	public void setIn(INode node);
	
	public void setOut(INode node);
	
	public boolean isVisited();
	
	public String getColour(INode node);
	
}
