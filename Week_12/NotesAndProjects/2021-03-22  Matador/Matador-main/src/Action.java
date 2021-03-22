public class Action {
    private String msg;
    private int amount;

    public Action(String msg, int amount) {
        this.msg = msg;
        this.amount = amount;
    }

    public Action(String msg) {
        this.msg = msg;
    }

    public int getAmount() {
        return amount;
    }

    public String getMsg() {
        return msg;
    }
}