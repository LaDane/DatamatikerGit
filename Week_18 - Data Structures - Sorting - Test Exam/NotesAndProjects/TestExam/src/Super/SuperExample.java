package Super;

public class SuperExample {
    public static void main(String[] args) {
        A objectA = new A();
        System.out.println("\nCREATING B NOW\n");
        B objectB = new B(1);
    }
}

class A {
    public A() {
        System.out.println("This is A");
    }
    public A(int i) {
        System.out.println("This is A WITH int");
    }
}

class B extends A {
    public B() {
        System.out.println("This is B");
    }
    public B(int i ) {
        super(i);
        System.out.println("This is B WITH int");
    }
}
