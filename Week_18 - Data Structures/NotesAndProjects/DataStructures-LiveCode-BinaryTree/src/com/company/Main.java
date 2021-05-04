package com.company;

import BinaryTree.BinaryTree;
import BinaryTree.Node;

public class Main {

    public static void main(String[] args)
    {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);

        System.out.println(bt.root.getData());
        System.out.println(bt.root.getLeft().getData());
        System.out.println(bt.root.getRight().getData());
        System.out.println(bt.root.getLeft().getLeft().getData());


        System.out.println("\nAmount of nodes = "+ bt.countNode(bt.root));
        System.out.println("\nSum of nodes = "+ bt.countNodeSum(bt.root));
        System.out.println("\nDFS sort :");
        bt.printNodes(bt.root);
    }
}
