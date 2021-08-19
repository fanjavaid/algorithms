package com.fanjavaid.algorithms.others.treetraversal;

class MyNode {
    int value;
    MyNode left;
    MyNode right;

    public MyNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class MyBinaryTree {
    MyNode root;

    public MyBinaryTree() {
        this.root = null;
    }

    private MyNode insertRecursive(MyNode current, int value) {
        if (current == null) {
            return new MyNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }

    public MyNode findRecursive(MyNode current, int value) {
        if (current == null) return null;

        if (value == current.value) {
            return current;
        } else if (value < current.value) {
            return findRecursive(current.left, value);
        } else {
            return findRecursive(current.right, value);
        }
    }

    private MyNode deleteRecursive(MyNode current, int value) {
        if (current == null) return null;

        if (value == current.value) {
            // delete this node
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }

        return current;
    }

    private int findSmallestValue(MyNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void add(int value) {
        this.root = insertRecursive(this.root, value);
    }

    public MyNode find(int value) {
        return findRecursive(this.root, value);
    }

    public void delete(int value) {
        this.root = deleteRecursive(this.root, value);
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
                '}';
    }
}

public class MyBinaryTreeImplementation {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(8);
        tree.add(12);
        tree.add(18);
        tree.add(30);
        tree.add(16);
        tree.add(19);

        System.out.println(tree);

        MyNode foundNode = tree.find(8);
        System.out.println((foundNode == null) ? "Not found" : foundNode);

        tree.delete(20);
        System.out.println(tree);
    }
}
