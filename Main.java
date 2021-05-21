public class Main {

	public static void main(String[] args) {
				// FileIO object made in order to pass to the GUI:
				FileIO fileHandler = new FileIO();
				// GUI takes a fileHandler object as a parameter in order
				// to read the data input by the user via the JFileChooser:
				View GUI = new View(fileHandler); 
				// Access the singleton searchEngine: 
				SearchEngine searchEngine = SearchEngine.getSearchEngine(); 
				// searchEngine is then populated with the data that the user 
				// input via the JFileChooser:
				searchEngine.setAll(GUI.getTeacherList(), GUI.getCourseList());
				// The GUI's searchEngine instance variable is then set to be 
				// this searchEngine, in order for the user to search the data
				// they input into the program by interacting with the GUI: 
				GUI.setSearchEngine(searchEngine);
			}
	}
