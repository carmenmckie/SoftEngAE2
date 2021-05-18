import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class View implements ActionListener {

	private JFrame frame;
	private JPanel panelOne;
	private JPanel panelTwo;
	private JPanel panelThree;
	private JPanel panelFour; 
	private JPanel panelFive; 
	private JPanel panelSeven; 
	private JPanel panelEight; 
	private JPanel panelUserEnters;
	private JTextArea textArea1;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JLabel JLabel1; 
	private JLabel csvLabel;
	private JLabel updatedDataLabel;
	private JTextArea textArea2;
	private JTextField teachersWithoutTheseSkillsResult;
	private JButton button2;
	private JLabel userEntersLabel;
	private JTextField teachersWithTheseSkillsResult;
	public static final int FRAME_HEIGHT = 900; 
	public static final int FRAME_WIDTH = 1800; 
	public static final int TEXTAREA_HEIGHT = 45; 
	public static final int TEXTAREA_WIDTH = 20; 
	private JButton buttonOne;
	private CardLayout cardLayout;
	private SearchEngine searchEngine;
	private Lab lab1;
	private ArrayList<String> courseInfo;
	
	
	public void setSearchEngine(SearchEngine searchEngine) {
		this.searchEngine = searchEngine; 
	}
	
	// Called when GUI is made: 
	public View(Lab lab1) {
		makeComponents();
		makeLayout();
		this.lab1 = lab1; 
	}
	
	// Implementing Card Layout
	private void makeLayout() {
		frame.setLayout(cardLayout);
		frame.add(panelOne,"one");
		frame.add(panelTwo,"two");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1800,900);
		frame.setVisible(true);
		
	}
	

	private void makeComponents() {
		frame = new JFrame("AgileFun AE2 Demo");
		cardLayout = new CardLayout();
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		
		/////////////////////////////
		// Page One: (Class Director) 
		///////////////////////////// 
		panelOne = new JPanel();
		JLabel1 = new JLabel("Hello Class Director, please choose a file:");
		buttonOne = new JButton("Choose a File >>");
		buttonOne.addActionListener(new button1Listener());
		panelOne.add(JLabel1);
		panelOne.add(buttonOne);
		

		
		////////////////////////////
		// Page Two: Administrator 
		////////////////////////////
		panelTwo = new JPanel();
		panelTwo.setLayout(new BorderLayout());	
		
		
		///////////////////////////////////
		// WEST 
		///////////////////////////////////
		// panelThree - To Display Data from CSV File 
		panelThree = new JPanel(); 
		textArea1 = new JTextArea(TEXTAREA_HEIGHT, TEXTAREA_WIDTH);
		textArea1.setText("Data from CSV file to go here");
		// Original CSV data not to be edited: 
		textArea1.setEditable(false); 
		scrollPane1 = new JScrollPane(textArea1);
		panelThree.add(scrollPane1);
		panelTwo.add(panelThree, BorderLayout.WEST);
		
		
		///////////////////////////////////
		// NORTH
		///////////////////////////////////
		// Panel Four - Menu 
		panelFour = new JPanel(); 
		panelFour.setLayout(new BorderLayout());
		csvLabel = new JLabel("Data from CSV File:");
		updatedDataLabel = new JLabel("Updated Data:");
		panelFour.add(csvLabel, BorderLayout.WEST);
		panelFour.add(updatedDataLabel, BorderLayout.EAST);
		panelTwo.add(panelFour, BorderLayout.NORTH);

		
		
		
		
		
		
		///////////////////////////////////
		// EAST 
		///////////////////////////////////
		// Panel Five - Updated Data 
		panelFive = new JPanel(); 
		textArea2 = new JTextArea(TEXTAREA_HEIGHT,TEXTAREA_WIDTH); 
		textArea2.setText("(textArea2) updated data could go here");
		scrollPane2 = new JScrollPane(textArea2); 
		panelFive.add(scrollPane2); 
		panelTwo.add(panelFive, BorderLayout.EAST);
		
		
		
		
		
		
		
		///////////////////////////////////
		// SOUTH 
		///////////////////////////////////
		panelSeven = new JPanel(); 
		panelSeven.setLayout(new BorderLayout());
		panelTwo.add(panelSeven, BorderLayout.SOUTH); 
		// Save Button 
		button2 = new JButton("(button2) L: Save to File and Close");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// *******************************
				// *******************************
				// *******************************

				
				// Needs to save
				// searchEngine's courseList and teacherList (updated throughout the program)
				// Write them to a file on the user's laptop
				// Close the program 
				
				
				// ********************************
				// *******************************
				// *******************************

				
				
				
			}
		});
		panelSeven.add(button2, BorderLayout.EAST);

		
		
		
		
		
		///////////////////////////////////
		// CENTER
		///////////////////////////////////
		panelEight = new JPanel(); 
		panelEight.setLayout(new GridLayout(0, 3));
		panelTwo.add(panelEight, BorderLayout.CENTER);

		
		
		
		
		
		
		///////////////////////////////////
		// TOP ROW
		///////////////////////////////////
		// Enter Teacher - .userEnters()
		panelUserEnters = new JPanel(); 
		panelUserEnters.setLayout(new GridLayout(0, 1));
		userEntersLabel = new JLabel("<html>Please enter the <b>skill</b><br> you are searching for,<br> followed by enter:</html>");
		JTextField userEntersTraining = new JTextField();
		userEntersTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// User enters a skill, and this then sets the output of the other two boxes so the user can 
				// see the search results 
				String data = userEntersTraining.getText();
				ArrayList<Teacher> teachersWithSkill = searchEngine.findTeacher(data); 
				int counter1 = teachersWithSkill.size(); 
			      StringBuffer sb = new StringBuffer();
			      for (Teacher s : teachersWithSkill) {
			         sb.append(s);
			         sb.append(" ");
			      }
			      String str = sb.toString();
			      // Teachers WITH this skill displayed in the output: 
				teachersWithTheseSkillsResult.setText("There are " + counter1 + " teachers with this skill: " + str);
				// Clear the search box so another search can occur: 
				userEntersTraining.setText("");
				// Teachers without this skill: 
				ArrayList<Teacher> teachersWithoutSkill = searchEngine.findTeachersToTrain(data);
				int counter2 = teachersWithoutSkill.size();
				StringBuffer sb2 = new StringBuffer(); 
				for (Teacher s2 : teachersWithoutSkill) {
					sb2.append(s2);
					sb2.append(" " );
					String str2 = sb2.toString(); 
					// Teachers WITHOUT this skill displayed in the output: 
					teachersWithoutTheseSkillsResult.setText("There are " + counter2 + " teachers without this skill: " + str2);
				}
			}
		});
		// Add event handling to clear the text when clicked
		panelUserEnters.add(userEntersLabel);
		panelUserEnters.add(userEntersTraining);
		panelEight.add(panelUserEnters);

		
		
		
		
		
		// Result1: teachers with these skills 
		JPanel panelTeachersWithTheseSkills = new JPanel(); 
		panelTeachersWithTheseSkills.setLayout(new GridLayout(0,1));
		JLabel teachersWithTheseSkillsLabel = new JLabel("<html> Teachers <b>with</b> these skills: <html>");
		teachersWithTheseSkillsResult = new JTextField(); 
		panelTeachersWithTheseSkills.add(teachersWithTheseSkillsLabel);
		panelTeachersWithTheseSkills.add(teachersWithTheseSkillsResult);
		panelEight.add(panelTeachersWithTheseSkills);
		
		
		
	
		// Result2: teachers without these skills 
		JPanel panelTeachersWithoutTheseSkills = new JPanel(); 
		panelTeachersWithoutTheseSkills.setLayout(new GridLayout(0,1));
		JLabel teachersWithoutTheseSkillsLabel = new JLabel("<html> Teachers <b>without</b> these skills: <html>");
		teachersWithoutTheseSkillsResult = new JTextField(); 
		panelTeachersWithoutTheseSkills.add(teachersWithoutTheseSkillsLabel);
		panelTeachersWithoutTheseSkills.add(teachersWithoutTheseSkillsResult);
		panelEight.add(panelTeachersWithoutTheseSkills);
		

		JPanel panelAddSkillToTeacher = new JPanel(); 
		panelAddSkillToTeacher.setLayout(new GridLayout(0,1)); 
		JLabel addSkillToTeacherLabel = new JLabel("<html>Please enter the <b>teacher</b>,<br> and the <b>skill</b> to add to them,<br> seperated by a <b>space</b>,<br> and followed by <b>enter</b>:</html>");
		JTextField addSkillToTeacherField = new JTextField(); 
		addSkillToTeacherField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data = addSkillToTeacherField.getText();
				// Pass to Search Engine's method to add a particular skill to a Teacher: 
				searchEngine.addSkillToTeacher(data); 
				addSkillToTeacherField.setText("Processed");
				// Array to String, so it can be printed in the JTextField 
//				ArrayList<Teacher> temp = searchEngine.getTeacherList();
				StringBuffer sb = new StringBuffer();
			      for (Teacher s : searchEngine.getTeacherList()) {
			         sb.append(s);
			         sb.append(" ");
			      }
			      String str = sb.toString();
			      textArea2.setText(str);
				}
			
		});
		panelAddSkillToTeacher.add(addSkillToTeacherLabel);
		panelAddSkillToTeacher.add(addSkillToTeacherField);
		panelEight.add(panelAddSkillToTeacher);

		
		
		// Add Teacher to Lab panel 
		JPanel panelAddTeacherToLab = new JPanel(); 
		panelAddTeacherToLab.setLayout(new GridLayout(0,1));
		JLabel addTeacherToLabLabel = new JLabel("<html>Please enter the <b>Course</b>,<br> and the <b>Lab</b>,<br> and the <b>Teacher</b> to add, seperated by a <b>space</b>,<br> and followed by <b>enter</b>:</html>");
		JTextField addTeacherToLabEntry = new JTextField(); 
		addTeacherToLabEntry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String data = addTeacherToLabEntry.getText();
				searchEngine.addTeacherToLab(data);
				addTeacherToLabEntry.setText("Processed");
				
				StringBuffer sb = new StringBuffer();
			      for (Course s : searchEngine.getCourseList()) {
			         sb.append(s);
			         sb.append(" ");
			      }
			      String str = sb.toString();
				// Need to get the new data displayed on the other text field now ...
			      textArea2.setText(str);
				}			
		}); 
		
		panelAddTeacherToLab.add(addTeacherToLabLabel);
		panelAddTeacherToLab.add(addTeacherToLabEntry);
		panelEight.add(panelAddTeacherToLab);

	}
	
	////////////////////////////////////////
	////////////////////////////////////////
	////////////////////////////////////////
	// INTERACTION - not fully finished yet
	////////////////////////////////////////
	////////////////////////////////////////
	////////////////////////////////////////

	
	
	// buttonOne's actionListener: 
	public class button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			courseInfo = lab1.uploadFile();
			String listString = courseInfo.stream().map(Object::toString)
                    .collect(Collectors.joining("," + "\n"));
			// textArea1 should ONLY be set at the start of the program
			// At no other point does it change 
			textArea1.setText(listString);
			textArea2.setText("");
			cardLayout.show(frame.getContentPane(),"two");
		}
		
	}

	
	public class OtherCardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cardLayout.show(frame.getContentPane(),"one");
		}
		
	}
	
	
	public class BothListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == buttonOne)
			{
				cardLayout.show(frame.getContentPane(), "two");
			}
			else
			{
				cardLayout.show(frame.getContentPane(), "one");
			}
		}	
	}
	

		
	
	
	public static void main(String[] args) {
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	//
	public Lab getLab() {
		return this.lab1; 
	}
	
	public ArrayList<String> getCourseInfo(){
		return this.courseInfo; 
	}

	
	

}
	

