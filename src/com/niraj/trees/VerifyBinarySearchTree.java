package com.niraj.trees;


/**
 * Algorithm to find whether a binary tree is a binary search tree (BST). A BST can have atmost
 * 2 children and whose left child node has a value lesser than its root(parent) node and the
 * right child node has a value larger than its root(parent) node. An empty node is also considered
 * as a BST.
 *
 * The below algorithm has a running time complexity of 0(n)
 */
public class VerifyBinarySearchTree {

    private class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    /**
     * The algorithm compares each node data between its min and max range. A left node always needs
     * to be between the min value and the data value of its root. Whereas, the right node always needs
     * to be between the data value of its root node and the max value.
     *
     */
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
