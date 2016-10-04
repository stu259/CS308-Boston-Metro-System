/**
 *Interface used for displaying information to the user 
 *and allowing them to make choices
 */
public interface IDisplay extends java.io.Serializable{
	
	/***
	 * Used to display a number of choices to the user
	 * and allow them to choose one of the choices.
	 * 
	 * @param options - An array of option strings which represent the 
	 * 					available options the user has
	 * @return The index in the array of the option they chose + 1
	 */
	
	public abstract int getChoiceOptions(String options[], String promptMessage);
	
	public abstract int getInt(int minLimit, int maxLimit, String promptMessage);
	
}
