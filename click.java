import java.util.Scanner;

public class click {

	public static void main(String[] main){
		 
		
		DropDown d = new DropDown(); 
		DBConnect connect = new DBConnect();
		boolean go = false; 
		
		
		
		
		

		while(!go){
			
				
			Scanner input = new Scanner(System.in);  //to read from standard input
			System.out.println("What do you want to get?");
			System.out.println("1) Course name");
			System.out.println("2) Get Session ");
			System.out.println("3) Questions");
			System.out.println("4) Returner");
			System.out.println("0) Exit");
			int response = input.nextInt(); 

			

			if(response == 1){ 
				connect.getcoursename();
			}else if(response == 2){ 
				connect.getsession();
			}else if(response == 3){ 
				connect.getQuestions();
			}	else if(response == 0){ 
				System.out.println("Goodbye!");
				go = true; 
				break; 
			}else{ 
				throw new IllegalArgumentException(); 
			}
		}


	}

}
