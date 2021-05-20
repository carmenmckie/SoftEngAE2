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


public class View {

	private JFrame frame;
	private JPanel panelOne;
	private JPanel panelTwo;
	private JPanel panelThree;
	private JPanel panelFour; 
	private JPanel panelFive; 
	private JPanel panelSeven; 
	private JPanel panelEight; 
	private JPanel panelUserEnters;
	private JPanel panelTeachersWithTheseSkills; 
	private JPanel panelTeachersWithoutTheseSkills;
	private JPanel panelAddSkillToTeacher; 
	private JPanel panelAddTeacherToLab; 
	private JPanel panelCheckLabRequirements; 
	private JTextArea textArea1;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane teachersWithTheseSkillsScrollPanel;
	private JScrollPane teachersWithoutTheseSkillsScrollPanel;
	private JLabel JLabel1; 
	private JLabel csvLabel;
	private JLabel updatedDataLabel;
	private JLabel teachersWithTheseSkillsLabel;
	private JLabel teachersWithoutTheseSkillsLabel; 
	private JLabel addSkillToTeacherLabel; 
	private JLabel addTeacherToLabLabel; 
	private JLabel checkRequirementsLabel; 
	private JTextArea textArea2;
	private JTextArea teachersWithoutTheseSkillsResult;
	private JTextField addSkillToTeacherField; 
	private JTextField addTeacherToLabEntry; 
	private JTextField checkLabRequirementsEntry; 
	private JButton button2;
	private JLabel userEntersLabel;
	private JTextArea teachersWithTheseSkillsResult;
	private JTextField userEntersTraining;
	public static final int FRAME_HEIGHT = 900; 
	public static final int FRAME_WIDTH = 1800; 
	public static final int TEXTAREA_HEIGHT = 45; 
	public static final int TEXTAREA_WIDTH = 20; 
	public static final int CLOSE_PROGRAM = 0; 
	private JButton buttonOne;
	private CardLayout cardLayout;
	private SearchEngine searchEngine;
	private FileIO fileHandler;
	private ArrayList<String> courseInfo;
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Teacher> teachers = new ArrayList<>();
	
	// Called when GUI is made: 
	public View(FileIO fileHandler) {
		makeComponents();
		makeLayout();
		this.fileHandler = fileHandler; 
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
		
		// Class Director Page (Upload File) 
		panelOne = new JPanel();
		JLabel1 = new JLabel("Hello Class Director, please choose a file:");
		buttonOne = new JButton("Choose a File >>");
		buttonOne.addActionListener(new button1Listener());
		panelOne.add(JLabel1);
		panelOne.add(buttonOne);
		
		
		// Administrator - work with the data 
		panelTwo = new JPanel();
		panelTwo.setLayout(new BorderLayout());

		
		// WEST BorderLayout 
		// panelThree - To Display Data from CSV File 
		panelThree = new JPanel(); 
		textArea1 = new JTextArea(TEXTAREA_HEIGHT, TEXTAREA_WIDTH);
		// textArea1 will be loaded with data from the .txt file, so this text will be replaced: 
		textArea1.setText("Data from .txt file to go here");
		// Original CSV data not to be edited: 
		textArea1.setEditable(false); 
		scrollPane1 = new JScrollPane(textArea1);
		panelThree.add(scrollPane1);
		panelTwo.add(panelThree, BorderLayout.WEST);
		

		// NORTH BorderLayout
		// Panel Four - Menu 
		panelFour = new JPanel(); 
		panelFour.setLayout(new BorderLayout());
		csvLabel = new JLabel("Data from .txt File:");
		updatedDataLabel = new JLabel("Updated Data:");
		panelFour.add(csvLabel, BorderLayout.WEST);
		panelFour.add(updatedDataLabel, BorderLayout.EAST);
		panelTwo.add(panelFour, BorderLayout.NORTH);

		
		// EAST BorderLayout 
		// Panel Five - Updated Data 
		panelFive = new JPanel(); 
		textArea2 = new JTextArea(TEXTAREA_HEIGHT,TEXTAREA_WIDTH); 
		// Will display the updated data when the user makes changes throughout: 
		textArea2.setText("updated data could go here");
		scrollPane2 = new JScrollPane(textArea2); 
		panelFive.add(scrollPane2); 
		panelTwo.add(panelFive, BorderLayout.EAST);
		
		// SOUTH BorderLayout 
		panelSeven = new JPanel(); 
		panelSeven.setLayout(new BorderLayout());
		panelTwo.add(panelSeven, BorderLayout.SOUTH); 
		// Save Button 
		button2 = new JButton("Save to File and Close");
		button2.addActionListener(new button2Listener());
		panelSeven.add(button2, BorderLayout.EAST);

		////////////////////////////////
		// CENTER BorderLayout 
		////////////////////////////////
		panelEight = new JPanel(); 
		panelEight.setLayout(new GridLayout(0, 3));
		panelTwo.add(panelEight, BorderLayout.CENTER);

		
		/////////////////////////////////
		// Top Row
		/////////////////////////////////
		// Enter Teacher - .userEnters()
		panelUserEnters = new JPanel(); 
		panelUserEnters.setLayout(new GridLayout(0, 1));
		userEntersLabel = new JLabel("<html>Please enter the <b>skill</b><br> you are searching for,<br> followed by enter:</html>");
		userEntersTraining = new JTextField();
		userEntersTraining.addActionListener(new userEntersTrainingListener());
		// Add event handling to clear the text when clicked
		panelUserEnters.add(userEntersLabel);
		panelUserEnters.add(userEntersTraining);
		panelEight.add(panelUserEnters);

		
		// Result Panel: teachers with these skills 
		panelTeachersWithTheseSkills = new JPanel(); 
		panelTeachersWithTheseSkills.setLayout(new GridLayout(0,1));
		teachersWithTheseSkillsLabel = new JLabel("<html> Teachers <b>with</b> these skills: <html>");
		teachersWithTheseSkillsResult = new JTextArea(); 
		teachersWithTheseSkillsScrollPanel = new JScrollPane(teachersWithTheseSkillsResult); 
		panelTeachersWithTheseSkills.add(teachersWithTheseSkillsLabel);
		panelTeachersWithTheseSkills.add(teachersWithTheseSkillsScrollPanel);
		panelEight.add(panelTeachersWithTheseSkills);
		
		
		// Result Panel: teachers without these skills 
		panelTeachersWithoutTheseSkills = new JPanel(); 
		panelTeachersWithoutTheseSkills.setLayout(new GridLayout(0,1));
		teachersWithoutTheseSkillsLabel = new JLabel("<html> Teachers <b>without</b> these skills: <html>");
		teachersWithoutTheseSkillsResult = new JTextArea(); 
		teachersWithoutTheseSkillsScrollPanel = new JScrollPane(teachersWithoutTheseSkillsResult);
		panelTeachersWithoutTheseSkills.add(teachersWithoutTheseSkillsLabel);
		panelTeachersWithoutTheseSkills.add(teachersWithoutTheseSkillsScrollPanel);
		panelEight.add(panelTeachersWithoutTheseSkills);
		

		/////////////////////////////////
		// Bottom Row
		/////////////////////////////////
		// Add Skill to Teacher Panel
		panelAddSkillToTeacher = new JPanel(); 
		panelAddSkillToTeacher.setLayout(new GridLayout(0,1)); 
		addSkillToTeacherLabel = new JLabel("<html>Please enter the <b>teacher</b>,<br> and the <b>skill</b> to add to them,<br> seperated by a <b>space</b>,<br> and followed by <b>enter</b>:</html>");
		addSkillToTeacherField = new JTextField(); 
		addSkillToTeacherField.addActionListener(new addSkillToTeacherFieldListener());
		panelAddSkillToTeacher.add(addSkillToTeacherLabel);
		panelAddSkillToTeacher.add(addSkillToTeacherField);
		panelEight.add(panelAddSkillToTeacher);

		
		// Add Teacher to Lab panel 
		panelAddTeacherToLab = new JPanel(); 
		panelAddTeacherToLab.setLayout(new GridLayout(0,1));
		addTeacherToLabLabel = new JLabel("<html>Please enter the <b>Course</b>,<br> and the <b>Lab</b>,<br> and the <b>Teacher</b> to add, seperated by a <b>space</b>,<br> and followed by <b>enter</b>:</html>");
		addTeacherToLabEntry = new JTextField(); 
		addTeacherToLabEntry.addActionListener(new addTeacherToLabEntryListener());
		panelAddTeacherToLab.add(addTeacherToLabLabel);
		panelAddTeacherToLab.add(addTeacherToLabEntry);
		panelEight.add(panelAddTeacherToLab);
		
		
		// Panel to check what requirements are still needed:
		panelCheckLabRequirements = new JPanel(); 
		panelCheckLabRequirements.setLayout(new GridLayout(0,1));
		checkRequirementsLabel = new JLabel("<html>Please enter the <b>Course</b>,<br> and the <b>Lab</b>,<br> seperated by a <b>space</b>,<br>to see how many teachers are needed: </html>");
		checkLabRequirementsEntry = new JTextField(); 
		checkLabRequirementsEntry.addActionListener(new checkLabRequirementsEntryListener());
		panelCheckLabRequirements.add(checkRequirementsLabel); 
		panelCheckLabRequirements.add(checkLabRequirementsEntry);
		panelEight.add(panelCheckLabRequirements);
	}
	
	
	public void setSearchEngine(SearchEngine searchEngine) {
		this.searchEngine = searchEngine; 
	}
	
	public ArrayList<String> getCourseInfo(){
	return this.courseInfo;
	}

	public ArrayList<Teacher> getTeacherList(){
		return this.teachers;
	}
	
	public ArrayList<Course> getCourseList(){
		return this.courses;
	}
	
	private static String teacherArrayListToString(ArrayList<Teacher> teacherList) {
		StringBuffer sb = new StringBuffer(); 
		for(Teacher s : teacherList) {
			sb.append(s); 
			sb.append(" "); 
			sb.append("\n");
		}
		String str = sb.toString(); 
		return str; 
	}


	////////////////////////////////////////
	// Interaction 
	////////////////////////////////////////

	
	// buttonOne's actionListener: 
	public class button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			courseInfo = fileHandler.uploadFile();
			// Creates DataHandling object so data from file can be read: 
			DataHandling dh = new DataHandling(courses, teachers, courseInfo); 
			dh.dataHandler();
			String listString = courseInfo.stream().map(Object::toString)
                    .collect(Collectors.joining("," + "\n"));
			// textArea1 should ONLY be set at the start of the program
			// At no other point does it change 
			textArea1.setText(listString);
			textArea2.setText("");
			cardLayout.show(frame.getContentPane(),"two");
		}

	}

	// ActionListener for 'addSkillToTeacherField' 
	private class addSkillToTeacherFieldListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String data = addSkillToTeacherField.getText();
			// Pass to Search Engine's method to add a particular skill to a Teacher: 
			searchEngine.addSkillToTeacher(data); 
			addSkillToTeacherField.setText("Processed");
			// Array to String, so it can be printed in the JTextField 
			StringBuffer sb = new StringBuffer();
		      for (Teacher s : searchEngine.getTeacherList()) {
		         sb.append(s);
		         sb.append("\n");
		         
		      }
		      String str = sb.toString();
		      textArea2.setText(str);
		}
	}
	
	private class addTeacherToLabEntryListener implements ActionListener { 
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
	      textArea2.setText(str);
		}
	}
	
	private class checkLabRequirementsEntryListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			String data = checkLabRequirementsEntry.getText(); 
			int temp = searchEngine.findTeachersNeededPerLab(data);
			String str = "This lab currently needs " + temp + " teachers.";
			checkLabRequirementsEntry.setText(str);
			
		}
	}

	
	private class userEntersTrainingListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String data = userEntersTraining.getText();
			ArrayList<Teacher> teachersWithSkill = searchEngine.findTeacher(data); 
			int counter1 = teachersWithSkill.size(); 
		      // Teachers WITH this skill displayed in the output: 
			teachersWithTheseSkillsResult.setText("There are " + counter1 + " teacher(s) with this skill: \n\n" + teacherArrayListToString(teachersWithSkill));
			// Clear the search box so another search can occur: 
			userEntersTraining.setText("");
			// Teachers without this skill: 
			ArrayList<Teacher> teachersWithoutSkill = searchEngine.findTeachersToTrain(data);
			int counter2 = teachersWithoutSkill.size();
				// Teachers WITHOUT this skill displayed in the output: 
				teachersWithoutTheseSkillsResult.setText("There are " + counter2 + " teacher(s) without this skill: \n\n" + teacherArrayListToString(teachersWithoutSkill));
			}			
		}
	
	private class button2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchEngine.getCourseList(); 
			FileIO.saveFile(searchEngine.getCourseList(), searchEngine.getTeacherList());
			System.exit(CLOSE_PROGRAM);		
			}
	}
}

