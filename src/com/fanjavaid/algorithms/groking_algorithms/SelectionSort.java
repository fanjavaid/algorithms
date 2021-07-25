package com.fanjavaid.algorithms.groking_algorithms;

import java.util.*;

public class SelectionSort {
	public static void main(String[] args) {
		int[] data  = { 89, -9, 56, 7, 0 };
		System.out.println(Arrays.toString(data));

		int n = data.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (data[j] < data[min]) min = j;
			}

			if (i != min) {
				int temp = data[min];
				data[min] = data[i];
				data[i] = temp;
			}
		}

		System.out.println("Sorted to:");
		System.out.println(Arrays.toString(data));
	}
}
