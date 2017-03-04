import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClickerController {
	private Clicker model;
	private ViewClass view;
	//public JButton button = new JButton();

	public ClickerController(Clicker model, ViewClass view){
		this.model = model;
		this.view = view;
		JButton homeButton = new JButton("Home");
		JButton deleteButton = new JButton("Delete");
		JButton selectButton = new JButton("Select");
	}
	
	/* Once user ends the question session the program will call this method
	 * to upload question and all its related data to Model(Database)
	 */
	public void addData(){
		
	}
	
	/* There will be button which upon clicking allows user to select 
	 * the row of table to be deleted and calls this method.
	 */
	public void deleteData(){

	}
	
	/*
	 * Called by a “home” button. Updates the View to the list/menu of classes, 
	 * from which user can choose from to view its questions.
	 */
	public void listClasses(){
		//view.drawclasstable(class id)
	}
	
	/*
	 * Called by clicking on class entry from list/menu of classes. Updates the View 
	 * to show the respective class’ table of questions
	 */
	public void goToClass(int classID, int classSession, int questionNumber){
		//view.drawsessiontable(class id, class session, question number);
	}

	/*
	 * updates the View to show the screenshot of the question
	 */
	public void getScreenshot(){
		//print model.Question();
	}
	
	/*
	 * updates the View to show bar-chart of students’ answers
	 */
	public void getBarChart(){
		//model.getAnswer();
	}
	
	/*
	 * prints updated view
	 */
	public void updateView(){

	}
	
	/*
	 * resets the View to default state (not showing screenshot, bar-chart, or report; just table)
	 */
	public void reset(){

	}

	//getReport();
}
