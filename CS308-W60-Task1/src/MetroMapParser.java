import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*
;

    /**
     * This class reads a text description of a metro subway system
     * and generates a graph representation of the metro.
     *
     * Students should feel free to modify this code as needed
     *  to complete this exercise.
     *
     *<p>
     *
     * The grammar for the file is described below in BNF. A typical line
     * in the file looks like this :
     *
     * <code> 20 NorthStation   Green 19 22  Orange 15 22  </code>
     *
     * where :
     *         20 is the StationID
     *         NorthStation is the StationName
     *         Green 19 22
     *                  Green is the LineName
     *                  19 is the StationID of the outbound station
     *                  22 is the StationID of the inbound station
     *         Orange 15 22 is a LineID in which :
     *                  Orange is the LineName
     *                  15 is the StationID of the outbound station
     *                  22 is the StationID of the inbound station
     *
     *         Therefore, NorthStation has two outgoing lines.
     *
     *  note : 0 denotes the end of a line : i.e. in this case,
     *  OakGrove would be at the end of the line, as there is no other outbound 
     *  station.
     *
     *<p>
     * metro-map ::= station-spec* <BR>
     * station-spec ::= station-id station-name station-line+ <BR>
     * station-id ::= (positive integer) <BR>
     * station-name ::= string <BR>
     * station-line ::= line-name station-id station-id <BR>
     *
     */

public class MetroMapParser
{
	//arrays for capturing data from the file
	private ArrayList<Integer> id = new ArrayList<>();
	private ArrayList<String> name = new ArrayList<>();
	private List<ArrayList<String>> lineColours;
	private List<ArrayList<Integer>> inID;
	private List<ArrayList<Integer>> outID;
    private BufferedReader fileInput;
    

    
    public static void main(String[] args)
    {
		
		if(args.length != 1)
		{
		    usage();
		    System.exit(0);
		}
	
		String filename = args[0];
		
		
		try
		{
		    MetroMapParser mmp = new MetroMapParser(filename);
		    mmp.generateGraphFromFile();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
    }


    private static void usage()
    {
	//prints a usage message to System.out
	System.out.println("java ex3.MetroMapParser <filename>");
    }

    
    /**
     * @effects: creates a new parser that will read from the file 
     * filename unless the file does not exist. The filename should specify
     * the exact location of the file. This means it should be something like
     * /mit/$USER/6.170/ex3/bostonmetro.txt
     *
     * 
     * @throws java.io.IOException if there <tt>filename</tt> cannot be read
     *
     * @returns a new MetroMapParser that will parse the file filename
     */
    
    public MetroMapParser(String filename) throws IOException
    {
	//a buffered reader reads line by line, returning null when file is done
	fileInput = new BufferedReader(new FileReader(filename));
    }

    /**
     * @throws Exception 
     * @effects: parses the file, and generates a graph from it, unless there
     * is a problem reading the file, or there is a problem with the format of the
     * file.
     *
     * @throws ex3.BadFileException if there is a problem with the format of the file
     *
     * @returns the Graph generated by the file
     */

    public  void  generateGraphFromFile()
	throws Exception
    {

	String line = fileInput.readLine();
	StringTokenizer st;
	String stationID;
	String stationName;
	String lineName;
	String outboundID, inboundID;
	
	
	//initialising the arrays for storing the line data
	ArrayList<Integer> inStations = new ArrayList<Integer>();
	inID = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> outStations = new ArrayList<Integer>();
	outID = new ArrayList<ArrayList<Integer>>();
	ArrayList<String> colour = new ArrayList<String>();
	lineColours = new ArrayList<ArrayList<String>>();
	
	
	while(line != null)
	{	
		
		
	    //STUDENT :
	    //
	    //in this loop, you must collect the information necessary to 
	    //construct your graph, and you must construct your graph as well.
	    //how and where you do this will depend on the design of your graph.
	    //

	    
	    //StringTokenizer is a java.util Class that can break a string into tokens
	    // based on a specified delimiter.  The default delimiter is " \t\n\r\f" which
	    // corresponds to the space character, the tab character, the newline character,
	    // the carriage-return character and the form-feed character.
	    st = new StringTokenizer(line);

	    //We want to handle empty lines effectively, we just ignore them!
	    if(!st.hasMoreTokens())
	    {
			line = fileInput.readLine();
			continue;
	    }
	    
	    //from the grammar, we know that the Station ID is the first token on the line
	    stationID = st.nextToken();
	    //adds the station id to the stationId array
	    id.add(Integer.parseInt(stationID));
	    
	    
	    if(!st.hasMoreTokens())
	    {
	    	throw new Exception("no station name");
	    }

	    //from the grammar, we know that the Station Name is the second token on the line.
	    stationName = st.nextToken();
	    //adds station name to appropriate array
	    name.add(stationName);
	    
	    
	    if(!st.hasMoreTokens())
	    {
	    	throw new Exception("station is on no lines");
	    }
	    
	    //this loop collects data about the multiple lines for station
	    while(st.hasMoreTokens())
	    {
			lineName = st.nextToken();
				
			if(!st.hasMoreTokens())
			{
			    throw new Exception("poorly formatted line info");
			}
	
			outboundID = st.nextToken();
			
			if(!st.hasMoreTokens())
			{
			    throw new Exception("poorly formatted adjacent stations");
			}
	
			inboundID = st.nextToken();
			
			
			/*needs comments here and below*/
			colour.add(lineName);
			inStations.add(Integer.parseInt(inboundID));
			outStations.add(Integer.parseInt(outboundID));
	    }
	    //adds the list of colours, in and out stations to appropriate arrays.
	    
	    inID.add(inStations);
	    outID.add(outStations);
	    lineColours.add(colour);
	    inStations = new ArrayList<Integer>();
	    outStations = new ArrayList<Integer>();
	    colour = new ArrayList<String>();
		
	    line = fileInput.readLine();
	}
	
       
    }
    
    //getters for all the arrays which hold data to construct the graph
    public int getStationID(int idNum){
    	return id.get(idNum);
    }
    
    public String getStationName(int idNum){
    	return name.get(idNum);
    }
    
    /**
     * 
     * @param idNum
     * @return a list of all inbound nodes connected to the node with id idNum
     */
    public ArrayList<Integer> getInID(int idNum){
    	return inID.get(idNum);
    }
    /**
     * 
     * @param idNum
     * @return a list of all outbound nodes connected to the node with id idNum
     */
    
    public ArrayList<Integer> getOutID(int idNum){
    	return outID.get(idNum);
    }
    
    /**
     * 
     * @param idNum
     * @return a list of all colours for the node with id idNum
     */
    
    public ArrayList<String> getColours(int idNum){
    	return lineColours.get(idNum);
    }
    
    public int getNumNodes(){
    	return id.size();
    }
}
		