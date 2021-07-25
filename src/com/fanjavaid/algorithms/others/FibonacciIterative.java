package com.fanjavaid.algorithms.others;

public class FibonacciIterative {
    public static void main(String[] args) {
        FibonacciIterative fi = new FibonacciIterative();
        int n = Integer.valueOf(args[0]);

        System.out.println("Fibonacci " + n + " = " + fi.fibIter(n));
    }

    public int fibIter(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int curr = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int temp = curr + next;
            curr = next;
            next = temp;
        }
        return curr;
    }
}

/**
 * temp = 0 + 1 = 1
 * 5
 * [0, 1, 2, 3, 4, 5, 6]
 * [0, 1, 1, 2, ?, ?, ?]
 *     c
 *        n
 * 
 *     result = 0
 */