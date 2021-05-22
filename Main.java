public class Main {

	public static void main(String[] args) {
				// create Model object that can be passed to create the View: 
				Model model = new Model(); 
				// Create a View object, which also makes a Controller object within: 
				View GUI = new View(model); 
				// Access the singleton searchEngine: 
				SearchEngine searchEngine = SearchEngine.getSearchEngine(); 
				// The Model object's searchEngine instance variable is then set to be 
				// this searchEngine, in order for the user to search the data
				// they input into the program by interacting with the GUI: 
				model.setSearchEngine(searchEngine);
				// searchEngine is then populated with the data that the user 
				// input via the JFileChooser:
				model.getSearchEngine().setAll(model.getTeacherList(), model.getCourseList());
			}
	}
