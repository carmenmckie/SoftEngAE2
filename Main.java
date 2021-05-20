
public class Main {

	public static void main(String[] args) {
				FileIO fileHandler = new FileIO();
				View GUI = new View(fileHandler); 
				SearchEngine searchEngine = SearchEngine.getSearchEngine(); 
				searchEngine.setAll(GUI.getTeacherList(), GUI.getCourseList());
				GUI.setSearchEngine(searchEngine);
			}
		}
