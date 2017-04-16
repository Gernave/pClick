import java.sql.*;
import java.util.ArrayList;


public class DBConnect {
 private Connection con; 
 private Statement st; 
 private ResultSet rs;
 ArrayList<String> cour = new ArrayList<String>(); 
 ArrayList<String> ids = new ArrayList<String>(); 
 ArrayList<String> ans = new ArrayList<String>(); 
  //DropDown options;

 public DBConnect(){
	// options = new DropDown(); 
	 try{ 
		 Class.forName("com.mysql.jdbc.Driver");
	     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clicker", "root", "");
	     st = con.createStatement();
		 
	 }catch(Exception ex){
		 System.out.println("Error: " + ex); 
		 
	 }
 } 
 
 
 public ArrayList<String> getcoursename(){ 
	 try{ 
		 String query = "SELECT course_name FROM courses"; 
		 rs = st.executeQuery(query); 
		 System.out.println("Records from database");
		 while(rs.next()){ 
			// String id = rs.getString("id");
			 String coursename = rs.getString("course_name"); 
			 System.out.println("The courses are: " + coursename);
			 cour.add(coursename);
			 
		 }
		 
		 
	 }catch(Exception ex){ 
		 System.out.println(ex);
	 }
	 return cour; 
 }
 
 public ArrayList<String> getsession(){ 
	 try{ 
		 String query = "SELECT id FROM sessions WHERE course_id = 1"; 
		 rs = st.executeQuery(query); 
		 System.out.println("Records from database");
		 while(rs.next()){ 
			// String id = rs.getString("id");
			 String id = rs.getString("id"); 
			 System.out.println("The answer is: " + id);
			 ans.add(id);
			 
			 
		 }
		 
	 }catch(Exception ex){ 
		 System.out.println(ex);
	 }
	 return ans; 
 }
	 
	 
	 public ArrayList<String> getQuestions(){ 
		 try{ 
			 String query = "SELECT name FROM questions WHERE session_id = 1";
			
			 rs = st.executeQuery(query); 
			 System.out.println("Records from database");
			 while(rs.next()){ 
				// String id = rs.getString("id");
				 String qname = rs.getString("name"); 
				 System.out.println("The clicker ID is: " + qname);
				 ids.add(qname); 
			 }
			 
		 }catch(Exception ex){ 
			 System.out.println(ex);
		 }
	 
		 return ids;  
	 
	 
 }
 
 
 
	
	
	
}
