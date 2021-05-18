import java.util.ArrayList;
import java.util.Scanner;

public class DataHandling {
	ArrayList<Course> courses;
	ArrayList<Teacher> teachers;
	ArrayList<String> courseInfo;
	
	public DataHandling(ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<String> courseInfo) {
		this.courses=courses;
		this.teachers=teachers;
		this.courseInfo=courseInfo;
	}

	public void dataHandler() {

		int flag = 0;

		for (String i : courseInfo) {
			
			Scanner sc1 = new Scanner(i);
			if(i.contains(".")) {
				flag = 1;
				continue;
			}
			
			
			if(flag == 0) {
				sc1.useDelimiter(", ");
				String s1 = sc1.next();
				String s2 = sc1.next();
				String s3 = sc1.next();
				
				
				Course course = new Course();
				
				course.setName(s1);
				
				Scanner sc2 = new Scanner(s2);
				while(sc2.hasNext()) {
					String labname = sc2.next();
					int labstaff = sc2.nextInt();
					
					FileIO lab = new FileIO(labname, labstaff);
					course.setLab(lab);
				}
				
				Scanner sc3 = new Scanner(s3);
				while(sc3.hasNext()) {
					String skillname = sc3.next();
					course.addSkill(skillname);
				}
				
				courses.add(course);
			}
			else {
				Teacher teacher = new Teacher();
				sc1.useDelimiter(", ");
				String s1 = sc1.next();
				String s2 = sc1.next();
				
				teacher.setTeacherName(s1);
				
				Scanner sc2 = new Scanner(s2);
				while(sc2.hasNext()) {
					String skillname = sc2.next();
					teacher.setSkill(skillname);
				}
				
				teachers.add(teacher);
	
			}
		}
		
		for(Course i: courses) {
			System.out.print(i.toString());
		}
		for(Teacher i: teachers) {
			System.out.println(i.toString());
		}
	}
}
