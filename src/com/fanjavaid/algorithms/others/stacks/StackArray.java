package com.fanjavaid.algorithms.others.stacks;

import java.util.Arrays;

class StackArr<T> {
    private int top;
    private T[] data;
    private int size;

    public StackArr(int capacity, T... dummy) {
        this.top = -1;
        this.data = Arrays.copyOf(dummy, capacity);
        this.size = 0;
    }

    public T peek() {
        return data[top];
    }

    public T pop() {
        if (isEmpty()) return null;

        T popped = data[top];
        data[top--] = null;
        size--;
        return popped;
    }

    public StackArr push(T value) {
        if (!isFull()) {
            data[++top] = value;
            size++;
        }
        return this;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    // region Getter & Setter
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // endregion
}

public class StackArray {
    public static void main(String[] args) {
        StackArr<Integer> stack = new StackArr<>(3);
        stack.push(5).push(10).push(2);
        stack.push(1000); // test to pushed again when stack is already full
        System.out.println(Arrays.toString(stack.getData()));

        System.out.println("Peek = " + stack.peek());

        int popped = stack.pop();
        System.out.println("Pop " + popped);
        System.out.println(Arrays.toString(stack.getData()) + ", Length = " + stack.getSize());

        stack.pop();
        stack.pop();
        stack.pop(); // test to popped again when stack is already empty
        System.out.println("Is Empty? " + stack.isEmpty());
    }
}
