
public class Line implements IEdge{
	private String colour;
	private int in, out;
	private boolean visited;	
	
	public Line(int in, int out, String colour){
		this.colour= colour;
		this.in = in;
		this.out = out;
		this.setVisited(false);
	}
	
	public int getIn(){
		int inCopy = this.in;
		return inCopy;
	}
	 
	public int getOut(){
		int outCopy = this.out;
		return outCopy;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public String getColour() {
		return this.colour;
	}

	public void setVisited(boolean b) {
		this.visited = b;
	}
}
