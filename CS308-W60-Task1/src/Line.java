
public class Line implements Edge{
	private String colour;
	private Node in, out;
	private boolean visited;	
	
	public Line(Node in, Node out, String colour){
		this.colour= colour;
		this.in = in;
		this.out = out;
		this.setVisited(false);
	}
	
	public Node getIn(){
		Node inCopy = this.in;
		return inCopy;
	}
	
	public Node getOut(){
		Node outCopy = this.out;
		return outCopy;
	}
	
	public void setIn(Node node){
		this.in = node;
	}
	
	public void setOut(Node node){
		this.out = node;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public String getColour(Node node) {
		return this.colour;
	}

	public void setVisited(boolean b) {
		this.visited = b;
	}
}
