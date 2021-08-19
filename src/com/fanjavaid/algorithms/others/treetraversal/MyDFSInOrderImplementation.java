package com.fanjavaid.algorithms.others.treetraversal;

import java.util.ArrayList;
import java.util.List;

public class MyDFSInOrderImplementation {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(10);
        tree.add(6);
        tree.add(15);
        tree.add(3);
        tree.add(8);
        tree.add(20);

        MyNode root = tree.root;
        System.out.println(new MyDFSInOrderImplementation().traverse(root));
    }

    private List<Integer> traverse(MyNode node) {
        List<Integer> data = new ArrayList<>();
        traverseRecursive(node, data);
        return data;
    }

    private void traverseRecursive(MyNode node, List<Integer> data) {
        if (node.left != null) traverseRecursive(node.left, data);
        data.add(node.value);
        if (node.right != null) traverseRecursive(node.right, data);
    }
}
