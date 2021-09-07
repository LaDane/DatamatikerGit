public class NodeList {
    private Node headNode = null;
    private Node tailNode = null;


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

    public Node removeFromHead() {
        if (headNode == null)
            return null;
        else if (headNode == tailNode)
            return headNode;

        Node node = headNode;
        headNode.nextNode.previousNode = null;
        headNode = headNode.nextNode;
        return node;
    }

    public Node removeFromTail() {
        if (tailNode == null)
            return null;
        else if (headNode == tailNode)
            return tailNode;

        Node node = tailNode;
        tailNode.previousNode.nextNode = null;
        tailNode = tailNode.previousNode;
        return node;
    }

    public String printFromHead() {
        String result = "";
        Node currentNode = headNode;
        while (currentNode != null) {
            result = result + currentNode.name;
            currentNode = currentNode.nextNode;
        }
        return result;
    }

    public String printFromTail() {
        String result = "";
        Node currentNode = tailNode;
        while (currentNode != null) {
            result = result + currentNode.name;
            currentNode = currentNode.previousNode;
        }
        return result;
    }
}
