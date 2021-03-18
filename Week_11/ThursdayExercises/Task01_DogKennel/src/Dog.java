import java.util.ArrayList;

public class Dog {
    private String name;
    private String owner;
    private boolean isHungry;
    private ArrayList<String> offSpring = new ArrayList<>();

    Dog(String _name, boolean _isHungry) {
        this.name = _name;
        this.isHungry = _isHungry;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() { return owner; }

    public String feedDog() {
        isHungry = false;
        return name + " has been fed, and is no longer hungry";
    }

    public void setOffSpring(String name) {
        offSpring.add(name);
    }

    public String[] getOffSpring() {
        String[] children = new String[offSpring.size()];
        for (int i = 0; i < children.length; i++) {
            children[i] = offSpring.get(i);
        }
        return children;
    }
}
