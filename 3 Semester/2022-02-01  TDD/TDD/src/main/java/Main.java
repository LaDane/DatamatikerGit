public class Main {
    private static String cloth;
    private String hat;
    
    public static void main(String[] args) {
        Main m = new Main();
        String returnValue = m.sayHello();
        System.out.println(returnValue);
    }
    
    public String sayHello() {
        return "Hello";
    }
}
