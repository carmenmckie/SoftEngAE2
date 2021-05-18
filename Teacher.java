import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	private String teacherName;
	private ArrayList <String> teacherSkills = new ArrayList<String>();
//	private ArrayList <String> teacherTraining = new ArrayList<String>();

	
	//constructor 
	public Teacher(String teacherName, ArrayList<String> teacherSkills) {
		this.teacherName = teacherName;
		this.teacherSkills = teacherSkills;
//		this.teacherTraining = teacherTraining;
	}
	public Teacher() {
		this.teacherName = "";
		this.teacherSkills = new ArrayList<String>();
	}

	//User enters teacherSkills or teacher Training
	public ArrayList<String> userEnters(){
		String contEnter;
	    System.out.println("Please enter");
	    ArrayList<String> contents= new ArrayList<String>();
        Scanner contentEnter = new Scanner(System.in);
        contEnter = contentEnter.next();
        //courseInst.add(courseInstructors); 

        for(String contEnter1 : contents) {
        	contEnter1 = contEnter;
            contents.add(contEnter1);
        }
        
        return contents;
	}
	
	//Update teacher training information
//	public ArrayList<String> updateTrainingInfo(ArrayList<String> teacherSkills){
//		
//		//User input
//		System.out.println("Please enter the teacher skills of the training status you want to change, followed by the return key.");
//		Scanner info = new Scanner(System.in);
//		String changInfo = info.nextLine();	
//		
//		
//		//Find the corresponding location
//		int location = 0;
//		for(String str:teacherSkills){
//		     if(str.contains(changInfo)){
//		    	 location = teacherSkills.indexOf(str);
//		     }
//		}
//		
//		
//		//Change the data in teacherTraining
//		teacherTraining.set(location, "OK");  //Trained status is "OK"	
//		return teacherTraining;
//	}
	
	//Increase teacher's skills
//	public void addSkill(ArrayList<String> teacherSkills) {
//		System.out.println("Please enter a new skill, followed by the return key.");
//		Scanner info = new Scanner(System.in);
//		String newSkill = info.nextLine();	
//		
//		teacherSkills.add(newSkill);
//		
//	}
	
	public void setSkill(String skill) {
		this.teacherSkills.add(skill);
	}
	
	
	//setting and getting
//	public String getTeacherName() {
//		return teacherName;
//	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
//	public void setTeacherSkills(ArrayList<String> teacherSkills) {
//		this.teacherSkills = teacherSkills;
//	}
//	public ArrayList<String> getTeacherTraining() {
//		return teacherTraining;
//	}
//	public void setTeacherTraining(ArrayList<String> teacherTraining) {
//		this.teacherTraining = teacherTraining;
//	}

	public String printSkills() {
		String s = "";
		for(String i: teacherSkills) {
			s += i + " ";
		}
		return s;
	}
	
	
	//toString
	public String toString() {
		return teacherName + ", with skills: " + this.printSkills();
	}
	
	
	public ArrayList<String> getTeacherSkills() {
		return teacherSkills;
	}

	
	
	///Added in Tuesday 18.05.2021
	public String getTeacherName() {
		return this.teacherName; 
	}
	
	
	
	
	
	
	
	
	
	
	//Main method
//	public static void main(String[] args) {
	
	//Read the data to arrylist
	//because our group has not determined the data format, this is a simple way of writing
//	Scanner s = new Scanner(new File("filepath"));
//	ArrayList<String> list = new ArrayList<String>();
//	while (s.hasNext()){
//	    list.add(s.next());
//	}
//	s.close();
//	}

}