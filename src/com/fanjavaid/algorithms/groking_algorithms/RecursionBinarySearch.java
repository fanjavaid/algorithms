package com.fanjavaid.algorithms.groking_algorithms;

public class RecursionBinarySearch {
	public static void main(String[] args) {
		int[] arr = { -1, 10, 18, 75, 99, 1000 };
		int x = -18;
		System.out.println(x+" at index " + binarySearch(arr, x, 0, arr.length-1));
	}
	
	public static int binarySearch(int[] arr, int x, int start, int end) {
		int low = start;
		int high = end;
		int mid = (low+high)/2;

		// Base case when the x is not found
		if (low > high) return -1;

		// Base case when the x is found
		if (arr[mid] == x) {
			return mid;
		} else if (arr[mid] > x) {
			high = mid-1;
		} else {
			low = mid+1;
		}
		
		// Recursive case
		return binarySearch(arr, x, low, high);
	}
}
