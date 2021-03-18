public class Person implements Human{
    String name;
    int age;
    Address address;

    public Person(String _name, int _age, Address _address) {
        this.name = _name;
        this.age = _age;
        this.address = _address;
    }


    @Override
    public void sleep() {
        System.out.println("I sleep now");
    }

    @Override
    public void eat() {
        System.out.println("I eat now");
    }
}
