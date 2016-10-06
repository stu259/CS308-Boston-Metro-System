
public interface IEdge {

	boolean visited = false;	
	INode in = null;
	INode out = null;
	
	public int getIn();

	public int getOut();
	
	public boolean isVisited();
	
	public String getColour(INode node);
	
	public void setVisited(boolean b);
	
}
