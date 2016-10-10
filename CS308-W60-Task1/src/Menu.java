import java.util.ArrayList;

public class Menu {
	
	
	private static CLIDisplay display = new CLIDisplay();
	private static MetroSystem ms;
	
	public Menu(MetroSystem system){
		ms = system;
		mainMenu();
		
	}
	
	  
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
   
   //tentative
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
	   for(INode n: ms.BostonMS.search(fromStation, toStation)){
		   System.out.println(n.getId() + " " + n.getName());
	   }

	   
	   // add search caller here! 
   }
   
   //shitty feature placeholder
   private static void listStations(){
	   for(int i=1; i<ms.BostonMS.getStationList().size()+1; i++){
		   System.out.println(ms.BostonMS.getNode(i).getId()+" Name: "+ms.BostonMS.getNode(i).getName());
	   }
   }
   
   //Could use integer as parameter and pass it to exit()
   //Quit System
   private static void quit(){
	   System.exit(0);
   }
   
   //tentative method -- final version will be made after we know how we want the thing to look
   public void DisplayRoute(Station[] array){
	   //boolean linechange = false;

	   System.out.println("So, you're taking the train from");
	   for(Station x: array){  
	   System.out.println(x.getName());
	   }
	   System.out.print(" and you'll be there in no time! ");
	   
	   System.out.println("Mind the Gap, between the train and the platform...");
	   
   }
   
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
