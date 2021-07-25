package com.fanjavaid.algorithms.others;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { -100, 89, 3, 90, 8, 0 };
        System.out.println(Arrays.toString(new QuickSort().sort(arr, 0, arr.length - 1)));
    }

    private int pivot(int[] arr, int start, int end) {
        int pivot = start;
        int swapIdx = start;

        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[pivot]) {
                swapIdx++;
                swap(arr, swapIdx, i);
            }
        }

        swap(arr, swapIdx, pivot);
        return swapIdx;
    }

    public int[] sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = pivot(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
