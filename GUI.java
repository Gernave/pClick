import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI {

	private JFrame f = new JFrame("Title");//main window

	private JButton updateB = new JButton("Update data for your classes");

	private JButton helpB = new JButton("Help");

	private JButton goB = new JButton("Go");//takes user input

	private JButton barchartB = new JButton("Show answers");

	private JButton screenshotB = new JButton("Show questions");

	ArrayList<String> questionCol; 

	ArrayList<String> durationCol;

	Map<String, String> nameCol; 

	DBConnect connect = new DBConnect(); 

	QueryBuilderMini qbm = new QueryBuilderMini(); 

	boolean doer = false; 

	String classResp = ""; 
	String sessionResp = "1"; 

	GUI(){

		/*try
		{
			setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,10));
		}
		catch(Exception e){}
		 */

		questionCol = new ArrayList<String>(); 
		durationCol = new ArrayList<String>();
		nameCol = new LinkedHashMap<String, String>(); 
		
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

		JLabel label_2 = new JLabel("Class");
		JLabel label_3 = new JLabel("Session");
		JLabel label_4 = new JLabel("Filter");
		JLabel label_5 = new JLabel("Order by");
		JLabel label_6 = new JLabel("Ignore");
		JLabel label_7 = new JLabel("Question");
		JLabel label_8 = new JLabel("Answer");


		panelHolder[0][0].add(label_2);
		panelHolder[1][0].add(label_3);
		panelHolder[2][0].add(label_4);
		panelHolder[3][0].add(label_5);
		panelHolder[4][0].add(label_6);
		
		panelHolder[7][1].add(label_7);
		panelHolder[7][2].add(label_8);


		//****DROPDOWNS****//

		ArrayList<String> courses = new ArrayList<String>();
		ArrayList<String> sessions = new ArrayList<String>(); 
		sessions = connect.getsession(); 
		courses = connect.getcoursename(); 

		String[] classList = new String[courses.size()]; 
		String[] sessionList = new String[sessions.size()];
		
		classList = courses.toArray(classList);  
		sessionList = sessions.toArray(sessionList); 

		String filterOptions[] = {"Above","Below", "Exactly"};
		String orderOptions[] = {"By Name", "By Time"};

		String questionList[] = {"1", "2", "3", "4", "5"}; 
		String answerList[] = {"A", "B", "C", "D", "E"}; 

		
		
		JComboBox classMenu = new JComboBox(classList);
		JComboBox sessionMenu = new JComboBox(sessionList);
		JComboBox filterMenu = new JComboBox(filterOptions);
		JComboBox orderMenu = new JComboBox(orderOptions);
		JComboBox questionMenu = new JComboBox(questionList); 
		JComboBox answerMenu = new JComboBox(answerList); 
		JCheckBox checkBox_1 = new JCheckBox("Paired questions");
		JCheckBox checkBox_2 = new JCheckBox("1st half");


		panelHolder[0][1].add(classMenu);		
		panelHolder[1][1].add(sessionMenu);		
		panelHolder[2][1].add(filterMenu);
		panelHolder[3][1].add(orderMenu);		
		panelHolder[4][1].add(checkBox_1);		
		panelHolder[5][1].add(checkBox_2);
		panelHolder[6][1].add(goB);
		panelHolder[7][1].add(questionMenu);



		//****RIGHT COLUMN****//

		JTextField textField = new JTextField("", 10);
		textField.setSize(50, 10);

		JCheckBox checkBox_3 = new JCheckBox("Unpaired suestions");
		JCheckBox checkBox_4 = new JCheckBox("2nd half");
		JRadioButton radioButton_1 = new JRadioButton("Ascending");
		JRadioButton radioButton_2 = new JRadioButton("Descending");

		JPanel radioButtons = new JPanel();
		radioButtons.add(radioButton_1);
		radioButtons.add(radioButton_2);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton_1);
		group.add(radioButton_2);
		radioButton_1.setSelected(true); 


		JButton updateAnswerB = new JButton("Update Answer"); 
		
		panelHolder[2][2].add(textField);
		panelHolder[3][2].add(radioButton_1); 	panelHolder[3][3].add(radioButton_2);
		panelHolder[4][2].add(checkBox_3);
		panelHolder[5][2].add(checkBox_4);

		panelHolder[7][2].add(answerMenu);		panelHolder[7][3].add(updateAnswerB); 

		//****RESULTS****//

		//***Table***//

		String[] columns = new String[] {
				"Question Id", "Time taken", "1st try", "2nd try", "Session"
		};

		String[][] data2 = new String[10][5];//[row][column]
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

		results.add(pictureButtons);

		//TextArea text = new TextArea(10,50);

		//****ADDING GUI PARTS****//

		f.getContentPane().add(topButtons, BorderLayout.PAGE_START);
		f.getContentPane().add(dropdowns, BorderLayout.CENTER);		
		f.getContentPane().add(results, BorderLayout.PAGE_END);
		f.pack();
		f.setVisible(true);






		//****ACTION LISTENERS FOR BUTTONS****//

		ActionListener go = new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				System.out.println("Selected session: "+
						sessionMenu.getItemAt(sessionMenu.getSelectedIndex()));
				
				//Clears table.
				for(int row=0; row<10; row++){
					for(int col=0; col<4; col++){
						table.getModel().setValueAt(" ", row, col);
					}

				}
				
				doer = true; 
				String order = ""; 
				String orderCol = ""; 


				if(radioButton_1.isSelected()){
					order = "ASC"; 
				}else if(radioButton_2.isSelected()){ 
					order = "DESC"; 
				}

				if(orderMenu.getItemAt(orderMenu.getSelectedIndex()).equals("By Time")){
					orderCol = "duration";
				}else{ 
					orderCol = "name"; 
				}

				classResp = (String)classMenu.getItemAt(classMenu.getSelectedIndex());
				sessionResp = (String)sessionMenu.getItemAt(sessionMenu.getSelectedIndex()); 

				String argum2 = qbm.fquery(sessionResp, order, orderCol);
				nameCol.clear(); 
				
				nameCol = connect.getBoth(argum2); 

				int count = 0; 
				for (String name: nameCol.keySet()){

					String key =name.toString();
					String value = nameCol.get(name).toString(); 
					table.getModel().setValueAt(key, count, 0);
					table.getModel().setValueAt(value, count, 1);

					count++; 
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
		
		//if(sessionMenu.getItemAt(sessionMenu.getSelectedIndex()).equals(Integer.toString(questionSelected)))
		
		ActionListener screenshot = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String sessionSelected = (String)sessionMenu.getItemAt(sessionMenu.getSelectedIndex());
				
				int questionSelected = 1;

				for(int i=0;i<nameCol.size();i++){
					if(table.isRowSelected(i)){ 
						questionSelected = i+1;
					}
				}
				
				Image image = connect.getImage2(sessionSelected,Integer.toString(questionSelected));
				
				image = image.getScaledInstance(1024, 768,  java.awt.Image.SCALE_SMOOTH); 
				ImageIcon icon = new ImageIcon(image);
				JLabel imageLabel = new JLabel(icon); 
				
				JFrame imageWindow = new JFrame("Image");
				imageWindow.add(imageLabel);
				imageWindow.pack();
				imageWindow.setVisible(true);
			}
		};

		ActionListener barchart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sessionSelected = (String)sessionMenu.getItemAt(sessionMenu.getSelectedIndex());
				
				int questionSelected = 0;
				
				for(int i=0;i<nameCol.size();i++){
					if(table.isRowSelected(i)){
						questionSelected = i+1;
					}
				}

				Image image = connect.getResponse2(sessionSelected,Integer.toString(questionSelected));
				
				ImageIcon icon = new ImageIcon(image);
				JLabel imageLabel = new JLabel(icon); 
				

				JFrame imageWindow = new JFrame("Image");
				imageWindow.add(imageLabel);
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
