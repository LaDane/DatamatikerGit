public abstract class Field {
    int id;
    String label;

    public Field(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public abstract Action getAction();

}
