package com.fanjavaid.algorithms.others.doublylinkedlist;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public DoublyLinkedList push(String value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
        this.length++;
        return this;
    }

    public Node pop() {
        if (this.head == null) return null;

        Node removed = this.tail;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = removed.getPrev();
            this.tail.setNext(null);
            removed.setPrev(null);
        }

        this.length--;

        return removed;
    }

    public Node shift() {
        if (this.head == null) return null;

        Node removed = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = removed.getNext();
            this.head.setPrev(null);
            removed.setNext(null);
        }
        this.length--;

        return removed;
    }

    public DoublyLinkedList unshift(String value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            Node currentHead = this.head;
            currentHead.setPrev(node);
            node.setNext(currentHead);
            this.head = node;
        }
        this.length++;

        return this;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) return null;

        int middle = this.length / 2;

        Node current = this.head;
        int counter = 0;

        if (index <= middle) {
            // start from head
            while (counter != index) {
                current = current.getNext();
                counter++;
            }
        } else {
            // start from tail
            current = this.tail;
            counter = this.length - 1;
            while (counter != index) {
                current = current.getPrev();
                counter--;
            }
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
        if (index == this.length) {
            push(value);
            return true;
        }

        Node before = get(index - 1);
        Node after = before.getNext();
        Node newNode = new Node(value);

        before.setNext(newNode);
        newNode.setPrev(before);
        newNode.setNext(after);
        after.setPrev(newNode);

        this.length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length) return null;
        if (index == 0) return shift();
        if (index == this.length - 1) return pop();

        Node removed = get(index);
        Node before = removed.getPrev();
        Node after = removed.getNext();

        before.setNext(after);
        after.setPrev(before);

        removed.setNext(null);
        removed.setPrev(null);

        this.length--;

        return removed;
    }

    public DoublyLinkedList reverse() {
        // Swap head & tail
        Node current = this.head;
        this.head = this.tail;
        this.tail = current;

        // Reverse
        Node prev = null;
        Node next;
        for (int i = 0; i < this.length; i++) {
            next = current.getNext();
            current.setNext(prev);

            if (prev != null) prev.setPrev(current);

            prev = current;
            current = next;
        }
        return this;
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = this.head;
        if (current == null) return "(empty)";
        while (current != null) {
            if (current.getNext() != null && current.getNext().getPrev() != null) {
                sb.append(current.getValue())
                        .append(" ")
                        .append("<->")
                        .append(" ");
            } else {
                sb.append(current.getValue())
                        .append(" ")
                        .append("->")
                        .append(" ");

                if (current == this.tail) sb.append("null");
            }
            current = current.getNext();
        }
        sb.append("\nLength: ").append(this.length);

        return sb.toString();
    }

    // region Getter and Setter
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
    // endregion
}
