import java.util.ArrayList;

public class Menu {
	
	
	private static CLIDisplay display = new CLIDisplay();
	private static MetroSystem ms;
	
	/**
	 * 
	 * @param MetroSystem graph copy that was cloned and sent to this main menu for
	 * reference. It then calls the Main Menu for user interaction
	 */
	public Menu(MetroSystem system){
		ms = system;
		mainMenu();
		
	}
	
	/**
	 * Initiates User Interaction Main Menu to ask user out of given options.
	 */
   private static void mainMenu(){
		
		System.out.println("Welcome to W6 Boston Metro System");
		
		String[] mainMenu= { "Get Directions", "List All Stations", "Quit Application"	};
		while(true){
			switch(display.getChoiceOptions(mainMenu, "What would you like to do?")){
				case 1: directionMenu(); break;
				
				case 2: listStations(); break;
				
				case 3: quit(); break;
			};
		}
	}
   
   //tentative -- we need to add a better way to display the how to tell the user which line to take and when to change
   private static void directionMenu(){
	   boolean checkFrom = false, checkTo = false;
	   int fromStation= 0, toStation = 0;
	   
	   ArrayList<INode> toStationList = new ArrayList<>();
	   ArrayList<INode> fromStationList = new ArrayList<>();
	   
	   String promptMessage = "What station are you going from?";
	   
	   while(!checkFrom){
		   String userInputFrom = display.getUserInput(promptMessage);
		   userInputFrom = userInputFrom.toLowerCase();

		   for(int i = 1 ; i <= ms.BostonMS.getStationList().size(); i++){
			   INode s = ms.BostonMS.getNode(i);
			   
			   if (userInputFrom.equals(s.getName().toLowerCase())){

				   fromStationList.add(s);
			   }
		   }

		   if(fromStationList.size() > 1){
			   
			   String[] options = generateStationList(fromStationList);
			   int userChoice = display.getChoiceOptions(options, "Which Station did you mean?");
			   
			   switch(userChoice){
			   		case 1:
			   			fromStation = fromStationList.get(0).getId();
			   			checkFrom = true;
			   			break;
			   		case 2:
			   			fromStation = fromStationList.get(0).getId();
			   			checkFrom = true;
			   			break;
			   }
			   
		   }
		   else if(fromStationList.size() == 1){
			   fromStation = fromStationList.get(0).getId();
			   checkFrom = true;
		   }
	   promptMessage = "Wanna re-enter the station name?";
	   }
	  
	   promptMessage = "Which station are you going to?";
	   while(!checkTo){
		   String userInputTo = display.getUserInput(promptMessage);
		   userInputTo = userInputTo.toLowerCase();
		   for(int i = 1 ; i <= ms.BostonMS.getStationList().size(); i++){
			   INode s = ms.BostonMS.getNode(i);
			   
			   if (userInputTo.equals(s.getName().toLowerCase())){
				   //User is not stupid and input is correct
				   toStationList.add(s);
				   
			   }
		   }
		   
		   if(toStationList.size() > 1){

			   String[] options = generateStationList(toStationList);
			   
			   int userChoice = display.getChoiceOptions(options, "Which Station did you mean?");
			   
			   switch(userChoice){
		   		case 1:
		   			toStation = toStationList.get(0).getId();
		   			checkTo = true;
		   			break;
		   		case 2:
		   			toStation = toStationList.get(0).getId();
		   			checkTo = true;
		   			break;
		   }
		   }
		   else if (toStationList.size() == 1){
			   toStation = toStationList.get(0).getId();
			   checkTo = true;
		   }
	   promptMessage = "Wanna re-enter the station name?";
	   }
	   
	   
	   System.out.println("NOW!, we search!");
	   ArrayList<IEdge> edges = ms.BostonMS.search(fromStation, toStation);
	   ArrayList<String> directions = new ArrayList<String>();
	   String colour = edges.get(0).getColour();
	   int stationOne = edges.get(0).getOut();
	   int stationTwo = edges.get(edges.size() - 1).getIn();
	   for(int i = 1; i < (edges.size() - 1); i++){
		   if(!(colour.equals(edges.get(i).getColour()))){
			   stationTwo = edges.get(i - 1).getIn();
			   directions.add(addToDirections(stationOne, stationTwo, directions, colour));
			   colour = edges.get(i).getColour();
			   stationOne = edges.get(i - 11).getIn();
		   }
		  // System.out.println(e.getOut() + " " + e.getIn() + " " + e.getColour());
		   
	   }
	   stationTwo = edges.get(edges.size() - 1).getIn();
	   directions.add(addToDirections(stationOne, stationTwo, directions, colour));
	   for(int i = 0; i <= directions.size() - 1; i++){
		   System.out.println(directions.get(i));
	   }
   }
   
   private static String addToDirections(int station1, int station2, ArrayList<String> directions, String colour){
	   String direction = "Get the train from " + ms.BostonMS.getNode(station1).getName() + " to " + ms.BostonMS.getNode(station2).getName() + " on the " + colour + " line.";
	   return direction;
   }
   
   
   
   /**
    *  List all the stations from the reference graph to print out a list
    */
   private static void listStations(){
	   for(int i=1; i<ms.BostonMS.getStationList().size()+1; i++){
		   System.out.println(ms.BostonMS.getNode(i).getId()+" "+ms.BostonMS.getNode(i).getName());
	   }
   }

   //Quit System
   private static void quit(){
	   System.exit(0);
   }
   
   //tentative method -- final version will be made after we know how we want the thing to look
   public void DisplayRoute(Station[] array){

	   System.out.println("So, you're taking the train from");
	   for(Station x: array){  
	   System.out.println(x.getName());
	   }
	   System.out.print(" and you'll be there in no time! ");
	   
	   System.out.println("Mind the Gap, between the train and the platform...");
	   
   }
   
   /**
    * 
    * @param array
    * @return
    * 		an array of string text that are used for options.
    * 
    * This method passes through the arrayList and gets a station's line's color and neighbour station
    * So that we can tell the user more about a duplicate station.
    */
   private static String[] generateStationList(ArrayList<INode> array){
	   String options[] = new String [2];
	   for(int i=0; i<array.size(); i++){
		  String tempcolor = ms.BostonMS.getColourList(array.get(i).getId()).get(0);
		   
		  String neighbour = ms.BostonMS.getNeighbour(array.get(i).getId()).getName();
		  
		   options[i] = array.get(i).getName() +" on line "+ tempcolor + " alongside " +neighbour+" station?";
	   }
	   
	   return options;
   }
}
