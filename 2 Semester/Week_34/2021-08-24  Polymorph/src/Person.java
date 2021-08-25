public class Person extends Command{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void whoAmI() {
        System.out.println("I am a person");
    }

    @Override
    public void execute() {
        whoAmI();
    }
}
