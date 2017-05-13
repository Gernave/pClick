import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;


public class DBConnect {
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



	public DBConnect(){
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clicker", "root", "");
			st = con.createStatement();

		}
		
		catch(Exception ex){
			System.out.println("Error: " + ex); 
		}
	} 


	public ArrayList<String> getcoursename(){ 
		
		try{ 
			String query = "SELECT course_name FROM courses"; 

			rs = st.executeQuery(query);
			while(rs.next()){ 
				String coursename = rs.getString("course_name"); 
				File file = new File("d:\\" + coursename);
				if (!file.exists()) {
					file.mkdir(); 
				}
				System.out.println("The courses are: " + coursename);
				cour.add(coursename);

			}


		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return cour; 
	}



	public ArrayList<String> getsession(){ 
		
		try{ 
			
			String query = "SELECT id FROM sessions WHERE course_id = 1"; 
			rs = st.executeQuery(query);
			
			while(rs.next()){ 
				String id = rs.getString("id");
				File file = new File("d:\\CS 141 FALL 2016\\" + id);
				if (!file.exists()) {
					file.mkdir(); 
				}
				ans.add(id);
			}

		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return ans; 
	}





	public Image getImage2(String session, String question){

		question = "\"Question "+ question+"\"";
		String counter = null;
		InputStream is = null; 
		Image bImageFromConvert = null;
		
		try{ 
			int count = 0; 
			String query = "SELECT picture FROM questions WHERE session_id = " + session 
					+ " AND name = " + question;
			System.out.println(query);

			rs = st.executeQuery(query);
			while(rs.next()){ 
				count++;
				counter = Integer.toString(count); 
				is=rs.getBinaryStream(1);
				
				bImageFromConvert = ImageIO.read(is);
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return bImageFromConvert;
	}
	
	public Image getResponse2(String session, String question){

		question = "\"Question "+ question+"\"";
		String counter = null;
		InputStream is = null; 
		Image bImageFromConvert = null;
		
		try{ 
			int count = 0; 
			String query = "SELECT response FROM questions WHERE session_id = " + session 
					+ " AND name = " + question;
			System.out.println(query);

			rs = st.executeQuery(query);
			while(rs.next()){ 
				count++;
				counter = Integer.toString(count); 
				is=rs.getBinaryStream(1);
				
				bImageFromConvert = ImageIO.read(is);
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return bImageFromConvert;
	}

	public String getImage(String session){

		String counter = null;
		InputStream is = null; 
		
		try{ 
			int count = 0; 
			String query = "SELECT picture FROM questions WHERE session_id = " + session;

			rs = st.executeQuery(query);
			while(rs.next()){ 
				count++;
				counter = Integer.toString(count); 
				is=rs.getBinaryStream(1);
				
				BufferedImage bImageFromConvert = ImageIO.read(is);
				/*
				FileOutputStream fos=new FileOutputStream("d:\\CS 141 FALL 2016\\"+session+"\\"+counter+".jpg");
				
				int k;
				while((k=is.read())!=-1){
					fos.write(k);
				}
				
				fos.close();
				 */
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return "d:\\"+counter+".jpg";
	}


	public String getResponse(String session){

		String counter = null;
		InputStream is = null; 
		try{ 
			int count = 0; 
			String query = "SELECT response FROM questions WHERE session_id = " + session;

			rs = st.executeQuery(query);
			
			while(rs.next()){ 
				count++;
				counter = Integer.toString(count); 
				is=rs.getBinaryStream(1);
				/*
				FileOutputStream fos=new FileOutputStream("d:\\CS 141 FALL 2016\\"+session+"\\"+"r"+counter+".jpg");
				
				int k;
				while((k=is.read())!=-1){
					fos.write(k);
				}
				fos.close();
				*/
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return "d:\\"+"r"+counter+".jpg";
	}




	public Map<String, String> getBoth(String arg){ 
		try{ 
			String query = arg;

			rs = st.executeQuery(query); 
			while(rs.next()){ 
				String duration = rs.getString("duration");
				String name = rs.getString("name");


				temp.put(name,duration); 
			}

		}catch(Exception ex){ 
			System.out.println(ex);
		}

		return temp;  
	}
}
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class DBConnect {
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
 
 

 public DBConnect(){
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
			 File file = new File("d:\\" + coursename);
			  if (!file.exists()) {
				  file.mkdir(); 
			  }
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
			 File file = new File("d:\\CS 141 FALL 2016\\" + id);
			 if (!file.exists()) {
				  file.mkdir(); 
			  }
		//	 System.out.println("The answer is: " + id);
			 ans.add(id);
			 
			 
		 }
		 
	 }catch(Exception ex){ 
		 System.out.println(ex);
	 }
	 return ans; 
 }
	
	
	 
	
	 
	 
	 
	 public String getImage(String session){
		 
		 String counter = null;
		 InputStream is = null; 
		 try{ 
			 int count = 0; 
			 String query = "SELECT picture FROM questions WHERE session_id = " + session;
			 
			
			 
			 rs = st.executeQuery(query); 
			// System.out.println("Records from database");
			 while(rs.next()){ 
				 count++;
				 counter = Integer.toString(count); 
				  is=rs.getBinaryStream(1);
				  FileOutputStream fos=new FileOutputStream("d:\\CS 141 FALL 2016\\"+session+"\\"+counter+".jpg");
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
	 
	 
 public String getResponse(String session){
		 
		 String counter = null;
		 InputStream is = null; 
		 try{ 
			 int count = 0; 
			 String query = "SELECT response FROM questions WHERE session_id = " + session;
			 
			 
			 
			 rs = st.executeQuery(query); 
			// System.out.println("Records from database");
			 while(rs.next()){ 
				 count++;
				 counter = Integer.toString(count); 
				  is=rs.getBinaryStream(1);
				  FileOutputStream fos=new FileOutputStream("d:\\CS 141 FALL 2016\\"+session+"\\"+"r"+counter+".jpg");
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
		return "d:\\"+"r"+counter+".jpg";
		 
		 
	 }
	 
	 
	 
	 
	 public Map<String, String> getBoth(String arg){ 
		 try{ 
			 String query = arg;
			// System.out.println("Query is " + query);
			
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
