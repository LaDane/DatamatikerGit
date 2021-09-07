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
}