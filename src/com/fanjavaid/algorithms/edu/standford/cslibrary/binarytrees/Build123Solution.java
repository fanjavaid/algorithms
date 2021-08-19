package com.fanjavaid.algorithms.edu.standford.cslibrary.binarytrees;

import com.fanjavaid.algorithms.edu.standford.cslibrary.binarytrees.model.Node;

class Build123BinaryTree {
    Node root;

    public Build123BinaryTree() {
        this.root = null;
    }

    private Node insert(Node node, int data) {
        // Base Case
        if (node == null) {
            return new Node(data);
        } else {
            // Recursive Cases
            if (data <= node.data) node.left = insert(node.left, data);
            if (data > node.data) node.right = insert(node.right, data);
            return node;
        }
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    public void build123a() {
        this.root = new Node(2);
        Node leftChild = new Node(1);
        Node rightChild = new Node(3);

        this.root.left = leftChild;
        this.root.right = rightChild;
    }

    public void build123b() {
        this.root = new Node(2);
        this.root.left = new Node(1);
        this.root.right = new Node(3);
    }

    public void build123c() {
        insert(2);
        insert(1);
        insert(3);
    }
}

// http://cslibrary.stanford.edu/110/BinaryTrees.html#java No.1 Question
public class Build123Solution {
    public static void main(String[] args) {
        Build123BinaryTree tree = new Build123BinaryTree();
        tree.build123a();
        System.out.println("build123a = " + tree.root);

        tree = new Build123BinaryTree();
        tree.build123b();
        System.out.println("build123b = " + tree.root);

        tree = new Build123BinaryTree();
        tree.build123c();
        System.out.println("build123c = " + tree.root);
    }
}
