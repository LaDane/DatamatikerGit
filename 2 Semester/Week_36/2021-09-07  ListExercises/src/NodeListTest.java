import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeListTest {

    NodeList list = new NodeList();

    @org.junit.jupiter.api.Test
    void insertFromHead() {
        assertEquals("1", list.insertFromHead(new Node("1")).name);
    }

    @org.junit.jupiter.api.Test
    void insertFromTail() {
        assertEquals("1", list.insertFromTail(new Node("1")).name);
    }

    @org.junit.jupiter.api.Test
    void removeFromHead() {
        fillList();
        assertEquals("5", list.removeFromHead().name);
    }

    @org.junit.jupiter.api.Test
    void removeFromTail() {
        fillList();
        assertEquals("1", list.removeFromTail().name);
    }

    @Test
    void printListFromHead() {
        fillList();
        assertEquals("54321", list.printFromHead());
    }

    @Test
    void printListFromTail() {
        fillList();
        assertEquals("12345", list.printFromTail());
    }

    void fillList() {
        list.insertFromHead(new Node("1"));
        list.insertFromHead(new Node("2"));
        list.insertFromHead(new Node("3"));
        list.insertFromHead(new Node("4"));
        list.insertFromHead(new Node("5"));
    }

    @Test
    void removeWithString() {
        fillList();
        list.removeWithString("2");
//        System.out.println(list.printFromHead());
        assertEquals("5431", list.printFromHead());
    }

    @Test
    void removeWithNode() {
        fillList();
        Node rNode = new Node("6");
        list.insertFromHead(rNode);
        list.insertFromHead(new Node("7"));
        list.removeWithNode(rNode);
        assertEquals("754321", list.printFromHead());
//        assertEquals("54321", list.printFromHead());
        System.out.println(list.printFromTail() +" - "+ list.printFromHead());
    }

    @Test
    void findNode() {

    }

    @Test
    void insertNodeNext() {
        fillList();
        Node nodeToInsert = new Node("-");
        list.insertNodeNext("1", nodeToInsert);
//        assertEquals("5432-1", list.printFromHead());
        assertEquals("54321-", list.printFromHead());
        System.out.println(list.printFromHead());
    }

    @Test
    void insertNodePrevious() {
        fillList();
        Node nodeToInsert = new Node("-");
        list.insertNodePrevious("5", nodeToInsert);
//        assertEquals("543-21", list.printFromHead());
        assertEquals("-54321", list.printFromHead());
        System.out.println(list.printFromHead());
    }
}