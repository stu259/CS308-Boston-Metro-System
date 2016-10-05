import java.util.*;

public class Station implements INode {
	
	private String Name;
	private int ID;
	private ArrayList<Line> lines;
	
	public Station(int ID, String Name) {
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
	
	public ArrayList<IEdge> getLines() {
		return new ArrayList<IEdge>(this.lines);
	}

}
