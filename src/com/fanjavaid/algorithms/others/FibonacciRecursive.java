package com.fanjavaid.algorithms.others;

import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursive {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fib(Integer.valueOf(args[0])));
        System.out.println(memo);
    }

    private static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        long result = fib(n-1) + fib(n-2);
        memo.put(n, result);

        return result;
    }
}