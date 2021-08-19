package com.fanjavaid.algorithms.edu.standford.cslibrary.binarytrees;

import com.fanjavaid.algorithms.edu.standford.cslibrary.binarytrees.model.Node;

import java.util.ArrayList;
import java.util.List;

class SizeBinaryTree {
    Node root;

    public SizeBinaryTree() {
        this.root = null;
    }

    private Node insert(Node node, int data) {
        if (node == null) return new Node(data);
        if (data <= node.data) node.left = insert(node.left, data);
        if (data > node.data) node.right = insert(node.right, data);
        return node;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private int size(Node node) {
        if (node == null) return 0;
        int leftSize = size(node.left);
        int righSize = size(node.right);

        return 1 + leftSize + righSize;
    }

    public int size() {
        return size(this.root);
    }

    private void traversePreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        if (node.left != null) traversePreOrder(node.left);
        if (node.right != null) traversePreOrder(node.right);
    }

    public void traversePreOrder() {
        System.out.println("\nPreOrder");
        traversePreOrder(this.root);
    }

    private void traverseInorder(Node node) {
        if (node == null) return;
        if (node.left != null) traverseInorder(node.left);
        System.out.print(node.data + " ");
        if (node.right != null) traverseInorder(node.right);
    }

    public void traverseInOrder() {
        System.out.println("\nInorder");
        traverseInorder(this.root);
    }

    private void traversePostOrder(Node node) {
        if (node == null) return;
        if (node.left != null) traversePostOrder(node.left);
        if (node.right != null) traversePostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    public Node minValue(Node node) {
        if (node.left == null) {
            System.out.println("\nRETURN = " + node.data);
            return node;
        }
        return minValue(node.left);
    }

    private int hasPathSum(Node node, int sum) {
        if (node == null) return 0;

        int total = node.data + hasPathSum(node.left, sum);
        if (total == sum) {
            System.out.println("Found! Left Total = " + total + ", Sum = " + sum);
            return total;
        }

        total = node.data + hasPathSum(node.right, sum);
        if (total == sum) {
            System.out.println("Found! Right Total = " + total + ", Sum = " + sum);
            return total;
        }
        return total;
    }

    private boolean hasPathSumSubstract(Node node, int sum) {
        if (node == null) return (sum == 0);

        int subSum = sum - node.data; // 11 - 5 = 6
        return hasPathSumSubstract(node.left, subSum) || hasPathSumSubstract(node.right, subSum);
    }

    public boolean hasPathSum(int sum) {
//        int total = hasPathSum(this.root, sum);
//        return total == sum;

        return hasPathSumSubstract(this.root, sum);
    }

    /**
            5
        3       6
     *1
     */

    /**
     *
     *
     * minValue(1) -> return 1
     * minValue(2) -> gak bakal return karena node.left ada isinya
     */

    // 5 4 3
    // 5 6

    /**
     Given a binary tree, prints out all of its root-to-leaf
     paths, one per line. Uses a recursive helper to do the work.
     */
    public void printPaths() {
        int[] path = new int[1000];
        printPathsRecur(root, path, 0);
    }
    /**
     Recursive printPaths helper -- given a node, and an array containing
     the path from the root node up to but not including this node,
     prints out all the root-leaf paths.
     */
    private void printPathsRecur(Node node, int[] path, int pathLen) {
        if (node==null) return;

        // append this node to the path array
        path[pathLen] = node.data;
        pathLen++;

        // it's a leaf, so print the path that led to here
        if (node.left==null && node.right==null) {
            printArray(path, pathLen);
        }
        else {
            // otherwise try both subtrees
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    /**
     Utility that prints ints from an array on one line.
     */
    private void printArray(int[] ints, int len) {
        int i;
        for (i=0; i<len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }


    public void mirror(Node node) {
        if (node == null) return;

        if (node.left != null && node.right != null) {
            Node temp = node.right;
            node.right = node.left;
            node.left = temp;

            mirror(node.left);
            mirror(node.right);
        }
    }
}

public class SizeSolution {
    public static void main(String[] args) {
        SizeBinaryTree tree = new SizeBinaryTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(14);
        tree.insert(7);
        tree.insert(9);

        System.out.println(tree.root);
        System.out.println("Size = " + tree.size());

        tree.traverseInOrder();
        tree.traversePreOrder();

        System.out.println("\n" + tree.minValue(tree.root));

        System.out.println();
        tree.traversePostOrder();

        System.out.println();
        System.out.println("Has path sum = " + tree.hasPathSum(11));

        tree.printPaths();

        tree.mirror(tree.root);
        System.out.println(tree.root);
    }
}
