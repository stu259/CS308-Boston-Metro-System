//import java.util.*;

public class Station implements INode {
	
	private String Name;
	private int ID;

	/***
	 * Constructor class initializes variables
	 * @author Aaron
	 * @param ID
	 * @param Name
	 * 
	 * @effects ID and Name variable
	 */
	public Station(int ID, String Name) {
		this.Name = Name;
		this.ID = ID;
		
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
	
	//don't think we need this anymore
	/*
	public ArrayList<IEdge> getLines() {
		return new ArrayList<IEdge>(this.lines);
	}
	*/

}
