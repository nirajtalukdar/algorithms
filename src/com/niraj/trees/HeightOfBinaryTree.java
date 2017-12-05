package com.niraj.trees;


/**
 * Height of an empty node(leaf node) is -1. Height of a binary tree is the number of edges
 * in the longest path from the root node to the leaf node. Running time complexity of this
 * algorithm is 0(n)
 */
public class HeightOfBinaryTree {

    class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    public int findHeightOfBinaryTree(Node node) {

        if (node == null) {
            return -1;
        }

        int leftNodeHeight = findHeightOfBinaryTree(node.leftNode);
        int rightNodeHeight = findHeightOfBinaryTree(node.rightNode);

        return Math.max(leftNodeHeight, rightNodeHeight) +1;
    }
}
