import java.io.IOException;

public class Driver {
	
	 private static CLIDisplay display = new CLIDisplay();
	 static MetroMapParser mmp;
	 
   public static void main(String[] args) {
      //mainMenu();
	   
	   try {
		   mmp = new MetroMapParser("bostonmetro.txt");
		} catch (IOException e) {
			//Probably wrong filepath... Derp
			//We should not get this point so might as well crash if we do.
			System.exit(0);
			e.printStackTrace();
		}

	   try {
		mmp.generateGraphFromFile();
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
	   MetroSystem ms = new MetroSystem(mmp.getNumNodes());
	   
	   //Testing Code
	   for(int i = 0; i < mmp.getNumNodes(); i++){
		   for(int j = 0; j < mmp.getInID(i).size(); j++){
			   ms.BostonMS.addEdge(mmp.getInID(i).get(j), mmp.getStationID(i), mmp.getColours(i).get(j));
			   ms.BostonMS.addEdge(mmp.getOutID(i).get(j), mmp.getStationID(i), mmp.getColours(i).get(j));
			   ms.BostonMS.addNode(mmp.getStationID(i), mmp.getStationName(i));
		   }
	   }
	   
	   for(int i = 1 ; i <= 124; i++){
		   INode s = ms.BostonMS.getNode(i);
		   System.out.println(s.getId() + " "+ s.getName());
		   
	   }
	   
	   //End of testing code
   }
   
   public void reader() {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   public void display() {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   private static void mainMenu(){
		
		System.out.println("Welcome to W6 Boston Metro System");
		
		String[] mainMenu= { "Get Directions", "Do Other Shit?", "Quit Application"	};
		
		switch(display.getChoiceOptions(mainMenu, "What would you like to do?")){
			case 1: directionMenu(); break;
			
			case 2: helloWorld(); break;
			
			case 3: Quit(); break;
		};
		
	}
   
   //tentative
   private static void directionMenu(){
	   String from = display.getUserInput("What station are you going from?");
	   String to = display.getUserInput("Which station are you going to?");
	   
	   System.out.println("You're going from "+from+" to "+to);
	   System.out.println("to be continued ....");
   }
   
   //shitty feature placeholder
   private static void helloWorld(){
	   System.out.println("HelloWorld!");
   }
   
   //Quit System
   private static void Quit(){
	   System.exit(0);
   }
   
   }
