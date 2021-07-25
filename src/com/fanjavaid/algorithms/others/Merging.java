package com.fanjavaid.algorithms.others;

import java.util.Arrays;

public class Merging {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 100, 890 };
        int[] arr2 = { 2, 8 };

        int[] results = new Merging().merge(arr1, arr2);
        System.out.println(Arrays.toString(results));
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] results = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                results[k] = arr1[i];
                i++;
            } else {
                results[k] = arr2[j];
                j++;
            }
            k++;
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
