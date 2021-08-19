package com.fanjavaid.algorithms.others.stacks;

class StackNode<T> {
    private T value;
    private StackNode<T> next;

    public StackNode(T value) {
        this.value = value;
        this.next = null;
    }

    // region Getter & Setter
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
    // endregion
}

class Stack<T> {
    private StackNode<T> first;
    private int size;

    public Stack<T> push(T value) {
        StackNode<T> node = new StackNode<>(value);
        if (this.first == null) {
            this.first = node;
        } else {
            node.setNext(this.first);
            this.first = node;
        }
        this.size++;
        return this;
    }

    public StackNode<T> pop() {
        if (this.first == null) return null;

        StackNode<T> removed = this.first;
        if (this.size == 1) {
            this.first = null;
        } else {
            this.first = removed.getNext();
            removed.setNext(null);
        }
        this.size--;
        return removed;
    }

    public StackNode<T> peek() {
        return this.first;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    // region Getter & Setter
    public StackNode<T> getFirst() {
        return first;
    }

    public void setFirst(StackNode<T> first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // endregion
}

public class StackLinkedList {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("40").push("20 ABC").push("Rp10");

        System.out.println("Peek = " + stack.peek().getValue());

        StackNode<String> popped = stack.pop();
        System.out.println("\nPop " + popped.getValue());
        System.out.println("Peek " + stack.peek().getValue());
        System.out.println("Is empty? " + stack.isEmpty());

        popped = stack.pop();
        System.out.println("\nPop " + popped.getValue());
        System.out.println("Is empty? " + stack.isEmpty() + ", Size = " + stack.getSize());

        popped = stack.pop();
        System.out.println("\nPop " + popped.getValue());
        System.out.println("Is empty? " + stack.isEmpty() + ", Size = " + stack.getSize());
    }
}
