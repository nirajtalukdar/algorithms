package com.niraj.trees;

public class PreOrderTraversal {

    private class Node {

       private int data;
       private Node leftNode;
       private Node rightNode;
    }

    public void doPreOrderTraversal(Node node) {

        if (node == null) {

            return;
        }
        System.out.print(node.data+" ");
        doPreOrderTraversal(node.leftNode);
        doPreOrderTraversal(node.rightNode);

    }
}
