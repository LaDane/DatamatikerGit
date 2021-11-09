package FunctionLayer;

public class Info {

    private int info_id;
    private String name;

    public Info(int info_id, String name) {
        this.info_id = info_id;
        this.name = name;
    }

    public int getInfo_id() {
        return info_id;
    }

    public void setInfo_id(int info_id) {
        this.info_id = info_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
