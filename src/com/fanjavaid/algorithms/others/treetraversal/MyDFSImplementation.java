package com.fanjavaid.algorithms.others.treetraversal;

import java.util.ArrayList;
import java.util.List;

public class MyDFSImplementation {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(10);
        tree.add(6);
        tree.add(15);
        tree.add(3);
        tree.add(8);
        tree.add(20);

        MyNode node = tree.root;
        List<Integer> results = new MyDFSImplementation().traverse(node);
        System.out.println(results);
    }

    public List<Integer> traverse(MyNode node) {
        List<Integer> data = new ArrayList<>();
        traverseRecursive(node, data);
        return data;
    }

    private void traverseRecursive(MyNode node, List<Integer> data) {
        data.add(node.value);

        if (node.left != null) {
            traverseRecursive(node.left, data);
        }

        if (node.right != null) {
            traverseRecursive(node.right, data);
        }
    }
}
