import java.io.IOException;
import java.util.HashMap;

public class Driver {
	
	 
 static MetroMapParser mmp;
	 
/***
 * Main Class that runs the Metro Subway System
 * @param args
 * 
 * The main method class in a MetroMapParser and parses the whole list from the text
 * file. It then tries to generate Graph from that parsed file.
 * 
 * The created graph is now ............?
 */
   public static void main(String[] args) {
		   
		   try{
			   mmp = new MetroMapParser("bostonmetro.txt");
	   } 
	   catch (IOException e) {
			e.printStackTrace();
		}
	
	   try{
		   mmp.generateGraphFromFile();
	   } 
	   catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   MetroSystem ms = new MetroSystem(mmp.getNumNodes());
	   
	   //Filling the graph in from the parser
	   for(int i = 0; i < mmp.getNumNodes(); i++){
		   for(int j = 0; j < mmp.getInID(i).size(); j++){
			   ms.BostonMS.addEdge(mmp.getInID(i).get(j), mmp.getStationID(i), mmp.getColours(i).get(j));
			   ms.BostonMS.addEdge(mmp.getOutID(i).get(j), mmp.getStationID(i), mmp.getColours(i).get(j));
			   ms.BostonMS.addNode(mmp.getStationID(i), mmp.getStationName(i));
		   }
	   }
	   HashMap<Integer, Station> stationList = ms.BostonMS.getStationList();
	
	   //test code
	//	   for(INode n: ms.BostonMS.search(14, 22)){
	//		   System.out.println(n.getId() + " " + n.getName());
	//	   }
	
		//cloning and calling the next class for interaction menu
	   	MetroSystem clone = ms;
		new Menu(clone);
   }

   
   }
