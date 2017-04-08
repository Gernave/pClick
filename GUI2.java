import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI2{

	private JFrame f = new JFrame("Clicker");//main window
	
	private JFrame BarChart = new JFrame("Bar Chart");//window displaying barchart
	
	private JButton updateB = new JButton("Show picture");
	
	private JButton helpB = new JButton("Help");

	private JButton button = new JButton("Search");//takes user input
	
	GUI2(){
		JPanel topButtons = top();
		JPanel dropdowns = center();
		
		//options in drop down menu
		String choices[] = {"Term", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String classList[] = {"Class", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String sessionList[] = {"Session", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String showOptions[] = {"Show", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String ignoreOptions[] = {"Ignore", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		String orderOptions[] = {"Order by", "CHOICE 1","CHOICE 2", "CHOICE 3"};
		
		JComboBox cb = makeDropDown(choices);
		JComboBox classMenu = makeDropDown(classList);
		JComboBox sessionMenu = makeDropDown(sessionList);
		JComboBox showMenu = makeDropDown(showOptions);
		JComboBox ignoreMenu = makeDropDown(ignoreOptions);
		JComboBox orderMenu = makeDropDown(orderOptions);
				
		dropdowns.add(cb);		
		dropdowns.add(classMenu);		
		dropdowns.add(sessionMenu);		
		dropdowns.add(showMenu);		
		dropdowns.add(ignoreMenu);
		dropdowns.add(orderMenu);
		
		//showImage(/*insert image address here to display it in new window*/);
		
		
		
		/*
		 * Section of results
		 */
		JPanel results = new JPanel();
		results.setLayout(new BoxLayout(results, BoxLayout.PAGE_AXIS));
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
		dropdowns.setLayout(new BoxLayout(dropdowns, BoxLayout.PAGE_AXIS));
		dropdowns.add(button);
		return dropdowns;
	}
	
	private JComboBox makeDropDown(String choices[]){
		JComboBox cb = new JComboBox(choices);//drop-down menu
		return cb;
	}
}
