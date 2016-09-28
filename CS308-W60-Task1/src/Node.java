import java.util.ArrayList;

// needs comments by Aaron3


public interface Node {
public void setOutbound(Node value);
    
	public ArrayList<Edge> edges = null;

   
   public void setName(String value);
   
   public String getName();
   
   public void setId(int value);
   
   public int getId();
  
   
   }
