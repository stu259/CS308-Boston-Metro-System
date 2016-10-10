import java.util.ArrayList;

public interface MultiGraphADT {
   
   
   public ArrayList<IEdge> search(int n1,int n2);
   
   public void addEdge(int n1, int n2, String color);
   
   public void addNode(INode n);
   
   public INode getNode(int id); 

   }
