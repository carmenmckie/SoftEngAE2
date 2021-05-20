import java.util.ArrayList;
import java.util.Scanner;
//this class was made into a Singleton because we only ever need one of these objects and would not want more of them to be created:

public class SearchEngine {
	private ArrayList <Teacher> teacherList;
	private ArrayList <Course> courseList; 
	
	private static SearchEngine se = new SearchEngine();
	

	public static SearchEngine getSearchEngine() {
		return se;
	}
	
	public void setAll(ArrayList<Teacher> teacherList, ArrayList<Course> courseList) {
		this.teacherList = teacherList;
		this.courseList = courseList; 
	}

	
	//method to find a teacher by passing it a skill
	public ArrayList<Teacher> findTeacher(String skill) {
		ArrayList<Teacher> found = new ArrayList<Teacher>();
		for(Teacher i: teacherList) {
			if(i.getTeacherSkills().contains(skill)) {
				found.add(i);
			}
		}
		return found;
	}
	
	//method to find a teacher by passing it a name
	public Teacher findTeacherByName(String name) {
		Teacher tempTeacher = new Teacher(); 
			for (int i=0; i < this.getTeacherList().size(); i++) {
				if(this.getTeacherList().get(i).getTeacherName().contains(name)) {
					tempTeacher = this.getTeacherList().get(i);					
			}
		} return tempTeacher; 
	}	        
	
	// Testing: 
	// To add skill to specific teacher 
	// Maybe could be refactored to use .findTeacher - although it returns an ArrayList 
	public String addSkillToTeacher(String data) {
		Scanner s = new Scanner(data); 
		String teacher = s.next();
		String skill = s.next(); 
		String result = ""; 
		//Testing:
		result += "TEACHER: " + teacher + " SKILL: " + skill; 
		for(int i=0; i < this.teacherList.size(); i++) {
			// Find the teacher the user entered: 
			if(this.getTeacherList().get(i).getTeacherName().contains(teacher)) {
				// Give them this new skill: 
				this.getTeacherList().get(i).setSkill(skill); 
				}					
			}
		return result; 
		}
	

	public void addTeacherToLab(String data) {
		Scanner s = new Scanner(data); 
		String course = s.next(); 
		String lab = s.next(); 
		String teacher = s.next(); 
		this.findLabByName(data).getTeachersInLab().add(findTeacherByName(teacher)); 
		int temp = this.findLabByName(data).getnTeachers(); 
		// So that if a teacher is added, the number of teachers needed in the lab is decreased:
		if (!(temp == 0)) {
		// unless it is zero, then don't decrease this, as -1 teachers needed is not appropriate 
			temp = temp - 1; 
		}
		this.findLabByName(data).setnTeachers(temp);
	}
	
	public Labs findLabByName(String data) {
		Labs temp = null; 
		Scanner s = new Scanner(data); 
		String course = s.next(); 
		String lab = s.next(); 
		// Look for the Course: 
		for(int i=0; i < this.getCourseList().size(); i++) {
			// Find the Course the user entered: 
			if(this.getCourseList().get(i).getCourseName().contains(course)) {
				// Find the Lab within that course: 
				for(int j = 0; j < this.getCourseList().get(i).getLabList().size(); j++) {
					if(this.getCourseList().get(i).getLabList().get(j).getName().contains(lab)) {
						temp = this.getCourseList().get(i).getLabList().get(j);
					}
				}
			}
		}
		return temp; 
	}
	//method to find how many teachers are needed for one lab
	public int findTeachersNeededPerLab(String data) { 
		int temp = this.findLabByName(data).getnTeachers(); 
		return temp; 
	}	
	
	//method to return what teachers do not have the required skills (i.e. pass it an ArrayList<String> of skills)
	public ArrayList<Teacher> findTeachersToTrain(String skill) {
		ArrayList<Teacher> toTrain = new ArrayList<Teacher>();
		for(Teacher i: teacherList) {
			if(!i.getTeacherSkills().contains(skill)) {
				toTrain.add(i);
			}
		}
		return toTrain;
	}
	//getters and setters:
	public ArrayList<Teacher> getTeacherList(){
		return this.teacherList;
	}
	
	public ArrayList<Course> getCourseList(){
		return this.courseList; 
	}
	
	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList; 
	}
	
}
