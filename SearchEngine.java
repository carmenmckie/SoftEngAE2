import java.util.ArrayList;
import java.util.Scanner;
//Search engine is a Singleton since we only ever need one of these objects 

public class SearchEngine {
	private ArrayList <Teacher> teacherList;
	private ArrayList <Course> courseList; 
	
//	public SearchEngine(ArrayList<Teacher> teacherList, ArrayList<Course> courseList) { //, ArrayList <String> teacherSkills) {
//		this.teacherList = teacherList;
//		this.courseList = courseList; 
//	}
	
	private static SearchEngine se = new SearchEngine();
	
	private SearchEngine() {
		
	}
	
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
	
	// *****************************
	// Add Teacher to Lab 
	// The order the user should enter is 1. Course 2. Lab 3. Teacher Name 
//	public Course addTeacherToLab(String data) {
//		Course tempCourse = new Course(); 
//		Scanner s = new Scanner(data); 
//		String course = s.next(); 
//		String lab = s.next(); 
//		String teacher = s.next(); 
//		// Look for the Course: 
//		for(int i=0; i < this.getCourseList().size(); i++) {
//			// Find the Course the user entered: 
//			if(this.getCourseList().get(i).getCourseName().contains(course)) {
//				tempCourse = this.getCourseList().get(i);
//				// Find the Lab within that course: 
//				for(int j = 0; j < this.getCourseList().get(i).getLabList().size(); j++) {
//					if(this.getCourseList().get(i).getLabList().get(j).getName().contains(lab)) {
//						// Add the Teacher requested to that specific Lab 
//						this.getCourseList().get(i).getLabList().get(j).getTeachersInLab().add(findTeacherByName(teacher));
//						// find teacher 
//					}
//				}
//				
//				
//			}
//		}	return tempCourse; 				
//	}
//		
//	
	
	public void addTeacherToLab(String data) {
//		Course tempCourse = new Course(); 
		Scanner s = new Scanner(data); 
		String course = s.next(); 
		String lab = s.next(); 
		String teacher = s.next(); 
		// Look for the Course: 
		for(int i=0; i < this.getCourseList().size(); i++) {
			// Find the Course the user entered: 
			if(this.getCourseList().get(i).getCourseName().contains(course)) {
//				tempCourse = this.getCourseList().get(i);
				// Find the Lab within that course: 
				for(int j = 0; j < this.getCourseList().get(i).getLabList().size(); j++) {
					if(this.getCourseList().get(i).getLabList().get(j).getName().contains(lab)) {
						// Add the Teacher requested to that specific Lab 
						this.getCourseList().get(i).getLabList().get(j).getTeachersInLab().add(findTeacherByName(teacher));
						// find teacher 
					}
				}
				
				
			}
		}					
	}
		
	
	
	
	//method to return what teachers do not have ALL the required skills (i.e. pass it an ArrayList<String> of skills)
	// Changed to just a String and not a String Array 
	public ArrayList<Teacher> findTeachersToTrain(String skill) {
		ArrayList<Teacher> toTrain = new ArrayList<Teacher>();
		for(Teacher i: teacherList) {
			if(!i.getTeacherSkills().contains(skill)) {
				toTrain.add(i);
			}
		}
		return toTrain;
	}
	
	public ArrayList<Teacher> getTeacherList(){
		return this.teacherList;
	}
	
	public ArrayList<Course> getCourseList(){
		return this.courseList; 
	}
	
	////
	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList; 
	}
	
}