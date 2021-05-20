import java.util.ArrayList;
import java.util.Scanner;
/*this is a class for handling the data that was read in from the txt file. When the file in the correct format is uploaded 
this class uses Scanners to create an ArrayList of courseInfo, which stops when the line contains a dot "." i.e. delimiter, 
after which Teacher information is stored in the ArrayList of Teachers. The ArrayList of courseInfo gets split futher into information about course name, 
lab name and skill name using the "," delimiter. Similarly, the ArrayList of Teachers gets populated with the data contained in the file with Teacher name and Teacher skills
All this is done via one method called dataHandler() in order to perform this operation in one stape (i.e. an atomic way) and thus reduce the possibility of errors ocurring */
public class DataHandling {
	ArrayList<Course> courses;
	ArrayList<Teacher> teachers;
	ArrayList<String> courseInfo;
	
	public DataHandling(ArrayList<Course> courses, ArrayList<Teacher> teachers, ArrayList<String> courseInfo) {
		this.courses=courses;
		this.teachers=teachers;
		this.courseInfo=courseInfo;
	}
//method to perform handling of data:
	public void dataHandler() {
//flag to be able to recognise when a line with a dot ocurrs: 
		int flag = 0;
//loop to iterate over the lines before the dot: 
		for (String i : courseInfo) {
			//if a dot is encountered, the flag gets set to 1
			Scanner sc1 = new Scanner(i);
			if(i.contains(".")) {
				flag = 1;
				continue;
			}
			
			//as long as flag = 0, each line is scanned
			if(flag == 0) {
				sc1.useDelimiter(", ");
				String s1 = sc1.next();
				String s2 = sc1.next();
				String s3 = sc1.next();
				
				// and a new course obeject is created:
				Course course = new Course();
				// the first entry before the comma in each line is the course name
				course.setName(s1);
			//the second String after the first comma and until the next comma is split further:
				Scanner sc2 = new Scanner(s2);
				while(sc2.hasNext()) {
					//the first entry is the name of the lab
					String labname = sc2.next();
					//the second entry is the number of staff required to teach that lab
					int labstaff = sc2.nextInt();
					
					Lab lab = new Lab(labname, labstaff);
					course.setLab(lab);
				}
				//after the last comma, the skills are read in which are separated in the file by a space character
				Scanner sc3 = new Scanner(s3);
				while(sc3.hasNext()) {
					String skillname = sc3.next();
					course.addSkill(skillname);
				}
				
				courses.add(course);
			}
			else {
				
				//after encountering the dot a new Teacher class is created with each line in the document: 
				Teacher teacher = new Teacher();
				// when the comma delimiter in each line ocurrs, a new string is created: 
				sc1.useDelimiter(", ");
				String s1 = sc1.next();
				String s2 = sc1.next();
				//the first String is the teacher name:
				teacher.setTeacherName(s1);
				//the second String are the teacher's skills
				Scanner sc2 = new Scanner(s2);
				//there are as many skills per teacher as there are spaces
				while(sc2.hasNext()) {
					String skillname = sc2.next();
					teacher.setSkill(skillname);
				}
				
				teachers.add(teacher);
	
			}
		}
		// printing to test:
		for(Course i: courses) {
			System.out.print(i);
		}
		for(Teacher i: teachers) {
			System.out.println(i);
		}
	}
}
