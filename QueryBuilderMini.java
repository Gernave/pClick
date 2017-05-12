
public class QueryBuilderMini {
	
	
	public String a; 
	
	public String fquery(String sessName, String order, String orderCol){
		return "SELECT name, duration FROM questions WHERE session_id = " + sessName + " ORDER BY " + orderCol + " " + order ; 
	}
	
	
	
	
	
	
	
}
