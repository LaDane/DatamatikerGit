public class NodeList {

    Node headNode = null;
    Node tailNode = null;


    public Node insertFromHead(Node node) {
        if (isListEmpty(node))
            return headNode;

        headNode.previousNode = node;
        node.nextNode = headNode;
        headNode = node;
        return headNode;
    }

    public Node insertFromTail(Node node) {
        if (isListEmpty(node))
            return tailNode;

        tailNode.nextNode = node;
        node.previousNode = tailNode;
        tailNode = node;
        return node;
    }

    private boolean isListEmpty(Node node) {
        if (headNode == null) {
            headNode = node;
            tailNode = node;
            return true;
        }
        return false;
    }

    public String printFromHead() {
        String result = "";
        Node node = headNode;
        while (node != null) {
            result = result + node.name;
            node = node.nextNode;
        }
        return result;
    }

    public String printFromTail() {
        String result = "";
        Node node = tailNode;
        while (node != null) {
            result = result + node.name;
            node = node.previousNode;
        }
        return result;
    }

    public Node removeFromHead() {
        if (headNode == null)               // empty list
            return null;
        else if (headNode == tailNode)      // list is 1 long
            return headNode;

        Node node = headNode;
        headNode.nextNode.previousNode = null;
        headNode = headNode.nextNode;
        return node;
    }

    public Node removeFromTail() {
        if (headNode == null)               // empty list
            return null;
        else if (headNode == tailNode)      // list is 1 long
            return headNode;

        Node node = tailNode;
        tailNode.previousNode.nextNode = null;
        tailNode = tailNode.previousNode;
        return node;
    }
}
