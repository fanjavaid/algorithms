package com.fanjavaid.algorithms.groking_algorithms;

import java.util.*;

public class RecursionSum {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 6 };
		System.out.println("Sum of " + Arrays.toString(arr) +" = " + sum(arr));
	}

	public static int sum(int[] nums) {
		// Base case?
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		// Recursive case?
		return nums[0] + sum(Arrays.copyOfRange(nums, 1, nums.length));
	}
}
