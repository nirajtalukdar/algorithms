package com.niraj.trees;


public class VerifyBinarySearchTree {

    private class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    public boolean isBinarySearchTree(Node node, int min_range, int max_range) {

        if (node == null) {

            return true;
        }

        if (node.data <= min_range || node.data > max_range) {

            return false;
        }

        return isBinarySearchTree(node.leftNode, min_range, node.data)
                && isBinarySearchTree(node.rightNode, node.data, max_range);
    }
}
