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
	}
	
	public Teacher() {
		this.teacherName = "";
		this.teacherSkills = new ArrayList<String>();
	}
	
	public void setSkill(String skill) {
		this.teacherSkills.add(skill);
	}
	
	//setting and getting:
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
	
	public ArrayList<String> getTeacherSkills() {
		return teacherSkills;
	}

	public String getTeacherName() {
		return this.teacherName; 
	}
	
	//toString
	public String toString() {
		return teacherName + ", with skills: " + this.printSkills();
	}
	
	

}
