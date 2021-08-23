package SchoolExample;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Address teacherAddress = new Address("roady", 1337, 0, "", 90210, "Denmark");
        Teacher teacher = new Teacher("Jesper", 31, teacherAddress, 666);

        ArrayList<Student> students = new ArrayList<Student>();

        students.add(new Student("Bob", 52, new Address("", 1, 0, "", 3520, "De varme lande"), 1678666));

        Semester firstSemester = new Semester("DAT1B", teacher, students);
        School cba = new School("Copenhagen Business Academy", firstSemester);

        System.out.println(cba.getName());
        System.out.println(cba.getSemester().getSemesterName());
        System.out.println("Number of students: "+cba.getSemester().getNumberOfStudents());

        System.out.println(teacher.getName());
        System.out.println(teacher.getAddress());

        teacher.shit();

        students.get(0).sleep();
        students.get(0).shit();

    }
}
