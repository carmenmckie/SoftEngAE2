import javax.swing.*;
import java.io.*;
import java.util.*;

public class File {

    //Instance Variables
    private ArrayList<String> myList = new ArrayList<String>();
    private String userDir = System.getProperty("user.home");

    //Getter Method for Arraylist
    public ArrayList<String> getMyList() {
        return myList;
    }

    //Getter Method for String name.
    public String getUserDir() {
        return userDir;
    }

    //Main Method
    public static void main(String[] args) {

    }

    //Method to upload a document and converts the text into an ArrayList
    public void uploadFile(){
        java.io.File file;
        Scanner fileInput;
        int theResponse;

        //Directory Position and Default Opening Location
        //Opens Browser in Desktop Menu
        JFileChooser filePicker = new JFileChooser();

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
                        File.getMyList().add(line);
                    }
                }
                else{
                    System.out.println("Not a file!");
                }
                fileInput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace(); //Prints Exception if any
            }
            System.out.println(getMyList());
        }
     }

    //}

    public void clearList(){
        //Clears the Arraylist
        getMyList().clear();
    }

    public void addRequirement(){

        System.out.println("Add new requirement: ");
        //Create New Scanner Object
        Scanner newCatch = new Scanner(System.in);
        String myText = newCatch.nextLine();
        //Adds Text to Array List
        getMyList().add(myText);
        System.out.println(getMyList());
    }

   public void createFile(){

       //Initialize File Object and Passing Path as Argument
       File file = new File(getUserDir() + "\\Desktop\\LabList.txt");
       boolean result;
       try
       {
           result = file.createNewFile();      //Creates a New File
           if(result)      // Test if Successfully Created a New File
           {
               System.out.println("file created "+file.getCanonicalPath()); //Returns the Path String
           }
           else
           {
               System.out.println("File already exist at location: "+file.getCanonicalPath());
           }
       }
       catch (IOException e)
       {
           e.printStackTrace();    //Prints Exception if any
       }
   }

   public void writeFile(){

       //First Create File, Before Writing it
       createFile();

       String fullList = "";

       FileWriter writer;
       try {
           writer = new FileWriter(getUserDir() + "\\Desktop\\LabList.txt");
           //Go through entire ArrayList and Concatenating Strings into String FullList
           for(String section : getMyList()){
               fullList = fullList + section + "\n";
           }
           //Write String FullList into the File
           writer.write(fullList);
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();        //Prints Exception if any
       }
   }
}
