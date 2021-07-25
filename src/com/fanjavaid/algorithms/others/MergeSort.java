package com.fanjavaid.algorithms.others;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {98, 0, -1, 67, 8, 4, 2};
        int[] sortedArr = new MergeSort().sort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    public int[] sort(int[] arr) {
        if(arr.length <= 1) return arr;

        int mid = arr.length / 2;

        // Get array index 0 until mid
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));

        // Get array index mid until n
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] results = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                results[k++] = arr1[i++];
            } else {
                results[k++] = arr2[j++];
            }
        }

        while(i < arr1.length) {
            results[k++] = arr1[i++];
        }

        while(j < arr2.length) {
            results[k++] = arr2[j++];
        }

        return results;
    }
}
