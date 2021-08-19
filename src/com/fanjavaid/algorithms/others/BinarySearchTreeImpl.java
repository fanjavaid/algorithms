package com.fanjavaid.algorithms.others;

class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(int value) throws IllegalArgumentException {
        TreeNode node = new TreeNode(value);
        if (this.root == null) {
            this.root = node;
            return this;
        }

        TreeNode current = this.root;
        while (true) {
            if (value == current.value) throw new IllegalArgumentException("Node " + value + " is already exists");
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    return this;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                    return this;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public TreeNode find(int value) {
        if (this.root == null) return null;

        TreeNode current = this.root;
        while (current != null) {
            if (value == current.value) return current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}

public class BinarySearchTreeImpl {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(13);
        tree.insert(2);

        System.out.println(tree);

        int value = 2;
        TreeNode foundNode = tree.find(value);
        System.out.println("Searching Node: " + value + " = " + foundNode);
    }
}
