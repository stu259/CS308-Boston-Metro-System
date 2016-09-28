
public class Line implements Edge{
	private String Color;
	private Node in;
	private Node out;
	private boolean visited;
	
	
	public Line(Node in, Node out, String color){
		this.Color= color;
		this.in = in;
		this.out = out;
		this.visited = false;
	}
	
	public Node getIn(){
		return in;
		//need to make copy of passing such instances ... based on Sotiri's lecture on 28th Sept
	}
	
	public Node getOut(){
		return out;
	}
	
	public void setIn(Node node){
		this.in = node;
	}
	
	public void setOut(Node node){
		this.out = node;
	}
	
	public boolean isVisited()
}
