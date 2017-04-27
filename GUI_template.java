import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
public class GUIv4 {

	private JFrame f = new JFrame("Title");//main window

	private JButton updateB = new JButton("Update data for your classes");

	private JButton helpB = new JButton("Help");

	private JButton goB = new JButton("Go");//takes user input
	
	private JButton barchartB = new JButton("Show answers");
	
	private JButton screenshotB = new JButton("Show qustions");
	
	GUIv4(){

		try
		{
		    setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,20));
		}
		catch(Exception e){}
		//f.setLayout(new BoxLayout(f, BoxLayout.PAGE_AXIS));
		
			//****GUI PARTS****//

		JPanel topButtons = top();
		
		JPanel dropdowns = center();
		
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results, BoxLayout.PAGE_AXIS));

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

		panelHolder[0][0].add(label_1);
		panelHolder[1][0].add(label_2);
		panelHolder[2][0].add(label_3);
		panelHolder[3][0].add(label_4);
		panelHolder[4][0].add(label_5);
		panelHolder[5][0].add(label_6);

			//****DROPDOWNS****//

		String choices[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String classList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String sessionList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String showOptions[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String orderOptions[] = {"Chronological", "CHOICE 1","CHOICE 2", "CHOICE 3"};

		JComboBox cb = new JComboBox(choices);
		JComboBox classMenu = new JComboBox(classList);
		JComboBox sessionMenu = new JComboBox(sessionList);
		JComboBox showMenu = new JComboBox(showOptions);
		JComboBox orderMenu = new JComboBox(orderOptions);

		JCheckBox checkBox_1 = new JCheckBox("Paired questions");
		JCheckBox checkBox_2 = new JCheckBox("1st half");

		panelHolder[0][1].add(cb);
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
		
		

		String[] columns = new String[] {
				"Id", "Name", "Hourly Rate", "Part Time"
		};

		//actual data for the table in a 2d array
		Object[][] data = new Object[][] {
				{"Id", "Name", "Hourly Rate", "Part Time"},
				{1, "John", 40.0, false },
				{2, "Rambo", 70.0, false },
				{3, "Zorro", 60.0, true },
		};
		//create table with data
		JTable table = new JTable(data, columns);
		
		
		TextArea text = new TextArea(30,50);
		
		JPanel pictureButtons = new JPanel();
		pictureButtons.add(screenshotB);
		pictureButtons.add(barchartB);
		
		results.add(table);
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
				radioButton_1.isSelected();
				
				checkBox_1.isSelected();
				
				cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 1");
				
				text.setText("make choice");
				
				table.getModel().setValueAt("It works", 1, 1);
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
				ImageIcon image = new ImageIcon("C:\\Users\\Gernave\\Pictures\\Screenshots\\Screenshot (1).png");
				JLabel imageLabel = new JLabel(image); 
				imageWindow.add(imageLabel);
				imageWindow.pack();
				imageWindow.setVisible(true);
			}
		};
		
		ActionListener barchart = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame imageWindow = new JFrame("Image");
				ImageIcon image = new ImageIcon("C:\\Users\\Gernave\\Pictures\\Screenshots\\Screenshot (5).png");
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
