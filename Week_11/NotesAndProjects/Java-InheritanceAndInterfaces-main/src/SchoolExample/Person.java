package SchoolExample;

public class Person implements Human
{
    private String name;
    private int age;
    private Address address;

    public Person(String name, int age, Address address)
    {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public Address getAddress()
    {
        return address;
    }

    @Override
    public void eat()
    {
        System.out.println("nom nom nom");
    }

    @Override
    public void sleep()
    {
        System.out.println("zzzz");
    }

    @Override
    public void shit()
    {
        System.out.println("poopy time");
    }
}
