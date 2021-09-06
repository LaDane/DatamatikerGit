public class Main {
    public static void main(String[] args) {

        Node node = new Node("Mie");
        Node node1 = new Node("Viktor");

        node1.nextNode = node;
        System.out.println("Next node is : "+ node1.nextNode.name);
    }
}
