package com.fanjavaid.algorithms.others;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        int[] nums = { 39, 40, 26, 32, 46, 310, 39, 31, 23, 10, 43 };
        new RadixSort().sort(nums);
    }

    public int[] sort(int[] numbers) {
        int k = getMaxDigits(numbers);

        for (int j = 0; j < k; j++) {
            ArrayList<Integer>[] buckets = new ArrayList[10];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < numbers.length; i++) {
                int currentDigit = getDigitByPosition(numbers[i], j);
                buckets[currentDigit].add(numbers[i]);
            }

            numbers = new int[numbers.length];
            int index = 0;
            for (int row = 0; row < buckets.length; row++) {
                int col = 0;
                while (col < buckets[row].size()) {
                    numbers[index++] = buckets[row].get(col++);
                }
            }
        }
        System.out.println(Arrays.toString(numbers));

        return numbers;
    }

    public int getDigitByPosition(int number, int position) {
        return (int) Math.floor(Math.abs(number) / Math.pow(10, position)) % 10;
    }

    public int getTotalDigits(int number) {
        if (number == 0) return 1;
        return (int) Math.floor(Math.log10(Math.abs(number))) + 1;
    }

    public int getMaxDigits(int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            max = Math.max(numbers[i], max);
        }
        return getTotalDigits(max);
    }
}

// 267,1
// 10^1 = 10
// 
