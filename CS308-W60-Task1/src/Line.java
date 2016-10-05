
public class Line implements IEdge{
	private String colour;
	private INode in, out;
	private boolean visited;	
	
	public Line(INode in, INode out, String colour){
		this.colour= colour;
		this.in = in;
		this.out = out;
		this.setVisited(false);
	}
	
	public INode getIn(){
		INode inCopy = this.in;
		return inCopy;
	}
	
	public INode getOut(){
		INode outCopy = this.out;
		return outCopy;
	}
	
	public void setIn(INode node){
		this.in = node;
	}
	
	public void setOut(INode node){
		this.out = node;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public String getColour(INode node) {
		return this.colour;
	}

	public void setVisited(boolean b) {
		this.visited = b;
	}
}
