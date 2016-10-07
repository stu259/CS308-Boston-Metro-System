
public class Line implements IEdge{
	private String colour;
	private int in, out;
	
	public Line(int in, int out, String colour){
		this.colour= colour;
		this.in = in;
		this.out = out;
	}
	
	public int getIn(){
		int inCopy = this.in;
		return inCopy;
	}
	 
	public int getOut(){
		int outCopy = this.out;
		return outCopy;
	}
	
	
	public String getColour() {
		return this.colour;
	}

}
