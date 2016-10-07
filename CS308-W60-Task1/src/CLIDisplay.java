import java.util.Scanner;

//use the parser for tokenizing and all that jazz

import javax.management.relation.InvalidRoleInfoException;

public class CLIDisplay implements IDisplay{

	Scanner scan;
	String promptSymbol;
	
	public CLIDisplay(){
		promptSymbol = ">>";
	}
	
	/*
	 * (non-Javadoc)
	 * @see IDisplay#getChoiceOptions(java.lang.String[], java.lang.String)
	 * 
	 * An array of strings as options that are to be selected. And a prompt
	 * message.
	 * 
	 * @return: integer value of the number of option selected.
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

	@Override
	public int getInt(int minLimit, int maxLimit, String promptMessage) {
		
		int userInput = -1;
		boolean validInput = false; //since user has not entered anything
		String rangeWarning = "Your input should be within "+Integer.toString(minLimit)+" and "+Integer.toString(maxLimit);

		
		while(!validInput){
			System.out.println(" ");
			System.out.println(promptMessage);
			
			try{
				System.out.println(promptSymbol);
				scan = new Scanner(System.in);
				userInput = scan.nextInt();
				validInput = true;
				
				if(userInput < minLimit || userInput > maxLimit){
					System.out.println(rangeWarning);
					validInput = false;
				}
			}
			catch(Exception e){
				System.out.println("Error: "+e);
				validInput = false;
			}
		}
		return userInput;
	}
	
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