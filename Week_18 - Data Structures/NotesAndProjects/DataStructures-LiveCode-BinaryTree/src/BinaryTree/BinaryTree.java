package BinaryTree;

public class BinaryTree
{
    public Node root;

    public void add(int value)
    {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value)
    {
        if (current == null)
        {
            return new Node(value);
        }

        if (value < current.getData())
        {
            current.setLeft(addRecursive(current.getLeft(), value));
        }
        else if (value > current.getData())
        {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    // count total nodes
    public int countNode(Node root){
        if(root==null)
            return 0;
        return 1 + countNode(root.getLeft()) + countNode(root.getRight());
    }

    // count sum of nodes
    public int countNodeSum(Node root) {
        if (root == null)
            return 0;
        return root.getData() + countNodeSum(root.getLeft()) + countNodeSum(root.getRight());
    }

    public void printNodes(Node root){
        if(root.getLeft() != null){
            printNodes(root.getLeft());
        }
        System.out.println(root.getData());

        if(root.getRight() != null){
            printNodes(root.getRight());
        }
    }

}
