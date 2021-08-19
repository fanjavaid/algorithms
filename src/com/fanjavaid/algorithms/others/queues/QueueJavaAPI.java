package com.fanjavaid.algorithms.others.queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueJavaAPI {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.add("Fandi");
        q.add("Akhmad");
        q.add("John");
        q.add("Doe");

        System.out.println(q + ", size = " + q.size());

        String polled = q.poll(); // return null if queue is empty
        System.out.println("Polled = " + polled);

        System.out.println(q);

        System.out.println("Peek = " + q.peek());

        String removed = q.remove(); // throw exception if queue is empty
        System.out.println("Removed = " + removed);

        System.out.println(q);
    }
}
