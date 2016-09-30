
public interface MultiGraphADT {
   
	//structure of Nodes
	
	//Structure of Edges probably List of Edges?
	
	//
   
   public Node getStations();
   
   public void search();
   
   public void addLine(Node n1, Node n2, String color);
   
   public void removeLine(Node n1, Node n2, String color);

   }
