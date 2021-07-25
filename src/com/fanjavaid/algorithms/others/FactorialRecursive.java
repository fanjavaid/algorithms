package com.fanjavaid.algorithms.others;

import java.util.HashMap;
import java.util.Map;

public class FactorialRecursive {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(factorial(Integer.valueOf(args[0])));
    }

    private static long factorial(int n) {
        if (n == 1) return 1;

        if (memo.containsKey(n)) return memo.get(n);

        long result = n * factorial(n-1);
        memo.put(n, result);

        return result;
    }
}