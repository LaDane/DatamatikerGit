public class English extends Dialog{
    @Override
    public String welcome() {
        return "Hello and welcome";
    }

    @Override
    public String quit() {
        return "Press q to quit";
    }

    @Override
    public String selectOject() {
        return "Enter the type of the object you want analyze";
    }
}
