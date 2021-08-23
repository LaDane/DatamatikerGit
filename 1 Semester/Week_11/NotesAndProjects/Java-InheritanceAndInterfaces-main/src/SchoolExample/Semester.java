package SchoolExample;

import java.util.*;

public class Semester
{
    private String semesterName;
    private Teacher teacher;
    private List<Student> students;

    public Semester(String semesterName, Teacher teacher, List<Student> students)
    {
        this.semesterName = semesterName;
        this.teacher = teacher;
        this.students = students;
    }

    public int getNumberOfStudents()
    {
        return students.size();
    }

    public String getSemesterName()
    {
        return semesterName;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public List<Student> getStudents()
    {
        return students;
    }
}
