import java.util.ArrayList;

public class Lab {
    private String name; 
    private int nTeachers;
    private ArrayList <String> skills;
    private ArrayList<Teacher> teachersInLab = new ArrayList<Teacher>();
    
    
    public Lab (String name, int nTeachers, ArrayList <String> requirements) {
        this.name = name;
        this.nTeachers = nTeachers;
        this.skills = requirements;
    }
    
    public Lab (String name, int nTeachers) {
        this.name = name;
        this.nTeachers = nTeachers;
    }
    public String toString() {
        return name + " " + skills + ", " + teachersInLab;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Teacher> getTeachersInLab(){
    	return this.teachersInLab;
    }

    public int getnTeachers() {
        return nTeachers;
    }

    public void setnTeachers(int nTeachers) {
        this.nTeachers = nTeachers;
    }

    public ArrayList<String> getSkill() {
        return skills;
    }

    public void setSkill(ArrayList<String> requirements) {
        this.skills = requirements;
    }
}
