package com.niraj.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a type of breadth first search (BFS) algorithm
 */
public class LevelOrderTraversal {

    class Node {

        private int data;
        private Node leftNode;
        private Node rightNode;
    }

    public void doLevelOrderTraversing(Node node) {

        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {

            node = nodeQueue.peek();

            if (node.leftNode != null) {
                nodeQueue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                nodeQueue.offer(node.rightNode);
            }

            System.out.println(node.data);
            nodeQueue.poll();
        }
    }
}
