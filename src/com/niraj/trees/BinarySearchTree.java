package com.niraj.trees;

public class BinarySearchTree {

    private int data;
    private BinarySearchTree leftNode;
    private BinarySearchTree rightNode;

    public BinarySearchTree(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinarySearchTree(){

    }

    private BinarySearchTree createNode(int data) {

        return new BinarySearchTree(data);
    }

    private BinarySearchTree insertNode(BinarySearchTree node, int data) {

        if (node == null) {
            node = createNode(data);

        } else if (data <= node.data) {

            node.leftNode = insertNode(node.leftNode, data);
        } else {

            node.rightNode = insertNode(node.rightNode, data);
        }

        return node;
    }

    private boolean isNodeAvailable(BinarySearchTree node, int data) {

        boolean isFound = false;

        if (node == null) {
            isFound =  false;

        } else if (data == node.data) {
            isFound = true;

        } else if (data < node.data) {
            isFound = isNodeAvailable(node.leftNode, data);

        } else {
            isFound = isNodeAvailable(node.rightNode, data);
        }

        return isFound;
    }

    public int findHeightOfBinaryTree(BinarySearchTree node) {

        if (node == null) {
            return -1;
        }

        int leftNodeHeight = findHeightOfBinaryTree(node.leftNode);
        int rightNodeHeight = findHeightOfBinaryTree(node.rightNode);

        return Math.max(leftNodeHeight, rightNodeHeight) +1;
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(15);
        bst.insertNode(bst, 10);
        bst.insertNode(bst, 20);
        bst.insertNode(bst, 12);
        bst.insertNode(bst, 17);
        bst.insertNode(bst, 8);
        bst.insertNode(bst, 25);
        boolean isNodePresent = bst.isNodeAvailable(bst, 20);

        System.out.println("Insertion complete");
        System.out.println("IsNodePresent : "+isNodePresent);
        System.out.println("Height of the binary tree : "+bst.findHeightOfBinaryTree(bst));

    }
}
