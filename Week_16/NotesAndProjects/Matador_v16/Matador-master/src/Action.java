public class Action {
    private String msg;
    private String response;
    private String yesPleaseMsg, noThanksMsg;



    public Action(){


    }



    public Action(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String response) {
        this.msg= response;
    }

    public void setResponseMsg(String response) {
        this.response = response;
    }
    public String getResponseMsg() {
        return this.response;
    }



   public String getYesPleaseMsg() {
        return yesPleaseMsg;
    }
    public String getNoThanksMsg() {
        return noThanksMsg;
    }
    public void setYesPleaseMsg(String yesPleaseMsg) {
        this.yesPleaseMsg = yesPleaseMsg;
    }
    public void setNoThanksMsg(String noThanksMsg) {
        this.noThanksMsg = noThanksMsg;
    }
}