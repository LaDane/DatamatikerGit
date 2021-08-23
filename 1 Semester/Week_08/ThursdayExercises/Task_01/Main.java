class Main {
    public static void main(String[] args) {
        printString("print this");
        printNameAge("Aleksander", 24);
    }

    public static void printString(String s) {
        System.out.println(s);
    }

    public static void printNameAge(String name, int age) {
        System.out.println("My name is "+ name +", I am "+ age +" years old");
    }
}