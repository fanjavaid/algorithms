package com.fanjavaid.algorithms.others.queues;

import java.util.ArrayList;

class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue<T> enqueue(T value) {
        // Add new node to the first element, should works like unshift operation of linked list
        Node<T> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
        return this;
    }

    public Node<T> peek() {
        return this.head;
    }

    public Node<T> dequeue() {
        if (this.head == null) return null;

        Node<T>removed = this.head;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = removed.next;
        }

        this.size--;

        return removed;
    }

    public int getSize() {
        return size;
    }
}

public class QueueSinglyLinkedList {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("FIRST").enqueue("SECOND");
        q.enqueue("THIRD");

//        System.out.println();
//
        Node<String> polled = q.dequeue();
        System.out.println("Dequeued = " + polled.data);
        System.out.println(q.getSize());
        System.out.println(q.peek().data);

//        System.out.println("Queue Size: " + q.getSize());
//        int num = 1;
//        while (q.getSize() > 0) {
//            Node<String> dequeued = q.dequeue();
//            System.out.println(num + ". " + dequeued.data);
//            num++;
//        }
    }
}

        // John -> null
// p
//           c
