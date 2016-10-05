public class Driver {
	
	 private static CLIDisplay display = new CLIDisplay();;
   public static void main(String[] args) {
      mainMenu();
	   // TODO implement this operation
     // throw new UnsupportedOperationException("not implemented");
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
