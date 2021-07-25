package com.fanjavaid.algorithms.groking_algorithms;

import java.util.*;

class Stack {
	int top;
	int[] data;
	int size;

	public Stack(int initialSize) {
		this.top = -1;
		this.data = new int[initialSize];
		this.size = 0;
	}

	public int push(int value) {
		data[++top] = value;
		size++;
		return value;
	}

	public void pop() {
		data[top] = 0;
		top--;
		size--;
	}

	public int peek() {
		return data[top];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top == data.length;
	}

	public String toString() {
		return "{ size = "+this.size+", top = "+this.top+", data = "+Arrays.toString(this.data)+"}";

	}
}

public class StackArray {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		System.out.println(stack +"\n");

		System.out.println("Push data 89, 5, and 100");
		stack.push(89);
		stack.push(5);
		stack.push(100);
		System.out.println(stack +"\n");

		System.out.println("Pop stack");
		stack.pop();
		//stack.pop();
		System.out.println(stack +"\n");

		System.out.println("Peek stack");
		int top = stack.peek();
		System.out.println("Top element is " + top + "\n");

		System.out.println("\nIs Empty = " + stack.isEmpty());
		System.out.println("Is Full = " + stack.isFull());
	}
}
