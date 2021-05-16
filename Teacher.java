import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	private String teacherName;
	private ArrayList <String> teacherSkills = new ArrayList<String>();
	private ArrayList <String> teacherTraining = new ArrayList<String>();

	
	//constructor 
	public Teacher(String teacherName, ArrayList<String> teacherSkills, ArrayList<String> teacherTraining) {
		super();
		this.teacherName = teacherName;
		this.teacherSkills = teacherSkills;
		this.teacherTraining = teacherTraining;
	}

	// TODO Auto-generated constructor stub
	public Teacher() {
		super();
	}


	//User enters teacherSkills or teacher Training
	pubilc ArryList<String> userEnters(){
		String contEnter;
	    System.out.println("Please enter");
	    ArrayList<String> contents= new ArrayList<String>();
        Scanner contentEnter = new Scanner(System.in);
        contEnter = contentEnter.next();
        //courseInst.add(courseInstructors); 

        for(String contEnter1 : contents) {
        	contEnter1 = contEnter;
            contentEnter.add(contEnter1);
        }
	}
	
	//Update teacher training information
	pubilc ArryList<String> void updateTrainingInfo(teacherSkills, teacherTraining){
		
		//User input
		System.out.println("Please enter the teacher skills of the training status you want to change, followed by the return key.");
		Scanner info = new Scanner(system.in);
		String changInfo = info.nextLine();	
		
		
		//Find the corresponding location
		int location;
		for(String str:teacherSkills){
		     if(str.contains(changInfo)){
		    	 location = teacherSkills.indexOf(str);
		     }
		}
		
		
		//Change the data in teacherTraining
		teacherTraining.set(location, "OK");  //Trained status is "OK"	
		return teacherTraining;
	}
	
	//Increase teacher's skills
	public void addSkill(teacherSkills) {
		System.out.println("Please enter a new skill, followed by the return key.");
		Scanner info = new Scanner(system.in);
		String newSkill = info.nextLine();	
		
		teacherSkills.add(newSkill);
		
	}
	
	
	
	//setting and getting
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public ArrayList<String> getTeacherSkills() {
		return teacherSkills;
	}
	public void setTeacherSkills(ArrayList<String> teacherSkills) {
		this.teacherSkills = teacherSkills;
	}
	public ArrayList<String> getTeacherTraining() {
		return teacherTraining;
	}
	public void setTeacherTraining(ArrayList<String> teacherTraining) {
		this.teacherTraining = teacherTraining;
	}

	
	//toString
	public String toString() {
		return "Teacher [teacherName=" + teacherName + "]";
	}

	//Main method
	public static void main(String[] args) {
	
	//Read the data to arrylist
	//because our group has not determined the data format, this is a simple way of writing
	Scanner s = new Scanner(new File("filepath"));
	ArrayList<String> list = new ArrayList<String>();
	while (s.hasNext()){
	    list.add(s.next());
	}
	s.close();
	}

}
