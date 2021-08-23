package SchoolExample;

public class Student extends Person
{
    private int studentNumber;

    public Student(String name, int age, Address address, int studentNumber)
    {
        super(name, age, address);
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber()
    {
        return studentNumber;
    }

    @Override
    public void shit()
    {
        System.out.println("no more toilet paper");
    }
}
