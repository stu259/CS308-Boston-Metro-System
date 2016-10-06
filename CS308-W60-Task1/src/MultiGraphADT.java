import java.util.ArrayList;

public interface MultiGraphADT {
   
   public void addEdge(int n1, int n2, String color);
   
   public void addNode(INode n);
   
   public INode getNode(int id);
   
   ArrayList<Integer> successors(int node);

   public void search(int start, int finish);

      
   

   }
