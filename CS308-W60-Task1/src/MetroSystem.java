import java.util.*;

public class MetroSystem {
	Graph BostonMS;
	List<String> firstCol = new ArrayList<String>();
	List<String> secondCol = new ArrayList<String>();
	List<String> lastMatch = new ArrayList<String>();
	int changeCount = 0;
	String output ="";
	boolean sameLine;
	
	public MetroSystem(int gNodes){
		BostonMS = new Graph();
		
	}
	
	  public void finalOutput(ArrayList<INode> path){
			for(int i = 1; i <path.size(); i++){
				firstCol = BostonMS.getColourList(path.get(i - 1).getId());
				secondCol = BostonMS.getColourList(path.get(i).getId());
				
				if(lastMatch != null )
					for(int m = 0; m<lastMatch.size();m++){
						if(!(firstCol.contains(lastMatch)) && !(secondCol.contains(lastMatch))){
							changeCount++;
						}
					}
				else{
					for(int j = 0; j < firstCol.size(); j++){
						for(int k = 0; k <secondCol.size(); k++){
							if(firstCol.contains(secondCol.get(k)) || secondCol.contains(firstCol.get(j))){
								if(firstCol.contains(secondCol.get(k))) lastMatch.add(secondCol.get(k));
								if (secondCol.contains(firstCol.get(j))) lastMatch.add(firstCol.get(j));
								sameLine = true;
							}
						}
					}
				}
				if(firstCol.size() == 1 && secondCol.size() == 1 && !(firstCol.contains(secondCol.get(0))) && sameLine != true){
					changeCount++;
				}
				else if(firstCol.size() > 1 && sameLine != true) {
					for(int j = 0; j < firstCol.size(); j++){
						for(int k = 0; k <secondCol.size(); k++){
							if(firstCol.get(j) != secondCol.get(k)){
								changeCount++;
							}
						}
					}
				}
				else if(secondCol.size() > 1 && sameLine != true){
					for(int j = 0; j < firstCol.size(); j++){
						for(int k = 0; k <secondCol.size(); k++){
							if(firstCol.get(j) != secondCol.get(k)){
								changeCount++;
							}
						}
					}
				}
				sameLine = false;
				
			}
			
			if(changeCount >= 1){
				output = "There's a change!!!";
			}
			else {
				output = "NO CHANGE!";
			}
			
			firstCol = null;
			secondCol = null;
			System.out.println(output + "The value of sameLine = " + sameLine + "The output of change counter = " + changeCount);
			
		}
}
