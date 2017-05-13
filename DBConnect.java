import java.io.*;
import java.sql.*;
import java.util.*;
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
		
		InputStream is = null;
		
		Image image = null;
		
		try{ 
			String query = "SELECT picture FROM questions WHERE session_id = " + session 
					+ " AND name = " + question;
			//System.out.println(query);

			rs = st.executeQuery(query);
			
			while(rs.next()){ 
				is=rs.getBinaryStream(1);				
				image = ImageIO.read(is);
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return image;
	}
	
	public Image getResponse2(String session, String question){

		question = "\"Question "+ question+"\"";
		
		InputStream is = null; 
		
		Image image = null;
		
		try{ 
			String query = "SELECT response FROM questions WHERE session_id = " + session 
					+ " AND name = " + question;
			
			//System.out.println(query);

			rs = st.executeQuery(query);
			
			while(rs.next()){ 
				is=rs.getBinaryStream(1);				
				image = ImageIO.read(is);
			}
		}
		
		catch(Exception ex){ 
			System.out.println(ex);
		}
		
		return image;
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