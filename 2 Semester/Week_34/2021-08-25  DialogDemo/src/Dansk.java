public class Dansk extends Dialog{
    @Override
    public String welcome() {
        return "Hej og velkommen";
    }

    @Override
    public String quit() {
        return "Tryk q for at stoppe";
    }

    @Override
    public String selectOject() {
        return "Skriv navnet på det objekt du vil undersøge";
    }
}
