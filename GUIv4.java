import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.awt.Image;
public class GUIv4 {

	private JFrame f = new JFrame("Title");//main window

	private JButton updateB = new JButton("Update data for your classes");

	private JButton helpB = new JButton("Help");

	private JButton goB = new JButton("Go");//takes user input
	
	private JButton barchartB = new JButton("Show answers");
	
	private JButton screenshotB = new JButton("Show questions");
	
	DBConnect connect = new DBConnect(); 
	
	GUIv4(){
		
		//f.setLayout(new BoxLayout(f, BoxLayout.PAGE_AXIS));
		
			//****GUI PARTS****//

		JPanel topButtons = top();
		JPanel dropdowns = center();
		JPanel results = new JPanel();

			//****CENTER PART****//

		int i = 8;	//row
		int j = 4;	//column
		JPanel[][] panelHolder = new JPanel[i][j];    
		dropdowns.setLayout(new GridLayout(i,j));

		for(int m = 0; m < i; m++) {
			for(int n = 0; n < j; n++) {
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
		
		results.setLayout(new BoxLayout(results, BoxLayout.PAGE_AXIS));

		TextArea text = new TextArea(20,50);
		
		JPanel pictureButtons = new JPanel();
		pictureButtons.add(screenshotB);
		pictureButtons.add(barchartB);
		
		results.add(text);
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
				radioButton_1.isSelected();//checks whether radiobutton is selected
				
				checkBox_1.isSelected();//checks whether checkbox is selected
				
				if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals("1")){
					TreeMap<String, String> temp = new TreeMap<String, String>(); 
					temp = connect.getIDnFancs(); 
				//	text.append((Arrays.asList(temp).toString()));
					//text.append("\n");
					
					for (String name: temp.keySet()){

			            String key =name.toString();
			            String value = temp.get(name).toString();  
			           text.append(key + " = " + value);
			           
			           text.append("\n");


			} 
					
					
					
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
				JFrame imageWindow = new JFrame("Image");
				
				if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals("1")){
				ImageIcon image = new ImageIcon("C:\\Users\\Rishav Sharma\\Desktop\\Clicker Project\\pClick-master\\CS 141 FALL 2016\\Images\\L1611021411_Q1.jpg");//insert image address here
				
				JLabel imageLabel = new JLabel(image); 
				imageWindow.add(imageLabel);
				imageWindow.pack();
				imageWindow.setVisible(true);

				}
			}
		};
		
		ActionListener barchart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame imageWindow = new JFrame("Image");
				ImageIcon image = new ImageIcon("C:\\Users\\Rishav Sharma\\Desktop\\Clicker Project\\pClick-master\\CS 141 FALL 2016\\Images\\L1611021411_C1.jpg");//insert image address here
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
}