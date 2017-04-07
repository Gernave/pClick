import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DropDown{

	JFrame f;//main window
	JFrame BarChart;//window displaying barchart

	DropDown(){    
		f = new JFrame("Clicker");
		
		/*
		 * Top buttons
		 */
		JPanel topButtons = new JPanel();
		topButtons.setLayout(new FlowLayout());
		//panel.add(topButtons, BorderLayout.PAGE_START);
		
		JButton updateB = new JButton("Update Database");
		JButton helpB = new JButton("Help");
		
		topButtons.add(updateB);
		topButtons.add(helpB);
		
		
		/*
		 * Labels for selection menus
		 */
		JPanel labels = new JPanel();
		labels.setLayout(new BoxLayout(labels, BoxLayout.PAGE_AXIS));
		
		JLabel Term = new JLabel("Term");
		JLabel Class = new JLabel("Class");
		labels.add(Term);
		labels.add(Class);
		
		/*
		 * Section of selection menus
		 */
		JPanel dropdowns = new JPanel();
		dropdowns.setLayout(new BoxLayout(dropdowns, BoxLayout.PAGE_AXIS));

		JButton button = new JButton("Go");//takes user input
		
		String choices[] = {"Term", "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
		String choices2[] = {"Class", "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
		JComboBox cb = new JComboBox(choices);//drop-down menu
		JComboBox cb2 = new JComboBox(choices2);
		
		dropdowns.add(new JLabel("Search"));
		dropdowns.add(cb);
		dropdowns.add(cb2);
		dropdowns.add(button);
		
		/*
		 * Section of results
		 */
		TextArea text = new TextArea(20,50);//prints lists of classes, answers etc.
		f.getContentPane().add(topButtons, BorderLayout.PAGE_START);
		//f.getContentPane().add(labels, BorderLayout.LINE_START);
		f.getContentPane().add(dropdowns, BorderLayout.CENTER);
		f.getContentPane().add(new JLabel("Results"),BorderLayout.PAGE_END);
		f.getContentPane().add(text, BorderLayout.PAGE_END);
		
		f.pack();
		
		f.setVisible(true);
		
		/*
		 * Window which opens to display bar-chart 
		 */
		BarChart = new JFrame("Bar Chart");
		
		ImageIcon image = new ImageIcon("C:\\Users\\Gernave\\Pictures\\Screenshots\\Screenshot (5).png");
        JLabel imageLabel = new JLabel(image); 
        BarChart.add(imageLabel);
	
		BarChart.pack();
		BarChart.setVisible(false);

		/*
		 * Does things depending on choice of drop-down menu's option
		 */
		ActionListener a = new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 1")){
					text.append("Button Clicked times Button Clicked times Button Clicked times");
					text.append("\n");
				}else if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 2")){
					text.append("b");
					text.append("\n");
				}else if(cb.getItemAt(cb.getSelectedIndex()).equals("CHOICE 3")){
					text.append("c");
					text.append("\n");
				}else{
					BarChart.setVisible(true);
					text.setText("make choice");
				}
			}
		};

		button.addActionListener(a);  
	}


	public static void main(String[] args) {    
		new DropDown(); 
		//new ThreeCascadeJComboBox();
		//new GUI2();
	} 
}
