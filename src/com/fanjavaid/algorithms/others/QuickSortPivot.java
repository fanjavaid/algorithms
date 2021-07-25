package com.fanjavaid.algorithms.others;

import java.util.Arrays;

public class QuickSortPivot {
    public static void main(String[] args) {
        int[] arr = {19, -90, -1, 5, 87, 6, 100};
        int p = new QuickSortPivot().pivot(arr, 0, arr.length);
        System.out.println("New Pivot = " + p);
        System.out.println(Arrays.toString(arr));
    }    

    /**
     * Pivot function for Quick Sort 
     * when the starting pivot is defined at start index
     * @param arr Initial array
     * @param start Initial start index array
     * @param end Initial end index array
     * @return next Pivot index, will used on recursive call to sort the Array
     */
    public int pivot(int[] arr, int start, int end) {
        int pivot = start;

        // Used to track last position of index which less than off 'pivot'
        // each time found the i-th is less than pivot, increment this
        // And at the end of looping, swap between current pivot with this
        int swapIdx = start;
        
        /**
         * Please remember this position
         * to understand position swapIdx and i
         * 
         * 19, -90, -1, 5, 87, 6, 100
         * p
         *                  i
         *            swapIdx
         * 
         * When i is on 87, it continue increment until stop at 6
         * then because 6 < 19, increment swapIdx
         */
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[pivot]) {
                swapIdx++;
                swap(arr, swapIdx, i);
                System.out.println("Swap between " + swapIdx + " and " + i);
            }
        }

        swap(arr, swapIdx, pivot);

        return swapIdx;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
