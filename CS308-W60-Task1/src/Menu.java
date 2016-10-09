
public class Menu {
	
	
	private static CLIDisplay display = new CLIDisplay();
	private static MetroSystem ms;
	
	public Menu(MetroSystem system){
		ms = system;
		mainMenu();
		
	}
	
	  
   private static void mainMenu(){
		
		System.out.println("Welcome to W6 Boston Metro System");
		
		String[] mainMenu= { "Get Directions", "Do Other Shit?", "Quit Application"	};
		
		switch(display.getChoiceOptions(mainMenu, "What would you like to do?")){
			case 1: directionMenu(); break;
			
			case 2: helloWorld(); break;
			
			case 3: quit(); break;
		};
		
	}
   
   //tentative
   private static void directionMenu(){
	   boolean checkFrom = false, checkTo = false;
	   String fromStation= null, toStation = null;
	   while(!checkFrom){
		   String userInputFrom = display.getUserInput("What station are you going from?");

		   for(int i = 1 ; i <= ms.BostonMS.getStationList().size(); i++){
			   INode s = ms.BostonMS.getNode(i);
			   
			   if (userInputFrom.equals(s.getName())){
				   //User is not stupid and input is correct
				   fromStation = s.getName();
				   checkFrom = true;
				   break;
			   }
		   }
	   }
	
	   while(!checkTo){
		   String userInputTo = display.getUserInput("Which station are you going to?");
		   for(int i = 1 ; i <= ms.BostonMS.getStationList().size(); i++){
			   INode s = ms.BostonMS.getNode(i);
			   if (userInputTo.equals(s.getName())){
				   //User is not stupid and input is correct
				   toStation = s.getName();
				   checkTo = true;
				   break;
			   }
		   }
	   }
	   
	   System.out.println("You're going from "+fromStation+" to "+toStation);
	   System.out.println("to be continued ....");
	   
	   // add search caller here! 
   }
   
   //shitty feature placeholder
   private static void helloWorld(){
	   System.out.println("HelloWorld!");
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
}