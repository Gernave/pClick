import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DropDown{

	JFrame f;
	JFrame BarChart;

	DropDown(){    
		f = new JFrame("Clicker");

		JPanel panel = new JPanel();//uses BorderLayout by default
		f.add(panel);

		TextArea text = new TextArea(20,50);

		JButton button=new JButton("Show");

		String choices[] = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
		JComboBox cb = new JComboBox(choices);

		panel.add(cb, BorderLayout.PAGE_START);
		panel.add(text, BorderLayout.CENTER);
		panel.add(button, BorderLayout.PAGE_END); 

		f.setSize(400,500);    
		f.setVisible(true);
		
		
		BarChart = new JFrame("Bar Chart");
		
		ImageIcon image = new ImageIcon("C:\\Users\\Gernave\\Pictures\\Screenshots\\Screenshot (5).png");
        JLabel imageLabel = new JLabel(image); 
        BarChart.add(imageLabel);
		
		BarChart.setSize(400,500);    
		BarChart.setVisible(false);

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
	} 
}
