package com.niraj.trees;

public class InOrderTraversal {

    private class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    public void doInOrderTraversal(Node node) {

        if (node == null) {

            return;
        }
        doInOrderTraversal(node.leftNode);
        System.out.print(node.data);
        doInOrderTraversal(node.rightNode);
    }
}
