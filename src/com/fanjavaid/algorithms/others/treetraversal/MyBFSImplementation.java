package com.fanjavaid.algorithms.others.treetraversal;

import java.util.ArrayList;
import java.util.List;

public class MyBFSImplementation {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(10);
        tree.add(6);
        tree.add(15);
        tree.add(3);
        tree.add(8);
        tree.add(20);

        MyNode node = tree.root;

        List<Integer> data = new ArrayList<>();
        List<MyNode> queue = new ArrayList<>();

        queue.add(node);

        while (queue.size() > 0) {
            node = queue.remove(0);
            data.add(node.value);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        System.out.println(tree);
        System.out.println("BFS = " + data);
    }
}
