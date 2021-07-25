package com.fanjavaid.algorithms.others;

import java.util.Arrays;

class Node {
    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public LinkedList push(String value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.length++;
        return this;
    }

    public Node pop() {
        if (this.head == null) return null;

        Node current = this.head;
        Node newTail = current;
        while (current.getNext() != null) {
            newTail = current;
            current = current.getNext();
        }

        this.tail = newTail;
        this.tail.setNext(null);
        this.length--;

        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return current;
    }

    public Node shift() {
        if (this.head == null) return null;

        Node shiftedNode = this.head;
        this.head = this.head.getNext();
        this.length--;

        if (this.length == 0) this.tail = null;

        return shiftedNode;
    }

    public LinkedList unshift(String value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
        this.length++;

        return this;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) return null;

        Node current = this.head;
        int counter = 0;
        while (counter != index) {
            current = current.getNext();
            counter++;
        }
        return current;
    }

    public boolean set(int index, String value) {
        Node node = get(index);

        if (node == null) return false;

        node.setValue(value);
        return true;
    }

    public boolean insert(int index, String value) {
        if (index < 0 || index > this.length) return false;
        if (index == 0) {
            unshift(value);
            return true;
        }
        if (index == length) {
            push(value);
            return true;
        }

        Node node = new Node(value);
        Node previous = get(index - 1);
        Node after = previous.getNext();

        previous.setNext(node);
        node.setNext(after);
        this.length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) return null;
        if (index == this.length - 1) return pop();
        if (index == 0) return shift();

        Node previous = get(index - 1);
        Node deletedNode = previous.getNext();
        previous.setNext(deletedNode.getNext());
        deletedNode.setNext(null);
        this.length--;

        return deletedNode;
    }

    public LinkedList reverse() {
        Node curr = this.head;
        this.head = this.tail;
        this.tail = curr;

        Node next;
        Node prev = null;
        for (int i = 0; i < this.length; i++) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        return this;
    }

    public Node popHead() throws NullPointerException {
        if (this.head == null) throw new NullPointerException("List is Empty!");

        Node temp = this.head;

        this.head = null;
        this.tail = null;

        return temp;
    }

    public void traverse() {
        int i = 0;
        String[] arr = new String[this.length];

        Node current = this.head;
        while (current != null) {
            arr[i++] = current.getValue();
            current = current.getNext();
        }

        System.out.println(Arrays.toString(arr));
    }

    // Getter and Setter
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push("n1");
        list.push("n2");
        list.push("n3");

        list.traverse();

        System.out.println();

        /*
        Node poppedNode = list.pop();
        System.out.println("Pop Node: " + poppedNode.value);

        list.traverse();

        System.out.println("\nPop");
        list.pop();
        list.traverse();

        System.out.println("\nPop");
        list.pop();
        list.traverse();

        System.out.println("\nPop");
        list.pop();
        list.traverse();
        */

        /*
        Node node = list.shift();
        System.out.println("Shift Node: " + node.value);
        list.shift();
        list.shift();
        list.shift();

        list.traverse();

        System.out.println(list.tail.value);
        */
        // list.shift(); throw exception!
        
        /*
        list.pop(); list.pop(); list.pop(); list.pop();
        list.traverse();
        System.out.println();
        list.unshift("NEW HEAD");
        list.traverse();
        */

//        System.out.println(list.get(0).getValue());
//        System.out.println(list.get(1).getValue());
//        System.out.println(list.get(2).getValue());
//        System.out.println(list.get(3).getValue());
//        System.out.println(list.get(4));
//        System.out.println(list.get(-1));

        /*System.out.println("Before update");
        System.out.println(list.get(2).getValue());

        System.out.println("After update");
        list.set(2, "New VALUE");
        System.out.println(list.get(2).getValue());*/

        /*System.out.println("Before:");
        list.traverse();

        System.out.println("\nAfter");
        list.insert(2, "New Node!");
        list.traverse();
        System.out.println("Tail = " + list.getTail().getValue());*/

        /*System.out.println("Before:");
        list.traverse();

        Node removed = list.remove(0);
        System.out.println("\nAfter, deleted node = " + removed.getValue());
        list.traverse();
        System.out.println("Tail = " + list.getTail().getValue() + ", Head = " +
                list.getHead().getValue());*/

        System.out.println("Before:");
        list.traverse();

        System.out.println("\nAfter:");
        list.reverse();
        list.traverse();
        list.push("n4");
        list.traverse();
        list.reverse();
        list.traverse();
    }
}
