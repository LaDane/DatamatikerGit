import java.util.ArrayList;

public class Semester {
    String name;
    Teacher teacher;
    ArrayList<Student> students = new ArrayList<Student>();

    public Semester(String name, Teacher teacher, ArrayList<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }
}
