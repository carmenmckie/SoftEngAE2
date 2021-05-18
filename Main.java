import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Opening two FileReaders, may be fixed by making this into a seperate method / class 
	// Not had a chance to make this into seperate methods yet 
	
	public static void main(String[] args) {

		//!!!!!!! Because of two .uploadFiles() it opens a JFileChooser twice, needs fixed.... 
		Lab lab1 = new Lab();
		ArrayList<String> courseInfo = new ArrayList<>();
		courseInfo = lab1.uploadFile();
		
		ArrayList<Course> courses = new ArrayList<>();
		ArrayList<Teacher> teachers = new ArrayList<>();
		DataHandling dh = new DataHandling(courses, teachers, courseInfo);
		dh.dataHandler();
		//
		View GUI = new View(lab1); 
		SearchEngine searchEngine = SearchEngine.getSearchEngine(); 
		searchEngine.setAll(teachers, courses);
		GUI.setSearchEngine(searchEngine);
		
	//	lab1.writeFile();
	}
}