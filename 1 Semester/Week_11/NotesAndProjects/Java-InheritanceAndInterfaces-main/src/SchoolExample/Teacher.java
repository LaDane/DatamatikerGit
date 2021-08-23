package SchoolExample;

public class Teacher extends Person
{
    private int employeeID;

    public Teacher(String name, int age, Address address, int employeeID)
    {
        super(name, age, address);
        this.employeeID = employeeID;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }
}
