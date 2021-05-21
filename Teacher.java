import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher {
	private String teacherName;
	private ArrayList <String> teacherSkills = new ArrayList<String>();
	
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

        return contents;
	}
	
	public void setSkill(String skill) {
		this.teacherSkills.add(skill);
	}
	
	
	//setting and getting

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	

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
