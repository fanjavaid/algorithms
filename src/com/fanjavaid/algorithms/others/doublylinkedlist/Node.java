package com.fanjavaid.algorithms.others.doublylinkedlist;

public class Node {
    private String value;
    private Node next;
    private Node prev;

    public Node(String value) {
        this.value = value;
        this.next = null;
        this.prev = null;
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

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
