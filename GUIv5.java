import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class DBConnectv1 {
 private Connection con; 
 private Statement st; 
 private ResultSet rs;
 private ResultSet rs1; 
 ArrayList<String> cour = new ArrayList<String>(); 
 ArrayList<String> ids = new ArrayList<String>(); 
 ArrayList<String> ans = new ArrayList<String>(); 
 ArrayList<String> strttime = new ArrayList<String>(); 
 TreeMap<String, String>IDnfans = new TreeMap<String, String>(); 
 ArrayList<String> dura = new ArrayList<String>();
 QueryBuilderMini qdm = new QueryBuilderMini(); 
 Map<String, String> temp = new LinkedHashMap<String, String>(); 
 
 
  //DropDown options;

 public DBConnectv1(){
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
		// System.out.println("Records from database");
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
		// System.out.println("Records from database");
		 while(rs.next()){ 
			// String id = rs.getString("id");
			 String id = rs.getString("id"); 
		//	 System.out.println("The answer is: " + id);
			 ans.add(id);
			 
			 
		 }
		 
	 }catch(Exception ex){ 
		 System.out.println(ex);
	 }
	 return ans; 
 }
	
	
	 
	
	 
	 
	 
	 public String getImage(){
		 
		 String counter = null;
		 InputStream is = null; 
		 try{ 
			 int count = 0; 
			 String query = "SELECT picture FROM questions WHERE questions.id = 1"; 
			 
			 rs = st.executeQuery(query); 
			// System.out.println("Records from database");
			 while(rs.next()){ 
				 count++;
				 counter = Integer.toString(count); 
				  is=rs.getBinaryStream(1);
				  FileOutputStream fos=new FileOutputStream("d:\\"+counter+".jpg");
					 int k;
					 while((k=is.read())!=-1)
					 {
					 fos.write(k);
					 }
				 fos.close();
			 }
			
			 
		 }catch(Exception ex){ 
			 System.out.println(ex);
		 }
		return "d:\\"+counter+".jpg";
		 
		 
	 }
	 
	 
	 
	 
	 public Map<String, String> getBoth(String arg){ 
		 try{ 
			 String query = arg;
			 System.out.println("Query is " + query);
			
			 rs = st.executeQuery(query); 
			 //System.out.println("Records from database");
			 while(rs.next()){ 
				// String id = rs.getString("id");
				 String duration = rs.getString("duration");
				 String name = rs.getString("name");
				 
			//	 System.out.println("The clicker ID is: " + time);
				 temp.put(name,duration); 
			 }
			 
		 }catch(Exception ex){ 
			 System.out.println(ex);
		 }
	 
		 return temp;  
		 
	 }
	 
	 
	 
	 
	 
	    
	 
	 
	
		 
	 }
	 
	 
 
 
 
	
	
	
//}
