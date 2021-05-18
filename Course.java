import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList <FileIO> labs; 
	private ArrayList <String> skills;
	
	
	// Get Course by Name: 
//	
//	public Course returnCourseByName() {
//		
//	}
	
	public Course(String name, ArrayList <FileIO> labs, ArrayList <String> skills) {
		this.name = name;
		this.labs = labs;
		this.skills = skills;
		
	}
	public Course() {
		this.name = null;
		this.labs = new ArrayList<FileIO>();
		this.skills = new ArrayList<String>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLab(FileIO lab) {
		this.labs.add(lab);
	}
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	
	public String printLabs() {
		String lab = "";
		for(FileIO i: labs) {
			lab += i.getName() + " " + i.getTeachersInLab();
		}
		
		return lab;
		
	}
	
	public String getCourseName() {
		return this.name;
	}
	
	public ArrayList<FileIO> getLabList(){
		return this.labs;
	}


	// Need to get it to also print the Teachers in each lab 
	public String toString() {
		return this.name + " " + this.printLabs();
	}
	
}