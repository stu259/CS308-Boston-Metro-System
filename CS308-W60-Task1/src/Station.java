import java.util.*;

public class Station implements Node {
	
	private String Name;
	private int ID;
	private ArrayList<Line> lines;
	
	public Station(String Name) {
		this.Name = Name;
	}

	@Override
	public void setName(String value) {
		this.Name = value;

	}

	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public void setId(int value) {
		this.ID = value;

	}

	@Override
	public int getId() {
		return this.ID;
	}
	
	public ArrayList<Edge> getLines() {
		return new ArrayList<Edge>(this.lines);
	}

}
