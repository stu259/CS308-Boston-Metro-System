import java.util.ArrayList;

public class Line implements Edge{
	private String colour;
	private Node in, out;
	private boolean visited;
	private ArrayList<String> strings;
	
	
	public Line(Node in, Node out, String colour){
		this.colour= colour;
		this.in = in;
		this.out = out;
		this.visited = false;
	}
	
	public Node getIn(){
		return this.in;
		//need to make copy of passing such instances ... based on Sotiri's lecture on 28th Sept
	}
	
	public Node getOut(){
		return this.out;
	}
	
	public void setIn(Node node){
		this.in = node;
	}
	
	public void setOut(Node node){
		this.out = node;
	}
	
	public boolean isVisited() {
		return true;
	}
	
	public String getColour(Node node) {
		return this.colour;
	}
}
