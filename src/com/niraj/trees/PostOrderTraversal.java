package com.niraj.trees;

public class PostOrderTraversal {

    private class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    public void doPostOrderTraversal(Node node) {

        if (node == null) {

            return;
        }
        doPostOrderTraversal(node.leftNode);
        doPostOrderTraversal(node.rightNode);
        System.out.print(node.data+" ");
    }
}
