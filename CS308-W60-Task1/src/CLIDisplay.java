import java.util.Scanner;

//use the parser for tokenizing and all that jazz

import javax.management.relation.InvalidRoleInfoException;

public class CLIDisplay implements IDisplay{

	Scanner scan;
	String promptSymbol;
	
	
	/**
	 * Constructor
	 * @effects	
	 * 			initializes the prompt symbol
	 */
	public CLIDisplay(){
		promptSymbol = ">>";
	}
	
	/***
	 * @author Junaid 
	 * @param 
	 * 			String text that will prompt the user of what type of data that's required of them.
	 * 			Array of Strings as options menu that are displayed with their option number
	 * 
	 * @return
	 * 			the number of option selected based on options list
	 */
	@Override
	public int getChoiceOptions(String[] options, String promptMessage) {
		// TODO Auto-generated method stub
		boolean validInput = false;
		
		int startingOptionNum = 1;
		int currOptionNum;
		int chosenOption = -1; //since user hasnt chosen anything yet
		
		// the highest number of choice a user can make
		int upperOptionNum = options.length;
		
		// the lowest number of choice a user can make
		int lowerOptionNum = 1;
		
		while(!validInput){
			currOptionNum = startingOptionNum;
			
			System.out.println(" ");
			System.out.println(promptMessage);
			
			for(String choice: options){
				System.out.println(Integer.toString(currOptionNum)+ "." + choice);
				currOptionNum++;
			}
			
			System.out.println(promptSymbol);
			
			try{
				scan = new Scanner(System.in);
				chosenOption = scan.nextInt();
				validInput = true;
				
				if(chosenOption < lowerOptionNum || chosenOption > upperOptionNum){
					System.out.println("Input must be between "+Integer.toString(lowerOptionNum)
													+" and "+Integer.toString(upperOptionNum));
					validInput = false;
					
				}
			}
			catch(Exception e){
				System.out.println("Input must be a number");
				validInput = false;
			}
		}
		
		return chosenOption;
	}

	
	/**
	 * @author Junaid
	 * @param
	 * 			String text that will prompt the user of what type of data that's required of them.
	 * @return	returns the user choice in a text form
	 */
	@Override
	public String getUserInput(String promptMessage){
		
		scan = new Scanner(System.in);
		boolean validInput = false;
		String userInput = null;
		while(!validInput){
			System.out.println(promptMessage);
			userInput = scan.nextLine();
			
			if((userInput.matches("[0-9]+"))){ //pattern matching and checking if the user only entered numbers
				System.out.println("You entered numbers only, that's not a station name...");
			}
			else
				validInput = true;
			
		}
		
		
		return userInput;
	}

}