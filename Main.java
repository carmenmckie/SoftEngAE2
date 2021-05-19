
public class Main {

	public static void main(String[] args) {
				Lab lab1 = new Lab();
				View GUI = new View(lab1); 
				SearchEngine searchEngine = SearchEngine.getSearchEngine(); 
				searchEngine.setAll(GUI.getTeacherList(), GUI.getCourseList());
				GUI.setSearchEngine(searchEngine);
			}
		}
