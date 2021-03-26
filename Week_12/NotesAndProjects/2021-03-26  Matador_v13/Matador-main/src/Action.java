public class Action {
    private String msg;
    private int amount;
    private int playerId;

    public Action(String msg, int amount){
        this.msg = msg;
        this.amount = amount;
    }

    public Action(String msg, int amount, int playerId){
        this.msg = msg;
        this.amount = amount;
        this.playerId = playerId;
    }

    public Action(String msg){
        this.msg = msg;
    }

    public int getAmount() {
        return amount;
    }

    public String getMsg() {
        return msg;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}