import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
public class GUIv5 {

	private JFrame f = new JFrame("Title");//main window

	private JButton updateB = new JButton("Update data for your classes");

	private JButton helpB = new JButton("Help");

	private JButton goB = new JButton("Go");//takes user input

	private JButton barchartB = new JButton("Show answers");

	private JButton screenshotB = new JButton("Show questions");
	ArrayList<String> questionCol; 
	ArrayList<String> durationCol;

	DBConnect connect = new DBConnect(); 

	ConnectTest connector = new ConnectTest(); 
	int randomInt = 0; 
	String classResp = ""; 
	String sessionResp = "1"; 


	GUIv5(){

		try
		{
			setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,20));
		}
		catch(Exception e){}
		questionCol = new ArrayList<String>(); 
		durationCol = new ArrayList<String>(); 
		//****GUI PARTS****//

		JPanel topButtons = top();

		JPanel dropdowns = center();

		JPanel results = new JPanel(); 
		results.setLayout(new BoxLayout(results, BoxLayout.PAGE_AXIS));




		//****CENTER PART****//

		int panelsRow = 8;	//row
		int panelsCol = 4;	//column
		JPanel[][] panelHolder = new JPanel[panelsRow][panelsCol];    
		dropdowns.setLayout(new GridLayout(panelsRow,panelsCol));

		for(int m = 0; m < panelsRow; m++) {
			for(int n = 0; n < panelsCol; n++) {
				panelHolder[m][n] = new JPanel();
				dropdowns.add(panelHolder[m][n]);
			}
		}





		//****LABELS****//

		JLabel label_1 = new JLabel("Term");
		JLabel label_2 = new JLabel("Class");
		JLabel label_3 = new JLabel("Session");
		JLabel label_4 = new JLabel("Filter");
		JLabel label_5 = new JLabel("Order by");
		JLabel label_6 = new JLabel("Ignore");

		//panelHolder[0][0].add(label_1);
		panelHolder[1][0].add(label_2);
		panelHolder[2][0].add(label_3);
		panelHolder[3][0].add(label_4);
		panelHolder[4][0].add(label_5);
		panelHolder[5][0].add(label_6);

		//****DROPDOWNS****//

		ArrayList<String> courses = new ArrayList<String>();
		ArrayList<String> sessions = new ArrayList<String>(); 
		sessions = connect.getsession(); 
		courses = connect.getcoursename(); 

		String[] classList = new String[courses.size()]; 
		classList = courses.toArray(classList); 
		String[] sessionList = new String[sessions.size()]; 
		sessionList = sessions.toArray(sessionList); 

		//	String choices[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		//	String classList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		//String sessionList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String showOptions[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		//String ignoreOptions[] = {"Ignore", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String orderOptions[] = {"By Date", "By Name"};

		//JComboBox cb = new JComboBox(choices);
		JComboBox classMenu = new JComboBox(classList);
		JComboBox sessionMenu = new JComboBox(sessionList);
		JComboBox showMenu = new JComboBox(showOptions);
		//JComboBox ignoreMenu = new JComboBox(ignoreOptions);
		JComboBox orderMenu = new JComboBox(orderOptions);
		JCheckBox checkBox_1 = new JCheckBox("Paired questions");
		JCheckBox checkBox_2 = new JCheckBox("1st half");

		//panelHolder[0][1].add(cb);
		panelHolder[1][1].add(classMenu);		
		panelHolder[2][1].add(sessionMenu);		
		panelHolder[3][1].add(showMenu);
		panelHolder[4][1].add(orderMenu);		
		panelHolder[5][1].add(checkBox_1);		
		panelHolder[6][1].add(checkBox_2);
		panelHolder[7][1].add(goB);				




		//****RIGHT COLUMN****//

		JCheckBox checkBox_3 = new JCheckBox("Unpaired suestions");
		JCheckBox checkBox_4 = new JCheckBox("2nd half");
		JRadioButton radioButton_1 = new JRadioButton("Ascending");
		JRadioButton radioButton_2 = new JRadioButton("Descending");

		JPanel radioButtons = new JPanel();
		radioButtons.add(radioButton_1);
		radioButtons.add(radioButton_2);

		panelHolder[4][2].add(radioButton_1); panelHolder[4][3].add(radioButton_2);
		panelHolder[5][2].add(checkBox_3);
		panelHolder[6][2].add(checkBox_4);

		//****RESULTS****//

		//***Table***//

		String[] columns = new String[] {
				"Question Id", "Time taken", "Percentage of correct", "Class/Session"
		};

		String[][] data2 = new String[10][4];//[row][column]
		for(int row=0; row<10; row++){
			for(int col=0; col<4; col++){
				data2[row][col]=" ";
			}

		}

		JTable table = new JTable(data2, columns);
		table.setRowHeight(30);

		results.add(new JScrollPane(table));

		//***Picture buttons***//

		JPanel pictureButtons = new JPanel();
		pictureButtons.add(screenshotB);
		pictureButtons.add(barchartB);

		TextArea text = new TextArea(10,50);

		//results.add(table);
		//results.add(text);
		results.add(pictureButtons);



		//****ADDING GUI PARTS****//

		f.getContentPane().add(topButtons, BorderLayout.PAGE_START);
		f.getContentPane().add(dropdowns, BorderLayout.CENTER);		
		f.getContentPane().add(results, BorderLayout.PAGE_END);
		f.pack();
		f.setVisible(true);




		//****ACTION LISTENERS FOR BUTTONS****//

		ActionListener go = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	

				if(radioButton_1.isSelected()){//checks whether radiobutton is selected
					System.out.println("Selected" );
				}

				checkBox_1.isSelected();//checks whether checkbox is selected

				//table.getModel().setValueAt("It works", 1, 1);//command for editing table


				Random randomGenerator = new Random();
				int randomInt; 
				ArrayList<Integer> a = new ArrayList<Integer>(); 
					


				classResp = (String)classMenu.getItemAt(classMenu.getSelectedIndex());
				sessionResp = (String)sessionMenu.getItemAt(sessionMenu.getSelectedIndex()); 

	
				System.out.println("The query is " + connector.getVals(classResp, sessionResp));

				//if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals("1")){
				
				questionCol.clear(); 
				durationCol.clear();  
				
				questionCol = connect.getQuestions(); 
				durationCol = connect.getDuration();

				for(int i = 0; i<questionCol.size(); i++){
					table.getModel().setValueAt(questionCol.get(i), i, 0);
					System.out.println(questionCol.size());
					text.append("\n");
				}

				for(int i = 0; i<durationCol.size(); i++){ 
					table.getModel().setValueAt(durationCol.get(i), i, 1);

				}

				for(int i = 0; i<9; i++){ 
					randomInt = randomGenerator.nextInt(100);
					a.add(randomInt); 
					
					String Int = Integer.toString(randomInt); 

					table.getModel().setValueAt(Int+"%", i, 2);
					table.getModel().setValueAt("1", i, 3);

				}

				if(radioButton_1.isSelected()){
										

				}
				

			}











		};

		ActionListener update = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};

		ActionListener help = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};

		ActionListener screenshot = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {

				int questionSelected = 0;

				for(int i=0;i<5;i++){
					if(table.isRowSelected(i)){ //function for checking row
						questionSelected = i+1;
					}
				}
				//Make sure to make an error message if the user does not pick any questions!!!!!!!!!!!!!!!!!!!!!
				JFrame imageWindow = new JFrame("Image");
				System.out.println("Row is " + questionSelected);
				//if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals(Integer.toString(questionSelected))){

				ImageIcon image = new ImageIcon("d:\\"+Integer.toString(questionSelected)+".jpg");//insert image address here

				JLabel imageLabel = new JLabel(image); 
				imageWindow.add(imageLabel);
				imageWindow.pack();
				imageWindow.setVisible(true);


			}
		};

		ActionListener barchart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int questionSelected = 0;

				for(int i=0;i<5;i++){
					if(table.isRowSelected(i)){ //function for checking row
						questionSelected = i+1;
					}
				}
				//Make sure to make an error message if the user does not pick any questions!!!!!!!!!!!!!!!!!!!!!
				JFrame imageWindow = new JFrame("Image");
				System.out.println("Row is " + questionSelected);
				//if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals(Integer.toString(questionSelected))){

				ImageIcon image = new ImageIcon("d:\\"+"r"+Integer.toString(questionSelected)+".jpg");//insert image address here

				JLabel imageLabel = new JLabel(image); 
				imageWindow.add(imageLabel);
				imageWindow.pack();
				imageWindow.setVisible(true);

			}
		};


		goB.addActionListener(go);  
		updateB.addActionListener(update); 
		helpB.addActionListener(help);
		screenshotB.addActionListener(screenshot);
		barchartB.addActionListener(barchart);
	}


	/*
	 * WIP
	 */
	private void showImageInGUI(String imageAddress){
		ImageIcon imageIcon = new ImageIcon(imageAddress);

		Image image = imageIcon.getImage(); // transform it

		Image newimg = image.getScaledInstance(400, 300,  java.awt.Image.SCALE_SMOOTH); 
		// scale it the smooth way 

		imageIcon = new ImageIcon(newimg);

		//imageLabel = new JLabel(imageIcon);

		//results.add(imageLabel);
	}

	private JPanel top(){
		/*
		 * Top buttons
		 */
		JPanel topButtons = new JPanel();
		topButtons.setLayout(new FlowLayout());		
		topButtons.add(updateB);
		topButtons.add(helpB);
		return topButtons;
	}

	private JPanel center(){
		/*
		 * Section of selection menus
		 */
		JPanel dropdowns = new JPanel();
		dropdowns.setLayout(new FlowLayout());
		return dropdowns;
	}


	public static void setUIFont(javax.swing.plaf.FontUIResource f)
	{   
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while(keys.hasMoreElements())
		{
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
		}
	}



}
