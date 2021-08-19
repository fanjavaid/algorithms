package com.fanjavaid.algorithms.others.stacks;

import java.util.Stack;

public class StackJavaApi {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(10);
        stack.push(14);
        System.out.println(stack);

        int popped = stack.pop();
        System.out.println("Pop = " + popped);
        System.out.println(stack);

        System.out.println("Peek = " + stack.peek());
        System.out.println("Size = " + stack.size());
        System.out.println("Search 20 = " + stack.search(20));
        System.out.println("Is Empty? = " + stack.empty());
    }
}
