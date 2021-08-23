package SchoolExample;

public class School
{
    private String name;
    private Semester semester;

    public School(String name, Semester semester)
    {
        this.name = name;
        this.semester = semester;
    }

    public String getName()
    {
        return name;
    }

    public Semester getSemester()
    {
        return semester;
    }
}
