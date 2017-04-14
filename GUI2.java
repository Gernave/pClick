import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI2{

	private JFrame f = new JFrame("Title");//main window
	
	private JFrame BarChart = new JFrame("Bar Chart");//window displaying barchart
	
	private JButton updateB = new JButton("Update data for your classes");
	
	private JButton helpB = new JButton("Help");

	private JButton button = new JButton("Go");//takes user input
	
	GUI2(){
		JPanel topButtons = top();
		JPanel dropdowns = center();
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results, BoxLayout.PAGE_AXIS));
		
		//options in drop down menu
		
		JPanel labelColumn = new JPanel();
		JPanel dropdownColumn = new JPanel();
		JPanel otherColumn = new JPanel();
		
		dropdowns.add(labelColumn);
		dropdowns.add(dropdownColumn);
		dropdowns.add(otherColumn);
		
		labelColumn.setLayout(new BoxLayout(labelColumn, BoxLayout.PAGE_AXIS));
		dropdownColumn.setLayout(new BoxLayout(dropdownColumn, BoxLayout.PAGE_AXIS));
		otherColumn.setLayout(new BoxLayout(otherColumn, BoxLayout.PAGE_AXIS));

		
					//****LABELS****//
		
		
		JPanel labelPanel_1 = new JPanel();
		JPanel labelPanel_2 = new JPanel();
		JPanel labelPanel_3 = new JPanel();
		JPanel labelPanel_4 = new JPanel();
		JPanel labelPanel_5 = new JPanel();
		JPanel labelPanel_6 = new JPanel();
		
		JLabel label_1 = new JLabel("Term");
		JLabel label_2 = new JLabel("Class");
		JLabel label_3 = new JLabel("Session");
		JLabel label_4 = new JLabel("Filter");
		JLabel label_5 = new JLabel("Order by");
		JLabel label_6 = new JLabel("Ignore");
				
		labelPanel_1.add(label_1);
		labelPanel_2.add(label_2);
		labelPanel_3.add(label_3);
		labelPanel_4.add(label_4);
		labelPanel_5.add(label_5);
		labelPanel_6.add(label_6);
		
		labelColumn.add(labelPanel_1);
		labelColumn.add(labelPanel_2);
		labelColumn.add(labelPanel_3);
		labelColumn.add(labelPanel_4);
		labelColumn.add(labelPanel_5);
		labelColumn.add(labelPanel_6);
		
		labelColumn.add(Box.createVerticalStrut(55));
		
		
					//****DROPDOWNS****//
		
		
		String choices[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String classList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String sessionList[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		String showOptions[] = {"CHOICE 1","CHOICE 2", "CHOICE 3"};
		//String ignoreOptions[] = {"Ignore", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String orderOptions[] = {"Chronological", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		
		JComboBox cb = new JComboBox(choices);
		JComboBox classMenu = new JComboBox(classList);
		JComboBox sessionMenu = new JComboBox(sessionList);
		JComboBox showMenu = new JComboBox(showOptions);
		//JComboBox ignoreMenu = new JComboBox(ignoreOptions);
		JComboBox orderMenu = new JComboBox(orderOptions);
		
		JCheckBox checkBox_1 = new JCheckBox("Paired questions");
		JCheckBox checkBox_2 = new JCheckBox("1st half of paired questions");
		/*
		JPanel ddPanel_1 = new JPanel();
		JPanel ddPanel_2 = new JPanel();
		JPanel ddPanel_3 = new JPanel();
		JPanel ddPanel_4 = new JPanel();
		JPanel ddPanel_5 = new JPanel();
		JPanel ddPanel_6 = new JPanel();
		
		ddPanel_1.add(cb);
		ddPanel_2.add(classMenu);		
		ddPanel_3.add(sessionMenu);		
		ddPanel_4.add(showMenu);		
		ddPanel_5.add(ignoreMenu);
		ddPanel_6.add(orderMenu);
		
		dropdownColumn.add(ddPanel_1);
		dropdownColumn.add(ddPanel_2);		
		dropdownColumn.add(ddPanel_3);		
		dropdownColumn.add(ddPanel_4);		
		dropdownColumn.add(ddPanel_5);
		dropdownColumn.add(ddPanel_6);
		*/

		dropdownColumn.add(cb);
		dropdownColumn.add(classMenu);		
		dropdownColumn.add(sessionMenu);		
		dropdownColumn.add(showMenu);
		dropdownColumn.add(orderMenu);		
		dropdownColumn.add(checkBox_1);		
		dropdownColumn.add(checkBox_2);
		dropdownColumn.add(button);				

		
		//****RIGHT COLUMN****//


		JCheckBox checkBox_3 = new JCheckBox("Unpaired suestions");
		JCheckBox checkBox_4 = new JCheckBox("2nd half of paired questions");
		JRadioButton radioButton_1 = new JRadioButton("Ascending");
		JRadioButton radioButton_2 = new JRadioButton("Descending");
		
		JPanel radioButtons = new JPanel();
		
		radioButtons.add(radioButton_1);
		radioButtons.add(radioButton_2);

		otherColumn.add(Box.createRigidArea(new Dimension(0,65)));
		otherColumn.add(radioButtons);
		otherColumn.add(checkBox_3);
		otherColumn.add(checkBox_4);
		
		radioButtons.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		//****RESULTS****//
		
		
		TextArea text = new TextArea(3,50);//prints lists of classes, answers etc.
		TextArea text2 = new TextArea(5,50);//prints lists of classes, answers etc.
		TextArea text3 = new TextArea(5,50);//prints lists of classes, answers etc.
		results.add(text);
		results.add(text2);
		results.add(text3);
		
		
		
		f.getContentPane().add(topButtons, BorderLayout.PAGE_START);
		f.getContentPane().add(dropdowns, BorderLayout.CENTER);		
		f.getContentPane().add(results, BorderLayout.PAGE_END);
		f.pack();
		f.setVisible(true);
		

		/*
		 * Does things upon pressing buttons
		 */
		ActionListener a = new ActionListener() {  //Go button
			public void actionPerformed(ActionEvent e) {
				if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 1")){
					text.append("Button Clicked");
					text.append("\n");
				}else if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 2")){
					text.append("b");
					text.append("\n");
				}else if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 3")){
					text.append("c");
					text.append("\n");
				}else{
					text.setText("make choice");
				}
			}
		};

		ActionListener b = new ActionListener() {  //Shows pic
			public void actionPerformed(ActionEvent e) {
				BarChart.setVisible(true);
			}
		};

		ActionListener c = new ActionListener() {  //help button
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		
		button.addActionListener(a);  
		updateB.addActionListener(b); 
		helpB.addActionListener(c); 
	}
	
	private void showImage(String imageAddress){
		ImageIcon image = new ImageIcon(imageAddress);
		JLabel imageLabel = new JLabel(image); 
        BarChart.add(imageLabel);
		BarChart.pack();
		BarChart.setVisible(false);
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
		//dropdowns.setLayout(new BoxLayout(dropdowns, BoxLayout.PAGE_AXIS));
		dropdowns.setLayout(new FlowLayout());
		return dropdowns;
	}
}
