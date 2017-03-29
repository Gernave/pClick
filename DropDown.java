import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DropDown{
	/*JLabel lbl = new JLabel();*/
	
	JFrame f;   
	
	DropDown(){    
	    f=new JFrame("DropDown");
	    
	    final JLabel label = new JLabel("Hi there");
	    label.setHorizontalAlignment(JLabel.CENTER);  
	    label.setSize(400,100);  
	    
	    JButton b=new JButton("Show");  
	    b.setBounds(200,100,75,20);
	    
	    String choices[] = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
	    
	    JComboBox cb=new JComboBox(choices);
	    
	    cb.setBounds(50, 50,90,20);
	    
	    f.add(cb); f.add(label); f.add(b);
	    
	    f.setLayout(null);    
	    f.setSize(400,500);    
	    f.setVisible(true);    
	    
	    ActionListener a = new ActionListener() {  
    		public void actionPerformed(ActionEvent e) {       
    			String data = "Selected: " + cb.getItemAt(cb.getSelectedIndex());  
    			label.setText(data);  
    		}
    	};
	    
	    b.addActionListener(a);  
	}
	
	
	public static void main(String[] args) {    
	    new DropDown();         
	} 
}
