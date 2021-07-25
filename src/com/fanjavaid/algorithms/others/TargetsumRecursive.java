package com.fanjavaid.algorithms.others;

import java.util.*;
public class TargetsumRecursive {
    private static Map<Integer, Boolean> memo = new HashMap<>(); 

    public static void main(String[] args) {
        System.out.println(canSum(10000, new int[]{ 7, 14 }));
        System.out.println(memo);
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;            
            if (canSum(remainder, numbers) == true) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }
}
