import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeListTest {

    NodeList list = new NodeList();

    @org.junit.jupiter.api.Test
    void insertFromHead() {

        Node node = new Node("Viktor");
        Node node1 = new Node("Christian");

        assertEquals("Viktor", list.insertFromHead(node).name);
        assertEquals("Christian", list.insertFromHead(node1).name);
        assertEquals("Christian", list.headNode.name);
    }

    @Test
    void insertFromTail() {
        Node node = new Node("Viktor");
        Node node1 = new Node("Christian");

        list.insertFromTail(node);
        list.insertFromTail(node1);

        assertEquals("Christian", list.tailNode.name);
        assertEquals("Viktor", list.tailNode.previousNode.name);
    }

    @Test
    void printFromHead() {
        list.insertFromHead(new Node("Node1"));
        list.insertFromHead(new Node("Node2"));
        list.insertFromHead(new Node("Node3"));
        list.insertFromHead(new Node("Node4"));
        list.insertFromHead(new Node("Node5"));

        assertEquals("Node5Node4Node3Node2Node1", list.printFromHead());
        System.out.println(list.printFromHead());
    }

    @Test
    void printFromTail() {
        list.insertFromHead(new Node("Node1"));
        list.insertFromHead(new Node("Node2"));
        list.insertFromHead(new Node("Node3"));
        list.insertFromHead(new Node("Node4"));
        list.insertFromHead(new Node("Node5"));

        assertEquals("Node1Node2Node3Node4Node5", list.printFromTail());
        System.out.println(list.printFromTail());
    }

    @Test
    void removeFromHead() {
        assertEquals(null, list.removeFromHead());

        list.insertFromHead(new Node("Node1"));
        assertEquals("Node1", list.removeFromHead().name);

        list.insertFromHead(new Node("Node2"));
        list.insertFromHead(new Node("Node3"));
        list.insertFromHead(new Node("Node4"));
        list.insertFromHead(new Node("Node5"));

        assertEquals("Node5", list.removeFromHead().name);
        System.out.println(list.printFromHead());
    }


    @Test
    void removeFromTail() {
        assertEquals(null, list.removeFromTail());

        list.insertFromHead(new Node("Node1"));
        assertEquals("Node1", list.removeFromTail().name);

        list.insertFromHead(new Node("Node2"));
        list.insertFromHead(new Node("Node3"));
        list.insertFromHead(new Node("Node4"));
        list.insertFromHead(new Node("Node5"));

        assertEquals("Node1", list.removeFromTail().name);
        System.out.println(list.printFromTail());
    }
}