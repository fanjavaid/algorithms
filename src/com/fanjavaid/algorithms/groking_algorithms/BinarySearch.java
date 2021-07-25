package com.fanjavaid.algorithms.groking_algorithms;

import java.util.*;

public class BinarySearch {
	public static void main(String[] args) {
		int[] data = { -9, 0, 4, 7, 19, 100 }; // Sorted array
		int foundIndex = search(4, data);

		System.out.println("Searching 4 on " + Arrays.toString(data));
		System.out.println("Found at index " + foundIndex);
	}

	public static int search(int search, int[] sources) {
		int high = sources.length-1;
		int low = 0;

		while (low <= high) {
			int mid = (low+high)/2;

			if (sources[mid] == search) {
				return mid;
			} else if (sources[mid] >  search) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}

		return -1;
	}
}

