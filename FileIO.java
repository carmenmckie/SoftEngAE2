import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileIO {
    private  ArrayList<String> labList = new ArrayList<String>();
    // static - an issue 
    private static String userDir = System.getProperty("user.home");

    //Getter Method for Arraylist
    public ArrayList<String> getLabList() {
        return labList;
    }

    //Getter Method for String name.
    public static String getUserDir() {
        return userDir;
    }
    
    
    //Method to upload a document and converts the text into an ArrayList
    public  ArrayList<String> uploadFile(){
        File file;
        Scanner fileInput;
        int theResponse;

        //Directory Position and Default Opening Location
        //Opens Browser in Desktop Menu
        JFileChooser filePicker = new JFileChooser(getUserDir() + "Desktop");

        //Allows the User to Select Files or Directories within the Browser
        filePicker.setFileSelectionMode((JFileChooser.FILES_AND_DIRECTORIES));
        
        //The Response is assigned a numerical value (Approved, Closed, or Canceled)
        theResponse = filePicker.showOpenDialog(null);

        //If Response is 1 continue, If Response is 0 skip
        if(theResponse == JFileChooser.APPROVE_OPTION){
            file = filePicker.getSelectedFile();
            try {
                fileInput = new Scanner(file);
                if(file.isFile()){
                    while(fileInput.hasNextLine()){
                        //Add Contents of Uploaded File into an Arraylist
                        String line = fileInput.nextLine();
                        //   System.out.println(line);
                        getLabList().add(line);
                    }
                }
                else{
                    System.out.println("Not a file!");
                }
                fileInput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace(); //Prints Exception if any
            }
            //System.out.println(getLabList());
        }
		return getLabList();
    }
    
    public static void saveFile(ArrayList<Course> courses, ArrayList<Teacher> teachers) {
	    BufferedWriter out = null; 
    	StringBuffer sb = new StringBuffer();
    	StringBuffer sb2 = new StringBuffer();
    	String userHomeFolder = getUserDir(); 
    	File updatedData = new File(userHomeFolder, "LabList.txt");
	    try {
	    	// Saves to home directory 
	    	out = new BufferedWriter(new FileWriter(updatedData));
	    	// Courses 
	            for (Course s : courses) {
	              sb.append(s + "\n");
	            }
	        String coursesInString = sb.toString();
	         out.write(coursesInString);
	        // Teachers
		  for (Teacher s2 : teachers) {
		       sb2.append(s2 + "\n");
		     }
	       String teachersInString = sb2.toString();
	       out.write(teachersInString);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally { 
	    	try {
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	    }
	}
}
