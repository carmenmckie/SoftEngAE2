import java.util.ArrayList;
//this class contains the name of the course, holds a reference to the Labs class as an ArrayList, and also an ArrayList of skills that are required for a course
public class Course {
	private String name;
	private ArrayList <Lab> labs; 
	private ArrayList <String> skills;
	
	public Course(String name, ArrayList <Lab> labs, ArrayList <String> skills) {
		this.name = name;
		this.labs = labs;
		this.skills = skills;
		
	}
	public Course() {
		this.name = null;
		this.labs = new ArrayList<Lab>();
		this.skills = new ArrayList<String>();
	}
	//getters and setters:
	public void setName(String name) {
		this.name = name;
	}
	public void setLab(Lab lab) {
		this.labs.add(lab);
	}
	
	public String getCourseName() {
		return this.name;
	}
	
	public ArrayList<Lab> getLabList(){
		return this.labs;
	}
	
	//method to add a skill to the course
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	// printLabs method to print how many teachers are required for a lab
	public String printLabs() {
		String lab = "";
		for(Lab i: labs) {
			lab += i.getName() + " " + i.getTeachersInLab();
			lab += ", teachers now needed for this lab: " + i.getnTeachers() + "\n";
		}
		return lab;
	}

	// toString to print the Teachers in each lab 
	public String toString() {
		return this.name + " " + this.printLabs() + "\n";
	}
	
}
