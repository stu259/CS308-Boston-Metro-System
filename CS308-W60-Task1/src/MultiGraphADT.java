import java.util.ArrayList;
import java.util.List;

public interface MultiGraphADT {
   
	//structure of Nodes
	
	//Structure of Edges probably List of Edges?
	
	//
   
   
   public void search();
   
   public void addEdge(int n1, int n2, String color);
   
   public void addNode(INode n);
   
   public INode getNode(int id);
   
   ArrayList<Integer> successors(int node);

      
   

   }
