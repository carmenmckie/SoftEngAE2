import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList <Labs> labs; 
	private ArrayList <String> skills;
	
	public Course(String name, ArrayList <Labs> labs, ArrayList <String> skills) {
		this.name = name;
		this.labs = labs;
		this.skills = skills;
		
	}
	public Course() {
		this.name = null;
		this.labs = new ArrayList<Labs>();
		this.skills = new ArrayList<String>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLab(Labs lab) {
		this.labs.add(lab);
	}
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	
	public String printLabs() {
		String lab = "";
		for(Labs i: labs) {
			lab += i.getName() + " " + i.getTeachersInLab();
			lab += ", teachers now needed for this lab: " + i.getnTeachers() + "\n";
		}
		return lab;
	}
	
	public String getCourseName() {
		return this.name;
	}
	
	public ArrayList<Labs> getLabList(){
		return this.labs;
	}


	// Need to get it to also print the Teachers in each lab 
	public String toString() {
		return this.name + " " + this.printLabs() + "\n";
	}
	
}
