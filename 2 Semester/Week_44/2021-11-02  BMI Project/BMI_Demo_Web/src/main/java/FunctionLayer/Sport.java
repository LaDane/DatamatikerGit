package FunctionLayer;

public class Sport {

    private int sports_id;
    private String name;

    public Sport(int sports_id, String name) {
        this.sports_id = sports_id;
        this.name = name;
    }

    public int getSports_id() {
        return sports_id;
    }

    public void setSports_id(int sports_id) {
        this.sports_id = sports_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
